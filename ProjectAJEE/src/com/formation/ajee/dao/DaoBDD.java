package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.formation.ajee.metier.ListeDoc;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;

public class DaoBDD {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";

	public String user= "ajee";
	public String pass= "erreuretga";
	public Personne personne;

	public void insertPersBackup(Personne personne) {
		Connection connexion = null;
		Statement statement = null;	
		
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();

			String sql = "insert into backup " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, ville, telFixe, telPort, fax,"
					+ " dateNaissance, lieuNaissance, numSecu, " + "nationalite, situation, fonction, positionEntreprise, cadre, coeff,"
					+ " salaire, visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, " + "ticketResto, dateCreation,"
					+ " dateModification, bloque, raisonBlocage, listeDoc) values ('" 
					+ personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getSexe() + "','" 
					+ personne.getIdentifiant() + "','"	+ personne.getMdp() + "','" + personne.getEmail() + "','"
					+ personne.getAdresse() + "','" + personne.getCp() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "','" 
					+ personne.getTelPort() + "','" + personne.getFax() + "','" +personne.getDateNaissanceStringDAO() + "','" 
					+ personne.getLieuNaissance() + "','" + personne.getNumSecu() + "','" + personne.getNationalite() + "','" 
					+ personne.getSituation() + "','" + personne.getFonction() + "','" + personne.getPositionEntreprise() + "'," 
					+ personne.isCadre() + ",'" + personne.getCoeff() + "','" + personne.getSalaire() + "','" 
					+ personne.getVisiteMedicaleStringDAO() +"','" + personne.getMontantTransport() + "'," + personne.isVoiture() + ",'" 
					+ personne.getNbCV() + "','" + personne.getNbKm() + "'," + personne.isMutuelle() + "," + personne.isTicketResto() + ",'" 
					+ personne.getDateCreationString() + "','" + personne.getDateModificationString() + "'," + personne.isBloque() + ",'" 
					+ personne.getRaisonBlocage() + "','" + personne.getListeDoc() + "');";
			statement.executeUpdate(sql);
			
			System.out.println("Insert terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertPersBdd(Personne personne) {
		Connection connexion = null;
		Statement statement = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();

			String sql = "insert into bdd " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, ville, telFixe, telPort, fax,"
					+ " dateNaissance, lieuNaissance, numSecu, " + "nationalite, situation, fonction, positionEntreprise, cadre, coeff,"
					+ " salaire, visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, " + "ticketResto, dateCreation,"
					+ " dateModification, bloque, raisonBlocage, listeDoc) values ('" 
					+ personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getSexe() + "','" 
					+ personne.getIdentifiant() + "','"	+ personne.getMdp() + "','" + personne.getEmail() + "','"
					+ personne.getAdresse() + "','" + personne.getCp() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "','" 
					+ personne.getTelPort() + "','" + personne.getFax() + "','" +personne.getDateNaissanceStringDAO() + "','" 
					+ personne.getLieuNaissance() + "','" + personne.getNumSecu() + "','" + personne.getNationalite() + "','" 
					+ personne.getSituation() + "','" + personne.getFonction() + "','" + personne.getPositionEntreprise() + "'," 
					+ personne.isCadre() + ",'" + personne.getCoeff() + "','" + personne.getSalaire() + "','" 
					+ personne.getVisiteMedicaleStringDAO() +"','" + personne.getMontantTransport() + "'," + personne.isVoiture() + ",'" 
					+ personne.getNbCV() + "','" + personne.getNbKm() + "'," + personne.isMutuelle() + "," + personne.isTicketResto() + ",'" 
					+ personne.getDateCreationString() + "','" + personne.getDateModificationString() + "'," + personne.isBloque() + ",'" 
					+ personne.getRaisonBlocage() + "','" + personne.getListeDoc() + "');";
			statement.executeUpdate(sql);
			
			System.out.println("Insert terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTableBdd() {
		Connection conn = null;
		Statement stat = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from ajee.bdd;";
			stat.executeUpdate(sql);
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTableBackUp() {
		Connection conn = null;
		Statement stat = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from ajee.backup;";
			stat.executeUpdate(sql);
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
