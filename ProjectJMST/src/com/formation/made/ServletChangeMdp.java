package com.formation.made;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletChangeMdp
 */
@WebServlet(description = "cette servlet doit changer le mot de passe de la session active", urlPatterns = { "/ServletChangeMdp" })
public class ServletChangeMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChangeMdp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Object personne =session.getAttribute("Personne");
//		Personne perso=null;
//		if (personne instanceof Personne) {
//			 perso= (Personne) personne;
//		}
//		Object objSessionNoSerie=session.getAttribute("noSerie");
//		String sNoSerie=request.getParameter("noSerie");
//		if (objSessionNoSerie instanceof String) {
//			String sSessionNoSerie=
//		}
//		String sAncienMdp=request.getParameter("ancienMdp"); //il faudrait changer les noms "names" des differents mots de passe
		
		HttpSession session=request.getSession();
		Object personne = session.getAttribute("Personne");//il faudrait vraiment verifier si c'est une personne
		Personne perso=null;
		if (personne instanceof Personne) {
			perso=(Personne)personne;
		}
		
		String loginPersonne=perso.getIdentifiant();
		String mdpPersonne=perso.getMdp();
		
		String sLogin=request.getParameter("identifiant");
		String sAncienMdp=request.getParameter("ancien mdp"); //il faudrait changer les noms "names" des differents mots de passe
		String sNouveauMdp=request.getParameter("new mdp 1");
		String sRenouvellementMdp=request.getParameter("new mdp 2");
		
		if (perso!=null) {
			if (mdpPersonne.equals(sAncienMdp)&&loginPersonne.equals(sLogin)) {
				if (sNouveauMdp.equals(sRenouvellementMdp)) {
					perso.setMdp(sNouveauMdp);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
