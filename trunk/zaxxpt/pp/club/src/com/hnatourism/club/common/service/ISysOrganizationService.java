package com.hnatourism.club.common.service;

import java.util.List;
import com.hnatourism.framework.core.exception.DataAccessException;
import com.hnatourism.club.common.domain.SysOrganization;
import com.hnatourism.club.common.web.vo.SysOrganizationVo;
/**
 * 项目名称:海航旅业CLUB系统系统系统
 * 
 * 功能描述:组织机构表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public interface ISysOrganizationService {
	/**
	 * 【根据条件查询】（系统生成方法）
	 * @param domain
	 * @return
	 * @throws DataAccessException
	 */
	public List findByType(String type) throws Exception;
}
