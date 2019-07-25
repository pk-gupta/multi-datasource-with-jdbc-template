package org.marlabs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	@Id
	private Integer departmentId;
	private String departmentName;
	private String division;
	private String departmentGroupNmae;
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDepartmentGroupNmae() {
		return departmentGroupNmae;
	}
	public void setDepartmentGroupNmae(String departmentGroupNmae) {
		this.departmentGroupNmae = departmentGroupNmae;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", division="
				+ division + ", departmentGroupNmae=" + departmentGroupNmae + "]";
	}
	
	

}
