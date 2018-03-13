package com.cisco.la.model;

import java.util.Date;

public class MessageModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_user_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String userID;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_content
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_serial
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer serial;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_level
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer level;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_create_date
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_active
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Boolean active;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_session
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer session;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_intent
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String intent;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_message.msg_action
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String action;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_id
	 * @return  the value of public.la_message.msg_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_id
	 * @param id  the value for public.la_message.msg_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_user_id
	 * @return  the value of public.la_message.msg_user_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_user_id
	 * @param userID  the value for public.la_message.msg_user_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_content
	 * @return  the value of public.la_message.msg_content
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_content
	 * @param content  the value for public.la_message.msg_content
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_serial
	 * @return  the value of public.la_message.msg_serial
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getSerial() {
		return serial;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_serial
	 * @param serial  the value for public.la_message.msg_serial
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_level
	 * @return  the value of public.la_message.msg_level
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_level
	 * @param level  the value for public.la_message.msg_level
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_create_date
	 * @return  the value of public.la_message.msg_create_date
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_create_date
	 * @param createDate  the value for public.la_message.msg_create_date
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_active
	 * @return  the value of public.la_message.msg_active
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_active
	 * @param active  the value for public.la_message.msg_active
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_session
	 * @return  the value of public.la_message.msg_session
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getSession() {
		return session;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_session
	 * @param session  the value for public.la_message.msg_session
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setSession(Integer session) {
		this.session = session;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_intent
	 * @return  the value of public.la_message.msg_intent
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getIntent() {
		return intent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_intent
	 * @param intent  the value for public.la_message.msg_intent
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setIntent(String intent) {
		this.intent = intent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_message.msg_action
	 * @return  the value of public.la_message.msg_action
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getAction() {
		return action;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_message.msg_action
	 * @param action  the value for public.la_message.msg_action
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setAction(String action) {
		this.action = action;
	}
}