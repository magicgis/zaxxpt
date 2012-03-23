///////////////////////////////////////////////   
//   功能：合并表格   
//   参数：tb－－需要合并的表格ID   
//   参数：colLength－－需要对前几列进行合并，比如，   
//	   想合并前两列，后面的数据列忽略合并，colLength应为2   
//	   缺省表示对全部列合并   
///////////////////////////////////////////////   
function uniteTable(tb, colLength) {
	// 检查表格是否规整
	if (!checkTable(tb))
		return;
	var i = 0;
	var j = 0;
	var rowCount = tb.rows.length; // 行数
	var colCount = tb.rows[0].cells.length; // 列数
	var obj1 = null;
	var obj2 = null;
	// 为每个单元格命名
	for (i = 0; i < rowCount; i++) {
		for (j = 0; j < colCount; j++) {
			tb.rows[i].cells[j].id = "tb__" + i.toString() + "_" + j.toString();
		}
	}
	// 逐列检查合并
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
// 功能：检查表格是否规整
// 参数：tb－－需要检查的表格ID
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