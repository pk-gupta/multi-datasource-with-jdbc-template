package org.marlabs.department;

import java.util.List;

public interface DepartmentRepository {

	public List<DepartmentVo> listDepartments()throws Exception;

	public List<DepartmentVo> findDeptById(String deptId)throws Exception;

	public List<DepartmentVo> findDeptByName(String deptName)throws Exception;

	public List<DepartmentVo> findDeptByCode(String deptCode)throws Exception;

	public List<DepartmentVo> findDeptByDivision(String division) throws Exception;

}
