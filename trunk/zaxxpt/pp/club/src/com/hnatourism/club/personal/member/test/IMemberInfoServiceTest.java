package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员信息
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberInfoServiceTest extends JunitTestCase {
	private IMemberInfoService service = null;
	private MemberInfoVo memberInfo = null;
	private String testIdVal = "zyId";

	public IMemberInfoServiceTest() {
		service = (IMemberInfoService) getBean("memberInfoService");
		memberInfo = createMemberInfoVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberInfo);
	}

	public void testUpdate() throws Exception {
		service.update(memberInfo);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberInfo);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberInfoVo createMemberInfoVo() {
		MemberInfoVo memberInfo = new MemberInfoVo();
		memberInfo.setId(testIdVal);
		return memberInfo;
	}
}