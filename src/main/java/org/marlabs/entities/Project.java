package org.marlabs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Project")
public class Project {
	@Id
	private Integer projectId;
	private String projectCode;
	private String projectName;
	private String projectType;
	private String projectCdo;
	private String projectManager;
	private String projectManagerId;
	private String billableOrNot;
	private String deliveryManager;
	private String deliveryManagerId;
	private Date projectStartDate;
	private Date projectEndDate;
	private Date projectClosureDate;
	private String location;
	private Integer projectDivisionId;
	
	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectCdo() {
		return projectCdo;
	}
	public void setProjectCdo(String projectCdo) {
		this.projectCdo = projectCdo;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getProjectManagerId() {
		return projectManagerId;
	}
	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	public String getBillableOrNot() {
		return billableOrNot;
	}
	public void setBillableOrNot(String billableOrNot) {
		this.billableOrNot = billableOrNot;
	}
	public String getDeliveryManager() {
		return deliveryManager;
	}
	public void setDeliveryManager(String deliveryManager) {
		this.deliveryManager = deliveryManager;
	}
	public String getDeliveryManagerId() {
		return deliveryManagerId;
	}
	public void setDeliveryManagerId(String deliveryManagerId) {
		this.deliveryManagerId = deliveryManagerId;
	}
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public Date getProjectClosureDate() {
		return projectClosureDate;
	}
	public void setProjectClosureDate(Date projectClosureDate) {
		this.projectClosureDate = projectClosureDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getProjectDivisionId() {
		return projectDivisionId;
	}
	public void setProjectDivisionId(Integer projectDivisionId) {
		this.projectDivisionId = projectDivisionId;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectCode=" + projectCode + ", projectName=" + projectName
				+ ", projectType=" + projectType + ", projectCdo=" + projectCdo + ", projectManager=" + projectManager
				+ ", projectManagerId=" + projectManagerId + ", billableOrNot=" + billableOrNot + ", deliveryManager="
				+ deliveryManager + ", deliveryManagerId=" + deliveryManagerId + ", projectStartDate="
				+ projectStartDate + ", projectEndDate=" + projectEndDate + ", projectClosureDate=" + projectClosureDate
				+ ", location=" + location + ", projectDivisionId=" + projectDivisionId + "]";
	}
	
	
	
	
	
	
}
