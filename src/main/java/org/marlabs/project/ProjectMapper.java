package org.marlabs.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProjectMapper implements RowMapper<ProjectVo>{

	
	public ProjectVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectVo projectDetails = new ProjectVo();
//		int count = rs.getMetaData().getColumnCount();
//		for (int i = 1; i <= count; i++)
//		{
//		   System.out.println(rs.getMetaData().getColumnName(i));
//		}
		projectDetails.setProjectId(rs.getInt("ProjectId"));
		projectDetails.setProjectCode(rs.getString("Project Code"));
		projectDetails.setProjectName(rs.getString("ProjectName"));
		projectDetails.setProjectType(rs.getString("ProjectType"));
		projectDetails.setProjectCDO(rs.getString("CDO"));
		projectDetails.setProjectManager(rs.getString("Project manager"));
		projectDetails.setProjectManagerId(rs.getString("Project manager Id"));
		projectDetails.setDeliveryManager(rs.getString("Delivery Manager"));
		projectDetails.setDeliveryManagerId(rs.getString("Delivery Manager Id"));
		projectDetails.setProjectStartDate(rs.getString("Project Start Date"));
		projectDetails.setProjectEndDate(rs.getString("Project End Date"));
		projectDetails.setProjectClosureDate(rs.getString("ProjectClosureDate"));
		projectDetails.setLocation(rs.getString("Location"));
		projectDetails.setProjectDivisionId(rs.getString("ProjectDivisionId"));
	
		return projectDetails;
	}

}
