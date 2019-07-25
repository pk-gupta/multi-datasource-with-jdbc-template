package org.marlabs.employeeProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeProjectMapper implements RowMapper<EmployeeProjectVo>{

	
	public EmployeeProjectVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeProjectVo employeeDetails = new EmployeeProjectVo();
		/*int count = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= count; i++)
		{
		   System.out.println(rs.getMetaData().getColumnName(i));
		}*/
		employeeDetails.setEmployeeId(rs.getString("Employee Id"));

		employeeDetails.setEmployeeProject(rs.getString("Project Name"));
		employeeDetails.setEmployeeProjectId(rs.getString("ProjectId Code"));
	
		employeeDetails.setEmployeeName(rs.getString("Employee Name"));
		employeeDetails.setLocation(rs.getString("Location"));

	
		return employeeDetails;
	}

}
