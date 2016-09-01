package com.formation.bait.metier;

import java.sql.Timestamp;

public class DocPerso {
	private int IDPersonne;
	private int IDDocument;

	private String nomDocUtil = new String();
	private String type = new String();
	private String nomDocFile = new String();
	private String time = new String();
	private String commentaire;
	
	public DocPerso(){
		super();
	}
	
	
	public DocPerso(int iDPersonne, int iDDocument) {
		super();
		IDPersonne = iDPersonne;
		IDDocument = iDDocument;
	}


	public int getIDPersonne() {
		return IDPersonne;
	}


	public void setIDPersonne(int iDPersonne) {
		IDPersonne = iDPersonne;
	}


	public int getIDDocument() {
		return IDDocument;
	}


	public void setIDDocument(int iDDocument) {
		IDDocument = iDDocument;
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


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
