package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员账户表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberAccountServiceTest extends JunitTestCase {
	private IMemberAccountService service = null;
	private MemberAccountVo memberAccount = null;
	private String testIdVal = "zyId";

	public IMemberAccountServiceTest() {
		service = (IMemberAccountService) getBean("memberAccountService");
		memberAccount = createMemberAccountVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberAccount);
	}

	public void testUpdate() throws Exception {
		service.update(memberAccount);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberAccount);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberAccountVo createMemberAccountVo() {
		MemberAccountVo memberAccount = new MemberAccountVo();
		memberAccount.setId(testIdVal);
		return memberAccount;
	}
}