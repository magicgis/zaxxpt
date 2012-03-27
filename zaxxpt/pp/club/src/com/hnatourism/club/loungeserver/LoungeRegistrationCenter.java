package com.hnatourism.club.loungeserver;

import com.hnatourism.club.loungeserver.order.ILoungeOrderChangeApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderLogApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderReturnApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderCancelApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderExceptionApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderListApiService;
import com.hnatourism.club.loungeserver.order.ILoungeOrderVerifyApiService;
import com.hnatourism.club.loungeserver.order.IloungeOrderApiService;
import com.hnatourism.club.loungeserver.order.IloungeOrderDetailApiService;


public class LoungeRegistrationCenter {
	
	private IloungeHomeApiService  loungeHomeApiService;
	private IloungeOrderApiService  loungeOrderApiService;
	private IloungeSearchApiService loungeSearchApiService;
	private IloungeBookApiService loungeBookApiService;
	//休息室订单详细 lixun
	private IloungeOrderDetailApiService loungeOrderDetailApiService;
	//机场休息室订单取消  lixun
	private ILoungeOrderCancelApiService loungeOrderCancelApiService;
	//机场休息室订单状态确认  lixun
	private ILoungeOrderVerifyApiService loungeOrderVerifyApiService;
	//查询机场休息室退改信息   lixun
	private ILoungeOrderExceptionApiService loungeOrderExceptionApiService;
	//查询机场休息室日志信息   lixun
	private ILoungeOrderLogApiService loungeOrderLogApiService;
	//机场休息室订单退订 
	private ILoungeOrderReturnApiService LoungeOrderReturnApiService;
	//改期
	private ILoungeOrderChangeApiService LoungeOrderChangeApiService;
	private ILoungeOrderListApiService loungeOrderListApiService;
	
	/**
	 * 注册方法--根据条件查询休息室
	 * @return
	 */
	public Object findLoungeByWhere(){
		return loungeHomeApiService;
	}/**
	 * 注册方法--根据条件查询休息室
	 * @return
	 */
	public Object findLoungeInfoByComm(){
		return loungeHomeApiService;
	}
	
	/**
	 * 查找休息室订单
	 * @return
	 */
	public Object findLoungeOrder(){
		return  loungeOrderListApiService;
	}
	
	/**
	 * 查找休息室订单
	 * @return
	 */
	public Object findOrderLoungeByBill(){
		return  loungeOrderListApiService;
	}
	
	/**
	 * 新订单
	 * 
	 * 修改 lixun  提交订单
	 * 将insert 在过滤器中被过滤,改为save
	 * @return
	 */
	public Object saveOrderLounge(){
		return  loungeOrderApiService;
	}


	/**
	 * 注册方法--预定
	 * @return
	 */
	public Object findLoungeRoomById(){
		return loungeBookApiService;
	}
	
	/**
	 * 休息室搜索
	 * @return
	 */
	public Object findLoungeInfoBySearch(){
		return loungeSearchApiService;
	}
	
	/**
	 * 
	 * @description 【请添加描述】
	 * @return
	 * @createTime 2011-8-15 下午05:15:00
	 * @author lixun
	 */
	public Object findLoungeOrderDetail(){
		return loungeOrderDetailApiService;
	}
	/**
	 * 取消订单
	 * @description 【请添加描述】
	 * @return
	 * @createTime 2011-8-16 下午03:01:23
	 * @author lixun
	 */
	public Object cancelLoungeOrder(){
		return loungeOrderCancelApiService;
	}
	
	/**
	 * 
	 * @description 【机场休息室订单状态确认】
	 * @return
	 * @createTime 2011-9-8 上午11:18:59
	 * @author lixun
	 */
	public Object verifyLoungeOrder(){
		return loungeOrderVerifyApiService;
	}
	/**
	 * 
	 * @description 查询机场休息室退改信息
	 * @return
	 * @createTime 2011-8-17 上午11:50:32
	 * @author lixun
	 */
	public Object findLoungeOrderException(){
		return loungeOrderExceptionApiService;
	}
	
	/**
	 * 
	 * @description 查询机场休息室退改信息
	 * @return
	 * @createTime 2011-8-17 上午11:50:32
	 * @author lixun
	 */
	public Object findLoungeOrderLog(){
		return loungeOrderLogApiService;
	}
	/**
	 * 休息室订单退订    传入三个参数   订单id  退订内容    创建者   顾客id  具体名称见订单vo中   
	 * @return
	 */
	public Object unsubscribeLoungeOrder(){
		return LoungeOrderReturnApiService;
	}
	
	/**
	 * 改期
	 * @return
	 */
	public Object rescheduleLoungeOrder(){
		return LoungeOrderChangeApiService;
	}

	

	public IloungeHomeApiService getLoungeHomeApiService() {
		return loungeHomeApiService;
	}

	public void setLoungeHomeApiService(IloungeHomeApiService loungeHomeApiService) {
		this.loungeHomeApiService = loungeHomeApiService;
	}

	public IloungeOrderApiService getLoungeOrderApiService() {
		return loungeOrderApiService;
	}

	public void setLoungeOrderApiService(
			IloungeOrderApiService loungeOrderApiService) {
		this.loungeOrderApiService = loungeOrderApiService;
	}

	public IloungeSearchApiService getLoungeSearchApiService() {
		return loungeSearchApiService;
	}

	public void setLoungeSearchApiService(
			IloungeSearchApiService loungeSearchApiService) {
		this.loungeSearchApiService = loungeSearchApiService;
	}

	public IloungeBookApiService getLoungeBookApiService() {
		return loungeBookApiService;
	}

	public void setLoungeBookApiService(IloungeBookApiService loungeBookApiService) {
		this.loungeBookApiService = loungeBookApiService;
	}

	public IloungeOrderDetailApiService getLoungeOrderDetailApiService() {
		return loungeOrderDetailApiService;
	}

	public void setLoungeOrderDetailApiService(
			IloungeOrderDetailApiService loungeOrderDetailApiService) {
		this.loungeOrderDetailApiService = loungeOrderDetailApiService;
	}


	public ILoungeOrderReturnApiService getLoungeOrderReturnApiService() {
		return LoungeOrderReturnApiService;
	}
	public void setLoungeOrderReturnApiService(
			ILoungeOrderReturnApiService loungeOrderReturnApiService) {
		LoungeOrderReturnApiService = loungeOrderReturnApiService;
	}
	public ILoungeOrderChangeApiService getLoungeOrderChangeApiService() {
		return LoungeOrderChangeApiService;
	}
	public void setLoungeOrderChangeApiService(
			ILoungeOrderChangeApiService loungeOrderChangeApiService) {
		LoungeOrderChangeApiService = loungeOrderChangeApiService;
	}
	public void setLoungeOrderCancelApiService(
			ILoungeOrderCancelApiService loungeOrderCancelApiService) {
		this.loungeOrderCancelApiService = loungeOrderCancelApiService;
	}

	public ILoungeOrderCancelApiService getLoungeOrderCancelApiService() {
		return loungeOrderCancelApiService;
	}
	public ILoungeOrderExceptionApiService getLoungeOrderExceptionApiService() {
		return loungeOrderExceptionApiService;
	}
	public void setLoungeOrderExceptionApiService(
			ILoungeOrderExceptionApiService loungeOrderExceptionApiService) {
		this.loungeOrderExceptionApiService = loungeOrderExceptionApiService;
	}
	public ILoungeOrderListApiService getLoungeOrderListApiService() {
		return loungeOrderListApiService;
	}
	public void setLoungeOrderListApiService(
			ILoungeOrderListApiService loungeOrderListApiService) {
		this.loungeOrderListApiService = loungeOrderListApiService;
	}
	public void setLoungeOrderVerifyApiService(
			ILoungeOrderVerifyApiService loungeOrderVerifyApiService) {
		this.loungeOrderVerifyApiService = loungeOrderVerifyApiService;
	}
	public ILoungeOrderVerifyApiService getLoungeOrderVerifyApiService() {
		return loungeOrderVerifyApiService;
	}
	public ILoungeOrderLogApiService getLoungeOrderLogApiService() {
		return loungeOrderLogApiService;
	}
	public void setLoungeOrderLogApiService(
			ILoungeOrderLogApiService loungeOrderLogApiService) {
		this.loungeOrderLogApiService = loungeOrderLogApiService;
	}
	
}
