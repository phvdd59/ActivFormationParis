package com.formation.bean;

//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Integer id;
	
	@Column
	private String nom;
	
	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "description", column = @Column(name="desc")),
//		@AttributeOverride(name = "provenance", column = @Column(name="prov")),	
//	})
	@Column
	private ProduitInfo info;
	
	@OneToOne
	@MapsId
	private Categorie categorie;
	
	public Produit(){
	}
	
	public Produit(String nom, ProduitInfo info, Categorie categorie) {
		super();
		this.nom = nom;
		this.info = info;
		this.categorie = categorie;
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

	public ProduitInfo getInfo() {
		return info;
	}

	public void setInfo(ProduitInfo info) {
		this.info = info;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", info=" + info + ", categorie=" + categorie + "]";
	}

}
