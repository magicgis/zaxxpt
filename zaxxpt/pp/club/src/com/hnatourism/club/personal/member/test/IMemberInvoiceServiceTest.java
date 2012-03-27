package com.hnatourism.club.personal.member.test;

import java.util.List;

import com.hnatourism.framework.context.ContextHolder;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
import com.hnatourism.framework.junit.JunitTestCase;
import com.hnatourism.club.personal.member.web.vo.MemberInvoiceVo;
import com.hnatourism.club.personal.member.service.IMemberInvoiceService;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员发票表
 * 
 * 历史版本:
 *					2011-08-22 v1.1.0 (hna) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class IMemberInvoiceServiceTest extends JunitTestCase {
	private IMemberInvoiceService service = null;
	private MemberInvoiceVo memberInvoice = null;
	private String testIdVal = "zyId";

	public IMemberInvoiceServiceTest() {
		service = (IMemberInvoiceService) getBean("memberInvoiceService");
		memberInvoice = createMemberInvoiceVo();
	}

	public void testInsert() throws Exception {
		service.insert(memberInvoice);
	}

	public void testUpdate() throws Exception {
		service.update(memberInvoice);
	}

	public void testFindById() throws Exception {
		service.findById(testIdVal);
	}

	public void testFindByWhere() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setRowsOfPage(15);
		ContextHolder.getContext().setAttribute(PageInfo.PAGEINFO, pageInfo);
		List list = service.findByWhere(memberInvoice);
		log.info(list.size());
	}

	public void testDelete() throws Exception {
		service.delete(testIdVal);
	}

	public MemberInvoiceVo createMemberInvoiceVo() {
		MemberInvoiceVo memberInvoice = new MemberInvoiceVo();
		memberInvoice.setId(testIdVal);
		return memberInvoice;
	}
}