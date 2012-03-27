package com.hnatourism.club.personal.member.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnatourism.club.common.helper.flight.MemberPassenRequestMessage;
import com.hnatourism.club.common.helper.flight.MemberPassenResponseMessage;
import com.hnatourism.club.common.helper.flight.MemberPassengerAddRequestMessage;
import com.hnatourism.club.common.helper.flight.MemberPassengerAddResponseMessage;
import com.hnatourism.club.common.helper.flight.MemberPassengerDelRequestMessage;
import com.hnatourism.club.common.helper.flight.MemberPassengerUpdRequestMessage;
import com.hnatourism.club.common.helper.json.parser.ParseException;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.flight.passenger.MemberPassengerVo;
import com.hnatourism.club.flight.web.vo.FlightMemberPassenVo;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberPassengerService;
import com.hnatourism.framework.core.daosupport.page.Page;
import com.hnatourism.framework.core.daosupport.page.PageInfo;
/**
 * 项目名称:海航旅业B2C系统系统系统
 * 
 * 功能描述:会员常用旅客信息
 * 
 * 历史版本:2011-08-23 v1.1.0 (高杰) 创建:
 * 
 */
@SuppressWarnings("unchecked")
public class MemberPassengerAction extends BaseAction {
	// log
	private static final Log log = LogFactory.getLog(MemberPassengerAction.class);
	// service
	private IMemberPassengerService memberPassengerServ;
	// vo
  	private MemberPassengerVo memberPassengerVo;
  	private List<FlightMemberPassenVo> passengerlist;
  	private String passengeridlist;
  	private PageInfo pageInfo;
  	
  	private String id;
  	private String xm_textfield;
  	private String centType;
  	private String zj_textfield;
  	private String sex;
  	private String mobile;
  	private String email;
  	private String rmk;
  	private String action;
  	private String type;
  	private int page;
  	
  	@Autowired
	private IMemberInfoService memberInfoServ;
	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}
  	
	/**
	 * 【新增】（系统生成方法）
	 * @return
	 */
	public String add()
	{
		try
		{
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			getSession().setAttribute("updpg", null);
			
			search();
			
			memberPassengerVo = new MemberPassengerVo();
			memberPassengerVo.setName(xm_textfield);
			memberPassengerVo.setCertNo(zj_textfield);
			memberPassengerVo.setCertType(centType);
			memberPassengerVo.setType(type);
			memberPassengerVo.setSex(sex);
			memberPassengerVo.setMobile(mobile);
			memberPassengerVo.setEmail(email);
			memberPassengerVo.setDisc(rmk);
			memberPassengerVo.setMemberId(UserUtil.getUser(getSession().getId()).getId());
			
			ArrayList<MemberPassengerVo> memberPassengerVoList = new ArrayList<MemberPassengerVo>();
			for(int i=0; i<passengerlist.size(); i++){
				MemberPassengerVo memberPassengerVo = new MemberPassengerVo();
				memberPassengerVo.setId(passengerlist.get(i).getId());
				memberPassengerVo.setName(passengerlist.get(i).getName());
				memberPassengerVo.setType(passengerlist.get(i).getType());
				memberPassengerVo.setCertNo(passengerlist.get(i).getCertNo());
				memberPassengerVo.setCertType(passengerlist.get(i).getCertType());
				memberPassengerVoList.add(memberPassengerVo);
			}
			memberPassengerVoList.add(memberPassengerVo);
			MemberPassengerAddRequestMessage memberPassengerAddRequestMessage = new MemberPassengerAddRequestMessage();
			MemberPassengerAddResponseMessage memberPassengerAddResponseMessage = new MemberPassengerAddResponseMessage();
			memberPassengerAddRequestMessage.setMemberCode(UserUtil.getUser(getSession().getId()).getCode());
			memberPassengerAddRequestMessage.setMemberId(UserUtil.getUser(getSession().getId()).getId());
			memberPassengerAddRequestMessage.setMemberPassengerVoList(memberPassengerVoList);
			memberPassengerAddRequestMessage.setPersonNum(String.valueOf(memberPassengerVoList.size()));
			String resultStr = memberPassengerAddRequestMessage.excute2();
			if(resultStr.indexOf("success")>=0){
				getRequest().setAttribute("showInfo", 1);
			}else{
				getRequest().setAttribute("showInfo", 0);
			}
			memberPassengerAddResponseMessage.parseResponse(resultStr);
		}
		catch(Exception e)
		{
			getSession().setAttribute("updpg", "error");
			e.printStackTrace();
			return "mistake";
		}
		
		return "success";
	}
	
  	/**
	 * 【删除】（系统生成方法）
	 */
	public String del()
	{
		try
		{
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			ArrayList<MemberPassengerVo> memberPassengerVoList = new ArrayList<MemberPassengerVo>();
			String[] pg_idlist=passengeridlist.split(", ");
			for(int i=0;i<pg_idlist.length;i++)
			{
				MemberPassengerVo memberPassengerVo = new MemberPassengerVo();
				memberPassengerVo.setId(pg_idlist[i]);
				memberPassengerVoList.add(memberPassengerVo);
			}
			MemberPassengerDelRequestMessage memberPassengerDelRequestMessage = new MemberPassengerDelRequestMessage();
			memberPassengerDelRequestMessage.setMemberPassengerVoList(memberPassengerVoList);
			memberPassengerDelRequestMessage.setPersonNum(String.valueOf(memberPassengerVoList.size()));
			String resultStr = memberPassengerDelRequestMessage.excute2();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		return "success";
	}
	
	/**
	 * 【修改】（系统生成方法）
	 * @return
	 */
	public String modify()
	{
		try
		{
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			getSession().setAttribute("updpg", null);
			
			memberPassengerVo=new MemberPassengerVo();
			memberPassengerVo.setType(type);
			memberPassengerVo.setName(xm_textfield);
			memberPassengerVo.setCertNo(zj_textfield);
			memberPassengerVo.setCertType(centType);
			memberPassengerVo.setSex(sex);
			memberPassengerVo.setMobile(mobile);
			memberPassengerVo.setEmail(email);
			memberPassengerVo.setDisc(rmk);
			memberPassengerVo.setId(id);
			memberPassengerVo.setMemberId(UserUtil.getUser(getSession().getId()).getId());
			memberPassengerVo.setMemberCode(UserUtil.getUser(getSession().getId()).getCode());
			
			MemberPassengerUpdRequestMessage memberPassengerUpdRequestMessage = new MemberPassengerUpdRequestMessage();
			memberPassengerUpdRequestMessage.setMemberPassengerVo(memberPassengerVo);
			String resultStr = memberPassengerUpdRequestMessage.excute2();
			
		}
		catch(Exception e)
		{
			getSession().setAttribute("updpg", "error");
			e.printStackTrace();
			return "mistake";
		}
		return "success";
	}
	
  	/**
	 * 
	 */
	public String search()
	{
		 try
		 {
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			MemberPassenRequestMessage memberPassenRequestMessage = new MemberPassenRequestMessage();
			MemberPassenResponseMessage memberPassenResponseMessage = new MemberPassenResponseMessage();
			memberPassenRequestMessage.setMemberId(UserUtil.getUser(getSession().getId()).getId());
			String resultStr = "";
			resultStr =  memberPassenRequestMessage.excute();
			memberPassenResponseMessage.parseResponse(resultStr);
			passengerlist = memberPassenResponseMessage.getMemberPassenList();
			
		 }
		 catch(Exception e){
			 	e.printStackTrace();
				return "success";
		 }
		 return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toAdd()
	{
		try
		{
			if(UserUtil.getUser(getSession().getId())==null)
			{
				return "notlogin";
			}
			getSession().setAttribute("updpg", null);
			
			if(action.equalsIgnoreCase("upd"))
			{
				memberPassengerVo = new MemberPassengerVo();
				memberPassengerVo.setId(id);
				memberPassengerVo.setName(xm_textfield);
				memberPassengerVo.setType(type);
				memberPassengerVo.setCertType(centType);
				memberPassengerVo.setCertNo(zj_textfield);
//				memberPassengerVo=(MemberPassengerVo)memberPassengerServ.findById(id);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toModify()
	{
		return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public String toSearch(){
		return TO_SEARCH;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toView(){
		try{
	  	//memberPassengerService.findById(memberPassengerVo.getId());
	  }
		catch(Exception e){
			log.error("",e);
		}
		return TO_VIEW;
	}

	/**
	 * get Servive
	 * @return
	 */
	public IMemberPassengerService getMemberPassengerServ() {
		return memberPassengerServ;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setMemberPassengerServ(IMemberPassengerService memberPassengerServ) {
		this.memberPassengerServ = memberPassengerServ;
	}

	/**
	 * get Vo
	 * @return
	 */
	public MemberPassengerVo getMemberPassengerVo() {
		return memberPassengerVo;
	}

	/**
	 * set Vo
	 * @return
	 */	public void setMemberPassengerVo(MemberPassengerVo memberPassengerVo) {
		this.memberPassengerVo = memberPassengerVo;
	}

	public List getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(List passengerlist) {
		this.passengerlist = passengerlist;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getCentType() {
		return centType;
	}

	public void setCentType(String centType) {
		this.centType = centType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPassengeridlist() {
		return passengeridlist;
	}

	public void setPassengeridlist(String passengeridlist) {
		this.passengeridlist = passengeridlist;
	}

	public String getXm_textfield() {
		return xm_textfield;
	}

	public void setXm_textfield(String xmTextfield) {
		xm_textfield = xmTextfield;
	}

	public String getZj_textfield() {
		return zj_textfield;
	}

	public void setZj_textfield(String zjTextfield) {
		zj_textfield = zjTextfield;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}