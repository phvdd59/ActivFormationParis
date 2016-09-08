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
import com.formation.beans.Perso;

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

			String sql = "insert into personne " + " (nom, prenom, sexe, identifiant, mdp, email, adresse, cp, ville, telFixe, telPort, fax,"
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
			String sql = "DELETE from ajee.personne where idPersonne > 1;";
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
			String sql = "DELETE from ajee.backup where ;";
			stat.executeUpdate(sql);
			System.out.println("Delete terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Personne> lectureTableBackUp() {
		ArrayList<Personne>retour=new ArrayList<Personne>();
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "SELECT * FROM backup;";
			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				int sIdPersonne = resultat.getInt("idPersonne");
				String sNom = resultat.getString("nom");
				String sPrenom  = resultat.getString("prenom");
				String sIdentifiant = resultat.getString("identifiant");
				String sMdp = resultat.getString("mdp");
				String sSexe = resultat.getString("sexe");
				int iSexe=0;
				if(sSexe.contains("0")){
					iSexe=0;
				}else{
					iSexe=1;
				}
				
				String sEmail= resultat.getString("email");
				String sAdresse = resultat.getString("adresse");
				String sCp =resultat.getString("cp");
				String sVille = resultat.getString("ville");
				String sTelFixe = resultat.getString("telFixe");
				String sTelPort = resultat.getString("telPort");
				String sFax = resultat.getString("fax");
				Date sDateNaissance =resultat.getDate("dateNaissance");
				String sLieuNaissance =resultat.getString("lieuNaissance");
				String sNumSecu = resultat.getString("numSecu");
				String sNationalite = resultat.getString("nationalite");
				String sSituation = resultat.getString("situation");
				
				String sFonction = resultat.getString("fonction");
				String sPositionEntreprise = resultat.getString("positionEntreprise");
				boolean sCadre = resultat.getBoolean("cadre");
				String sCoeff = resultat.getString("coeff");
				String sSalaire = resultat.getString("salaire");
				Date sVisiteMedicale= resultat.getDate("visiteMedicale");
				String sMontantTransport=resultat.getString("montantTransport");
				boolean sVoiture = resultat.getBoolean("voiture");
				int sNbCV = resultat.getInt("nbCV");
				String sNbKm = resultat.getString("nbKm");
				boolean sMutuelle=resultat.getBoolean("mutuelle");
				boolean sTicketResto= resultat.getBoolean("ticketResto");
				Date sDateCreation= resultat.getDate("dateCreation");
				Date sDateModification= resultat.getDate("dateModification");
				boolean sBloque = resultat.getBoolean("bloque");
				String sRaisonBlocage = resultat.getString("raisonBlocage");
				//String sListeDoc= resultat.getString("listeDoc");
			
				
				Personne pers=new Personne(sIdPersonne,sNom,sPrenom,sIdentifiant,sMdp,iSexe,sEmail,sAdresse,sCp,sVille,sTelFixe,sTelPort,sFax,sDateNaissance,sLieuNaissance,sNumSecu,sNationalite,sSituation,sFonction,sPositionEntreprise,sCadre,sCoeff,sSalaire,sVisiteMedicale,sMontantTransport,sVoiture,sNbCV,sNbKm,sMutuelle,sTicketResto,sDateCreation,sDateModification,sBloque,sRaisonBlocage);
				retour.add(pers);
			}
			;

			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		
		return retour;
		
	}
	
	public ArrayList<Perso> lectureTableBackUpPerso() {
		ArrayList<Perso>retour=new ArrayList<Perso>();
		Connection conne = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conne = DriverManager.getConnection(DB_URL, user, pass);
			stat = conne.createStatement();
			String sql = "SELECT * FROM personne;";
			ResultSet resultat = stat.executeQuery(sql);
			
			
			while (resultat.next()) {
				Perso perso = new Perso();
				 perso.setIdPersonne(resultat.getInt("idPersonne"));
				perso.setNom(resultat.getString("nom"));
				perso.setPrenom(resultat.getString("prenom"));
				perso.setIdentifiant(resultat.getString("identifiant"));
				perso.setMdp(resultat.getString("mdp"));
				String sSexe = resultat.getString("sexe");
				int iSexe=0;
				if(sSexe.contains("0")){
					iSexe=0;
				}else{
					iSexe=1;
				}
				perso.setSexe(iSexe);
				perso.setEmail(resultat.getString("email"));
				perso.setAdresse(resultat.getString("adresse"));
				perso.setCp(resultat.getString("cp"));
				perso.setVille(resultat.getString("ville"));
				perso.setTelFixe(resultat.getString("telFixe"));
				perso.setTelPort(resultat.getString("telPort"));
				perso.setFax(resultat.getString("fax"));
				perso.setDateNaissance(resultat.getDate("dateNaissance"));
				perso.setLieuNaissance(resultat.getString("lieuNaissance"));
				perso.setNumSecu(resultat.getString("numSecu"));
				perso.setNationalite(resultat.getString("nationalite"));
				perso.setSituation(resultat.getString("situation"));
				
				perso.setFonction(resultat.getString("fonction"));
				perso.setPos(resultat.getString("positionEntreprise"));
				perso.setCadre(resultat.getBoolean("cadre"));
				perso.setCoeff(resultat.getString("coeff"));
				perso.setSalaire(resultat.getString("salaire"));
				perso.setVisiteMedicale(resultat.getDate("visiteMedicale"));
				perso.setMontantTransport(resultat.getString("montantTransport"));
				perso.setVoiture(resultat.getBoolean("voiture"));
				perso.setNbCV(resultat.getInt("nbCV"));
				perso.setNbKm(resultat.getString("nbKm"));
				perso.setMutuelle(resultat.getBoolean("mutuelle"));
				perso.setTicketResto(resultat.getBoolean("ticketResto"));
				perso.setDateCreation(resultat.getDate("dateCreation"));
				perso.setDateModification(resultat.getDate("dateModification"));
				perso.setBloque(resultat.getBoolean("bloque"));
				perso.setRaisonBlocage(resultat.getString("raisonBlocage"));
				
					retour.add(perso);
			}
			;

			System.out.println("fin");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		
		return retour;
		
	}

}
