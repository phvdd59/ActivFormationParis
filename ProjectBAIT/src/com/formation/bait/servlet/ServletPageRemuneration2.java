package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.bait.metier.FonctionsCommune;
import com.formation.bait.metier.Personne;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletRemuneration2", name = "ServletRemuneration2")
public class ServletPageRemuneration2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int VALEUR = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageRemuneration2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("//ServletLogin3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		FonctionsCommune fonctions = new FonctionsCommune();
		String sNoSuiviClient = request.getParameter("suiviClient");
		String sNbAppelClient = request.getParameter("nbAppelClient");
		Object oNoSuivi = session.getAttribute("suivi");
		if (oNoSuivi != null) {
			session.setAttribute("servlet", "Remuneration");
			session.setAttribute("methode", "POST");
			int nbAppel = ((Integer) session.getAttribute("nbAppel")).intValue();
			nbAppel++;
			session.setAttribute("nbAppel", Integer.valueOf(nbAppel));
			
			fonctions.AfficherHautDePage(response);

			File file2 = new File(
					"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Remuneration.html");
			BufferedReader bIn2 = null;
			Personne personne = (Personne) session.getAttribute("Personne");
			InputStreamReader inputStreamReader2 = null;
			try {
				inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
				bIn2 = new BufferedReader(inputStreamReader2);
				String line2 = bIn2.readLine();
				while (line2 != null) {
					// System.out.println(line);
					if (!personne.isCadre()) {
						line2=line2.replace("name=\"cadre\" value=\"Cadre\" type=\"radio\" checked","name=\"cadre\" value=\"Cadre\" type=\"radio\"");
						line2=line2.replace("name=\"Cadre\" value=\"NCadre\" type=\"radio\"", "name=\"Cadre\" value=\"NCadre\" type=\"radio\" checked");
					
					}
					
					if (!personne.isMutuelle()) {
						line2=line2.replace("name=\"mutuelle\" value=\"oui\" type=\"radio\" checked","name=\"mutuelle\" value=\"oui\" type=\"radio\"");
						
						line2=line2.replace("name=\"mutuelle\" value=\"non\" type=\"radio\" ","name=\"mutuelle\" value=\"non\" type=\"radio\" checked");
					
					}
					
					if (!personne.isTicket()) {
						line2=line2.replace("value=\"oui\" name=\"resto\" type=\"radio\" checked", "value=\"oui\" name=\"resto\" type=\"radio\" ");
						
						line2=line2.replace("name=\"resto\" value=\"non\" type=\"radio\"","name=\"resto\" value=\"non\" type=\"radio\" checked");
					
					}
					
					if (!personne.isVoiture()) {
						line2=line2.replace("name=\"voiture\" value=\"oui\" type=\"radio\" checked","name=\"voiture\" value=\"oui\" type=\"radio\" ");
						
						line2=line2.replace("name=\"voiture\" value=\"non\" type=\"radio\"","name=\"voiture\" value=\"non\" type=\"radio\" checked");
					
					}
					
					line2=line2.replace("%%fonction%%", personne.getFonction());
					
					line2=line2.replace("%%position%%", personne.getPosition());
					
					line2=line2.replace("%%salaire%%", personne.getSalaire());
					
					line2=line2.replace("%%visiteMedicale%%", personne.getVisiteMedicale());
					
					line2=line2.replace("%%montantTransport%%", personne.getMontantTransport());
					
					line2=line2.replace("%%nbKm%%", personne.getNdKm());
					
					line2=line2.replace("%%nbCV%%", personne.getNbCV());
					
					line2=line2.replace("%%coefficient%%", personne.getCoeff());
					
					
					
					response.getWriter().append(line2 + "\n");
					
					
					
					
					line2 = bIn2.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bIn2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			fonctions.AfficherBasDePage(response);
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//ServletLoginTest");
			rd.forward(request, response);
		}
	}
}