package com.hnatourism.club.golf.prod.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.reflect.TypeToken;
import com.hnatourism.club.common.util.UserUtil;
import com.hnatourism.club.golf.api.ApiClient;
import com.hnatourism.club.golf.api.GsonUtil;
import com.hnatourism.club.golf.prod.service.IGolfHomeService;
import com.hnatourism.club.golf.prod.vo.GolfInfoVo;
import com.hnatourism.club.golf.prod.vo.HnaProCityVo;
import com.hnatourism.club.personal.member.service.IMemberAccountService;
import com.hnatourism.club.personal.member.service.IMemberInfoService;
import com.hnatourism.club.personal.member.service.IMemberRoleService;
import com.hnatourism.club.personal.member.web.vo.MemberAccountVo;
import com.hnatourism.club.personal.member.web.vo.MemberInfoVo;
import com.hnatourism.club.personal.member.web.vo.MemberRoleVo;
import com.hnatourism.framework.utils.PropertiesUtils;
import com.hnatourism.framework.utils.StringUtils;
import com.hnatourism.framework.web.action.BaseAction;


/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:跳转到高尔夫首页
 * 
 * 历史版本: ${2011.8.2} v1.0.0 (${高杰}) 创建
 * 
 */
@SuppressWarnings("unchecked")
public class GolfHomeAction extends BaseAction
{
	private static final long serialVersionUID = 8922017842741135405L;

	private List<GolfInfoVo> golflist_image;//图片展示的球场
	private List<HnaProCityVo> citylist;//推荐城市列表
	private String serverPath;
	//高尔夫预订时间
	private String bookTime;
	
	
	@Autowired
	private IGolfHomeService golfHomeServ;
	public void setGolfHomeServ(IGolfHomeService golfHomeServ) {
		this.golfHomeServ = golfHomeServ;
	}
	private IMemberInfoService memberInfoServ;
	public void setMemberInfoServ(IMemberInfoService memberInfoServ) {
		this.memberInfoServ = memberInfoServ;
	}
	private IMemberAccountService memberAccountServ;
	public void setMemberAccountServ(IMemberAccountService memberAccountServ) {
		this.memberAccountServ = memberAccountServ;
	}
	private IMemberRoleService memberRoleServ;
	public void setMemberRoleServ(IMemberRoleService memberRoleServ) {
		this.memberRoleServ = memberRoleServ;
	}
	
	
	/**
	 * 高尔夫首页显示
	 */
	public String showGolfHome()
	{
		try
		{
			ApiClient client=new ApiClient();
			Type type_golf = new TypeToken<List<GolfInfoVo>>(){}.getType();
			Type type_city = new TypeToken<List<HnaProCityVo>>(){}.getType();
			
			String response = client.getHtml("/api/apiServer.action?method=api_findGolfInfoByRecommendProd");
			if(StringUtils.isNotEmpty(response) && response.indexOf("没有找到地址")>=0){
				response = null;
			}
			golflist_image=(List<GolfInfoVo>)GsonUtil.jsonToObject(response, type_golf);
			String cityResponse = client.getHtml("/api/apiServer.action?method=api_findHnaProCity_comm");
			if(StringUtils.isNotEmpty(cityResponse) && cityResponse.indexOf("没有找到地址")>=0){
				cityResponse = null;
			}
			citylist=(List<HnaProCityVo>)GsonUtil.jsonToObject(cityResponse, type_city);
			serverPath=PropertiesUtils.getVal("sysProps","resource.server.address");
			
			//排除非法数据
			List<GolfInfoVo> golf_image_result=new ArrayList<GolfInfoVo>();
			Iterator<GolfInfoVo> iterator_golf=golflist_image.iterator();
			while(iterator_golf.hasNext())
			{
				GolfInfoVo golf_image_temp=iterator_golf.next();
				if(golf_image_temp.getMinPrice()!=null)
				{
					golf_image_result.add(golf_image_temp);
				}
			}
			
			if(golf_image_result.size()>0)
			{
				golflist_image=golf_image_result;
			}
			
			List<HnaProCityVo> city_result=new ArrayList<HnaProCityVo>();
			Iterator<HnaProCityVo> iterator_city=citylist.iterator();
			while(iterator_city.hasNext())
			{
				HnaProCityVo city_temp=iterator_city.next();
				List<List<GolfInfoVo>> golf_result_part=new ArrayList<List<GolfInfoVo>>();
				List<GolfInfoVo> golf_result=new ArrayList<GolfInfoVo>();
				List<GolfInfoVo> golf_left_result=new ArrayList<GolfInfoVo>();
				List<GolfInfoVo> golf_right_result=new ArrayList<GolfInfoVo>();
				iterator_golf=city_temp.getGolflist().iterator();
				while(iterator_golf.hasNext())
				{
					GolfInfoVo golf_temp=iterator_golf.next();
					if(golf_temp.getMinPrice()!=null)
					{
						golf_result.add(golf_temp);
					}
				}
				
				//分左右显示
				if(golf_result.size()>0)
				{
					if(golf_result.size()%2==0)
					{
						for(int x=0;x<golf_result.size();x++)
						{
							if(x<golf_result.size()/2)
							{
								golf_left_result.add(golf_result.get(x));
							}
							else
							{
								golf_right_result.add(golf_result.get(x));
							}
						}
					}
					else
					{
						for(int x=0;x<golf_result.size();x++)
						{
							if(x<=golf_result.size()/2)
							{
								golf_left_result.add(golf_result.get(x));
							}
							else
							{
								golf_right_result.add(golf_result.get(x));
							}
						}
					}
					
					golf_result_part.add(golf_left_result);
					golf_result_part.add(golf_right_result);
					city_temp.setGolflist_result(golf_result_part);
					city_result.add(city_temp);
				}
			}
			citylist=city_result;
			
			if(ServletActionContext.getRequest().getParameter("source")!=null)
			 {
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				
				MemberInfoVo member=(MemberInfoVo)memberInfoServ.findById(request.getParameter("memid").toString());
				MemberAccountVo memberAccount=(MemberAccountVo)memberAccountServ.findByMember(member.getId());
				MemberRoleVo memberRole=(MemberRoleVo)memberRoleServ.findById(memberAccount.getRole());
				memberAccount.setMemberRole(memberRole);
				member.setMemberAccount(memberAccount);
				
				session.setAttribute("createUser", request.getParameter("createuser"));
				session.setAttribute("source", request.getParameter("source"));
				session.setAttribute("memberId", member.getId());
				UserUtil.set("sessionId", getSession().getId(),member);
				session.setAttribute("memberCode", member.getCode());
				session.setAttribute("cardNo", memberAccount.getCardNo());
			 }
			
			//显示预订日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new Date());
			bookTime=sdf.format(new Date());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "success";
		}
		
		return "success";
	}

	
	public List<GolfInfoVo> getGolflist_image() {
		return golflist_image;
	}
	public void setGolflist_image(List<GolfInfoVo> golflistImage) {
		golflist_image = golflistImage;
	}
	public List<HnaProCityVo> getCitylist() {
		return citylist;
	}
	public void setCitylist(List<HnaProCityVo> citylist) {
		this.citylist = citylist;
	}


	public String getServerPath() {
		return serverPath;
	}


	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}


	public String getBookTime() {
		return bookTime;
	}


	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
}
