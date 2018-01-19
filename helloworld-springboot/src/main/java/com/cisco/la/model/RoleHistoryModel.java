package com.cisco.la.model;

import java.util.Date;

public class RoleHistoryModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_rl_history.hstr_usr_id
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	private String userID;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_rl_history.hstr_rl_name
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	private String roleName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_rl_history.hstr_rl_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	private String roleHistory;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_rl_history.hstr_update_time
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_rl_history.hstr_usr_id
	 * @return  the value of public.la_rl_history.hstr_usr_id
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_rl_history.hstr_usr_id
	 * @param userID  the value for public.la_rl_history.hstr_usr_id
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_rl_history.hstr_rl_name
	 * @return  the value of public.la_rl_history.hstr_rl_name
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_rl_history.hstr_rl_name
	 * @param roleName  the value for public.la_rl_history.hstr_rl_name
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_rl_history.hstr_rl_history
	 * @return  the value of public.la_rl_history.hstr_rl_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public String getRoleHistory() {
		return roleHistory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_rl_history.hstr_rl_history
	 * @param roleHistory  the value for public.la_rl_history.hstr_rl_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public void setRoleHistory(String roleHistory) {
		this.roleHistory = roleHistory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_rl_history.hstr_update_time
	 * @return  the value of public.la_rl_history.hstr_update_time
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_rl_history.hstr_update_time
	 * @param updateTime  the value for public.la_rl_history.hstr_update_time
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}