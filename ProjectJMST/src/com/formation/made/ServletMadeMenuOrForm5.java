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
 * Servlet implementation class ServletMadeMenuOrForm5
 */
@WebServlet("/ServletMadeMenuOrForm5")
public class ServletMadeMenuOrForm5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMadeMenuOrForm5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Personne personne = null;
		Object o = session.getAttribute("Personne");
		
		if(o instanceof Personne){
			personne = (Personne) o;
			String sFonction=request.getParameter("fonction occupee");//il manque le string de cadre dans la jsp5
			String sCadre=request.getParameter("cadre");
			String sPosition=request.getParameter("Position");
			String sCoeff=request.getParameter("coefficient");
			String sSalaire=request.getParameter("salaire souhaite");
			String sMutuelle=request.getParameter("mutuelle");
			String sTicketResto=request.getParameter("ticket resto");
			String sVisiteMedicale=request.getParameter("date visite medicale");
			String sVehiculePerso=request.getParameter("vehicule perso");
			String sNbCV=request.getParameter("nb de CV");
			String sNbKm=request.getParameter("km mensuel");
			
//			 if(CtrlPersonne.ctrlFonction(sFonction)&&CtrlPersonne.ctrlCadre(sCadre)&&CtrlPersonne.ctrlPosition(sPosition)&&//
//					 +CtrlPersonne.ctrlCoeff(sCoeff)&&CtrlPersonne.ctrlSalaire(sSalaire)&&cCtrlPersonne.ctrlMutuelle(sMutuelle)//
//					 +CtrlPersonne.ctrlTicketResto(sTicketResto)&&CtrlPersonne.ctrlVisiteMedicale(sVisiteMedicale)&&
//					 +CtrlPersonne.ctrlVoiture(sVehiculePerso)&&CtrlPersonne.ctrlNbKm(sNbKm)&&CtrlPersonne.ctrlNbCV(sNbCV)){
//				personne.setFonction(sFonction);
//				personne.setCadre(ConversionPersonne.conversionBoolean(sCadre));
//				personne.setPosition(sPosition);
//				personne.setCoeff(sCoeff);
//				personne.setSalaire(sSalaire);
//				personne.setMutuelle(ConversionPersonne.conversionBoolean(sMutuelle));
//				personne.setTicketResto(ConversionPersonne.conversionBoolean(sTicketResto));
//				personne.setVisiteMedicale(ConversionPersonne.conversionDate(sVisiteMedicale));
//				personne.setVoiture(ConversionPersonne.conversionBoolean(sVehiculePerso));
//				personne.setNbKm(sNbKm);
//				personne.setNbCV(Integer.valueOf(sNbCV).intValue());
//				
//				
//				response.sendRedirect("http://localhost:8080/ProjectJMST/ServletJOCA1");
//				
//			}
//			 else {
//				response.sendRedirect("http://localhost:8080/ProjectJMST/jsp/Part5.jsp");
//			}
			
			
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
