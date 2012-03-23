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
��ʾbuttion

parameter(
	append,copy,modify,delete,
	cursor,
	tools,find,export,print,log,
	quick,
	return
)
--%>

<script>
//���ܱ���д����
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
				        text: '��ѯ',
				        handler: function(){top.finds($o('searchForm'), '${URI}_search.action?method=window', $o('method'), $o('searchCmd'), $o('searchDesc'));},
				        iconCls: 'find',
				        tooltip: '<b>�߼���ѯ</b><br/>����ٲ�ѯ��ͬ����,��֧����λָ����ѯ'
			        },'-',
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'export'}">
	            	{
				        text: '����Excel',
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
		            	text: '��ӡ',
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
						text: '�鿴������־',
				        handler: function(){
				                            var logsID = null;
				                            if (typeof grid != "undefined") {
						        					var selectedRows = grid.getSelectionModel().getSelections();  
												    if(selectedRows.length==0){
												        Ext.MessageBox.show({
												           title: "��ʾ",
												           msg: "<br>��ѡ��鿴��־�ļ�¼!",
												           buttons: Ext.MessageBox.OK,
												           icon: "ext-mb-warning"
												        });
												        return;
												    } else if (selectedRows.length > 1) {
													    Ext.MessageBox.show({
												           title: "��ʾ",
												           msg: "<br>����ѡ����м�¼�鿴,һ��ֻ�ܲ鿴һ�м�¼. ������!",
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
				text: '�鿴��ϸ',
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
    
    
    
    
    <%--  ��ʽ����......  --%>
    toolbar = new Ext.Toolbar();
    toolbar.render('toolbar');

    <c:if test="${method eq 'view' || method eq 'enter' || method eq 'list' || method eq 'page' || method eq 'find' || method eq 'search'}">
        <%--�����½������ơ��޸ġ�ɾ��--%>
		toolbar.add(
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'append'}">
				    {
				    text: '�½�',
			        handler: function(){top.appends($o('appendForm'));},
			        iconCls: 'append',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '�����½�Ȩ��'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
			          tooltip: '<b>�½�����</b><br/>�����½������'
			        </c:if>
				    },
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'copy'}">	 	    
			        {
			        text: '����',
			        handler: function(){copys();},
			        iconCls: 'copy',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '���޸���Ȩ��'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
					  tooltip: '<b>����ѡ��ļ�¼</b><br/>ע��:һ��ֻ�ܸ���һ����¼��Ϣ'
			        </c:if>
				    },
				</c:if>
	 	    </c:forTokens>
	 	    
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'modify'}">
				    {
				    text: '�޸�',
				    handler: function(){top.modifys($o('modifyForm'), (typeof grid == 'undefined' ? null : grid), $o('modifySelectID'));},
				    iconCls: 'modify',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '�����޸�Ȩ��'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
				      tooltip: '<b>�޸�ѡ��ļ�¼</b><br/>ע��:һ��ֻ���޸�һ����¼��Ϣ'
			        </c:if>
					},
				</c:if>
	 	    </c:forTokens>
			
			<c:forTokens items="${param.show}" delims="," var="item">
		        <c:if test="${item eq 'delete'}">
			        {
			        text: 'ɾ��',
			        handler: function(){top.deletes($o('deleteForm'), (typeof grid == 'undefined' ? null : grid), $o('deleteSelectID'));},
			        iconCls: 'delete',
			        <c:if test="${accessPower.usewrite ne '1'}">
			          disabled: true,
			          tooltip: '����ɾ��Ȩ��'
			        </c:if>
			        <c:if test="${accessPower.usewrite eq '1'}">
				      tooltip: '<b>ɾ��ѡ��ļ�¼</b><br/>ע��:����ѡ�������¼����ɾ��'
			        </c:if>
					},
				</c:if>
	 	    </c:forTokens>
		'-');


        <%--������һ�ʡ���һ��--%>    
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'cursor'}">
			    <c:if test="${method eq 'view'}">  
				    toolbar.add({text: '��һ��',
				        handler: function(){$o("priorForm").submit();},
				        iconCls: 'prior',
				        tooltip: '���Ϸ���һ����¼'
				    },{
						text: '��һ��',
				        handler: function(){$o("nextForm").submit();},
				        iconCls: 'next',
				        tooltip: '���·���һ����¼'
				    },'-');
				</c:if>
			</c:if>
 	    </c:forTokens>
		
		<%--������--%>
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'tools'}">		
			    toolbar.add({
			        text:'�߼�����',
			        iconCls: 'tools',
			        menu: ToolMenu
			    }); 
			</c:if>
 	    </c:forTokens>
		
	</c:if>
    
    
	<%--������ȡ��--%>
    <c:if test="${method eq 'append' || method eq 'copy' || method eq 'modify'}">
	    toolbar.add({
	        text: '����',
	        handler: function(){top.saves($o('saveForm'));},
	        iconCls: 'saves',
	        tooltip: 'ע��:��ɫ��ʾ����Ϊ��'
	    },{
	        text: 'ȡ��',
	        handler: function(){$o('returnForm').submit();},
	        iconCls: 'cancel'
	    });
    </c:if>


	<%--������ȡ��--%>
   	<c:if test="${method eq 'view'}">  
	   	<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'return'}">		
			    toolbar.add(
			    '-',
			    {
			    	text: '����',
			        handler: function(){$o('returnForm').submit();},
			        iconCls: 'result'
			    });
	        </c:if>
	   	</c:forTokens>
	</c:if>
     
    <%--������ȡ��--%>
    <c:if test="${method eq 'view' || method eq 'enter' || method eq 'list' || method eq 'page' || method eq 'find' || method eq 'search'}">
		<c:forTokens items="${param.show}" delims="," var="item">
	        <c:if test="${item eq 'quick'}">
	            toolbar.addFill(); 
	            toolbar.add('���ٲ�ѯ:');
			    toolbar.addField(quick);
			    toolbar.add({
			        text: '',
			        handler: function(){top.searchs($o("searchForm"), $o("method"), $o("searchQuick"), $o("searchText"));},
			        iconCls: 'search',
			        tooltip: '���ٲ�ѯ'
			    });
			</c:if>
	    </c:forTokens>
	</c:if>
	
	toolbar.doLayout();
});

/*Grid ID��View JS*/
function idView(val, params, record) {   
   return '<a href="${URI}_view.action?menuid=${menuid}&selectID='+record.data.id+'">' + val + '</a>';
}

</script>
  
