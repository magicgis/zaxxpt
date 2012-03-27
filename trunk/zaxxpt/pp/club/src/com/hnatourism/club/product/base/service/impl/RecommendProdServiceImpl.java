package com.hnatourism.club.product.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hnatourism.club.product.base.dao.IRecommendProdDao;
import com.hnatourism.club.product.base.domain.RecommendProd;
import com.hnatourism.club.product.base.service.RecommendProdService;
import com.hnatourism.club.product.base.vo.RecommendProdVo;
import com.hnatourism.framework.core.exception.BusinessException;
import com.hnatourism.framework.utils.BeanUtils;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:
 * 
 * 历史版本: 2011-9-22 v1.0.0 (lixun) 创建
 * 
 */
public class RecommendProdServiceImpl implements RecommendProdService{
	
	private IRecommendProdDao  recommendProdDao;
	
	@Override
	public RecommendProdVo findById(String id) throws BusinessException {
		RecommendProd domain=recommendProdDao.findById(id);
		if(domain==null){
			return null;
		}
		RecommendProdVo vo=new RecommendProdVo();
		BeanUtils.copyProperties(domain, vo);
		return vo;
	}

	@Override
	public List<RecommendProdVo> findByType(String type, String cityCode,
			int size) throws BusinessException {
		if(size<1){
			throw new BusinessException("","分页长度不能小于1,com.hnatourism.club.product.base.service.impl.RecommendProdServiceImpl.findByType()");
		}
		List<RecommendProd> domainList=recommendProdDao.findByType(type, cityCode, size);
		if(domainList==null||domainList.size()<1){
//			throw new BusinessException("","查询推荐信息结果为空,com.hnatourism.club.product.base.service.impl.RecommendProdServiceImpl.findByType()");
			return new ArrayList<RecommendProdVo>();
		}else {
			List<RecommendProdVo> result=new ArrayList<RecommendProdVo>();
			for(RecommendProd domain:domainList){
				RecommendProdVo vo=new RecommendProdVo();
				BeanUtils.copyProperties(domain, vo);
				result.add(vo);
			}
			return result;
		}
	}
	/**
	 * 
	 * @description 【返回产品推荐信息】
	 * @see com.hnatourism.club.product.base.service.RecommendProdService#findByType(java.lang.String, int, int)
	 * @createTime 2011-9-26 下午04:41:10
	 * @author lixun
	 */
	@Override
	public Map<String, List<RecommendProdVo>> findByType(String type,
			int cityAmount, int pageSize) throws BusinessException {
		if(cityAmount<1){
			throw new BusinessException("","城市数量不能小于1");
		}
		if(pageSize<1){
			throw new BusinessException("","推荐产品长度不能小于1");
		}
		//查询城市
//		Map<String, Object> query=new HashMap<String, Object>();
//		query.put("type", type);
//		query.put("cityAmount", cityAmount);
		try {
			List<String> cityCodes=recommendProdDao.findCityCodeByJdbc(type,cityAmount);
			Map<String, List<RecommendProdVo>> result=new HashMap<String, List<RecommendProdVo>>();
			if(cityCodes!=null&&cityCodes.size()>0){
				for(String cityCode:cityCodes){
					if(cityCode!=null){
						List<RecommendProd> domainList=recommendProdDao.findByType(type, cityCode, pageSize);
						if(domainList!=null&&domainList.size()>0){
							List<RecommendProdVo> voList=new LinkedList<RecommendProdVo>();
							for(RecommendProd domain: domainList){
								RecommendProdVo vo=new RecommendProdVo();
								BeanUtils.copyProperties(domain, vo);
								voList.add(vo);
							}
							result.put(cityCode, voList);
						}
					}
				}
			}
			return result;
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	@Override
	public List<RecommendProdVo> findByWhere(RecommendProdVo prodVo)
			throws BusinessException {
		if(prodVo==null){
			throw new BusinessException("","查询条件不能为空,com.hnatourism.club.product.base.service.impl.RecommendProdServiceImpl.findByType()");
		}
		RecommendProd queryDomain=new RecommendProd();
		BeanUtils.copyProperties(prodVo, queryDomain);
		List<RecommendProd> domainList=recommendProdDao.findByWhere(queryDomain);
		if(domainList==null||domainList.size()<1){
			throw new BusinessException("","查询推荐信息结果为空,com.hnatourism.club.product.base.service.impl.RecommendProdServiceImpl.findByType()");
		}else {
			List<RecommendProdVo> result=new LinkedList<RecommendProdVo>();
			for(RecommendProd domain:domainList){
				RecommendProdVo vo=new RecommendProdVo();
				BeanUtils.copyProperties(domain, vo);
				result.add(vo);
			}
			return result;
		}
	}

	public IRecommendProdDao getRecommendProdDao() {
		return recommendProdDao;
	}

	public void setRecommendProdDao(IRecommendProdDao recommendProdDao) {
		this.recommendProdDao = recommendProdDao;
	}

//	public IRecommendCityDao getRecommendCityDao() {
//		return recommendCityDao;
//	}
//
//	public void setRecommendCityDao(IRecommendCityDao recommendCityDao) {
//		this.recommendCityDao = recommendCityDao;
//	}
//	
	
	
}
