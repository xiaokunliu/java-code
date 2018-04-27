package com.dtrees.common.mail;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public final class MailUtility {
	
	/**
	 * Title: sendMailWithAttachment
	 * Description: 		send mail with attachment
	 * @param msgText		email context
	 * @param subject		email subject
	 * @param recipients	email recipients
	 * @param files			the file object 
	 */
	public static void sendMailWithAttachment(String msgText, String subject, List<String> recipients,List<File> files){
		String from = "it@crazysales.com.au";
		String username = "it@crazysales.com.au";
		String password = "C37=7SnY";
		
		// Create properties, get Session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		//proxy host
		props.setProperty("mail.smtp.host", "203.90.236.121");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		
		
		MailAuth auth = new MailAuth(username, password);
		Session session = Session.getDefaultInstance(props, auth);
		try {
			if (recipients.size() == 0) {
				throw new RuntimeException("no mail address was found.");
			}
			
			//create Message 
			Message message = new MimeMessage(session);
			
			//set the subject of the email
			message.setSubject(subject);
			
			//set from address
			message.setFrom(new InternetAddress(from));
			
            //set to address
            InternetAddress[] addressTo = new InternetAddress[recipients.size()];
            for (int i = 0; i < recipients.size(); i++) {
				addressTo[i] = new InternetAddress(recipients.get(i));
			}
            message.setRecipients(Message.RecipientType.TO, addressTo);
            
			//set email context 
			BodyPart messageBodyPart = new MimeBodyPart();  
            messageBodyPart.setContent(msgText,  "text/html;charset=utf-8");  
            
            //add attachments
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart); 
            
            for(File file:files){
            	MimeBodyPart mimeBodyPart = new MimeBodyPart(); 
            	mimeBodyPart.attachFile(file);
            	
            	String contentId = UUID.randomUUID().toString().replace("-", "");
            	mimeBodyPart.setContentID(contentId);
            	mimeBodyPart.setFileName(file.getName());
            	
            	multipart.addBodyPart(mimeBodyPart);
            }
            
            //save chanages
            message.saveChanges();
            
            //add to email 
            message.setContent(multipart);
			
			// Send the message
			Transport.send(message);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void sendMail(String msgText, String subject, String recipient) {
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add(recipient);
	}
	
	
//	public static void sendMail(String msgText, String subject, ArrayList<String> recipients) {
//
//		String from = "it@crazysales.com.au";
//		String username = "it@crazysales.com.au";
//		String password = "C37=7SnY";
//
//		// Create properties, get Session
//		Properties props = new Properties();
//		props.setProperty("mail.transport.protocol", "smtp");
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.port", "465");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.socketFactory.fallback", "false");
//		props.setProperty("mail.smtp.quitwait", "false");
//
//		MailAuth auth = new MailAuth(username, password);
//		Session session = Session.getDefaultInstance(props, auth);
//		try {
//			if (recipients.size() == 0) {
//				throw new RuntimeException("no mail address was found.");
//			}
//
//			// Instantiate a message
//			Message msg = new MimeMessage(session);
//			InternetAddress[] addressTo = new InternetAddress[recipients.size()];
//
//			// Set message attributes
//			msg.setFrom(new InternetAddress(from));
//
//			for (int i = 0; i < recipients.size(); i++) {
//				addressTo[i] = new InternetAddress(recipients.get(i));
//			}
//
//			msg.setRecipients(Message.RecipientType.TO, addressTo);
//
//			msg.setSubject(subject);
//			msg.setSentDate(new Date());
//
//			// Set message content
//			msg.setContent(msgText, "text/html");
//
//			// Send the message
//			Transport.send(msg);
//
//		} catch (Exception ex) {
//			throw new RuntimeException(ex.getMessage());
//		}
//	}
//
//	public static ArrayList<String> getRecipients(String csvPath) {
//		ArrayList<String> recipients = new ArrayList<String>();
//
//		FileReader fr = null;
//		BufferedReader in = null;
//
//		try {
//			File file = new File(csvPath);
//			String regex = ",";
//
//			if (!file.exists()) {
//				throw new RuntimeException("mail list cannot be found.");
//			}
//
//			fr = new FileReader(file);
//			in = new BufferedReader(fr);
//			String aline;
//
//			aline = in.readLine();
//
//			String mailAddr = "";
//
//			while ((aline = in.readLine()) != null) {
//				String itemInfo[] = aline.split(regex);
//
//				mailAddr = itemInfo[0].trim();
//				if (!mailAddr.isEmpty()) {
//					String[] mails = mailAddr.split(";");
//					for (String mail : mails) {
//						if (!mail.trim().isEmpty()) {
//							Pattern rfc2822 = Pattern
//									.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
//							if (!rfc2822.matcher(mail.toLowerCase()).matches()) {
//								System.out.println("Invalid address: "
//										+ mail);
//							} else {
//								recipients.add(mail);
//							}
//						}
//					}
//				}
//			}
//
//		} catch (Exception ex) {
//			logger.error(ex.getMessage());
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					logger.error(e.getMessage());
//				}
//			}
//			if (fr != null) {
//				try {
//					fr.close();
//				} catch (IOException e) {
//					logger.error(e.getMessage());
//				}
//			}
//		}
//
//		return recipients;
//	}
//
//	public static ArrayList<String> getRecipientsBySupplier(String csvPath, String supplierID) {
//		ArrayList<String> recipients = new ArrayList<String>();
//
//		FileReader fr = null;
//		BufferedReader in = null;
//		String regex = ",";
//
//		try {
//			File file = new File(csvPath);
//			if (!file.exists()) {
//				logger.fatal("mail list cannot be found.");
//				return recipients;
//			}
//
//			fr = new FileReader(file);
//			in = new BufferedReader(fr);
//			String aline;
//
//			aline = in.readLine();
//
//			String supplier = "";
//			String mailAddr = "";
//
//			while ((aline = in.readLine()) != null) {
//				String itemInfo[] = aline.split(regex);
//				int size = itemInfo.length;
//
//				if (size > 1) {
//					supplier = itemInfo[0].trim();
//
//					if ((!supplier.isEmpty()) && supplier.equals(supplierID)) {
//
//						mailAddr = itemInfo[1].trim();
//
//						if (!mailAddr.isEmpty()) {
//							String[] mails = mailAddr.split(";");
//							for (String mail : mails) {
//								if (!mail.trim().isEmpty()) {
//									Pattern rfc2822 = Pattern
//											.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
//									if (!rfc2822.matcher(mail.toLowerCase()).matches()) {
//										logger.error("Invalid address: " + mail);
//									} else {
//										recipients.add(mail);
//									}
//								}
//							}
//						}
//
//						break;
//					} else {
//						supplier = "";
//					}
//				}
//			}
//
//		} catch (Exception ex) {
//			logger.error(ex.getMessage());
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					logger.error(e.getMessage());
//				}
//			}
//			if (fr != null) {
//				try {
//					fr.close();
//				} catch (IOException e) {
//					logger.error(e.getMessage());
//				}
//			}
//		}
//		return recipients;
//	}

}
