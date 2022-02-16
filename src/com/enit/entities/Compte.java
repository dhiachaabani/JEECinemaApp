package com.enit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.GenerationType;

@Entity
@Table(name = "COMPTES")
@NamedQueries({ @NamedQuery(name = "findAllComptes", query = "SELECT c FROM Compte c"),
		@NamedQuery(name = "findCompteByName", query = "SELECT c FROM Compte c WHERE c.name = :cname"),
		@NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id = :cid") })
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// le nom du propri�taire du compte bancaire
	private String name;
	// Mot de passe du propri�taire du compte
	private String password;
	private float solde;

	public Compte(String name, String password, float solde) {
		super();
		this.name = name;
		this.password = password;
		this.solde = solde;
	}

	public Compte() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Compte[id=").append(getId()).append(", name=").append(getName()).append("]");
		return sb.toString();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}