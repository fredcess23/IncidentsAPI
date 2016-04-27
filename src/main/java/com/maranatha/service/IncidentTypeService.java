package com.maranatha.service;

import java.util.List;
import com.maranatha.model.CatIncident;
import com.util.GenericCache;

public abstract class IncidentTypeService extends GenericCache<String, CatIncident> {

	public abstract List<CatIncident> getAllIncidentTypes();
	public abstract CatIncident getIncidentType(String name);
	
	@Override
	public CatIncident send1(String model) {
		return getIncidentType(model);
	}

	@Override
	public List<CatIncident> send2(String model) {
		return getAllIncidentTypes();
	}

}
