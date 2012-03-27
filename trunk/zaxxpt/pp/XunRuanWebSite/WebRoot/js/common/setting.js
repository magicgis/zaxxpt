function aquery(id){

		if(id=="timeslice"){
			$("qtxt").value=$('g_calendar_year_start').value + ',' + $('g_calendar_month_start').value + ',' + $('g_calendar_day_start').value;
			$("qtxt").value +=';' + $('g_calendar_year_end').value + ',' + $('g_calendar_month_end').value + ',' + $('g_calendar_day_end').value;
		}else{
			$("qtxt").value=$(id).value;
		}
		$("articlequery").action="siteadmin.php?iframe=articlemanagement&ipost=query&action="+id;
		$("articlequery").submit();	
	}

function pquery(id){

		if(id=="timeslice"){
			$("qtxt").value=$('g_calendar_year_start').value + ',' + $('g_calendar_month_start').value + ',' + $('g_calendar_day_start').value;
			$("qtxt").value +=';' + $('g_calendar_year_end').value + ',' + $('g_calendar_month_end').value + ',' + $('g_calendar_day_end').value;
		}else{
			$("qtxt").value=$(id).value;
		}
		$("productquery").action="siteadmin.php?iframe=productmanagement&ipost=query&action="+id;
		$("productquery").submit();	
	}

function tquery(id){

		if(id=="timeslice"){
			$("qtxt").value=$('g_calendar_year_start').value + ',' + $('g_calendar_month_start').value + ',' + $('g_calendar_day_start').value;
			$("qtxt").value +=';' + $('g_calendar_year_end').value + ',' + $('g_calendar_month_end').value + ',' + $('g_calendar_day_end').value;
		}else{
			$("qtxt").value=$(id).value;
		}
		$("threadquery").action="siteadmin.php?iframe=threadmanagement&ipost=query&action="+id;
		$("threadquery").submit();	
	}



function asetting(executepage,id,pid,categoryid){
		if(id=='delete'){
			if(!is_checked('article')&&!is_checked('top_article')){
					return alert("没有文章被选中");
			}
			var con=confirm("您确定删除被选中文章的所有信息吗");
			if (con==true) {
				$("form_articlelist").action= executepage+"ipost=setarticle&pid="+pid+"&categoryid="+categoryid+"&action="+id;
				$("form_articlelist").submit();
				return;
				}else{
			return;
			}
		}
		if(id=='unsettop'){
			if(!is_checked('top_article')){
				return alert("没有文章被选中");
			}
			$("form_articlelist").action=executepage+"ipost=setarticle&pid="+pid+"&categoryid="+categoryid+"&action="+id;
			$("form_articlelist").submit();
		}else{
			if(!is_checked('article')&&!is_checked('top_article')){
					return alert("没有文章被选中");
			}
			$("form_articlelist").action=executepage+"ipost=setarticle&pid="+pid+"&categoryid="+categoryid+"&action="+id;
			$("form_articlelist").submit();
		}
}


function psetting(executepage,id,pid,categoryid){
		if(id=='delete'){
			if(!is_checked('product')&&!is_checked('top_product')){
					return alert("没有产品被选中");
			}
			var con=confirm("您确定删除被选中产品的所有信息吗");
			if (con==true) {
				$("form_productlist").action= executepage+"ipost=setproduct&pid="+pid+"&categoryid="+categoryid+"&action="+id;
				$("form_productlist").submit();
				return;
				}else{
			return;
			}
		}
		if(id=='unsettop'){
			if(!is_checked('top_product')){
				return alert("没有产品被选中ssss");
			}
			$("form_productlist").action=executepage+"ipost=setproduct&pid="+pid+"&categoryid="+categoryid+"&action="+id;
			$("form_productlist").submit();
		}else{
			if(!is_checked('product')&&!is_checked('top_product')){
					return alert("没有产品被选中");
			}
			$("form_productlist").action=executepage+"ipost=setproduct&pid="+pid+"&categoryid="+categoryid+"&action="+id;
			$("form_productlist").submit();
		}
}


function tsetting(executepage,id,forid){
		if(id=='delete'){
			if(!is_checked('thread')&&!is_checked('top_thread')){
					return alert("没有主题被选中");
			}
			var con=confirm("您确定删除被选中主题的所有信息吗");
			if (con==true) {
				$("form_threadlist").action= executepage+"ipost=setthread&forid="+forid+"&action="+id;
				$("form_threadlist").submit();
				return;
				}else{
			return;
			}
		}
		if(id=='unsettop'){
			if(!is_checked('top_thread')){
				return alert("没有主题被选中");
			}
			$("form_threadlist").action=executepage+"ipost=setthread&forid="+forid+"&action="+id;
			$("form_threadlist").submit();
		}else{
				if(!is_checked('thread')&&!is_checked('top_thread')){
					return alert("没有主题被选中");
			}
			$("form_threadlist").action=executepage+"ipost=setthread&forid="+forid+"&action="+id;
			$("form_threadlist").submit();
		}
}

function onetsetting(id,forid){
	if(id=='delete'){
			var con=confirm("您确定删除被选中主题的所有信息吗");
			if (con==true) {
				$("one_threadlist").action= "post.php?ipost=setthread&forid="+forid+"&action="+id;
				$("one_threadlist").submit();
				return;
				}
		}else{
				$("one_threadlist").action= "post.php?ipost=setthread&forid="+forid+"&action="+id;
				$("one_threadlist").submit();
				return;
		}
}


	function showmoveform(){
		if($("moveform").style.display=="none"){
			$("moveform").style.display="";
			$("move_select_cid").focus();
		}else{
			$("moveform").style.display="none";
		}		
	}

function delreply(rid,typeid){
			var con=confirm("您确定删除该回复信息的所有信息吗");
			if (con==true) {
				window.location.href="post.php?action=deletereply&rid="+rid;
				return;
		}
	}

function delmembermsg(){
			if(!is_checked('msg')){
				return alert("没有短消息被选中");
		}
			var con=confirm("您确定删除选中的短消息吗");
			if (con==true) {
				$("form_msglist").action= "panel.php?action=deletemsg"
				$("form_msglist").submit();
		}
	}


