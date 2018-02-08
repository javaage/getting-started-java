package com.cisco.la.model;

import java.util.Date;

public class RecordModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_record.crd_id
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_record.crd_request
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	private String request;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_record.crd_response
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	private String response;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_record.crd_time
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	private Date time;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_record.crd_id
	 * @return  the value of public.la_record.crd_id
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_record.crd_id
	 * @param id  the value for public.la_record.crd_id
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_record.crd_request
	 * @return  the value of public.la_record.crd_request
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_record.crd_request
	 * @param request  the value for public.la_record.crd_request
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_record.crd_response
	 * @return  the value of public.la_record.crd_response
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_record.crd_response
	 * @param response  the value for public.la_record.crd_response
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_record.crd_time
	 * @return  the value of public.la_record.crd_time
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_record.crd_time
	 * @param time  the value for public.la_record.crd_time
	 * @mbg.generated  Thu Feb 08 14:38:32 CST 2018
	 */
	public void setTime(Date time) {
		this.time = time;
	}
}