package com.maranatha.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
public class UserDAOImpl implements UserDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	public void save(User u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try{
        	tx = session.beginTransaction();
        	session.persist(u);
        	tx.commit();
        }
        catch(HibernateException e){
        	e.printStackTrace();
        	tx.rollback();
        }
        session.close();		
	}

	public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> personList = null;
        //List<User> personList = session.createQuery("from usuario").list();
        try{
        	personList= (List<User>)session.createCriteria(User.class).list();
        }
        catch(HibernateException e){
        	e.printStackTrace();
            session.close();
        }

        return personList;
	}
	
	public List<User> search(String name) {
		List<User> user=null;
		try{
			Session session = this.sessionFactory.openSession();
	        Criteria cr=session.createCriteria(User.class);
	        //cr.add(Restrictions.eq("name", name));
	        cr.add(Restrictions.ilike("name", name,MatchMode.ANYWHERE));
	        //user = (User) cr.list().get(0);
	        user = (List<User>) cr.list();
	        session.close();			
		}
		catch(HibernateException e){
        	e.printStackTrace();			
			System.out.println("Error");
		}
       
        return user;
	}

	public void addUser(User person) {
		Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        //Save the employee in database
        session.saveOrUpdate(person);

        //Commit the transaction
        session.getTransaction().commit();		
	}

	public void removeUser(Integer personId) {
		Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        User person = (User) session.get(User.class, personId);
        session.delete(person);
        
        session.getTransaction().commit();
	}

	public boolean login(User person) {
	
		boolean flag=false;
		
		try{
			Session session = this.sessionFactory.openSession();
	        Criteria cr=session.createCriteria(User.class);
	        cr.add(Restrictions.eq("username", person.getUsername()));
	        cr.add(Restrictions.eq("password", person.getPassword()));
	        
	        if(cr.list().size() > 0){
	        	flag = true;
	        }
	        session.close();			
		}
		catch(Exception e){
			System.out.println("Error");
		}
       
        return flag;
	}

	public User getUser(User person) {

		User user=null;
		try{
			Session session = this.sessionFactory.openSession();
	        Criteria cr=session.createCriteria(User.class);
	        cr.add(Restrictions.eq("username", person.getUsername()));
	        user = (User) cr.list().get(0);
	        session.close();			
		}
		catch(HibernateException e){
        	e.printStackTrace();			
		}
       
        return user;
	}


}
