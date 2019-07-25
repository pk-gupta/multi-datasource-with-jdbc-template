package org.marlabs.project;

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
public class ProjectController {
	
	@Autowired
    private ProjectRepository projectRepository;
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@ResponseBody
    @RequestMapping(value = "/projects", method = RequestMethod.GET, 
	produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectVo>> getProjects() {
		try {
			List<ProjectVo> projects=projectRepository.listProjects();
			return new ResponseEntity<List<ProjectVo>>(projects,HttpStatus.OK);
		} catch (Exception e) {
			log.debug("--Error message HRIS ProjectController listProjects method--", e);
			return new ResponseEntity<List<ProjectVo>>(HttpStatus.NOT_FOUND);
		}
	}
}
