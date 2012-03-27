<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/web/css/jcxxslist.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/web/css/style.css" rel="stylesheet" type="text/css" />
<TITLE>修改支付密码 _ ${domain_cn} </TITLE>
</head>
<body>
<div class="main">
<%@ include file="/WEB-INF/pages/member/menu.jsp"%>
<!----------------------------------------- RIGHT ------------------------------------>
<div class="floatleft width783">
    <div class="lineclear"><img src="${ctx}/web/images/right_top.jpg"/></div>
    <div class="listTAB rightbg">
        <div id="path"><a href="${ctx}/member/index.jsp" class="cl0">我的个人中心</a> &gt; <span class="cl1">修改支付密码</span></div>
        <div id="Accountcenter">
            <div class="right_h">
                <ul>
                    <li class="left Accountwidth"><img src="${ctx}/web/images/right_h_l.jpg"/></li>
                    <li class="right_h_bg widtha">
                        <div class="grf_tag4"><a href="#" class="ontag">修改支付密码</a></div>
                    </li>
                    <li class="right_h_bg widthb"></li>
                    <li class="right Accountwidth"><img src="${ctx}/web/images/right_h_r.jpg"/></li>
                </ul>
            </div>
            <div class="clear"></div>
            <div class="listTAB">
                <div class="password">
                    <div id="Modify_pass">
                        <ul>
                            <li><font class="Modifypassword">当前密码：</font>
                                <input type="text" name="dqmm_textfield2" id="dqmm_textfield2" class="textfields" />
                            </li>
                            <li><font class="Modifypassword">新 密 码：</font>
                                <input type="text" name="dqmm_textfield" id="dqmm_textfield" class="textfields" />
                            </li>
                            <li><font class="Modifypassword">重复新密码：</font>
                                <input type="text" name="dqmm_textfield" id="dqmm_textfield" class="textfields" />
                            </li>
                            <li><span><a href="#" class="button_bc">保存修改</a></span></li>
                        </ul>
                    </div>
                </div>
                <div class="password mp mp_padbottom">备注：初始支付密码和您的登录密码是一样的，为了安全起见，请您修改一个不同的支付密码．<br />
                    您在本网站购买机票或其他商品时，如果选择用账户余额支付时会提示您输入此密码．</div>
            </div>
            <div class="lineclear left"><img src="${ctx}/web/images/right_l_bott.jpg" /></div>
        </div>
        <div class="lineclear Accountheight"></div>
    </div>
    <div class="lineclear"><img src="${ctx}/web/images/right_bott.jpg" /></div>
</div>
<!-----------------------------------------RIGHT END------------------------------------>
<div class="clear"></div>
</div>
</body>
