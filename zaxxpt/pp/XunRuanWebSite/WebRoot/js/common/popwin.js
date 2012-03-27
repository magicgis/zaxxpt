			function popwindows(str,type,code){
			var width,height,bordercolor,titleheight,titlecolor;
			width=600;
			height=450;
			titleheight=30 
			bordercolor="#336699";//提示窗口的边框颜色
			titlecolor="#99CCFF";//提示窗口的标题颜色
			
			var sWidth,sHeight;
			sWidth=Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth) + "px";
			sHeight=Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) + "px";
			var bgObj=document.createElement("div");
			bgObj.setAttribute('id','bgDiv');
			bgObj.style.position="absolute";
			bgObj.style.top="0";
			bgObj.style.background="#777";
			bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=50,finishOpacity=50";
			bgObj.style.opacity="0.6";
			bgObj.style.left="0";
			bgObj.style.width=sWidth;
			bgObj.style.height=sHeight;
			bgObj.style.zIndex = "999";
			document.body.appendChild(bgObj);
			
			var popwin=document.createElement("div")
			popwin.setAttribute("id","msgDiv");
			popwin.setAttribute("align","center");
	    	popwin.style.position = "absolute";
            popwin.style.left = "50px";
            popwin.style.top = "15px";
            popwin.style.marginLeft = "25px" ;
            popwin.style.marginTop = document.documentElement.scrollTop+"px";
            popwin.style.width = width + "px";
            popwin.style.height =height + "px";
            popwin.style.zIndex = "1000";
   
		   document.body.appendChild(popwin);
		   var txt=document.createElement("div");
		   txt.setAttribute("id","msgTxt");
		   if(type==1){
		   txt.innerHTML='<table id="popwin" cellPadding="0" class="font_14"><tr><td class="title"><span>产品图片</span> <a href="javascript:void(0)" onclick="close_popwin()"></a></td></tr><tr><td align="center"><img src="./clientdata/attachment/product/' +str+'" onload="if(this.width>695) {this.resized=true; this.width=650;}"></td></tr></table>';
		   }
		   else if(type==2){
			   if(code==1){
					txt.innerHTML=   login_withcode_box();
			   }else{
					txt.innerHTML=   login_nocode_box();
			   }
		   }
           document.getElementById("msgDiv").appendChild(txt);
			   if(type==2){
						document.getElementById("login_userid").focus();
					if(code==1){
						changeauthcode();
					 }
			   }
            }
			function close_popwin(){
			    document.body.removeChild(document.getElementById("bgDiv"));
                document.body.removeChild(document.getElementById("msgDiv"));
			}


			function  login_nocode_box(){
			var w;
			w = '<form method="post" id="login_form" action="verify.php?action=loginin">';
			w = w + '<table id="popwin" cellPadding="0" class="font_14">';
			w = w + '<tr><td class="title"><span>用户登录</span> <a href="javascript:void(0)" onclick="close_popwin()"></a></td></tr>';
			w = w + '<tr><td height="20px"></td></tr>';
			w = w + '<tr><td class="loguser"><span>用户账号：</span><input type="text" id="login_userid" name="login_userid" maxlength="18" id="loginuserid" tabindex="98"> <a href="register.php">注册新账号</a></td></tr>';
			w = w + '<tr><td height="20px"></td></tr>';
			w = w + '<tr><td class="loguser"><span>登陆密码：</span><input type="password" name="login_userpwd" maxlength="20" tabindex="99"  > <a href="forgetpassword.php">忘了密码</td></tr>';
			w = w + '<tr><td height="20px"> </td></tr>';
			w = w + '<tr><td align="center"><input type="submit" value="用户登录" > </td></tr>';
			w = w + '<tr><td height="20px"></td></tr>';
			w = w + '</table>';
			w = w + '</form>';
			return w;
			}
		// withauthcode means use authcode
			function  login_withcode_box(){
			var w;
			w = '<form method="post" id="login_form" action="verify.php?action=loginin">';
			w = w + '<table id="popwin" cellPadding="0" class="font_14">';
			w = w + '<tr><td class="title"><span>用户登录</span> <a href="javascript:void(0)" onclick="close_popwin()"></a></td></tr>';
			w = w + '<tr><td height="10px"></td></tr>';
			w = w + '<tr><td class="loguser"><span>用户账号：</span><input type="text" id="login_userid" name="login_userid" maxlength="18" tabindex="97" id="loginuserid"> <a href="register.php">注册新账号</a></td></tr>';
			w = w + '<tr><td height="10px"></td></tr>';
			w = w + '<tr><td class="loguser"><span>登陆密码：</span><input type="password" name="login_userpwd" maxlength="20" tabindex="98"  > <a href="forgetpassword.php">忘了密码</td></tr>';
			w = w + '<tr><td height="10px"></td></tr>';
			w = w + '<tr><td class="loguser"><span>验证码：</span><input type="text" name="loginauthcode" maxlength="4" class="authcode" tabindex="99"><div id="iauthcodediv"></div></td></tr>';
			w = w + '<tr><td height="20px"></td></tr>';
			w = w + '<tr><td align="center"><input type="submit" value="用户登录" ></td></tr>';
			w = w + '<tr><td height="10px"></td></tr>';
			w = w + '</table>';
			w = w + '</form>';
			return w;
			}
