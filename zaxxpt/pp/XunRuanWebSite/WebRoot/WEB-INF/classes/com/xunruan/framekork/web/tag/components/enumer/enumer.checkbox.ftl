<#include "header.ftl" />
<#if parameters.checkAll?default(false)>
	<#if (parameters.grid?default(0) > 0) ><tr><td colspan='${parameters.grid}'><#else><li></#if><#t/>
<input type='checkbox' id='__checkAll_${parameters.name}'<#rt/>
		<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
		</#if>
 onclick='var self=this;$(":checkbox[name=${parameters.name}]").each(function(){this.checked=self.checked;});'><#rt/>
<label for='__checkAll_${parameters.name}'>全选/取消</label><#rt/>
	<#if (parameters.grid?default(0) > 0) ></td></tr><#else></li></#if>
</#if>
<#assign itemCount = 0/>
<@s.iterator status="status" value="parameters.list">
	<#include "item.header.ftl"/>
    <#assign itemKey = stack.findValue(parameters.listKey)/>
	<#assign itemKeyStr=itemKey.toString() />
    <#assign itemValue = stack.findString(parameters.listValue)/>
<input type="checkbox" name="${parameters.name?html}" value="${itemKeyStr?html}"<#rt/>
		<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
		</#if>
 id="${parameters.name?html}-${itemCount}"<#rt/>
    <#if tag.contains(parameters.nameValue, itemKey)>
 checked="checked"<#rt/>
    </#if>
    <#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
    </#if>
    <#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
    </#if>
    <#include "/${defaultTemplateDir}/simple/scripting-events.ftl" />
    <#include "/${defaultTemplateDir}/simple/common-attributes.ftl" />
/><label for="${parameters.name?html}-${itemCount}">${itemValue?html}</label><#include "item.footer.ftl"/><#rt/>
    <#assign itemCount = itemCount + 1/>
</@s.iterator>
<#if (parameters.grid?default(0) > 0) ></table><#else></ul></#if><#rt/>
<#if parameters.autoEvent?default(false) >
<script language='javascript'>$(function(){$(':checkbox[name=${parameters.name}][checked]').click();});</script><#rt/>
</#if>