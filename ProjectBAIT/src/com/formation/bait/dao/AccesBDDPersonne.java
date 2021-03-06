package com.formation.bait.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.bait.metier.DocPerso;
import com.formation.bait.metier.FonctionsCommune;
import com.formation.bait.metier.ListeDoc;
import com.formation.bait.metier.Personne;
import com.formation.beans.InterPersoService;
import com.formation.beans.Perso;

public class AccesBDDPersonne {
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://www.psyeval.fr/";

	public String user = "bait";
	public String pass = "erreurthde";

	public boolean savePersonne(Personne personne) {
		Connection conn = null;
		Statement stat = null;
		boolean result = false;
		int resultInt = 0;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "UPDATE listeUser set identifiant='" + personne.getIdentifiant() + "', mdp='" + personne.getMdp() + //
					"', email='" + personne.getEmail() + "', nom='" + personne.getNom() + "', prenom='" + personne.getPrenom() + //
					"', adresse='" + personne.getAdresse() + "', cp='" + personne.getcP() + "', ville='" + personne.getVille() + //
					"', telFixe='" + personne.getTelFixe() + "', telPort='" + personne.getTelPort() + "', fax='" + personne.getFax() + //
					"', dateNaissance='" + personne.getDateNaissance() + "', lieuNaissance='" + personne.getLieuNaissance() + //
					"', numSecu='" + personne.getNumSecu() + "', Nationalite='" + personne.getNationalite() + "', situation='" + personne.getSituation() + "', fonction='" + //
					personne.getFonction() + "', positionEntreprise='" + personne.getPosition() + "', cadre='" + booleanConverter(personne.isCadre()) + //
					"', coeff='" + personne.getCoeff() + "', salaire='" + personne.getSalaire() + "', visiteMedicale='" + //
					personne.getVisiteMedicale() + "', montantTransport='" + personne.getMontantTransport() + "', voiture='" + //
					booleanConverter(personne.isVoiture()) + "', nbCV='" + personne.getNbCV() + "', nbKm='" + personne.getNdKm() + "', mutuelle='" + //
					booleanConverter(personne.isMutuelle()) + "', ticketResto='" + booleanConverter(personne.isTicket()) + "', admin='" + booleanConverter(personne.isAdmin()) + //
					"', dateCreation='" + personne.getDateCreation() + "', dateModification='" + personne.getDateModification() + //
					"', bloque='" + booleanConverter(personne.isBloque()) + "', raisonBlocage='" + personne.getRaisonBlocage() + "' WHERE IDPersonne=" + personne.getIdPersonne() + ";";
			resultInt = stat.executeUpdate(sql);
			System.out.println(sql);
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkUserName(String identifiant) {
		Connection conn = null;
		Statement stat = null;
		boolean result = false;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "SELECT IDPersonne FROM listeUser WHERE identifiant='" + identifiant//
					+ "';";

			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				result = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean savePersonneEmpruntee(Personne personne) {
		boolean result = false;

		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "insert into listeUserEmpruntee (identifiant,mdp,email,nom,prenom,adresse,cp,ville," + //
					"telFixe,telPort,fax,dateNaissance,lieuNaissance,numSecu,Nationalite,situation,fonction,positionEntreprise," + //
					"cadre,coeff,salaire,visiteMedicale,montantTransport,voiture,nbCV,nbKm,mutuelle,ticketResto,admin," + //
					"dateCreation,dateModification,bloque,raisonBlocage) values ('" + personne.getIdentifiant() + "','" + //
					personne.getMdp() + "','" + personne.getEmail() + "','" + personne.getNom() + "','" + personne.getPrenom() + "','" + //
					personne.getAdresse() + "','" + personne.getcP() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "','" + //
					personne.getTelPort() + "','" + personne.getFax() + "','" + personne.getDateNaissance() + "','" + //
					personne.getLieuNaissance() + "','" + personne.getNumSecu() + "','" + personne.getNationalite() + "','" + personne.getSituation() + "','" + //
					personne.getFonction() + "','" + personne.getPosition() + "','" + booleanConverter(personne.isCadre()) + "','" + personne.getCoeff() + "','" + //
					personne.getSalaire() + "','" + personne.getVisiteMedicale() + "','" + personne.getMontantTransport() + "','" + //
					booleanConverter(personne.isVoiture()) + "','" + personne.getNbCV() + "','" + personne.getNdKm() + "','" + booleanConverter(personne.isMutuelle()) + "','" + //
					booleanConverter(personne.isTicket()) + "','" + booleanConverter(personne.isAdmin()) + "','" + personne.getDateCreation() + "','" + personne.getDateModification() + "','" + //
					booleanConverter(personne.isBloque()) + "','" + personne.getRaisonBlocage() + "');";

			stat.executeUpdate(sql);
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void remplirListeUserEmpruntee(Perso[] tabPerso) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "delete from listeUserEmpruntee";
			stat.executeUpdate(sql);
			FonctionsCommune fc = new FonctionsCommune();
			for (Perso perso : tabPerso) {
				savePersonneEmpruntee(fc.PersoVersPerso(perso));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean createNewPersonne(String identifiant, String mdp, String email, String nom, String prenom) {
		boolean result = false;
		Personne personne = new Personne(identifiant, mdp);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setEmail(email);
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "insert into listeUser (identifiant,mdp,email,nom,prenom,adresse,cp,ville," + //
					"telFixe,telPort,fax,dateNaissance,lieuNaissance,numSecu,Nationalite,situation,fonction,positionEntreprise," + //
					"cadre,coeff,salaire,visiteMedicale,montantTransport,voiture,nbCV,nbKm,mutuelle,ticketResto,admin," + //
					"dateCreation,dateModification,bloque,raisonBlocage) values ('" + personne.getIdentifiant() + "','" + //
					personne.getMdp() + "','" + personne.getEmail() + "','" + personne.getNom() + "','" + personne.getPrenom() + "','" + //
					personne.getAdresse() + "','" + personne.getcP() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "','" + //
					personne.getTelPort() + "','" + personne.getFax() + "','" + personne.getDateNaissance() + "','" + //
					personne.getLieuNaissance() + "','" + personne.getNumSecu() + "','" + personne.getNationalite() + "','" + personne.getSituation() + "','" + //
					personne.getFonction() + "','" + personne.getPosition() + "','" + booleanConverter(personne.isCadre()) + "','" + personne.getCoeff() + "','" + //
					personne.getSalaire() + "','" + personne.getVisiteMedicale() + "','" + personne.getMontantTransport() + "','" + //
					booleanConverter(personne.isVoiture()) + "','" + personne.getNbCV() + "','" + personne.getNdKm() + "','" + booleanConverter(personne.isMutuelle()) + "','" + //
					booleanConverter(personne.isTicket()) + "','" + booleanConverter(personne.isAdmin()) + "','" + personne.getDateCreation() + "','" + personne.getDateModification() + "','" + //
					booleanConverter(personne.isBloque()) + "','" + personne.getRaisonBlocage() + "');";

			stat.executeUpdate(sql);
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String[] findPersonne(String Identifiant) {
		Connection conn = null;
		Statement stat = null;
		String[] parameters = new String[4];
		parameters[0] = null;
		parameters[1] = null;
		parameters[2] = null;
		parameters[3] = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT IDPersonne,mdp,bloque,raisonBlocage FROM listeUser WHERE identifiant='" + Identifiant//
					+ "';";

			ResultSet resultat = stat.executeQuery(sql);
			while (resultat.next()) {
				parameters[0] = resultat.getString("IDPersonne");
				parameters[1] = resultat.getString("mdp");
				boolean blok = resultat.getBoolean("bloque");
				if (blok) {
					parameters[2] = "True";
				} else {
					parameters[2] = "False";
				}
				parameters[3] = resultat.getString("raisonBlocage");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return parameters;
	}

	public ArrayList<String> findAllUserId() {
		ArrayList<String> listUser = new ArrayList<String>();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT IDPersonne FROM listeUser;";

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

	public Personne getPersonne(String Id) {
		Personne personne = null;
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
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
			personne.setNationalite(resultat.getString("nationalite"));
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
			personne.setDateCreation(resultat.getString("dateCreation"));
			personne.setDateModification(resultat.getString("dateModification"));
			personne.setBloque(resultat.getBoolean("bloque"));
			personne.setRaisonBlocage(resultat.getString("raisonBlocage"));

			String sql2 = "SELECT * FROM listDocuments WHERE IDPERSONNE ='" + Id + "';";
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

	public Personne getPersonneEmpruntee(String Id) {
		Personne personne = null;
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			String sql = "SELECT * FROM listeUserEmpruntee WHERE IDPERSONNE ='" + Id + "';";

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
			personne.setNationalite(resultat.getString("nationalite"));
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
			personne.setDateCreation(resultat.getString("dateCreation"));
			personne.setDateModification(resultat.getString("dateModification"));
			personne.setBloque(resultat.getBoolean("bloque"));
			personne.setRaisonBlocage(resultat.getString("raisonBlocage"));

			String sql2 = "SELECT * FROM listDocuments WHERE IDPERSONNE ='" + Id + "';";
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

	public void afficherListeCandidats(HttpServletResponse response) throws IOException {

		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			response.getWriter().append("<div style=\"text-align: center; margin-left:80px; width:350px; max-height:420px; overflow:auto\">");
			String sql = "SELECT * FROM listeUser Where admin=0 order by nom;";
			ResultSet resultat = stat.executeQuery(sql);
			char lettre = 'Z';
			while (resultat.next()) {
				if (!resultat.getString("nom").startsWith(Character.toString(lettre))) {
					lettre = resultat.getString("nom").charAt(0);
					response.getWriter().append("<div style=\"margin-top: 12px; font-size:150%;\">");
					response.getWriter().append(lettre);
					response.getWriter().append("</div>");
				}
				response.getWriter().append("<form method=\"post\" action=\"http://" + FonctionsCommune.HOST + ":8080/ProjectBAIT/ServletPageExamCandidat2\">");
				response.getWriter().append("<input type=\"hidden\" value=\"" + resultat.getString("IDPersonne") + "\" name=\"IDcandidat\" />");
				response.getWriter().append("<input type=\"hidden\" value=\"notre\" name=\"BDDorigine\" />");
				response.getWriter().append("<input type=\"submit\" style=\"width: 250px;\" value=\"" + resultat.getString("nom") + " " + resultat.getString("prenom") + "\" name=\"" + resultat.getString("nom") + "\" /><br>");
				response.getWriter().append("</form>");
			}
			response.getWriter().append("</div>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void afficherListeCandidatsEmpruntee(HttpServletResponse response) throws IOException {

		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL + "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();

			response.getWriter().append("<div style=\"text-align: center; margin-left:80px; width:350px; max-height:420px; overflow:auto\">");
			String sql = "SELECT * FROM listeUserEmpruntee Where admin=0 order by nom;";
			ResultSet resultat = stat.executeQuery(sql);
			char lettre = 'Z';
			while (resultat.next()) {
				if (!resultat.getString("nom").startsWith(Character.toString(lettre))) {

					lettre = resultat.getString("nom").charAt(0);
					response.getWriter().append("<div style=\"margin-top: 12px; font-size:150%;\">");
					response.getWriter().append(lettre);
					response.getWriter().append("</div>");
				}
				response.getWriter().append("<form method=\"post\" action=\"http://" + FonctionsCommune.HOST + ":8080/ProjectBAIT/ServletPageExamCandidat2\">");
				response.getWriter().append("<input type=\"hidden\" value=\"" + resultat.getString("IDPersonne") + "\" name=\"IDcandidat\" />");
				response.getWriter().append("<input type=\"hidden\" value=\"empruntee\" name=\"BDDorigine\" />");
				response.getWriter().append("<input type=\"submit\" style=\"width: 250px;\" value=\"" + resultat.getString("nom") + " " + resultat.getString("prenom") + "\" name=\"" + resultat.getString("nom") + "\" /><br>");
				response.getWriter().append("</form>");
			}
			response.getWriter().append("</div>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void creTables() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;

			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			// String sql1 = "DROP DATABASE listeUserActiv;";
			// String sql0 = "CREATE DATABASE listeUserActiv;";
			// stat.executeUpdate(sql1);
			// stat.executeUpdate(sql0);
			url += "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "CREATE TABLE listeUser (" + //
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
					"raisonBlocage VARCHAR(1000));";
			System.out.println(sql);
			stat.executeUpdate(sql);

			String sql2 = "CREATE TABLE listDocuments (" + //
					"IDDocument INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + //
					"IDPersonne INTEGER(11) NOT NULL," + //
					"nomDocUtil VARCHAR(255)," + //
					"type VARCHAR(50)," + //
					"nomDocFile VARCHAR(500)," + //
					"dateCreationDoc VARCHAR(255)," + //
					"commentaire VARCHAR(255)," + //
					"document BLOB);";
			stat.executeUpdate(sql2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void creTablesSauv() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName(JDBC_DRIVER);
			String url = DB_URL;

			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			// String sql1 = "DROP DATABASE listeUserActiv;";
			// String sql0 = "CREATE DATABASE listeUserActiv;";
			// stat.executeUpdate(sql1);
			// stat.executeUpdate(sql0);
			url += "bait";
			conn = DriverManager.getConnection(url, user, pass);
			stat = conn.createStatement();
			String sql = "CREATE TABLE listeUserEmpruntee (" + //
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
					"raisonBlocage VARCHAR(1000)," + //
					"Nationalite VARCHAR(255));";
			System.out.println(sql);
			stat.executeUpdate(sql);

			// String sql2 = "CREATE TABLE listDocumentsSave (" + //
			// "IDDocument INTEGER(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
			// //
			// "IDPersonne INTEGER(11) NOT NULL," + //
			// "nomDocUtil VARCHAR(255)," + //
			// "type VARCHAR(50)," + //
			// "nomDocFile VARCHAR(500)," + //
			// "dateCreationDoc VARCHAR(255)," + //
			// "commentaire VARCHAR(255)," + //
			// "document BLOB);";
			// stat.executeUpdate(sql2);
			//
			// String sql3 = "insert into listeUserSave select * from
			// listeUser;";
			// stat.executeUpdate(sql3);
			// String sql4 = "insert into listDocumentsSave select * from
			// listDocuments;";
			// stat.executeUpdate(sql4);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void accesAutresBDD(String Str) {
		URL wsdlURL;
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		try {
			if (Str.equals("BDDJMST")) {
				wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
				Service service = Service.create(wsdlURL, qname);
				InterPersoService ps = service.getPort(InterPersoService.class);

				Perso[] ps1 = ps.getPersos();
				this.remplirListeUserEmpruntee(ps1);
			} else if (Str.equals("BDDAJEE")) {
				wsdlURL = new URL("http://192.168.33.159:8888/ws/jax?wsdl");
				Service service = Service.create(wsdlURL, qname);
				InterPersoService ps = service.getPort(InterPersoService.class);

				Perso[] ps1 = ps.getPersos();
				this.remplirListeUserEmpruntee(ps1);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int booleanConverter(boolean bool) {
		int res = 0;

		if (bool == true) {
			res = 1;
		}
		return res;
	}

	private boolean integerConverter(int i) {
		boolean res = false;

		if (i == 1) {
			res = true;
		}
		return res;
	}

}
