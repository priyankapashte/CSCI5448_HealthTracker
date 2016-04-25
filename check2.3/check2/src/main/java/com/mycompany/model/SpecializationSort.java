package com.mycompany.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate.HibernateUtil;

public class SpecializationSort implements Sort {

	@Override
	public List<Doctor> sort(String loc, String spl) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 		Session session = sessionFactory.openSession();
 		session.beginTransaction();
 		String queried="from Doctor D where D.location = :Location AND D.specialization = :Specialization order by specialization";
 		System.out.println(queried);
 		Query query=  session.createQuery(queried);
 		query.setParameter("Location",loc);
    	query.setParameter("Specialization",spl);
 		java.util.List<Doctor> allDoctors = query.list();
 		return allDoctors;
	}

}
