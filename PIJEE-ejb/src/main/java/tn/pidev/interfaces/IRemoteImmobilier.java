package tn.pidev.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.pidev.entities.Immobilier;

@Remote
public interface IRemoteImmobilier {

	
	public int ajouterImmobilier(Immobilier immobilier);
	public void supprimerImmobilier(int id_immobilier);
	public Immobilier findImmobilier(int id_immobilier);
	public List<Immobilier> afficherImmobilier();	
	public void updateImmobilier(Immobilier NewImmobilier);
	public Immobilier getImmobilierById(int id);
	
}
