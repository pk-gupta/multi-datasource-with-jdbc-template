package org.marlabs.employee;

public class EmployeeVo {
	
	 private String employeeId;
	 private String employeeDepartment;
	 private String employeeProject;
	 private String employeeProjectId;
	 private String employeeDepartmentId;
	 private String employeeName;
	 private String location;
	 private String email;
	 private String phoneNumber;
	 private String employeeManager;
	 private String employeeManagerId;
	 private String designation;
	 private String designationId;
	 private boolean isManager;
	 public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public void setBillable(boolean isBillable) {
		this.isBillable = isBillable;
	}
	private Integer role;
	 private boolean isBillable;
	 
    public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeProject() {
		return employeeProject;
	}
	public void setEmployeeProject(String employeeProject) {
		this.employeeProject = employeeProject;
	}
	public String getEmployeeProjectId() {
		return employeeProjectId;
	}
	public void setEmployeeProjectId(String employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}
	public String getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
	public void setEmployeeDepartmentId(String employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmployeeManager() {
		return employeeManager;
	}
	public void setEmployeeManager(String employeeManager) {
		this.employeeManager = employeeManager;
	}
	public String getEmployeeManagerId() {
		return employeeManagerId;
	}
	public void setEmployeeManagerId(String employeeManagerId) {
		this.employeeManagerId = employeeManagerId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
	public boolean getIsBillable() {
		return isBillable;
	}
	public void setIsBillable(boolean isBillable) {
		this.isBillable = isBillable;
	}

}
