<#if (parameters.grid?default(0) > 0) >
</td>
	<#if (itemCount == (parameters.listSize - 1)) >
		<#assign remainder = (parameters.grid - itemCount % parameters.grid - 1) />
		<#if (remainder > 0) ><#list (1 .. remainder) as i>
<td></td>
		</#list></#if>
</tr><#t/>
	</#if>
<#else>
</li>
</#if>