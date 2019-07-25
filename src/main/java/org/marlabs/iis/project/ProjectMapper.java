package org.marlabs.iis.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

public class ProjectMapper implements RowMapper<ProjectIISVo>{

	
	public ProjectIISVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectIISVo projectDetails = new ProjectIISVo();
		
		projectDetails.setEmployeeId(rs.getString("Employee_id"));
		projectDetails.setProjectId(rs.getInt("Project_id"));
		projectDetails.setProjectName(rs.getString("Project_name"));
		projectDetails.setProjectStatus(rs.getString("status"));
		projectDetails.setProjectType(rs.getString("ProjectType"));
		projectDetails.setProjectStartDate(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Project_startdate")));
		projectDetails.setProjectEndDate(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Project_enddate")));
	
		return projectDetails;
	}

}
