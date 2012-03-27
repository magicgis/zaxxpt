// JavaScript Document
var evalData;
var $_Ajax=function(url, param, calcFunc){
	this.url=url;
	this.param=param;
	this.calcFunc=calcFunc;
	
	this.createxmlHttp=function(){
		if(window.ActiveXObject)
		{
			try {  
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  
			}  
			catch (e) {  
				try {  
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  
				}  
				catch (e) {  
					return e;  
				}  
			} 
		}
		else if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();
		}
		if(!xmlHttp) {
			alert("不能创建XMLHttpRequest对象实例，请使用IE浏览器！");	
		}
		return xmlHttp;
	}
	
	this.request=function(){
		xmlHttp=this.createxmlHttp();
		xmlHttp.onreadystatechange=this.response;
		xmlHttp.open("GET",url, true);
		xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8");
		xmlHttp.send(null);
	}
	
	this.response=function() {
		if(xmlHttp.readyState==4)
		{
			if(xmlHttp.status==200 || xmlHttp.status==0)
			{
				evalData=xmlHttp.responseText;
				alert(evalData);
				eval(evalData);
			}
		}
	}
}

var online= new Array();
var qqFrameObject=function(path){
	this.basePath="";
	if(path !=null && path != "") {
		this.basePath=path;
	}
}
/*
 * <函数功能> Js文件中加载一个js文件
 */
qqFrameObject.prototype.loadJsFile=function(src)
{
	var headObj = document.body;
	srciptObj = document.createElement("script");
	srciptObj.language = "javaScript";
	srciptObj.type = "text/JavaScript";
	srciptObj.src = src;
	headObj.appendChild(srciptObj);
}

/*
 * <函数功能> 在html对象中加入QQ在线访问功能
 * <参数> index: QQ索引
 */
qqFrameObject.prototype.showImgQQ=function(table, name, qq, index)
{
	var tr = table.insertRow(-1);
	var td = tr.insertCell(-1);
	td.setAttribute("valign", "middle");
	td.setAttribute("background", this.basePath+"images/kefu_middle.gif");
	td.setAttribute("align", "left");
	td.setAttribute("width", "110");
	td.setAttribute("style", "padding-left: 20px;");

	if (online[index]==0)
	{
		td.innerHTML="&nbsp;&nbsp;<img src="+this.basePath+"images/QQoffline.gif border=0 align=middle>&nbsp;&nbsp;<a class='qqb' target=blank href='http://wpa.qq.com/msgrd?V=1&Uin="+qq+"&Site=在线咨询&Menu=no' title='客服不在线，请留言'>"+name+"</a>";
	}
	else
	{
		td.innerHTML="&nbsp;&nbsp;<img src="+this.basePath+"images/QQonline.gif border=0 align=middle>&nbsp;&nbsp;<a class='qqa' target=blank href='http://wpa.qq.com/msgrd?V=1&Uin="+qq+"&Site=在线咨询&Menu=no' title='在线即时交谈'>"+name+"</a>";
	}
}

qqFrameObject.prototype.create=function() {
	var divStayTopLeft;
	if (!document.layers)
	{
		divStayTopLeft=document.createElement("div");
		divStayTopLeft.id="divStayTopLeft";
		divStayTopLeft.style.position="absolute";
	}
	var layerStay=document.createElement("layer");
	layerStay.id="divStayTopLeft";
	if(divStayTopLeft)
	{
		divStayTopLeft.appendChild(layerStay);	
	}
	
	var table=document.createElement("table");
	table.border="0";
	table.width="110";
	table.cellspacing="0";
	table.cellpadding="0";
	var tr = table.insertRow(-1);
	var td = tr.insertCell(-1);
	td.setAttribute("width", "110");
	td.setAttribute("align", "left");
	td.innerHTML="<img border=0 src="+this.basePath+"images/kefu_up.gif>";
	
	var ajax = new $_Ajax("http://webpresence.qq.com/getonline?Type=1&331830177:393247152:329168043:282842703:");
	ajax.request();
	eval(evalData)

	this.showImgQQ(table, "谢立杰", "331830177", 0)
	this.showImgQQ(table, "刘 &nbsp;鹏", "393247152", 1);
	this.showImgQQ(table, "文 &nbsp;正", "329168043", 2);
	this.showImgQQ(table, "陈 &nbsp;军", "282842703", 3);
	
	tr = table.insertRow(-1);
	td = tr.insertCell(-1);
	td.setAttribute("width", "110");
	td.setAttribute("align", "left");
	td.innerHTML="<img border=0 src="+this.basePath+"images/kefu_down.gif>";
	
	layerStay.appendChild(table);
	document.body.appendChild(layerStay);
	
	this.JSFX_FloatTopDiv();
}


qqFrameObject.prototype.JSFX_FloatTopDiv=function()
{
	var verticalpos="frombottom"
	var startX =screen.width-150,
	startY = 250;
	var ns = (navigator.appName.indexOf("Netscape") != -1);
	var d = document;
	function ml(id)
	{
		var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id];
		if(d.layers)el.style=el;
		  el.sP=function(x,y){this.style.left=x;this.style.top=y;};
		  el.x = startX;
		if (verticalpos=="fromtop")
		  el.y = startY;
		else{
		  el.y = ns ? pageYOffset + innerHeight : document.body.scrollTop + document.body.clientHeight;
		  el.y -= startY;
		}
		return el;
	}
	window.stayTopLeft=function()
	{
		if (verticalpos=="fromtop"){
			var pY = ns ? pageYOffset : document.body.scrollTop;
			ftlObj.y += (pY + startY - ftlObj.y)/8;
		}
		else{
			var pY = ns ? pageYOffset + innerHeight : document.body.scrollTop + document.body.clientHeight;
			ftlObj.y += (pY - startY - ftlObj.y)/8;
		}
		ftlObj.sP(ftlObj.x, ftlObj.y);
		setTimeout("stayTopLeft()", 10);
	}
	ftlObj = ml("divStayTopLeft");
	
	stayTopLeft();
}