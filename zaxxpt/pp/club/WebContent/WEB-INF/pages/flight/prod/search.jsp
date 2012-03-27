<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/web/js/city/style/city.css" rel="stylesheet" type="text/css" />
    <link href = "${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
    <link href = "${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/web/js/clubJs/avflights.js" language="javascript" type="text/javascript"></script>
    <script  src="${ctx}/web/js/clubJs/select3css.js" language="javascript" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/clubJs/select3css.js" language="javascript"></script>
    <script type="text/javascript" src="${ctx}/web/js/paging.js" ></script>
	<script type="text/javascript">
		var CTX='${ctx}';var isDisplayCity='Y';
		var pageName="search.jsp"; var specialInfoName="gospecialInfoJson";
		var returnFlag=false;
	</script>
    <script type="text/javascript" src="${ctx}/web/js/city/allAirport.js" ></script><!-- 用了 -->
	<script type="text/javascript" src="${ctx}/web/js/My97DatePicker/WdatePicker.js" ></script><!-- 用了 -->
    <script type="text/javascript" src="${ctx}/web/js/city/hotCity/hotCity.js"></script>
    <script type="text/javascript" src="${ctx}/common/include/weatherAjax.js"></script>
    <script type="text/javascript" src="${ctx}/flight/js/flightContrl.js"></script><!-- 机票的逻辑控制 -->
    <title><ap:write key='<%=request.getParameter("deAirport")%>' isDisplayCity="true"></ap:write>
    	  -<ap:write key='<%=request.getParameter("arAirport")%>' isDisplayCity="true"></ap:write>
    	  	机票查询 - ${domain_cn }
    </title>
	<style type="text/css">
		.theadHide tr{
			spadding-top: 0;
			padding-bottom: 0;
		}
		.module_a .inner{float:left}
	</style>
</head>
<body>
	<div class="senav">
        <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="#" class="se">首页</a> &gt; <a href="#" class="se">机票预订 &gt; </a>航班信息</li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    	</ul>
    </div>
<%@include file="/flight/controlSingle.jsp" %>
<div class="clear"></div>
<div class="search">
	<div class="search_left">
        <div class="searchform_frm">
                <div class="left_txt w1">出发城市：</div>
                <div class="r_form w2">
                	<div class="inb">
                        <!--<INPUT id="txtplain1" class="inps" onfocus="showSearch_Flight(this)" onkeyup="suggest_Flight.display(this,'departureAirportId',event)" " type="text" name=s"earchDepartureAirport">
                         <A class="set_city" href="javascript:suggest_Flight.display(this,'departureAirportId',event);"></A>--> 
            			<input name="deAirport" type="hidden" id="departureAirportId" value="<%=departureAirportCode%>" />             
            			<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="departureAirport" name="departureAirport" onblur="blurEvt(this)"
            			<% if(StringUtils.isBlank(departureAirportCode)){%>value="中文/拼音" style="color:#C1C1C1"<%} %>
            			onclick="suggest_Flight.display(this,'departureAirportId',event)"
            			onkeyup="suggest_Flight.display(this,'departureAirportId',event)"
            			value="<ap:write key="<%=departureAirportCode %>" isDisplayCity="true"></ap:write>" />
          				<!--   <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('departureAirport','departureAirportId',this,1,'city','airport')" />
          				-->
               		</div>
            	</div>
                <div class="left_txt w3">到达城市：</div>
                <div class="r_form w4">
                	<div class="inb">
                        <!-- <INPUT id="txtplain2" class="inps" onfocus="this.select();" onkeyup="PlainCheck();" value="<%=arrivalAirportCode%>" type="text" name=s"earchDepartureAirport">
                        <A class="set_city" href="javascript:citySelect.GetContentData('txtplain2');"></A> --> 
            			<input name="arAirport" type="hidden" id="arrivalAirportId" value="<%=arrivalAirportCode%>" />             
            			<input  type="text" class="inps" autoComplete="off" onfocus="showSearch_Flight(this)" id="arrivalAirport" name="arrivalAirport" onblur="blurEvt(this)"
           				<% if(StringUtils.isBlank(arrivalAirportCode)){%>value="中文/拼音" style="color:#C1C1C1"<%} %>
            			onclick="suggest_Flight.display(this,'arrivalAirportId',event)"
            			onkeyup="suggest_Flight.display(this,'arrivalAirportId',event)"
            			value="<ap:write key="<%=arrivalAirportCode%>" isDisplayCity="true"></ap:write>" />
          				<!--   <img src="${ctx}/web/images/btn_inputSlct.gif" width="16" height="16" class="set_city" onclick="setFillObj('arrivalAirport','arrivalAirportId',this,1,'city','airport')" />    
               			-->
                    </div>
            	</div>
                <div class="left_txt w5"></div>
                <div class="r_form w6">
                	<input type="radio" name="redio_searchFlight" value="1" id="danCheng" checked="checked">
                	<label for="danCheng"> 单程 </label>
                	&nbsp;&nbsp;
                	<input type="radio" name="redio_searchFlight" value="2" id="wangFan" >
                	<label for="wangFan"> 往返 </label>
            	</div>
                <div class="left_txt w1">出发时间：</div>
                <div class="r_form w2">
                	<div class=inb>
                        <input id="plainDate1" class="inps" type="text" onfocus="WdatePicker({minDate:'%y-%M-%d'})"  name="searchDepartureTime" value="<%=departureDate %>" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})" onchange="checkWhenBack()"/>
                    	<!--     <a class="set_date" href="javascript:WdatePicker({el:'plainDate1',maxDate:'#F{\'2050-10-01\'}',minDate:'%y-%M-%d'})"></a>
                    	-->
                    </div>
            	</div>
                <div class="left_txt w3 ReturnTime"><span>返程时间：</span></div>
                <div class="r_form w4 ReturnTime">
                	<div id="labPlain2" class="inb">
                    	<input id="plainDate2" class="inps" type="text" onfocus="WdatePicker({minDate:$('#plainDate1').val()})"  name="" value="<%=returnDate %>" onclick="WdatePicker({maxDate:'#F{\'2050-10-01\'}',minDate:$('#plainDate1').val()})"/>
                        <!--  <a class="set_date" href="javascript:WdatePicker({el:'plainDate2',maxDate:'#F{\'2050-10-01\'}',minDate:$('#plainDate1').val()})"></a>
                        -->
                    </div>
            	</div>
                <div class="btn"><input id="controlColor" class="submitBTN" type="button" onclick="searchFlight()"/></div>
		</div>
    </div>
<%--天气预报异步加载区域   --%>
<div id="tq_box" class="tq_box1"></div>
</div>
<div class="clear"></div>
<div id="btop" class="wfpj Wmargin">
        <div class="jp_hb_left w1">
        	<ap:write key="<%=departureAirportCode%>" isDisplayCity="true">
        	</ap:write> <%=dao%> <ap:write key="<%=arrivalAirportCode%>" isDisplayCity="true"></ap:write>
        </div>
        <div class="jp_hb_right w2">
        	<%if(!flightIsNullFlag){%>
        		出发日期：<%=departureDate%>（共<span class="red"><%=flightList.size()%></span>个航班信息）
        	<%}%>
        </div>
</div>
<!--Filter -->
<ul class="FilterSelectBox clearfix_">
		<li> <span class="left">航空公司：</span>
	        <div id="tm2010style" class="left select_box_people">
	             <select name="Room" id="Room">
	                <option value="">不限</option>
	                <%
	                Iterator<String> companyIterator = setCompany.iterator();
	                while(companyIterator.hasNext()){
	                	String comCode = companyIterator.next();
	                %>
	               	<option value="<%=comCode%>"><al:write key="<%=comCode%>"/></option>
	                <%} %>
	            </select>
	        </div>
	    </li>
	    <li> <span class="left marginL40">起飞时间：</span>
	        <div id="tm2010style" class="left select_box_people">
	            <select name="language_tm2010" id="language_tm2010">
	                <option value="">不限</option>
	                <option value="00:00-06:00">00:00-06:00</option>
	                <option value="06:00-12:00">06:00-12:00</option>
	                <option value="12:00-18:00">12:00-18:00</option>
	                <option value="18:00-24:00">18:00-24:00</option>
	            </select>
	    	</div>
	    </li>
</ul>
<!--Filter end--> 
<!--list-->
<div class="main980">
	<div class="module_a Order">
	  	   <%
	         if(flightIsNullFlag){
	       %>
	        <div class="inner  go_mod_ticket list marginT_1" " id="FlightOut">
	        	<table id="flightListTable">
	              <tr  class='Tickets'><td colspan='9'>
	                <b>非常抱歉，没有符合您查询条件的航班，或此出发日期的舱位已售完。   建议您选择其他出发日期进行查询。</b><br/><br/> 如有疑问请致电 ${site_tel}。</td></tr>
	            </table>
	        </div>
	       <%}else {%>
	        <div class="title" id="AllDataTitle">
	        	<span class="l"></span>
	        	<div class="c go_mod_ticket">
	            <table>
	                <thead>
	                    <tr>
	                        <th class="airline">航空公司/航班</th>
	                        <!-- 4种状态 air_up air_down air_current_up air_current_down -->
	                        <th class="airtime">起降时间</th>
<!--	                        <th class="airtime"><a id="depTimeSorter"  href="javascript:void(0);" class="air_up">起降时间<b></b></a></th>-->
	                        <th class="airport">起降机场</th>
	                        <th class="airplane">机建/燃油</th>
	                        <th class="airprice">舱位</th>
	                        <th class="airminprice">票面价</th>
	                        <th class="airdis">优惠幅度</th>
	                        <th class="airorder">会员价</th>
<!--	                        <th class="airorder"><a id="payPriceSorter" href="javascript:void(0);" class="air_up2">会员价<b></b></a></th>-->
	                        <th class="vip">会员特价机票申请区</th>
	                    </tr>
	                </thead>
	           	 </table>
	            </div>
	            <span class="r"></span>
	         </div>
        <%--					迭代所有的航班信息--%>
			<%for(int i=0;i<flightList.size();i++){
				FlightInfoVo flightInfoVo=flightList.get(i);
			%>
        	<div class="inner  go_mod_ticket list marginT_1" id="allDataDiv" name="allDataDiv">
        		<table>
        			<thead class="c go_mod_ticket">
<%--        				虚拟存在的表头,用于保持页面对齐 --%>
						<tr class="theadHide">
							<th class="airline" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airtime" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airport" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airplane" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airprice" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airminprice" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airdis" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="airorder" style="padding-top: 0; padding-bottom: 0;"></th>
							<th class="vip" style="padding-top: 0; padding-bottom: 0;" colspan="2"></th>
						</tr>
	                </thead>
	            	<tbody>
						<tr class="Tickets">
							<td class="airline">
								<span class="airlogo airlogo_hu">
                					<img src="${ctx}/web/images/32_32/icon_airport<%=flightInfoVo.getAirlineCompanyCode()%>.gif">
                				</span>
		                		<%=flightInfoVo.getAirlineCompany()%><br />
		                    	<%=flightInfoVo.getAirlineCompanyCode()%><%=flightInfoVo.getFlightNo()%>
							</td>
							<td class="airtime">
								<strong><%=flightInfoVo.getDepartureTime()%></strong><br />
								<strong><%=flightInfoVo.getArrivalTime()%></strong>					
							</td>
							<td class="airport">
								<ap:write key="<%=flightInfoVo.getDepartureAirport()%>" /><%= flightInfoVo.getDepartureTerminal() == null || "".equals(flightInfoVo.getDepartureTerminal())? "" : "[" + flightInfoVo.getDepartureTerminal() + "]"%><br />
	                        	<ap:write key="<%=flightInfoVo.getArrivalAirport()%>"  /><%= flightInfoVo.getArrivalTerminal() == null || "".equals(flightInfoVo.getArrivalTerminal())? "" : "[" + flightInfoVo.getArrivalTerminal() + "]"%>							
							</td>
							<td class="airplane">
								<%=flightInfoVo.getConstructionFee()%>/<%=flightInfoVo.getAdultBaf()%>
							</td>
							<td class="airprice">
								<%FlightCabinInfoVo cabinInfoVo=flightInfoVo.getFlightCabinInfoVo(); 
								String cabinDiscount="";
								if(!"null".equals(cabinInfoVo.getCabinDiscount())&&null!=cabinInfoVo.getCabinDiscount()&&!"".equals(cabinInfoVo.getCabinDiscount())){
								cabinDiscount = new BigDecimal(cabinInfoVo.getCabinDiscount()).multiply(new BigDecimal(10)).toBigInteger().toString();
								}
								List<FlightCabinInfoVo> cabinInfoVoList=flightInfoVo.getFlightCabinInfoVoList();
								//计算分润
								calculateSubRun(cabinInfoVo);
								%>
								<%=cabinInfoVo.getCabinName()%>
								(<span><%=cabinDiscount%>%/</span><%=cabinInfoVo.getCabinCode()%>)<br /> 
								座位数 <%="A".equals(cabinInfoVo.getCabinSeatNum())?"&gt;9":cabinInfoVo.getCabinSeatNum()%>
								<br>
								<a href="#" class="orangea Tickets_TG">退改签</a>
								<div class="Tickets_TGBox"><%=cabinInfoVo.getChangeInfo()%></div>
							</td>
							<td class="airminprice">
								<strong><span class="yen">¥</span><%=cabinInfoVo.getAdultTicketPricePar()%></strong><br />	
								<% if(!ListUtils.isEmpty(cabinInfoVoList)){ %>  
									<a class="jp_qbjg more_btn" href="#">全部价格</a>
								<%} %>						
							</td>
							<td class="airdis" title="<%=cabinInfoVo.getCommissionRate()%>">
								<%=cabinInfoVo.getCommissionRate()%>%
							</td>
							<td class="airorder" id="commonDataTd<%=i%>">
								<strong>
									<span class="yen red">¥</span>
									<strong  class="red"><%=cabinInfoVo.getAdultTicketPrice()%></strong>
								</strong><br />
								<a class="Btn63_24" href="javascript:void(0);" onclick="bookingFlight({bookButton:$(this),type:1});return false;"><%=bookingName%></a>
								<input type="hidden" name="adultTicketPrice" value="<%=cabinInfoVo.getAdultTicketPrice()%>"/>
								<input type="hidden" name="gdepartureTime" value="<%=flightInfoVo.getDepartureTime()%>"/>
								<input type="hidden" name="gairlineCompanyCode" value="<%=flightInfoVo.getAirlineCompanyCode()%>"/>
								<input type="hidden" name="garrivalTime" value="<%=flightInfoVo.getArrivalTime()%>"/>
								<input type="hidden" name="commonDataId" value="commonDataTd<%=i%>">
								<input type="hidden" class="commonDataInput"  name="goflightInfoJson" value="<%=flightVoToJson(flightInfoVo)%>"/>
								<input type="hidden" class="uniqueDataInput"  name="gocabinInfoJson" value="<%=cabinVoToJson(cabinInfoVo)%>"/>
							</td>
							<%--id 为vip航班号_舱位号 为方便以后查找这个单元格使用     如 vipMU1000_F --%>
							<td class="vip" id="vip<%=flightInfoVo.getAirlineCompanyCode()+flightInfoVo.getFlightNo()+"_"+cabinInfoVo.getCabinCode()%>">
								
							</td>
							<td class="vip2"></td>
						</tr>
<%--						迭代所有舱位的信息--%>
						<%if(!ListUtils.isEmpty(cabinInfoVoList)){%>
						<tr id="" class="more_Tickets" style="display: table-row;">
							<td id="" colspan="10">
								<div class="all_rebate">
								<p>
									<span class="icon_arrow"></span>
<!--									<a class="icon_close" href="#" title="关闭">关闭</a>-->
								</p>
									<table>
										<thead>
											<tr class="theadHide">
												<th class="airline" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airtime" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airport" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airplane" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airprice" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airminprice" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airdis" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="airorder" style="padding-top: 0; padding-bottom: 0;"></th>
												<th class="vip" style="padding-top: 0; padding-bottom: 0;" colspan="2"></th>
											</tr>
										</thead>
										<tbody>
											<%for(int j=0;j<cabinInfoVoList.size();j++){
												FlightCabinInfoVo cabinInfoVoHide=cabinInfoVoList.get(j);
												//计算分润
												calculateSubRun(cabinInfoVoHide);
											%>
												<tr id="">
													<td class="airline"></td>
													<td class="airtime"></td>
													<td class="airport"></td>
													<td class="airplane"></td>
													<td class="airprice">
														<%=cabinInfoVoHide.getCabinName()%>
						                           		<%
						                      				String inCabinDiscount = "";
						                      				if(!"null".equals(cabinInfoVoHide.getCabinDiscount())&&null!=cabinInfoVoHide.getCabinDiscount()&&!"".equals(cabinInfoVoHide.getCabinDiscount())){
						                      					inCabinDiscount =  new BigDecimal(cabinInfoVoHide.getCabinDiscount()).multiply(new BigDecimal(10)).toBigInteger().toString();
						                      				}
						                      			%>
						                                (<span><%=inCabinDiscount%>%/</span><%=cabinInfoVoHide.getCabinCode()%>)<br/>
						                                                                                      座位数 <%="A".equals(cabinInfoVoHide.getCabinSeatNum())?"&gt;9":cabinInfoVoHide.getCabinSeatNum()%><br/>
						                                <a href="#" class="orangea Tickets_TG">退改签</a>
						                                <div class="Tickets_TGBox"><%=cabinInfoVoHide.getChangeInfo()%></div>														
													</td>
													<td class="airminprice">
														<strong><span class="yen">¥</span><%=cabinInfoVoHide.getAdultTicketPricePar()%></strong>		
													</td>
													<td class="airdis" title="<%=cabinInfoVoHide.getCommissionRate()%>"><%=cabinInfoVoHide.getCommissionRate()%>%</td>
													<td class="airorder">
														<strong class="red"><span class="yen red">¥</span><%=cabinInfoVoHide.getAdultTicketPrice()%></strong><br />
														<a class="Btn63_24" href="javascript:void(0);" onclick="bookingFlight({bookButton:$(this),type:2});return false;" ><%=bookingName%></a>
														<input type="hidden" name="adultTicketPrice" value="<%=cabinInfoVoHide.getAdultTicketPrice()%>"/>
														<input type="hidden" name="commonDataId" value="commonDataTd<%=i%>">
														<input type="hidden" class="uniqueDataInput"  name="gocabinInfoJson" value="<%=cabinVoToJson(cabinInfoVoHide)%>"/>
													</td>
													<td class="vip" id="vip<%=flightInfoVo.getAirlineCompanyCode()+flightInfoVo.getFlightNo()+"_"+cabinInfoVoHide.getCabinCode()%>">
													</td>
													<td class="vip2"></td>
												</tr>
											<%}%>
										</tbody>
									</table>
								</div>
							</td>
						</tr>
						<%} %>
						</tbody>
	          			</table>
					</div>
					<%}%>
<%--					<div id="allDataTail" style="display: none;"></div>--%>
	       <%} %>
	</div>  
</div> 
<%
if(!StringUtils.isEmpty(beforeDateStr)&&!StringUtils.isEmpty(afterDateStr)){
%>
<div class="Wmargin tijiao_frm">
	<a href="javascript:void(0);" class="beforeday" onclick="beforeDate('<%=beforeDateStr%>','<%=yesterday%>')"><%=beforeDateStr%> </a>
	<a href="javascript:void(0);" class="nextday"  onclick="afterDate('<%=afterDateStr%>')"><%=afterDateStr%> </a>
	<a href="javascript:void(0);" id="gotoTop"><img src="${ctx}/web/images/bottomtop.jpg" width="51" height="32" /></a>
</div>
<%
}
%>  
<form action="" method="post" id="flightSearchForm">
	<input type="hidden" value="" id="bookingGoFlightVoJsonQ" name="bookingGoFlightVoJson">
</form>
<form action="${ctx}/flight/book.jsp" method="post" id="flightBookForm">
	<input type="hidden" name="flightType" value="<%=flightType%>" id="flightType"/>
	<input type="hidden" name="deAirport" value="<%=departureAirportCode%>" id="departureAirportCode"/>  
	<input type="hidden" name="arAirport" value="<%=arrivalAirportCode%>" id="arrivalAirportCode"/>   
	<input type="hidden" name="departureDate" value="<%=departureDate%>" id="departureDate"/> 
	<input type="hidden" name="returnDate" value="<%=returnDate%>"/>
	<%--特价信息的json ,舱位信息的json ,特价信息的json --%>
	<input type="hidden" class="commonDataInput"  name="goflightInfoJson" id="flightInfoJson" value=""/>
	<input type="hidden" class="uniqueDataInput"  name="gocabinInfoJson" id="cabinInfoJson" value=""/>
	<input type="hidden" class="specialDataInput" name="gospecialInfoJson" id="specialInfoJson" value=""/>
</form>
<script type="text/javascript">
function bookingFlight(param){
	var flightType = $("#flightType").val();
	// 选择数据存放单元格
	var button=param.bookButton;
	var commonDataTd=null;// 公共数据存放的单元格
	var uniqueDataTd=null;// 特有数据存放的单元格
	var specialDataTd=null;//特价
	if(param.type==1){
		 commonDataTd=button.parent();
		 uniqueDataTd=button.parent();
	}else if(param.type==2){
		uniqueDataTd=button.parent();
		commonDataTd=$("#"+uniqueDataTd.find("input[name='commonDataId']").val());
	}else if(param.type==3){
		specialDataTd=button.parent();
		uniqueDataTd=specialDataTd.siblings(".airorder");
		commonDataTd=$("#"+uniqueDataTd.find("input[name='commonDataId']").val());
	}
// 获取数据
	if(commonDataTd&&uniqueDataTd){
		var flightSubmitForm=$("#flightBookForm");
		// 自动封装参数
		//公共信息
		flightSubmitForm.find(".commonDataInput").each(function(){
			var input=$(this);
			input.val(commonDataTd.find("input[name='"+input.attr("name")+"']").val());
		});
		//舱位特有信息
		flightSubmitForm.find(".uniqueDataInput").each(function(){
			var input=$(this);
			input.val(uniqueDataTd.find("input[name='"+input.attr("name")+"']").val());
		});
		//特价舱位信息
		if(param.type==3){
			flightSubmitForm.find(".specialDataInput").each(function(){
				var input=$(this);
				input.val(specialDataTd.find("input[name='"+input.attr("name")+"']").val());
			});
		}
		if(flightType=="2"){// 往返
			flightSubmitForm.attr("action", CTX+"/flight/searchReturn.jsp");
		}
		
		flightSubmitForm.submit();
	}
}
</script>
</body>
