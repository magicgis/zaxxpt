package com.hnatourism.club.common.service;

import java.lang.reflect.Type;

import com.hnatourism.club.golf.order.vo.GolfOrderVo;
import com.hnatourism.club.lounge.order.vo.OrderLoungeVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;

public interface IPriceValidatorService {

	public Boolean validatPrice(Object obj,String memberId);
	public Boolean validatGolf(GolfOrderVo golfOrderVo,MemberInfoVo memberInfoVo);
	public Boolean validatLounge(OrderLoungeVo orderLoungeVo,MemberInfoVo memberInfoVo);
	public Boolean validator(Object source,Object target,String skipParameters,Type... skipType);
}
