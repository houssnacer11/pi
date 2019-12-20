package tn.pidev.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pidev.entities.Employe;
import tn.pidev.interfaces.IEmployeRemote;

@Stateless
@LocalBean
public class EmployeServiceImpl implements IEmployeRemote{

	@PersistenceContext(unitName="PIJEE-ejb")
	EntityManager em;
	
	
	
	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId_employe();
	}

	@Override
	public void supprimerEmploye(int idEmploye) {
		Employe e = em.find(Employe.class, idEmploye);
		em.remove(e);
		
	}

	@Override
	public Employe findEmploye(int idEmploye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> afficherEmploye() {
		List<Employe> Lemployes = em.createQuery("select p from Employe p", Employe.class).getResultList();
		return Lemployes;
	}

	@Override
	public void updateEmploye(Employe NewEmploye) {
		
		Employe e=em.find(Employe.class, NewEmploye.getId_employe());
		
		e.setFirstName(NewEmploye.getFirstName());
		e.setLastName(NewEmploye.getLastName());
		e.setEmail(NewEmploye.getEmail());
		e.setUsername(NewEmploye.getUsername());
		e.setPassword(NewEmploye.getPassword());
		
		
		
	}

	
	@Override
	public Employe getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Employe> query = em
				.createQuery("select e from Employe e  where e.email=:email and e.password=:password ", Employe.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Employe employe = null;
		try {
			employe = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}
	
	@Override
	public Employe getEmployeById(int id) {
		TypedQuery<Employe> query = em
				.createQuery("select e from Employe e  where e.id_employe=:id ", Employe.class);
		query.setParameter("id", id);
		Employe employe = null;
		try {
			employe = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}
	

	

}
