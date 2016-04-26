package com.mycompany.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Id;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;

import antlr.collections.List;

public class DBHandler{
		
		public Doctor addDoctor(Doctor doctor)
		{
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		session.save(doctor);	
	 		session.getTransaction().commit();
	 		return doctor;
		}
		public Patient addPatient(Patient patient)
		{
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		session.save(patient);	
	 		session.getTransaction().commit();
	 		return patient;
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
		   
			public void addAppointment(Appointment appointment)
			{
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		// this would save the Student_Info object into the database
		 		 session.save(appointment);	
		 		 session.getTransaction().commit();
			}
			
			public boolean validateUsername(String username, String acctype) throws NamingException{
			    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from "+ acctype + " A WHERE A.userName = :username" ;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("username",username);
		 		java.util.List allUsers = query.list();
		 		if (allUsers.size()==0){
		 			return false;
		 		}
		        return true;
		    }
			public Patient getPatient(String username){
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from Patient P where P.userName = :username" ;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("username",username);
		 		java.util.List<Patient> patient = query.list();
				return patient.get(0);
			}
			public Doctor getDoctor(String username){
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from Doctor D where D.userName = :username" ;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("username",username);
		 		java.util.List<Doctor> doctor = query.list();
				return doctor.get(0);
			}
			public Doctor getDoctorbyID(int ID){
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from Doctor D where D.id = :ID" ;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("ID",ID);
		 		java.util.List<Doctor> doctor = query.list();
				return doctor.get(0);
			}
			public String validateUser(String username, String password) throws NamingException 
		    {
				String UserType = "Unregistered";
			    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
	            boolean isDoctor=validateUsername(username,"Doctor");
	            boolean isPatient=validateUsername(username,"Patient");
	            if(isDoctor){
	     
	            	String queried="from Doctor D WHERE D.userName = :username AND D.password = :Password";
			 		System.out.println(queried);
	            	Query query=  session.createQuery(queried);
	            	query.setParameter("username",username);
	            	query.setParameter("Password",password);
			 		java.util.List allDoctors = query.list();
			 		if (allDoctors.size()!=0){
			 			UserType= "Doctor";
			 		}
	            }
	            else if(isPatient){
	            	String queried="from Patient P WHERE P.userName = :username AND P.password = :Password";
			 		System.out.println(queried);
	            	Query query=  session.createQuery(queried);
	            	query.setParameter("username",username);
	            	query.setParameter("Password",password);
			 		java.util.List allPatients = query.list();
			 		if (allPatients.size()!=0){
			 			UserType= "Patient";
			 		}
	            }
	            
				return UserType;
		 		
		     } 
			public java.util.List getLocations(){
				 	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			 		Session session = sessionFactory.openSession();
			 		session.beginTransaction();
			 		String queried="select location from Doctor order by location" ;
			 		System.out.println(queried);
			 		Query query=  session.createQuery(queried);
			 		java.util.List allLocations = query.list();
			 		return allLocations;
			}
			public java.util.List getSpecializations(){
			 	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="select specialization from Doctor order by specialization" ;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		java.util.List allSpecializations = query.list();
		 		return allSpecializations;
		 		}

			public void editDoctorProfile(Doctor doctor)
	 			{
	 		    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		 		Session session = sessionFactory.openSession();
	 		 		session.beginTransaction();
	 		 		session.update(doctor);	
	 		 		session.getTransaction().commit();
	 			}
			public void editPatientProfile(Patient patient)
 			{
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		session.update(patient);
 		 	 	session.getTransaction().commit();
 			}
			public java.util.List<Patient> getPatients(int id)
			{
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		Criteria criteria = session.createCriteria(Patient.class).createAlias("doctor", "d");
		 		criteria.add(Restrictions.eq("d.id", id));
		 		java.util.List<Patient> patients = criteria.list();
		 		return patients;
			}
			public HealthParameters getHealthParameters(int patientId)
			{
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from HealthParameters H where H.id = :id";
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("id",patientId);
		 		java.util.List<HealthParameters> healthParameters = query.list();
		 		return healthParameters.get(0);
			}
		

}
