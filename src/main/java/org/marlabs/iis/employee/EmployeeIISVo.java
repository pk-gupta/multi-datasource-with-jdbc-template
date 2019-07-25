package org.marlabs.iis.employee;

public class EmployeeIISVo {
	
	private int id;
	private String employeeId;
	private String employeeName;
	private String phoneNumber;
	private String email;
	private String location;
	private String state;
	private boolean isManager;
	
	private String empRecruiter;
	private String empRecruiterId;
	private String empRecruiterEmail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmpRecruiter() {
		return empRecruiter;
	}
	public void setEmpRecruiter(String empRecruiter) {
		this.empRecruiter = empRecruiter;
	}
	public String getEmpRecruiterId() {
		return empRecruiterId;
	}
	public void setEmpRecruiterId(String empRecruiterId) {
		this.empRecruiterId = empRecruiterId;
	}
	public String getEmpRecruiterEmail() {
		return empRecruiterEmail;
	}
	public void setEmpRecruiterEmail(String empRecruiterEmail) {
		this.empRecruiterEmail = empRecruiterEmail;
	}
	
}
	