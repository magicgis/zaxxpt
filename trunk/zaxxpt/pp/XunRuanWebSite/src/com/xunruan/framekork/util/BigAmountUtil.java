package com.xunruan.framekork.util;



import java.math.BigDecimal;
import java.util.List;

/**
 * * @author wenz
 * @verision 1.0
 * 2012-02-13
 */
public class BigAmountUtil {
	private static final BigDecimal MAXIMUM_NUMBER = new BigDecimal(
			"999999999999.99");
	// 大写中文数组
	private static final String[] digits = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	private static final String[] radices = new String[] { "", "拾", "佰", "仟" };
	private static final String[] bigRadices = new String[] { "", "万", "亿" };
	private static final String[] decimals = new String[] { "角", "分", "" };

	// 将金额数字转换成大写形式 val1（源值）, val2（目标值）
	public static String getBigAmount(String s) {

		if (StringUtil.isEmpty(s)) {
			return "";
		}
		if (!s.matches("^\\d{0,13}(\\.)?\\d*$")) {
			return "不合法的数字格式!";
		}
		s = s.replaceAll("\\,", ""); // 去除金额分隔符

		BigDecimal bd = new BigDecimal(s);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		s = bd.toString();
		int index = s.indexOf(".");
		String integral = (index == -1) ? s : s.substring(0, index);
		integral = integral.replaceAll("^0+", ""); // 去除开头的0
		String decimal = (index == -1) ? "" : s.substring(index + 1, s.length());
		if (decimal.equals("0") || decimal.equals("00")) decimal = "";

		String outputCharacters = "";
		// 处理金额整数部分
		if (integral.length() > 0) {
			int zeroCount = 0;
			for (int i = 0; i < integral.length(); i++) {
				int p = integral.length() - i - 1;
				char ch = integral.charAt(i);
				int quotient = p / 4;
				int modulus = p % 4;
				if (ch == '0') {
					zeroCount++;
				} else {
					if (zeroCount > 0) {
						outputCharacters += digits[0];
					}
					zeroCount = 0;
					outputCharacters += digits[ch - '0'] + radices[modulus];
				}
				if (modulus == 0 && zeroCount < 4) {
					outputCharacters += bigRadices[quotient];
				}
			}
			outputCharacters += "元";
		}
		// 处理金额小数部分, 只支持两位小数
		if (decimal.length() > 0) {
			for (int i = 0; i < decimal.length(); i++) {
				int d = decimal.charAt(i);
				if (d != '0') {
					outputCharacters += digits[d - '0'] + decimals[i];
				}
				if (d == '0'  && (StringUtil.isNotEmpty(integral) && i == 0)) {
					outputCharacters += digits[d - '0'];
				}
			}
		}

		if (outputCharacters == "") {
			outputCharacters = "零" + "元";
		}
		// 添加整字
		if (StringUtil.isEmpty(decimal)) {
			outputCharacters += "整";
		}
		return outputCharacters;
	}
}