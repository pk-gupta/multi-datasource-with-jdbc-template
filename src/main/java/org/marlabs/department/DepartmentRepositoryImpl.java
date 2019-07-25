package org.marlabs.department;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
	
	
	@Autowired
	@Qualifier("jdbcHRIS")
	protected JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<DepartmentVo> listDepartments()throws Exception  {
		try {
			String sql = "SELECT * from Department_V";
			return jdbcTemplate.query(sql, new DepartmentMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in DepartmentRepositoryImpl listDepartments()--", e);
		}
	}

	
	@Override
	public List<DepartmentVo> findDeptById(String deptId) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where [Department Id] = ?";
			return jdbcTemplate.query(sql,new Object[]{deptId}, new DepartmentMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in DepartmentRepositoryImpl findDeptById--", e);
		}
	}

	@Override
	public List<DepartmentVo> findDeptByName(String deptName) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where [Department Name]=?";
			return jdbcTemplate.query(sql,new Object[]{deptName}, new DepartmentMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in DepartmentRepositoryImpl findDeptByName--", e);
		}
	}

	@Override
	public List<DepartmentVo> findDeptByDivision(String division) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where Division = ?";
			return jdbcTemplate.query(sql,new Object[]{division}, new DepartmentMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in DepartmentRepositoryImpl findDeptByDivision--", e);
		}
	}


	@Override
	public List<DepartmentVo> findDeptByCode(String deptCode) throws Exception {
		return Collections.emptyList();
	}
}
