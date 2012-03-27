/* * 
 * Copyright © 2008 HNA Co. Ltd. 
 * All right reserved. 
 */

package com.hnatourism.framework.web.filter;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;

import com.hnatourism.framework.utils.StringUtils;

/**
 * 
 * <h3>SqlQueryFilter</h3>
 * <h4>过滤sql中非法字符</h4>
 *
 * <h4>Special Notes</h4>
 * 
 *
 * @ver 0.1
 * @author zhangyun
 * 2009-7-6
 *
 */
public final class SqlQueryFilter{


	/**
	 * 处理需要过滤的参数值
	 * @param val
	 * @return
	 * @author zhangyun
	 */
	public static String dealParamVal(String val){
		//"script","and", "exec", "count", "chr", "mid", "master", "or", "truncate", "char", "declare", "join"
		//"insert", "select", "delete", "update","create","drop"
		val=dealKeyWord(val);
		//|,;,$,%,逗号,(),+,\ 
		val = strEscape(val);
		//处理单引号 转义成 sql字符
		val =  StringEscapeUtils.escapeSql(val);
		return val;
	}
	
	/**
	 * 暂时不过滤 1.@不过滤，因为有邮件 2.逗号
	 * @param input
	 * @return
	 * @author zhangyun
	 */
	public static String strEscape(String input){
        if(input == null)
            return input;
        StringBuffer filtered = new StringBuffer(input.length());
//        char prevChar = '\0';
        char c;
        for(int i = 0; i < input.length(); i++){
            c = input.charAt(i);
            if(c == '|' || c == '$' || c == '#' || c == '%' || c == '(' || c == ')'|| c == '+'|| c == ';'){//|| c == '?'|| c == '%' || c == '(' || c == ')'|| c == '+'|| c == ';'|| c == '?'){
                filtered.append(StringUtils.toSBC(c));
            }
//            else
//            if(c == '\\')
//                filtered.append("\\\\");
//            else
//            if(c == '/')
//                filtered.append("\\/");
//            else
//            if(c == '\t')
//                filtered.append("\\t");
//            else
//            if(c == '\n'){
//                if(prevChar != '\r')
//                    filtered.append("\\n");
//            } 
//            else
//            if(c == '\r')
////                filtered.append("\\n");
//            	filtered.append("\r\n");
//            else
//            if(c == '\f')
//                filtered.append("\\f");
            else{
                filtered.append(c);
            }
//            prevChar = c;
        }

        return filtered.toString();
    }
	
	public static String dealKeyWord(String input) {  
		String[] keyWord = {"script"," and ", " exec ", " count ", " chr ", " mid ", " master ", " or ", " truncate ", " char ", " declare ", " join ","insert", "select", "delete", "update","create","drop"};
		String temp = input.toLowerCase();
		for(int i= 0;i<keyWord.length;i++){
			if(temp.indexOf(keyWord[i]) >= 0){
				input = input.substring(0, temp.indexOf(keyWord[i])) + StringUtils.toSBC(input.substring(temp.indexOf(keyWord[i]),temp.indexOf(keyWord[i]) + keyWord[i].length())) + input.substring(temp.indexOf(keyWord[i]) + keyWord[i].length(), input.length());
				input = dealKeyWord(input);
				break;
			}
		}
		return input;   
	} 
	
	/**
	 * 过滤sql中非法字符 exec、xp_、sp_、declare、union、cmd
	 * 
	 * @param value
	 * @return
	 */
	public static String filterSql(String value) 
    { 
        if (value==null || "".equals( value.trim() )) return ""; 
        value = value.replaceAll(";", "" );
        value = value.replaceAll("'", ""); // '
        value = value.replaceAll("&", ""); // &
        value = value.replaceAll("%", ""); // %20
        value = value.replaceAll("--", ""); // --
        value = value.replaceAll("==", ""); // ==
        value = value.replaceAll("<", ""); // <
        value = value.replaceAll(">", ""); // >
        value = value.replaceAll("%", ""); // %
        value = value.replaceAll("[?]", ""); // ?
        value = value.replaceAll(":", ""); // :
        value = value.replaceAll("\"", ""); // "
        value = value.replaceAll("[|]", ""); // |
        value = value.replaceAll("[{]", ""); // {
        value = value.replaceAll("[}]", ""); // }
        
//        value = value.replaceAll("exec", ""); // %
        value = value.replaceAll("xp_", ""); // %
        value = value.replaceAll("sp_", ""); // %
//        value = value.replaceAll("declare", ""); // %
//        value = value.replaceAll("cmd", ""); // %
        return value; 
    }
	
	public static void main(String args[]){
		//System.out.println(filterSql("<>?:\"|{}"));
	}
}
