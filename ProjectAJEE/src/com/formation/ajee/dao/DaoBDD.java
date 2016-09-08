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
	public final static String DB_URL = "jdbc:mysql://www.psyeval.fr/";

	public String user;
	public String pass;
	public Perso[] tabPerso;

	public void insertPersBackup(Perso[] tabPerso) {
		Connection connexion = null;
		Statement statement = null;
		

			DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";
			String user = "ajee";
			String pass = "erreuretga";
		
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();

			for (int i = 0; i < tabPerso.length; i++) {

				String sql = "insert into backup " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, ville, telFixe, telPort, fax," + " dateNaissance, lieuNaissance, numSecu, " + "nationalite, situation, fonction, positionEntreprise, cadre, coeff,"
						+ " salaire, visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, " + "ticketResto, dateCreation," + " dateModification, bloque, raisonBlocage, listeDoc) values ('" + tabPerso[i].getNom() + "','" + tabPerso[i].getPrenom() + "','" + tabPerso[i].getSexe() + "','"
						+ tabPerso[i].getIdentifiant() + "','" + tabPerso[i].getMdp() + "','" + tabPerso[i].getEmail() + "','" + tabPerso[i].getAdresse() + "','" + tabPerso[i].getCp() + "','" + tabPerso[i].getVille() + "','" + tabPerso[i].getTelFixe() + "','" + tabPerso[i].getTelPort() + "','"
						+ tabPerso[i].getFax() + "','" + tabPerso[i].getDateNaissanceStringDAO() + "','" + tabPerso[i].getLieuNaissance() + "','" + tabPerso[i].getNumSecu() + "','" + tabPerso[i].getNationalite() + "','" + tabPerso[i].getSituation() + "','" + tabPerso[i].getFonction() + "','"
						+ tabPerso[i].getPositionEntreprise() + "'," + tabPerso[i].isCadre() + ",'" + tabPerso[i].getCoeff() + "','" + tabPerso[i].getSalaire() + "','" + tabPerso[i].getVisiteMedicaleStringDAO() + "','" + tabPerso[i].getMontantTransport() + "'," + tabPerso[i].isVoiture() + ",'"
						+ tabPerso[i].getNbCV() + "','" + tabPerso[i].getNbKm() + "'," + tabPerso[i].isMutuelle() + "," + tabPerso[i].isTicketResto() + ",'" + tabPerso[i].getDateCreationString() + "','" + tabPerso[i].getDateModificationString() + "'," + tabPerso[i].isBloque() + ",'"
						+ tabPerso[i].getRaisonBlocage() + "','" + tabPerso[i].getListeDoc() + "');";
				statement.executeUpdate(sql);
			}
			System.out.println("Insert terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertPersBdd(Perso[] tabPerso) {
		Connection connexion = null;
		Statement statement = null;
		

			DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";
			String user = "ajee";
			String pass = "erreuretga";
		
		try {
			Class.forName(JDBC_DRIVER);
			connexion = DriverManager.getConnection(DB_URL, user, pass);
			statement = connexion.createStatement();

			for (int i = 0; i < tabPerso.length; i++) {

				String sql = "insert into bdd " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, ville, telFixe, telPort, fax," + " dateNaissance, lieuNaissance, numSecu, " + "nationalite, situation, fonction, positionEntreprise, cadre, coeff,"
						+ " salaire, visiteMedicale, montantTransport, voiture, nbCV, nbKm, mutuelle, " + "ticketResto, dateCreation," + " dateModification, bloque, raisonBlocage, listeDoc) values ('" + tabPerso[i].getNom() + "','" + tabPerso[i].getPrenom() + "','" + tabPerso[i].getSexe() + "','"
						+ tabPerso[i].getIdentifiant() + "','" + tabPerso[i].getMdp() + "','" + tabPerso[i].getEmail() + "','" + tabPerso[i].getAdresse() + "','" + tabPerso[i].getCp() + "','" + tabPerso[i].getVille() + "','" + tabPerso[i].getTelFixe() + "','" + tabPerso[i].getTelPort() + "','"
						+ tabPerso[i].getFax() + "','" + tabPerso[i].getDateNaissanceStringDAO() + "','" + tabPerso[i].getLieuNaissance() + "','" + tabPerso[i].getNumSecu() + "','" + tabPerso[i].getNationalite() + "','" + tabPerso[i].getSituation() + "','" + tabPerso[i].getFonction() + "','"
						+ tabPerso[i].getPositionEntreprise() + "'," + tabPerso[i].isCadre() + ",'" + tabPerso[i].getCoeff() + "','" + tabPerso[i].getSalaire() + "','" + tabPerso[i].getVisiteMedicaleStringDAO() + "','" + tabPerso[i].getMontantTransport() + "'," + tabPerso[i].isVoiture() + ",'"
						+ tabPerso[i].getNbCV() + "','" + tabPerso[i].getNbKm() + "'," + tabPerso[i].isMutuelle() + "," + tabPerso[i].isTicketResto() + ",'" + tabPerso[i].getDateCreationString() + "','" + tabPerso[i].getDateModificationString() + "'," + tabPerso[i].isBloque() + ",'"
						+ tabPerso[i].getRaisonBlocage() + "','" + tabPerso[i].getListeDoc() + "');";
				statement.executeUpdate(sql);
			}
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
		
		DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";
		String user = "ajee";
		String pass = "erreuretga";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from ajee.bdd;";
			int resultat = stat.executeUpdate(sql);
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
		
		DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";
		String user = "ajee";
		String pass = "erreuretga";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement();
			String sql = "DELETE from ajee.backup;";
			int resultat = stat.executeUpdate(sql);
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Perso[] lectureTable(String projet) {
		Perso[] retour = new Perso[300];
		Connection conne = null;
		Statement stat = null;
		
		if (projet.contains("BAIT")){
			DB_URL = DB_URL+"bait";
			String user = "bait";
			String pass = "erreurthde";
		}else if (projet.contains("AJEE")){
			DB_URL = DB_URL+"ajee";
			String user = "ajee";
			String pass = "erreuretga";
		}else if (projet.contains("JMST")){
			DB_URL = DB_URL+"jmst";
			String user = "jmst";
			String pass = "erreurmade";
		}
		
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "SELECT * FROM personne;";
			ResultSet resultat = stat.executeQuery(sql);
			int i =0;
			
			while (resultat.next()) {
				int sIdPersonne = resultat.getInt("idPersonne");
				String sNom = resultat.getString("nom");
				String sPrenom = resultat.getString("prenom");
				String sIdentifiant = resultat.getString("identifiant");
				String sMdp = resultat.getString("mdp");
				String sSexe = resultat.getString("sexe");
				int iSexe = 0;
				if (sSexe.contains("0")) {
					iSexe = 0;
				} else {
					iSexe = 1;
				}

				String sEmail = resultat.getString("email");
				String sAdresse = resultat.getString("adresse");
				String sCp = resultat.getString("cp");
				String sVille = resultat.getString("ville");
				String sTelFixe = resultat.getString("telFixe");
				String sTelPort = resultat.getString("telPort");
				String sFax = resultat.getString("fax");
				Date sDateNaissance = resultat.getDate("dateNaissance");
				String sLieuNaissance = resultat.getString("lieuNaissance");
				String sNumSecu = resultat.getString("numSecu");
				String sNationalite = resultat.getString("nationalite");
				String sSituation = resultat.getString("situation");

				String sFonction = resultat.getString("fonction");
				String sPositionEntreprise = resultat.getString("positionEntreprise");
				boolean sCadre = resultat.getBoolean("cadre");
				String sCoeff = resultat.getString("coeff");
				String sSalaire = resultat.getString("salaire");
				Date sVisiteMedicale = resultat.getDate("visiteMedicale");
				String sMontantTransport = resultat.getString("montantTransport");
				boolean sVoiture = resultat.getBoolean("voiture");
				int sNbCV = resultat.getInt("nbCV");
				String sNbKm = resultat.getString("nbKm");
				boolean sMutuelle = resultat.getBoolean("mutuelle");
				boolean sTicketResto = resultat.getBoolean("ticketResto");
				Date sDateCreation = resultat.getDate("dateCreation");
				Date sDateModification = resultat.getDate("dateModification");
				boolean sBloque = resultat.getBoolean("bloque");
				String sRaisonBlocage = resultat.getString("raisonBlocage");
				//String sListeDoc= resultat.getString("listeDoc");

				Personne pers = new Personne(sIdPersonne, sNom, sPrenom, sIdentifiant, sMdp, iSexe, sEmail, sAdresse, sCp, sVille, sTelFixe, sTelPort, sFax, sDateNaissance, sLieuNaissance, sNumSecu, sNationalite, sSituation, sFonction, sPositionEntreprise, sCadre, sCoeff, sSalaire, sVisiteMedicale,
						sMontantTransport, sVoiture, sNbCV, sNbKm, sMutuelle, sTicketResto, sDateCreation, sDateModification, sBloque, sRaisonBlocage);
				retour[i]=pers;
				i++;
			}
			;

			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return retour;

	}

}
