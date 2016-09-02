package com.formation.thcr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.Sexe;

public class DAOPersonne {

	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost/listpersonne";

	public String user = "root";
	public String pass = "";

	public void delete(Personne personne) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "DELETE FROM listpersonne.personne"//
					+ "WHERE LP_EMAIL=" + "'" + personne.getEmail() + "';";
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("OK : " + result);
			} else {
				System.out.println("Erreur");
			}
			statement.close();
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean update(Personne personne) {
		Connection con = null;
		Statement statement = null;
		boolean bool = false;
		try {
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			// LP_IDPERSONNE |LP_NOM |LP_SEXE |LP_IDENTIFIANT |LP_MDP
			// |LP_EMAIL |LP_ADRESSE |LP_CP |LP_VILLE |LP_TELFIXE |LP_TELPORT
			// |LP_FAX |LP_DATENAISSANCE |LP_LIEUNAISSANCE |LP_NUMSECU
			// |LP_NATIONALITE |LP_SITUATION |LP_FONCTION |LP_CADRE |LP_COEFF
			// |LP_SALAIRE |LP_VISITEMEDICALE |LP_MONTANTTRANSPORT |LP_VOITURE
			String sql = "UPDATE listpersonne.personne"//
					+ " SET LP_NOM='" + personne.getNom() //
					+ "', LP_PRENOM='" + personne.getPrenom()//
					+ "', LP_SEXE='" + personne.getSexe().getSexe()//
					+ "', LP_IDENTIFIANT='" + personne.getIdentifiant()//
					+ "', LP_MDP='" + personne.getMdp()//
					+ "', LP_EMAIL='" + personne.getEmail()//
					+ "', LP_ADRESSE='" + personne.getAdresse()//
					+ "', LP_CP='" + personne.getCp()//
					+ "', LP_VILLE='" + personne.getVille()//
					+ "', LP_TELFIXE='" + personne.getTelFixe()//
					+ "', LP_TELPORT='" + personne.getTelPort()//
					+ "', LP_FAX='" + personne.getFax()//
					+ "', LP_DATENAISSANCE='" + personne.getDateNaissance()//
					+ "', LP_LIEUNAISSANCE='" + personne.getLieuNaissance()//
					+ "', LP_NUMSECU='" + personne.getNumSecu()//
					+ "', LP_NATIONALITE='" + personne.getNationalite()//
					+ "', LP_SITUATION='" + personne.getSituation()//
					+ "', LP_FONCTION='" + personne.getFonction()//
					+ "', LP_CADRE='" + personne.isCadre()//
					+ "', LP_COEFF='" + personne.getCoeff()//
					+ "', LP_SALAIRE='" + personne.getSalaire()//
					+ "', LP_VISITEMEDICALE='" + personne.getVisiteMedicale()//
					+ "', LP_MONTANTTRANSPORT='" + personne.getMontantTransport()//
					+ "', LP_VOITURE='" + personne.isVoiture()//
					// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
					// |LP_DATECREATION
					// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
					+ "', LP_NBCV='" + personne.getNbCV()//
					+ "', LP_MUTUELLE='" + personne.isMutuelle()//
					+ "', LP_TICKETRESTO='" + personne.isTicketResto()//
					+ "', LP_ADMIN='" + personne.isAdmin()//
					+ "', LP_DATECREATION='" + personne.getDateCreation()//
					+ "', LP_DATEMODIFICATION='" + personne.getDateModification()//
					+ "', LP_BLOQUE='" + personne.isBloque()//
					+ "', LP_RAISONBLOCAGE='" + personne.getRaisonBlocage()//
					+ "' WHERE LP_EMAIL=" + "'" + personne.getIdentifiant() + "';";//
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("OK : " + result);
				bool=true;
			} else {
				System.out.println("Erreur");
			}
			statement.close();
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public void create(Personne personne) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			// TRAITER LES METADATA pour contrôler les erreurs

			// LP_IDPERSONNE |LP_NOM |LP_SEXE |LP_IDENTIFIANT |LP_MDP
			// |LP_EMAIL |LP_ADRESSE |LP_CP |LP_VILLE |LP_TELFIXE |LP_TELPORT
			// |LP_FAX |LP_DATENAISSANCE |LP_LIEUNAISSANCE |LP_NUMSECU
			// |LP_NATIONALITE |LP_SITUATION |LP_FONCTION |LP_CADRE |LP_COEFF
			// |LP_SALAIRE |LP_VISITEMEDICALE |LP_MONTANTTRANSPORT |LP_VOITURE
			// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
			// |LP_DATECREATION
			// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
			String sql = "INSERT INTO listpersonne.personne"//
					+ "(LP_NOM, LP_PRENOM, LP_SEXE, LP_IDENTIFIANT, LP_MDP, LP_EMAIL, LP_ADRESSE, LP_CP, LP_VILLE, LP_TELFIXE, "
					+ "LP_TELPORT, LP_FAX, LP_DATENAISSANCE, LP_LIEUNAISSANCE, LP_NUMSECU, LP_NATIONALITE, "
					+ "LP_SITUATION, LP_FONCTION, LP_CADRE, LP_COEFF, LP_SALAIRE, LP_VISITEMEDICALE, "
					+ "LP_MONTANTTRANSPORT, LP_VOITURE, LP_NBCV, LP_NBKM, LP_MUTUELLE, LP_TICKETRESTO, LP_ADMIN, "
					+ "LP_DATECREATION, LP_DATEMODIFICATION, LP_BLOQUE, LP_RAISONBLOCAGE)" + "VALUES('"
					+ personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getSexe().getSexe() + "','"
					+ personne.getIdentifiant() + "'," + "'" + personne.getMdp() + "','" + personne.getEmail() + "','"
					+ personne.getAdresse() + "'," + "'" + personne.getCp() + "','" + personne.getVille() + "','"
					+ personne.getTelFixe() + "'," + "'" + personne.getTelPort() + "','" + personne.getFax() + "','"
					+ personne.getDateNaissance() + "'," + "'" + personne.getLieuNaissance() + "','"
					+ personne.getNumSecu() + "','" + personne.getNationalite() + "'," + "'" + personne.getSituation()
					+ "','" + personne.getFonction() + "','" + personne.isCadre() + "'," + "'" + personne.getCoeff()
					+ "','" + personne.getSalaire() + "','" + personne.getVisiteMedicale() + "'," + "'"
					+ personne.getMontantTransport() + "','" + personne.isVoiture() + "','" + personne.getNbCV() + "',"
					+ "'" + personne.getNbKm() + "','" + personne.isMutuelle() + "','" + personne.isTicketResto() + "',"
					+ "'" + personne.isAdmin() + "','" + personne.getDateCreation() + "','"
					+ personne.getDateModification() + "'," + "'" + personne.isBloque() + "','"
					+ personne.getRaisonBlocage() + "')";//
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("OK : " + result);
			} else {
				System.out.println("pas de modif");
			}
			statement.close();
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean read(Personne personne) {
		boolean retour=false;
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "SELECT * FROM listpersonne.personne";
			ResultSet result = statement.executeQuery(sql);
			boolean check = false;
			// TRAITER LES METADATA pour contrôler les erreurs
			// LP_IDPERSONNE |LP_NOM |LP_SEXE |LP_IDENTIFIANT |LP_MDP
			// |LP_EMAIL |LP_ADRESSE |LP_CP |LP_VILLE |LP_TELFIXE |LP_TELPORT
			// |LP_FAX |LP_DATENAISSANCE |LP_LIEUNAISSANCE |LP_NUMSECU
			// |LP_NATIONALITE |LP_SITUATION |LP_FONCTION |LP_CADRE |LP_COEFF
			// |LP_SALAIRE |LP_VISITEMEDICALE |LP_MONTANTTRANSPORT |LP_VOITURE
			// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
			// |LP_DATECREATION
			// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
			while (result.next()) {
				if (personne.getIdentifiant().equals(result.getString("LP_IDENTIFIANT"))
						|| personne.getIdPersonne() == result.getInt("LP_IDPERSONNE")) {
					personne.setIdentifiant(result.getString("LP_IDENTIFIANT"));
					personne.setIdPersonne(Integer.valueOf(result.getString("LP_IDPERSONNE")).intValue());
					personne.setNom(result.getString("LP_NOM"));
					personne.setPrenom(result.getString("LP_PRENOM"));
					if (result.getString("LP_SEXE").equals(Sexe.FEMININ)) {

						personne.setSexe(new Sexe(Sexe.FEMININ));
					} else {
						personne.setSexe(new Sexe(Sexe.MASCULIN));
					}
					personne.setIdentifiant(result.getString("LP_IDENTIFIANT"));
					personne.setMdp(result.getString("LP_MDP"));
					personne.setEmail(result.getString("LP_EMAIL"));
					personne.setAdresse(result.getString("LP_ADRESSE"));
					personne.setCp(result.getString("LP_CP"));
					personne.setVille(result.getString("LP_VILLE"));
					personne.setTelFixe(result.getString("LP_TELFIXE"));
					personne.setTelPort(result.getString("LP_TELPORT"));
					personne.setFax(result.getString("LP_FAX"));
					personne.setDateNaissance(result.getDate("LP_DATENAISSANCE"));
					personne.setLieuNaissance(result.getString("LP_LIEUNAISSANCE"));
					personne.setNumSecu(result.getString("LP_NUMSECU"));
					personne.setNationalite(result.getString("LP_NATIONALITE"));
					personne.setSituation(result.getString("LP_SITUATION"));
					personne.setFonction(result.getString("LP_FONCTION"));
					personne.setCadre(Boolean.valueOf(result.getString("LP_NOM")).booleanValue());
					personne.setCoeff(result.getString("LP_COEFF"));
					personne.setSalaire(result.getString("LP_SALAIRE"));
					personne.setVisiteMedicale(result.getDate("LP_VISITEMEDICALE"));
					// |LP_MONTANTTRANSPORT |LP_VOITURE
					// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
					// |LP_DATECREATION
					// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
					personne.setMontantTransport(result.getString("LP_MONTANTTRANSPORT"));
					personne.setVoiture(Boolean.valueOf(result.getString("LP_VOITURE")).booleanValue());
					personne.setNbCV(Integer.valueOf(result.getString("LP_NBCV")).intValue());
					personne.setNbKm(result.getString("LP_NBKM"));
					personne.setMutuelle(Boolean.valueOf(result.getString("LP_MUTUELLE")).booleanValue());
					personne.setTicketResto(Boolean.valueOf(result.getString("LP_TICKETRESTO")).booleanValue());
					personne.setAdmin(Boolean.valueOf(result.getString("LP_ADMIN")).booleanValue());
					personne.setDateModification(result.getTimestamp("LP_DATECREATION"));
					personne.setBloque(Boolean.valueOf(result.getString("LP_BLOQUE")).booleanValue());
					personne.setRaisonBlocage(result.getString("LP_RAISONBLOCAGE"));
					check = true;
					retour=true;
				}
			}
			statement.close();
			if (check) {
				System.out.println("OK");
			} else {
				System.out.println("erreur de lecture, personne non trouvé dans la base de donnée avec le login : "
						+ personne.getIdentifiant());
			}
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;
	}

	public ListPersonne read() {
		Connection con = null;
		Statement statement = null;
		ListPersonne list = new ListPersonne();
		try {
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			statement = con.createStatement();
			String sql = "SELECT * FROM listpersonne.personne";
			ResultSet result = statement.executeQuery(sql);
			boolean check = false;
			// TRAITER LES METADATA pour contrôler les erreurs
			// LP_IDPERSONNE |LP_NOM |LP_SEXE |LP_IDENTIFIANT |LP_MDP
			// |LP_EMAIL |LP_ADRESSE |LP_CP |LP_VILLE |LP_TELFIXE |LP_TELPORT
			// |LP_FAX |LP_DATENAISSANCE |LP_LIEUNAISSANCE |LP_NUMSECU
			// |LP_NATIONALITE |LP_SITUATION |LP_FONCTION |LP_CADRE |LP_COEFF
			// |LP_SALAIRE |LP_VISITEMEDICALE |LP_MONTANTTRANSPORT |LP_VOITURE
			// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
			// |LP_DATECREATION
			// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
			while (result.next()) {
				Personne personne = new Personne();
				personne.setIdPersonne(Integer.valueOf(result.getString("LP_IDPERSONNE")).intValue());
				personne.setNom(result.getString("LP_NOM"));
				personne.setPrenom(result.getString("LP_PRENOM"));

				if (result.getString("LP_SEXE").equals(Sexe.FEMININ)) {

					personne.setSexe(new Sexe(Sexe.FEMININ));
				} else {
					personne.setSexe(new Sexe(Sexe.MASCULIN));
				}
				personne.setIdentifiant(result.getString("LP_IDENTIFIANT"));
				personne.setMdp(result.getString("LP_MDP"));
				personne.setEmail(result.getString("LP_EMAIL"));
				personne.setAdresse(result.getString("LP_ADRESSE"));
				personne.setCp(result.getString("LP_CP"));
				personne.setVille(result.getString("LP_VILLE"));
				personne.setTelFixe(result.getString("LP_TELFIXE"));
				personne.setTelPort(result.getString("LP_TELPORT"));
				personne.setFax(result.getString("LP_FAX"));
				personne.setDateNaissance(result.getDate("LP_DATENAISSANCE"));
				personne.setLieuNaissance(result.getString("LP_LIEUNAISSANCE"));
				personne.setNumSecu(result.getString("LP_NUMSECU"));
				personne.setNationalite(result.getString("LP_NATIONALITE"));
				personne.setSituation(result.getString("LP_SITUATION"));
				personne.setFonction(result.getString("LP_FONCTION"));
				personne.setCadre(Boolean.valueOf(result.getString("LP_NOM")).booleanValue());
				personne.setCoeff(result.getString("LP_COEFF"));
				personne.setSalaire(result.getString("LP_SALAIRE"));
				personne.setVisiteMedicale(result.getDate("LP_VISITEMEDICALE"));
				// |LP_MONTANTTRANSPORT |LP_VOITURE
				// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
				// |LP_DATECREATION
				// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
				personne.setMontantTransport(result.getString("LP_MONTANTTRANSPORT"));
				personne.setVoiture(Boolean.valueOf(result.getString("LP_VOITURE")).booleanValue());
				personne.setNbCV(Integer.valueOf(result.getString("LP_NBCV")).intValue());
				personne.setNbKm(result.getString("LP_NBKM"));
				personne.setMutuelle(Boolean.valueOf(result.getString("LP_MUTUELLE")).booleanValue());
				personne.setTicketResto(Boolean.valueOf(result.getString("LP_TICKETRESTO")).booleanValue());
				personne.setAdmin(Boolean.valueOf(result.getString("LP_ADMIN")).booleanValue());
				personne.setDateModification(result.getTimestamp("LP_DATECREATION"));
				personne.setBloque(Boolean.valueOf(result.getString("LP_BLOQUE")).booleanValue());
				personne.setRaisonBlocage(result.getString("LP_RAISONBLOCAGE"));
				list.add(personne);
				check = true;
			}

			statement.close();
			if (check) {
				System.out.println("OK");
			} else {
				System.out.println("erreur de lecture");
			}
			System.out.println("fin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
