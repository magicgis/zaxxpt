<%@ page pageEncoding="UTF-8"%>
<%@page import="com.hnatourism.club.golf.api.ApiClient"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@page import="com.hnatourism.club.golf.prod.vo.GolfInfoVo"%>
<%@page import="com.hnatourism.club.golf.api.GsonUtil"%>
<%@page import="java.lang.reflect.Type"%>
<%@page import="com.hnatourism.club.lounge.prod.vo.LoungeRoomVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.hnatourism.club.golf.prod.vo.GolfSiteVo"%>
<%@ include file="/common/include/tags-lib.jsp"%>

<%
	String userid = "";
	if(null != UserUtil.getUser(request.getSession().getId())){
		 userid=UserUtil.getUser(request.getSession().getId()).getId();
	}
	request.setAttribute("userid",userid);

	String golf_json="";
	List<GolfInfoVo> golflist_image=null;
	String lounge_json="";
	List<LoungeRoomVo> roomlist=null;
	try
	{
		golf_json=new ApiClient().getHtml("/api/apiServer.action?method=api_findGolfInfoByRecommendProd");
		Type type_golf = new TypeToken<List<GolfInfoVo>>(){}.getType();
		golflist_image=(List<GolfInfoVo>)GsonUtil.jsonToObject(golf_json, type_golf);
		
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
		
		lounge_json=new ApiClient().getHtml("/api/apiServer.action?method=findLoungeInfoByComm");
		Type type_lounge = new TypeToken<List<LoungeRoomVo>>(){}.getType();
		roomlist=(List<LoungeRoomVo>)GsonUtil.jsonToObject(lounge_json, type_lounge);
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}
%>



<%@page import="com.hnatourism.framework.utils.StringUtils"%>
<%@page import="com.hnatourism.framework.utils.ListUtils"%>
<%@page import="com.hnatourism.club.common.util.UserUtil"%>
<script language="javascript" type="text/javascript">
function doClick(o){
o.className="on";
var j;
var id;
var e;
for(var i=1;i<=3;i++){
id ="nav"+i;
j = document.getElementById(id);
e = document.getElementById("sear"+i);
if(id != o.id){
j.className="off";
e.style.display = "none";
}else{
e.style.display = "block";
}
}
}

function redDetail(hotelcode){
	/*
	var time1=$("#plainDate1").val();
    if(time1==""){
    	time1 = dateStr1;
    }
    var time2=$("#plainDate2").val();
    if(time2==""){
      	time2 = dateStr2;
    }*/
    var today=new Date();
    var date2=new Date();
    date2.setTime(today.getTime()+86400000);
    time1=dateToStr(today);
    time2=dateToStr(date2);
	window.location.href = "${ctx}/hotel/view.jsp?hotelDetailsQueryVo.hotelCode="+hotelcode+"&hotelDetailsQueryVo.idate="+time1+"&hotelDetailsQueryVo.odate="+time2;
}

//date  to string
function dateToStr(date){
	var year=date.getFullYear();
	var month=date.getMonth();
	var day=date.getDate();
	var monthStr=month+1>=10?month+1:"0"+(month+1);
	var dayStr=day>=10?day:"0"+day;
	return year+"-"+monthStr+"-"+dayStr;
}
</script>
<div id="main">
    <div class="flash_bj"> 
        <!--img_show-->
        <div id="content" class="img_show">
            <div class="img_content">
                <ul>
                    <li><a href="${ctx}/subject/memberIntroduction.jsp#cardType_1"><img src="${ctx}/web/images/show_01.jpg" /></a><a href="${ctx}/subject/memberApply.jsp" class=" buyLinks"></a></li>
                    <li><a href="${ctx}/subject/memberIntroduction.jsp#cardType_2"><img src="${ctx}/web/images/show_02.jpg" /></a><a href="${ctx}/subject/memberApply.jsp" class=" buyLinks"></a></li>
                    <li><a href="${ctx}/subject/memberIntroduction.jsp#cardType_3"><img src="${ctx}/web/images/show_03.jpg" /></a><a href="${ctx}/subject/memberApply.jsp" class=" buyLinks"></a></li>
                    <li><a href="${ctx}/subject/memberIntroduction.jsp#cardType_4"><img src="${ctx}/web/images/show_04.jpg" /></a><a href="${ctx}/subject/memberApply.jsp" class=" buyLinks"></a></li>
                    <li><a href="subject/scoreExchange.jsp"><img src="${ctx}/web/images/show_05.jpg" /></a><a href="${ctx}/subject/memberApply.jsp" class=" buyLinks"></a></li>
                </ul>
            </div>
            <!--img_content End-->
            <ul class="img_caption">
                <li class="on">金管家<b></b></li>
                <li>白金管家<b></b></li>
                <li>钻石管家<b></b></li>
                <li>政企管家<b></b></li>
                <li>积分兑换<b></b></li>
            </ul>
            <!--img_content End--> 
            
        </div>
        <!--img_show End--> 
        
    </div>
    <div id="jcbottom1">
        <div class="home_tag">
            <div class="clear"></div>
            <div class="home_tag_content">
                <div class="home_left">
                    <ul>
                        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
                        <li class="home_tagbj">
                            <ul>
                                <li class="tag1"><a href="javascript:void(0);" class="on" id="nav1" onmouseover="doClick(this)"><img src="${ctx}/web/images/tag1.jpg" /></a></li>
                                <li class="tag2"><A href="javascript:void(0);" class="off" id="nav2" onmouseover="doClick(this)"><img src="${ctx}/web/images/tag2.jpg" /></A></li>
                                <li class="tag3"><A href="javascript:void(0);" class="off" id="nav3" onmouseover="doClick(this)"><img src="${ctx}/web/images/tag3.jpg" /></A></li>
                            </ul>
                        </li>
                        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
                    </ul>
                </div>
                <div class="jp_height clear" id="sear1" style="display:block;"> <img class="tag_img" src="${ctx}/web/images/img11.jpg" />
                    <dl class="TicketsInfo">
                        <dt>会员三折申请</dt>
                        <dd><b></b>金管家，一年1人次国内往返三折票</dd>
                        <dd><b></b>白金管家，一年2人次国内往返三折票</dd>
                        <dd><b></b>钻石管家，一年3人次国内往返三折票</dd>
                        <dd><a href="javascript:void(0);threeDiscountTicket()" >立即申请>></a></dd>
                    </dl>
                    <dl class="TicketsInfo noBG">
                        <dt>公务机申请</dt>
                        <dd>想要高效、专享、尊贵的公务机，那么在这里申请吧！我们为您打造专享公务机服务！</dd>
                        <dd><a href="javascript:void(0);addWish()" >立即申请>></a></dd>
                    </dl>
                </div>
                <div class="jp_height clear" id="sear2" style="display:none;" > 
                </div>
                <div class="jp_height clear" id="sear3" style="display:none;"> <img class="tag_img" src="${ctx}/web/images/img13.jpg" />
                    <ul class="tag_p w480">
                        <% 
                        	int index_gf=0;
                        if(!ListUtils.isEmpty(golflist_image)){
	                    	for(int i_gf=0;i_gf<golflist_image.size();i_gf++)
	                    	{
								GolfInfoVo golf_show=golflist_image.get(i_gf);
								//System.out.println("golf_show="=+golf_sho);
								//System.out.println("golf_show.getCityVo="=+golf_show.getCityVo());
								if(golf_show.getCityVo() == null){
									continue;
								}
	                    		if(index_gf<5)
	                    		{	
									//System.out.println("golf_show.getCityVo().getPcName()"+golf_show.getCityVo().getPcName());
	                    		%>
	                    		<li>
	                    			<% out.write("<a href='golf/search.jsp?id="+golf_show.getId()+"'>"+golf_show.getName());%></a>
	                    			<span class="city"><%=golf_show.getCityVo().getPcName()%></span>
	                    			<span style="width: 100px;"><tt>￥
	                    				<% 
	                    					if(golf_show.getMinPrice()!=null&&golf_show.getGolfsitelist()!=null)
	                    					{
		                    					if(golf_show.getGolfsitelist().size()>0)
		                    					{
		                    						GolfSiteVo site=golf_show.getGolfsitelist().get(0);
		                    						
		                    						if(site.getType()==1)
		                    						{
		                    							out.print(golf_show.getMinPrice().getPrice());%></tt>元/球<%
			                    						index_gf++;
		                    						}
		                    						else
		                    						{
		                    							if(golf_show.getMinHPrice()!=null)
			                    						{
			                    							if(golf_show.getMinPrice().getPrice()<golf_show.getMinHPrice().getPrice())
				                    						{
				                    							out.print(golf_show.getMinPrice().getPrice());%></tt>元/人<%
				                    						}
				                    						else
				                    						{
				                    							out.print(golf_show.getMinHPrice().getPrice());%></tt>元/人<%
				                    						}
			                    							index_gf++;
			                    						}
		                    						}
		                    					}
	                    					}
										%>
	                    			</span>
	                    		</li>
	                    		<%
	                    		}
	                    	}
	                    	}
	                    %>
                    </ul>
                </div>
            </div>
            <div class="home_right">
                <div class="home_mright">
                    <ul>
                        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
                        <li class="home_mright_bj"><img src="${ctx}/web/images/xxt.jpg" /></li>
                        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
                    </ul>
                </div>
                <div>
                    <ul class="mright_a">
                    <%
                    	int index_l=0;
                    if(!ListUtils.isEmpty(roomlist)){
                    	for(int i_l=0;i_l<roomlist.size();i_l++)
                    	{
                    		if(index_l<4)
                    		{
                    			LoungeRoomVo room_show=roomlist.get(i_l);
                    		 %>
                    		 	<li><b></b>
								<!-- <span class="linkText_1"> -->
                    		 <%
                    		 	//out.print(room_show.getLounge().getAirport().getName());
                    		 %>
							 <!-- </span> -->
								<span class="linkText_2" title="<%=room_show.getLounge().getName()%>">
	                 		 <%
	                 			out.print("<a href='loungeDetailAction!loungeDetail.action?id="+room_show.getLounge().getId()+"&airport="+room_show.getLounge().getAirportCode()+"'>"+room_show.getLounge().getName()+"</a>");
                    		 %>
	                 		 	</span><span class="linkText_4" style="width: 25%;">
	                 		 <%
	                 			out.print(room_show.getLoungePriceVo().getPrice());
		                 		if(room_show.getType().equalsIgnoreCase("1"))
								{
		                 			out.print("元/间");
	                 		 	}
	                 		 	else if(room_show.getType().equalsIgnoreCase("2"))
	                 		 	{
		                 			out.print("元/人");
	                 		 	}
	                 		 	else if(room_show.getType().equalsIgnoreCase("3"))
	                 		 	{
		                 			out.print("元/人");
	                 		 	}
                    		 %>
	                 		 	</span><span class="linkText_5">
	                 		 <%
	                 		 	if(room_show.getType().equalsIgnoreCase("1"))
								{
		                 			out.print("贵宾间");
	                 		 	}
	                 		 	else if(room_show.getType().equalsIgnoreCase("2"))
	                 		 	{
		                 			out.print("贵宾厅");
	                 		 	}
	                 		 	else if(room_show.getType().equalsIgnoreCase("3"))
	                 		 	{
		                 			out.print("两舱休息室");
	                 		 	}
                    		 %>
	                 		 	</span></li>
	                 		 <%
	                 			index_l++;
                    		}
                    	}
                    	}
                    %>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
    
</div>

<script type="text/javascript" language="javascript">
//广告轮播效果JS
$(function(){
	var len = $(".img_caption li").length;
	var index = 1;
	var adTimer;

	
	$(".img_caption li").mouseover(function(){
		var index = $(".img_caption li").index(this);
		showImg(index);
	});
				
	$(".img_show").hover(function(){
		clearInterval(adTimer)
	},function(){
		adTimer = setInterval(function(){
		showImg(index);
		index++;
		if(index==len){index=0;}
		},3000)
	}).trigger("mouseleave");
	
	//加载酒店推荐信息
	loadHotelRecomm();
	
});
function showImg(index){
	var img_height = $(".img_content").height();
	$(".img_content ul").stop(true,false).animate({top:-index*(img_height)},400);
	$(".img_caption li").eq(index).attr("class","on").siblings().removeClass();
};
//异步加载酒店信息推荐
function loadHotelRecomm(){
	$.ajax({
		   type: "POST",
		   url: "${ctx}/hotelInfoAction!findRecommInIndex.action",
		   dataType: "html",
		   success: function(data){
				$("#sear2").html(data);
		   }
	});
}
//三折票
function threeDiscountTicket(){
	if(null == '${userid}' || '' == '${userid}' || 'null' == '${userid}'){
				   var url="${ctx}/member/login.jsp";
			       window.location=url;
			       return;
	}
	var url="${ctx}/flight/discount.jsp";
	window.location=url;
}
//添加心愿
function addWish(){
	if(null == '${userid}' || '' == '${userid}' || 'null' == '${userid}'){
				   var url="${ctx}/member/login.jsp";
			       window.location=url;
			       return;
	}
	var url="${ctx}/flight/applybusiness.jsp";
	window.location=url;
}
</script>
