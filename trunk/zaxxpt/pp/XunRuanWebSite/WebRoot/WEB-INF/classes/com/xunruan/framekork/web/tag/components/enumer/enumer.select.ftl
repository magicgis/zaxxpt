<select<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")?exists>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id?exists>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.multiple?default(false)>
 multiple="multiple"<#rt/>
</#if>
<#include "/${defaultTemplateDir}/simple/scripting-events.ftl" />
<#include "/${defaultTemplateDir}/simple/common-attributes.ftl" />
>
<#if parameters.nullPrompt?exists>
	<#if parameters.nullValue?exists>
    <option value="${parameters.nullValue?html}">${parameters.nullPrompt}</option>
	<#lt /><#else>    <option value="">${parameters.nullPrompt}</option>
    </#if>
</#if>
<@s.iterator value="parameters.list">
	<#assign itemKey = stack.findValue(parameters.listKey)/>
	<#assign itemKeyStr = itemKey.toString()/>
	<#assign itemValue = stack.findString(parameters.listValue)/>
    <option value="${itemKeyStr?html}"<#rt/>
        <#if tag.contains(parameters.nameValue, itemKey) == true>
 selected="selected"<#rt/>
		</#if>
        <#if parameters.extraInfoMap?exists><#list parameters.extraInfoMap?keys as key>
        	<#assign value = (stack.findString(parameters.extraInfoMap[key]))?default("") />
 ${key?html}="${value?html}"<#rt/>
        </#list></#if>
    >${itemValue?html}</option><#lt/>
</@s.iterator>
</select><#rt/>
<#if parameters.extraInfoValueMap?exists><#list parameters.extraInfoValueMap?keys as key>
<input type="hidden" name="${key}" value="${parameters.extraInfoValueMap[key]}" />
</#list></#if>
<#if parameters.extraInfoScript?exists >
<script language='javascript'>$(function(){var j=$('select[name=${parameters.name}]');if (j.get(0).onchange) {j.get(0).orig_onchange=j.get(0).onchange;j.get(0).onchange=null;}j.change(function(){${parameters.extraInfoScript}if (this.orig_onchange) this.orig_onchange();});});</script><#rt/>
</#if>
<#if parameters.autoEvent?default(false) >
<script language='javascript'>$(function(){$('select[name=${parameters.name}]').change();});</script><#rt/>
</#if>