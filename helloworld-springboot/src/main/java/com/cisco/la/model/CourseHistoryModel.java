package com.cisco.la.model;

public class CourseHistoryModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_crs_history.hstr_usr_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	private String userID;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_crs_history.hstr_crs_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	private Integer CourseID;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_crs_history.hstr_usr_id
	 * @return  the value of public.la_crs_history.hstr_usr_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_crs_history.hstr_usr_id
	 * @param userID  the value for public.la_crs_history.hstr_usr_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_crs_history.hstr_crs_id
	 * @return  the value of public.la_crs_history.hstr_crs_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	public Integer getCourseID() {
		return CourseID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_crs_history.hstr_crs_id
	 * @param CourseID  the value for public.la_crs_history.hstr_crs_id
	 * @mbg.generated  Mon Feb 05 17:51:00 CST 2018
	 */
	public void setCourseID(Integer CourseID) {
		this.CourseID = CourseID;
	}
}