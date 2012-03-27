package com.xunruan.framekork.util;

import java.util.List;

public interface DateModelConvert<E> {
	
	public Object  convert(List<E> list);
	
	public Object  convert(List<E> list,String apiCode);
	
	public Object  convert(E e);
	
	public Object  convert(E e,String apiCode);

}
