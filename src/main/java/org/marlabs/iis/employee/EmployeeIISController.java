package org.marlabs.iis.employee;

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
@RequestMapping("/iis")
public class EmployeeIISController {
	
	@Autowired
    private EmployeeIISRepository employeeIISRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ResponseBody
    @RequestMapping(value = "/employees", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeIISVo>> getAllEmployees() {
		
		try {
			System.out.println("------In EmployeeIISController-----");
			List<EmployeeIISVo> employees=employeeIISRepository.listEmployees();
			return new ResponseEntity<List<EmployeeIISVo>>(employees,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<EmployeeIISVo>>(HttpStatus.NOT_FOUND);
		}	
	}
}
