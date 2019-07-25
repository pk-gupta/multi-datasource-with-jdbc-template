package org.marlabs.iis.employee;

import java.util.List;

public interface EmployeeIISRepository {

	public List<EmployeeIISVo> listEmployees() throws Exception;

}
