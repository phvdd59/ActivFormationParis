package com.formation.thcr.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.Sexe;

/**
 * Servlet implementation class ServletTestDAO
 */
@WebServlet("/ServletTestDAO")
public class ServletTestDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Personne personne = new Personne();

		personne.setAdmin(false);
		personne.setAdresse("testadresse");
		personne.setBloque(false);
		personne.setCadre(false);
		personne.setCoeff("1");
		personne.setCp("cp");
		String StringDateCreation = "2010-03-06";
		ConversionPersonne conv = new ConversionPersonne();
		personne.setDateCreation(conv.conversionDate(StringDateCreation));
		java.util.Date date = new java.util.Date();
		personne.setDateModification(new Timestamp(date.getTime()));
		personne.setDateNaissance(conv.conversionDate(StringDateCreation));
		personne.setEmail("test.test@test.fr");
		personne.setFax("");
		personne.setFonction("fonction");
		personne.setIdentifiant("test");
		personne.setLieuNaissance("lieu de naissance");
		personne.setMdp("password");
		personne.setMontantTransport("70");
		personne.setMutuelle(false);
		personne.setNationalite("fr");
		personne.setNbCV(20);
		personne.setNbKm("200");
		personne.setNom("Nomtest");
		personne.setNumSecu("190");
		personne.setPosition("position de test");
		personne.setPrenom("Prenomtest");
		personne.setRaisonBlocage("pas de raison");
		personne.setSalaire("32000");
		personne.setSexe(new Sexe(Sexe.MASCULIN));
		personne.setSituation("situation test");
		personne.setTelFixe("01");
		personne.setTelPort("06");
		personne.setTicketResto(false);
		personne.setVille("Ville test");
		personne.setVisiteMedicale(conv.conversionDate(StringDateCreation));
		personne.setVoiture(false);

		session.setAttribute("Personne", personne);

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/ServletTestDAO2");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
