package com.xunruan.framekork.util;


import java.io.PrintStream;

public class DataTypeConvertUtils
{

	public DataTypeConvertUtils()
	{
	}

	public static String ascii2String(int ascii)
	{
		return (new StringBuilder(String.valueOf((char)ascii))).toString();
	}

	public static int string2Ascii(String string)
	{
		byte byteArr[] = string.getBytes();
		return byteArr[0];
	}

	public static String toHexString(int decimalism)
	{
		return Integer.toHexString(decimalism);
	}

	public static String toOctalString(int decimalism)
	{
		return Integer.toOctalString(decimalism);
	}

	public static String toBinaryString(int decimalism)
	{
		return Integer.toBinaryString(decimalism);
	}

	public static String hex2decimalism(String hexString)
	{
		return Integer.valueOf(hexString, 16).toString();
	}

	public static String octal2decimalism(String octalString)
	{
		return Integer.valueOf(octalString, 8).toString();
	}

	public static String binary2decimalism(String binaryString)
	{
		return Integer.valueOf(binaryString, 2).toString();
	}

	public static void main(String args[])
	{
		System.out.println(Integer.toHexString(33));
		Integer factor = Integer.valueOf(33);
		String s = String.format("%d", new Object[] {
			factor
		});
		System.out.println(s);
		s = String.format("%x", new Object[] {
			factor
		});
		System.out.println(s);
		s = String.format("%o", new Object[] {
			factor
		});
		System.out.println(s);
	}
}
