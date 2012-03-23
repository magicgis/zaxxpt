/**
 * @fileOverview tmp js file
 * @version 1.0.0
 * @change
    修改者      修改时间         版本       修改描述
*/
/*
rl.provide("tmp", sv.jsRoot);
*/
   /*
      下拉列表框与隐藏表单域名关联操作
     	 sv.SelectorTag 中可以将一个下拉选项框 与 input表单控件 的值进行关联 
      中默认绑定的方法函数名为：inputAttended(inputName,selectorObj);
   */
   function inputAttended(inputName,selName){
       var _inputObj = document.getElementById(inputName);
       var _selObj = document.getElementById(selName);
       var selValue = _selObj.options[_selObj.selectedIndex].text;
       _inputObj.value = selValue;
 }
 

    function inputTreeAttended(inputName,selName){
       var _inputObj = document.getElementById(inputName);
       var _selObj = document.getElementById(selName);
       var selValue = _selObj.options[_selObj.selectedIndex].realValue;
       _inputObj.value = selValue;
 }

/* 将下拉框选中项的显示值赋值给隐藏域 */
function selectChange(sel,hid){
	if(typeof(sel)=="string"){
		sel = rl.getDom(sel);
	}
	rl.getDom(hid).value = sel.options[sel.selectedIndex].text;
}
 
/*** 下拉复选框标签 Begin ***/

/* 下拉复选框类 */
function MckSelector(valueField,textField,nullValue,nullText,valueSeparator,textSeparator){
	this.valueField = valueField;
	this.textField = textField;
	this.nullValue = nullValue;
	this.nullText = nullText;
	this.valueSeparator = valueSeparator;	//隐藏域分隔符
	this.textSeparator = textSeparator;		//显示值分隔符
	this.options = [];						//已选选项数组
}

/* 加入选项 */
MckSelector.prototype.put = function(value,text){
	this.options.push(new MckOption(value,text));
}
/* 移除选项 */
MckSelector.prototype.remove = function(value){
	for(var i=this.options.length-1;i>=0;i--){
		if(this.options[i].value == value){
			this.options.splice(i,1);
		}
	}
}
/* 获取所有所选项value值,多个用逗号隔开 */
MckSelector.prototype.getValue = function(){
	if(this.options.length<=0){
		return this.nullValue;
	}
	var str = "";
	for(var i=0;i<this.options.length;i++){
		str += this.options[i].value;
		if(i<this.options.length-1){
			str += this.valueSeparator;
		}
	}
	if(str == ''){
		str = this.nullValue;
	}
	return str;
}
/* 获取所有所选项text值,多个用逗号隔开 */
MckSelector.prototype.getText = function(){
	if(this.options.length<=0){
		return this.nullText;
	}
	var str = "";
	for(var i=0;i<this.options.length;i++){
		str += this.options[i].text;
		if(i<this.options.length-1){
			str += this.textSeparator;
		}
	}
	if(str == ''){
		str = this.nullText;
	}
	return str;
}
/* 初始化已选值 */
MckSelector.prototype.initOptions = function(values,texts){
	if(values!=''){
		var vs = values.split(this.valueSeparator);
		var ts = texts.split(this.textSeparator);
		for(var i=0;i<vs.length;i++){
			this.put(vs[i],ts[i]);
		}
	}
}

/* 下拉复选框选项类 */
function MckOption(value,text){
	this.value = value;
	this.text = text;
}

/* 存取页面上所有复选下拉框的id,用于鼠标点击下拉框外时隐藏下拉框 */
var MckIds = [];

/* 显示/隐藏选项 */
function MckShowSelect(sid){
	var ele = document.getElementById("MckSelectTag_"+sid);
	var iframe = document.getElementById("MckIframeTag_"+sid);
	if(ele.style.display=='block'){
		ele.style.display="none";
		iframe.style.display="none";
	}else{
		ele.style.display="block";
		iframe.style.display="block";
	}
}

/* 选择/取消选择 */
function MckCheck(mck,idx){
	var cb = document.getElementById("MckCb_"+mck.valueField+"_"+idx);
	var hid = document.getElementById(mck.valueField);
	var inp = document.getElementById(mck.textField);
	
	var text = document.getElementById("MckTxt_"+mck.valueField+"_"+idx).innerHTML;
	var value = document.getElementById("MckHd_"+mck.valueField+"_"+idx).value;

	if(cb.checked){
		mck.put(value,text);
	}else{
		mck.remove(value);
	}
	
	inp.value = mck.getText();
	hid.value = mck.getValue();
}

/* 鼠标点击下拉框以外时隐藏下拉框 */
document.onclick = function(event){
	var e = event||window.event;
	var ele = e.srcElement||e.target;
	for(var i=0;i<MckIds.length;i++){
		if(!inSelectFocus(ele,MckIds[i])){
			document.getElementById("MckSelectTag_"+MckIds[i]).style.display="none";
			document.getElementById("MckIframeTag_"+MckIds[i]).style.display="none";
		}
	}
}
/* 判断鼠标点击是否在下拉框以内 */
function inSelectFocus(ele,mid){
	while(ele){
		if(ele.id=="MckTextTag_"+mid||ele.id=="MckSelectTag_"+mid){
			return true;
		}
		ele = ele.parentNode;
	}
	return false;
}

/*** 下拉复选框标签 End ***/

/* 获取纵向滚动条已滚动高度 */
function getScrollTop()
{
    var scrollTop=0;
    if(document.documentElement&&document.documentElement.scrollTop)
    {
        scrollTop=document.documentElement.scrollTop;
    }
    else if(document.body)
    {
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}

/* 获取横向滚动条已滚动宽度 */
function getScrollLeft()
{
    var scrollLeft=0;
    if(document.documentElement&&document.documentElement.scrollLeft)
    {
        scrollLeft=document.documentElement.scrollLeft;
    }
    else if(document.body)
    {
        scrollLeft=document.body.scrollLeft;
    }
    return scrollLeft;
}