package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.ajee.metier.Personne;

public class Dao {
	public final static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public final static String DB_URL= "jdbc:mysql://localhost/dbetga";
	
	public String user = "";
	public String pass = "";
	
	public void insertTable() {
		Connection connexion = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			ArrayList<Personne> listPersonne = new ArrayList<Personne>();
			Personne personne = new Personne();
			for (int i = 0; i < listPersonne.size(); i++) {
				String sql = "INSERT INTO AJEE "
						+" (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, "
						+ "ville, telFixe, telPort, fax, dateNaissance, lieuNaissance, numSecu, "
						+ "nationalite, situation, fonction, position, cadre, coeff, salaire, "
						+ "visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, "
						+ "ticketResto, dateModification, bloque, raisonBlocage, listeDoc) "
						+ "VALUES ("+personne.getNom()+","+personne.getPrenom()+", "
						+personne.getSexe()+","+personne.getIdentifiant()+","+personne.getMdp()
						+","+personne.getEmail()+","+personne.getAdresse()+","+personne.getCp()
						+","+personne.getVille()+","+personne.getTelFixe()+","+personne.getFax()+","
						+personne.getDateNaissance()+","+personne.getLieuNaissance()+","
						+personne.getNumSecu()+","+personne.getNationalite()+","
						+personne.getSituation()+","+personne.getFonction()+", "+personne.getPosition()
						+","+personne.isCadre()+","+personne.getCoeff()+","+personne.getSalaire()+","
						+personne.getVisiteMedicale()+","+personne.getMontantTransport()+","
						+personne.isVoiture()+","+personne.getNbCV()+","+personne.getNbKm()+","
						+personne.isMutuelle()+","+personne.isTicketResto()+","+personne.getDateCreation()
						+","+personne.getDateModification()+","+personne.isBloque()+","
						+personne.getRaisonBlocage()+","+personne.getListeDoc()+");";
				statement.executeUpdate(sql);
			}
			System.out.println("Insert terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "UPDATE AJEE "+ "set prenom = 'ambr' " + "where prenom = 'ambr1';";
				int resultat = stat.executeUpdate(sql);
				if (resultat >= 0) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from test.meuble "+ "where nom = 'SALUTCESTCOOL';";
				int resultat = stat.executeUpdate(sql);
				if (resultat >= 0) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			System.out.println("FIN");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
