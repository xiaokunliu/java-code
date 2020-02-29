package com.xiaokunliu.commons.encrypt;


import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5HashUtility {

	public static String computeContentMD5HeaderValue(FileInputStream fis) {
		
		try {
			DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));

			byte[] buffer = new byte[8192];
			while (dis.read(buffer) > 0)
				;

			String md5Content = new String(Base64.encodeBase64(dis.getMessageDigest().digest()));

			// Effectively resets the stream to be beginning of the file
			// via a FileChannel.
			fis.getChannel().position(0);

			return md5Content;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String computeContentMD5HeaderValue(InputStream is) {

		try {
			DigestInputStream dis = new DigestInputStream(is, MessageDigest.getInstance("MD5"));

			byte[] buffer = new byte[8192];
			while (dis.read(buffer) > 0)
				;

			String md5Content = new String(Base64.encodeBase64(dis.getMessageDigest().digest()));

			// Effectively resets the stream to be beginning of the file
			// via a FileChannel.
			//fis.getChannel().position(0);

			return md5Content;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String computeContentMD5Header(InputStream inputStream) {
	    // Consume the stream to compute the MD5 as a side effect.
	    DigestInputStream s;
	    try {
	        s = new DigestInputStream(inputStream, MessageDigest.getInstance("MD5"));
	        // drain the buffer, as the digest is computed as a side-effect
	        byte[] buffer = new byte[8192];
	        while(s.read(buffer) > 0);
	        return new String(
					Base64.encodeBase64(s.getMessageDigest().digest()), StandardCharsets.UTF_8);
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer();
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

}
