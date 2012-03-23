///////////////////////////////////////////////   
//   ���ܣ��ϲ����   
//   ������tb������Ҫ�ϲ��ı��ID   
//   ������colLength������Ҫ��ǰ���н��кϲ������磬   
//	   ��ϲ�ǰ���У�����������к��Ժϲ���colLengthӦΪ2   
//	   ȱʡ��ʾ��ȫ���кϲ�   
///////////////////////////////////////////////   
function uniteTable(tb, colLength) {
	// ������Ƿ����
	if (!checkTable(tb))
		return;
	var i = 0;
	var j = 0;
	var rowCount = tb.rows.length; // ����
	var colCount = tb.rows[0].cells.length; // ����
	var obj1 = null;
	var obj2 = null;
	// Ϊÿ����Ԫ������
	for (i = 0; i < rowCount; i++) {
		for (j = 0; j < colCount; j++) {
			tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
		}
	}
	// ���м��ϲ�
	for (i = 0; i < colCount; i++) {
		if (i == colLength)
			return;
		obj1 = document.getElementById("tb__0_" + i.toString())
		for (j = 1; j < rowCount; j++) {
			obj2 = document.getElementById("tb__" + j.toString() + "_" + i.toString());
			if (obj1.innerText == obj2.innerText) {
				obj1.rowSpan++;
				obj2.parentNode.removeChild(obj2);
			} else {
				obj1 = document.getElementById("tb__" + j.toString() + "_" + i.toString());
			}
		}
	}
}

// ///////////////////////////////////////
// ���ܣ�������Ƿ����
// ������tb������Ҫ���ı��ID
// ///////////////////////////////////////
function checkTable(tb) {
	if (tb.rows.length == 0)
		return false;
	if (tb.rows[0].cells.length == 0)
		return false;
	for ( var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[0].cells.length != tb.rows[i].cells.length)
			return false;
	}
	return true;
}