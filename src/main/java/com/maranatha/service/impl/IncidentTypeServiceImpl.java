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
	private CatIncidentDAO catIncidentDAOImpl;
	
	 public List<CatIncident> getAllIncidentTypes() {
		 	return catIncidentDAOImpl.getIncidents();
	    }
	 
	 public CatIncident getIncidentType(CatIncident name) {
			return catIncidentDAOImpl.getIncident(name);
	    }

	
}
