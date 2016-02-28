package com.maranatha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maranatha.dao.CatIncidentDAO;
import com.maranatha.model.CatIncident;

@RestController
public class IncidentTypeRestController {

	@Autowired
	private CatIncidentDAO catIncidentDAOImpl;
	
	@RequestMapping(value="/incident/type", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatIncident> getAllIncidentTypes() {
		return catIncidentDAOImpl.getIncidents();
    }

	@RequestMapping(value="/incident/type/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CatIncident getIncidentType(@PathVariable("name") String name) {
		return catIncidentDAOImpl.getIncident(name);
    }

	
}
