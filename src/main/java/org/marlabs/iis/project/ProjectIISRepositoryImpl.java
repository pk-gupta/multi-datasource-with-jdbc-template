package org.marlabs.iis.project;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectIISRepositoryImpl implements ProjectIISRepository{
	
	
	@Autowired
	@Qualifier("jdbcIIS")
    private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<ProjectIISVo> listProjects() throws Exception {
		try {
			String sql = "SELECT * from Projects";
			return jdbcTemplate.query(sql, new ProjectMapper());
		} catch (Exception e) {
			throw new SQLException("--Error message in ProjectIISRepositoryImpl listProjects()----", e);
		}

	}	
	

}
