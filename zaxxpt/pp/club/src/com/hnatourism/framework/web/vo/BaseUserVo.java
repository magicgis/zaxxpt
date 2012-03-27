package com.hnatourism.framework.web.vo;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * 登录用户请继承该类
 * @author zhangyun
 *
 */
public class BaseUserVo extends AbstractVo implements java.io.Serializable ,UserDetails{
	//唯一标识
	private String id ;
	//用户帐号(也是唯一的，字母+数字)
	private String userCode ;
	//用户名称
	private String username ;
	//密码
	private String password ;
	private String ip ;
	
	//acegi授权
	private GrantedAuthority[] authorities;
	
	@Override
	public GrantedAuthority[] getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}