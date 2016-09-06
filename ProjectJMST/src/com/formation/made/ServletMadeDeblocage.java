package com.formation.made;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.ListPersonne;
import com.formation.thcr.metier.Personne;

/**
 * Servlet implementation class ServletMadeADebloquer
 */
@WebServlet("/ServletMadeDeblocage")
public class ServletMadeDeblocage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMadeDeblocage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String personneADebloquer=request.getParameter("personneADebloquer");
		String noSerieSession=(String) session.getAttribute("noSerie");
		String noSerie=request.getParameter("noSerie");
		System.out.println("personne a  debloquer" +personneADebloquer);
		DAOPersonne dao=new DAOPersonne();
		ListPersonne listePersonne=dao.read();
		//if(noSerieSession.equals(noSerie)){
		for (Personne personne : listePersonne) {
			System.out.println("le nom de la personne est "+personne.getNom());
			if(personne.getIdentifiant().equals(personneADebloquer)){
				System.out.println("la liste de personne est bonne");
				if(personne.isBloque()==true){
					System.out.println("");
					personne.setBloque(false);
					personne.setRaisonBlocage("Personne debloquee");
					dao.update(personne);
					
				}

				
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/testjspsuppression.jsp");
				//dispatcher.forward(request, response);
			}
			
		}
	//	}
		System.out.println("je forward");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/testjspsuppression.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("http://localhost:8080/ProjectJMST/jsp/Part5.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
