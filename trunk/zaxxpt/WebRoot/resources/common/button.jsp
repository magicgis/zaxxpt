<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<form id="viewForm" name="viewForm" action="${URI}_view.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="viewSelectID" name="selectID" value="${selectID}" >
</form>

<form id="appendForm" name="appendForm" action="${URI}_append.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="appendSelectID" name="selectID" value="${selectID}" >
</form>

<form id="copyForm"   name="copyForm"   action="${URI}_copy.action"   method="post" style="margin:0;padding:0;" >
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="copySelectID" name="selectID" value="${selectID}" >
</form>

<form id="modifyForm" name="modifyForm" action="${URI}_modify.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="modifySelectID" name="selectID" value="${selectID}" >
</form>

<form id="deleteForm" name="deleteForm" action="${URI}_delete.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="deleteSelectID" name="selectID" value="${selectID}" >
</form>

<form id="exportForm" name="exportForm" action="${URI}_export.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
</form>

<form id="searchForm" name="searchForm" action="${URI}_search.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="method" name="method" value="" >
   <input type="hidden" id="searchQuick" name="searchEntity.searchQuick" value="" >
   <input type="hidden" id="searchCmd"   name="searchEntity.searchCmd" value="" >
   <input type="hidden" id="searchDesc"  name="searchEntity.searchDesc" value="" >
</form>

<form id="returnForm" name="returnForm" action="${URI}_list.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
</form>

<form id="priorForm" name="priorForm" action="${URI}_prior.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="viewSelectID" name="selectID" value="${selectID}" >
</form>

<form id="nextForm" name="nextForm" action="${URI}_next.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="viewSelectID" name="selectID" value="${selectID}" >
</form>

<form id="viewForm" name="viewForm" action="${URI}_view.action" method="post" style="margin:0;padding:0;">
   <input type="hidden" id="menuid" name="menuid" value="${menuid}" >
   <input type="hidden" id="viewSelectID" name="selectID" value="${selectID}" >
</form>


<div id="toolbar" style="<c:if test="${method eq 'enter' || method eq 'list' || method eq 'page' || method eq 'find' || method eq 'search'}">border-left: #99bbe8 1px solid;</c:if> border-right: #99bbe8 1px solid;width: 100%"></div>


<%--
显示buttion

parameter(
	append,copy,modify,delete,
	cursor,
	tools,find,export,print,log,
	quick,
	return
)
--%>

<script>
//可能被重写方法
function copys() {
	top.copys($o('copyForm'), (typeof grid == 'undefined' ? null : grid), $o('copySelectID'));
}

var toolbar = null;

Ext.onReady(function(){
    var disabledTips = '${param.disabledTips}';
    if (disabledTips == '') {
		//Ext.QuickTips.init();
	}
		
	//Ext.form.Field.prototype.msgTarget = 'side';
	
    var ToolMenu = new Ext.menu.Menu({
        id: 'ToolsMenu',
        items: [
			
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'find'}">            	
			        {
				        text: '查询',
				        handler: function(){top.finds($o('searchForm'), '${URI}_search.action?method=window', $o('method'), $o('searchCmd'), $o('searchDesc'));},
				        iconCls: 'find',
				        tooltip: '<b>高级查询</b><br/>与快速查询不同的是,他支持栏位指定查询'
			        },'-',
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'export'}">
	            	{
				        text: '导出Excel',
				        handler: function(){top.exports($o('exportForm'), (typeof grid == 'undefined' ? null : grid));},
				        <c:if test="${accessPower.useexport ne '1'}">
				        disabled: true,
				        </c:if>
						<c:if test="${accessPower.useexport eq '1' && method eq 'view'}">  
				        disabled: true,
				        </c:if>
				        iconCls: 'export'
	            	},
				</c:if>
	 	    </c:forTokens>
	 	    
	 	    <c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'print'}">
		            {
		            	text: '打印',
			        	handler: function(){alert('print');},
						<c:if test="${accessPower.useprint ne '1'}">
				        disabled: true,
				        </c:if>
				        iconCls: 'print'
	            	},'-',
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'log'}">  	            
		            {
						text: '查看操作日志',
				        handler: function(){
				                            var logsID = null;
				                            if (typeof grid != "undefined") {
						        					var selectedRows = grid.getSelectionModel().getSelections();  
												    if(selectedRows.length==0){
												        Ext.MessageBox.show({
												           title: "提示",
												           msg: "<br>请选择查看日志的记录!",
												           buttons: Ext.MessageBox.OK,
												           icon: "ext-mb-warning"
												        });
												        return;
												    } else if (selectedRows.length > 1) {
													    Ext.MessageBox.show({
												           title: "提示",
												           msg: "<br>不能选择多行记录查看,一次只能查看一行记录. 请重试!",
												           buttons: Ext.MessageBox.OK,
												           icon: "ext-mb-warning"
												        });
												        return;
												    }
												    logsID = selectedRows[0].data.id;
											} else {
												    logsID = '${selectID}';
											}
										    
				        	top.logsShow("${menuid}", logsID);
				        },
				        iconCls: 'log'
		            },
				</c:if>
	 	    </c:forTokens>
	 	    
	 	    {
				text: '查看详细',
		        handler: function(){top.views($o('viewForm'), (typeof grid == "undefined" ? null : grid), $o('viewSelectID'));},
		        <c:if test="${method eq 'view'}">  
		        disabled: true,
		        </c:if>
		        iconCls: 'view'
            }
        ]
    });
    
    var quick = new Ext.form.TextField({
		id:'searchText',
		name:'searchText',
		value:'${searchEntity.searchQuick}',
		width:100
	});
    
    
    
    
    <%--  正式处理......  --%>
    toolbar = new Ext.Toolbar();
    toolbar.render('toolbar');

    <c:if test="${method eq 'view' || method eq 'enter' || method eq 'list' || method eq 'page' || method eq 'find' || method eq 'search'}">
        <%--处理新建、复制、修改、删除--%>
		toolbar.add(
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'append'}">
				    {
				    text: '新建',
			        handler: function(){top.appends($o('appendForm'));},
			        iconCls: 'append',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '您无新建权限'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
			          tooltip: '<b>新建操作</b><br/>单击新建进入表单'
			        </c:if>
				    },
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'copy'}">	 	    
			        {
			        text: '复制',
			        handler: function(){copys();},
			        iconCls: 'copy',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '您无复制权限'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
					  tooltip: '<b>复制选择的记录</b><br/>注意:一次只能复制一条记录信息'
			        </c:if>
				    },
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'modify'}">
				    {
				    text: '修改',
				    handler: function(){top.modifys($o('modifyForm'), (typeof grid == 'undefined' ? null : grid), $o('modifySelectID'));},
				    iconCls: 'modify',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '您无修改权限'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
				      tooltip: '<b>修改选择的记录</b><br/>注意:一次只能修改一条记录信息'
			        </c:if>
					},
				</c:if>
	 	    </c:forTokens>
			
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'delete'}">
			        {
			        text: '删除',
			        handler: function(){top.deletes($o('deleteForm'), (typeof grid == 'undefined' ? null : grid), $o('deleteSelectID'));},
			        iconCls: 'delete',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '您无删除权限'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
				      tooltip: '<b>删除选择的记录</b><br/>注意:可以选择多条记录批量删除'
			        </c:if>
					},
				</c:if>
	 	    </c:forTokens>
		'-');


        <%--处理上一笔、下一笔--%>    
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'cursor'}">
			    <c:if test="${method eq 'view'}">  
				    toolbar.add({text: '上一笔',
				        handler: function(){$o("priorForm").submit();},
				        iconCls: 'prior',
				        tooltip: '向上翻阅一条记录'
				    },{
						text: '下一笔',
				        handler: function(){$o("nextForm").submit();},
				        iconCls: 'next',
				        tooltip: '向下翻阅一条记录'
				    },'-');
				</c:if>
			</c:if>
 	    </c:forTokens>
		
		<%--处理工具--%>
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'tools'}">		
			    toolbar.add({
			        text:'高级功能',
			        iconCls: 'tools',
			        menu: ToolMenu
			    }); 
			</c:if>
 	    </c:forTokens>
		
	</c:if>
    
    
	<%--处理保存取消--%>
    <c:if test="${method eq 'append' || method eq 'copy' || method eq 'modify'}">
	    toolbar.add({
	        text: '保存',
	        handler: function(){top.saves($o('saveForm'));},
	        iconCls: 'saves',
	        tooltip: '注意:红色提示不能为空'
	    },{
	        text: '取消',
	        handler: function(){$o('returnForm').submit();},
	        iconCls: 'cancel'
	    });
    </c:if>


	<%--处理保存取消--%>
   	<c:if test="${method eq 'view'}">  
	   	<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'return'}">		
			    toolbar.add(
			    '-',
			    {
			    	text: '返回',
			        handler: function(){$o('returnForm').submit();},
			        iconCls: 'result'
			    });
	        </c:if>
	   	</c:forTokens>
	</c:if>
     
    <%--处理保存取消--%>
    <c:if test="${method eq 'view' || method eq 'enter' || method eq 'list' || method eq 'page' || method eq 'find' || method eq 'search'}">
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'quick'}">
	            toolbar.addFill(); 
	            toolbar.add('快速查询:');
			    toolbar.addField(quick);
			    toolbar.add({
			        text: '',
			        handler: function(){top.searchs($o("searchForm"), $o("method"), $o("searchQuick"), $o("searchText"));},
			        iconCls: 'search',
			        tooltip: '快速查询'
			    });
			</c:if>
	    </c:forTokens>
	</c:if>
	
	toolbar.doLayout();
});

/*Grid ID的View JS*/
function idView(val, params, record) {   
   return '<a href="${URI}_view.action?menuid=${menuid}&selectID='+record.data.id+'">' + val + '</a>';
}

</script>
  
