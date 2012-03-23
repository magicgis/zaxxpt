/**
 * @fileOverview tmp js file
 * @version 1.0.0
 * @change
    �޸���      �޸�ʱ��         �汾       �޸�����
*/
/*
rl.provide("tmp", sv.jsRoot);
*/
   /*
      �����б�������ر�������������
     	 sv.SelectorTag �п��Խ�һ������ѡ��� �� input���ؼ� ��ֵ���й��� 
      ��Ĭ�ϰ󶨵ķ���������Ϊ��inputAttended(inputName,selectorObj);
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

/* ��������ѡ�������ʾֵ��ֵ�������� */
function selectChange(sel,hid){
	if(typeof(sel)=="string"){
		sel = rl.getDom(sel);
	}
	rl.getDom(hid).value = sel.options[sel.selectedIndex].text;
}
 
/*** ������ѡ���ǩ Begin ***/

/* ������ѡ���� */
function MckSelector(valueField,textField,nullValue,nullText,valueSeparator,textSeparator){
	this.valueField = valueField;
	this.textField = textField;
	this.nullValue = nullValue;
	this.nullText = nullText;
	this.valueSeparator = valueSeparator;	//������ָ���
	this.textSeparator = textSeparator;		//��ʾֵ�ָ���
	this.options = [];						//��ѡѡ������
}

/* ����ѡ�� */
MckSelector.prototype.put = function(value,text){
	this.options.push(new MckOption(value,text));
}
/* �Ƴ�ѡ�� */
MckSelector.prototype.remove = function(value){
	for(var i=this.options.length-1;i>=0;i--){
		if(this.options[i].value == value){
			this.options.splice(i,1);
		}
	}
}
/* ��ȡ������ѡ��valueֵ,����ö��Ÿ��� */
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
/* ��ȡ������ѡ��textֵ,����ö��Ÿ��� */
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
/* ��ʼ����ѡֵ */
MckSelector.prototype.initOptions = function(values,texts){
	if(values!=''){
		var vs = values.split(this.valueSeparator);
		var ts = texts.split(this.textSeparator);
		for(var i=0;i<vs.length;i++){
			this.put(vs[i],ts[i]);
		}
	}
}

/* ������ѡ��ѡ���� */
function MckOption(value,text){
	this.value = value;
	this.text = text;
}

/* ��ȡҳ�������и�ѡ�������id,�����������������ʱ���������� */
var MckIds = [];

/* ��ʾ/����ѡ�� */
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

/* ѡ��/ȡ��ѡ�� */
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

/* ���������������ʱ���������� */
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
/* �ж�������Ƿ������������� */
function inSelectFocus(ele,mid){
	while(ele){
		if(ele.id=="MckTextTag_"+mid||ele.id=="MckSelectTag_"+mid){
			return true;
		}
		ele = ele.parentNode;
	}
	return false;
}

/*** ������ѡ���ǩ End ***/

/* ��ȡ����������ѹ����߶� */
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

/* ��ȡ����������ѹ������ */
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