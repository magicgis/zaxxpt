package com.xunruan.framekork.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wenz
 * 
 */

public class PackUtil {
	private char ESCAPE_CHAR = '\\';
	private char NAME_VALUE_SEPARATOR = '=';
	private char NAME_VALUE_PARIR_SEPARATOR = ',';
	private char NAME_ARRAY_PAIR_START = '[';
	private char NAME_ARRAY_PAIR_END = ']';
	private char NAME_MAP_PAIR_START = '{';
	private char NAME_MAP_PAIR_END = '}';
	private char NAME_ARRAY_ELE_SEPARATOR = ',';
	
	private int maxDeeps = 10;
	

	public static final PackUtil DEFAULT = new PackUtil();
	public static final PackUtil QUERY_STRING = new PackUtil('\0', '=', '&');
	
	private PackUtil() {}
	private PackUtil(char escape_char, char name_valie_separator,
			char name_valie_parir_separator) {
		ESCAPE_CHAR = escape_char;
		NAME_VALUE_SEPARATOR = name_valie_separator;
		NAME_VALUE_PARIR_SEPARATOR = name_valie_parir_separator;
	}

	public String pack(Map<String, ?> map){
		String rst = packMap(map, 0);
		
		return rst.substring(1, rst.length() - 1);
	}
	
	@SuppressWarnings("unchecked")
	protected String packObject(Object val, int deep){
		if(val instanceof Object[] || val instanceof Collection)return packArray(val, deep);
		else if(val instanceof Map)return packMap((Map)val, deep);
		return packString(val);
		
	}

	protected String packMap(Map<String, ?> map, int deep){
		if (deep++ > this.maxDeeps) throw new IllegalArgumentException("exceed max deep: " + deep + " > " + this.maxDeeps);
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String, ?> entry : map.entrySet()){
			sb.append(packString(entry.getKey()));
			sb.append(NAME_VALUE_SEPARATOR);
			if(entry.getValue() != null)sb.append(packObject(entry.getValue(), deep));
			sb.append(NAME_VALUE_PARIR_SEPARATOR);
		}
		if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		return NAME_MAP_PAIR_START + sb.toString() + NAME_MAP_PAIR_END;
	}
	
	public Map<String, Object> unpack(String str){
		Map<String, Object> ret = new LinkedHashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		boolean isMeta = false;
		String name = null;
		Object value = null;
		boolean isArrayValue = false;
		List<String> array = new ArrayList<String>();
		int arrayDeep = 0;
		int mapDeep = 0;
		for(int i = 0 ; i < str.length(); i++){
			char c = str.charAt(i);
			if(isMeta){
				sb.append(c);
				isMeta = false;
				continue;
			}
			if (c == ESCAPE_CHAR) { 
				isMeta = true;
				sb.append(c);
				continue;
			} 
			else if (arrayDeep==0 && mapDeep ==0 && c == NAME_VALUE_SEPARATOR) {
				name = unpackString(sb.toString());
				sb.setLength(0);
				arrayDeep = 0;
				mapDeep = 0;
				continue;
			}
			else if (arrayDeep==0 && mapDeep ==0 && c == NAME_VALUE_PARIR_SEPARATOR) {
				if(name == null) continue;
				value = unpackObject(sb.toString());
				sb.setLength(0);
				ret.put(name, value);
				name = null;
				continue;
			}
			else if(c == NAME_ARRAY_PAIR_START){
				arrayDeep++;
			}
			else if(c == NAME_ARRAY_PAIR_END){
				arrayDeep--;
			}
			else if(c == NAME_MAP_PAIR_START){
				mapDeep++;
			}
			else if(c == NAME_MAP_PAIR_END){
				mapDeep--;
			}
			sb.append(c);
		}
		if(name != null){
			value = unpackObject(sb.toString());
			sb.setLength(0);
			ret.put(name, value);
		}
		
		return ret;
	}
	
	protected Object[] unpackArray(String str){
		List<Object> ret = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		boolean isMeta = false;
		int arrayDeep = 0;
		int mapDeep = 0;
		for(int i = 0 ; i < str.length(); i++){
			char c = str.charAt(i);
			if(isMeta){
				sb.append(c);
				isMeta = false;
				continue;
			}
			if (c == ESCAPE_CHAR) { 
				isMeta = true;
				sb.append(c);
				continue;
			} 
			else if(c == NAME_ARRAY_ELE_SEPARATOR){
				if(arrayDeep == 0 && mapDeep == 0){
					ret.add(unpackObject(sb.toString()));
					sb.setLength(0);
					continue;
				}
			}
			else if(c == NAME_ARRAY_PAIR_START){
				arrayDeep++;
			}
			else if(c == NAME_ARRAY_PAIR_END){
				arrayDeep--;
			}
			else if(c == NAME_MAP_PAIR_START){
				mapDeep++;
			}
			else if(c == NAME_MAP_PAIR_END){
				mapDeep--;
			}
			sb.append(c);
		}
		Object lastObj = unpackObject(sb.toString());
		if(lastObj != null) ret.add(lastObj);
		
		return ret.toArray();
		
	}

	
	protected Object unpackObject(String str){
		String pstr = str == null ? "" : str.trim();
		if(pstr.startsWith("" + NAME_ARRAY_PAIR_START) && pstr.endsWith("" + NAME_ARRAY_PAIR_END)){
			return unpackArray(pstr.substring(1, pstr.length() - 1));
		}else if(pstr.startsWith("" + NAME_MAP_PAIR_START) && pstr.endsWith("" + NAME_MAP_PAIR_END)){
			return unpack(pstr.substring(1, pstr.length() - 1));
		}
		return unpackString(str);
	}
	
	protected String unpackString(String str){
		StringBuffer sb = new StringBuffer();
		boolean isMeta = false;
		for(int i = 0 ; i < str.length(); i++){
			char c = str.charAt(i);
			if(isMeta){
				sb.append(c);
				isMeta = false;
				continue;
			}
			if (c == ESCAPE_CHAR) { 
				isMeta = true;
				continue;
			} 
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	@SuppressWarnings("unchecked")
	protected String packArray(Object val, int deep){
		if(val == null) return "[]";
		Object[] array;
		if(val instanceof Object[]) array = (Object[]) val;
		else array = ((Collection)val).toArray();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(Object v : array) sb.append(packObject(v, deep) +",");
		if(array.length > 0) sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
	
	protected String packString(Object str){
		if(str == null) return "";
		String rst = "" + str;
		for(String ms : new String[]{"" +ESCAPE_CHAR+ESCAPE_CHAR, ""+NAME_VALUE_SEPARATOR, ""+NAME_VALUE_PARIR_SEPARATOR, "\\"+NAME_ARRAY_PAIR_START, "\\"+NAME_ARRAY_PAIR_END}){
			rst = rst.replaceAll(ms, "" + ESCAPE_CHAR + ESCAPE_CHAR + ms);
		}
		return rst;
	}
	
	public static void main(String[] args) throws Exception{
//		String str = "";
//		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//		PrintWriter stdout = new PrintWriter(new OutputStreamWriter(System.out, "utf-8"), true);
//		stdout.println("Please enter the original data : ");
//		str = stdin.readLine();
//		stdout.println(PackUtil.DEFAULT.unpack(str));
			
	}
	

}
