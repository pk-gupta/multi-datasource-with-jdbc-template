package org.marlabs.employeeProject;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeProjectRepositoryImpl implements EmployeeProjectRepository{
	@Autowired
	@Qualifier("jdbcHRIS")
	protected JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<EmployeeProjectVo> listEmployeeProjects()throws Exception  {
		try {
			String sql = "select * from EmployeeProject_V";
			return jdbcTemplate.query(sql, new EmployeeProjectMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in EmployeeProjectRepositoryImpl listEmployees() --", e);
		}

	}

	
}
