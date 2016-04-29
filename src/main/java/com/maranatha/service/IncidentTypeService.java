package com.maranatha.service;

import java.util.List;

import com.maranatha.model.CatIncident;
import com.util.GenericCache;

public abstract class IncidentTypeService extends GenericCache<CatIncident, CatIncident> {

	public abstract List<CatIncident> getAllIncidentTypes();
	public abstract CatIncident getIncidentType(CatIncident name);
	
	@Override
	public CatIncident send1(CatIncident model) {
		return getIncidentType(model);
	}

	@Override
	public List<CatIncident> send2() {
		return getAllIncidentTypes();
	}

}
