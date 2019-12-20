package tn.pidev.interfaces;


import java.util.List;

import javax.ejb.Remote;

import tn.pidev.entities.Rendezvous;
import tn.pidev.entities.Visiteur;

@Remote
public interface IRDVRemote {
	
	public String ajouterRdv(Rendezvous rdv);
	public String affecterEmployeRdv(int emp,int id_rdv);
	public void declinerRdv(int id_rdv);
	public List<Rendezvous> afficherRdvs();
	public List<Rendezvous> afficherRdvsEmp(int id_emp);
	

}
