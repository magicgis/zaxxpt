package com.test.entity;

public class SystemUsersRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEM_USERS_ROLE.ID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEM_USERS_ROLE.SUID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    private String suid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYSTEM_USERS_ROLE.RID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    private String rid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEM_USERS_ROLE.ID
     *
     * @return the value of SYSTEM_USERS_ROLE.ID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEM_USERS_ROLE.ID
     *
     * @param id the value for SYSTEM_USERS_ROLE.ID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEM_USERS_ROLE.SUID
     *
     * @return the value of SYSTEM_USERS_ROLE.SUID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public String getSuid() {
        return suid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEM_USERS_ROLE.SUID
     *
     * @param suid the value for SYSTEM_USERS_ROLE.SUID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public void setSuid(String suid) {
        this.suid = suid == null ? null : suid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYSTEM_USERS_ROLE.RID
     *
     * @return the value of SYSTEM_USERS_ROLE.RID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public String getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYSTEM_USERS_ROLE.RID
     *
     * @param rid the value for SYSTEM_USERS_ROLE.RID
     *
     * @mbggenerated Thu Mar 29 16:21:41 GMT+08:00 2012
     */
    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }
}