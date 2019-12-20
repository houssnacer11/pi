package tn.pidev.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.pidev.entities.Employe;

@Remote
public interface IEmployeRemote {

	public Employe getEmployeByEmailAndPassword(String email, String password);
	public int ajouterEmploye(Employe employe);
	public void supprimerEmploye(int idEmploye);
	public Employe findEmploye(int idEmploye);
	public List<Employe> afficherEmploye();	
	public void updateEmploye(Employe NewEmploye);
	public Employe getEmployeById(int id);
	
}
