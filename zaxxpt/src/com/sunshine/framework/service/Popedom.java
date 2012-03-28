package com.sunshine.framework.service;

import java.util.List;

import com.sunshine.framework.entity.BaseDomain;
import com.sunshine.framework.entity.SystemRole;

/***
 *@author wenz
 *@Date 2012-3-27����02:00:43
 *@version 1.0
 *@see com.sunshine.framework.service.Popedom
 ***/
public interface Popedom {

	/***
	 * ��ȡ����Ȩ�� �����еĹ���Ȩ�� �����ֶ�Ȩ��
	 * @return List<BaseDomain>
	 */
	public List<BaseDomain>  getPopedom();
	
	/***
	 * ��ȡ��ɫ�б�
	 * @return List<Role>  ��ɫ����
	 */
	public List<SystemRole>  getRole();	
	/***
	 * ��֤ʵ���Ƿ����Ȩ��
	 * @param domain  ʵ��
	 * @return boolean  �Ƿ����Ȩ��
	 */
	public boolean verifyPopedom(BaseDomain domain);
	
	/***
	 * ��֤List�е�ʵ���Ƿ����Ȩ�޲��ҷ��ؾ���Ȩ�޵�ʵ��
	 * @param list ʵ�弯��
	 * @return List<BaseDomain>  ����Ȩ��ʵ�弯��
	 */
	public List<BaseDomain> verifyPopedom(List<BaseDomain> list);
	
	/***
	 * ͨ��ʵ��ID��֤�Ƿ����Ȩ��
	 * @param id Ȩ��ID
	 * @return boolean �Ƿ����Ȩ��
	 */
	public boolean verifyPopedom(String id);
	
	/***
	 * Ȩ����֤  ,����Ϊһ�����飬����֤Field ������Ϊ[0]����Դ����,[1]������,[2]�ֶ�����
	 * @param args ����
	 * @return boolean  �Ƿ����Ȩ��
	 */
	public boolean verifyPopedom(String... args);
	
	/***
	 * ������Դ ���Ϊ�ֶ�������ֶ����ڵ���Դ  ���Ϊ��������˹������ڵ���Դ ���Ϊ��Դ��Ϊ���˺����Դ
	 * @return List<BaseDomain>
	 */
	public List<BaseDomain> filterSource();
	
	
}
