package com.cisco.la.model;

import java.util.Date;

public class CourseModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_id
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private int id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_name
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private String courseName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_price
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private Double price;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_startdate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private Date startDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_enddate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private Date endDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_active
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private Boolean active;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_course.crs_url
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	private String url;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_id
	 * @return  the value of public.la_course.crs_id
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_id
	 * @param id  the value for public.la_course.crs_id
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_name
	 * @return  the value of public.la_course.crs_name
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_name
	 * @param courseName  the value for public.la_course.crs_name
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_price
	 * @return  the value of public.la_course.crs_price
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_price
	 * @param price  the value for public.la_course.crs_price
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_startdate
	 * @return  the value of public.la_course.crs_startdate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_startdate
	 * @param startDate  the value for public.la_course.crs_startdate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_enddate
	 * @return  the value of public.la_course.crs_enddate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_enddate
	 * @param endDate  the value for public.la_course.crs_enddate
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_active
	 * @return  the value of public.la_course.crs_active
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_active
	 * @param active  the value for public.la_course.crs_active
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_course.crs_url
	 * @return  the value of public.la_course.crs_url
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_course.crs_url
	 * @param url  the value for public.la_course.crs_url
	 * @mbg.generated  Mon Jan 29 14:35:30 CST 2018
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}