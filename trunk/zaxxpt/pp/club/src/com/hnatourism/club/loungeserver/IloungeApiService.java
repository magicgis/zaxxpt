package com.hnatourism.club.loungeserver;

import java.lang.reflect.Type;

public interface IloungeApiService {

	/**
	 * 参数初始化
	 * @param permeters 初始化参数
	 * @param type 参数类型
	 * @throws Exception
	 */
	public void init( Object permeters,Type type) throws Exception ;
	/**
	 * 传入参数处理
	 * @throws Exception
	 */
	public void parameterHandler()  throws Exception;
	/**
	 * 执行业务增删改查
	 */
	public void execute();
	
	/**
	 * 执行完成后处理
	 */
	public void endHandler();
	
	/**
	 * 返回结果集
	 * @return
	 */
	public Object getResult();
}
