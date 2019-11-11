package com.xiaokunliu.commons.string;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtility {


	/**
	 * @param siteUrl
	 *            http://siteUrl/products_pictures/964/96413_7_extra.jpg or
	 *            http:
	 *            //siteUrl/ebaypage/products_pictures/964/96413_7_extra.jpg or
	 *            http
	 *            ://siteUrl/ebaypage/products_pictures/964/13/96413_7_extra.jpg
	 * @return 964/96413_7_extra.jpg or 964/13/96413_7_extra.jpg
	 */
	public static String getRelativePath(String siteUrl) {
		if (StringUtils.isNotBlank(siteUrl) && siteUrl.contains("products_pictures")) {
			int index = siteUrl.lastIndexOf("products_pictures/") + "products_pictures".length();
            String path = siteUrl.substring(index + 1);
			return path;
		}
		return siteUrl;
	}

	/**
	 * @param filePath
	 *            964/13_96413_7_extra.jpg or 964/13/96413_7_extra.jpg
	 * @return 96413_7_extra
	 */
	public static String getImageFileName(String filePath) {
		if (!StringUtils.isBlank(filePath)) {
			int index = filePath.lastIndexOf("/");
            String fileName = filePath.substring(index + 1);
			return fileName;
		}
		return "";
	}

	/**
	 * @param filePath
	 *            960/96017_502439_F.jpg
	 * @return 960/13/96017_502439_F.jpg,13 is tokenId
	 */
	public static String buildFilePathForTokenId(String filePath, int tokenId) {
		if (StringUtils.isBlank(filePath)) {
			return null;
		}
		String[] strArr = filePath.split("\\/");
		String fileDir = strArr[0];
		String fileName = strArr[1];
		return fileDir + "/" + tokenId + "/" + fileName;
	}

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		dest = dest.replace(" ", "");
		return dest;
	}

	public static String removeTroublesomeCharacters(String inString) {
		if (inString == null){
			return null;
		}

		StringBuffer newString = new StringBuffer();
		char ch;
		for (int i = 0; i < inString.length(); i++) {
			ch = inString.charAt(i);
			// remove any characters outside the valid UTF-8 range as well as
			// all control characters
			// except tabs and new lines
			/*
			 * || ch == '\t' || ch == '\n' || ch
			 * == '\r'
			 */
			if ((ch < 0x00FD && ch > 0x001F) ) {
				newString.append(ch);
			}
		}
		return newString.toString();
	}

	public static String objectToString(Object object){
		if(object == null){
			return null;
		}
		return object.toString();
	}

	public static String filterUSShippingCarrierUsed(String currierName){
		String regularRex = "[A-Za-z0-9-]{1,}";
		Pattern pattern = Pattern.compile(regularRex);
		Matcher matcher = pattern.matcher(currierName);
		if(!matcher.matches()){
			String filterRegex = "[\\t\\/\\(\\)@#$%%^&*!_+=~]{1,}";
			return currierName.replaceAll(filterRegex,"-");
		}
		return currierName;
	}
}
