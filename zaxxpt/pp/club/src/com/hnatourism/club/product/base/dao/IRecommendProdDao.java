package com.hnatourism.club.product.base.dao;


import java.util.List;
import java.util.Map;

import com.hnatourism.club.product.base.domain.RecommendProd;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;
/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:推荐产品类
 * 
 * 历史版本:
 *					2011-03-21 v1.0.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface IRecommendProdDao {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByWhere(RecommendProd domain) throws DataAccessException ;
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
  public Page findByWhere(RecommendProd domain,PageInfo pageInfo) throws DataAccessException;
	/**
	 * 【根据ID查询】（系统生成方法）
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public RecommendProd findById(String id) throws DataAccessException ;

	/**
	 * 【删除】（系统生成方法）
	 * @param id
	 * @throws DataAccessException
	 */
//	public int delete(String id) throws DataAccessException ;

	/**
	 *  【修改】（系统生成方法）
	 * @param domain
	 * @throws DataAccessException
	 */
//	public int update(RecommendProd domain) throws DataAccessException ;

	/**
	 * 【新增】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
//	public Object insert(RecommendProd domain) throws DataAccessException ;

	/**
	 * 【团购产品推荐分页查询】
	 * @param domain
	 * @param pageInfo
	 * @return
	 * @throws DataAccessException
	 */
//	public Page findGroupByWhere(RecommendProd domain,PageInfo pageInfo) throws DataAccessException;
	
	/**
	 * 
	 * @description 【根据类型查询推荐信息】
	 * @param type 查询推荐类型
	 * @param size 查询条数
	 * @param ctiyCode 城市编码,如果城市编码为空则查询该类型的所有推荐信息
	 * @return
	 * @throws DataAccessException
	 * @createTime 2011-9-22 上午10:10:29
	 * @author lixun
	 */
	public List<RecommendProd> findByType(String type,String ctiyCode,int size)throws DataAccessException;
//	/**
//	 * 
//	 * @description 【根据类型查询城市编码】
//	 * @param type
//	 * @param cityAmount
//	 * @throws DataAccessException
//	 * @createTime 2011-9-26 下午05:03:04
//	 * @author lixun
//	 */
//	public List<String> findCityCodeByType(String type, int cityAmount)throws DataAccessException;
	public List<String> findCityCodeByJdbc(String type,int cityAmount)throws DataAccessException;
}
