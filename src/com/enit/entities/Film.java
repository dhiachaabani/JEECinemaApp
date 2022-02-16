package com.enit.entities;

import java.io.Serializable;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Film implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	
	private Integer id;

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String nom;
	@OneToMany(mappedBy="film") 
	private List <SalleProg> salleProg;
	public Film( String nom) {
		super();
		this.nom = nom;
	}

	public List <SalleProg> getSalleProg(){
		return salleProg;
	}

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



}
