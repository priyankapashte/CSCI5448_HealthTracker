package mytld.mycompany.myapp;

import com.mycompany.model.*;

import com.mycompany.dao.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.hibernate.HibernateUtil;


/**
 * Handles requests for the application home page.
 */
/* Added @SessionAttributes to maintain object state across pages: Shreya */ 
@SessionAttributes({"patientForm","doctorForm"})
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
	/* Added appropriate attributes to include start time and end time: Shreya */
	private String starttime;
	private String endtime;
	//protected int id;
	UserDAO userdao= new UserDAO();
	PatientDAO patientdao = new PatientDAO();
	DoctorDAO doctordao = new DoctorDAO();
	
	/*Added to persist object through pages*/
	@ModelAttribute("patientForm")
    public Patient patient() {
        return new Patient();
    }
	
	/*Added to persist object through pages*/
	@ModelAttribute("doctorForm")
    public Doctor doctor() {
        return new Doctor();
    }
	
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
			user1.setUsername("kl");
			user1.setPassword("kl");

			
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
	 public ModelAndView registerUser(@RequestParam ("acctype")String acc, @ModelAttribute("patientForm")Patient patient,@ModelAttribute("doctorForm")Doctor doctor, ModelMap model) 
	 {
		 	if(acc.equals("patient"))
		 		return new ModelAndView("registerPatient", "patient", new Patient(userName,password,firstName,lastName,age,gender,telephone,email,height,weight));
		 	else  
		 		return new ModelAndView("registerDoctor", "doctor", new Doctor(userName,password,firstName,lastName,age,gender,telephone,email,location,specialization,day,starttime,endtime));
	 } 
	 
	 /*Controller method to save data into database and create patient profile: shreya*/
	 @RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	 public ModelAndView welcomePatient (@ModelAttribute("patientForm") Patient patient,ModelMap model)
	 { 
		 return new ModelAndView("welcomePatient", "patient", patientdao.addUser(patient));
	 }
	 
	 /*Controller method to save data into database and create doctor profile:shreya*/
	 @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
	 public ModelAndView welcomeDoctor(@ModelAttribute("doctorForm") Doctor doctor,ModelMap model) 
	 {
		 return new ModelAndView("welcomeDoctor", "doctor", doctordao.addUser(doctor));
	 }
	 
	 /*Controller method to handle requests on patient's profile: shreya*/
	 @RequestMapping(value = "/welcomePatient", method = RequestMethod.POST)
	 public ModelAndView welcomePatient(@RequestParam("edit")String edit, @ModelAttribute("patientForm") Patient patient, ModelMap model, BindingResult result) 
	 {
		 if(edit.equals("Edit Profile"))
		 {
			 return new ModelAndView("editPatientProfile", "patient", patient);
		 }
		 else
			 return new ModelAndView("appointmentScheduler", "patient", patient);
	 }
	 
	 /*Controller method to handle requests on doctor's profile: shreya*/
	 @RequestMapping(value = "/welcomeDoctor", method = RequestMethod.POST)
	 public ModelAndView welcomeDoctor(@RequestParam("edit")String edit, @ModelAttribute("doctorForm") Doctor doctor, ModelMap model, BindingResult result) 
	 {
		 if(edit.equals("Edit Profile"))
		 {
			 return new ModelAndView("editDoctorProfile", "doctor", doctor);
		 }
		 else
			 return new ModelAndView("welcomeDoctor", "doctor", doctor);
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
	 
	 /*Controller method to edit patient profile: shreya*/
		 @RequestMapping(value = "/editPatientProfile", method = RequestMethod.POST)
		 public String editPatientProfile(@ModelAttribute("patientForm") Patient patient, ModelMap model, BindingResult result) 
		 {
			 patientdao.editPatientProfile(patient);
			 return "welcomePatient";
		 }
		 
		/*Controller method to edit doctor profile:shreya*/
		 @RequestMapping(value = "/editDoctorProfile", method = RequestMethod.POST)
		 public String editDoctorProfile(@ModelAttribute("doctorForm") Doctor doctor, ModelMap model, BindingResult result) 
		 {
			 doctordao.editDoctorProfile(doctor);
			 return "welcomeDoctor";
		 }
}
