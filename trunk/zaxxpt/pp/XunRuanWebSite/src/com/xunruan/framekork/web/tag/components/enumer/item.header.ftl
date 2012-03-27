<#if (parameters.grid?default(0) > 0) >
	<#if ((itemCount % parameters.grid) == 0) >
		<#if (itemCount != 0)>
</tr>
		</#if>
<tr><#rt/>
	</#if>
<td><#rt/>
<#else>
<li><#rt/>
</#if>