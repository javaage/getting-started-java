package com.cisco.la.entity;

import java.util.Date;

import com.cisco.la.model.GoldenSampleModel;

public class GoldenSampleJoin extends GoldenSampleModel{

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the mandatoryName
	 */
	public String getMandatoryName() {
		return mandatoryName;
	}

	/**
	 * @param mandatoryName the mandatoryName to set
	 */
	public void setMandatoryName(String mandatoryName) {
		this.mandatoryName = mandatoryName;
	}

	/**
	 * @return the optionalName
	 */
	public String getOptionalName() {
		return optionalName;
	}

	/**
	 * @param optionalName the optionalName to set
	 */
	public void setOptionalName(String optionalName) {
		this.optionalName = optionalName;
	}

	private String roleName;
	
	private String mandatoryName;
	
	private String optionalName;
}