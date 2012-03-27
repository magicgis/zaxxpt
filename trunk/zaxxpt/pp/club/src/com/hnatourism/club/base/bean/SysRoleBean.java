package com.hnatourism.club.base.bean;

public class SysRoleBean {

	
		private String id ;
		/**
		 * 角色名称（也是唯一的）
		 */
		private String sysRoleName ;
		/**
		 * 角色的英文名
		 */
		private String roleKey ;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getSysRoleName() {
			return sysRoleName;
		}
		public void setSysRoleName(String sysRoleName) {
			this.sysRoleName = sysRoleName;
		}
		public String getRoleKey() {
			return roleKey;
		}
		public void setRoleKey(String roleKey) {
			this.roleKey = roleKey;
		}
}
