package com.maranatha.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.maranatha.model.CatIncident;
import com.util.HibernateUtil;

@Repository
public class CatIncidentDAOImpl implements CatIncidentDAO{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public CatIncident getIncident(CatIncident name) {

		CatIncident incidentType=null;
		try{
			Session session = this.sessionFactory.openSession();
	        Criteria cr=session.createCriteria(CatIncident.class);
	        cr.add(Restrictions.eq("name", name));
	        incidentType = (CatIncident) cr.list().get(0);
	        session.close();			
		}
		catch(Exception e){
			System.out.println("Error");
		}
	   
	    return incidentType;
	}

	public List<CatIncident> getIncidents() {
		
		 Session session = this.sessionFactory.openSession();
        List<CatIncident> incidentTypes= (List<CatIncident>)session.createCriteria(CatIncident.class).list();
        session.close();
        return incidentTypes;
	}

	

}
