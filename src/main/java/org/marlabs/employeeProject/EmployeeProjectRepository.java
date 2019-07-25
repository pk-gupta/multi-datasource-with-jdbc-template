package org.marlabs.employeeProject;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface EmployeeProjectRepository {
	
	public List<EmployeeProjectVo> listEmployeeProjects() throws Exception;
	
}
