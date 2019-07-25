package org.marlabs.project;

import java.util.List;



public interface ProjectRepository {
	
	public List<ProjectVo> listProjects()  throws Exception;

	public List<ProjectVo> findProjectByName(String projectName)throws Exception;

	public List<ProjectVo> findProjectByCode(String projectCode)throws Exception;

	public List<ProjectVo> findProjectById(String projectId)throws Exception;
}
