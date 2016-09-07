package com.formation.thcr.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletMdpUpdate
 */
@WebServlet("/ServletMdpUpdate")
public class ServletMdpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMdpUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("Personne");
		
		String sMdpOld = request.getParameter("ancien mdp");
		String sMdpNew1 = request.getParameter("new mdp 1");
		String sMdpNew2 = request.getParameter("new mdp 2");
		
		Personne personne = null;
		if(o instanceof Personne){
			personne = (Personne) o;
		}
		if(personne.getMdp().equals(sMdpOld) && sMdpNew1.equals(sMdpNew2)){
			personne.setMdp(sMdpNew1);
		}
		DAOPersonne dao = new DAOPersonne();
		java.util.Date dateModif = new java.util.Date();
		personne.setDateModification(new Timestamp(dateModif.getTime()));
		dao.update(personne,"personne");
		getServletContext().getRequestDispatcher("/ServletJOCA1").forward(request, response);
		//REDIRECT TO LOGIN
		//response.sendRedirect("/ServletJOCA1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
