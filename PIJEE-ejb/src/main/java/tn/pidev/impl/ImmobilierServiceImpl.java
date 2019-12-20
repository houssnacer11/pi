package tn.pidev.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pidev.entities.Immobilier;
import tn.pidev.interfaces.IRemoteImmobilier;

@Stateless
@LocalBean
public class ImmobilierServiceImpl implements IRemoteImmobilier {

	
	@PersistenceContext(unitName="PIJEE-ejb")
	EntityManager em;
	
	
	@Override
	public int ajouterImmobilier(Immobilier immobilier) {
		em.persist(immobilier);
		return immobilier.getId_immobilier();
	}

	@Override
	public void supprimerImmobilier(int id_immobilier) {
		Immobilier i = em.find(Immobilier.class, id_immobilier);
		em.remove(i);
		
	}

	@Override
	public Immobilier findImmobilier(int id_immobilier) {
		Immobilier i = em.find(Immobilier.class, id_immobilier);
		return i;
	}

	@Override
	public List<Immobilier> afficherImmobilier() {
		List<Immobilier> Limmobilier = em.createQuery("select i from Immobilier i", Immobilier.class).getResultList();
		return Limmobilier;
	}

	@Override
	public void updateImmobilier(Immobilier NewImmobilier) {
		
		Immobilier i=em.find(Immobilier.class, NewImmobilier.getId_immobilier());
		
		i.setIntitule(NewImmobilier.getIntitule());
		i.setDescription(NewImmobilier.getDescription());
		i.setAdresse(NewImmobilier.getAdresse());
		i.setMetrage(NewImmobilier.getMetrage());

		i.setPrix(NewImmobilier.getPrix());
		i.setCategorie(NewImmobilier.getCategorie());
		
		
	}

	@Override
	public Immobilier getImmobilierById(int id) {
		TypedQuery<Immobilier> query = em
				.createQuery("select i from Immobilier i  where i.id_immobilier=:id ", Immobilier.class);
		query.setParameter("id", id);
		Immobilier immobilier = null;
		try {
			immobilier = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return immobilier;
	}

	

}
