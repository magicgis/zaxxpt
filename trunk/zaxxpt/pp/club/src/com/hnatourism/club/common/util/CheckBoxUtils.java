package com.hnatourism.club.common.util;

import java.util.Arrays;
import com.hnatourism.framework.utils.ArrayUtils;
import com.hnatourism.framework.utils.StringUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:复选框处理处理
 * 
 * 历史版本:
 *					2010-07-21 v1.0.0 (hna) 创建:
 * 
 */
public class CheckBoxUtils{
	/**
	 * @description 【组合区间条件拼接sql字符串】
	 * @param priceArr 区间数组
	 * @param column sql对应的列名
	 * @return
	 * @author zhangyun
	 */
	public static String mergeRange(String[] arr,String column){
		String sql = null;
		if(ArrayUtils.isEmpty(arr) || StringUtils.isEmpty(column)){
			return sql;
		}
		Arrays.sort(arr);
		//sql
		StringBuffer sb = new StringBuffer().append(" ((");
		//区间的开启与关闭
		int i=0;
		//下一个区间
		String next = null;
		//当前区间开启
		String curStart = null;
		//当前区间关闭
		String curEnd = null;
		//下一个区间开启
		String nextStart = null;
		//下一个区间关闭
		String nextEnd = null;
		for(String cur:arr){
			curStart = cur.split(",")[0];
			curEnd = cur.split(",")[1];
			//当前不是最后一个
			if(i!=(arr.length-1)){
				next = arr[i+1];
				nextStart = next.split(",")[0];
				nextEnd = next.split(",")[1];
				if(curEnd.equals(nextStart)){
					arr[i+1] = curStart+","+nextEnd;
				}
			}
			// 当前不是最后一个并且当前末不等于下个首，或者当前为最后一个
			if((i!=(arr.length-1) && !curEnd.equals(nextStart)) 
					|| (i==(arr.length-1) )){
				//如果已经有区间了  " ((" 长度为3，增加or
				if(sb.length()>3){
					sb.append(" or (");
				}
				//拼接区间开启条件
				sb.append(column).append(">").append(curStart);
				//如果不是以结束符结尾，则拼接区间关闭条件
				if(!((i==(arr.length-1)) && "999999".equals(curEnd))){
					sb.append(" and ").append(column).append("<=").append(curEnd);
				}
				sb.append(")");
			}
			i++;
		}
		sql = sb.append(")").toString();
		return sql;
	}
	
	/**
	 * @description 【组合复选框条件】
	 * @param arr
	 * @param column
	 * @return
	 * @author zhangyun
	 */
	public static String mergeCheckBox(String[] arr,String column){
		return column;
	}
	
	public static void main(String[] args) {
		String[] priceArr={"1,200","800,999999","400,800"};
		System.out.println(mergeRange(priceArr,"name"));;
		
	}
}
