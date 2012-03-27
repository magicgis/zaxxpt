
var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_moz = (navigator.product == 'Gecko') && userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera) && userAgent.substr(userAgent.indexOf('msie') + 5, 3);
var is_ie6 = is_ie && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);

function $(id) {
	return document.getElementById(id);
}

function in_array(needle, haystack) {
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}

function setcopy(text, alertmsg){
	if(is_ie) {
		clipboardData.setData('Text', text);
		alert(alertmsg);
	} else if(prompt('Press Ctrl+C Copy to Clipboard', text)) {
		alert(alertmsg);
	}
}

function isUndefined(variable) {
	return typeof variable == 'undefined' ? true : false;
}

function checkFocus() {
	var g_editor_doc=getEditorobj();
	g_editor_doc.focus();
	}


function doane(event) {
	e = event ? event : window.event;
	if(is_ie) {
		e.returnValue = false;
		e.cancelBubble = true;
	} else if(e) {
		e.stopPropagation();
		e.preventDefault();
	}
}
 
 function searchfocus(id){
	if($(id).value=="请输入搜索内容"){
		$(id).value="";
	}
 }


 function submitsearch(t){
	 if($("searchword").value=="" || $("searchword").value=="请输入搜索内容"){
		return alert("请输入查询内容");
	 }
	 var searchword=$('searchword').value;
	 if(searchword.indexOf('&') != -1){
		searchword=searchword.substr(0,searchword.indexOf('&'));
	 }
	//return alert(searchword);
	if(t=="article_search_btn"){
		window.location.href="search.php?searchword="+searchword+"&type=1";
	}else if(t=="product_search_btn"){
		window.location.href="search.php?searchword="+searchword+"&type=2";
	}else if(t=="thread_search_btn"){
		window.location.href="search.php?searchword="+searchword+"&type=3";
	}
 }

function strlen(str) {
	return (is_ie && str.indexOf('\n') != -1) ? str.replace(/\r?\n/g, '_').length : str.length;
}

function char_strlen(str) {
	var charset = document.charset;
	var len = 0;
	for(var i = 0; i < str.length; i++) {
		len += str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255 ? (charset == 'utf-8' ? 3 : 2) : 1;
	}
	return len;
}

function in_array(needle, haystack) {
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}


function redirect(url) {
	window.location.replace(url);
}




function checkall(checkid, b) {
	for(i=0; i<50; i++){
		var obj = $(checkid + "_check_" + i);
		if(obj != null){
			obj.checked = b;
		}
	}
}


function checkall_onclick(checkid) {

	if($(checkid + '_check_all').checked == true){
		checkall(checkid, true);
	}else{
		checkall(checkid, false);
	}
}


function is_checked(checkid) {
	for(i=0; i<50; i++){
		var obj = $(checkid + "_check_" + i);
		if(obj != null){
			if(obj.checked == true){
			return true;
			}
		}
	  }
	  return false;
	}


function mergecategory(type){
	   	var con=confirm("您确定要合并分类吗？");
		var sval=$('sourcecategory').value;
		var dval=$('destinationcategory').value;
		 if(sval=='0' || sval=='0,0' || dval=='0' || dval=='0,0'){
					return alert("不能为根分类");
		}
		if (con==true) {
			obj=$("merge"+type+"category");
			obj.action="siteadmin.php?iframe=" + type + "category&ipost=merge";
			obj.submit();
		}
}
//变量c表示子分类的数量
function delcategory(type,pid,cid,c){
	var typename= ['article','product','forum'];
	var con=confirm("您确定要删除分类吗？\n分类删除后，归属于该分类的所有信息全部会被删除");
		if (con==true) {
			if(pid==0 && c!=0){
				return alert("该分类存在子分类，请先删除子分类");
			}
			window.location.href="siteadmin.php?iframe=" + typename[type] + "category&ipost=delete&pid="  + pid + "&cid=" + cid;
	}
}


function submitcheck(type){

	if($('cid').value=='0,0'){
		alert("请选择分类,不能为根分类");
		return false;
	}
	var titlecount=char_strlen($(type+'title').value);
	if(titlecount>120 || titlecount<1){
		alert("标题字符数必须大于0个字符,且不能超过120字符");
		return false;
	}

	if(type=="product"){
		var introcount=char_strlen($(type+'intro').value);
		if($('prointro_param_1')!=null){
		var paramintrocount=char_strlen($('prointro_param_1').value);
		}
		if(introcount>600 || paramintrocount>600){
			alert("产品简介字符数不能超过600个字符");
			return false;
		}
		var allowedext=new Array('jpg','gif','png');
		var path = $('logoimg').value;
		var ext = path.lastIndexOf('.') == -1 ? '' : path.substr(path.lastIndexOf('.') + 1, path.length).toLowerCase();
		if(!in_array(ext,allowedext)){
			alert("不能将该附件作为产品标示图");
			return false;
		}
	}
	var contentcount=char_strlen($('g_editor_doc').value);
	if(contentcount>15000 || contentcount<1){
		alert("内容字符数必须大于0个字符,且不能超过15000字符");
		return false;
	}
}



function changeface(index){
	var icon=new Array('01c.png','02c.png','03c.png','04c.png','05c.png','06c.png','07c.png','08c.png','09c.png','10c.png','11c.png','12c.png','13c.png','14c.png','15c.png','16c.png','17c.png','18c.png','19c.png','20c.png','21c.png','22c.png','23c.png','24c.png','25c.png');
	var viewface=new Array('01.png','02.png','03.png','04.png','05.png','06.png','07.png','08.png','09.png','10.png','11.png','12.png','13.png','14.png','15.png','16.png','17.png','18.png','19.png','20.png','21.png','22.png','23.png','24.png','25.png');
	$("faceview").innerHTML="<img src=\"images\/userface\/"+viewface[index]+"\">";
	$("newface").value=viewface[index];
}

function changeauthcode(){
	var rand = Math.random();
		$("iauthcodediv").innerHTML="<img src=\"authcode.php?update=" + rand + " \" onclick=\"changeauthcode()\" style=\"cursor: pointer;\">";
} 

function postthread(forid){
	window.location.href="post.php?action=pubthread&forid="+forid;
}
function postproduct(pid,categoryid){
	window.location.href="post.php?action=pubproduct&pid=" + pid + "&categoryid=" + categoryid;
}
function postarticle(pid,categoryid){
	window.location.href="post.php?action=pubarticle&pid=" + pid + "&categoryid=" + categoryid;
}