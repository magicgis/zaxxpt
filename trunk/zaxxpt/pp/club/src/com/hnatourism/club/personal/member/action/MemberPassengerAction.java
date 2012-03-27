package com.hnatourism.club.personal.member.action;

import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.common.web.BaseAction;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberPassengerService;
import com.hnatourism.club.personal.member.web.vo.MemberPassengerVo;
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
	private IMemberPassengerService memberPassengerService;
	// vo
  	private MemberPassengerVo memberPassengerVo;
  	private List passengerlist;
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
  	private String action="add";
  	//新加字段
  	private String address;
  	private String postcode;
  	
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
			
			MemberPassengerVo passenger=new MemberPassengerVo();
			passenger.setName(xm_textfield);
			passenger.setCertNo(zj_textfield);
			passenger.setCertType(centType);
			passenger.setSex(sex);
			passenger.setMobile(mobile);
			passenger.setEmail(email);
			passenger.setDisc(rmk);
			passenger.setAddress(address);
			passenger.setPostcode(postcode);
			passenger.setId(UUID.randomUUID().toString().replace("-", ""));
			passenger.setMemberId(UserUtil.getUser(getSession().getId()).getId());
			
			memberPassengerService.insert(passenger);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "success2";
		}
		
		return "success2";
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
			//如果参数pg_idlist是空
			if(passengeridlist==null){
				memberPassengerService.delete(id);//根据id删除常用地址
			}else{
				String[] pg_idlist=passengeridlist.split(", ");
				for(int i=0;i<pg_idlist.length;i++)
				{
					memberPassengerService.delete(pg_idlist[i]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "success2";
		}
		return "success2";
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
			
			MemberPassengerVo passenger=new MemberPassengerVo();
			passenger.setName(xm_textfield);
			passenger.setMobile(mobile);
			passenger.setId(id);
			if(rmk!=null){
				passenger.setCertType(centType);
				passenger.setCertNo(zj_textfield);
				passenger.setSex(sex);
				passenger.setEmail(email);
				passenger.setDisc(new String(rmk.getBytes("ISO8859-1"),"utf-8"));
			}else{
				passenger.setAddress(address);
				passenger.setPostcode(postcode);
			}
			memberPassengerService.update(passenger);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "success2";
		}
		return "success2";
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
			System.out.println(memberPassengerService);
			 Page page=memberPassengerService.findByMember(UserUtil.getUser(getSession().getId()).getId(),1);
			 passengerlist=page.getData();
			 pageInfo=page.getPageInfo();
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
			
			if(action.equalsIgnoreCase("upd"))
			{
				memberPassengerVo=(MemberPassengerVo)memberPassengerService.findById(id);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		return "toadd";
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
	  	//memberPassengerServiceice.findById(memberPassengerVo.getId());
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
	public IMemberPassengerService getmemberPassengerService() {
		return memberPassengerService;
	}

	/**
	 * set Servive
	 * @return
	 */
	public void setmemberPassengerService(IMemberPassengerService memberPassengerService) {
		this.memberPassengerService = memberPassengerService;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}