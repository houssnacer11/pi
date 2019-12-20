package tn.pidev.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table
public class Rendezvous implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rdv;
	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_rdv;
	@ManyToOne
	private Immobilier immobilier;
	
	@ManyToOne
	private Visiteur visiteur;
	
	@ManyToOne
	private Employe employe;
	
	
	public Rendezvous(Date date_rdv, Immobilier immobilier, String message) {
		super();
		this.date_rdv = date_rdv;
		this.immobilier = immobilier;
		this.message = message;
	}
	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rendezvous(int id_rdv, Date date_rdv, Immobilier immobilier,  String message) {
		super();
		this.id_rdv = id_rdv;
		this.date_rdv = date_rdv;
		this.immobilier = immobilier;
		this.message = message;
	}
	public int getId_rdv() {
		return id_rdv;
	}
	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}
	public Date getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}
	public Immobilier getImmobilier() {
		return immobilier;
	}
	public void setImmobilier(Immobilier immobilier) {
		this.immobilier = immobilier;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Visiteur getVisiteur() {
		return visiteur;
	}
	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	

	
	
	

}
