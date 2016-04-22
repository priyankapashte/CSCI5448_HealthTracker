package com.mycompany.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;

import antlr.collections.List;

public class DoctorDAO {
	
		protected int id;
		protected String userName;
		protected String password;
		protected String firstName;
		protected String lastName;
		protected int age;
		protected String gender;
		protected String telephone;
		protected String email;
		private String location;
		private String specialization;
		private String day;
		private String starttime;
		private String endtime;
		
		/*modified method to return doctor object: shreya*/
		public Doctor addUser(Doctor doctor)
		{
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		session.save(doctor);	
	 		session.getTransaction().commit();
	 		return doctor;
		}
		
		   /* Method to  READ all the Doctors */
		   public void listDoctors( ){
			  
			   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		        List allpatients = (List)session.createQuery("SELECT * FROM patient").list();
		        for (Iterator it = ((java.util.List) allpatients).iterator(); it.hasNext(); ) {
		               Object[] myResult = (Object[]) it.next();
		               String firstName = (String) myResult[0];
		               String lastName = (String) myResult[1];
		               System.out.println( "Found " + firstName + " " + lastName );
		            }
		        session.getTransaction().commit();
		   }
		
		 
		/*Function to update profile details: shreya*/
			public void editDoctorProfile(Doctor doctor)
			{
		    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		session.saveOrUpdate(doctor);	
		 		session.getTransaction().commit();
		 		
			}
		public DoctorDAO()
		{
			
		}
}
