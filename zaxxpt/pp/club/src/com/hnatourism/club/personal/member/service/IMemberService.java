package com.hnatourism.club.personal.member.service;

import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.framework.core.exception.BusinessException;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:会员登录注册
 * 
 * 历史版本: 2010-07-02 v1.0.0 (hna) 创建:
 * 
 */
public interface IMemberService {


	public MemberInfoVo regist(MemberInfoVo memberInfoVo) throws BusinessException;
	
	public MemberInfoVo login(MemberInfoVo memberInfoVo) throws BusinessException;
	/**
	 * 手机绑定
	 * @param mobule : String
	 * @return MemberInfoVo
	 * @throws BusinessException
	 * 
	 */
	public MemberInfoVo mobileBangding(MemberInfoVo memberInfoVo) throws BusinessException;
	
}
 
