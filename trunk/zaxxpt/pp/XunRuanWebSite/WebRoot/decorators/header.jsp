<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/page/common/taglib.jsp" %>
    <title>广州讯软-打造国内知名软件外包信息服务</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="author" content="广州讯软信息科技有限公司"> 
	<meta name="copyright" content="(c)2011-2013"> 
	<meta name="project" content="gateway web engine"> 
	<meta name="keywords" content="讯软 软件 外包 广州讯软 产品研发 人力资源 外包服务"> 
	<meta name="description" content="广州讯软信息科技是一家致力于通信行业、金融行业、网站建设、软件外包及服务的专业级技术公司，拥有雄厚实力的产品研发、实施及技术支持" />
  </head>
  <body>
    <div id="sitebody" class="sitebody">
    	<div id="header" class="header">
			<div id="sitelogo" class="sitelogo">
				<div class="logo">
					<a href="index.html"><img src="${ctx}/images/logo/xunruan_logo.gif" alt="广州讯软信息科技公司门户网" /></a>
				</div>
				<div id="siteheadtop" class="siteheadtop">
					<!-- 广州讯软信息科技有限公司欢迎你！ --> 
					<a href="sitemap.html">网站地图</a> | 
					<a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.gzxunruan.com');" href="javascript:void(0)">设为主页</a> |
					<a href="javascript:void(0)" onclick="javascript:window.external.AddFavorite('http://www.gzxunruan.com','广州讯软信息科技有限公司')">收藏本站</a> | 
					<a href="mailto:service@gzxunruan.com">公司邮箱</a> 
				</div>
			</div> 
			
			<div id="sitemenu" class="sitemenu">
				<div class="menu-items">
				<div id="first"    class="menu_head activation">首页</div>
				<div id="product"  class="menu_head">公司产品</div>
				<div id="news"     class="menu_head">
				新闻中心
				<ul id="news_menu" class="menu_body">
				<li><a href="#">公司新闻</a></li>
				<li><a href="#">行业动态</a></li>
				</ul>
				</div>
				<div id="srvtype"  class="menu_head">
				服务类型
				<ul id="srvtype_menu" class="menu_body">
				<li><a href="#">开发与维护</a></li>
				<li><a href="#">应用测试</a></li>
				<li><a href="#">人力资源外包</a></li>
				<li><a href="#">项目外包</a></li>
				</ul>
				</div>
				<div id="workdev"  class="menu_head">
				招贤纳士
				<ul id="workdev_menu" class="menu_body">
				<li><a href="#">人才理念</a></li>
				<li><a href="#">招聘职位</a></li>
				</ul>
				</div>
				<div id="vocation" class="menu_head">职业发展</div>
				<div id="aboutus"  class="menu_head">
				关于我们
				<ul id="aboutus_menu" class="menu_body">
				<li><a href="#">公司简介</a></li>
				<li><a href="#">企业理念</a></li>
				<li><a href="#">联系我们</a></li>
				<li><a href="#">战略定位</a></li>
				<li><a href="#">团队发展</a></li>
				</ul>
				</div>
				</div>
			</div>
			<div id="imgMenu" class="imgMenu">
		<SCRIPT language=javascript type=text/javascript>
			var widths = 1000;
			var heights = 280;
			var counts = 4;
			img1 = new Image(); img1.src = '${ctx}/images/menu/main1.jpg';
			img2 = new Image(); img2.src = '${ctx}/images/menu/main2.jpg';
			img3 = new Image(); img3.src = '${ctx}/images/menu/main3.jpg';
			img4 = new Image(); img4.src = '${ctx}/images/menu/main4.jpg';
		
			url1 = new Image(); //url1.src = 'javascript: void(0)';
			url2 = new Image(); //url2.src = 'javascript: void(0)';
			url3 = new Image(); //url3.src = 'javascript: void(0)';
			url4 = new Image(); //url4.src = 'javascript: void(0)';	

			var nn = 1;
			var key = 0;
			function change_img() {
				if (key == 0) {
					key = 1;
				}
				else if (document.all) {
					document.getElementById("pic").filters[0].Apply();
					document.getElementById("pic").filters[0].Play(duration = 2);
				}
				eval('document.getElementById("pic").src=img' + nn + '.src');
				eval('document.getElementById("url").href=url' + nn + '.src');
				for (var i = 1; i <= counts; i++) {
					document.getElementById("xxjdjj" + i).className = 'axx';
				}
				document.getElementById("xxjdjj" + nn).className = 'bxx';
				nn++; if (nn > counts) { nn = 1; }
				tt = setTimeout('change_img()', 4000);
			}
			function changeimg(n) { nn = n; window.clearInterval(tt); change_img(); }
			document.write('<style>');
			document.write('.axx{padding:1px 7px;border-left:#cccccc 1px solid;}');
			document.write('a.axx:link,a.axx:visited{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#666;}');
			document.write('a.axx:active,a.axx:hover{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#999;}');
			document.write('.bxx{padding:1px 7px;border-left:#cccccc 1px solid;}');
			document.write('a.bxx:link,a.bxx:visited{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#D34600;}');
			document.write('a.bxx:active,a.bxx:hover{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#D34600;}');
			document.write('</style>');
			document.write('<div style="width:' + widths + 'px;height:' + heights + 'px;overflow:hidden;text-overflow:clip;">');
			document.write('<div><a id="url"><img id="pic" style="border:0px;filter:progid:dximagetransform.microsoft.wipe(gradientsize=1.0,wipestyle=4, motion=forward)" width=' + widths + ' height=' + heights + ' /></a></div>');
			if($.browser.msie) {
				document.write('<div class="item ieitem">');
			}
			else {
				document.write('<div class="item nonieitem">');
			}
			for (var i = 1; i < counts + 1; i++) { document.write('<a href="javascript:changeimg(' + i + ');" id="xxjdjj' + i + '" class="axx" target="_self">' + i + '</a>'); }
			document.write('</div></div>');
			change_img();
		</SCRIPT>
		</div>
		</div>
		</div>
		
		</body>
