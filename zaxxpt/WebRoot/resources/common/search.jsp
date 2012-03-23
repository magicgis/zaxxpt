<%@page language="java" contentType="text/html;charset=GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="ext" uri="/ext3" %>
<ext:html>

  <head>
	 <title>�߼���ѯ</title>
	 <ext:init href="${path}" lang="CN" />
	 <link rel="stylesheet" type="text/css" href="${path}/resources/css/body.css" />
	 <link rel="stylesheet" type="text/css" href="${path}/resources/css/font_style.css" />
  </head>


<script>
       // �ֶ�����
       function getFieldType() {
			var type = "";
            
       		var fieldtype = $o("fieldName").value.split(",");
       		
       		if (fieldtype.length > 1) {
	       		types = fieldtype[0].split(".");
       		    type = types[types.length-1];
       		} else {
       		    type = $o("fieldName").value;
       		}
       		return type;
       }
       
       // �ֶ�ѡ��
       function selectField() {
            var type = getFieldType();
       		$o("return").innerHTML = "���";
       		
   		    $o("stringWhere").style.marginLeft    = "-1000px";
   		    $o("integerWhere").style.marginLeft   = "-1000px";
   		    $o("booleanWhere").style.marginLeft   = "-1000px";
   		    $o("dateWhere").style.marginLeft      = "-1000px";
      		    
   		    $o("stringValue").style.marginLeft    = "-1000px";
   		    $o("sdIntegerValue").style.marginLeft = "-1000px";
  		    $o("integerValue").style.marginLeft   = "-1000px";
   		    $o("booleanValue").style.marginLeft   = "-1000px";
   		    $o("sdDateValue").style.marginLeft    = "-1000px";
   		    $o("dateValue").style.marginLeft      = "-1000px";
       		           		
       		if (type == "String") {
       		    $o("stringWhere").style.marginLeft    = "5px";
       		    $o("stringValue").style.marginLeft    = "5px";
       		} else if (type == "Integer" || type == "Double" || type == "Float") {
         		$o("return").innerHTML = "��";
       		    $o("integerWhere").style.marginLeft   = "5px";
       		    $o("sdIntegerValue").style.marginLeft = "5px";
       		} else if (type == "Boolean") {
       		    $o("booleanWhere").style.marginLeft   = "5px";
       		    $o("booleanValue").style.marginLeft   = "5px";
       		} else if (type == "Date") {
        		$o("return").innerHTML = "��";
       		    $o("dateWhere").style.marginLeft    = "5px";
       		    $o("sdDateValue").style.marginLeft  = "5px";
       		}
       }
       
       // ��������ѡ��
       function selectDateWhere() {
            var date = $o("dateWhereId").value;
            
            if (date == '��...֮��' || date =='����...֮��') {
                $o("return").innerHTML = "��";
                $o("sdDateValue").style.marginLeft = "5px";
                $o("dateValue").style.marginLeft = "-1000px";
            } else {
                $o("return").innerHTML = "���";
                $o("sdDateValue").style.marginLeft = "-1000px";
                $o("dateValue").style.marginLeft = "5px";
            }
       }
       
       // ��������ѡ��
       function selectIntegerWhere() {
            var integer = $o("integerWhereId").value;
            
            if (integer == '��...֮��' || integer =='����...֮��') {
		        $o("return").innerHTML = "��";
                $o("sdIntegerValue").style.marginLeft = "5px";
                $o("integerValue").style.marginLeft = "-1000px";
            } else {
                $o("return").innerHTML = "���";
                $o("sdIntegerValue").style.marginLeft = "-1000px";
                $o("integerValue").style.marginLeft = "5px";
            }
       }
       
       // ȡ����ѡ���ֶ�����
       function getField(encn) {
    	   var fieldname = $o("fieldName").value.split(",");
    	   var type = getFieldType();

    	   // ��ֲ Oracle
      	   if (type == "Date") {
      		 	return (encn == "en" ? "to_char(" + fieldname[fieldname.length-1] + ",'yyyy-mm-dd')" : $o("fieldId").value) + " ";
      	   } else {
      		    return (encn == "en" ? fieldname[fieldname.length-1] : $o("fieldId").value) + " ";
      	   }
            
       }
       
       // ȡ����ѡ����
       function getWhere(encn) {
            var type = getFieldType();
       		var result = "";
       		
       		if (type == "String") {
       		    result = (encn == "en" ? $o("stringWhereName").value : $o("stringWhereId").value);
       		} else if (type == "Integer" || type == "Double" || type == "Float") {
       		    result = (encn == "en" ? $o("integerWhereName").value : $o("integerWhereId").value);
       		} else if (type == "Boolean") {
       		    result = (encn == "en" ? $o("booleanWhereName").value : $o("booleanWhereId").value);
       		} else if (type == "Date") {
       		    result = (encn == "en" ? $o("dateWhereName").value : $o("dateWhereId").value);
       		}

       	    return result + " ";
       }
       
       // ȡ������ѯֵ
       function getValue(where) {
      		var type = getFieldType();
       		var result = "";

       		if (type == "String") {
       		    result = $o("stringValueName").value;
       		    
       		} else if (type == "Integer" || type == "Double" || type == "Float") {
	       		var integer = $o("integerWhereName").value;

	            if (integer == 'between' || integer =='not between')
	                result = $o("startIntegerValueName").value + "' And '" + $o("endIntegerValueName").value;
	            else
	                result = $o("integerValueName").value;
       		    
       		} else if (type == "Boolean") {
	       		if (document.getElementsByName("booleanValueName")[0].checked) {result = "1";} else {result = "0";}
	       		
       		} else if (type == "Date") {
	       		var date = $o("dateWhereName").value;

	            if (date == 'between' || date =='not between')
	                result = $o("startDateValueName").value + "' And '" + $o("endDateValueName").value;
	            else
	                result = $o("dateValueName").value;
	            
       		}
       		
       		if (where.trim() != "") {
       			if (where.trim() == "like" || where.trim() == "not like")
       		    	result = "'%" + result + "%'";
       		   	else
       		   	    result = "'" + result + "'";
       		}
       		           		
       	    return result;
       }
       
       // ��ȡand or
       function getAndOr(encn) {
			var aoEn = "";
			var aoCn = "";
			
		    if (document.getElementsByName("andor")[0].checked) {
		        aoEn = " and ";
		        aoCn = " ���� "
		    } else {
		        aoEn = " or ";
		        aoCn = " ���� ";
		    }
		        
			return (encn == "en" ? aoEn : aoCn);
       }
       
       // ���SQL���
	   function addSQL() {
		    var searchDesc = $o("searchDesc").value.trim();      //�������SQL����
		    var searchCmd  = $o("searchCmd").value.trim();       //�������SQL�ű�
		    
		    
		    if (searchCmd == "")
	  		    $o("searchCmd").value  =                  getField('en') + getWhere('en') + getValue(getWhere('en'));
		    else
		    	$o("searchCmd").value += getAndOr('en') + getField('en') + getWhere('en') + getValue(getWhere('en'));
		    
		    if (searchDesc == "")
			    $o("searchDesc").value  = "����ѯ������\n          " +                    getField('cn') + getWhere('cn') + getValue('');
		    else
			    $o("searchDesc").value += "\n     " + getAndOr('cn') + "\n          " + getField('cn') + getWhere('cn') + getValue('');

		    //alert($o("searchCmd").value);
		    
			$o("stringValueName").value = '';    
            $o("integerValueName").value = '';
            $o("startDateValueName").value = '';
            $o("endDateValueName").value = '';
            $o("dateValueName").value = '';
	   }
	   
</script>

<body>
	<ext:load href="${path}"/>
	
	<div style="margin-top: 5px;margin-left: 10px;" class="IE6">
	    ��ѯ����
	</div>
	
	<div style="margin-top: 10px;margin-left: 10px;float: left;" class="TextBlack">
	    ����
	</div>
	<div style="margin-top: 5px;margin-left: 5px;float: left;">
	    <ext:combobox id="fieldId" hiddenName="fieldName" name="fieldName_" size="1000" width="100" blank="true" list="${fieldList}" onselect="selectField();"/>
	</div>
	
	
	<div style="margin-top: 10px;margin-left: 20px;float: left;" class="TextBlack">
	    ����
	</div>
    <div id="stringWhere"  style="margin-top: 5px;margin-left: 5px;float: left;">
       	<ext:combobox id="stringWhereId" hiddenName="stringWhereName" name="stringWhereName_" size="1000" width="90" blank="true" list="${stringList}"/>
  	</div>
  	<div id="integerWhere" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <ext:combobox id="integerWhereId" hiddenName="integerWhereName" name="integerWhereName_" size="1000" width="90" blank="true" list="${integerList}" onselect="selectIntegerWhere();"/>
    </div>
    <div id="booleanWhere" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <ext:combobox id="booleanWhereId" hiddenName="booleanWhereName" name="booleanWhereName_" size="1000" width="90" blank="true" list="${booleanList}"/>
    </div>
    <div id="dateWhere"    style="margin-top: 5px;margin-left: -1000px;float: left;">
        <ext:combobox id="dateWhereId" hiddenName="dateWhereName" name="dateWhereName_" size="1000" width="90" blank="true" list="${dateList}" onselect="selectDateWhere();"/>
	</div>
	

	<div id="return" style="margin-top: 10px;margin-left: 20px;float: left;" class="TextBlack">
	    ���
	</div>	
	<%--String����--%>
    <div id="stringValue"  style="margin-top: 5px;margin-left: 5px;float: left;">
        <ext:edit id="stringValueId" name="stringValueName" size="1000" width="120" blank="true"/>
    </div>
    
    <%--Start-End��������--%>
    <div id="sdIntegerValue" style="margin-top: 5px;margin-left: -1000px;float: left;">
		<div style="float: left;">
           <ext:number id="startIntegerValueId" name="startIntegerValueName" size="1000" width="90" blank="true"/>
        </div>
        <div style="margin-top: 5px;margin-left: 8px;float: left;" class="TextBlack">��</div>
        <div style="margin-left:8px; float: left;">
           <ext:number id="endIntegerValueId" name="endIntegerValueName" size="1000" width="90" blank="true"/>
        </div>
    </div>
    <div id="integerValue" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <ext:number id="integerValueId" name="integerValueName" size="1000" width="120" blank="true"/>
    </div>    
    
    <%--Boolean����--%>
    <div id="booleanValue" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <label><input type="radio" name="booleanValueName" value="1"  class="TextBlack" checked="checked" />��</label>
	    <label><input type="radio" name="booleanValueName" value="0" class="TextBlack" />��</label> 
	</div>
	
	<%--Start-End��������--%>
	<div id="sdDateValue" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <div style="float: left;">
           <ext:startDate id="startDateValueId" name="startDateValueName" size="20" width="95" endDate="endDateValueId" blank="true"/>
        </div>
        <div style="margin-top: 5px;margin-left: 8px;float: left;" class="TextBlack">��</div>
        <div style="margin-left:8px; float: left;">
           <ext:endDate id="endDateValueId" name="endDateValueName" size="20" width="95" startDate="startDateValueId" blank="true"/>
        </div>
	</div>
	
	<%--Date����--%>
    <div id="dateValue" style="margin-top: 5px;margin-left: -1000px;float: left;">
        <ext:date id="dateValueId" name="dateValueName" size="20" width="90" blank="true"/>
	</div>
	
	
	
	<div style="margin-top: 5px;margin-left: 15px;float: left;">
	    <img src="${path}/resources/images/addfind.gif" border="0" onclick="addSQL();" style="cursor: pointer;">
	</div>	
	
	<table width="100%" border="0" cellspacing="4" cellpadding="0" class="TextBlack">
   	  <tr style="height: 2px;">
	    <td></td>
	  </tr>
	  <tr>
	    <td>
	        &nbsp;
			<label><input type="radio" name="andor" value=" and " checked="checked" />����</label>
			<label><input type="radio" name="andor" value=" or " />����</label>
		</td>
	  </tr>
	  <tr>
	    <td height="200" valign="top">
	        <textarea readonly="readonly" id="searchDesc" name="searchDesc" style="height: 195px;width: 620px;" class=" x-form-textarea x-form-field">
	        </textarea>
	        <input type="hidden" id="searchCmd" name="searchCmd">
	    </td>
	  </tr>
	</table>
	
</body>
</ext:html>
