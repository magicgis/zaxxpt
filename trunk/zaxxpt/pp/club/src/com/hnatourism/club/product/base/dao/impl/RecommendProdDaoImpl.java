package com.hnatourism.club.product.base.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnatourism.club.product.base.dao.IRecommendProdDao;
import com.hnatourism.club.product.base.domain.RecommendProd;
import com.hnatourism.framework.core.daosupport.AbstractIBatisDaoSupport;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.core.exception.DataAccessException;

import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:推荐信息dao操作
 * 
 * 历史版本: 2011-9-22 v1.0.0 (lixun) 创建[推荐信息在前台只需要查询操作即可,所以目前只提供查询操作]
 * 			
 * 
 */
public class RecommendProdDaoImpl extends AbstractIBatisDaoSupport implements
		IRecommendProdDao {
	private static final Log log = LogFactory
			.getLog(RecommendProdDaoImpl.class);
	
	private JdbcDaoSupport jdbcDaoSupport;
//	@Override
//	public int delete(String id) throws DataAccessException {
////		RecommendProd domain = findById(id);
////		if (domain == null) {
////			throw new DataAccessException("", "ID = '" + id
////					+ "' object not exist");
////		}
////		return getPersistanceManager().delete("deleteRecommendProd", id);
//		return 0;
//	}

	/**
	 * 
	 * @description 【根据id查询】
	 * @see com.hnatourism.club.product.base.dao.IRecommendProdDao#findById(java.lang.String)
	 * @createTime 2011-9-22 上午10:33:04
	 * @author lixun
	 */
	@Override
	public RecommendProd findById(String id) throws DataAccessException {
		 return (RecommendProd) getPersistanceManager().load(
		 "findRecommendProdById", id);
	}

	/**
	 * 
	 * @description 【根据类型查询】
	 * @see com.hnatourism.club.product.base.dao.IRecommendProdDao#findByType(java.lang.String, java.lang.String, int)
	 * @createTime 2011-9-22 上午10:35:07
	 * @author lixun
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RecommendProd> findByType(String type, String ctiyCode, int size)
			throws DataAccessException {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("type", type);
		queryMap.put("ctiyCode", ctiyCode);
		queryMap.put("size", size);
		List<RecommendProd> result=null;
		if(ctiyCode==null){
			try {
				result= (List<RecommendProd>) getPersistanceManager().find("findRecommendProdByTypeNoCode", queryMap);
			} catch (Exception e) {
				result=null;
			}
		}else {
			try {
				result=(List<RecommendProd>) getPersistanceManager().find("findRecommendProdByType", queryMap);
			} catch (Exception e) {
				result=null;
			}
			
		}
		return result;
	}

	/**
	 * 
	 * @description 【根据指定条件查询】
	 * @see com.hnatourism.club.product.base.dao.IRecommendProdDao#findByWhere(com.hnatourism.club.product.base.domain.RecommendProd)
	 * @createTime 2011-9-22 上午10:35:29
	 * @author lixun
	 */
	@Override
	public List findByWhere(RecommendProd domain) throws DataAccessException {
		return getPersistanceManager().find("findRecommendProdByWhere", domain);
	}

	/**
	 * 
	 * @description 【根据条件查询,并进行分页】
	 * @see com.hnatourism.club.product.base.dao.IRecommendProdDao#findByWhere(com.hnatourism.club.product.base.domain.RecommendProd, com.hnatourism.framework.core.daosupport.page.PageInfo)
	 * @createTime 2011-9-22 上午10:35:54
	 * @author lixun
	 */
	@Override
	public Page findByWhere(RecommendProd domain, PageInfo pageInfo)
			throws DataAccessException {
		return this.getPersistanceManager().find("findRecommendProdByWhere", domain, pageInfo);
	}
	
	@Override
	public List<String> findCityCodeByJdbc(String type,int cityAmount)
			throws DataAccessException {
		String sql="SELECT cityCode FROM (SELECT RC.CITY_CODE cityCode FROM RECOMMEND_CITY RC WHERE  RC.STS='1' AND RC.PROD_TYPE= ?  ORDER BY RC.SEQ  )  WHERE ROWNUM <= ? ";
		List<String> result=new ArrayList<String>();
		try{
			Object[] pramArr={type,cityAmount};
			List<?> searchList = jdbcDaoSupport.find(sql, pramArr);
			for(int i=0;i<searchList.size();i++){
				result.add(((Map<String, String>)searchList.get(i)).get("CITYCODE"));
			}
		}catch (Exception e) {
			throw new  DataAccessException("查询城市失败");
		}
		return result;
	}

	public JdbcDaoSupport getJdbcDaoSupport() {
		return jdbcDaoSupport;
	}

	public void setJdbcDaoSupport(JdbcDaoSupport jdbcDaoSupport) {
		this.jdbcDaoSupport = jdbcDaoSupport;
	}
	
//    SELECT  PAGE.RECOMMEND_CITY_CODE CITYCODE FROM
// 	(SELECT  DISTINCT RECOMMEND_CITY_CODE FROM 
//     (SELECT  RP.RECOMMEND_CITY_CODE,RP.STS FROM RECOMMEND_PROD RP INNER JOIN RECOMMEND_CITY RC ON RP.RECOMMEND_CITY_CODE=RC.CITY_CODE WHERE RC.STS=1 AND  RC.PROD_TYPE=#type# )JT WHERE JT.STS=1)PAGE WHERE ROWNUM<=#cityAmount#

	
	

}
