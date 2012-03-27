package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberStsVo;
import com.hnatourism.club.personal.member.service.IMemberStsService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员状态表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberStsServiceTest extends JunitTestCase {
	private IMemberStsService service = null;
	private MemberStsVo memberSts = null;
	private String testIdVal = "zyId";

	public IMemberStsServiceTest() {
		service = (IMemberStsService) getBean("memberStsService");
		memberSts = createMemberStsVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberSts);
	}

	public void testUpdate() throws Exception {
		service.update(memberSts);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberSts);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberStsVo createMemberStsVo() {
		MemberStsVo memberSts = new MemberStsVo();
		memberSts.setId(testIdVal);
		return memberSts;
	}
}