/*
 * 
 */
jQuery.fn.limit=function(){ 
    var self = $("div[limit]"); 
    self.each(function(){ 
        var objString = $(this).text(); 
        var objLength = $(this).text().length; 
        var num = $(this).attr("limit"); 
        if(objLength > num){ 
$(this).attr("title",objString); 
            objString = $(this).text(objString.substring(0,num) + "..."); 
        } 
    }) 
} 
$(document).ready(function () {
	$("ul.menu_body").each(function(index, item) {
		$('ul#' + item.id + ' li:even').addClass("alt");
		$('ul#' + item.id + ' li a:even').addClass("alt");
		});
	$('div.menu_head').each(function(index, menuHead){
		var id = menuHead.id;
		var left = $("#"+id).position().left;//menuHead.offsetLeft;
		//var top  = menuHead.offsetTop + menuHead.offsetHeight;
		var top  = $("#"+id).position().top + menuHead.offsetHeight;
    	$('ul#' + id + '_menu').css({"position": "absolute", "left": left, "top": top, 'margin': 0});
	    $('div#'+id).hover(function () {
	    	$('div#' + id).addClass("menu_head_hover");
			$('ul#' + id + '_menu').stop(false, true).slideDown('normal');
	    	},
	    	function () {
	    	$('div#' + id).removeClass("menu_head_hover");
			$('ul#' + id + '_menu').stop(false, true).slideUp('normal');
	    });
	});
	$('ul.menu_body li a').mouseover(function () {
		$(this).animate({ fontSize: "14px", paddingLeft: "20px" }, 50 );
    });
	$('ul.menu_body li a').mouseout(function () {
		$(this).animate({ fontSize: "12px", paddingLeft: "10px" }, 50 );
    });
});