package com.mycompany.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;

public class PatientDAO {
	
		protected int id;
		protected String userName;
		protected String password;
		protected String firstName;
		protected String lastName;
		protected int age;
		protected String gender;
		protected String telephone;
		protected String email;
		private int height;
		private int weight;
		
		public String addUser(Patient patient)
		{
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		// this would save the Student_Info object into the database
	 		 session.save(patient);	
	 		 session.getTransaction().commit();
	 		// session.close();
	 		 return patient.getFirstName();
		}
		
		public PatientDAO()
		{
			
		}
}
