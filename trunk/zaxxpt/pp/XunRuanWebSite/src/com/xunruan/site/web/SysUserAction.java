package com.xunruan.site.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunruan.framekork.dao.IBaseDao;
import com.xunruan.framekork.lang.PageInfo;
import com.xunruan.framekork.web.action.BaseAction;
import com.xunruan.site.domain.SysUser;

/***
 * 2012-02-07
 * @author wenz
 * @version 1.0
 */
public class SysUserAction extends BaseAction {
	
	@Resource
	private IBaseDao<SysUser> sysUserDao;
	
	public String execute(){
		PageInfo<SysUser> page=new PageInfo<SysUser>();
		page=sysUserDao.findByParam(SysUser.class, page, "name", "admin");
		System.out.println(page);
		return SUCCESS;
	}

	public IBaseDao<SysUser> getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(IBaseDao<SysUser> sysUserDao) {
		this.sysUserDao = sysUserDao;
	}
	
	
}
