package com.xiaokunliu.j2ee.email;

import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.util.*;

/**
 * project:java-code
 * file:MailTools
 * package:com.xiaokunliu.j2ee.email
 * date:2019/7/30 5:45 PM
 * author:keithl
 */
public final class MailTools {

    private final static MailTools MAIL_TOOL_INSTANCE = new MailTools();
    private MailTools(){}

    public static MailTools buildMailTools(){
        return MAIL_TOOL_INSTANCE;
    }

    /**
     * transfer to chinese
     * @param textString
     * @return
     */
    public String transferChinese(String textString){
        try {
            return MimeUtility.encodeText(new String(textString.getBytes(), "UTF-8"), "GBK2312", "B");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean sendEmail(final SendEmailObject emailObject){
        // 读取邮件配置，这里省略跳过
        try {
            Properties properties = new Properties();
            properties.put("mail.stmp.host", "192.168.10.235");
            properties.put("mail.stmp.auth", true);

            Session mailSession = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailObject.getSmtpUserName(), emailObject.getSmtpPassword());
                }
            });

            MimeMessage mailMessage = new MimeMessage(mailSession);

            // set from host
            mailMessage.setFrom(new InternetAddress(emailObject.getFrom()));

            // set receiver host
            InternetAddress[] toAddress = {new InternetAddress(emailObject.getTo())};
            /**
             * Message.RecipientType.TO: 普通发送
             * Message.RecipientType.CC: 抄送
             * Message.RecipientType.BCC: 暗抄
             */
            mailMessage.setRecipients(Message.RecipientType.TO, toAddress);

            // set topic
            String subject = this.transferChinese(emailObject.getSubject());
            if (subject == null){
                throw new RuntimeException(String.format("the subject transfer to chinese fail,subject=%s", emailObject.getSubject()));
            }
            mailMessage.setSubject(subject);

            //add content
            Multipart multipart = new MimeMultipart();
            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setText(emailObject.getContent());
            multipart.addBodyPart(contentPart);

            //add attachments
            for (String attachment:emailObject.getAttachments()){
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                FileDataSource fileDataSource = new FileDataSource(attachment);

                mimeBodyPart.setDataHandler(new DataHandler(fileDataSource));
                mimeBodyPart.setFileName(fileDataSource.getName());

                multipart.addBodyPart(mimeBodyPart);
            }

            // clear attachments
            emailObject.getAttachments().clear();
            mailMessage.setContent(multipart);

            // set email date
            mailMessage.setSentDate(new Date());
            //send email
            Transport.send(mailMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<ReceiveEmailObject> getReceiveEmail(ReceiveEmailConfig receiveEmailConfig){
        Store store = null;
        try{

            String account = receiveEmailConfig.getPop3Account();
            Properties properties = new Properties();
            if (isGmail(account)){
                properties.put("mail.pop3.socketFactory.class", ReceiveEmailConfig.POP3_SSL_FACTORY);
            }
            Session session = Session.getDefaultInstance(properties);
            URLName urlName = new URLName("pop3", receiveEmailConfig.getPop3Host(), receiveEmailConfig.getPop3Port(), "",
                    receiveEmailConfig.getPop3Account(), receiveEmailConfig.getPop3Password());
            store = session.getStore(urlName);
            store.connect();


            // get receive email messages
            Message[] messages = getEmailMessages(store);
            List<ReceiveEmailObject> receiveEmailObjectList = new ArrayList<>();
            if (messages != null && messages.length > 0){
                for (Message message:messages){
                    ReceiveEmailObject receiveEmailObject = messageToReceiveObject(message);
                    receiveEmailObjectList.add(receiveEmailObject);
                }
            }
            return receiveEmailObjectList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (store != null){
                try {
                    store.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    private boolean isGmail(String accountEmail){
        if (StringUtils.isNotBlank(accountEmail) && accountEmail.lastIndexOf("@gmail.com") != -1){
            return true;
        }
        return false;
    }

    private Message[] getEmailMessages(Store store) throws Exception{
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        return inbox.getMessages();
    }

    private ReceiveEmailObject messageToReceiveObject(Message message){
        try{
            ReceiveEmailObject receiveEmailObject = new ReceiveEmailObject();

            Date receivedDate = getReceivedDate(message);
            receiveEmailObject.setReceivedDate(receivedDate);

            List<String> ccAddress = getCCAddresses(message);
            receiveEmailObject.setCcAddress(ccAddress);

            List<String> receivers = getAllRecipients(message);
            receiveEmailObject.setReceivers(receivers);

            boolean hasRead = hasRead(message);
            receiveEmailObject.setHasRead(hasRead);

            String sender = getSender(message);
            receiveEmailObject.setSender(sender);

            List<File> attachments = getAttachments(message);
            receiveEmailObject.setAttachmentList(attachments);

            String content = getContent(message);
            receiveEmailObject.setContent(content);
            return receiveEmailObject;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getContent(Part part, StringBuffer result) throws Exception {
        if (part.isMimeType("multipart/*")){
            Multipart multipart = (Multipart)part.getContent();
            int count = multipart.getCount();

            // the first part is text/plain
            if (count > 1){
                count = 1;
            }

            for (int i=0; i < count; i++){
                BodyPart bodyPart = multipart.getBodyPart(i);
                getContent(bodyPart, result);
            }
            // the second part is text/html,ignore
        }else if (part.isMimeType("text/*")){
            result.append(part.getContent());
        }
        return result.toString();
    }

    private String getContent(Message message) throws Exception{
        StringBuffer text = new StringBuffer();
        return getContent(message, text);
    }

    private List<File> getAttachments(Message message){
        List<File> files = new ArrayList<>();
        try{
            if (message.isMimeType("multipart/mixed")){
                Multipart multipart = (Multipart) message.getContent();
                for (int i=0,len=multipart.getCount(); i<len; i++){
                    Part part = multipart.getBodyPart(i);
                    String serverFileName = MimeUtility.decodeText(part.getFileName());
                    String fileName = UUID.randomUUID().toString();
                    File file = new File(fileName + getFileSuffix(serverFileName));

                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    InputStream inputStream = part.getInputStream();
                    BufferedOutputStream out = new BufferedOutputStream(fileOutputStream);

                    byte[] buff = new byte[1024];
                    int index = 0;
                    while ((index = inputStream.read(buff)) >0 ){
                        out.write(buff, 0, index);
                    }
                    out.close();
                    inputStream.close();
                    fileOutputStream.close();

                    files.add(file);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }

    private String getFileSuffix(String fileName){
        if (StringUtils.isNotBlank(fileName) && fileName.lastIndexOf(".") != -1){
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    private String getSender(Message message) throws Exception{
        Address[] addresses = message.getFrom();
        return MimeUtility.decodeText(addresses[0].toString());
    }

    private boolean hasRead(Message message) throws Exception{
        return message.getFlags().contains(Flags.Flag.SEEN);
    }

    private Date getReceivedDate(Message message) throws Exception{
        if (message.getSentDate() != null){
            return message.getSentDate();
        }
        if (message.getReceivedDate() != null){
            return message.getReceivedDate();
        }
        return new Date();
    }

    private List<String> getCCAddresses(Message message) throws Exception{
        Address[] addresses = message.getRecipients(Message.RecipientType.CC);
        return getAddresses(addresses);
    }

    private List<String> getAllRecipients(Message message) throws Exception{
        Address[] addresses = message.getAllRecipients();
        return getAddresses(addresses);
    }

    private List<String> getAddresses(Address[] addresses){
        List<String> addressList = new ArrayList<>();
        if (addresses != null){
            for (Address address:addresses){
                addressList.add(address.toString());
            }
        }
        return addressList;
    }
}
