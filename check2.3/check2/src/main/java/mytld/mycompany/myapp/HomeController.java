package mytld.mycompany.myapp;

import com.mycompany.model.*;

import com.mycompany.dao.*;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.hibernate.HibernateUtil;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String gender;
	protected String telephone;
	protected String email;
	protected int height;
	protected int weight;
	private String location;
	private String specialization;
	private String day;
	private String time;
	//protected int id;
	UserDAO userdao= new UserDAO();
	PatientDAO patientdao = new PatientDAO();
	DoctorDAO doctordao = new DoctorDAO();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public String FirstPage(@ModelAttribute("userForm") User user,ModelMap model) 
	 {
	        return "index";
	 }
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String Login(@ModelAttribute("userForm") User user,ModelMap model) 
	 {
			// Write the Student_Info object into the database
			User_Test user1 = new User_Test();
			user1.setUsername("Viraj");
			user1.setPassword("pp23");

			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// this would save the Student_Info object into the database
			session.save(user1);
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
			return "welcomePatient";
	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String Register(@ModelAttribute("userForm") User user,ModelMap model)
	    {
		 //	doctordao.listDoctors();
		 	return "registration";
	    }
	 
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public ModelAndView registerUser(@RequestParam ("acctype")String acc,@ModelAttribute("patientForm")Patient patient,@ModelAttribute("doctorForm")Doctor doctor, ModelMap model) 
	 {
		 	if(acc.equals("patient"))
		 		return new ModelAndView("registerPatient", "patient", new Patient(userName,password,firstName,lastName,age,gender,telephone,email,height,weight));
		 	else  
		 		return new ModelAndView("registerDoctor", "doctor", new Doctor(userName,password,firstName,lastName,age,gender,telephone,email,location,specialization,day,time));
	 }

	 @RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	 public String welcomePatient (@ModelAttribute("patientForm") Patient patient,ModelMap model)
	 {
		 firstName=patientdao.addUser(patient); 
		 System.out.println(firstName);
		 model.addAttribute("firstName",firstName);
		 return "welcomePatient";
	 }
	 
	 @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
	 public String welcomeDoctor(@ModelAttribute("doctorForm") Doctor doctor,ModelMap model) 
	 {
		 doctordao.addUser(doctor); 
		 return "welcomeDoctor";
	 }
	 
	 @RequestMapping(value = "/welcomePatient", method = RequestMethod.POST)
	 public String appointmentScheduler(@ModelAttribute("userForm") User user,ModelMap model) 
	 {
		 		return "appointmentScheduler";
	 }
	 
	 @RequestMapping(value = "/scheduler", method = RequestMethod.POST)
	 public String appointmentScheduler(@RequestParam ("appointtype")String app,@ModelAttribute("userForm") User user,ModelMap model) 
	 {
		 if(app.equals("Book Appointment"))
		 	return "bookAppointment";
		 else if(app.equals("Reschedule Appointment"))
		 	return "rescheduleAppointment";
		 else 
			 return "cancelAppointment";
	 }
}
