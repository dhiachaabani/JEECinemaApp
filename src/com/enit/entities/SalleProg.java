package com.enit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class SalleProg implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public SalleProg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToOne
	private Salle salle;

	@ManyToOne
	private Film film;
	@OneToMany(mappedBy = "salleProg")

	private List<Seance> seance;

	public List<Seance> getSeance() {
		return seance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public Salle getSalle() {
		return salle;
	}

	public SalleProg(Salle salle, Film f) {
		super();
		this.film = f;
		this.salle = salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
