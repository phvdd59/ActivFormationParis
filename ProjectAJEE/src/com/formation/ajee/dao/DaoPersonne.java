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

public class DaoPersonne {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://www.psyeval.fr/ajee";

	public String user = "ajee";
	public String pass = "erreuretga";
	public ArrayList<Personne> listPersonne;
	public Personne personne;

	public void insertPersonne(Personne personne) {
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

	public void updatePersonne(Personne personne) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stat = conn.createStatement(); 
					String sql1 = "update ajee.personne set nom = '" + personne.getNom() + "' where idPersonne = '" + personne.getIdPersonne() + "';"; 
					String sql2 = " update ajee.personne set prenom = '" + personne.getPrenom() + "' where idPersonne = '" + personne.getIdPersonne() + "';"; 
					String sql3 = " update ajee.personne set sexe = '" + personne.getSexe() + "' where idPersonne = '" + personne.getIdPersonne() + "';"; 
					String sql4 = " update ajee.personne set identifiant = '" + personne.getIdentifiant() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql5 = " update ajee.personne set mdp = '" + personne.getMdp() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql6 = " update ajee.personne set email = '" + personne.getEmail() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql7 = " update ajee.personne set adresse = '" + personne.getAdresse() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql8 = " update ajee.personne set cp = '" + personne.getCp() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql9 = " update ajee.personne set ville = '" + personne.getVille() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql10 = " update ajee.personne set telFixe = '" + personne.getTelFixe() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql11 = " update ajee.personne set telPort = '"	+ personne.getTelPort() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql12 = " update ajee.personne set fax = '" + personne.getFax() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql13 = " update ajee.personne set dateNaissance = curdate()" //+ personne.getDateNaissance() 
					+ " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql15 = " update ajee.personne set lieuNaissance = '" + personne.getLieuNaissance() + "' where idPersonne = '" + personne.getIdPersonne() +"';";							
					String sql16 = " update ajee.personne set numSecu = '" + personne.getNumSecu() + "' where idPersonne = '" + personne.getIdPersonne() + "';";
					String sql17 = " update ajee.personne set nationalite = '" + personne.getNationalite() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql18 = " update ajee.personne set situation = 'null'" //+ personne.getSituation() 
					+ " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql20 = " update ajee.personne set fonction = '" + personne.getFonction() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql21= " update ajee.personne set positionEntreprise = '" + personne.getPositionEntreprise() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql22 = " update ajee.personne set cadre = " + personne.isCadre() + " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql23 = " update ajee.personne set coeff = '" + personne.getCoeff() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql24 = " update ajee.personne set salaire = '" + personne.getSalaire() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql25 = " update ajee.personne set visiteMedicale = curdate()" //+ personne.getVisiteMedicale() 
					+ " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql26 = " update ajee.personne set montantTransport = '" + personne.getMontantTransport() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql27 = " update ajee.personne set voiture = " + personne.isVoiture() + " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql28 = " update ajee.personne set nbCV = '" + personne.getNbCV() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql29 = " update ajee.personne set nbKm = '" + personne.getNbKm() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql30 = " update ajee.personne set mutuelle = " + personne.isMutuelle() + " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql31 = " update ajee.personne set ticketResto = " + personne.isTicketResto() + " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql32 = " update ajee.personne set dateModification = curdate()"  //personne.getDateModification()  
					+ " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql33 = " update ajee.personne set bloque = " + personne.isBloque() + " where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql34 = " update ajee.personne set raisonBlocage = '" + personne.getRaisonBlocage() + "' where idPersonne = '" + personne.getIdPersonne() +"';";
					String sql35 = " update ajee.personne set listeDoc = '" + personne.getListeDoc() + "' where idPersonne = '" + personne.getIdPersonne() + "';";

					stat.executeUpdate(sql1);
					stat.executeUpdate(sql2);
					stat.executeUpdate(sql3);	
					stat.executeUpdate(sql4);
					stat.executeUpdate(sql5);
					stat.executeUpdate(sql6);
					stat.executeUpdate(sql7);
					stat.executeUpdate(sql8);
					stat.executeUpdate(sql9);
					stat.executeUpdate(sql10);
					stat.executeUpdate(sql11);
					stat.executeUpdate(sql12);
					stat.executeUpdate(sql13);
					stat.executeUpdate(sql15);
					stat.executeUpdate(sql16);
					stat.executeUpdate(sql17);
					stat.executeUpdate(sql18);
					stat.executeUpdate(sql20);
					stat.executeUpdate(sql21);
					stat.executeUpdate(sql22);
					stat.executeUpdate(sql23);
					stat.executeUpdate(sql24);
					stat.executeUpdate(sql25);
					stat.executeUpdate(sql26);
					stat.executeUpdate(sql27);
					stat.executeUpdate(sql28);
					stat.executeUpdate(sql29);
					stat.executeUpdate(sql30);
					stat.executeUpdate(sql31);
					stat.executeUpdate(sql32);
					stat.executeUpdate(sql33);
					stat.executeUpdate(sql34);
					stat.executeUpdate(sql35);
					
			System.out.println("Update terminer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePersonne(Personne personne) {
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
	
public ArrayList<Personne> lectureTable() {
	ArrayList<Personne>retour=new ArrayList<Personne>();
	Connection conne = null;
	Statement stat = null;
	try {
		Class.forName(JDBC_DRIVER);
		conne = DriverManager.getConnection(DB_URL, user, pass);
		stat = conne.createStatement();
		String sql = "SELECT * FROM personne;";
		ResultSet resultat = stat.executeQuery(sql);
		while (resultat.next()) {
			int sIdPersonne = resultat.getInt("idPersonne");
			String sNom = resultat.getString("nom");
			String sPrenom  = resultat.getString("prenom");
			String sIdentifiant = resultat.getString("identifiant");
			String sMdp = resultat.getString("mdp");
			//String sSexe = resultat.getString("sexe");
			
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
			//String sSituation = resultat.getString("situation");
			//SITUATION ssSituation = SITUATION.valueOf(sSituation);
			
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
			Timestamp sDateModification= resultat.getTimestamp("dateModification");
			boolean sBloque = resultat.getBoolean("bloque");
			String sRaisonBlocage = resultat.getString("raisonBlocage");
			//String sListeDoc= resultat.getString("listeDoc");
			
			//System.out.println(sIdentifiant + " " + sNom+ " " + sMdp);
			
			Personne pers=new Personne(sIdPersonne,sNom,sPrenom,sIdentifiant,sMdp,sEmail,sAdresse,sCp,sVille,sTelFixe,sTelPort,sFax,sDateNaissance,sLieuNaissance,sNumSecu,sNationalite,sFonction,sPositionEntreprise,sCadre,sCoeff,sSalaire,sVisiteMedicale,sMontantTransport,sVoiture,sNbCV,sNbKm,sMutuelle,sTicketResto,sDateCreation,sDateModification,sBloque,sRaisonBlocage);
			retour.add(pers);
		}
		;

		System.out.println("fin");
	} catch (ClassNotFoundException | SQLException e) {

		e.printStackTrace();
	}
	
	
	return retour;
	
}


}
