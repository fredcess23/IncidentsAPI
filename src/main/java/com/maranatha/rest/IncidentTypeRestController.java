package com.maranatha.rest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maranatha.model.CatIncident;
import com.maranatha.service.IncidentTypeService;

@RestController
public class IncidentTypeRestController {

	@Autowired
	private IncidentTypeService incidentTypeService;
	
	@RequestMapping(value="/incident/type", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatIncident> getAllIncidentTypes(){
		try {
			return incidentTypeService.cacheList.get("");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
    }

	@RequestMapping(value="/incident/type/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CatIncident getIncidentType(@PathVariable("name") String name) {
		try {
			return incidentTypeService.cache.get(name);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
    }

	
}
