package tn.esprit.managedbeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import tn.pidev.entities.Immobilier;
import tn.pidev.entities.Rendezvous;
import tn.pidev.entities.Visiteur;
import tn.pidev.impl.EmployeServiceImpl;
import tn.pidev.impl.ImmobilierServiceImpl;
import tn.pidev.impl.RdvServiceImpl;
import tn.pidev.impl.VisiteurServiceImpl;



@ManagedBean(name = "rdvBean")
@SessionScoped
public class RdvBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String message;
	private int id_visiteur;
	private int id_immobilier;
	private int id_employe;
	private int id_rdv;
	private List<Rendezvous> rdvs;
	private List<Rendezvous> rdvs_emp;
	
	
	
	@EJB
	RdvServiceImpl rs;
	
	@EJB
	ImmobilierServiceImpl is;
	
	@EJB
	VisiteurServiceImpl vs;
	
	@EJB
	EmployeServiceImpl es;
	
	public List<Rendezvous> getRdvs() {
		rdvs=rs.afficherRdvs();
		return rdvs;
	}
	
	public void setRdvs(List<Rendezvous> rdvs) {
		this.rdvs = rdvs;
	}
	
	
	public List<Rendezvous> getRdvs_emp() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("id_emp");
		rdvs_emp=rs.afficherRdvsEmp(id);
		return rdvs_emp;
	}
	
	public void setRdvs_emp(List<Rendezvous> rdvs_emp) {
		this.rdvs_emp = rdvs_emp;
	}
	
	
	
	
	public String addRdv(int id_imm,int id_vis)
	{
		
		id_immobilier=id_imm;
		id_visiteur=id_vis;
		
		

		
		String navigateTo = "null";
		navigateTo = "/pages/frontend/listImmobilierPage?faces-redirect=true";
		
		
		Rendezvous rdv=new Rendezvous();
		rdv.setDate_rdv(new Date(date.getYear(),date.getMonth(),date.getDate()));
		rdv.setMessage(message);
		Immobilier imm=is.findImmobilier(id_immobilier);
		rdv.setImmobilier(imm);
		Visiteur visit=vs.findVisiteur(id_visiteur);
		rdv.setVisiteur(visit);
		rs.ajouterRdv(rdv);
		
		
		return navigateTo;
	}
	
	
	public String affecterRdv(int id_empl,int id_rend)
	{
		String navigateTo = "null";
		navigateTo = "/pages/backend/afficherRendezVous?faces-redirect=true";
		
		rs.affecterEmployeRdv(id_empl,id_rend);
		
		
		return navigateTo;
	}
	
	public void suppRdv(int id_rdv)
	{
		rs.declinerRdv(id_rdv);
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId_visiteur() {
		return id_visiteur;
	}
	public void setId_visiteur(int id_visiteur) {
		this.id_visiteur = id_visiteur;
	}
	


	public int getId_immobilier() {
		return id_immobilier;
	}


	public void setId_immobilier(int id_immobilier) {
		this.id_immobilier = id_immobilier;
	}




	public int getId_employe() {
		return id_employe;
	}




	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}


	public int getId_rdv() {
		return id_rdv;
	}


	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}

	
	
	
	

}
