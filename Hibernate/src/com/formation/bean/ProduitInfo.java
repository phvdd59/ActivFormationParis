package com.formation.bean;

import javax.persistence.Embeddable;

@Embeddable
public class ProduitInfo {
	
	private String description;
	private String provenance;
	
	public ProduitInfo() {
		super();
	}
	public ProduitInfo(String description, String provenance) {
		super();
		this.description = description;
		this.provenance = provenance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	@Override
	public String toString() {
		return "ProduitInfo [description=" + description + ", provenance=" + provenance + "]";
	}
}
