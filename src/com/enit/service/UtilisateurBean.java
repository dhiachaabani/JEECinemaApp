package com.enit.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.enit.entities.Compte;
import com.enit.entities.Film;
import com.enit.entities.Seance;
import com.enit.MyExceptions.*;

@Stateful
public class UtilisateurBean implements Utilisateur {
	@PersistenceContext
	private EntityManager em = null;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public UtilisateurBean() {
		super();
	}

	public float solde() throws UserNotFoundException {
		float sld;
		Query q = em.createNamedQuery("findCompteById");
		q.setParameter("cid", user_id);
		List<Compte> res = (List<Compte>) (q.getResultList());

		if (res.size() == 0)
			throw new UserNotFoundException();
		else
			sld = res.get(0).getSolde();
		return sld;

	}

	public Set<Compte> getAllCompte() {
		Query q = em.createQuery("Select s From Compte s", Compte.class);
		List<Compte> res = (List<Compte>) (q.getResultList());
		return new HashSet<Compte>(res);
	}

	public void createCompte(String name, String password, float solde) {
		Compte c = new Compte(name, password, solde);
		em.persist(c);
	}

	public Compte findCompte(int id) {
		return em.find(Compte.class, id);

	}

	public List<Compte> findCompteByName(String nom) {
		Query q = em.createQuery("Select f From Compte f where f.name= nom", Compte.class);
		List<Compte> res = (List<Compte>) (q.getResultList());
		return res;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void debite(float somme) throws SoldeNegatifException, UserNotFoundException {

		float solde = solde();
		if (solde - somme <= 0) {
			throw new SoldeNegatifException();
		} else {
			Compte compte;
			Query q = em.createNamedQuery("findCompteById");
			q.setParameter("cid", user_id);

			List<Compte> res = (List<Compte>) (q.getResultList());
			if (res.size() == 0) {

				throw new UserNotFoundException();
			} else {
				compte = res.get(0);
				compte.setSolde(solde - somme);
				em.merge(compte);
			}
		}
	}

	public String getName() throws UserNotFoundException {
		String nom;
		Query q = em.createNamedQuery("findCompteById");
		q.setParameter("cid", user_id);
		List<Compte> res = (List<Compte>) (q.getResultList());
		if (res.size() == 0) {
			throw new UserNotFoundException();
		} else {
			nom = res.get(0).getName();
		}

		return nom;
	}

	public void init(String name, String passwd) throws UserNotFoundException {

		Query q = em.createNamedQuery("findCompteByName");
		q.setParameter("cname", name);
		List<Compte> res = (List<Compte>) q.getResultList();

		if (res == null || res.size() == 0) {
			throw new UserNotFoundException();
		} else {
			if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)) {
				user_id = res.get(0).getId();
			} else {
				throw new UserNotFoundException();
			}
		}
	}

}
