package com.formation.ajee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formation.ajee.metier.Personne;

public class DaoPersonne {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";

	public String user = "ajee";
	public String pass = "erreuretga";
	public ArrayList<Personne> listPersonne;
	public Personne personne;

	public void insertTable(Personne personne) {
		Connection connexion = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();
			
				String sql = "insert into personne " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, " 
						+ "ville, telFixe, telPort, fax, dateNaissance, lieuNaissance, numSecu, " + "nationalite, situation, fonction, positionEntreprise, cadre, coeff, salaire, "
						+ "visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, " + "ticketResto, dateCreation, dateModification, bloque, raisonBlocage, listeDoc) "
						+ "values ('" + personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getSexe() + 
						"','" + personne.getIdentifiant() + "','"
						+ personne.getMdp() + "','" + personne.getEmail() + "','" + personne.getAdresse() + "','" + personne.getCp() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "','" + personne.getTelPort() + "','" + personne.getFax() + "', curdate()" //personne.getDateNaissance() 
						+ ",'" + personne.getLieuNaissance() + "','"
						+ personne.getNumSecu() + "','" + personne.getNationalite() + "','" + null + //personne.getSituation() + 
						"','" + personne.getFonction() + "','" + personne.getPositionEntreprise() + "'," + personne.isCadre() + ",'" + personne.getCoeff() + "','" + personne.getSalaire() + "', curdate() "+ // personne.getVisiteMedicale() +
						",'" + personne.getMontantTransport() + "'," + personne.isVoiture() + ",'" + personne.getNbCV() + "','" + personne.getNbKm() + "'," + personne.isMutuelle() + "," + personne.isTicketResto() + ", curdate()" //personne.getDateCreation() 
						+ ",curdate()" +// personne.getDateModification() +
						"," + personne.isBloque() + ",'" + personne.getRaisonBlocage() + "','" + personne.getListeDoc() + "');";
				statement.executeUpdate(sql);
			
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
			String sql = "update personne " + "set nom = " + personne.getNom() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set prenom = " + personne.getPrenom() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set sexe = " + personne.getSexe() + " "
					+ "where idPersonne = " + personne.getIdPersonne() + "','" + "set identifiant = " + personne.getIdentifiant() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set mdp = " + personne.getMdp() + " " + "where idPersonne = " + personne.getIdPersonne() + "','"
					+ "set email = " + personne.getEmail() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set adresse = " + personne.getAdresse() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set cp = " + personne.getCp() + " " + "where idPersonne = "
					+ personne.getIdPersonne() + "','" + "set ville = " + personne.getVille() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set telFixe = " + personne.getTelFixe() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set telPort = "
					+ personne.getTelPort() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set fax = " + personne.getFax() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set dateNaissance = " + personne.getDateNaissance() + " " + "where idPersonne = "
					+ personne.getIdPersonne() + "','" + "set lieuNaissance = " + personne.getLieuNaissance() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set numSecu = " + personne.getNumSecu() + " " + "where idPersonne = " + personne.getIdPersonne() + "','"
					+ "set nationalité = " + personne.getNationalite() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set situation = " + personne.getSituation() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set fonction = " + personne.getFonction() + " "
					+ "where idPersonne = " + personne.getIdPersonne() + "','" + "set position = " + personne.getPositionEntreprise() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set cadre = " + personne.isCadre() + " " + "where idPersonne = " + personne.getIdPersonne() + "','"
					+ "set coeff = " + personne.getCoeff() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set salaire = " + personne.getSalaire() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set visiteMedicale = " + personne.getVisiteMedicale() + " "
					+ "where idPersonne = " + personne.getIdPersonne() + "','" + "set montantTransport = " + personne.getMontantTransport() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set voiture = " + personne.isVoiture() + " " + "where idPersonne = "
					+ personne.getIdPersonne() + "','" + "set nbCV = " + personne.getNbCV() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set nbKm = " + personne.getNbKm() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set mutuelle = " + personne.isMutuelle()
					+ " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set ticketResto = " + personne.isTicketResto() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set dateModification = " + personne.getDateModification() + " " + "where idPersonne = "
					+ personne.getIdPersonne() + "','" + "set bloque = " + personne.isBloque() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set raisonBlocage = " + personne.getRaisonBlocage() + " " + "where idPersonne = " + personne.getIdPersonne() + "','" + "set listeDoc = "
					+ personne.getListeDoc() + " " + "where idPersonne = " + personne.getIdPersonne() + ";";

			stat.executeUpdate(sql);
			System.out.println("Update terminer");
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
			String sql = "DELETE from ajee.personne " + "where idPersonne = " + personne.getIdPersonne() + ";";
			int resultat = stat.executeUpdate(sql);
			if (resultat >= 0) {
				System.out.println("OK");
			} else {
				System.out.println("NOK");
			}
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
