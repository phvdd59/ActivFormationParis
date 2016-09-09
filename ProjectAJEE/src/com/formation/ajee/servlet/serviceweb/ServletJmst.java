package com.formation.ajee.servlet.serviceweb;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.formation.ajee.dao.DaoBDD;
import com.formation.ajee.dao.DaoPersonne;
import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;
import com.formation.beans.InterPersoService;
import com.formation.beans.Perso;

/**
 * Servlet implementation class ProjectJmst
 */
@WebServlet("/ProjectJmst")
public class ServletJmst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJmst() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		ListPersonne lstPersonne = new ListPersonne();
		ListPersonne lstPersonnesave = new ListPersonne(1);

		DaoPersonne dao = new DaoPersonne();
		DaoBDD dao1 = new DaoBDD();
		URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
		Service service = Service.create(wsdlURL, qname);
		InterPersoService ps = service.getPort(InterPersoService.class);
		Perso[] p = ps.getPersos();

		if (lstPersonnesave.size() == 0) {
			for (int i = 0; i < lstPersonne.size(); i++) {
				dao1.insertPersBackup(lstPersonne.get(i));
			}
		}
		// } else {
		if (p != null) {
			dao1.deleteTableBdd();
			for (int i = 0; i < p.length; i++) {
				Personne pers = new Personne();
				pers.setAdresse(p[i].getAdresse());
				pers.setNom(p[i].getNom());
				pers.setPrenom(p[i].getPrenom());
				pers.setSexe(p[i].getSexe());
				pers.setIdentifiant(p[i].getIdentifiant());
				pers.setMdp(p[i].getMdp());
				pers.setEmail(p[i].getEmail());
				pers.setCp(p[i].getCp());
				pers.setVille(p[i].getVille());
				pers.setTelFixe(p[i].getTelFixe());
				pers.setTelPort(p[i].getTelPort());
				pers.setFax(p[i].getFax());
				pers.setDateNaissance(p[i].getDateNaissance());
				pers.setLieuNaissance(p[i].getLieuNaissance());
				pers.setNumSecu(p[i].getNumSecu());
				pers.setNationalite(p[i].getNationalite());
				pers.setSituation(p[i].getSituation());
				pers.setFonction(p[i].getFonction());
				pers.setPositionEntreprise(p[i].getPos());
				pers.setCadre(p[i].isCadre());
				pers.setCoeff(p[i].getCoeff());
				pers.setSalaire(p[i].getSalaire());
				pers.setVisiteMedicale(p[i].getVisiteMedicale());
				pers.setMontantTransport(p[i].getMontantTransport());
				pers.setVoiture(p[i].isVoiture());
				pers.setNbCV(p[i].getNbCV());
				pers.setNbKm(p[i].getNbKm());
				pers.setMutuelle(p[i].isMutuelle());
				pers.setTicketResto(p[i].isTicketResto());
				pers.setDateCreation(p[i].getDateCreation());
				pers.setDateModification(p[i].getDateModification());
				pers.setBloque(p[i].isBloque());
				pers.setRaisonBlocage(p[i].getRaisonBlocage());

				dao.insertPersonne(pers);
			}
		}

		// }
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
		rd.forward(request, response);
	}

}
