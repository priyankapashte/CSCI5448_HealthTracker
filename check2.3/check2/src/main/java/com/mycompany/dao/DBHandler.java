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

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.mycompany.hibernate.HibernateUtil;
import com.mycompany.model.*;

import antlr.collections.List;

public class DBHandler{
	
		
		public void addDoctor(Doctor doctor)
		{
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		Session session = sessionFactory.openSession();
	 		session.beginTransaction();
	 		// this would save the Student_Info object into the database
	 		 session.save(doctor);	
	 		 session.getTransaction().commit();
	 		// session.close();
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
			public Patient addPatient(Patient patient)
			{
		    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		// this would save the Student_Info object into the database
		 		 session.save(patient);	
		 		 session.getTransaction().commit();
		 		 //session.close();
		 		// session.close();
		 		 return patient;
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
/*			public java.util.List<Doctor> getDoctors(String loc,String Spl,String sort){
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		String queried="from Doctor D where D.location = :Location AND D.specialization = :Specialization order by "+ sort;
		 		System.out.println(queried);
		 		Query query=  session.createQuery(queried);
		 		query.setParameter("Location",loc);
            	query.setParameter("Specialization",Spl);
		 		java.util.List<Doctor> allDoctors = query.list();
		 		return allDoctors;
			}*/
			
			public void editDoctorProfile(Doctor doctor)
	 			{
	 		    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 		 		Session session = sessionFactory.openSession();
	 		 		session.beginTransaction();
	 		 		session.saveOrUpdate(doctor);	
	 		 		session.getTransaction().commit();
	 			}
			public void editPatientProfile(Patient patient)
 			{
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 		Session session = sessionFactory.openSession();
		 		session.beginTransaction();
		 		session.update(patient);
 		 		
 		 	/*String hql = "UPDATE Patient "
 		 			+ "set age=:age, email=:email, firstName=:firstName, lastName=:lastName,"
	 				+ "telephone=:telephone, height=:height,weight=:weight"
	 				+ "  where id=:id";
	 	    Query query = session.createQuery(hql);
	 	    query.setParameter("age",patient.getAge());
	 	    query.setParameter("email",patient.getEmail());
	 	    query.setParameter("firstName",patient.getFirstName());
	 	    query.setParameter("lastName",patient.getLastName());
	 	    query.setParameter("telephone",patient.getTelephone());
	 	    query.setParameter("height",patient.getHeight());
	 	    query.setParameter("weight",patient.getWeight());
	 	    query.setParameter("id",patient.getId());
	 	    System.out.println(hql);
	 	    int result = query.executeUpdate();
	 		if(result == 0)
	 			System.out.println("Error");
	 		else
	 			System.out.println("Executed");*/
		 	session.getTransaction().commit();
 			}
		

}
