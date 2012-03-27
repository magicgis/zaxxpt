<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/select3css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/web/js/clubJs/select2css.js" language="javascript"></script>
<title>机场休息室订单填写- 机场休息室预订 - ${domain_cn }</title>

<script type="text/javascript">
	var status="false";
	function valForm()
	{
		var starttimeview=document.getElementById("StartTime");
		var starttime=starttimeview.value;
		if(starttime=="")
		{
			alert("开始时间不能为空！！！！！");
			starttimeview.focus();
			return;
		}
		if(document.getElementById("roomType").value==1)
		{
			var endtimeview=document.getElementById("EndTime");
			var endtime=endtimeview.value;
			if(endtime=="")
			{
				alert("结束时间不能为空！！！！！");
				endtimeview.focus();
				return;
			}
			else
			{
				starttime=starttime.substring(0,starttime.indexOf(':'));
				endtime=endtime.substring(0,endtime.indexOf(':'));
				
				if(parseInt(starttime)>=parseInt(endtime))
				{
					alert("预订的结束时间必须晚于开始时间！！！！！");
					endtimeview.focus();
					return;
				}
			}
		}
		
		if(document.getElementById("amountPrice").value=="0")
		{
			alert("总价格数值不规范！！！！！");
			return;
		}
		
		var contactNameView=document.getElementById("loginerName");
		var contactName=document.getElementById("loginerName").value;
		if(contactName==""||contactName.length>50)
		{
			alert("联系人姓名不规范！！！！！");
			contactNameView.focus();
			return;
		}
		else
		{
			for(var index=0;index<contactName.length;index++)
			{
				if(contactName.charCodeAt(index)>8&&contactName.charCodeAt(index)<47)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactNameView.focus();
					return;
				}
				else if(contactName.charCodeAt(index)>47&&contactName.charCodeAt(index)<65)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactNameView.focus();
					return;
				}
				else if(contactName.charCodeAt(index)>90&&contactName.charCodeAt(index)<97)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactNameView.focus();
					return;
				}
				else if(contactName.charCodeAt(index)>122&&contactName.charCodeAt(index)<255)
				{
					alert("联系人姓名包含非法字符！！！！！");
					contactNameView.focus();
					return;
				}
			}
		}
		var rule=/^(0(\d){1,3})([ ]?|[-]?)((\d){8})$/;
		if(!rule.exec(document.getElementById("loginerContact").value))
		{
			rule=/^(\d){11}$/;
			if(!rule.exec(document.getElementById("loginerContact").value))
			{
				alert("联系人联系方式不规范！！！！！");
				document.getElementById("loginerContact").focus();
				return;
			}
		}
		rule=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(!rule.exec(document.getElementById("loginerEmail").value))
		{
			alert("邮箱地址填写不规范！！！！！");
			document.getElementById("loginerEmail").focus();
			return;
		}
		
		var people_name_list="";
		var people_list=document.getElementById("select_box_people").childNodes;
		for(var i=0;i<people_list.length;i++)
		{
			if(people_list[i].nodeName=="LI")
			{
				var people_info_list=people_list[i].childNodes;
				for(var x=0;x<people_info_list.length;x++)
				{
					if(people_info_list[x].nodeName=="SPAN")
					{
						var people_info_list_each=people_info_list[x].childNodes;
						for(var y=0;y<people_info_list_each.length;y++)
						{
							if(people_info_list_each[y].nodeName=="INPUT")
							{
								if(people_info_list_each[y].name=="passengerName")
								{
									if(people_info_list_each[y].value==""||people_info_list_each[y].value.length>30||people_info_list_each[y].value.length<2)
									{
										alert("客人姓名长度不规范！！！！！");
										people_info_list_each[y].focus();
										return;
									}
									for(var index=0;index<people_info_list_each[y].value.length;index++)
									{
										if(people_info_list_each[y].value.charCodeAt(index)>8&&people_info_list_each[y].value.charCodeAt(index)<47)
										{
											alert("客人姓名包含非法字符！！！！！");
											people_info_list_each[y].focus();
											return;
										}
										else if(people_info_list_each[y].value.charCodeAt(index)>47&&people_info_list_each[y].value.charCodeAt(index)<65)
										{
											alert("客人姓名包含非法字符！！！！！");
											people_info_list_each[y].focus();
											return;
										}
										else if(people_info_list_each[y].value.charCodeAt(index)>90&&people_info_list_each[y].value.charCodeAt(index)<97)
										{
											alert("客人姓名包含非法字符！！！！！");
											people_info_list_each[y].focus();
											return;
										}
										else if(people_info_list_each[y].value.charCodeAt(index)>122&&people_info_list_each[y].value.charCodeAt(index)<255)
										{
											alert("客人姓名包含非法字符！！！！！");
											people_info_list_each[y].focus();
											return;
										}
									}
									if(people_name_list.indexOf(","+people_info_list_each[y].value+",")>=0)
									{
										alert("客人姓名不能重复，请自行添加标识区分！！！！！");
										people_info_list_each[y].focus();
										return;
									}
									people_name_list=people_name_list+","+people_info_list_each[y].value+",";
								}
								else
								{
									rule=/^[A-Za-z0-9]+$/;
									if(!rule.exec(people_info_list_each[y].value))
									{
										alert("客人航班号不规范！！！！！");
										people_info_list_each[y].focus();
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		var passengerinfo="";
		var ts=$(".tag_select");
		var coun=GetClass("input2").length;
		//$("#select_box_people").children("#passengerlist").children("div").children("select").each(function()
		for(var i=0;i<coun;i++){
			passengerinfo=passengerinfo+","+ts[i*2+1].innerHTML+","+ts[(i+1)*2].innerHTML;
        }
		document.getElementById("passengerInfo").value=passengerinfo;
		
		if(status=="false")
		{
			document.forms.loungeForm.submit();
			status="true";
		}
	}
	
	// 计算小时数
	function countHour(){
        var StartTime=$("#StartTimeUL li").index($("#StartTimeUL li.Selected"));
        var EndTime=$("#EndTimeUL li").index($("#EndTimeUL li.Selected"));
        return EndTime-StartTime;
    }

	function showPlayerInputOne()
	{
		var price=0;
		var price_reg=0;
		var adult_price=document.getElementById("price").value;
		var child_price=document.getElementById("childrenPrice").value;
		var adult_price_reg=document.getElementById("price_reg").value;
		var child_price_reg=document.getElementById("cprice_reg").value;
		var people_list=document.getElementById("select_box_people").childNodes;
		if(people_list[i].nodeName=="LI")
		{
			var people_info_list=people_list[i].childNodes;
			for(var x=0;x<people_info_list.length;x++)
			{
				if(people_info_list[x].nodeName=="DIV")
				{
					var people_info_list_each=people_info_list[x].childNodes;
					for(var y=0;y<people_info_list_each.length;y++)
					{
						var adultchild=people_info_list_each[y];
						
						if(adultchild.nodeName=="SELECT")
						{
							var adultorchild=adultchild.options[adultchild.selectedIndex].text;
							if(adultorchild=="成人")
							{
								price=price+parseFloat(adult_price);
								price_reg=price_reg+parseFloat(adult_price_reg);
							}
							else if(adultorchild=="儿童")
							{
								price=price+parseFloat(child_price);
								price_reg=price_reg+parseFloat(child_price_reg);
							}
						}
					}
				}
			}
		}
	}
	
	function show_Price(price,type)
	{
		var num = new Number(price);
		if(type=="profit")
		{
			document.getElementById("amountPrice").value=num.toFixed(2);
			document.getElementById("amountPriceShow").innerHTML=num.toFixed(0)+"元";//显示时只显示整数
		}
		else if(type=="reg")
		{
			document.getElementById("amountPrice_reg").value=num.toFixed(2);
		}
	}
	
	function cal_adultchild()
	{
		var price=0;
		var price_reg=0;
		var adult_price=document.getElementById("price").value;
		var child_price=document.getElementById("childrenPrice").value;
		var adult_price_reg=document.getElementById("price_reg").value;
		var child_price_reg=document.getElementById("cprice_reg").value;
		//var people_list=document.getElementById("select_box_people").childNodes;
		var coun=GetClass("input2").length;
		for(var i=0;i<coun;i++)
		{
			//if(people_list[i].nodeName=="LI")
			//{
				//var people_info_list=people_list[i].childNodes;
				//for(var x=0;x<people_info_list.length;x++)
				//{
					//if(people_info_list[x].nodeName=="DIV")
					//{
						//var people_info_list_each=people_info_list[x].childNodes;
						//for(var y=0;y<people_info_list_each.length;y++)
						//{
							//var adultchild=people_info_list_each[y];
							
							//if(adultchild.nodeName=="SELECT")
							//{
								//var adultorchild=adultchild.options[adultchild.selectedIndex].text;
								var ts=$(".tag_select");
								if(ts[i*2+1].innerHTML=="成人")
								{
									price=price+parseFloat(adult_price);
									price_reg=price_reg+parseFloat(adult_price_reg);
								}
								else if(ts[i*2+1].innerHTML=="儿童")
								{
									price=price+parseFloat(child_price);
									price_reg=price_reg+parseFloat(child_price_reg);
								}
							//}
							//alert(price+"===="+i);
						//}
					//}
				//}
			//} 
		}
		
		show_Price(price,"profit");
		show_Price(price_reg,"reg");
	}
	
	//总价清零
	function set_Zero()
	{
		show_Price("0","profit");
		show_Price("0","reg");
	}
	
	//计算按单价格
	function set_Order()
	{
		var price=parseFloat(countHour())*parseFloat(document.getElementById("price").value);
		var price_reg=parseFloat(countHour())*parseFloat(document.getElementById("price_reg").value);
		show_Price(price,"profit");
		show_Price(price_reg,"reg");
	}
	
	//计算按人价格
	function set_Man()
	{
		//var peoplenum=document.getElementById("people");
		//var price=parseFloat(peoplenum.options[peoplenum.selectedIndex].value)*parseFloat(document.getElementById("price").value);
			cal_adultchild();
		//show_Price(price);
	}
	
	//计算单收费价格
	function set_Addition()
	{
		var additionview=document.getElementById("additionshowlist");
		var children=additionview.getElementsByTagName("INPUT");
		var additionprice=0;
		for(var i=0;i<children.length;i+=3)
		{
			if(children[i].checked)
			{
				var id_price=children[i].getAttribute("value");
				var id_way=children[i+1].getAttribute("value");
				var id=id_price.substring(0,id_price.indexOf("_"));
				var price=id_price.substring(id_price.indexOf("_")+1);
				var way=id_way.substring(id_way.indexOf("_")+1);
				if(way=="1")
				{
					additionprice=parseFloat(additionprice)+parseFloat(price);
				}
				else
				{
					var peoplenum=document.getElementById("people");
					//peoplenum.options[peoplenum.selectedIndex]
					additionprice=parseFloat(additionprice)+parseFloat(document.getElementById("select_info_people").innerHTML)*parseFloat(price);
				}
			}
		}
		
		var price_amount=document.getElementById("amountPrice").value;
		price_amount=parseFloat(price_amount)+parseFloat(additionprice);
		show_Price(price_amount,"profit");
		show_Price(price_amount,"reg");
	}
	
	
	function chooseAddition()
	{
		if(document.getElementById("way").value=="1")
        {
			if(countHour()>0)
			{
				set_Order();
				set_Addition();
			}
			else
			{
				set_Zero();
			}
		}
		else
		{
			set_Man();
			set_Addition();
		}
	}
	
	
	function changeAdultChildren(action)
	{
		cal_adultchild();
	}

	

	//根据class获取节点 
	function GetClass(className)
	{return getElementsByClassName(className)} 

	var $c=function(array){
	var nArray = [];
	for (var i=0;i<array.length;i++) nArray.push(array[i]);
	return nArray;
	};
	 
	Array.prototype.each=function(func){
	for(var i=0,l=this.length;i<l;i++) 
	{func(this[i],i);};}; 

	var getElementsByClassName=function(cn){ 
	var hasClass=function(w,Name){ 
	var hasClass = false; 
	w.className.split(' ').each(function(s){ 
	if (s == Name) hasClass = true; 
	}); 
	return hasClass; 
	}; 
	var elems =document.getElementsByTagName("*")||document.all; 
	var elemList = []; 
	$c(elems).each(function(e){ 
	if(hasClass(e,cn)){elemList.push(e);} 
	}) 
	return $c(elemList); 
	}; 
</script>


</head>
<body>
<div class="clear"></div>
<div class="senav">
    <ul>
        <li><img src="${ctx}/web/images/seleft.jpg" /></li>
        <li class="sebj"><a href="${ctx}" class="se">首页</a> &gt;&nbsp; <a href="${ctx}/lounge/index.jsp" class="se">机场休息室首页</a> &gt;&nbsp; <span class="se1">机场休息室预订   &gt;&nbsp; <f:write type="休息室类型" value='${bookRoom.type}'></f:write></span><span class="wxts">温馨提示：建议起飞前一小时到达！</span></li>
        <li><img src="${ctx}/web/images/seright.jpg" /></li>
    </ul>
</div>
<div class="main980"> 
    <!--Module-->
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c">预订机场信息</span><span class="r"></span></div>
        <div class="inner clearfix_">
            <ul class="clearfix_ x3">
                <li><span class="t"><s:property escape="false" value="bookRoom.lounge.name"/></span></b></li>
                <li>到达日期：<b><s:property value="bookTime_show"/></b></li>
                <li>价格：<b class="jp_jq">
                <s:iterator value="bookRoom.pricelist" var="price">
	            <s:if test='#price.type!="S"'>
	            	<s:property escape="false" value="#price.price"/>
	            </s:if>
	            </s:iterator>
	            <s:if test="bookRoom.type==1">
	            	元/时
	            </s:if>
	            <s:else>
	            	元/人
	            </s:else>
                </b></li>
            </ul>
            <ul class="clearfix_ x3">
            <s:if test="bookRoom.type==1">
                <li>休息室类型：<b><s:property value="bookRoom.roomType"/>人间</b></li>
            </s:if>
                <li>机场：<b><s:property escape="false" value="bookRoom.lounge.airport.name"/></b></li>
            </ul>
            <ul class="clearfix_ Uncertain">
            	<li>免费项目：<b>
            	<f:write2 type="L包含项目" value="${bookRoom.loungePriceVo.item}" regexValue=","></f:write2>
                </b></li>
            </ul>
            <ul class="clearfix_ Uncertain"><li>单买项目：<b>&nbsp;
            <s:iterator value="bookRoom.pricelist" var="price">
            <s:if test='#price.type=="S"'>
            	<s:property escape="false" value="#price.item"/>；
            </s:if>
            </s:iterator>
            </b></li></ul>
            <div class="separated_line"></div>
            <ul class="clearfix_ x2">
                <li><span class="t">退改规则</span></li>
            </ul>
            <ul class="h25"><li><s:property escape="false" value="bookRoom.rmk"/></li></ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
    <!--Module-->
    <s:form name="loungeForm" id="loungeForm" action="addLoungeOrder" method="post">
    	<input type="hidden" name="airportName" id="airportName" value="<s:property escape="false" value="bookRoom.lounge.airport.name"/>"/>
    	<input type="hidden" name="rmk" id="rmk" value="<s:property escape="false" value="bookRoom.rmk"/>"/>
    	<input type="hidden" name="amountPrice" id="amountPrice" value="0"/>
    	<input type="hidden" name="amountPrice_reg" id="amountPrice_reg" value="0"/>
    	<input type="hidden" name="flightNo" id="flightNo" value="<s:property escape="false" value="bookRoom.lounge.airportCode"/>"/>
    	<input type="hidden" name="roomType" id="roomType" value="<s:property value="bookRoom.type"/>"/>
    	<input type="hidden" name="roomid" id="roomId" value="<s:property value="roomid"/>"/>
    	<input type="hidden" name="childrenPrice" id="childrenPrice" value="<s:property value="bookRoom.loungePriceVo.childrenPrice"/>"/>
    	<input type="hidden" name="price" id="price" value="<s:property value="bookRoom.loungePriceVo.price"/>"/>
    	<input type="hidden" name="signingPrice" id="signingPrice" value="<s:property value="bookRoom.loungePriceVo.signingPrice"/>"/>
    	<input type="hidden" name="price_reg" id="price_reg" value="<s:property value="bookRoom.loungePriceVo.price_reg"/>"/>
    	<input type="hidden" name="cprice_reg" id="cprice_reg" value="<s:property value="bookRoom.loungePriceVo.cprice_reg"/>"/>
    	<input type="hidden" name="way" id="way" value="<s:property escape="false" value="bookRoom.loungePriceVo.way"/>"/>
    	<input type="hidden" name="pginfo" id="passengerInfo"/>
    <div class="module_a Order">
        <div class="title"><span class="l"></span><span class="c"><b class="left">预订信息</b><b class="right">支付金额：<b class="red" id="amountPriceShow">
                <s:if test="bookRoom.type==1">
                	0.00
                </s:if>
                <s:else>
                	<s:iterator value="bookRoom.pricelist" var="price">
		            <s:if test='#price.type!="S"'>
		            	<s:property escape="false" value="#price.price"/>
		            </s:if>
		            </s:iterator>
                </s:else>
                                          元</b></b></span><span class="r"></span></div>
        <div class="inner clearfix_">
        <s:if test="!passengerlist.isEmpty()">
        	 <ul class="w1">
                <li id="clientNameCheckbox" class="Insert_select_box marginT10 Original clearfix_"> 
					<span class="left">常用人姓名：</span>
				<s:iterator value="passengerlist" var="passenger" status="item">
					<span class="left czPassenger" id="pgnameview">&nbsp;
	                    <input type="checkbox" id="checkbox01" />
	                    <label><s:property value="#passenger.name"/></label>
	                    <input type="hidden" value="<s:property value="#passenger.type"/>" id="<s:property value="#passenger.name"/>">
					</span> 
				</s:iterator>
                </li>
            </ul>
        </s:if>
            <ul class="clearfix_">
                <li class="Insert_select_box marginT10 Original"><span class="left">预订人数：</span>
                    <div id="tm2008style" class="left select_box_people">
                        <select name="people" id="people">
                        <s:if test="bookRoom.type==1">
                        	<s:iterator begin="1" end="bookRoom.roomType" step="1" var="roomcontent">
                        		<option value="<s:property value="#roomcontent"/>"><s:property value="#roomcontent"/></option>
                        	</s:iterator>
                        </s:if>
                        <s:else>
                        	<option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </s:else>
                        </select>
                    </div>
                    <span class="left" id="additionshowlist">&nbsp;
                    <s:iterator value="bookRoom.pricelist" var="price">
		            <s:if test='#price.type=="S"'>
                    	<input type="checkbox" onclick="chooseAddition()" name="additionalItemId" value="<s:property escape="false" value="#price.item"/>_<s:property value="#price.price"/>">
		            	<input type="hidden" name="additionalway" value="<s:property escape="false" value="#price.item"/>_<s:property value="#price.way"/>"/>
		            	<input type="hidden" name="additionalsprice" value="<s:property escape="false" value="#price.item"/>_<s:property value="#price.signingPrice"/>"/>
		            	<label>
		            		<s:property escape="false" value="#price.item"/>
		            		&nbsp;<s:property escape="false" value="#price.price"/>
		            	<s:if test='#price.way=="0"'>元/人</s:if>
		            	<s:else>元/单</s:else>
		            	</label>
		            </s:if>
		            </s:iterator>
                    </span></li>
            </ul>
            <ul id="select_box_people">
                <li id="passengerlist" class="Insert_select_box marginT10 Original"> 
                <span class="left">客人姓名：</span>
                    <div id="uboxstyle1" class="left select_box_people">
                        <select name="language_tm12" id="adultorchild0" title="aaa">
                            <option value="成人">成人</option>
                            <option value="儿童" >儿童</option>
                        </select>
                    </div>
                    <span class="left lh_normal" id="playerview">&nbsp;
                    <input  type="text" class="input2" name="passengerName" maxlength="20"/>
                    </span> <span class="left marginL10">航班号：</span>
                    <div id="uboxstyle1" class="left select_box_people">
                        <select name="language_tm13" id="flightNo0" name="flightNo">
                        <s:iterator value='bookRoom.lounge.airlineCorp.split(",")' var="airline">
                        	<option value="<s:property value="#airline"/>"><s:property value="#airline"/></option>
                        </s:iterator>
                        </select>
                    </div>
                    <span class="left lh_normal">&nbsp;
                   <input type="text" class="jdmc" name="passengerairline" maxlength="6"/>
                    </span>
                 </li>
            </ul>
            <ul>
                <li class="Insert_select_box marginT10">
                	<span class="left">预订时间：</span> 
                	<span class="left lh_normal">
                    	<input type="text" class="text_w90" name="bookstarttime" id="StartTime" readonly="readonly"/>
                    	<s:if test="bookRoom.type==1">
                    	-
                    	<input type="text" class="text_w90" name="bookendtime" id="EndTime" readonly="readonly"/>
                    	</s:if>
                    </span>
                    <s:if test="bookRoom.type==1">
                    	<span id="pointBox">
                    		<span class="left">&nbsp;注意：选择的“结束时间”应大于“开始时间”。</span>
                    		<span style="display:none;" class="left">&nbsp;共计<b class="jp_jq" id="BookingHours">?</b>小时</span>
                    	</span> 
                	</s:if>
                </li>
            </ul>
            <ul class="timesall clearfix_">
                <li class="w40">开始时间：</li>
                <li style="height:auto;">
                    <ul class="times2 clearfix_" id="StartTimeUL">
                    <s:iterator value="bookRoom.workTimeList" var="worktime" status="item">
                    <s:if test="bookRoom.workTimeStatusList[#item.index]==1">
                    	<li class="Disable">
                    </s:if>
                    <s:else>
                    	<li>
                    </s:else>
                    	<s:property value="#worktime"/></li>
                    </s:iterator>
                    </ul>
                </li>
            </ul>
            <s:if test="bookRoom.type==1">
            	<ul class="timesall clearfix_">
	                <li class="w40">结束时间：</li>
	                <li style="height:auto;">
	                    <ul class="times2 clearfix_" id="EndTimeUL">
	                        <s:iterator value="bookRoom.workTimeList" var="worktime" status="item">
		                    <s:if test="bookRoom.workTimeStatusList[#item.index]==1">
		                    	<li class="Disable">
		                    </s:if>
		                    <s:else>
		                    	<li>
		                    </s:else>
		                    	<s:property value="#worktime"/></li>
		                    </s:iterator>
	                    </ul>
	                </li>
	            </ul>
            </s:if>
            <ul class="Explain clearfix_">
                <li><b class="Disable"></b>灰色不可选</li>
                <li><b></b>白色,可选</li>
                <li><b class="Selected"></b>红色,选中</li>
            </ul>
            <div class="separated_line"></div>
            <ul class="paddingT10B10">
                <li><span class="orange">温馨提示：</span><b>预订机场贵宾间及贵宾休息厅需等待确认</b></li>
            </ul>
        </div>
        <b class="bl"></b> <b class="br"></b> </div>
    <!--Module end--> 
</div>
<!--main980 end-->

<div class="jd_fy_box margin5">
    <ul>
        <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
        <li class="jd_fy">联系人信息</li>
        <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
    </ul>
</div>
<div class="jd_fj_list2">
    <ul>
        <li class="orange w1">姓名：</li>
        <li class="w2">
            <input name="loginerName" type="text" class="jdmc" id="loginerName" value="<s:property value="member.name"/>"/>
        </li>
        <li class="orange w3">联系方式：</li>
        <li class="w2">
            <input name="loginerContact" type="text" class="jdmc" id="loginerContact" value="<s:property value="member.mobile"/>"/>
        </li>
        <li class="orange w3">邮箱地址：</li>
        <li class="w6">
            <input name="loginerEmail" type="text" class="jdmc" id="loginerEmail" value="<s:property value="member.email"/>"/>
        </li>
    </ul>
</div>
<div id="content"><img src="${ctx}/web/images/xx_bottom.jpg" /></div>
<div  class=" Wmargin tijiao_frm"><a class="button2 cuti" href="javascript:history.go(-1)">返 回 &gt;&gt;</a><a class="button1 cuti commenminites" href="javascript:valForm()">提交订单 &gt;&gt;</a> </div>
</s:form>
<script type="text/javascript">

//获取将要动态添加的html
var htmlLi = $("#select_box_people > li").eq(0).html(); 

function setOnclik(){
	
	//var  ddd = document.getElementById("language_tm12");
	alert("");
	//if(ddd!='null' && ddd!=null){
		
		//for(var i=0;i<ddd.length;i++){
			//ddd.onclick =setOnclickSelect;
		  
		   ////}
	//}
}

function setOnclickSelect(){
 alert(this);
}

$(function(){

		// 入住人姓名处理 checkbox
		$("#clientNameCheckbox  :checkbox").attr('checked', false); 
		$("#playerview :input").val("");
		
		$("#clientNameCheckbox  :checkbox").click(function(){
		if($(this).is(":checked")){
			var centent="${bookRoom.roomType}";
			if(centent==null||centent==""){
				centent=9;
				}
			if(GetClass("input2").length<centent){
			var personType=new Array();
			//alert($("select[title='aaa']").val());
			var ih=$("select[title='aaa']");
			var ts=$(".tag_select");
			for(var i=0;i<ih.length;i++){
				//for(var k=0;k<ih[i].length;k++){
					personType[i]=ts[i*2+1].innerHTML;
					//alert(personType[i]);
				//}
			}
			
			var boxname=document.getElementById($(this).next("label").text()).value;
			if(boxname=='02'){
				personType[$("select[title='aaa']").length]='儿童';
			}else{
				personType[$("select[title='aaa']").length]='成人';
			}
			var info=new Array();
			var info1=new Array();
			var idx = GetClass("input2").length;
			var inputName=$(this).next("label").text();
			var tuanzu2=GetClass("input2");
			var tuanzu3=GetClass("jdmc");
			var ck=0;
			for(var i=0;i<$(".input2").length;i++){
				if(tuanzu2[i].value==""){
					ck++;
				}
			}
			if(ck<=0){
				var icount=0;
			for(var k=0;k<idx;k++){
				if(tuanzu2[k].value!=""){
					 info[k]=tuanzu2[k].value;
					 info1[k]=tuanzu3[k].value;
					 icount++;
				}else{
					info[k]=inputName;
					icount++;
				}
			}
			info[icount]=inputName;
			//删除上次动态添加的html
		    $(".addLi").remove();
			// 触发事件li的索引
			for(i=0; i<idx; i++){
				$("#select_box_people").append('<li id="passengerlist" class="addLi">'+htmlLi+'</li>');
			}
			// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
			$(".addLi").each(function(index) {
	            $(this).children().children("select").attr("name", "people"+index);
	        });
			// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
			$(".addLi").children().children("select").each(function(index) {
				var names = $(this).attr("name");
	            $(this).attr("name", names+index);
	        });
			
			// 删除第二次以后调用rSelects方法多生成的元素.
			$(".Original select").siblings().remove();
	         //调用select2css.js样式
			 rSelects();
			// 
			 	var tuanzu1=GetClass("input2");
			 	var tuanzu2=GetClass("jdmc");
			 	var ih=$("select[title='aaa']");
			 	var ts=$(".tag_select");
			 	for(var i=0;i<personType.length;i++){
					//for(var k=0;k<ih[i].length;k++){
					ts[i*2+1].innerHTML=personType[i];
					//}
				}
				for(var k=0;k<info.length;k++){
					//alert(info[k]);
					tuanzu1[k].value=info[k];
					if(info1[k]==undefined){
						tuanzu2[k].value="";
					}else{
						tuanzu2[k].value=info1[k];
					}
				}
			}else{
				var personType=new Array();
				//alert($("select[title='aaa']").val());
				var ih=$("select[title='aaa']");
				var ts=$(".tag_select");
				for(var i=0;i<ih.length;i++){
					//for(var k=0;k<ih[i].length;k++){
						personType[i]=ts[i*2+1].innerHTML;
						//alert(personType[i]);
					//}
				}
				
				
				var tuanzu1=GetClass("input2");
				for(var k=0;k<tuanzu1.length;k++){
					if(tuanzu1[k].value==""){
						 tuanzu1[k].value=$(this).next("label").text();
						 var boxname=document.getElementById($(this).next("label").text()).value;
							if(boxname=='02'){
								personType[k]='儿童';
								//alert(personType[k]+k);
							}else{
								personType[k]='成人';
								//alert(personType[k]+k);
							}
						 break;
					}
				}
			 	for(var i=0;i<personType.length;i++){
					//for(var k=0;k<ih[i].length;k++){
					ts[i*2+1].innerHTML=personType[i];
					//}
				}
				
			}
			//人数下拉赋值
			document.getElementById("select_info_people").innerHTML=tuanzu1.length;
			document.getElementById("people").value=tuanzu1.length;
			//计算收费
			//$("#StartTimeUL li").not(".Disable").addClass("Selected").siblings().removeClass("Selected");
			//$("#BookingHours").text(countHour());
		    //$("#StartTime").val($.trim($(this).text()));
			countHour()>0 ? $("#pointBox span").eq(1).show().siblings().hide() : $("#pointBox span").eq(0).show().siblings().hide() ;
			
			if(document.getElementById("way").value=="1")
	        {			
				if(countHour()>0)
				{
					set_Order();
					set_Addition();
				}
				else
				{
					set_Zero();
				}
			}
			else
			{
				set_Man();
				set_Addition();
			}
				//$("#playerview :input[value='']").eq(0).val($(this).next("label").text());
				
				//if($("#clientNameCheckbox  :checkbox:checked").length>$("#playerview :input").length){
					//alert("请选择打位数");
					//$("#clientNameCheckbox  :checkbox["+$(this).next("label").text()+"]").attr("checked",false);
				//}
				
		}else{
			
			var tuanzu1=GetClass("input2");
			if(tuanzu1[tuanzu1.length-1].value==""){
				
				for(var k=0;k<tuanzu1.length;k++){
					if(tuanzu1[k].value==""){
						 tuanzu1[k].value=$(this).next("label").text();
						 break;
					}
				}
			}else{
				var valuebox=$(this).next("label").text();
				$(this).attr("checked",false);
				alert("该房间最多住"+centent+"人！");
			}
		}
		}else{
			
			//$("#playerview :input[value="+$(this).next("label").text()+"]").val("");
			var tuanzu1=GetClass("input2");
			var tuanzu3=GetClass("jdmc");
			for(var k=0;k<tuanzu1.length;k++){
				if(tuanzu1[k].value==$(this).next("label").text()){
					 //tuanzu1[k].value="";
					 if(tuanzu1.length!=1){
						 if(k==0){
							 tuanzu1[k].value="";
							 tuanzu3[k].value="";
							 var ts=$(".tag_select");
							 ts[1].innerHTML=ts[ts.length-2].innerHTML;
							 tuanzu1[0].value=tuanzu1[tuanzu1.length-1].value;
							 tuanzu3[0].value=tuanzu3[tuanzu1.length-1].value;
							 var inp=$("#select_box_people > li").eq(tuanzu1.length-1);
							 inp.remove();
						 }else{
					 	var inp=$("#select_box_people > li").eq(k);
					 //var inp=$("#playerview :input[value="+$(this).next("label").text()+"]");
					    inp.remove();
						 }
					 }else{
						 tuanzu1[k].value="";
					 }
				}
			}
			var tuanzu2=GetClass("input2");
			//人数下拉赋值
			document.getElementById("select_info_people").innerHTML=tuanzu2.length;
			document.getElementById("people").value=tuanzu1.length;
			//计算收费
			//$("#StartTimeUL li").not(".Disable").addClass("Selected").siblings().removeClass("Selected");
			//$("#BookingHours").text(countHour());
		    //$("#StartTime").val($.trim($(this).text()));
			countHour()>0 ? $("#pointBox span").eq(1).show().siblings().hide() : $("#pointBox span").eq(0).show().siblings().hide() ;
			
			if(document.getElementById("way").value=="1")
	        {			
				if(countHour()>0)
				{
					set_Order();
					set_Addition();
				}
				else
				{
					set_Zero();
				}
			}
			else
			{
				set_Man();
				set_Addition();
			}
			
		}
		
	});
	

	
	// 单击li后的一些操作
	$("#options_people >li").live("click",function(){
		var tuanzu1=GetClass("input2");
		// 触发事件li的索引
	    var idx = $("#options_people >li").index(this);
		// 根据索引确定循环次数
		if(idx+1>tuanzu1.length){
			if($("#clientNameCheckbox  :checkbox").is(":checked")||idx+1>tuanzu1.length){
				var idx = GetClass("input2").length;
				var inputName=$(this).next("label").text();
				var tuanzu2=GetClass("input2");
				var tuanzu3=GetClass("jdmc");
				if($(".input2[value='']").length<=0||idx+1>tuanzu1.length){
					var personType=new Array();
					var ih=$("select[title='aaa']");
					var ts=$(".tag_select");
					for(var i=0;i<ih.length;i++){
						//for(var k=0;k<ih[i].length;k++){
							personType[i]=ts[i*2+1].innerHTML;
						//}
					}
					
					var info=new Array();
					var info1=new Array();
					var icount=0;
					for(var k=0;k<idx;k++){
						if(tuanzu2[k].value!=""){
							 info[k]=tuanzu2[k].value;
							 info1[k]=tuanzu3[k].value;
							 icount++;
						}else{
							info[k]=inputName;
							icount++;
						}
					}
					info[icount]=inputName;
					//删除上次动态添加的html
				    $(".addLi").remove();
					// 触发事件li的索引
					var idx = $("#options_people >li").index(this);
					for(i=0; i<idx; i++){
						if(i>=$("select[title='aaa']").length){
							personType[i]='成人';
						}
						$("#select_box_people").append('<li id="passengerlist" class="addLi">'+htmlLi+'</li>');
					}
					// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
					$(".addLi").each(function(index) {
			            $(this).children().children("select").attr("name", "people"+index);
			        });
					// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
					$(".addLi").children().children("select").each(function(index) {
						var names = $(this).attr("name");
			            $(this).attr("name", names+index);
			        });
					
					// 删除第二次以后调用rSelects方法多生成的元素.
					$(".Original select").siblings().remove();
			         //调用select2css.js样式
					 rSelects();
					// 
					 var tuanzu1=GetClass("input2");
					 var tuanzu2=GetClass("jdmc");
					 var ih=$("select[title='aaa']");
					 var ts=$(".tag_select");
					 for(var i=0;i<personType.length;i++){
							//for(var k=0;k<ih[i].length;k++){
						ts[i*2+1].innerHTML=personType[i];
							//}
					}	
					 for(var k=0;k<info.length;k++){
							//alert(info[k]);
						tuanzu1[k].value=info[k];
						if(info1[k]==undefined){
							tuanzu2[k].value="";
						}else{
							tuanzu2[k].value=info1[k];
						}
					}
				}else{
					var tuanzu1=GetClass("input2");
					for(var k=0;k<tuanzu1.length;k++){
						if(tuanzu1[k].value==""){
							 tuanzu1[k].value=$(this).next("label").text();
							 break;
						}
					}
				}
				
				
					//$("#playerview :input[value='']").eq(0).val($(this).next("label").text());
					
					//if($("#clientNameCheckbox  :checkbox:checked").length>$("#playerview :input").length){
						//alert("请选择打位数");
						//$("#clientNameCheckbox  :checkbox["+$(this).next("label").text()+"]").attr("checked",false);
					//}
					
			}else{
				$("#playerview :input[value="+$(this).next("label").text()+"]").val("");
				var tuanzu1=GetClass("input2");
				for(var k=0;k<tuanzu1.length;k++){
					if(tuanzu1[k].value==$(this).next("label").text()){
						 tuanzu1[k].value="";
					}
				}
			}
			//计算收费
			//$("#StartTimeUL li").not(".Disable").addClass("Selected").siblings().removeClass("Selected");
			//$("#BookingHours").text(countHour());
		    //$("#StartTime").val($.trim($(this).text()));
			countHour()>0 ? $("#pointBox span").eq(1).show().siblings().hide() : $("#pointBox span").eq(0).show().siblings().hide() ;
			
			if(document.getElementById("way").value=="1")
	        {			
				if(countHour()>0)
				{
					set_Order();
					set_Addition();
				}
				else
				{
					set_Zero();
				}
			}
			else
			{
				set_Man();
				set_Addition();
			}
		}else if(idx+1==tuanzu1.length){

		}else{			
			var info=new Array();
			var info1=new Array();
			//删除上次动态添加的html
		    $(".addLi").remove();
			for(i=0; i<idx; i++){
				$("#select_box_people").append('<li id="passengerlist" class="addLi">'+htmlLi+'</li>');
			}
			// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
			$(".addLi").each(function(index) {
	            $(this).children().children("select").attr("name", "people"+index);
	        });
			// 确保动态添加内容中select的name值是唯一的，不然与select2css.js冲突
			$(".addLi").children().children("select").each(function(index) {
				var names = $(this).attr("name");
	            $(this).attr("name", names+index);
	        });
			
			// 删除第二次以后调用rSelects方法多生成的元素.
			$(".Original select").siblings().remove();
	         //调用select2css.js样式
			 rSelects();
			 var tuanzu1=GetClass("input2");
			 var tuanzu2=GetClass("jdmc");
				for(var k=0;k<tuanzu1.length;k++){
					tuanzu1[k].value="";
					if(tuanzu2[k].name!='loginerName'&&tuanzu2[k].name!='loginerContact'&&tuanzu2[k].name!='loginerEmail')
					tuanzu2[k].value="";	 
				}
			 $("#clientNameCheckbox  :checkbox").attr('checked', false); 
			 //setOnclik();
			}
			document.getElementById("select_info_people").innerHTML=tuanzu1.length;
			document.getElementById("people").value=tuanzu1.length;
			
    });
	
	// 开始、结束时间选择
    $(".times2 li").not(".Disable").css("cursor","pointer").hover(function(){
	        $(this).css("border-color","#F4972F");},
        function(){
	    	$(this).css("border-color","#D5D5D5");
    });
    $("#StartTimeUL li").not(".Disable").click(function(){
		$(this).addClass("Selected").siblings().removeClass("Selected");
		$("#BookingHours").text(countHour());
	    $("#StartTime").val($.trim($(this).text()));
		countHour()>0 ? $("#pointBox span").eq(1).show().siblings().hide() : $("#pointBox span").eq(0).show().siblings().hide() ;
		
		if(document.getElementById("way").value=="1")
        {
			if(countHour()>0)
			{
				set_Order();
				set_Addition();
			}
			else
			{
				set_Zero();
			}
		}
		else
		{
			set_Man();
			set_Addition();
		}
	});
	$("#EndTimeUL li").not(".Disable").click(function(){
	    $(this).addClass("Selected").siblings().removeClass("Selected");
		$("#BookingHours").text(countHour());
		$("#EndTime").val($.trim($(this).text()));
		countHour()>0 ? $("#pointBox span").eq(1).show().siblings().hide() : $("#pointBox span").eq(0).show().siblings().hide() ;
		if(document.getElementById("way").value=="1")
        {
			if(countHour()>0)
			{
				set_Order();
				set_Addition();
			}
			else
			{
				set_Zero();
			}
		}
	});
    // 成人、儿童
	$(".tag_options li").live("click",function(){
		if(document.getElementById("way").value=="1")
        {
			if(countHour()>0)
			{
				set_Order();
				set_Addition();
			}
			else
			{
				set_Zero();
			}
		}
		else
		{
			set_Man();
			set_Addition();
		}
	});
    
    if(document.referrer.indexOf("login.jsp")>0)
	{
		$(".button2").attr("href","javascript:history.go(-2)");
	}
	
});
</script> 
<script type="text/javascript">
	//进入当前页面格式化总金额
	var price = document.getElementById("price").value;
	price = new Number(price);
	if(document.getElementById("roomType").value==1){
		price=0;//如果是贵宾间就显示0
	}
	document.getElementById("amountPriceShow").innerHTML=price.toFixed(0)+"元";//显示时只显示整数
</script>
</body>

 
