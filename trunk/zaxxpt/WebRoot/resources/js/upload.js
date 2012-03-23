/*
 * ע��:upload.js�ļ�����home.jsp����
 *
 * ����7��uploadFile��ͷ������upload.jsp�ļ������Ƹ�ֵ
 * ���ɵ���upload()����������uploadWindow��close�¼���ȡ������7������
 */
var uploadFile = '';
var uploadFileName = '';
var uploadFileNameExt = '';
var uploadFileNameSize = '';
var uploadFileRemark = '';
var uploadFileUserid = '';
var uploadFileUsername = '';
var uploadFileDate = '';

// �ϴ���������
var uploadWindow;  

// ִ���ϴ��ļ������ű�
function tagFileUpload() {
    var src = jsPath + "/files/upload.action";
	try {
    	var dt=new Date(); 
    	var iframeId="dailogIframe_"+dt.getHours()+""+dt.getMinutes()+""+dt.getSeconds()+""+Math.random(); 
    	var ifame_html="<iframe id='"+iframeId+"' name='uploadFrame' src='"+src+"' style='BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; WIDTH: 100%; BORDER-BOTTOM: 0px; HEIGHT: 100%' frameBorder='0' scrolling='no'></iframe>";  
		
		var width = 400;
		var height = 225;
		
    	uploadWindow = new Ext.Window({ 
                    title: '�ļ��ϴ� (�ļ����ܳ���200M)', 
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
	                    text     : '�ϴ�',
	                    disabled : false,
	                    handler:function(){
	                       var frame = document.frames.uploadFrame;
	                       
	                       if (frame.document.getElementById("file").value == '') {
								Ext.MessageBox.show({
						           title: "��ʾ",
						           msg: "<br>��ѡ���ϴ��ļ�!",
						           buttons: Ext.MessageBox.OK,
						           icon: "ext-mb-warning"
						        });
	                       } else {
		                       frame.document.getElementById("uploadForm").submit();
		                       //uploadWindow.close();
		                   }
	                    }
	                },{
	                    text     : 'ȡ��',
	                    handler  : function(){
	                        uploadWindow.close();
	                    }
	                }] 
                }); 
    	uploadWindow.show(); 
        uploadWindow.on("close",function(p) {
            document.getElementById(iframeId).src=""; 
        });  
        return uploadWindow; 
    }catch(e){
        alert(e);
    }
}

//�����ļ�����ͼƬ
function getFileImage(extName){
    if (!extName)
       return 'othe_ico.gif';
       
    extName = extName.toLowerCase();
    if (extName == 'jpg' || extName == 'gif' || extName == 'bmp' || extName == 'psd' || extName == 'jpge' || extName == 'gif')
       return 'jpg_ico.gif';
    else if (extName == 'html' || extName == 'htm' || extName == 'mht' || extName == 'mhtml')
       return 'html_ico.gif';
    else if (extName == 'jsp' || extName == 'asp' || extName == 'aspx' || extName == 'php')
       return 'asp_ico.gif';
    else if (extName == 'css')
       return 'css_ico.gif';
    else if (extName == 'js')
       return 'js_ico.gif';
    else if (extName == 'xml')
       return 'xml_ico.gif';
    else if (extName == 'sql')
       return 'sql_ico.gif';
    else if (extName == 'doc' || extName == 'dot' || extName == 'rtf')
       return 'doc_ico.gif';
    else if (extName == 'mp3' || extName == 'mp4' || extName == 'wav' || extName == 'avi' || extName == 'mid' || extName == 'asf' || extName == 'wm' || extName == 'wmv' || extName == 'mpge' || extName == 'mpg')
       return 'mp3_ico.gif';
    else if (extName == 'mdb')
       return 'mdb_ico.gif';
    else if (extName == 'mpp' || extName == 'mpt' || extName == 'mpd')
       return 'mpp_ico.gif';
    else if (extName == 'pdf')
       return 'pdf_ico.gif';
    else if (extName == 'ppt' || extName == 'pot' || extName == 'pps' || extName == 'ppa')
       return 'ppt_ico.gif';
    else if (extName == 'rar' || extName == 'zip')
       return 'rar_ico.gif';
    else if (extName == 'rar' || extName == 'rar' || extName == 'rar')
       return 'txt_ico.gif';
    else if (extName == 'txt' || extName == 'ini' || extName == 'log')
	   return 'txt_ico.gif';
	else if (extName == 'vsd' || extName == 'vss' || extName == 'vst')
	   return 'vsd_ico.gif';
	else if (extName == 'xls' || extName == 'xlt' || extName == 'csv')
	   return 'xls_ico.gif';	
    else if (extName == 'exe' || extName == 'com')
	   return 'exe_ico.gif';	
    else 
       return 'othe_ico.gif';
}
