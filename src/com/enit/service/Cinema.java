package com.enit.service;

import java.util.Date;
import java.util.List;

import java.util.Set;

import javax.ejb.Local;
import com.enit.entities.Salle;

import com.enit.entities.Film;
import com.enit.entities.SalleProg;
import com.enit.entities.Seance;
import com.enit.MyExceptions.*;

@Local
public interface Cinema {
	public Set<Film> list();

	public Set<Salle> listSalle();

	// Trouver les films correspondants au pattern donné en entrée.
	public Set<Film> findByPattern(String pattern);

	// Trouver un film à partir d'un id.
	public Film findFilm(int id);

	public Salle findSalle(int id);

	public Seance findSeance(int id);

	// Réserver une séance pour un utilisateur.
	public void reserve(Seance seance, Utilisateur u)
			throws PlusDePlaceException, SoldeInsuffisantException, UserNotFoundException, SoldeNegatifException;

	public Set<SalleProg> getAllSalleProg();

	public Film createFilm(String name);

	public void AjouterSalle(String nom, String adress, Integer capacite);

	public void AjouterSalleProg(Integer idfilm, Integer idsalle);

	public void AjouterSeance(String horaire, Float tarif, Integer idSalleprog);

	public Set<Seance> getAllSeance();

	public void update(Film f);

	public float getTarif();
}