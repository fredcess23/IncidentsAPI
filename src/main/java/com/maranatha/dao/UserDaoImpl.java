package com.maranatha.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.maranatha.model.User;
import com.util.HibernateUtil;

//@Repository("userQualifier")
@Repository
public class UserDaoImpl implements UserDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();




	public void save(User u) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u);
        tx.commit();
        session.close();		
	}

	public List<User> list() {
        Session session = this.sessionFactory.openSession();
        //List<User> personList = session.createQuery("from usuario").list();
        List<User> personList= (List<User>)session.createCriteria(User.class).list();
        System.out.println(personList);
        session.close();
        return personList;
	}
	
	public User search(String name) {
		User user=null;
		try{
			Session session = this.sessionFactory.openSession();
	        Criteria cr=session.createCriteria(User.class);
	        //cr.add(Restrictions.eq("name", name));
	        cr.add(Restrictions.ilike("name", name,MatchMode.ANYWHERE));
	        user = (User) cr.list().get(0);
	        session.close();			
		}
		catch(Exception e){
			System.out.println("Error");
		}
       
        return user;
	}

	public User getUser(String name) {
		return null;
	}

}
