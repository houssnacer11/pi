package tn.esprit.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.pidev.entities.Employe;
import tn.pidev.entities.Role;
import tn.pidev.impl.EmployeServiceImpl;

@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employe> employes;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private int idToUpdate;
	


	private String password;
	private Role role;
	
	@EJB
	EmployeServiceImpl es;

	
	

	public void suppEmploye(int id_employe)
	{
		es.supprimerEmploye(id_employe);
	}
	
	public List<Employe> getEmployes() {
		employes=es.afficherEmploye();
		return employes;
	}
	
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	public String addEmployePage()
	{
		
		this.firstName="";
		this.lastName="";
		this.email="";
		this.username="";
		this.password="";
		this.idToUpdate=0;
		
		System.out.println(idToUpdate);
		return "/pages/backend/AjoutEmploye?faces-redirect=true";
	}
	
	public String modifEmployePage(Employe employe)
	{
		this.setIdToUpdate(employe.getId_employe());
		this.setFirstName(employe.getFirstName());
		this.setLastName(employe.getLastName());
		this.setEmail(employe.getEmail());
		this.setUsername(employe.getUsername());
		this.setPassword(employe.getPassword());
		
		System.out.println(idToUpdate);
		return "/pages/backend/AjoutEmploye?faces-redirect=true";
	}
	
	public String addEmploye() throws ParseException
	{
		Employe e=new Employe(true,firstName,lastName,email,username,password,role.EMPLOYE);
		es.ajouterEmploye(e); 
		idToUpdate=0;
		return "/pages/backend/afficherEmploye?faces-redirect=true";
	}
	

	public String updateEmploye()
	{
		es.updateEmploye(new Employe(idToUpdate,true,firstName,lastName,email,username,password,Role.EMPLOYE));
		return "/pages/backend/afficherEmploye?faces-redirect=true";

	}
	
	
	public String pdfPage()
	{
		return "/pages/backend/pdfEmploye?faces-redirect=true";
	
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	

	public int getIdToUpdate() {
		return idToUpdate;
	}

	public void setIdToUpdate(int idToUpdate) {
		this.idToUpdate = idToUpdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	public EmployeServiceImpl getEs() {
		return es;
	}


	public void setEs(EmployeServiceImpl es) {
		this.es = es;
	}
	
	
	


	
	
	
	
}
