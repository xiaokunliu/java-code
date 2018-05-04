package com.dtrees.common.objects.numbers;

import java.math.BigDecimal;

public final class MathUtility {
	
	public static float numberFormat(float input) {
		BigDecimal output = new BigDecimal(input).setScale(2, BigDecimal.ROUND_HALF_UP);
		return output.floatValue();
	}
}
