package tn.esprit.managedbeans;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import tn.pidev.entities.Employe;
import tn.pidev.entities.Role;
import tn.pidev.entities.Visiteur;
import tn.pidev.impl.EmployeServiceImpl;
import tn.pidev.impl.VisiteurServiceImpl;



@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String newpassword;
	private int id_login;
	private Role onRole;
	FacesContext context = FacesContext.getCurrentInstance();

	
	private Employe employe;
	private Visiteur visiteur;
	
	
	private Boolean loggedIn;
	@EJB
	EmployeServiceImpl employeService;
	@EJB
	VisiteurServiceImpl visiteurService;

	public String doLogin() {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
		String navigateTo = "null";
		employe = employeService.getEmployeByEmailAndPassword(login, password);
		visiteur = visiteurService.getVisiteurByEmailAndPassword(login, password);
		if(employe != null)
		{
			username=employe.getUsername();
			lastname=employe.getLastName();
			firstname=employe.getFirstName();
			id_login=employe.getId_employe();
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("id_emp", id_login);
			
			
			if(employe.getRole()==Role.ADMINISTRATEUR)
			{
				onRole=Role.ADMINISTRATEUR;
			}
			if(employe.getRole()==Role.EMPLOYE)
			{
				onRole=Role.EMPLOYE;
			}
			navigateTo = "/pages/backend/dashboard?faces-redirect=true";
			loggedIn = true;
		}
		else if (visiteur != null) 
		{
			username=visiteur.getUsername();
			firstname=visiteur.getFirstName();
			lastname=visiteur.getLastName();
			email=visiteur.getEmail();
			password=visiteur.getPassword();
			id_login=visiteur.getId_visiteur();
			navigateTo = "/pages/frontend/listImmobilierPage?faces-redirect=true";
			loggedIn = true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn_login", new FacesMessage("Bad Credentials"));
		}
		
		return navigateTo;
	}
	
	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	public String doChangeProfilePage()
	{
		String navigateTo = "null";
		
		navigateTo = "/pages/auth/chprofile?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	
	
	public String doSignUpPage()
	{
		String navigateTo = "null";
	
		navigateTo = "/pages/auth/register?faces-redirect=true";
		return navigateTo;
	}
	
	public String doLoginPage()
	{
		String navigateTo = "null";
		navigateTo = "/pages/auth/login?faces-redirect=true";
		return navigateTo;
	}
	

	public String doSignUp()
	{
		String navigateTo = "null";
		Visiteur v =new Visiteur();
		v.setEmail(email);
		v.setFirstName(firstname);
		v.setLastName(lastname);
		v.setUsername(username);
		v.setPassword(password);
		
		if(visiteurService.ajouterVisiteur(v) != 0)
		{
			return navigateTo = "/pages/auth/login?faces-redirect=true";
		}
		return navigateTo;
	}
	
	
	public String doLogout() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.firstname="";
		this.lastname="";
		this.email="";
		this.username="";
		this.password="";
		
		return "/pages/auth/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public EmployeServiceImpl getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeServiceImpl employeService) {
		this.employeService = employeService;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getOnRole() {
		return onRole;
	}

	public void setOnRole(Role onRole) {
		this.onRole = onRole;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public int getId_login() {
		return id_login;
	}

	public void setId_login(int id_login) {
		this.id_login = id_login;
	}


	
	
	
}