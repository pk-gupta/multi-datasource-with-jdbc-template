package org.marlabs.project;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
	
	
	@Autowired
	@Qualifier("jdbcHRIS")
	protected JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<ProjectVo> listProjects() throws Exception {
		try {
			String sql = "SELECT * from Projects_V";
			return jdbcTemplate.query(sql, new ProjectMapper());
		} catch (Exception e) {
			throw new SQLException("--Error message in ProjectRepositoryImpl listProjects()----", e);
		}

	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectByName(String projectName) throws Exception {
		try {
			
			String sql = "SELECT * from Projects_V where ProjectName = ?";
			return jdbcTemplate.query(sql, new ProjectMapper(),new Object[]{projectName});
		} catch (Exception e) {
			throw new SQLException("--Error message in ProjectRepositoryImpl findProjectByName()----", e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectByCode(String projectCode) throws Exception {
      try {
			String sql = "SELECT * from Projects_V where [Project Code] = ?";
			return jdbcTemplate.query(sql,new Object[]{projectCode}, new ProjectMapper());
		} catch (Exception e) {
			throw new SQLException("--Error message in ProjectRepositoryImpl findProjectByCode()----", e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectById(String projectId) throws Exception {
		  try {				
				String sql = "SELECT * from Projects_V where ProjectId = ?";
				return jdbcTemplate.query(sql,new Object[]{projectId}, new ProjectMapper());
			} catch (Exception e) {
				throw new SQLException("--Error message in ProjectRepositoryImpl findProjectById()----", e);
			}
	}
	
	
	

}
