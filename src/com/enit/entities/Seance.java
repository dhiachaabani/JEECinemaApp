package com.enit.entities;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Seance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String horaire;
	public Integer places;

	private Float tarif;
	@ManyToOne
	private SalleProg salleProg;

	public Seance(String horaire, Float tarif, SalleProg salleProg, Integer place) {
		super();
		this.horaire = horaire;
		this.tarif = tarif;
		this.salleProg = salleProg;
		this.places = place;

	}

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalleProg getSalleProg() {
		return salleProg;
	}

	public void setSalleProg(SalleProg salleProg) {
		this.salleProg = salleProg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer place) {
		this.places = place;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}
}
