package com.xunruan.framekork.util;


import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.hnatourism.framework.utils:
//			StringUtils, ValidateRegexUtils

public class ValidateUtils
{

	public ValidateUtils()
	{
	}

	public static boolean validate(String validateData, String validateRegex)
	{
		boolean validateResult = false;
		if (StringUtils.isEmpty(validateData) || StringUtils.isEmpty(validateRegex))
		{
			return validateResult;
		} else
		{
			Pattern regex = Pattern.compile(validateRegex);
			Matcher matcher = regex.matcher(validateData);
			validateResult = matcher.matches();
			return validateResult;
		}
	}
}

