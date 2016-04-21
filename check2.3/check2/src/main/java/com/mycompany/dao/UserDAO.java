package com.mycompany.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;
public class UserDAO 
{
	protected int id;
	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String gender;
	protected String telephone;
	protected String email;
	
	public UserDAO()
	{
		
	}

/*	public String checkUser(User user)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
	    try
	    {
	    	 System.out.println("Username entered is "+user.getuserName());
	    	 session.beginTransaction();     	 
	    	 Query query = session.createQuery("from User U where U.userName = :userName");
	    	 query.setParameter("userName",user.getuserName());
	         List<User> user2 = query.list();
	         for(User user3 : user2)
	         {
	             System.out.println("List of Users::"+user3.getuId()+","+user3.getfName());
	             if(user3.getpassword().equals(user.getpassword()) && user3.getuserName().equals(user.getuserName()))
	            	 fName=user3.getfName();
	             else
	            	 fName="NULL";
	         }
	    	//query.setParameter("userName", user.getuserName());
	        //session.flush();
	        //session.clear();  
	        session.getTransaction().commit();
	       //session.close();
	    }catch (HibernateException e) 
	    {
	        e.printStackTrace();
	    }
	    return fName;
	}*/
	
	
	
	public void addUser(User user)
	{
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 		Session session = sessionFactory.openSession();
 		session.beginTransaction();
 		// this would save the Student_Info object into the database
 		 session.save(user);	
 		 session.getTransaction().commit();
 		// session.close();
	}
	
	
/*	public String save(User user)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 		Session session = sessionFactory.openSession();
 		session.beginTransaction();
 		
 		
 		lName=user.getlName();
 		fName=user.getfName();
 		email=user.getEmail();
 		Username=user.getuserName();
 		password=user.getpassword();
 		uID=user.getuId();
 		System.out.println("here Uid is "+ uID);
 		User user2=new User();
 		
 		user2= (User) session.get(User.class,uID+1);
 		
 		user2.setfName(fName);
 		user2.setlName(lName);
 		user2.setEmail(email);
 		user2.setpassword(password);
 		user2.setuserName(Username);
 	
 		
 		session.update(user2);	
 		session.getTransaction().commit();
 		//session.close();
 		
 		return fName;
	}*/

}
