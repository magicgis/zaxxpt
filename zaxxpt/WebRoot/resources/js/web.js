function hphmValidate(values) {
	var validateStr = true;
	var hphms = jQuery.trim(values);

	if (hphms.indexOf(" ") > 0) {
		var hphmArray = hphms.split(" ");
		for ( var i = 0; i < hphmArray.length; i++) {
			var hphm = hphmArray[i];
			hphm = hphm.replace('%', '');
			if (hphm.indexOf("%") > 0) {
				Dialog.alert('     [' + hphm + '] ���ƺ����в��ܺ���2�������ϵ�%��.     ');
				validateStr = false;
			} else {
				if (hphm.length < 5) {
					Dialog.alert('     [' + hphm + '] ���ƺ�����ȷλ����������5λ.     ');
					validateStr = false;
					break;
				}
			}
		}
	} else {
		hphm = hphms.replace('%', '');
		if (hphm.indexOf("%") > 0) {
			Dialog.alert('     [' + hphm + '] ���ƺ����в��ܺ���2�������ϵ�%��.     ');
			validateStr = false;
		} else {
			if (hphm.length < 5) {
				Dialog.alert('     [' + hphm + '] ���ƺ�����ȷλ����������5λ.     ');
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
			Dialog.alert('     �켣��ѯ���ܳ����������ƺ���.     ');
			validateStr = false;
		}
		for ( var i = 0; i < hphmArray.length; i++) {
			var hphm = hphmArray[i];
			if (hphm.indexOf("%") > 0) {
				Dialog.alert('     [' + hphms + '] ���ƺ����в��ܺ���%��.     ');
				validateStr = false;
			}
		}
	} else {
		if (hphms.indexOf("%") > 0) {
			Dialog.alert('     [' + hphms + '] ���ƺ����в��ܺ���%��.     ');
			validateStr = false;
		}
	}

	return validateStr;
}
