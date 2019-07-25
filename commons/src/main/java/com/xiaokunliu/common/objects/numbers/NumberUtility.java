package com.xiaokunliu.common.objects.numbers;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public final class NumberUtility {
	
	public static float numberFormat(float input) {
		BigDecimal output = new BigDecimal(input).setScale(2, BigDecimal.ROUND_HALF_UP);
		return output.floatValue();
	}
	
	public static int toInt(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString()))
			return -1;
		
		String str = obj.toString();
		try {
			return Integer.parseInt(str);
		} catch (Exception e){}
		return -1;
	}
	
	public static Integer toInteger(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString()))
			return null;
		
		String str = obj.toString();
		try {
			return Integer.parseInt(str);
		} catch (Exception e){}
		return null;
	}
	
	public static Double toDouble(Object obj) {
		if (obj == null)
			return null;
		
		String str = obj.toString();
		try {
			return Double.parseDouble(str);
		} catch (Exception e){}
		return null;
	}
	
	public static float toFLoat(Object obj) {

		if (obj == null)
			return 0f;
		
		String str = obj.toString();
		try {
			return Float.parseFloat(str);
		} catch (Exception e){}
		return 0f;
	}
	
	public static long toLong(Object obj) {

		if (obj == null)
			return 0L;
		
		String str = obj.toString();
		try {
			return Long.parseLong(str);
		} catch (Exception e){}
		return 0L;
	}

	//set float to int,like 9.99 => 9,9.12 =>9
	public static int floatToInt(float floatNumber){
		floatNumber = (float) Math.floor(floatNumber); //set 9.99 => 9.00,9.12 =>9.00
		return Math.round(floatNumber);
	}
}
