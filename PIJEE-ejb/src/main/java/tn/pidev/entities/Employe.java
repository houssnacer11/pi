package tn.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -80896952901737397L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_employe;
	private boolean isActif;
	private String firstName;
	private String lastName;
	private String email;	
	private String username;
	private String password;
	private Role role;
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rendezvous> rdvs;
	
	public int getId_employe() {
		return id_employe;
	}
	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}
	public boolean isActif() {
		return isActif;
	}
	public void setActif(boolean isActif) {
		this.isActif = isActif;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(boolean isActif, String firstName, String lastName, String email, String username, String password,
			Role role) {
		super();
		this.isActif = isActif;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Employe(int id_employe, boolean isActif, String firstName, String lastName, String email, String username,
			String password, Role role) {
		super();
		this.id_employe = id_employe;
		this.isActif = isActif;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public List<Rendezvous> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<Rendezvous> rdvs) {
		this.rdvs = rdvs;
	}
	
	
	
	


	
	
}
