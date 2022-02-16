package com.enit.service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.enit.MyExceptions.*;
import com.enit.entities.Compte;
import com.enit.entities.Film;
import com.enit.entities.Salle;
import com.enit.entities.Seance;

@Local
public interface Utilisateur {
	// Initialiser le bean compte bancaire utilisateur (authentification)
	public void init(String name, String passwd) throws UserNotFoundException;

	public String getName() throws UserNotFoundException;

	public Compte findCompte(int id);

	public List<Compte> findCompteByName(String nom);

	public void setUser_id(int user_id);

	public float solde() throws SoldeNegatifException, UserNotFoundException;

// Débiter le compte de l'utilisateur 
	public void debite(float f) throws SoldeNegatifException, UserNotFoundException;

	public Set<Compte> getAllCompte();

	public void createCompte(String name, String paswword, float solde);

}
