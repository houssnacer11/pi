package tn.pidev.interfaces;


import java.util.List;

import javax.ejb.Remote;

import tn.pidev.entities.Visiteur;

@Remote
public interface IVisiteurRemote {
	
	public int ajouterVisiteur(Visiteur Visiteur);
	public void supprimerVisiteur(int idVisiteur);
	public Visiteur findVisiteur(int idVisiteur);
	public Visiteur findVisiteurbyEmail(String Email);
	public List<Visiteur> afficherVisiteurs();
	public void updateVisiteur(Visiteur Visiteur);
	public Visiteur getVisiteurByEmailAndPassword(String email, String password);
	

}
