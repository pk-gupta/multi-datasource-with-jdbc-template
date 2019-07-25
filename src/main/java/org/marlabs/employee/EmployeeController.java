package org.marlabs.employee;

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
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	protected final Logger log = LoggerFactory.getLogger(getClass()); 	
	@ResponseBody
    @RequestMapping(value = "/employees", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeVo>> getEmployees() {
		try {
			List<EmployeeVo> employees=employeeRepository.listEmployees();
			return new ResponseEntity<List<EmployeeVo>>(employees,HttpStatus.OK);
		} catch (Exception e) {
			log.debug("--Error message HRIS EmployeeController getEmployees method--", e);
			return new ResponseEntity<List<EmployeeVo>>(HttpStatus.NOT_FOUND);
		}
	}
	
}
