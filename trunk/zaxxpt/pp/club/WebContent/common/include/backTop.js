/**
*使页面回到顶部,并且不用在浏览器中显示锚,没有特殊效果只是用来代替锚点的效果
*author lixun
*createDate 2011-9-15 
*/

function backTop(){
	$('body,html').animate({scrollTop:0},1000);
	return false;
}