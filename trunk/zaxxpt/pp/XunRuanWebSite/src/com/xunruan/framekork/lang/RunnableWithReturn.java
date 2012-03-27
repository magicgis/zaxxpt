package com.xunruan.framekork.lang;


/***
 * 
 * @author wenz
 * 2012-02-02 16:25
 * @version 1.0
 * 
 */
public interface RunnableWithReturn<R> {
	
	public R execute() throws Exception;

}
