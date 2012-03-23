// 日志窗口属性
var logsWindow;  

function logsShow(menuid, id) {
    var src = jsPath + "/system/logs_list.action?menuid=" + menuid + "&selectID=" + id;
	try {
    	var dt=new Date(); 
    	var iframeId="dailogIframe_"+dt.getHours()+""+dt.getMinutes()+""+dt.getSeconds()+""+Math.random(); 
    	var ifame_html="<iframe id='"+iframeId+"' name='logsFrame' src='"+src+"' style='BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; WIDTH: 100%; BORDER-BOTTOM: 0px; HEIGHT: 100%' frameBorder='0' scrolling='no'></iframe>";  
		
		var width = 600;
		var height = 350;
		
    	logsWindow = new Ext.Window({ 
                    title: '操作日志历史', 
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
  	                        border:false,
		                    height:height,
	    	                html:ifame_html
	                    })
                    ],
                    buttons: [{
	                    text     : ' 关 闭 ',
	                    handler  : function(){
	                        logsWindow.close();
	                    }
	                }] 
                }); 
    	logsWindow.show(); 
        logsWindow.on("close",function(p) {
            document.getElementById(iframeId).src=""; 
        });  
        return logsWindow; 
    }catch(e){
        alert(e);
    }
}
