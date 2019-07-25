package org.marlabs.iis.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeIISMapper implements RowMapper<EmployeeIISVo> {

	@Override
	public EmployeeIISVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeIISVo employeeDetails = new EmployeeIISVo();
		employeeDetails.setEmployeeId(rs.getString("Employee_id"));
		employeeDetails.setEmployeeName(rs.getString("Emp_name"));
		employeeDetails.setPhoneNumber(rs.getString("Emp_phone"));
		employeeDetails.setEmail(rs.getString("Emp_Email"));
		employeeDetails.setLocation(rs.getString("Emp_City"));
		employeeDetails.setState(rs.getString("Emp_state"));
		//employeeDetails.setEmpRecruiter(rs.getString("Emp_recruiter"));
		//employeeDetails.setEmpRecruiterId(rs.getString("Emp_recruiter_id"));
		return employeeDetails;

	}

	ArrayList<String> email = new ArrayList<String>(
		    Arrays.asList("pallavi.ayla@marlabs.com", "Santharam.Ayyalasomayajula@marlabs.com", "Abdul.Kodungukkaran@marlabsglobal.com"));
	
}
