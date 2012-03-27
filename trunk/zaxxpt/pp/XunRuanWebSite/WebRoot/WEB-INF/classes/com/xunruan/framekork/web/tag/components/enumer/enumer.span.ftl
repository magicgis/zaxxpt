<@s.iterator value="parameters.list">
    <#assign itemKey = stack.findValue(parameters.listKey)/>
    <#assign itemKeyStr = itemKey.toString() />
    <#assign itemValue = stack.findString(parameters.listValue)/>
    <#if tag.contains(parameters.nameValue, itemKey) == true>
<span<#rt/>
<#if parameters.id?exists>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#include "/${defaultTemplateDir}/simple/scripting-events.ftl" />
<#include "/${defaultTemplateDir}/simple/common-attributes.ftl" />
><#if parameters.escape>${itemValue?html}<#else>${itemValue}</#if></span><#rt/>
        </#if>
</@s.iterator>