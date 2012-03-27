/**
 *页面数据分页查询控制,
 *createtime 2011-8-10 15:11:01
 *author lixun
 *
 */
////from   古剑
//var  pageSize=4;//每页多少条记录
//var  cPage=1;//当前页
//// 总记录数
//var recordCount;
//// 总页数
//var  pageCount;
//
//function pageF(page){
//   
//   var tables=document.getElementById("table");
//   var trs=table.rows;
//   
//   //总记录数
//  recordCount=trs.length;
// //取得总页数
//if(recordCount%pageSize>0){
//	pageCount=(recordCount/pageSize)+1;
//	}else{
//	pageCount=recordCount/pageSize;
//	}
////当前页
//	this.page=page;
//	//每页记录数
//		
//	if(this.page<=1){
//		this.page=1;
//	}else if(this.page>=pageCount){
//		this.page=pageCount;
//	}
//   	//判断是否超出总记录数
//			var  k=0,i=0;
//			if((this.page*this.pageSize)>=recordCount){
//				k=recordCount;
//			}else{
//				k=this.page*this.pageSize;
//			}
//i=(this.page-1)*this.pageSize;
//	
//  for(var j=0;j<trs.length;j++){
//    if(j>=i&& j<k){
// 		trs[j].style.display="";	
//    } else{
//    	trs[j].style.display="none";
//    }   
//	
//  }
//  
//  var divPage=document.getElementById("pageSize");
//  divPage.innerHTML="";
//  //输出页码
//  for(var i=1;i<pageCount;i++){
//divPage.innerHTML=divPage.innerHTML+"<span onclick=pageF('"+i+"')>    "+i+"   </span>";
//}
//	  
//}
////end

var  pageSize=4;//每页多少条记录
var  cPage=1;//当前页
//总记录数
var recordCount;
//总页数
var  pageCount;


var currentDisplayTable;//当前活动的div

/**
 * 设置当前活动表格
 * @param tableId
 * @return
 */
function setCurrentDisplayDiv(tableId){
	currentDisplayDiv=document.getElementById("golfOrderTable");
}

