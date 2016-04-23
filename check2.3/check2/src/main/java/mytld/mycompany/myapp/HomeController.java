package mytld.mycompany.myapp;

import com.mycompany.model.*;

import com.mycompany.dao.*;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	DBHandler userdao= new DBHandler();
	
	private boolean validatePassword(String password) {
		  // Check for null, then a length less then 6 (and I really don't like the length()
		  // > 10 check, that's a BAD requirement).
		  if (password == null || password.length() < 6 || password.length() > 10) {
		    return false;
		  }
		  boolean containsChar = false;
		  boolean containsDigit = false;
		  for (char c : password.toCharArray()) {
		    if (Character.isLetter(c)) {
		      containsChar = true;
		    } else if (Character.isDigit(c)) {
		      containsDigit = true;
		    }
		    if (containsChar && containsDigit) {
		      return true;
		    }
		  }
		  return false;
		}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public String FirstPage(@ModelAttribute("userForm") User user,ModelMap model) 
	 {
	        return "index";
	 }
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String Login(@RequestParam ("Username")String Username, @RequestParam ("Password")String Password,@ModelAttribute("userForm") User user,ModelMap model) throws NamingException 
	 {
		 System.out.println("NEEEEE");
		 System.out.println(Username);
		 System.out.println(Password);
		 String Result = userdao.validateUser(Username, Password); 
		 System.out.println(Result);
		 if (Result.equals("Patient")){
			 return "welcomePatient";
		 }
		 else if (Result.equals("Doctor")){
			 return "welcomeDoctor";
		 }
		 else{
			 model.addAttribute("message","Invalid User Name or Password");
			 return "index";
		 }
		 
	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String Register(@ModelAttribute("userForm") User user,ModelMap model)
	    {
		 //	doctordao.listDoctors();

		 	return "registration";
	    }
	 
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public ModelAndView registerUser(@RequestParam ("uname")String user, @RequestParam ("pass")String pass,@RequestParam ("acctype")String acc,@ModelAttribute("patientForm")Patient patient,@ModelAttribute("doctorForm")Doctor doctor, HttpServletRequest request) 
	 {
		 	HttpSession session = request.getSession();
		 	session.setAttribute("uname", request.getParameter("uname"));
		 	session.setAttribute("pass", request.getParameter("pass"));
		 	if(acc.equals("patient")){
		 		System.out.println(firstName);
		 		System.out.println(user);
		 		return new ModelAndView("registerPatient", "patient", new Patient(userName,password,firstName,lastName,age,gender,telephone,email,height,weight));
		 	}
	 		else  
		 		return new ModelAndView("registerDoctor", "doctor", new Doctor(userName,password,firstName,lastName,age,gender,telephone,email,location,specialization,day,time));
	 }

	 @RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	 public String welcomePatient (@ModelAttribute("patientForm") Patient patient,ModelMap model, HttpServletRequest request)
	 {
     	 String uname=(String) request.getSession().getAttribute("uname");
     	 String pass=(String) request.getSession().getAttribute("pass");
     	 patient.setUserName(uname);
     	 patient.setPassword(pass);
		 patient=userdao.addPatient(patient); 
		 model.addAttribute("firstName",patient.getFirstName());
		 return "welcomePatient";
	 }
	 
	 @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
	 public String welcomeDoctor(@ModelAttribute("doctorForm") Doctor doctor,ModelMap model, HttpServletRequest request) 
	 {
     	 String uname=(String) request.getSession().getAttribute("uname");
     	 String pass=(String) request.getSession().getAttribute("pass");
     	 doctor.setUserName(uname);
     	  doctor.setPassword(pass);
		 userdao.addDoctor(doctor); 
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
		 if(app.equals("Book Appointment")){
			 java.util.List Location = userdao.getLocations(); 
			 for (int i = 0; i<Location.size();i++){		 
				 System.out.println(Location.get(i));
			 }
			 model.addAttribute("Location",Location);
			 model.addAttribute("Locations","Locations");
			 java.util.List<Doctor> Doctors = null; 
			 model.addAttribute("Doctor",Doctors);
			 model.addAttribute("Doctors","Doctors");
			 java.util.List Specialization = userdao.getSpecializations(); 
			 for (int i = 0; i<Specialization.size();i++){		 
				 System.out.println(Specialization.get(i));
			 }
			 model.addAttribute("Specialization",Specialization);
			 model.addAttribute("Specializations","Specializations");
			 
		 	return "bookAppointment";
		 	}
		 else if(app.equals("Reschedule Appointment"))
		 	return "rescheduleAppointment";
		 else 
			 return "cancelAppointment";
	 }
	 @RequestMapping(value = "/search", method = RequestMethod.POST)
	 public String DisplaySearch(@RequestParam ("LocationSelected")String loc,@RequestParam ("SortPref")String sort,@RequestParam ("SpecializationSelected")String Spl,@ModelAttribute("userForm") User user,ModelMap model) 
	 {
		 System.out.println(loc);
		 System.out.println(sort);
		 System.out.println(Spl);
		 java.util.List<Doctor> Doctors = userdao.getDoctors(loc,Spl,sort); 
		 for (int i = 0; i<Doctors.size();i++){		 
			 System.out.println(Doctors.get(i).getFirstName());
		 }
		 model.addAttribute("Doctor",Doctors);
		 model.addAttribute("Doctors","Doctors");
		 
		 java.util.List Location = userdao.getLocations(); 
		 for (int i = 0; i<Location.size();i++){		 
			 System.out.println(Location.get(i));
		 }
		 model.addAttribute("Location",Location);
		 model.addAttribute("Locations","Locations");
		 
		 java.util.List Specialization = userdao.getSpecializations(); 
		 for (int i = 0; i<Specialization.size();i++){		 
			 System.out.println(Specialization.get(i));
		 }
		 model.addAttribute("Specialization",Specialization);
		 model.addAttribute("Specializations","Specializations");
		
		 model.addAttribute("Location",Location);
		 model.addAttribute("Locations","Locations");
		 return "bookAppointment";
	 }
}
