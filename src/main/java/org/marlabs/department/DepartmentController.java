package org.marlabs.department;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hris")
public class DepartmentController {
	
	@Autowired
    private DepartmentRepository departmentRepository;
	protected final Logger log = LoggerFactory.getLogger(getClass()); 	
	@ResponseBody
    @RequestMapping(value = "/departments", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentVo>> getProjects() {
		try {
			List<DepartmentVo> departments=departmentRepository.listDepartments();
			return new ResponseEntity<List<DepartmentVo>>(departments,HttpStatus.OK);
		} catch (Exception e) {
			log.debug("---DepartmentController listDepartments()--", e);
			return new ResponseEntity<List<DepartmentVo>>(HttpStatus.NOT_FOUND);
		}
	}
}
