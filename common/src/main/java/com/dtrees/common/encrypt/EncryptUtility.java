package com.dtrees.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by keithl on 2017/10/11.
 */

public final class EncryptUtility {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(text.getBytes("utf-8"));
        return toHex(bytes);
    }

    public static String sha1(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(str.getBytes());
        return getFormattedText(messageDigest.digest());
    }

    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String getHashStringWithMd5(String raw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytesOfMessage = raw.getBytes("UTF-8");
        byte[] digest = md.digest(bytesOfMessage);
        String hashed = String.format("%032x", new BigInteger(1, digest));
        return hashed;
    }

    public static String genSessionID() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return md5(uuid);
    }
}
