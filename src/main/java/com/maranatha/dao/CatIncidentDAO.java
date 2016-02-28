package com.maranatha.dao;

import java.util.List;

import com.maranatha.model.CatIncident;

public interface CatIncidentDAO {

	public CatIncident getIncident(String name);
	public List<CatIncident> getIncidents();
}
