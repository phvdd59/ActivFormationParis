package com.formation.bait.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.AEADBadTagException;

import com.formation.beba.metier.DocPerso;
import com.formation.beba.metier.ListeDoc;
import com.formation.beba.metier.Personne;

public class AccesBDD {
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost/";

	public String user = "root";
	public String pass = "";

	private int savePersonne(Personne personne) {
		Connection conn = null;
		Statement stat = null;
		int result = 0;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "UPDATE listeUser set identifiant='"+personne.getIdentifiant()+"', mdp='"+personne.getMdp()+ //
					"',       WHERE identifiant='" + Identifiant//
					+ "';";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private int createNewPersonne(String identifiant, String mdp){
		int result 0;
		Personne personne = new Personne(identifiant, mdp);
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			
			String sql = "insert into listeUser (identifiant,mdp,email,nom,prenom,adresse,cp,ville,"+//
			"telFixe,telPort,fax,dateNaissance,lieuNaissance,numSecu,situation,fonction,positionEntreprise,"+//
			"cadre,coeff,salaire,visiteMedicale,montantTransport,voiture,nbCV,nbKm,mutuelle,ticketResto,admin,"+//
			"dateCreation,dateModification,bloque,raisonBlocage) values ('"+ personne.getIdentifiant()+"','"+//
			personne.getMdp()+"','"+personne.getEmail()+"','"+personne.getNom()+"','"+personne.getPrenom()+"','"+//
			personne.getAdresse()+"','"+personne.getcP()+"','"+personne.getVille()+"','"+personne.getTelFixe()+"','"+//
			personne.getTelPort()+"','"+personne.getFax()+"','"+personne.getDateNaissance()+"','"+//
			personne.getLieuNaissance()+"','"+personne.getNumSecu()+"','"+personne.getSituation()+"','"+//
			personne.getFonction()+"','"+personne.getPosition()+"','"+personne.isCadre()+"','"+personne.getCoeff()+"','"+//
			personne.getSalaire()+"','"+personne.getVisiteMedicale()+"','"+personne.getMontantTransport()+"','"+//
			personne.isVoiture()+"','"+personne.getNbCV()+"','"+personne.getNdKm()+"','"+personne.isMutuelle()+"','"+//
			personne.isTicket()+"','"+personne.isAdmin()+"','"+personne.getDateCreation()+"','"+personne.getDateModification()+"','"+//
			personne.isBloque()+"','"+personne.getRaisonBlocage()+"');";
			
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String[] findPersonne(String Identifiant) {
		Connection conn = null;
		Statement stat = null;
		String[] parameters = new String[2];
		parameters[0] = null;
		parameters[1] = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "listeUserActiv";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT IDPersonne,mdp FROM listeUser WHERE identifiant='" + Identifiant//
					+ "';";

			ResultSet resultat = stat.executeQuery(sql);
			resultat.first();
			parameters[0] = resultat.getString("IDPersonne");
			parameters[1] = resultat.getString("mdp");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return parameters;
	}

	private ArrayList<String> findAllUserId() {
		ArrayList<String> listUser = new ArrayList<String>();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT IDPersonne FROM listeUser ;";

			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				String sId = resultat.getString("IDPersonne");
				listUser.add(sId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}

	private Personne getPersonne(String Id) {
		Personne personne = null;
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM listeUser WHERE IDPERSONNE ='" + Id + "';";

			ResultSet resultat = stat.executeQuery(sql);
			resultat.first();

			String sIdentifiant = resultat.getString("identifiant");
			String sMdp = resultat.getString("mdp");
			personne = new Personne(sIdentifiant, sMdp);
			personne.setIdPersonne(resultat.getInt("IDPersonne"));
			personne.setEmail(resultat.getString("email"));
			personne.setNom(resultat.getString("nom"));
			personne.setPrenom(resultat.getString("prenom"));
			personne.setAdresse(resultat.getString("adresse"));
			personne.setcP(resultat.getString("cp"));
			personne.setVille(resultat.getString("ville"));
			personne.setTelFixe(resultat.getString("telFixe"));
			personne.setTelPort(resultat.getString("telPort"));
			personne.setFax(resultat.getString("fax"));
			personne.setDateNaissance(resultat.getString("dateNaissance"));
			personne.setLieuNaissance(resultat.getString("lieuNaissance"));
			personne.setNumSecu(resultat.getString("numSecu"));
			personne.setSituation(resultat.getString("situation"));
			personne.setFonction(resultat.getString("fonction"));
			personne.setPosition(resultat.getString("positionEntreprise"));
			personne.setCadre(resultat.getBoolean("cadre"));
			personne.setCoeff(resultat.getString("coeff"));
			personne.setSalaire(resultat.getString("salaire"));
			personne.setVisiteMedicale(resultat.getString("visiteMedicale"));
			personne.setMontantTransport(resultat.getString("montantTransport"));
			personne.setVoiture(resultat.getBoolean("voiture"));
			personne.setNbCV(resultat.getString("nbCV"));
			personne.setNdKm(resultat.getString("nbKm"));
			personne.setMutuelle(resultat.getBoolean("mutuelle"));
			personne.setTicket(resultat.getBoolean("ticketResto"));
			personne.setAdmin(resultat.getBoolean("admin"));
			personne.setSalaire(resultat.getString("salaire"));
			personne.setVisiteMedicale(resultat.getString("visiteMedicale"));
			personne.setAdmin(resultat.getBoolean("admin"));
			personne.setDateCreation(resultat.getString("dateCreation"));
			personne.setDateModification(resultat.getString("dateModification"));
			personne.setBloque(resultat.getBoolean("bloque"));
			personne.setRaisonBlocage(resultat.getString("raisonBlocage"));

			String sql2 = "SELECT * FROM listeDocs WHERE IDPERSONNE ='" + Id + "';";
			ListeDoc lstDoc = personne.getListeDoc();
			ResultSet resultat2 = stat.executeQuery(sql2);
			while (resultat2.next()) {
				String dIdPersonne = resultat.getString("IDPersonne");
				String dIdDocument = resultat.getString("IDDocument");
				DocPerso doc = new DocPerso(Integer.valueOf(dIdPersonne), Integer.valueOf(dIdDocument));
				doc.setNomDocFile(resultat2.getString("nomDocFile"));
				doc.setNomDocUtil(resultat2.getString("nomDocUtil"));
				doc.setType(resultat2.getString("type"));
				doc.setTime(resultat2.getString("time"));
				doc.setCommentaire(resultat2.getString("commentaire"));
				lstDoc.add(doc);
			}
			personne.setListeDoc(lstDoc);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}

	private void creTables() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;

			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql0 = "CREATE DATABASE listUserActiv";
			stat.executeUpdate(sql0);
			url += "listUserActiv";
			String sql = "CREATE TABLE listUser (" + //
					"IDPersonne INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + //
					"identifiant VARCHAR(255) NOT NULL UNIQUE, " + //
					"mdp VARCHAR(255) NOT NULL, " + //
					"email VARCHAR(255), " + //
					"nom VARCHAR(255), " + //
					"prenom VARCHAR(255), " + //
					"adresse VARCHAR(255), " + //
					"cp VARCHAR(50), " + //
					"ville VARCHAR(255), " + //
					"telFixe VARCHAR(255), " + //
					"telPort VARCHAR(255), " + //
					"fax VARCHAR(255), " + //
					"dateNaissance VARCHAR(255), " + //
					"lieuNaissance VARCHAR(255), " + //
					"numSecu VARCHAR(255), " + //
					"lieuNaissance VARCHAR(255), " + //
					"situation VARCHAR(255), " + //
					"fonction VARCHAR(255), " + //
					"positionEntreprise VARCHAR(255), " + //
					"cadre BOOLEAN, " + //
					"coeff VARCHAR(255), " + //
					"salaire VARCHAR(255), " + //
					"visiteMedicale VARCHAR(255), " + //
					"montantTransport VARCHAR(255), " + //
					"voiture BOOLEAN, " + //
					"nbCV VARCHAR(50), " + //
					"nbKm VARCHAR(50), " + //
					"mutuelle BOOLEAN, " + //
					"ticketResto BOOLEAN, " + //
					"admin BOOLEAN, " + //
					"dateCreation VARCHAR(255), " + //
					"dateModification VARCHAR(255), " + //
					"bloque BOOLEAN, " + //
					"raisonBlocage VARCHAR(1000);";

			stat.executeUpdate(sql);

			String sql2 = "CREATE TABLE listDocuments (" + //
					"IDDoument INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + //
					"IDPersonne INTEGER(11) NOT NULL," + //
					"nomDocUtil VARCHAR(255)," + //
					"type VARCHAR(50)," + //
					"nomDocFile VARCHAR(500)," + //
					"dateCreationDoc VARCHAR(255)," + //
					"commentaire VARCHAR(255)," + //
					"document BLOB ;";
			stat.executeUpdate(sql2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
