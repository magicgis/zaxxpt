function getEvent(evt){
	evt = evt || window.event;
	
	if (!evt) {
		var c = arguments.callee.caller;
		
		while (c) {
			evt =c.arguments[0];
			if (evt && Event == evt.constructor) {break;}
			c = c.caller;
		}
	}
	
	return evt;
}

function getEventTarget(evt){
	return evt.target ? 
		   evt.target : 
		   ((evt.srcElement) ? evt.srcElement : null);
}
	
function findParentByMethod(src, method, scope) {
	try{
		var args = [src].concat(Array.prototype.slice.call(arguments, 3));
		
		while(!method.apply(scope, args)) args[0] = args[0].parentNode;
		return args[0];
	}catch(err){
		return null;
	}
}
function getDom(id){
	var ele;
	
	if(!id) return null;
	if(typeof id == "string"){
		ele = document.getElementById(id);
	}else{
		ele = id;
	}
	
	return ele;
}
function isNonNullStr(obj){
	return (typeof obj == "string") ?
		!!obj :
		((obj instanceof String) && 
		 (String(obj) !== ""));
}

function trim(str){
	return str ? str.replace(/(^\s+)|\s+$/g , "") : "";
}

function hasClass(ele, css) {
	ele = getDom(ele)
	if(ele && isNonNullStr(css)){
		var re = new RegExp('\\b' + trim(css) + '\\b');
		return re.test(ele.className);
	}
}

function addClass(ele, css){
	ele = getDom(ele)
	if(ele && isNonNullStr(css)){
		if(! hasClass(ele, css) ) ele.className = trim(ele.className) + " " + css;
	}
}

function removeClass(ele, css){
	ele = getDom(ele)
	if(ele && isNonNullStr(css)){
		var re = new RegExp('\\b' + trim(css) + '\\b', "gi");
		ele.className = ele.className.replace(re, " ");
	}
}
//end util methods

function paintSameRangeRows(evt){
	var target = getEventTarget(getEvent(evt));
	var row = findParentByMethod(target, function(ele){
		return ele && ele.getAttribute("speedRange") != null;
	});
	if(row){
		paintActiveRange(row.getAttribute("speedRange"));
	}
}

function findSameRangeRows(range){
	if(!isNonNullStr(range)) return null;
	var table = document.getElementById("pg1");
	if(!table)return null;
	var row,
		rows = table.rows,
		sameRangeRows = [];
	for(var i=0,len=rows.length; i<len; i++){
		row = rows[i];
		if(row.getAttribute("speedRange") == range){
			sameRangeRows.push(row);
		}
	}
	
	return sameRangeRows;
}

function paintRows(rows){
	if(!rows) return;
	for(var i=0,len=rows.length; i<len; i++){
		addClass(rows[i], "active_range_row");
	}
}

function unpaintRows(rows){
	if(!rows) return;
	for(var i=0,len=rows.length; i<len; i++){
		removeClass(rows[i], "active_range_row");
	}
}

var activeRange = "";
function paintActiveRange(active){
	if(typeof active !== "string" || active.length == 0) return false;
	if(active == activeRange) return true;
	var rangeRows = findSameRangeRows(active);
	if(rangeRows && rangeRows.length){
		if(activeRange){
			unpaintRows(findSameRangeRows(activeRange));
		}
		paintRows(rangeRows);
		activeRange = active;
	}
}