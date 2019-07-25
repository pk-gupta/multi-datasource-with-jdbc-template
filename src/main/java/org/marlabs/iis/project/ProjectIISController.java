package org.marlabs.iis.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iis")
public class ProjectIISController {
	
	@Autowired
    private ProjectIISRepository projectIISRepository;
	
	@ResponseBody
    @RequestMapping(value = "/projects", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectIISVo>> getProjects() {
		try {
			System.out.println("------In ProjectIISController-----");
			List<ProjectIISVo> projects=projectIISRepository.listProjects();
			return new ResponseEntity<List<ProjectIISVo>>(projects,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProjectIISVo>>(HttpStatus.NOT_FOUND);
		}
	}
}
