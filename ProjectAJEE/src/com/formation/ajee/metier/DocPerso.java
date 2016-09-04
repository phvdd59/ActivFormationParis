package com.formation.ajee.metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.formation.ajee.dao.DaoDocument;

public class DocPerso {

	private int idDoc;
	private int idPersonne;
	private String nomDocUtil;
	private String type;
	private String nomDocFile;
	private long time;
	private String commentaire;
	private Personne personne;

	public DocPerso() {
	}

	public DocPerso(String nomDocUtil, String commentaire) {
		super();
		this.idPersonne = personne.getIdPersonne();
		this.nomDocUtil = nomDocUtil.substring(0, nomDocUtil.lastIndexOf(".") - 1);
		this.type = nomDocUtil.substring(nomDocUtil.lastIndexOf(".") + 1);
		this.time = (long) System.currentTimeMillis();
		this.nomDocFile = Long.toString(time);
		this.commentaire = commentaire;
		DaoDocument daoD = new DaoDocument();
		daoD.insertTable(this);
	}

	public DocPerso(int idPersonne, String nomDocUtil, String type, String nomDocFile, long time, String commentaire) {
		super();
		this.idPersonne = idPersonne;
		this.nomDocUtil = nomDocUtil;
		this.type = type;
		this.nomDocFile = nomDocFile;
		this.time = time;
		this.commentaire = commentaire;
		DaoDocument daoD = new DaoDocument();
		daoD.insertTable(this);
	}

	public void uploadFile() {
		File fileIn = new File("nomDocUtil");
		File fileOut = new File("nomDocFile");
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		int readUnByte;
		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxDentree.read();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				fluxDentree.close();
				fluxDeSortie.close();
			} catch (IOException e) {
			}
		}
	}
	
	public void TelechargerFile() {
		File fileIn = new File("nomDocFile");
		File fileOut = new File("RepertoireUser");
		FileInputStream fluxDentree = null;
		FileOutputStream fluxDeSortie = null;
		int readUnByte;
		try {
			fluxDentree = new FileInputStream(fileIn);
			fluxDeSortie = new FileOutputStream(fileOut);
			readUnByte = fluxDentree.read();
			while (readUnByte != -1) {
				fluxDeSortie.write(readUnByte);
				readUnByte = fluxDentree.read();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				fluxDentree.close();
				fluxDeSortie.close();
			} catch (IOException e) {
			}
		}
	}
	public int getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}
