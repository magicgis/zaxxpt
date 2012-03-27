<#--
	template = parameters.template
	theme = parameters.theme
	templateDir = parameters.templateDir
--><@s.iterator status="status" value="parameters.list">
        <#if stack.findValue(parameters.listKey)?exists>
          <#assign itemKey = stack.findValue(parameters.listKey)/>
          <#assign itemKeyStr = itemKey.toString()/>
        <#else>
          <#assign itemKey = ''/>
          <#assign itemKeyStr = ''/>
        </#if>
        <#if stack.findString(parameters.listValue)?exists>
          <#assign itemValue = stack.findString(parameters.listValue)/>
        <#else>
          <#assign itemValue = ''/>
        </#if>
        <#if tag.contains(parameters.nameValue, itemKey) == true>
<#if parameters.escape>${itemValue?html}<#else>${itemValue}</#if><@s.if test="not #status.last">${parameters.split!" "}</@s.if><#rt/>
        </#if>
</@s.iterator>