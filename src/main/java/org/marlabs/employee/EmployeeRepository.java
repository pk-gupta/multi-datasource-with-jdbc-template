package org.marlabs.employee;

import java.util.List;



public interface EmployeeRepository {
	
	public List<EmployeeVo> listEmployees() throws Exception;
	public List<EmployeeVo> findEmployeeById(String employeeId) throws Exception;
	public List<EmployeeVo> findEmployeeByMail(String email)throws Exception;
	public List<EmployeeVo> findEmployeeByName(String employeeName)throws Exception;
}
