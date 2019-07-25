package org.marlabs.commonDatabaseScheduler;
//package com.marlabs.rmbs.config.smtp.email;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.eclipse.jdt.internal.compiler.parser.Scanner;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.marlabs.rmbs.entities.Designation;
//import com.marlabs.rmbs.entities.ProjectMaster;
//import com.marlabs.rmbs.entities.UserMaster;
//import com.marlabs.rmbs.masters.repository.DesignationRepository;
//import com.marlabs.rmbs.masters.repository.ProjectMasterRepository;
//import com.marlabs.rmbs.masters.service.UserMasterRepository;
//
//
//@Component
//public class HrisDataScheduled {
//	
//	@Autowired
//	private UserMasterRepository userMasterRepository;
//	
//	@Autowired
//	private DesignationRepository designationRepository;
//	
//	
//	@Autowired
//	private ProjectMasterRepository projectMasterRepository;
//	
//	//@Scheduled(fixedRate = 2000)
//	@Transactional
//	public void userSync() throws IOException, JSONException {
// 
//		List<ReimbursPerson> dbUsersList = new ArrayList<>();
//			dbUsersList = userMasterRepository.getUsersFullList();
//			JSONArray json = new HrisDataScheduled().readJsonFromUrl("http://localhost:8099/hris/users");
//			for (int i = 0; i < json.length(); i++) {
//				JSONObject objects = json.getJSONObject(i);
//				for (ReimbursPerson reimbursPerson : dbUsersList) {
//					if (reimbursPerson.getMail() != null) {
//						if (reimbursPerson.getMail().equalsIgnoreCase(objects.getString("email"))) {
//							UserMaster userMaster = userMasterRepository.getOne(reimbursPerson.getId());
//							Designation designation = (Designation) designationRepository
//									.getOne(objects.getInt("designation"));
//							userMaster.setIsManager(objects.getBoolean("isManager"));
//							userMaster.setDesignationId(designation);
//							userMaster.setUserCode(objects.getString("userCode"));
//							userMasterRepository.save(userMaster);
//						}
//					}
//
//				}
//			}
//		
//
//	}
//	
//	
//	
//	//@Scheduled(fixedRate = 2000)
//	@Transactional
//	public void projectSync() throws IOException, JSONException {
//
//		List<ProjectMaster> dbProjectList = new ArrayList<>();
//		dbProjectList = projectMasterRepository.findAll();
//        JSONArray json = new HrisDataScheduled().readJsonFromUrl("http://localhost:8099/hris/projects");
//		for (int i = 0; i < json.length(); i++) {
//			JSONObject objects = json.getJSONObject(i);
//			for (ProjectMaster projectMaster : dbProjectList) {
//				ProjectMaster project = null;
//				if (projectMaster.getProjectCode().equalsIgnoreCase(objects.getString("projectCode"))) {
//					project = projectMasterRepository.getOne(projectMaster.getId());
//				} else {
//					project = new ProjectMaster();
//				}
//				if (project!=null) {
//					UserMaster projectManager = userMasterRepository
//							.findByMailIgnoreCase(objects.getString("pmMarlabsEmail"));
//					UserMaster accountManager = userMasterRepository
//							.findByMailIgnoreCase(objects.getString("amMarlabsEmail"));
//					UserMaster deliveryManager = userMasterRepository
//							.findByMailIgnoreCase(objects.getString("dmMarlabsEmail"));
//					UserMaster cdo = userMasterRepository.
//							findByMailIgnoreCase(objects.getString("cdoMarlabsEmail"));
//
//					project.setProjectCode(objects.getString("projectCode"));
//					project.setProjectType(objects.getString("projectType"));
//					project.setProjectDesc(objects.getString("projectName"));
//					project.setIsBillable(objects.getBoolean("isBillable"));
//					project.setProjectManagerId(projectManager);
//					project.setDeliveryManagerId(deliveryManager);
//					project.setCDOId(cdo);
//					projectMasterRepository.save(project);
//				}
//				
//			}
//		}
//
//	}
//	
//	
//	
//	
//	
//	public JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
//		InputStream is = new URL(url).openStream();
//		try {
//			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//			String jsonText = readAll(rd);
//			JSONArray json = new JSONArray(jsonText);
//			return json;
//		} finally {
//			is.close();
//		}
//	}
//	
//	
//	
//	
//	private String readAll(Reader rd) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		int cp;
//		while ((cp = rd.read()) != -1) {
//			sb.append((char) cp);
//		}
//		return sb.toString();
//	}
//	
//	
//
//	
//}
