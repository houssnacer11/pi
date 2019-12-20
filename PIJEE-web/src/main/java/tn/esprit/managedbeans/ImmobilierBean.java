package tn.esprit.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.pidev.entities.Categories;
import tn.pidev.entities.Immobilier;
import tn.pidev.impl.ImmobilierServiceImpl;

@ManagedBean(name = "immobilierBean")
@SessionScoped
public class ImmobilierBean implements Serializable {
	
	@EJB
	ImmobilierServiceImpl is;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<Immobilier> immobiliers;
	private String intitule;
	private String description;
	private String adresse;	
	private int metrage;
	private float prix;
	private Categories categorie;
	private int idToUpdate;
	private String value;
	
	
	public String doDetailsPage(int id)
	{
		String navigateTo = "null";
		Immobilier immo=is.getImmobilierById(id);
		intitule=immo.getIntitule();
		description=immo.getDescription();
		adresse=immo.getAdresse();
		metrage=immo.getMetrage();
		prix=immo.getPrix();
		categorie=immo.getCategorie();
		idToUpdate=immo.getId_immobilier();
		navigateTo = "/pages/frontend/ImmobilierDetails?faces-redirect=true";
		return navigateTo;
	}
	
	public String doAppointmentPage()
	{
		String navigateTo = "null";
		
		navigateTo = "/pages/frontend/rendezvousPage?faces-redirect=true";
		return navigateTo;
	}
	
	public void suppImmobilier(int id_immobilier)
	{
		is.supprimerImmobilier(id_immobilier);
	}
	
	
	public String addImmobilierPage()
	{
		
		this.intitule="";
		this.description="";
		this.adresse="";
		this.metrage=0;
		this.prix=0;
		this.categorie=Categories.TERRAIN;
		this.idToUpdate=0;
		
		return "/pages/backend/AjoutImmobilier?faces-redirect=true";
	}
	
	public String modifImmobilierPage(Immobilier immobilier)
	{
		this.setIdToUpdate(immobilier.getId_immobilier());
		this.setIntitule(immobilier.getIntitule());
		this.setDescription(immobilier.getDescription());
		this.setMetrage(immobilier.getMetrage());
		this.setPrix(immobilier.getPrix());
		this.setCategorie(immobilier.getCategorie());
		this.setAdresse(immobilier.getAdresse());
		System.out.println(idToUpdate);
		return "/pages/backend/AjoutImmobilier?faces-redirect=true";
	}
	
	public String addImmobilier() throws ParseException
	{
		
		if(value.equalsIgnoreCase("HABITATION"))
		{
			Immobilier i=new Immobilier(intitule,description,adresse,metrage,prix,categorie.HABITATION);
			is.ajouterImmobilier(i);
		}
		if(value.equalsIgnoreCase("BATIMENT"))
		{
			Immobilier i=new Immobilier(intitule,description,adresse,metrage,prix,categorie.BATIMENT);
			is.ajouterImmobilier(i);
		}
		if(value.equalsIgnoreCase("BUREAU"))
		{
			Immobilier i=new Immobilier(intitule,description,adresse,metrage,prix,categorie.BUREAU);
			is.ajouterImmobilier(i);
		}
		if(value.equalsIgnoreCase("TERRAIN"))
		{
			Immobilier i=new Immobilier(intitule,description,adresse,metrage,prix,categorie.TERRAIN);
			is.ajouterImmobilier(i);
		}
		
		
		idToUpdate=0;
		return "/pages/backend/afficherImmobilier?faces-redirect=true";
	}
	
	public String updateImmobilier()
	{
		if(value.equalsIgnoreCase("HABITATION"))
		{
			is.updateImmobilier(new Immobilier(idToUpdate,true,intitule,description,adresse,metrage,prix,categorie.HABITATION));
		}
		if(value.equalsIgnoreCase("BATIMENT"))
		{
			is.updateImmobilier(new Immobilier(idToUpdate,true,intitule,description,adresse,metrage,prix,categorie.BATIMENT));
		}
		if(value.equalsIgnoreCase("BUREAU"))
		{
			is.updateImmobilier(new Immobilier(idToUpdate,true,intitule,description,adresse,metrage,prix,categorie.BUREAU));
		}
		if(value.equalsIgnoreCase("TERRAIN"))
		{
			is.updateImmobilier(new Immobilier(idToUpdate,true,intitule,description,adresse,metrage,prix,categorie.TERRAIN));
		}
		
		return "/pages/backend/afficherImmobilier?faces-redirect=true";

	}
	
	
	
	public String pdfPage()
	{
		return "/pages/pdfEmploye?faces-redirect=true";
	
	}
	
	
	public List<Immobilier> getImmobiliers() {
		immobiliers=is.afficherImmobilier();
		return immobiliers;
	}
	
	public void setVisiteurs(List<Immobilier> immobiliers) {
		this.immobiliers = immobiliers;
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
	public int getIdToUpdate() {
		return idToUpdate;
	}
	public void setIdToUpdate(int idToUpdate) {
		this.idToUpdate = idToUpdate;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
}
