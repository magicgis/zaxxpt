1.<#if links?size != 0>   
2.<div class="link">   
3.        <strong>”—«È¡¥Ω”£∫</strong>   
4.        <#list links as link>   
5.        <a href="${link.linkUrl}" target="_blank" title="${link.linkName}">${link.linkName}</a>   
6.        </#list>   
7.</div>   
8.<#else>   
9.<div class="link"></div>   
10.</#if>  