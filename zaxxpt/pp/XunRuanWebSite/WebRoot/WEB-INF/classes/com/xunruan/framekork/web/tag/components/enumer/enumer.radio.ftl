<#include "header.ftl" />
<#if parameters.nullPrompt?exists>
	<#if (parameters.grid?default(0) > 0) ><tr><td colspan='${parameters.grid}'><#else><li></#if><#t/>
<input type='<#if (parameters.listSize == 1)>checkbox<#else>radio</#if>' name="${parameters.name?html}" id='__nullPrompt_${parameters.name}' value="<#if parameters.nullValue?exists>${parameters.nullValue}<#else></#if>" <#if parameters.cssClass?exists>class="${parameters.cssClass?html}"</#if>/><#rt/>
<label for='__nullPrompt_${parameters.name}'>${parameters.nullPrompt}</label><#rt/>
	<#if (parameters.grid?default(0) > 0) ></td></tr><#else></li></#if><#lt/>
</#if>
<#assign itemCount = 0/>
<@s.iterator value="parameters.list">
	<#include "item.header.ftl"/>
    <#assign itemKey = stack.findValue(parameters.listKey)/>
    <#assign itemKeyStr = itemKey.toString() />
    <#assign itemValue = stack.findString(parameters.listValue)/>
<input type="<#if (parameters.listSize == 1)>checkbox<#else>radio</#if>"<#rt/>
 name="${parameters.name?html}" value="${itemKeyStr?html}"<#rt/>
	<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
	</#if>
 id="${parameters.name?html}-${itemCount}"<#rt/>
	<#if tag.contains(parameters.nameValue?default(''), itemKeyStr)>
 checked="checked"<#rt/>
	</#if>
	<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
	</#if>
	<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
	</#if>
	<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
	</#if>
	<#include "/${defaultTemplateDir}/simple/scripting-events.ftl" />
	<#include "/${defaultTemplateDir}/simple/common-attributes.ftl" />
/><label for="${parameters.name?html}-${itemCount}">${itemValue}</label><#include "item.footer.ftl"/><#rt/>
    <#assign itemCount = itemCount + 1/>
</@s.iterator>
<#if (parameters.grid?default(0) > 0) ></table><#else></ul></#if><#rt/>
<#if parameters.autoEvent?default(false) >
<script language='javascript'>$(function(){$(':<#if (parameters.listSize == 1)>checkbox<#else>radio</#if>[name=${parameters.name}][checked]').click();});</script><#rt/>
</#if>