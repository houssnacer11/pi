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
public class Visiteur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_visiteur;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String image;
	
	
	@OneToMany(mappedBy = "visiteur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rendezvous> rdvs;
	

	public Visiteur(String firstName, String lastName, String email, String username, String password,
			int etat_contrat) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		
	}

	public Visiteur() {
		super();
	}

	public int getId_visiteur() {
		return id_visiteur;
	}

	public void setId_visiteur(int id_visiteur) {
		this.id_visiteur = id_visiteur;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
		public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Visiteur(int id_visiteur, String firstName, String lastName, String email, String username,
			String password, String image) {
		super();
		this.id_visiteur = id_visiteur;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.image = image;
	}

	public Visiteur(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Visiteur(int id_visiteur, String firstName, String lastName, String email, String username,String password) {
		super();
		this.id_visiteur = id_visiteur;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password=password;
		
	}
	
	
	

}
