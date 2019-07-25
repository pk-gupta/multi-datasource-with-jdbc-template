package org.marlabs.employeeProject;

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
public class EmployeeProjectController {
	
	@Autowired
    private EmployeeProjectRepository employeeProjectRepository;
	protected final Logger log = LoggerFactory.getLogger(getClass()); 	
	@ResponseBody
    @RequestMapping(value = "/employee/Projects", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeProjectVo>> getProjects() {
		try {
			List<EmployeeProjectVo> departments=employeeProjectRepository.listEmployeeProjects();
			return new ResponseEntity<List<EmployeeProjectVo>>(departments,HttpStatus.OK);
		} catch (Exception e) {
			log.debug("--EmployeeProjectController getProjects()--", e);
			return new ResponseEntity<List<EmployeeProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
	
}
