package tn.pidev.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pidev.entities.Visiteur;
import tn.pidev.interfaces.IVisiteurRemote;

@Stateless
@LocalBean
public class VisiteurServiceImpl implements IVisiteurRemote {

	@PersistenceContext(unitName = "PIJEE-ejb")
	EntityManager em;

	@Override
	public int ajouterVisiteur(Visiteur Visiteur) {
		em.persist(Visiteur);

		return Visiteur.getId_visiteur();
	}

	@Override
	public void supprimerVisiteur(int idVisiteur) {
		Visiteur Visiteur = em.find(Visiteur.class, idVisiteur);
		em.remove(Visiteur);
	}

	@Override
	public Visiteur findVisiteur(int idVisiteur) {
		Visiteur Visiteur = em.find(Visiteur.class, idVisiteur);
		return Visiteur;

	}
@Override
	public Visiteur findVisiteurbyEmail(String Email) {
		Visiteur Visiteur = em.find(Visiteur.class, Email);
		return Visiteur;

	}

	@Override
	public List<Visiteur> afficherVisiteurs() {
		List<Visiteur> LVisiteurs = em.createQuery("select p from Visiteur p", Visiteur.class).getResultList();
		return LVisiteurs;
	}

	@Override
	public void updateVisiteur(Visiteur Visiteur) {
		Visiteur c=em.find(Visiteur.class, Visiteur.getId_visiteur());
		c.setFirstName(Visiteur.getFirstName());
		c.setLastName(Visiteur.getLastName());
		c.setEmail(Visiteur.getEmail());
		c.setUsername(Visiteur.getUsername());
		c.setPassword(Visiteur.getPassword());
		
	}
	
	@Override
	public Visiteur getVisiteurByEmailAndPassword(String email, String password) {
		TypedQuery<Visiteur> query = em
				.createQuery("select v from Visiteur v  where v.email=:email and v.password=:password ", Visiteur.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Visiteur visiteur = null;
		try {
			visiteur = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return visiteur;
	}

	
	
}
