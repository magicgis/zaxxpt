package com.hnatourism.club.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:拼写处理 汉字转化为拼音
 * 
 * 历史版本:
 *					2010-07-21 v1.0.0 (hna) 创建:
 * 
 */
public class SpellUtils {
	/**   
	* 汉字转换为汉语拼音首字母，英文字符不变   
	* @param chines 汉字   
	* @return 拼音 
	*/
	public static String converterToFirstSpell(String chines) {
		String pinyinName = "";

		// 转化为字符
		char[] nameChar = chines.toCharArray();

		// 汉语拼音格式输出类
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();

		// 输出设置,大小写,音标方式等
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		for (int i = 0; i < nameChar.length; i++) {
			// 如果是中文
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(
							nameChar[i], defaultFormat)[0].charAt(0);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {// 为英文字符
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}

	/**   
	 * 汉字转换位汉语拼音，英文字符不变   
	 * @param chines 汉字   
	 * @return 拼音   
	 */
	public static String converterToSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(
							nameChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}

	/**   
	 * 汉字转换位汉语拼音，英文字符不变，首字母大写
	 * @param chines 汉字   
	 * @return 拼音   
	 */
	public static String CaptureSpell(String chines) {
		if (null == chines)
			return "";
		// 汉字转拼音
		String pinyinName = converterToSpell(chines);

		// 首字母大写
		String CaptureSpell = pinyinName.substring(0, 1).toUpperCase()
				+ pinyinName.substring(1);
		return CaptureSpell;
	}

	public static void main(String[] args) {
		System.out.println(converterToFirstSpell("wpde我的欢迎光临我的博客")); // 欢迎来到最棒的Java中文社区
		System.out.println(converterToSpell("wode 我的欢迎光临我的博客")); // 欢迎来到最棒的Java中文社区
	}
}
