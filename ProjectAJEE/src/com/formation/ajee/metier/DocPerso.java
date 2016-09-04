package com.formation.ajee.metier;

import com.formation.ajee.dao.DaoDocument;

public class DocPerso {
	
	private int idDoc;
	private String nomDocUtil;
	private String type;
	private String nomDocFile;
	private long time;
	private String commentaire;
	
	public DocPerso() {
	}
	
	public DocPerso(String nomDocUtil, String commentaire) {
		super();
		this.nomDocUtil = nomDocUtil.substring(0, nomDocUtil.lastIndexOf(".")-1);
		this.type = nomDocUtil.substring(nomDocUtil.lastIndexOf(".")+1);
		this.time = (long)System.currentTimeMillis();
		this.nomDocFile = Long.toString(time);
		this.commentaire = commentaire;	
		DaoDocument daoD = new DaoDocument();
		daoD.insertTable(this);
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
