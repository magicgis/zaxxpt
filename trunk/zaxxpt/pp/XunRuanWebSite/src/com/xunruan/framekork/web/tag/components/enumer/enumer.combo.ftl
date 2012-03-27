<#--
    不支持使用nullPrompt选项，当使用此选项时，若元素已有默认值，
    则第一次改变选择时将不会触发textChange事件，从而导致用户
    看上去没有值，但实际提交了初始值到服务器。
-->
<#include "enumer.select.ftl" />
<input type="hidden" name="${parameters.name?default("")?html}" value="${parameters.nameValue?html}"/>
<#if !stack.findValue("#jquery_combox_js_included")?exists><#t/>
    <link href="${request.contextPath}/enumer/combo/sexy-combo.cssx" rel="stylesheet" type="text/css" />
    <link href="${request.contextPath}/enumer/combo/sexy/sexy.cssx" rel="stylesheet" type="text/css" />
	<script language="javascript" src="${request.contextPath}/enumer/combo/jquery.sexy-combo-2.0.6.pack.jsx" ></script>
	<#assign temporaryVariable = stack.setValue("#jquery_combox_js_included", "true") /><#t/>
</#if><#t/>
<script>$(function(){
  	$("select[name=${parameters.name?default("")?html}]").sexyCombo({
  		suffix:"_c1",
  		hiddenSuffix:"_c2",
  		initialHiddenValue:"--x--",<#-- 此初始值用于判断用户是手工输入的值，还是通过选择框选择的值。 -->
  		<#if false && parameters.nullPrompt?exists>emptyText:"${parameters.nullPrompt?html}",</#if><#-- 因为上面的原因不支持此选项 -->
  		filterFn: function() { 
  			return true; 
  		},
  		textChangeCallback: function() {
  			$("input[name=${parameters.name?default("")?html}]").val(("--x--"==this.getHiddenValue())?this.getTextValue():this.getHiddenValue());
  		}
  	});
  	<#if (parameters.nameValue?default("") != "") >
  	$(":input[name=${parameters.name?default("")?html}_c1]").val("${parameters.nameValue?html}");
  	<#else>
  	$(":input[name=${parameters.name?default("")?html}_c1]").val("${parameters.nullPrompt?default("")?html}");
  	</#if>
  	$(":input[name=${parameters.name?default("")?html}_c1]").removeAttr("name");<#-- 去掉name属性以避免无效数据传递到服务器，但只在firefox下有效，IE下无法去除元素的name属性。 -->
  	$(":input[name=${parameters.name?default("")?html}_c2]").attr("disabled", "disabled").removeAttr("name");<#-- 避免无效数据传递到服务器 -->
  	$("select[name=${parameters.name?default("")?html}]").attr("disabled", "disabled").removeAttr("name");<#-- 避免无效数据传递到服务器 -->
});</script>