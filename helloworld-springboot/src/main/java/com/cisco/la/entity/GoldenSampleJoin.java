package com.cisco.la.entity;

import java.util.ArrayList;
import java.util.List;

import com.cisco.la.model.GoldenSampleModel;

public class GoldenSampleJoin extends GoldenSampleModel{
	private List<String> listMandatory = new ArrayList<String>();
	private List<String> listOptional = new ArrayList<String>();

	private String roleName;
	
	private String mandatoryName;
	
	private String optionalName;
	
	public List<String> getListMandatory() {
		return listMandatory;
	}
	public void setListMandatory(List<String> listMandatory) {
		this.listMandatory = listMandatory;
	}
	public List<String> getListOptional() {
		return listOptional;
	}
	public void setListOptional(List<String> listOptional) {
		this.listOptional = listOptional;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMandatoryName() {
		return mandatoryName;
	}
	public void setMandatoryName(String mandatoryName) {
		this.mandatoryName = mandatoryName;
	}
	public String getOptionalName() {
		return optionalName;
	}
	public void setOptionalName(String optionalName) {
		this.optionalName = optionalName;
	}
}