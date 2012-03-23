//·µ»ØÎÄ¼þÍ¼Æ¬
function getFileImage(v){
    if (v == 'jpg' || v == 'gif' || v == 'bmp' || v == 'psd' || v == 'jpge' || v == 'gif')
       return 'jpg_ico16.gif';
    else if (v == 'html' || v == 'htm' || v == 'jsp' || v == 'asp' || v == 'aspx' || v == 'php' || v == 'mht' || v == 'mhtml')
       return 'html_ico16.gif';
    else if (v == 'doc' || v == 'dot' || v == 'rtf')
       return 'doc_ico16.gif';
    else if (v == 'mp3' || v == 'mp4' || v == 'wav' || v == 'avi' || v == 'mid' || v == 'asf' || v == 'wm' || v == 'wmv' || v == 'mpge' || v == 'mpg')
       return 'mp3_ico16.gif';
    else if (v == 'mdb')
       return 'mdb_ico16.gif';
    else if (v == 'mpp' || v == 'mpt' || v == 'mpd')
       return 'mpp_ico16.gif';
    else if (v == 'pdf')
       return 'pdf_ico16.gif';
    else if (v == 'ppt' || v == 'pot' || v == 'pps' || v == 'ppa')
       return 'ppt_ico16.gif';
    else if (v == 'rar' || v == 'zip')
       return 'rar_ico16.gif';
    else if (v == 'rar' || v == 'rar' || v == 'rar')
       return 'txt_ico16.gif';
    else if (v == 'txt' || v == 'ini' || v == 'log')
	   return 'txt_ico16.gif';
	else if (v == 'vsd' || v == 'vss' || v == 'vst')
	   return 'vsd_ico16.gif';
	else if (v == 'xls' || v == 'xlt' || v == 'csv')
	   return 'xls_ico16.gif';	
    else if (v == 'exe' || v == 'com')
	   return 'exe_ico16.gif';	
    else 
       return 'othe_ico16.gif';
}