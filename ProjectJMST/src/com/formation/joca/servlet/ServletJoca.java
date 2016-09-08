package com.formation.joca.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.beans.ConversionPersoToPersonne;
import com.formation.beans.Perso;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletJoca
 */
@WebServlet("/ServletJoca")
public class ServletJoca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJoca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//		String sAdresse = (String) session.getAttribute("adresse");
		//		String lien = null;
		//		if (sAdresse.equals("JMST")) {
		//			lien = "localhost";
		//		} else if (sAdresse.equals("BAIT")) {
		//			lien = "192.168.33.144";
		//		} else if (sAdresse.equals("AJEE")) {
		//			lien = "192.168.33.141";
		//		}
		//		URL wsdlURL = new URL("http://" + lien + ":8888/ws/jax?wsdl");
		//		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		//		Service service = Service.create(wsdlURL, qname);
		//		InterPersoService ps = service.getPort(InterPersoService.class);
		Perso[] tabPerso = (Perso[]) session.getAttribute("tabPerso");

		ConversionPersoToPersonne conversion = new ConversionPersoToPersonne();
		DAOPersonne dao = new DAOPersonne();

		ListPersonne listp = dao.read("personneWS");


		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://www.psyeval.fr/jmst";
		final String user = "jmst";
		final String pass = "erreurmade";
		
		Connection con = null;
		Statement statement = null;
		
		try {
			System.out.println(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER); // nom du driver
			con = DriverManager.getConnection(DB_URL, user, pass);
			

			for (int i = 0; i < tabPerso.length; i++) {
				statement = con.createStatement();
				Personne personne=conversion.conv(tabPerso[i]);
				String sql = "INSERT INTO jmst.personneWS"//
						+ "(LP_NOM, LP_PRENOM, LP_SEXE, LP_IDENTIFIANT, LP_MDP, LP_EMAIL, LP_ADRESSE, LP_CP, LP_VILLE, LP_TELFIXE, "
						+ "LP_TELPORT, LP_FAX, LP_DATENAISSANCE, LP_LIEUNAISSANCE, LP_NUMSECU, LP_NATIONALITE, "
						+ "LP_SITUATION, LP_FONCTION, LP_POSITION,LP_CADRE, LP_COEFF, LP_SALAIRE, LP_VISITEMEDICALE, "
						+ "LP_MONTANTTRANSPORT, LP_VOITURE, LP_NBCV, LP_NBKM, LP_MUTUELLE, LP_TICKETRESTO, LP_ADMIN, "
						+ "LP_DATECREATION, LP_DATEMODIFICATION, LP_BLOQUE, LP_RAISONBLOCAGE)" + "VALUES('"
						+ personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getSexe().getSexe() + "','"
						+ personne.getIdentifiant() + "'," + "'" + personne.getMdp() + "','" + personne.getEmail() + "','"
						+ personne.getAdresse() + "'," + "'" + personne.getCp() + "','" + personne.getVille() + "','"
						+ personne.getTelFixe() + "'," + "'" + personne.getTelPort() + "','" + personne.getFax() + "','"
						+ personne.getDateNaissance() + "'," + "'" + personne.getLieuNaissance() + "','"
						+ personne.getNumSecu() + "','" + personne.getNationalite() + "'," + "'" + personne.getSituation()
						+ "','" + personne.getFonction() + "','" + personne.getPosition() + "','" + personne.isCadre() + "'," + "'" + personne.getCoeff()
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
					System.out.println("erreur DAO create");
				}
				statement.close();
						
			}
			System.out.println("fin perso");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/ProjectJMST/jsp/ListBDD.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
