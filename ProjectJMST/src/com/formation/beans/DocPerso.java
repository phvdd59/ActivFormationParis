package com.formation.beans;

public class DocPerso {
	
	private int idDoc;
	private String nomDocUtil;
	private String type;
	private String nomDocFile;
	private long time;
	private String commentaire;
	
	
	
	public DocPerso() {
		super(); //initialiser les valeurs
	}
	public int getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}
	public String getNomDocUtil() {
		return nomDocUtil;
	}
	public void setNomDocUtil(String nomDocUtil) {
		this.nomDocUtil = nomDocUtil;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNomDocFile() {
		return nomDocFile;
	}
	public void setNomDocFile(String nomDocFile) {
		this.nomDocFile = nomDocFile;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	
}
