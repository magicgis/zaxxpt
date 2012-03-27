package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员角色表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberRoleServiceTest extends JunitTestCase {
	private IMemberRoleService service = null;
	private MemberRoleVo memberRole = null;
	private String testIdVal = "zyId";

	public IMemberRoleServiceTest() {
		service = (IMemberRoleService) getBean("memberRoleService");
		memberRole = createMemberRoleVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberRole);
	}

	public void testUpdate() throws Exception {
		service.update(memberRole);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberRole);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberRoleVo createMemberRoleVo() {
		MemberRoleVo memberRole = new MemberRoleVo();
		memberRole.setId(testIdVal);
		return memberRole;
	}
}