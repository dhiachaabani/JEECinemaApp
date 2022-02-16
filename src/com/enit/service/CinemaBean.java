package com.enit.service;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.enit.entities.Film;
import com.enit.entities.Salle;
import com.enit.entities.SalleProg;
import com.enit.entities.Seance;
import com.enit.MyExceptions.*;

@Stateless
public class CinemaBean implements Cinema {
	@PersistenceContext
	private EntityManager em = null;

	public CinemaBean() {
		super();
	}

	public Set<Film> list() {
		Query q = em.createQuery("Select f From Film f", Film.class);
		List<Film> res = (List<Film>) (q.getResultList());
		return new HashSet<Film>(res);
	}

	public Set<Salle> listSalle() {
		Query q = em.createQuery("Select f From Salle f", Salle.class);
		List<Salle> res = (List<Salle>) (q.getResultList());
		return new HashSet<Salle>(res);
	}

	public Set<Film> findByPattern(String pattern) {
		Query q = em.createQuery("Select f From Film f where f.nom= pattern", Film.class);
		List<Film> res = (List<Film>) (q.getResultList());
		return new HashSet<Film>(res);
	}

	public Seance findSeance(int id) {
		return em.find(Seance.class, id);

	}

	public void AjouterSalle(String nom, String adress, Integer capacite) {
		Salle s = new Salle(nom, adress, capacite);
		em.persist(s);
	}

	public void AjouterSalleProg(Integer idfilm, Integer idsalle) {

		Film f = findFilm(idfilm);
		Salle s = findSalle(idsalle);

		SalleProg sp = new SalleProg(s, f);
		em.persist(sp);
	}

	public void AjouterSeance(String horaire, Float tarif, Integer idSalleprog) {
		SalleProg sallepr = findSalleProg(idSalleprog);
		Integer place = 0;
		Seance s = new Seance(horaire, tarif, sallepr, place);
		em.persist(s);

	}

	public Set<Seance> getAllSeance() {

		Query q = em.createQuery("Select s From Seance s", Seance.class);
		List<Seance> res = (List<Seance>) (q.getResultList());
		return new HashSet<Seance>(res);
	}

	public Film findFilm(int id) {

		return em.find(Film.class, id);
	}

	public Salle findSalle(int id) {

		return em.find(Salle.class, id);
	}

	public SalleProg findSalleProg(int id) {

		return em.find(SalleProg.class, id);
	}

	public Film createFilm(String name) {
		Film film = new Film(name);
		em.persist(film);
		return film;
	}

	public void update(Film f) {
		Film film = findFilm(f.getId());
		film = f;
		em.merge(film);

	}

	public Set<SalleProg> getAllSalleProg() {
		Query q = em.createQuery("Select sp From SalleProg sp", SalleProg.class);
		List<SalleProg> res = (List<SalleProg>) (q.getResultList());
		return new HashSet<SalleProg>(res);
	}

	public float getTarif() {
		Float tarifTot = (float) 0;
		Query q = em.createQuery("Select s From Seance s", Seance.class);
		List<Seance> res = (ArrayList<Seance>) (q.getResultList());
		for (int i = 0; i < res.size(); i++) {

			// le tarif d'une sule seance est la somme
			// de nombre de places de chaque seance * tarif
			// le tarif total est la somme de tous les tarifs

			tarifTot += res.get(i).getTarif() * res.get(i).getPlaces();
		}
		return tarifTot;
	}

	public void reserve(Seance seance, Utilisateur u)
			throws PlusDePlaceException, UserNotFoundException, SoldeNegatifException {
		Integer capaciteMax = seance.getSalleProg().getSalle().getCapacite();

		if (seance.getPlaces() > capaciteMax) {
			throw new PlusDePlaceException();
		} else {
			try {
				u.debite(seance.getTarif());
				seance.places+=1;

			} catch (UserNotFoundException e) {
				System.out.println("user not found exception");
			} catch (SoldeNegatifException e) {
				System.out.println("Solde negatif exception");

			}

		}
	}
}
