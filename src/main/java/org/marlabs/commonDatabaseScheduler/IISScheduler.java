package org.marlabs.commonDatabaseScheduler;
//package com.marlabs.rmbs.config.smtp.email;
//
//
//
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.marlabs.department.DepartmentRepository;
//import org.marlabs.department.DepartmentVo;
//import org.marlabs.employee.EmployeeRepository;
//import org.marlabs.employee.EmployeeVo;
//import org.marlabs.employeeProject.EmployeeProjectRepository;
//import org.marlabs.employeeProject.EmployeeProjectVo;
//import org.marlabs.iis.employee.EmployeeIISRepository;
//import org.marlabs.iis.employee.EmployeeIISVo;
//import org.marlabs.project.ProjectRepository;
//import org.marlabs.project.ProjectVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.marlabs.rmbs.entities.Department;
//import com.marlabs.rmbs.entities.EmployeeProject;
//import com.marlabs.rmbs.entities.ProjectMaster;
//import com.marlabs.rmbs.entities.RoleMaster;
//import com.marlabs.rmbs.entities.UserMaster;
//import com.marlabs.rmbs.masters.repository.ProjectMasterRepository;
//import com.marlabs.rmbs.masters.repository.RoleRepository;
//import com.marlabs.rmbs.masters.service.UserMasterRepository;
//import com.marlabs.rmbs.request.repository.EmployeeProjectRepo;
//
//
//
//@Component
//public class ScheduledTasks {
//
//
//
//
//
//	@Autowired
//	private UserMasterRepository userMasterRepository;
//
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private EmployeeRepository employeerepository;
//	
//	
//	@Autowired
//	private EmployeeProjectRepo employeeProjectRepo;
//	
//	@Autowired
//	private ProjectRepository projectrepository;
//	
//	@Autowired
//	private ProjectMasterRepository projectmasterrepository;
//	
//	@Autowired 
//	private EmployeeProjectRepository employeeProjectrepository;
//	
//	
//	@Autowired 
//	private DepartmentRepository departmentrepository;
//	
//	@Autowired
//	private com.marlabs.rmbs.masters.repository.DepartmentRepository departmentRepo;
//	
//	@Autowired
//	private EmployeeIISRepository employeeiisRepo;
//	
//	//@Scheduled(fixedRate =5000)
//	// @Scheduled(cron = "0 1 1 * * ?")
//	// @Scheduled(cron="0 15 9-17 * * MON-FRI")
//	// for evey 6 secs "*/60 * * * * *
//	@Scheduled(cron = "*/10 * * * * *")
//	//@Scheduled(cron = "0 10 14 ? * SUN") // Fire at 2:10 PM 
//											// every Sunday in the month of
//											// every month
//	//@Scheduled(cron="0 0 9 25 * ?") // Fire at every month on 25th
//	
//    @Transactional
//	public void updateUsersMaster() throws Exception {
//	//	List<EmployeeVo> newUsersList = new ArrayList<>();
//	
//		
//	RoleMaster roleNormal= roleRepository.findOne(3);
//		
//	//RoleMaster roleSuper= roleRepository.findOne(4);
//	
//	RoleMaster roleApprover= roleRepository.findOne(2);
//	//List<ReimbursPerson> newObjList = new ArrayList<>();
//	//newUsersList = employeerepository.listEmployees();
//	//	newObjList=saveDepartment(newUsersList, newObjList);
//		
//		
//	 //   List<ReimbursPerson> dbUsersList = new ArrayList<>();
//	//	dbUsersList = userMasterRepository.getUsersFullList();
//	
//	//	saveUser(roleNormal, roleApprover, newObjList, dbUsersList);
//		
//		
//		saveProjects();
//		saveIISemployees(roleApprover,roleNormal);
//		
//		List<EmployeeProjectVo> empProjects=new ArrayList<>();
//		
//		empProjects=employeeProjectrepository.listEmployees();
//		List<EmployeeProject> empProjectsPostgres = employeeProjectRepo.findAll();
//		
//		
//		 if(null!=empProjectsPostgres && !empProjectsPostgres.isEmpty() ){
//         	for(EmployeeProjectVo empView:empProjects){
//         		for(EmployeeProject empPost:empProjectsPostgres){
//         			if(empView.getEmployeeProjectId().equals(empPost.getEmployeeProjectId()) && empView.getEmployeeId().equals(empPost.getEmployeeId())){
//         				empView.setId(empPost.getId());
//         				
//         			}
//         		}
//         	}
//         }
//		 List<ProjectVo> projects=new ArrayList<>();
//			projects=projectrepository.listProjects();
//			for(EmployeeProjectVo emp:empProjects){
//			     for(ProjectVo prj:projects){
//
//					if(emp.getEmployeeProjectId().equalsIgnoreCase(prj.getProjectCode())){
//						emp.setProjectId(prj.getProjectId());
//						emp.setManagerId(prj.getProjectManagerId());
//						emp.setManager(prj.getProjectManager());
//						
//					}
//				}
//			}
//		 
//		 
//		for(EmployeeProjectVo emp:empProjects){
//			EmployeeProject pro=new EmployeeProject();
//			pro.setEmployeeId(emp.getEmployeeId());
//            pro.setEmployeeName(emp.getEmployeeName());
//            pro.setEmployeeProject(emp.getEmployeeProject());
//            pro.setEmployeeProjectId(emp.getEmployeeProjectId());
//           pro.setId(emp.getId());
//          pro.setProjectId(emp.getProjectId());
//          pro.setManager(emp.getManager());
//          pro.setManagerId(emp.getManagerId());
//           employeeProjectRepo.save(pro);
//            
//		}
//
//	}
//
//	private void saveIISemployees(RoleMaster roleApprover, RoleMaster roleNormal) {
//		
//	 try {
//		 List<ReimbursPerson> dbUsersList = new ArrayList<>();
//		dbUsersList = userMasterRepository.getUsersFullList();
//		 List<EmployeeIISVo> employeeIIS = employeeiisRepo.listEmployees();
//
//			if (null != dbUsersList || !dbUsersList.isEmpty()) {
//				for (EmployeeIISVo emp : employeeIIS) {
//					for (ReimbursPerson rmdb : dbUsersList) {
//						if (emp.getEmail().equalsIgnoreCase(rmdb.getMail())) {
//							emp.setId(rmdb.getId());
//						}
//
//					}
//				}
//			}
//			
//			List<String> managerList = new ArrayList<String>();
//			for(EmployeeIISVo emp:employeeIIS){	
//				managerList.add(emp.getEmpRecruiterEmail());
//			}
//			
//			for(EmployeeIISVo emp:employeeIIS){
//				for(String mId:managerList){
//					if(emp.getEmail().equals(mId)){
//						emp.setManager(true);
//						emp.setRole(2);
//					}
//				}
//			}
//			
//			
//			for(EmployeeIISVo emp:employeeIIS){
//				for(ReimbursPerson empm:dbUsersList){
//					if(emp.getEmpRecruiterEmail().equals(empm.getMail())){
//						emp.setEmpRecruiterId(String.valueOf(empm.getId()));
//						
//					}
//				}
//			}
//			
//			for(EmployeeIISVo emp:employeeIIS){
//				UserMaster userMaster=new UserMaster();
//				userMaster.setCn(emp.getEmployeeName());
//				if(emp.getRole()==2)
//			    userMaster.setRoleId(roleApprover);
//				else 
//					userMaster.setRoleId(roleNormal);
//				userMaster.setId(emp.getId());
//				userMaster.setIsManager(emp.isManager());
//				userMaster.setDepartment("iis");
//				userMaster.setGivenName("iis");
//				userMaster.setMail(emp.getEmail()); 
//				userMaster.setSubmissionTo("manager");
//				userMaster.setManager(emp.getEmpRecruiter());
//				userMaster.setLoc(emp.getLocation());
//				userMaster.setUid("iis");
//				userMaster.setEmployeeId(emp.getEmployeeId());
//				/*Department dpt=new Department();
//				dpt.setDepartmentCode("iis");
//				dpt.setDepatmentId("iis");
//				userMaster.setDepartmentId(dpt);*/
//				userMaster.setEmployeeType("iis");
//				if(null!=emp.getEmpRecruiterId() && !emp.getEmpRecruiterId().isEmpty()){
//				UserMaster user =new UserMaster();
//				user.setMail(emp.getEmpRecruiterEmail());
//				user.setId(Integer.parseInt(emp.getEmpRecruiterId()));
//				userMaster.setUserManagerId(user);
//				}
//				userMasterRepository.save(userMaster);
//				
//				
//			}
//			
//	 }catch (Exception e) {
//		e.printStackTrace();
//	}
//		
//		
//		
//	}
//
//	/**
//	 * @throws Exception
//	 */
//	private void saveProjects() throws Exception {
//		List<ProjectVo> projects=new ArrayList<>();
//		projects=projectrepository.listProjects();
//		List<ProjectDetails> details=new ArrayList<>();
//		ProjectVo projdt=new ProjectVo();
//		projdt.setProjectCode("Not Applicable");
//		projdt.setProjectName("Not Applicable");
//		projdt.setProjectId(1);
//		projdt.setProjectManager("");
//		projects.add(0, projdt);
//		
//		
//		for(ProjectVo project:projects){
//			ProjectDetails pdt=new ProjectDetails();
//			
//			pdt.setProjectCode(project.getProjectCode());
//			pdt.setProjectDesc(project.getProjectName());
//			pdt.setProjectManager(project.getProjectManager());
//			pdt.setProjectId(project.getProjectId());
//		UserMaster userDetail = userMasterRepository.findByEmployeeId(project.getProjectManagerId());
//		if(null!=userDetail){
//		pdt.setProjectManagerId(userDetail.getId());
//		details.add(pdt);
//		}
//		else if(null==userDetail && pdt.getProjectId()==1 ){
//			details.add(pdt);
//		}
//		else{
//	//	System.out.println("project manager:   " +project.getProjectManager()+"------->   project name:   " +project.getProjectName());
//		System.out.println();
//		}
//		}
//		
//		List<ProjectDetails> projectDetailsFromLocal=new ArrayList<>();
//		projectDetailsFromLocal=projectmasterrepository.getProjectsFullList();
//		
//		
//		if(null!=projectDetailsFromLocal || !projectDetailsFromLocal.isEmpty()){
//		for(ProjectDetails projectsList:details){
//			for(ProjectDetails projectDetails:projectDetailsFromLocal){
//				if(projectsList.getProjectId()==projectDetails.getProjectId()){
//					projectsList.setId(projectDetails.getId());
//				}
//			}
//		}
//		}
//	
//		
//
//		
//		
//		for(ProjectDetails prjcts:details){
//			ProjectMaster prjMaster=new ProjectMaster();
//			
//			prjMaster.setProjectCode(prjcts.getProjectCode());
//			prjMaster.setProjectDesc(prjcts.getProjectDesc());
//			prjMaster.setProjectManager(prjcts.getProjectManager());
//			prjMaster.setProjectId(prjcts.getProjectId());
//			if(prjcts.getProjectId()!=1){
//			UserMaster user=new UserMaster();
//			user.setId(prjcts.getProjectManagerId());
//			prjMaster.setProjectManagerId(user);
//			}
//			if(0!=prjcts.getId()){
//		     prjMaster.setId(prjcts.getId());
//			}
//			projectmasterrepository.save(prjMaster);
//			
//			
//		}
//	}
//
//	/**
//	 * @param roleNormal
//	 * @param roleApprover
//	 * @param newObjList
//	 * @param dbUsersList
//	 * @throws Exception 
//	 */
//	private void saveUser(RoleMaster roleNormal, RoleMaster roleApprover, List<ReimbursPerson> newObjList,
//			List<ReimbursPerson> dbUsersList) throws Exception {
//		for(ReimbursPerson emp:newObjList){
//			emp.setRoleId(roleNormal);
//		}
//		
//		
//	
//		List<String> managerList = new ArrayList<String>();
//		for(ReimbursPerson emp:newObjList){	
//			managerList.add(emp.getEmployeeManagerId());
//		}
//		List<ProjectVo> projects=new ArrayList<>();
//		projects=projectrepository.listProjects();
//		for(ProjectVo pr:projects){
//			managerList.add(pr.getProjectManagerId());
//		}
//		for(ReimbursPerson emp:newObjList){
//			for(String mId:managerList){
//				if(emp.getEmployeeId().equals(mId)){
//					emp.setIsManager(true);
//					emp.setRoleId(roleApprover);
//				}
//			}
//		}
//		
//		
//		if(null!=dbUsersList || !dbUsersList.isEmpty()){
//		for(ReimbursPerson emp:newObjList){
//			for(ReimbursPerson rmdb:dbUsersList){
//				if(emp.getEmployeeId().equals(rmdb.getEmployeeId())){					     
//		     emp.setId(rmdb.getId());
//		  UserMaster usermaster=  userMasterRepository.findOne(rmdb.getId());
//		  if(usermaster.getRoleId().getId()==4){
//		  emp.setRoleId(usermaster.getRoleId());
//		     break;
//		  }
//					}
//				}
//				
//			}
//		}
//		if(null!=dbUsersList || !dbUsersList.isEmpty()){
//		for(ReimbursPerson emp:newObjList){
//			for(ReimbursPerson rmdb:dbUsersList){
//				if(emp.getEmployeeManagerId().equals(rmdb.getEmployeeId())){					     
//		        emp.setUserManagerId(rmdb.getId());
//		     
//		      
//		    
//					}
//				}
//				
//			}
//		
//		}
//
//		for (ReimbursPerson reimbursPerson : newObjList) {
//			UserMaster userMaster = new UserMaster();
//			userMaster.setCn(reimbursPerson.getCn());
//		    userMaster.setRoleId(reimbursPerson.getRoleId());
//			userMaster.setIsManager(reimbursPerson.getIsManager());
//			userMaster.setDepartment(reimbursPerson.getDepartment());
//			userMaster.setGivenName(reimbursPerson.getGivenName());
//			userMaster.setMail(reimbursPerson.getMail()); 
//			userMaster.setSubmissionTo("manager");
//			userMaster.setManager(reimbursPerson.getManager());
//			userMaster.setLoc(reimbursPerson.getLoc());
//			userMaster.setUid(reimbursPerson.getUid());
//			userMaster.setEmployeeId(reimbursPerson.getEmployeeId());
//			userMaster.setDepartmentId(reimbursPerson.getDepartmentId());
//			if(null!=reimbursPerson.getId()){
//			userMaster.setId(reimbursPerson.getId());
//			}
//			UserMaster user=new UserMaster();
//			user.setId(reimbursPerson.getUserManagerId());
//			user.setCn(reimbursPerson.getManager());
//			userMaster.setUserManagerId(user);
//			userMaster.setDepartmentId(reimbursPerson.getDepartmentId());
//			userMaster.setDesignationLevel(reimbursPerson.getDesignatonId());
//			System.out.println(userMaster);
//			userMasterRepository.saveAndFlush(userMaster);
//		}
//	}
//
//	/**
//	 * @param newUsersList
//	 * @param newObjList
//	 * @throws Exception
//	 */
//	private List<ReimbursPerson> saveDepartment(List<EmployeeVo> newUsersList, List<ReimbursPerson> newObjList) throws Exception {
//		List<DepartmentVo> department=new ArrayList<>();
//		department=departmentrepository.listDepartments();
//		
//		List<DepartmentDetail> departs=new ArrayList<>();
//		for(DepartmentVo dpt:department){
//			DepartmentDetail dp=new DepartmentDetail();
//			dp.setDepartmentCode(dpt.getDepartmentName());
//			dp.setDepartmentDesc(dpt.getDepartmentName());
//			dp.setDepartmentId(dpt.getDepartmentId());
//			departs.add(dp);
//		}
//		
//		List<Department> departmntDetails=new ArrayList<>();
//
//		departmntDetails=departmentRepo.findAll();
//		 
//		
//		if(null!=departmntDetails || !departmntDetails.isEmpty()){
//		for(DepartmentDetail dpt:departs){
//			for( Department dptDetails:departmntDetails){
//				if(dpt.getDepartmentId().equals(dptDetails.getDepatmentId())){
//					dpt.setId(dptDetails.getId());
//				}
//				
//			}
//		}
//		}
//		
//		for(DepartmentDetail dpt:departs){
//			
//			Department depo=new Department();
//			depo.setDepatmentId(dpt.getDepartmentId());
//			depo.setDepartmentCode(dpt.getDepartmentCode());
//			depo.setDepartmentDesc(dpt.getDepartmentDesc());
//			
//			depo.setId(dpt.getId());
//			
//			departmentRepo.save(depo);
//			
//		}
//		
//		
//	
//
//		for (EmployeeVo person : newUsersList) {
//			ReimbursPerson dbObj = new ReimbursPerson();
//			dbObj.setUid(person.getEmployeeName());
//			dbObj.setCn(person.getEmployeeName());
//			dbObj.setManager(person.getEmployeeManager());
//			dbObj.setTelephoneNumber(person.getPhoneNumber());
//			dbObj.setLoc(person.getLocation());
//			dbObj.setMail(person.getEmail());
//			dbObj.setDepartment(person.getEmployeeDepartment());
//			dbObj.setUserPrincipalName(person.getEmail());
//			dbObj.setEmployeeId(person.getEmployeeId());
//			dbObj.setEmployeeManagerId(person.getEmployeeManagerId());
//			dbObj.setIsManager(false);
//			dbObj.setDesignatonId(Integer.parseInt(person.getDesignationId()));
//			
//		    for(Department dpt:departmntDetails){
//		    	
//		    	if(person.getEmployeeDepartmentId().equals(dpt.getDepatmentId())){
//		    		Department dp =new Department();
//		    		dp.setId(dpt.getId());
//		    		dp.setDepartmentCode((dpt.getDepartmentCode()));
//		    		dp.setDepartmentDesc(dpt.getDepartmentDesc());
//		    		dbObj.setDepartmentId(dp);
//		    	}
//		    }
//			newObjList.add(dbObj);
//		}
//		
//		return newObjList;
//	}
//	
//	
//
//	
//}
