package com.xunruan.framekork.util;


import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.rmi.server.UID;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.hnatourism.framework.utils:
//			DataTypeConvertUtils, StringUtils, DateFormatUtils

public class RandomUtils extends org.apache.commons.lang.math.RandomUtils
{

	public static Random rand = new Random();
	public static final AtomicLong sequenceNumber = new AtomicLong(0L);

	public RandomUtils()
	{
	}

	public static synchronized String getUID()
	{
		String uid = (new UID()).toString();
		uid = uid.replaceAll(":", "");
		return uid;
	}

	public static synchronized String getUUID()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	public static String getRandomLowerChar(Random rand)
	{
		int tempInt = rand.nextInt(26) + 97;
		String firstWord = String.valueOf((char)tempInt);
		return firstWord;
	}

	public static boolean isLowerChar(int ascii)
	{
		boolean isLowerChar = false;
		if (ascii >= 97 && ascii <= 122)
			isLowerChar = true;
		return isLowerChar;
	}

	public static String getRandomLowerChar(Random rand, String endChar)
	{
		return getRandomLowerChar(rand, endChar, true);
	}

	public static String getRandomLowerChar(Random rand, String charStr, boolean isEnd)
	{
		int ascii = DataTypeConvertUtils.string2Ascii(charStr);
		String firstWord = null;
		if (isEnd)
			firstWord = getRandomLowerChar(rand, 97, ascii);
		else
			firstWord = getRandomLowerChar(rand, ascii, 123);
		return firstWord;
	}

	public static String getRandomLowerChar(Random rand, String startChar, String endChar)
	{
		int start = DataTypeConvertUtils.string2Ascii(startChar);
		int end = DataTypeConvertUtils.string2Ascii(endChar);
		return getRandomLowerChar(rand, start, end);
	}

	public static String getRandomLowerChar(Random rand, int start, int end)
	{
		String firstWord = null;
		if (isLowerChar(start) && isLowerChar(end))
		{
			int tempInt = rand.nextInt((end - start) + 1) + start;
			firstWord = String.valueOf((char)tempInt);
		}
		return firstWord;
	}

	public static String getRandomUpperChar(Random rand)
	{
		int tempInt = rand.nextInt(26) + 65;
		String firstWord = String.valueOf((char)tempInt);
		return firstWord;
	}

	public static String getRandomChar(Random rand)
	{
		String firstWord = null;
		switch (rand.nextInt(2))
		{
		case 0: // '\0'
			firstWord = getRandomLowerChar(rand);
			break;

		default:
			firstWord = getRandomUpperChar(rand);
			break;
		}
		return firstWord;
	}

	public static String getRandomNumStr(Random rand)
	{
		return (new StringBuilder(String.valueOf(getRandomNumStr(rand, 10, true)))).toString();
	}

	public static int getRandomNum(Random rand, int num)
	{
		int tempInt = rand.nextInt(num);
		return tempInt;
	}

	public static int getRandomNum(Random rand, int num, boolean isEnd)
	{
		int tempInt = 0;
		if (isEnd)
		{
			tempInt = getRandomNum(rand, num);
		} else
		{
			num = DataTypeConvertUtils.string2Ascii((new StringBuilder(String.valueOf(num))).toString());
			tempInt = getRandomNum(rand, (57 - num) + 1) + 48;
		}
		return tempInt;
	}

	public static String getRandomNumStr(Random rand, int num, boolean isEnd)
	{
		return (new StringBuilder(String.valueOf(getRandomNum(rand, num, isEnd)))).toString();
	}

	public static Character getRandomNumWithChar(char key)
	{
		int tempval = 0;
		switch (key)
		{
		case 48: // '0'
			tempval = (int)(97F + rand.nextFloat() * 25F);
			break;

		case 49: // '1'
			tempval = (int)(65F + rand.nextFloat() * 25F);
			break;

		default:
			tempval = (int)(48F + rand.nextFloat() * 9F);
			break;
		}
		return new Character((char)tempval);
	}

	public static String getRandomNumWithChar(int length)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++)
		{
			int randomSelect = (int)(rand.nextFloat() * 100F) % 3;
			buffer.append(getRandomNumWithChar((char)randomSelect));
		}

		return buffer.toString();
	}

	public static String getRandomNumWithChar(Random rand)
	{
		String firstWord = null;
		switch (rand.nextInt(2))
		{
		case 0: // '\0'
			firstWord = getRandomNumStr(rand);
			break;

		default:
			firstWord = getRandomLowerChar(rand);
			break;
		}
		return firstWord;
	}

	public static String getRandomNumWithChar(Random rand, int seq, String charStr, boolean isEnd)
	{
		String firstWord = null;
		switch (rand.nextInt(2))
		{
		case 0: // '\0'
			firstWord = getRandomNumStr(rand, seq, isEnd);
			System.out.println((new StringBuilder("=====��0=====")).append(firstWord).toString());
			break;

		default:
			firstWord = getRandomLowerChar(rand, charStr);
			System.out.println((new StringBuilder("=====��1=====")).append(firstWord).toString());
			break;
		}
		return firstWord;
	}

	public static String getRandomChinese(Random rand, String array[])
	{
		String firstWord = null;
		String strH = getRandomLowerChar(rand, "b", "d");
		String strL = getRandomLowerChar(rand, "a", "f");
		System.out.println((new StringBuilder("=====1=====")).append(strH).toString());
		System.out.println((new StringBuilder("=====1=====")).append(strL).toString());
		if ("d".equals(strH))
			strH = (new StringBuilder(String.valueOf(strH))).append(getRandomNum(rand, 7)).toString();
		else
			strH = (new StringBuilder(String.valueOf(strH))).append(getRandomNumWithChar(rand, 10, "f", true)).toString();
		if ("a".equals(strL))
			strL = (new StringBuilder(String.valueOf(strL))).append(getRandomNumWithChar(rand, 1, "f", true)).toString();
		else
		if ("f".equals(strL))
			strL = (new StringBuilder(String.valueOf(strL))).append(getRandomNumWithChar(rand, 10, "e", true)).toString();
		else
			strL = (new StringBuilder(String.valueOf(strL))).append(getRandomNumWithChar(rand, 10, "f", true)).toString();
		System.out.println((new StringBuilder("====2======")).append(strH).toString());
		System.out.println((new StringBuilder("======2====")).append(strL).toString());
		byte bytes[] = new byte[2];
		bytes[0] = (byte)Integer.parseInt(strH, 16);
		bytes[1] = (byte)Integer.parseInt(strL, 16);
		try
		{
			firstWord = new String(bytes, "GBK");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return firstWord;
	}

	public static String getRandomTimestamp(String dateFormat, int RandomLen)
	{
		String dateTime = null;
		if (StringUtils.isEmpty(dateFormat))
			dateFormat = "yyMMddHHmmssSSS";
		dateTime = DateFormatUtils.format(new Date(), dateFormat);
		StringBuffer result = new StringBuffer();
		result.append(dateTime);
		for (int i = 0; i < RandomLen; i++)
			result.append(rand.nextInt(10));

		return result.toString();
	}

	public static long getAtomicLong()
	{
		return sequenceNumber.incrementAndGet();
	}

	public static String getText()
	{
		int length = 4;
		String finalWord = "";
		String firstWord = "";
		int tempInt = 0;
		String array[] = {
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
			"k", "l", "m", "o", "p", "q", "r", "s", "t", "u", 
			"v", "w", "x", "y", "z"
		};
		for (int i = 0; i < length; i++)
		{
			switch (rand.nextInt(3))
			{
			case 1: // '\001'
				tempInt = rand.nextInt(26) + 65;
				firstWord = String.valueOf((char)tempInt);
				break;

			case 2: // '\002'
				firstWord = getRandomChinese(rand, array);
				break;

			default:
				tempInt = rand.nextInt(10) + 48;
				firstWord = String.valueOf((char)tempInt);
				break;
			}
			finalWord = (new StringBuilder(String.valueOf(finalWord))).append(firstWord).toString();
		}

		return finalWord;
	}

	public static int getRandomNum(int randomNum[], int probability[])
	{
		if (randomNum.length != probability.length)
			return 0x80000000;
		Random ran = new Random();
		int ran_num = ran.nextInt(100);
		int temp = 0;
		for (int i = 0; i < randomNum.length; i++)
		{
			temp += probability[i];
			if (ran_num < temp)
				return randomNum[i];
		}

		return 0x80000000;
	}

	public static void main(String args[])
	{
		Random rand = new Random();
		System.out.println(getAtomicLong());
		for (int i = 0; i < 100; i++)
			System.out.println(getRandomNum(new int[] {
				5, 10, 20, 50
			}, new int[] {
				95, 3, 1, 1
			}));

	}

}
