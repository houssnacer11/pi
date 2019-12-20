package tn.esprit.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.pidev.entities.Visiteur;
import tn.pidev.impl.VisiteurServiceImpl;

@ManagedBean(name = "visiteurBean")
@SessionScoped
public class VisiteurBean implements Serializable {
	
	@EJB
	VisiteurServiceImpl vs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Visiteur> visiteurs;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int idToUpdate;
	
	
	
	public Visiteur findVisiteurbyId(int idVisiteur) {
		Visiteur Visiteur = vs.findVisiteur(idVisiteur);
		return Visiteur;
	}

	public List<Visiteur> getVisiteurs() {
		visiteurs=vs.afficherVisiteurs();
		return visiteurs;
	}
	
	public String modifVisitPage(Visiteur visiteur)
	{
		this.setIdToUpdate(visiteur.getId_visiteur());
		this.setFirstName(visiteur.getFirstName());
		this.setLastName(visiteur.getLastName());
		this.setEmail(visiteur.getEmail());
		this.setUsername(visiteur.getUsername());
		
		
		return "pages/user/chprofile?faces-redirect=true";
	}
	
	public String updateVisiteur(int id_login,String firstname,String lastname,String email,String username,String pass)
	{
		Visiteur v=new Visiteur(id_login,firstname,lastname,email,username,pass);
		vs.updateVisiteur(v);
		
		return "/pages/frontend/userprofile?faces-redirect=true";
		
	}
	
	public void setVisiteurs(List<Visiteur> visiteurs) {
		this.visiteurs = visiteurs;
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdToUpdate() {
		return idToUpdate;
	}

	public void setIdToUpdate(int idToUpdate) {
		this.idToUpdate = idToUpdate;
	}
	
	
	
}
