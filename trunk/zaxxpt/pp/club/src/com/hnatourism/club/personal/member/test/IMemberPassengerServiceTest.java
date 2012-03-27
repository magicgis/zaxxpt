package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
import com.hnatourism.club.personal.member.service.IMemberPassengerService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberPassengerServiceTest extends JunitTestCase {
	private IMemberPassengerService service = null;
	private MemberPassengerVo memberPassenger = null;
	private String testIdVal = "zyId";

	public IMemberPassengerServiceTest() {
		service = (IMemberPassengerService) getBean("memberPassengerService");
		memberPassenger = createMemberPassengerVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberPassenger);
	}

	public void testUpdate() throws Exception {
		service.update(memberPassenger);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberPassenger);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberPassengerVo createMemberPassengerVo() {
		MemberPassengerVo memberPassenger = new MemberPassengerVo();
		memberPassenger.setId(testIdVal);
		return memberPassenger;
	}
}