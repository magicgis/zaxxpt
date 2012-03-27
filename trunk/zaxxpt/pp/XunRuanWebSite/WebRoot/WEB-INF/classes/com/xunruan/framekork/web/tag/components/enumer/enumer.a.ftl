<@s.iterator value="parameters.list" status="st">
<#assign itemKey = stack.findValue(parameters.listKey)/>
<#assign itemKeyStr = itemKey.toString()/>
<#assign itemValue = stack.findString(parameters.listValue)/>
<a<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")?exists>
 size="${parameters.get("size")?html}"<#rt/>
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
 href="${itemKeyStr?html}"<#rt/>
<#include "/${defaultTemplateDir}/simple/scripting-events.ftl" />
<#include "/${defaultTemplateDir}/simple/common-attributes.ftl" />
>${itemValue?html}</a><@s.if test="not #st.last"><br /></@s.if>
</@s.iterator>