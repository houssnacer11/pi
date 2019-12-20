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
public class Immobilier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -80896952901737397L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_immobilier;
	private String intitule;
	private String description;
	private String adresse;	
	private int metrage;
	private float prix;
	private Categories categorie;
	
	@OneToMany(mappedBy = "immobilier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rendezvous> rdvs;
	
	public Immobilier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Immobilier(int id_immobilier, boolean isActif, String intitule, String description, String adresse,
			int metrage, float prix, Categories categorie) {
		super();
		this.id_immobilier = id_immobilier;
		this.intitule = intitule;
		this.description = description;
		this.adresse = adresse;
		this.metrage = metrage;
		this.prix = prix;
		this.categorie = categorie;
	}

	

	public Immobilier(String intitule, String description, String adresse, int metrage, float prix,
			Categories categorie) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.adresse = adresse;
		this.metrage = metrage;
		this.prix = prix;
		this.categorie = categorie;
	}

	public int getId_immobilier() {
		return id_immobilier;
	}

	public void setId_immobilier(int id_immobilier) {
		this.id_immobilier = id_immobilier;
	}

	

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getMetrage() {
		return metrage;
	}

	public void setMetrage(int metrage) {
		this.metrage = metrage;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

	public List<Rendezvous> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rendezvous> rdvs) {
		this.rdvs = rdvs;
	}
	
	
	

	
	
}
