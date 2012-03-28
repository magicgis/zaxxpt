package com.sunshine.framework.service;

import java.util.List;

import com.sunshine.framework.entity.BaseDomain;
import com.sunshine.framework.entity.SystemRole;

/***
 *@author wenz
 *@Date 2012-3-27下午02:00:43
 *@version 1.0
 *@see com.sunshine.framework.service.Popedom
 ***/
public interface Popedom {

	/***
	 * 获取所有权限 如所有的功能权限 或者字段权限
	 * @return List<BaseDomain>
	 */
	public List<BaseDomain>  getPopedom();
	
	/***
	 * 获取角色列表
	 * @return List<Role>  角色集合
	 */
	public List<SystemRole>  getRole();	
	/***
	 * 验证实体是否具有权限
	 * @param domain  实体
	 * @return boolean  是否具有权限
	 */
	public boolean verifyPopedom(BaseDomain domain);
	
	/***
	 * 验证List中的实体是否具有权限并且返回具有权限的实体
	 * @param list 实体集合
	 * @return List<BaseDomain>  具有权限实体集合
	 */
	public List<BaseDomain> verifyPopedom(List<BaseDomain> list);
	
	/***
	 * 通过实体ID验证是否具有权限
	 * @param id 权限ID
	 * @return boolean 是否具有权限
	 */
	public boolean verifyPopedom(String id);
	
	/***
	 * 权限验证  ,参数为一个数组，如验证Field 参数则为[0]数据源名称,[1]表名称,[2]字段名称
	 * @param args 数组
	 * @return boolean  是否具有权限
	 */
	public boolean verifyPopedom(String... args);
	
	/***
	 * 过滤资源 如果为字段则过滤字段所在的资源  如果为功能则过滤功能所在的资源 如果为资源则为过滤后的资源
	 * @return List<BaseDomain>
	 */
	public List<BaseDomain> filterSource();
	
	
}
