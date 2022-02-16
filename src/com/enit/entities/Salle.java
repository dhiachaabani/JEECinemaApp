package com.enit.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Salle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String nom;

	public Salle(String nom, String adress, Integer capacite) {
		super();
		this.nom = nom;
		this.adress = adress;
		this.capacite = capacite;
	}

	@OneToOne(mappedBy = "salle")
	private SalleProg salleProg;

	private String adress;
	private Integer capacite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public SalleProg getSalleProg() {
		return salleProg;
	}

	public void setSalleProg(SalleProg salleProg) {
		this.salleProg = salleProg;
	}

}
