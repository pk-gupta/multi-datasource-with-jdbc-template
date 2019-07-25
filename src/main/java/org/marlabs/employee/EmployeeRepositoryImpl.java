package org.marlabs.employee;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	@Autowired
	@Qualifier("jdbcHRIS")
	protected JdbcTemplate jdbcTemplate;
	
	protected final Logger log = LoggerFactory.getLogger(getClass()); 	
	
	@Transactional(readOnly=true)
	public List<EmployeeVo> listEmployees()throws Exception  {
		try {		
			String sql = "select * from Employee_V";
			return jdbcTemplate.query(sql, new EmployeeMapper());			
		} catch (Exception e) {
			throw new SQLException("--Error message in EmployeeRepositoryImpl listEmployees()--", e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeById(String employeeId) throws Exception {
		try {
			String sql = "SELECT * from Employee_V where [Employee Id] = ? ";
			return jdbcTemplate.query(sql,new Object[]{employeeId},new EmployeeMapper());
			
		}	
		  catch (Exception e) {
			throw new SQLException("--Error message in EmployeeRepositoryImpl findEmployeeById()----", e);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeByMail(String email) throws Exception {
		try {
			String sql = "SELECT * from Employee_V where Mail = ?";
			return jdbcTemplate.query(sql,new Object[]{email},new EmployeeMapper());
		
		}	
		  catch (Exception e) {
			throw new SQLException("--Error message in EmployeeRepositoryImpl findEmployeeByMail()--", e);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeByName(String employeeName) throws Exception {
		try {
			String sql = "SELECT * from Employee_V where [Employee Name] like ?";
			return jdbcTemplate.query(sql,new Object[]{"%"+employeeName+"%"},new EmployeeMapper());
			
		}	
		  catch (Exception e) {
			throw new SQLException("--Error message in EmployeeRepositoryImpl findEmployeeByName()--", e);
		}
	}
}
