package com.maranatha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maranatha.dao.CatIncidentDAO;
import com.maranatha.model.CatIncident;
import com.maranatha.service.IncidentTypeService;

@Repository
public class IncidentTypeServiceImpl extends IncidentTypeService {

	@Autowired
	private CatIncidentDAO catIncidentDAO;
	
	public void setcatIncidentDAO(CatIncidentDAO catIncidentDAO){
		this.catIncidentDAO = catIncidentDAO;
	}
	
	 public List<CatIncident> getAllIncidentTypes() {
		 	return catIncidentDAO.getIncidents();
	    }
	 
	 public CatIncident getIncidentType(CatIncident name) {
			return catIncidentDAO.getIncident(name);
	    }

	
}
