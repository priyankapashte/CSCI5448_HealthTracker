package mytld.mycompany.myapp;

import com.mycompany.model.*;

import com.mycompany.dao.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	private String starttime;
	private String endtime;
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
	public String FirstPage(ModelMap model) 
	 {
	        return "index";
	 }

	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String Login(@RequestParam ("Username")String Username, @RequestParam ("Password")String Password,ModelMap model, HttpServletRequest request) throws NamingException 
	 {
		 String Result = userdao.validateUser(Username, Password); 
		 if (Result.equals("Patient")){
			 Patient patient = userdao.getPatient(Username);
			 HttpSession session = request.getSession();
			 session.setAttribute("patient", patient);
			 model.addAttribute("firstName",patient.getFirstName());
			 return "welcomePatient";
		 }
		 else if (Result.equals("Doctor")){
			 Doctor doctor = userdao.getDoctor(Username);
			 HttpSession session = request.getSession();
			 session.setAttribute("doctor", doctor);
			 model.addAttribute("firstName",doctor.getFirstName());
			 return "welcomeDoctor";
		 }
		 else{
			 model.addAttribute("message","Invalid User Name or Password");
			 return "index";
		 }
		 
	 }
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 	 public String Logout(HttpServletRequest request) 
	 	 {
	 			HttpSession session = request.getSession();
	 			session.setAttribute("patient", null);
	 			session.setAttribute("doctor", null);
	 			session.setAttribute("uname", null);
	 			session.setAttribute("pass", null);
	 			session.invalidate();
	 	        return "index";
	 	 }
	 	@RequestMapping(value = "/homepagePatient", method = RequestMethod.GET)
	 	 public String Homepage(HttpServletRequest request,ModelMap model) 
	 	 {
	 		 HttpSession session = request.getSession();
	 		 Patient patient=(Patient)session.getAttribute("patient");
	 		 model.addAttribute("firstName",patient.getFirstName());
	 		 return "welcomePatient";
	 	 }
	 	@RequestMapping(value = "/homepageDoctor", method = RequestMethod.GET)
	 	 public String HomepageDoctor(HttpServletRequest request,ModelMap model) 
	 	 {
	 		 HttpSession session = request.getSession();
	 		 Doctor doctor=(Doctor)session.getAttribute("doctor");
	 		 model.addAttribute("firstName",doctor.getFirstName());
	 		 return "welcomeDoctor";
	 	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String Register()
	    {
		 //	doctordao.listDoctors();

		 	return "registration";
	    }
	 
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public ModelAndView registerUser(@RequestParam ("uname")String user, @RequestParam ("pass")String pass,@RequestParam ("acctype")String acc,@ModelAttribute("patientForm")Patient patient,@ModelAttribute("doctorForm")Doctor doctor, HttpServletRequest request) throws NamingException 
	 {
		 	HttpSession session = request.getSession();

		 	
		 	if(acc.equals("patient")){
		 		boolean isUserNamePresent=userdao.validateUsername(user,"Patient");
	    		boolean isValidPassword=validatePassword(pass);
	    		if (!isUserNamePresent && isValidPassword){
	    		 	session.setAttribute("uname", request.getParameter("uname"));
	    		 	session.setAttribute("pass", request.getParameter("pass"));
    		 		return new ModelAndView("registerPatient", "patient", new Patient(userName,password,firstName,lastName,age,gender,telephone,email,height,weight));
        		}
        		else if(isUserNamePresent && isValidPassword)
        		{
    				request.setAttribute("message", "Username is already taken. Try a new one"); // Will be available as ${message}
    				return new ModelAndView("registration");
        		}
        		else if(!isUserNamePresent && !isValidPassword)
        		{
    				request.setAttribute("message", "Password does not meet Requirements. Try a new one"); // Will be available as ${message}
    				return new ModelAndView("registration");
        		}
        		else{
    				request.setAttribute("message", "Username is already taken. Password is Invalid"); // Will be available as ${message}
    				return new ModelAndView("registration");

        		}
		 	}
	 		else{
		 		boolean isUserNamePresent=userdao.validateUsername(user,"Doctor");
	    		boolean isValidPassword=validatePassword(pass);
	    		if (!isUserNamePresent && isValidPassword){
	    		 	session.setAttribute("uname", request.getParameter("uname"));
	    		 	session.setAttribute("pass", request.getParameter("pass"));
			 		return new ModelAndView("registerDoctor", "doctor", new Doctor(userName,password,firstName,lastName,age,gender,telephone,email,location,specialization,day,starttime,endtime));
        		}
        		else if(isUserNamePresent && isValidPassword)
        		{
    				request.setAttribute("message", "Username is already taken. Try a new one"); // Will be available as ${message}
    				return new ModelAndView("registration");
        		}
        		else if(!isUserNamePresent && !isValidPassword)
        		{
    				request.setAttribute("message", "Password does not meet Requirements. Try a new one"); // Will be available as ${message}
    				return new ModelAndView("registration");
        		}
        		else{
    				request.setAttribute("message", "Username is already taken. Password is Invalid"); // Will be available as ${message}
    				return new ModelAndView("registration");
        		}
	 		}
	 }

	 @RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	 public String welcomePatient (@ModelAttribute("patientForm") Patient patient,ModelMap model, HttpServletRequest request)
	 {
     	 HttpSession session = request.getSession();
		 String uname=(String) request.getSession().getAttribute("uname");
     	 String pass=(String) request.getSession().getAttribute("pass");
     	 patient.setUserName(uname);
     	 patient.setPassword(pass);
		 patient=userdao.addPatient(patient); 
		 session.setAttribute("patient", patient);
		 model.addAttribute("firstName",patient.getFirstName());
		 return "welcomePatient";
	 }
	 
	 @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
	 public String welcomeDoctor(@ModelAttribute("doctorForm") Doctor doctor,ModelMap model, HttpServletRequest request) 
	 {
		 HttpSession session = request.getSession();
		 String uname=(String) request.getSession().getAttribute("uname");
     	 String pass=(String) request.getSession().getAttribute("pass");
     	 doctor.setUserName(uname);
     	 doctor.setPassword(pass);
		 doctor = userdao.addDoctor(doctor); 
		 session.setAttribute("doctor", doctor);
		 model.addAttribute("firstName",doctor.getFirstName());
		 return "welcomeDoctor";
	 }
	 
	 @RequestMapping(value = "/appointment", method = RequestMethod.POST)
	 public String appointmentScheduler() 
	 {
		 		return "appointmentScheduler";
	 }
	 
	 @RequestMapping(value = "/editDoctor", method = RequestMethod.POST)
	 public ModelAndView editDoctor(@ModelAttribute("doctorForm") Doctor doctor,ModelMap model, HttpServletRequest request) 
	 {
		 HttpSession session = request.getSession();
 		 doctor=(Doctor)session.getAttribute("doctor");
 		 model.addAttribute("firstName",doctor.getFirstName());
		 return new ModelAndView("editDoctorProfile", "doctor1", userdao.getDoctor(doctor.getUserName()));
	 }
	 
	 @RequestMapping(value = "/editPatient", method = RequestMethod.POST)
	 public ModelAndView editPatient(@ModelAttribute("patientForm") Patient patient,ModelMap model,HttpServletRequest request) 
	 {
		 HttpSession session = request.getSession();
 		 patient=(Patient)session.getAttribute("patient");
 		 model.addAttribute("firstName",patient.getFirstName());
		 return new ModelAndView("editPatientProfile", "patient1", userdao.getPatient(patient.getUserName()));
	 }
	 
	@RequestMapping(value = "/editPatientProfile", method = RequestMethod.POST)
	public String editPatientProfile(@ModelAttribute("patientForm") Patient patient1,ModelMap model, HttpServletRequest request) 
	{	
		HttpSession session = request.getSession();
		Patient patient = (Patient) session.getAttribute("patient");
		patient1.setId(patient.getId());
		patient1.setGender(patient.getGender());
		patient1.setUserName(patient.getUserName());
		patient1.setPassword(patient.getPassword());
		patient1.setAppointment(patient.getAppointment());
		patient1.setDoctor(patient.getDoctor());
		patient1.setHealthparameters(patient.getHealthparameters());
		userdao.editPatientProfile(patient1);
		patient1 = userdao.getPatient(patient1.getUserName());
		session.setAttribute("patient", patient1);
		model.addAttribute("firstName",patient1.getFirstName());
		return "welcomePatient";
	}
	
	//shreya
		@RequestMapping(value = "/editDoctorProfile", method = RequestMethod.POST)
		public String editDoctorProfile(@ModelAttribute("doctorForm") Doctor doctor1,ModelMap model, HttpServletRequest request) 
		{	
			HttpSession session = request.getSession();
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			doctor1.setId(doctor.getId());
			doctor1.setGender(doctor.getGender());
			doctor1.setUserName(doctor.getUserName());
			doctor1.setPassword(doctor.getPassword());
			doctor1.setAppointments(doctor.getAppointments());
			doctor1.setPatients(doctor.getPatients());
			userdao.editDoctorProfile(doctor1);
			doctor1 = userdao.getDoctor(doctor1.getUserName());
			session.setAttribute("doctor", doctor1);
			model.addAttribute("firstName",doctor1.getFirstName());
			return "welcomeDoctor";
		}
		 @RequestMapping(value = "/addAdvisingDoctor", method = RequestMethod.POST)
		 public String addAdvisingDoctor(@RequestParam ("SelectedDoctor")String doc, HttpServletRequest request) 
		 {
			System.out.println(doc); 
			Patient patient = (Patient)request.getSession().getAttribute("patient");
			System.out.println(patient.getFirstName()); 
			int ID= Integer.parseInt(doc.split("\\s+")[0]);
			System.out.println(ID);
			Doctor doctor = userdao.getDoctorbyID(ID);
			patient.setDoctor(doctor);
			userdao.editPatientProfile(patient);
			return "SuccessAddingDoc";
		 }
		@RequestMapping(value = "/viewPatients", method = RequestMethod.POST)
		public String viewPatients(@ModelAttribute("doctorForm") Doctor doctor1, ModelMap model, HttpServletRequest request) 
		{
			HttpSession session = request.getSession();
			Doctor doctor = (Doctor)session.getAttribute("doctor");
			int id = doctor.getId();
			java.util.List<Patient> patients;
			patients = userdao.getPatients(id);
			model.addAttribute("patients","patients");
			if(patients.size()!=0)
				model.addAttribute("Display","display:show");
			else
				model.addAttribute("Display","display:none"); 
			//model.addAttribute("patients", patientsList);
			List<String> patientsList = new ArrayList<String>();
			String str;
			for (int i = 0; i < patients.size(); i++) 
				{
		           str = "Id: "+patients.get(i).getId()+" Name: "+patients.get(i).getFirstName()+" "+patients.get(i).getLastName();
		           patientsList.add(str);
		           System.out.println(str);
		        }
			
				model.addAttribute("patientsList", patientsList);
				return "viewPatients";
		}
		
		@RequestMapping(value = "/view", method = RequestMethod.POST)
		public String viewList(@RequestParam("listedPatients")String selected, @RequestParam(value = "viewProfile", required=false)String profile, @RequestParam(value = "ViewHealthParameters", required=false)String health,  @ModelAttribute("doctorForm") Doctor doctor1, ModelMap model, HttpServletRequest request) 
		{
			if(profile == null || profile.isEmpty())
			{
			System.out.println("selected patient:"+selected);
			int id= Integer.parseInt(selected.split("\\s+")[1]);
			System.out.println(id);
			HealthParameters healthParameters = userdao.getHealthParameters(id);
			model.addAttribute("healthParameters", healthParameters);
			System.out.println("Calories: "+healthParameters.getCalories());
			return "viewHealthParameters";
			}
			else
			{
				HttpSession session = request.getSession();
				int id = Integer.parseInt(selected.split("\\s+")[1]);
				System.out.println(id);
				Patient patient = userdao.getPatientById(id);
				session.setAttribute("patient", patient);
				return "viewPatientProfile";
			}
				
		}
		@RequestMapping(value = "/viewHealthparametersPatient", method = RequestMethod.POST)
		public String viewHealthParameters(@ModelAttribute("patientForm") Patient patient, ModelMap model, HttpServletRequest request) 
		{
			HttpSession session = request.getSession();
	 		patient=(Patient)session.getAttribute("patient");
			HealthParameters healthParameters = userdao.getHealthParameters(patient.getId());
			model.addAttribute("healthParameters", healthParameters);
			System.out.println("Calories: "+healthParameters.getCalories());
			return "viewHealthParameters";	
		}
		
	 @RequestMapping(value = "/SetDoctor", method = RequestMethod.POST)
	 public ModelAndView SetDoctor(ModelMap model, HttpServletRequest request) 
	 {
		 		HttpSession session = request.getSession();
				Patient patient = (Patient)session.getAttribute("patient");
				Doctor doctor = patient.getDoctor();
				if (doctor==null){
					return new ModelAndView("adddoctor");
				}
				else{
					Doctor AdvisingDoctor=patient.getDoctor();
					String DocInfo = AdvisingDoctor.getId()+ " "+AdvisingDoctor.getFirstName()+ " "+AdvisingDoctor.getLastName()+" "+AdvisingDoctor.getEmail()+
					         " "+AdvisingDoctor.getLocation()+" "+AdvisingDoctor.getSpecialization();

					System.out.println(DocInfo);
					model.addAttribute("DocInfo",DocInfo);
					return new ModelAndView("removedoctor");
				}
					
	 }
	 @RequestMapping(value = "/AddDoctor", method = RequestMethod.POST)
	 public String AddDoctor(ModelMap model) 
	 {
		 java.util.List Location = userdao.getLocations(); 
		 for (int i = 0; i<Location.size();i++){		 
			 System.out.println(Location.get(i));
		 }
		 model.addAttribute("Location",Location);
		 model.addAttribute("Locations","Locations");
		 List<String> DoctorInfo=new ArrayList<String>();
		 model.addAttribute("Display","display:none");
		 model.addAttribute("Doctor",DoctorInfo);
		 model.addAttribute("Doctors","Doctors");
		 java.util.List Specialization = userdao.getSpecializations(); 
		 for (int i = 0; i<Specialization.size();i++){		 
			 System.out.println(Specialization.get(i));
		 }
		 model.addAttribute("Specialization",Specialization);
		 model.addAttribute("Specializations","Specializations");
		 return "displayDoctors";
	 }
	 
	 @RequestMapping(value = "/scheduler", method = RequestMethod.POST)
	 public String appointmentScheduler(@RequestParam ("appointtype")String app,ModelMap model)
	 {
		 model.addAttribute("Display","display:none");
		 if(app.equals("Book Appointment")){
			 java.util.List Location = userdao.getLocations(); 
			 for (int i = 0; i<Location.size();i++){		 
				 System.out.println(Location.get(i));
			 }
			 model.addAttribute("Location",Location);
			 model.addAttribute("Locations","Locations");
			 List<String> DoctorInfo=new ArrayList<String>();
			 model.addAttribute("Doctor",DoctorInfo);
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
	 
	 @RequestMapping(value = "/searchadvisingdoctor", method = RequestMethod.POST)
	 public String displayDoctors(@RequestParam ("LocationSelected")String loc,@RequestParam ("SortPref")String sort,@RequestParam ("SpecializationSelected")String Spl,ModelMap model) 
	 {
		 java.util.List<Doctor> Doctors = null;
		 if(sort.equals("location"))
		 {
			 ContextSort context = new ContextSort(new LocationSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		 else if(sort.equals("specialization"))
		 {
			 ContextSort context = new ContextSort(new SpecializationSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		 else
		 {
			 ContextSort context = new ContextSort(new NameSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		 List<String> DoctorInfo=new ArrayList<String>();
		 for (int i = 0; i<Doctors.size();i++){	
			 DoctorInfo.add(Doctors.get(i).getId()+ " "+Doctors.get(i).getFirstName()+ " "+Doctors.get(i).getLastName()+" "+Doctors.get(i).getEmail()+
			         " "+Doctors.get(i).getLocation()+" "+Doctors.get(i).getSpecialization());

			 System.out.println(Doctors.get(i).getFirstName());
		 }
		 if(DoctorInfo.size()==0){
			 model.addAttribute("Display","display:none");
		 }
		 else{
			 model.addAttribute("Display","display:show"); 
		 }
		 model.addAttribute("Doctor",DoctorInfo);
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
		 return "displayDoctors";
	 }
	 @RequestMapping(value = "/search", method = RequestMethod.POST)
	 public String DisplaySearch(@RequestParam ("LocationSelected")String loc,@RequestParam ("date")String d,@RequestParam ("SortPref")String sort,@RequestParam ("SpecializationSelected")String Spl,@ModelAttribute("userForm") User user,ModelMap model) throws ParseException 
	 {
		 java.util.List<Doctor> Doctors = null; 
		 if(sort.equals("location"))
		 {
			 ContextSort context = new ContextSort(new LocationSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		 else if(sort.equals("specialization"))
		 {
			 ContextSort context = new ContextSort(new SpecializationSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		 else
		 {
			 ContextSort context = new ContextSort(new NameSort());
			 Doctors = context.executeSort(loc, Spl);
		 }
		// java.util.List<Doctor> Doctors = userdao.getDoctors(loc,Spl,sort); 
		 
		 List<String> DoctorInfo=new ArrayList<String>();
		 
		 for (int i = 0; i<Doctors.size();i++){	
			 DoctorInfo.add(Doctors.get(i).getId()+ " "+Doctors.get(i).getFirstName()+ " "+Doctors.get(i).getLastName()+" "+Doctors.get(i).getEmail() 
					         +" "+ Doctors.get(i).getAge()+" "+Doctors.get(i).getTelephone()+" "+Doctors.get(i).getLocation()+" "+Doctors.get(i).getSpecialization());
			 System.out.println(Doctors.get(i).getFirstName());
		 }
		 if(DoctorInfo.size()==0){
			 model.addAttribute("Display","display:none");
		 }
		 else{
			 model.addAttribute("Display","display:show"); 
		 }
		 model.addAttribute("Doctor",DoctorInfo);
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
		 
		
		 SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		 Date dt1=format1.parse(d);
		 DateFormat format2=new SimpleDateFormat("EEEE"); 
		 String finalDay=format2.format(dt1);
		 System.out.println(finalDay);
		  
		 return "bookAppointment";
	 }
	 
	 @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	 public String addSelectedDoctor(@RequestParam ("SelectedDoctor")String doc,HttpServletRequest request, ModelMap model) 
	 {
		System.out.println(doc); 
		Patient patient = (Patient)request.getSession().getAttribute("patient");
		System.out.println(patient.getFirstName()); 
		int ID= Integer.parseInt(doc.split("\\s+")[0]);
		System.out.println(ID);
		Doctor doctor = userdao.getDoctorbyID(ID);
		String starttime = doctor.getStarttime();
		String endtime = doctor.getEndtime();
		String day = doctor.getDay();
		List<String> days=new ArrayList<String>();
		for(String d : day.split(","))
		{
			System.out.println(d);
			days.add(d);
		}
		int start = Integer.parseInt(starttime);
		int end = Integer.parseInt(endtime);
		List<String> slots=new ArrayList<String>();
		for(int i=start;i<end;i++)
		{
			slots.add(" "+i+"-"+(i+1));
		}
		
		request.getSession().setAttribute("doctor", doctor);
		model.addAttribute("appoint","appoint");
		model.addAttribute("slots",slots);
		model.addAttribute("d","d");
		model.addAttribute("days",days);
		model.addAttribute("endtime",endtime);
		model.addAttribute("day",day);
		//patient.setDoctor(doctor);
		//userdao.editPatientProfile(patient);
		return "AppointmentList";
	 }
	 @RequestMapping(value = "/selectAppointment", method = RequestMethod.POST)
	 public String addAppointmentDoctor(@RequestParam ("SelectedAppointment")String a, HttpServletRequest request, ModelMap model) 
	 {
		 Appointment appoint=new Appointment();
		 Patient patient = (Patient)request.getSession().getAttribute("patient");
		 Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
		 System.out.println(doctor);
		 appoint.setDoctor(doctor);
		 appoint.setPatient(patient);
		 userdao.addAppointment(appoint);
		 patient.setAppointment(appoint);
		 request.getSession().setAttribute("doctor", null);
		 System.out.println(a);
		 return "AppointmentConfirm";
	 }
	
	 @RequestMapping(value = "/DeselectDoctor", method = RequestMethod.POST)
	 public ModelAndView removeAdvisingDoctor(HttpServletRequest request) 
	 {
			Patient patient = (Patient)request.getSession().getAttribute("patient");
			patient.setDoctor(null);
			userdao.editPatientProfile(patient);
			return new ModelAndView("adddoctor");
	 }
	 @RequestMapping(value = "CancelAppointment", method = RequestMethod.POST)
	 public String cancelAppointment(HttpServletRequest request)
	 {
		 Patient patient = (Patient)request.getSession().getAttribute("patient");
		 Appointment app = patient.getAppointment();
		 System.out.println(app);
		 
		 app.setDoctor(null);
		 app.setPatient(null);
		 app.setDateTime(null);
		 patient.setAppointment(null);
		 userdao.cancelAppointment(app);
		 userdao.editPatientProfile(patient);
		 return "appointmentScheduler";
	 }
	 
	 
}
