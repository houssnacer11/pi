package tn.pidev.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pidev.entities.Employe;
import tn.pidev.entities.Rendezvous;
import tn.pidev.entities.Visiteur;
import tn.pidev.interfaces.IRDVRemote;

@Stateless
@LocalBean
public class RdvServiceImpl implements IRDVRemote {

	
	@PersistenceContext(unitName = "PIJEE-ejb")
	EntityManager em;
	
	@Override
	public String ajouterRdv(Rendezvous rdv) {
		em.persist(rdv);
		return "RDV N°" + rdv.getId_rdv() + " a été ajouter avec succées";
		
	}

	@Override
	public String affecterEmployeRdv(int id_emp, int id_rdv) {
		Rendezvous rdv = em.find(Rendezvous.class, id_rdv);
		Employe employe = em.find(Employe.class, id_emp);
		rdv.setEmploye(employe);
		em.merge(employe);
		return "c bnnn ";
	}

	@Override
	public void declinerRdv(int id_rdv) {
		Rendezvous rdve = em.find(Rendezvous.class, id_rdv);
		em.remove(rdve);	
	}

	@Override
	public List<Rendezvous> afficherRdvs() {
		List<Rendezvous> LRdvs = em.createQuery("select p from Rendezvous p", Rendezvous.class).getResultList();
		return LRdvs;
	}

	public List<Rendezvous> afficherRdvsEmp(int id_emp) {
		TypedQuery<Rendezvous> Lrdvs = em.createQuery("select t from Rendezvous t where t.employe.id_employe=:id ", Rendezvous.class).setParameter("id", id_emp);
		return Lrdvs.getResultList();
	}

}
