package com.hnatourism.club.product.base.service;

import java.util.List;
import java.util.Map;

import com.hnatourism.club.product.base.vo.RecommendProdVo;
import com.hnatourism.framework.core.exception.BusinessException;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:
 * 
 * 历史版本: 2011-9-22 v1.0.0 (lixun) 创建
 * 
 */
public interface RecommendProdService {
	/**
	 * 
	 * @description 【按类型查询推荐】
	 * @param type
	 * @param cityCode
	 * @param size
	 * @return
	 * @throws BusinessException
	 * @createTime 2011-9-22 下午01:58:46
	 * @author lixun
	 */
	public List<RecommendProdVo> findByType(String type,String cityCode,int size)throws BusinessException;
	/**
	 * 
	 * @description 【请添加描述】
	 * @param string 推荐类型
	 * @param cityAmount 城市数目
	 * @param pageSize 显示数目
	 * @return
	 * @throws BusinessException
	 * @createTime 2011-9-26 下午04:35:36
	 * @author lixun
	 */
	public Map<String, List<RecommendProdVo>> findByType(String type,int cityAmount, int pageSize)throws BusinessException;
	/**
	 * 
	 * @description 【按指定条件查询推荐】
	 * @param prodVo
	 * @return
	 * @throws BusinessException
	 * @createTime 2011-9-22 下午01:59:01
	 * @author lixun
	 */
	public List<RecommendProdVo> findByWhere(RecommendProdVo prodVo)throws BusinessException;
	/**
	 * 
	 * @description 【按id查询】
	 * @param id
	 * @return
	 * @throws BusinessException
	 * @createTime 2011-9-22 下午01:59:41
	 * @author lixun
	 */
	public RecommendProdVo findById(String id)throws BusinessException;
	
}
