function hphmValidate(values) {
	var validateStr = true;
	var hphms = jQuery.trim(values);

	if (hphms.indexOf(" ") > 0) {
		var hphmArray = hphms.split(" ");
		for ( var i = 0; i < hphmArray.length; i++) {
			var hphm = hphmArray[i];
			hphm = hphm.replace('%', '');
			if (hphm.indexOf("%") > 0) {
				Dialog.alert('     [' + hphm + '] 号牌号码中不能含有2个或以上的%号.     ');
				validateStr = false;
			} else {
				if (hphm.length < 5) {
					Dialog.alert('     [' + hphm + '] 号牌号码明确位数不能少于5位.     ');
					validateStr = false;
					break;
				}
			}
		}
	} else {
		hphm = hphms.replace('%', '');
		if (hphm.indexOf("%") > 0) {
			Dialog.alert('     [' + hphm + '] 号牌号码中不能含有2个或以上的%号.     ');
			validateStr = false;
		} else {
			if (hphm.length < 5) {
				Dialog.alert('     [' + hphm + '] 号牌号码明确位数不能少于5位.     ');
				validateStr = false;
			}
		}
	}

	return validateStr;
}


function hphmValidate2(values) {
	var validateStr = true;
	var hphms = jQuery.trim(values);
	if (hphms.indexOf(" ") > 0) {
		var hphmArray = hphms.split(" ");
		if (hphmArray.length > 3) {
			Dialog.alert('     轨迹查询不能超出三个车牌号牌.     ');
			validateStr = false;
		}
		for ( var i = 0; i < hphmArray.length; i++) {
			var hphm = hphmArray[i];
			if (hphm.indexOf("%") > 0) {
				Dialog.alert('     [' + hphms + '] 号牌号码中不能含有%号.     ');
				validateStr = false;
			}
		}
	} else {
		if (hphms.indexOf("%") > 0) {
			Dialog.alert('     [' + hphms + '] 号牌号码中不能含有%号.     ');
			validateStr = false;
		}
	}

	return validateStr;
}
