package com.system.dict.entity;

import com.sunshine.framework.entity.BaseEntity;
import com.sunshine.framework.entity.annotation.FieldMethod;
import com.sunshine.framework.entity.annotation.TableMethod;

@TableMethod(TableName = "system_dict")
public class DictEntity implements BaseEntity {
	@FieldMethod(IsField = true, IsPK = true,AutoKey=true)
	private String id;

	@FieldMethod(IsField = true)
	private String dicttype;
	
	@FieldMethod(IsField = true)
	private String dictcode;

	@FieldMethod(IsField = true)
	private String dictname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDicttype() {
		return dicttype;
	}

	public void setDicttype(String dicttype) {
		this.dicttype = dicttype;
	}

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

}
