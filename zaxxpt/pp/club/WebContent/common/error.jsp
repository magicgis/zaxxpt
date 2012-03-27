<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<%@ include file="/common/include/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" /><!--让IE8解释和IE7一样，不可删-->
<title>无标题文档</title>
<link type="text/css" rel="stylesheet"  href="HEB_style.css"/>
<script language="javascript">
function g(o){return document.getElementById(o);}
function HoverLi(n){
for(var i=1;i<=2;i++){g('tb1_'+i).className='p11_w_normaltab';g('tbc1_0'+i).className='undis';}g('tbc1_0'+n).className='dis';g('tb1_'+n).className='p11_w_hovertab';
}
</script>

</head>

<body>
<form action="" method="get">
<div class="right">
    <div class="breadcrum">你现在的位置：<a class="black" href="right_home.html">首页</a>&nbsp;&gt;&gt;&nbsp;请求错误</div>
<div class="content">
    	<div class="table_1 mt10px">
        	<p>请求错误</p>
        </div>
    	<div class="dis" id="tbc1_01">
          <div class="table_style" style="margin-top:-1px;">
          <div class="rightCs" style="padding:10px 20px;">
          	<dl class="rightC">
              <dd style="float:left;width:90%">
                  <p>
                  	<img src="images/icon07.gif" width="55" height="55" style="vertical-align:middle;margin-right:30px;"/>
                  	<font>${message}</font>
                  </p>
                <p>&nbsp;</p>
              </dd>
            </dl>
            <div class="clear"></div>
            	<input type="button" onclick="window.location.href='${ctx}/booking.action'" value="返 回"/>
            </div>
          </div>
          </div>
          <div class="undis" id="tbc1_02">
          <div class="table_style" style="margin-top:-1px;">
			<img src="images/ditie_bj.png" />
		  </div>
</div>

			<div style="display: none">
	
			</div>
  </div>
  </div>
</form>
</body>
</html>
