// JavaScript Document

var basePath="";
var width="110"
if(m_basePath!=null && m_basePath != "") {
	basePath=m_basePath;	
}

function showImgQQ(name, qq, index)
{
	document.write('<tr><td valign=middle align="left" background='+basePath+'images/kefu_middle.gif style="padding-left: 10px;">');
	if (online[index]==0)
		document.write("&nbsp;&nbsp;<img src="+basePath+"images/QQoffline.gif border=0 align=middle>&nbsp;&nbsp;<a class='qqb' target=blank href='http://wpa.qq.com/msgrd?V=1&Uin="+qq+"&Site=������ѯ&Menu=no' title='�ͷ������ߣ�������'>"+name+"</a>");
	else
		document.write("&nbsp;&nbsp;<img src="+basePath+"images/QQonline.gif border=0 align=middle>&nbsp;&nbsp;<a class='qqa' target=blank href='http://wpa.qq.com/msgrd?V=1&Uin="+qq+"&Site=������ѯ&Menu=no' title='���߼�ʱ��̸'>"+name+"</a>");
}

function loadJsFile(src){
	var headObj = document.getElementsByTagName("head")[0];
	srciptObj = document.createElement("script");
	srciptObj.language = "javaScript";
	srciptObj.type = "text/JavaScript";
	srciptObj.src = src;
	headObj.appendChild(srciptObj);
}

var online;
if(online == null) {
	online = new Array();
	document.write('<script language="javascript" type="text/javascript" src="http://webpresence.qq.com/getonline?Type=1&2500156978:1454256060:357256178:1315469727:1838448221:" charset="GBK"></script>');
}

if (!document.layers)
	document.write('<div id="divStayTopLeft">')
else
	document.write('<layer id="divStayTopLeft">');
document.write('<table border="0" width="'+width+'" cellspacing="0" cellpadding="0">');
document.write('<tr><td width="'+width+'"><img border=0 src='+basePath+'images/kefu_up.gif>');
showImgQQ("Ѷ��ͷ�", "2500156978", 0);
showImgQQ("����Ǣ̸", "1454256060", 1);
showImgQQ("�г���ѯ", "357256178", 2);
showImgQQ("�г�����", "1315469727", 3);
showImgQQ("ҵ����ѯ", "1838448221", 4);
document.write('</td></tr><tr><td width="'+width+'"><img border=0 src='+basePath+'images/kefu_down.gif></td></tr></table></layer>');

var verticalpos="frombottom"
if (!document.layers)
	document.write('</div>')
else
	document.write("</layer>");
function JSFX_FloatTopDiv()
{
	var posY = 100;
	var posX = document.body.clientWidth - width - 10;
	var leftPos = posX;
	var topPos  = posY;
	var id="divStayTopLeft";
	var d=document;
	var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id];
	
	if (document.body.scrollTop)
	{
		topPos  += document.body.scrollTop;
		leftPos += document.body.scrollLeft;    
	}
	else
	{
		topPos  += document.documentElement.scrollTop;
		leftPos += document.documentElement.scrollLeft;
	}
	
	el.style.position = "absolute";
	el.style.left     = leftPos + "px";
	el.style.top      = topPos  + "px";
	
	/*var startX =screen.width-150,
	startY = 250;
	var ns = (navigator.appName.indexOf("Netscape") != -1);
	var d = document;
	function ml(id)
	{
		var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id];
		if(d.layers)el.style=el;
		el.sP=function(x,y){
			this.style.left=x;
			this.style.top=y;
		};
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
		setTimeout("stayTopLeft()", 2000);
	}
	ftlObj = ml("divStayTopLeft");
	
	stayTopLeft();
	*/
}
JSFX_FloatTopDiv();
window.onresize = JSFX_FloatTopDiv;
window.onscroll = JSFX_FloatTopDiv;