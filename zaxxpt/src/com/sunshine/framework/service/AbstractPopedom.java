package com.sunshine.framework.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sunshine.framework.entity.BaseDomain;
import com.sunshine.framework.entity.SystemRole;
import com.sunshine.framework.entity.SystemUsersRole;

/***
 *@author wenz
 *@Date 2012-3-27����03:14:25
 *@version 1.0
 *@see com.sunshine.framework.service.AbstractPopedom
 ***/
public abstract class AbstractPopedom implements Popedom {

	/**
	 * �鿴List���Ƿ��BaseDomain��ͬID�Ķ���
	 * @param list
	 * @param baseDomain
	 * @return boolean
	 */
	protected boolean constains(List<BaseDomain> list,BaseDomain baseDomain){
		if(list!=null&&list.size()>0&&baseDomain!=null){
			for (BaseDomain domain : list) {
				if(domain.getId().equalsIgnoreCase(baseDomain.getId()))
					return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ����source�а�target�ж���ļ���
	 * @param source
	 * @param target
	 * @return List<BaseDomain>
	 */
	protected List<BaseDomain> constains(List<BaseDomain> source,List<BaseDomain> target){
		List<BaseDomain> list=null;
		if(source!=null&&source.size()>0&&target!=null&&target.size()>0){
			list=new ArrayList<BaseDomain>();
			for (BaseDomain domainSource : source) {
				for (BaseDomain targetSource : target) {
					if(targetSource.getId().equalsIgnoreCase(domainSource.getId()))
						list.add(targetSource);
				}
			}
		}
		return list;
	}

	
	
}
