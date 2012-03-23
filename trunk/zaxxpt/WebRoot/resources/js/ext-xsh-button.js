function views(form, grid, selectid) {
   var selectedRows = grid.getSelectionModel().getSelections();  
   if(selectedRows.length==0){ 
        Ext.MessageBox.show({
           title: "提示",
           msg: "<br>请选择查看记录!",
           buttons: Ext.MessageBox.OK,
           icon: "ext-mb-warning"
        });
        return;
   } else if (selectedRows.length > 1) {
	    Ext.MessageBox.show({
           title: "提示",
           msg: "<br>不能选择多行记录查看,一次只能查看一行记录. 请重试!",
           buttons: Ext.MessageBox.OK,
           icon: "ext-mb-warning"
        });
        return;
   }
   selectid.value = selectedRows[0].data.id;
   form.submit();
}

function appends(form) {
   form.submit();
}

function copys(form, grid, selectid) {
   if (selectid.value != '') {
      form.submit();
      return;
   }
   
   if (grid != null) {
	   var selectedRows = grid.getSelectionModel().getSelections();  
	   if(selectedRows.length==0){
	        Ext.MessageBox.show({
	           title: "提示",
	           msg: "<br>请选择需被复制的记录!",
	           buttons: Ext.MessageBox.OK,
	           icon: "ext-mb-warning"
	        });
	        return;
	   } else if (selectedRows.length > 1) {
	        Ext.MessageBox.show({
	           title: "提示",
	           msg: "<br>不能选择多行记录复制,一次只能复制一行记录. 请重试!",
	           buttons: Ext.MessageBox.OK,
	           icon: "ext-mb-warning"
	        });
	        return;
	   }
	   selectid.value = selectedRows[0].data.id;
	   form.submit();
	   return;
   } 
   
   Ext.MessageBox.show({
        title: "提示",
        msg: "<br>请选择需被复制的记录.",
        buttons: Ext.MessageBox.OK,
        icon: "ext-mb-warning"
   });
}

function modifys(form, grid, selectid) {
   if (selectid.value != '') {
      form.submit();
      return;
   }
   
   if (grid != null) {
	   var selectedRows = grid.getSelectionModel().getSelections();  
	   if(selectedRows.length==0){ 
	        Ext.MessageBox.show({
	           title: "提示",
	           msg: "<br>请选择需被修改的记录!",
	           buttons: Ext.MessageBox.OK,
	           icon: "ext-mb-warning"
	        });
	        return;
	   } else if (selectedRows.length > 1) {
	        Ext.MessageBox.show({
	           title: "提示",
	           msg: "<br>不能选择多行记录修改,一次只能修改一行记录. 请重试!",
	           buttons: Ext.MessageBox.OK,
	           icon: "ext-mb-warning"
	        });
	        return;
	   }
	   selectid.value = selectedRows[0].data.id;
	   form.submit();
	   return;
   } 

   Ext.MessageBox.show({
        title: "提示",
        msg: "<br>请选择需被修改的记录.",
        buttons: Ext.MessageBox.OK,
        icon: "ext-mb-warning"
   });
}

function deletes(form, grid, selectid) {
   var str = ""; 
   
   if (selectid.value != '') {
      str = selectid.value + ",";
   } else {
	   if (grid != null) {
		   var selectedRows = grid.getSelectionModel().getSelections();  
		   if(selectedRows.length==0) {
		   		Ext.MessageBox.show({
		           title: "提示",
		           msg: "<br>请选择需被删除的记录!",
		           buttons: Ext.MessageBox.OK,
		           icon: "ext-mb-warning"
		        });
		        return;
		   }
		   
		   for (var i = 0; i <selectedRows.length; i++) {
		      str += selectedRows[i].data.id + ","; 
		   }
	   } else if (selectid.value == '') {
	       Ext.MessageBox.show({
		           title: "提示",
		           msg: "<br>请选择需被删除的记录.",
		           buttons: Ext.MessageBox.OK,
		           icon: "ext-mb-warning"
		        });
	       return;
	   }
   }
   
   if(str) {
       Ext.MessageBox.confirm('提示...', "<br>是否确定删除已选择记录?", 
          function(btn) {
             if(btn == "yes") {
    	         str = str.substring(0,str.length-1);
  	             selectid.value = str;
	             form.submit();
	         }
          }
       );
    }
}

function exports(form, grid) {
   if(grid == null || grid.getView().getRows().length==0){ 
        Ext.MessageBox.show({
           title: "提示",
           msg: "<br>无数据导出!",
           buttons: Ext.MessageBox.OK,
           icon: "ext-mb-warning"
        });
        return;
   }
   form.submit();
}

function finds(form, src, method, searchCmd, searchDesc) {
	try {
    	var dt=new Date(); 
    	var iframeId="dailogIframe_"+dt.getHours()+""+dt.getMinutes()+""+dt.getSeconds()+""+Math.random(); 
    	var ifame_html="<iframe id='"+iframeId+"' name='findWindow' src='"+src+"' style='BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; WIDTH: 100%; BORDER-BOTTOM: 0px; HEIGHT: 100%' frameBorder='0' scrolling='no'></iframe>";  
		
		var width = 650;
		var height = 360;
		
    	var win=new Ext.Window({ 
                    title: '高级查询', 
                    layout:'fit',
	                resizable:false,
                    closable:true, 
                    width:width, 
                    height:height, 
                    modal:true,
                    border:false, 
                    plain:true, 
                    closeAction:'close',                  
                    items: [ 
	                    new Ext.Panel({
  	                        border:true,
		                    height:height,
	    	                html:ifame_html
	                    })
                    ],
                    buttons: [{
	                    text     : '显示全部',
	                    disabled : false,
	                    handler:function(){ 
	                       method.value     = "find";
	                       searchCmd.value  = "";
	                       searchDesc.value = "";
	                       form.submit();
	                       win.hide();
	                    }
	                },{
	                    text     : '开始查询',
	                    disabled : false,
	                    handler:function(){ 
	                       var frame = document.frames.findWindow;
	                       method.value     = "find";
	                       searchCmd.value  = frame.document.getElementById("searchCmd").value;
	                       searchDesc.value = frame.document.getElementById("searchDesc").value;
	                       form.submit();
	                       win.close();
	                    }
	                },{
	                    text     : '取消',
	                    handler  : function(){
	                        win.close();
	                    }
	                }] 
                }); 
    	win.show(); 
        win.on("close",function(p) {
            document.getElementById(iframeId).src=""; 
        });  
        return win; 
    }catch(e){
        alert(e);
    }
}

function searchs(form, method, searchQuick, searchText) {
 	method.value      = "search";
    searchQuick.value = searchText.value;
	form.submit();
}

function saves(form) {
   if (form.onsubmit()) {
	   Ext.MessageBox.show({
	       msg: '<br>正在保存,请稍后......',
	       progressText: 'Saving...',
	       width:300,
	       wait:true,
	       waitConfig: {interval:200},
	       icon:'ext-mb-download'
	   });
	   form.submit();
   }
}

function savesuccess() {
   Ext.MessageBox.hide();
}
