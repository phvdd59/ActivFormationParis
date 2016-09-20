package com.formation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer idCat;
	
	@Column
	private String nom;
	
	@Column
	private String ref;

	public Categorie() {
		super();
	}

	public Categorie(String nom, String ref) {
		super();
		this.nom = nom;
		this.ref = ref;
	}

	public Integer getIdCat() {
		return idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nom=" + nom + ", ref=" + ref + "]";
	}
	
}
