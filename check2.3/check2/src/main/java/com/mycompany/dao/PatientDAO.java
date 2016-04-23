package com.mycompany.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;

public class PatientDAO {
	

		
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
		
		public String validateUser(String username, String password) throws NamingException 
	    {
		    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		Query query=  session.createQuery("from Patient");
	 		List<Patient> allPatients = query.list();
	 		for(int i=0; i <allPatients.size();i++){
	 			Patient patient=(Patient)allPatients.get(i);
	 			System.out.println(patient.getFirstName());
	 		}
	 		return "jjjj";
	 		
	     } 
		public PatientDAO()
		{
			
		}
}
