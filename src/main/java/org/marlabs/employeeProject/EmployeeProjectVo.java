package org.marlabs.employeeProject;

public class EmployeeProjectVo {
	 private int id;
     private String employeeId;
	 private String employeeProject;
	 private String employeeProjectId;
	 private String employeeName;
	 private String location;
	 private String manager;
	 private String managerId;
	 private int projectId;
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	 public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
    public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

}
