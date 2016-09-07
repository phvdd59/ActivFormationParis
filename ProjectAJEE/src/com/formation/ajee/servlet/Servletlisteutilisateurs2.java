package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.veriffom.Vue;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value = "/Servletlisteutilisateurs2", name = "Servletlisteutilisateurs2")

public class Servletlisteutilisateurs2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ListPersonne lstUser2;
	public ListPersonne lstUser;
	public Personne user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletlisteutilisateurs2() {
		super();
	}

//	public void init(ServletConfig config) throws ServletException {
//		lstUser2 = new ListPersonne();
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("//Servletidentification");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object oNoSerie = session.getAttribute("noSerie");
		Personne personne = (Personne) session.getAttribute("personne");
		Personne utilisateur = (Personne) session.getAttribute("utilisateur");
		Vue vue = new Vue();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Object oNomA = request.getParameter("nomA");
		Object oPrenomA = request.getParameter("prenomA");
		Object oNomB = request.getParameter("nomB");
		Object oPrenomB = request.getParameter("prenomB");
		Object oCommentaire = request.getParameter("commentaire");
		Object boutonAjouter = request.getParameter("ajouter");
		Object boutonSupp = request.getParameter("supprimer");
		boolean existe = false;
		lstUser2 = new ListPersonne();
		
		if (oNoSerie != null && personne != null&& personne.getIdentifiant() != null) {
		if (boutonAjouter != null) {
			if (oNomA != "" && oPrenomA != "") {
				String nomA = (String) oNomA;
				String prenomA = (String) oPrenomA;
				user = new Personne(nomA, prenomA);
				user.setMdp(user.creationMdp());
				user.setIdentifiant(user.creationId(nomA, prenomA));

				for (int i = 0; i < lstUser2.size(); i++) {
					if (lstUser2.get(i).getIdentifiant().equals(user.getIdentifiant())) {
						existe = true;
						break;
					}
				}
				if (existe == false) {
					user.ajoutPersonne(user.getIdPersonne());
					
				}
				lstUser = new ListPersonne();
				
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");

				vue.lecturePage(response, "JSBandeauAdmin");

				/** Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					if (lineActiv.contains("<body>")) {
						if (existe == true) {
							lineActiv = lineActiv.replace("<body>", "<body onload='alert(\"Personne déjà existante\")'>");
							existe = false;
						} 
					}
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();

				/** Lecture bandeau */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/** Lecture page liste utilisateurs */
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {

					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser.size(); i++) {
							String ligne = "";
							if (lstUser.get(i).isBloque() == true) {
								ligne = "<option style=\"color:red;\" value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser.get(i).getNom() + lstUser.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser.get(i).getNom() + " " + lstUser.get(i).getPrenom() + " " + "  -  Identifiant : " + lstUser.get(i).getIdentifiant() + " / Mot de passe : " + lstUser.get(i).getMdp() + " / BLOQUE :" + lstUser.get(i).getRaisonBlocage() + "</");
								response.getWriter().println(ligne);
							} else {
								ligne = "<option value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser.get(i).getNom() + lstUser.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser.get(i).getNom() + " " + lstUser.get(i).getPrenom() + "  -  Identifiant : " + lstUser.get(i).getIdentifiant() + " / Mot de passe : " + lstUser.get(i).getMdp() + "</");
								response.getWriter().println(ligne);
							}
						}
					}

					response.getWriter().println(line);
					line = bIn.readLine();

				}

				bIn.close();
				
				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");

			} else {

				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				
				vue.lecturePage(response, "JSBandeauAdmin");

				/** Lecture page ActivConsulting */
				vue.lecturePage(response, "MenuActiv");

				/** Lecture bandeau */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/** Lecture page liste utilisateurs */
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {
					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser2.size(); i++) {
							String ligne = "";
							if (lstUser2.get(i).isBloque() == true) {
								ligne = "<option style=\"color:red;\" value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + " " + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + " / BLOQUE :" + lstUser2.get(i).getRaisonBlocage() + "</");
								response.getWriter().println(ligne);
							} else {
								ligne = "<option value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + "</");
								response.getWriter().println(ligne);
							}
						}
					}
					response.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();
				
				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");

			}
		} else if (boutonSupp != null) {

			if (oNomB != "" && oPrenomB != "") {
				String nomB = (String) oNomB;
				String prenomB = (String) oPrenomB;
				String commentaire = (String) oCommentaire;
				int indice = -1;

				user = new Personne(nomB, prenomB);
				user.setMdp(user.creationMdp());
				user.setIdentifiant(user.creationId(nomB, prenomB));

				for (int i = 0; i < lstUser2.size(); i++) {

					if (lstUser2.get(i).getIdentifiant().equals(user.getIdentifiant())) {
						lstUser2.get(i).setBloque(true);
						lstUser2.get(i).setRaisonBlocage(commentaire);
						lstUser2.get(i).modifPersonne(lstUser2.get(i).getIdPersonne());
						indice = 1;
						break;
					}
				}
				if (indice == -1) {
					existe = true;
				}

				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");
				
				vue.lecturePage(response, "JSBandeauAdmin");

				/** Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					if (lineActiv.contains("<body>")) {
						if (existe == true) {
							lineActiv = lineActiv.replace("<body>", "<body onload='alert(\"Personne non trouvée - Nom et/ou prénom inconnus\")'>");
							existe = false;
						} 
					}
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();

				/** Lecture bandeau */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/** Lecture page liste utilisateurs */
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {

					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser2.size(); i++) {
							String ligne = "";
							if (lstUser2.get(i).isBloque() == true) {
								ligne = "<option style=\"color:red;\" value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + " " + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + " / BLOQUE :" + lstUser2.get(i).getRaisonBlocage() + "</");
								response.getWriter().println(ligne);
							} else {
								ligne = "<option value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + "</");
								response.getWriter().println(ligne);
							}
						}
					}
					response.getWriter().println(line);
					line = bIn.readLine();
				}

				bIn.close();
				
				/** Lecture bas de page */
				vue.lecturePage(response, "BasPage");

			} else {
				/** Lecture Haut de page HTML */
				vue.lecturePage(response, "HautPage");

				vue.lecturePage(response, "JSBandeauAdmin");

				/** Lecture page ActivConsulting */
				vue.lecturePage(response, "MenuActiv");

				/** Lecture bandeau */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
					}
					if (lineDoc.contains("%utilisateur%")) {
						lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/** Lecture page liste utilisateurs */
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {
					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser2.size(); i++) {
							String ligne = "";
							if (lstUser2.get(i).isBloque() == true) {
								ligne = "<option style=\"color:red;\" value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + " " + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + " / BLOQUE :" + lstUser2.get(i).getRaisonBlocage() + "</");
								response.getWriter().println(ligne);
							} else {
								ligne = "<option value='%%value%%'></option>";
								ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
								ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + "</");
								response.getWriter().println(ligne);
							}
						}
					}
					response.getWriter().println(line);
					line = bIn.readLine();
				}
				bIn.close();

			/** Lecture bas de page */
			vue.lecturePage(response, "BasPage");
			}
		} else {
			/** Lecture Haut de page HTML */
			vue.lecturePage(response, "HautPage");
			
			vue.lecturePage(response, "JSBandeauAdmin");

			/** Lecture page ActivConsulting */
			vue.lecturePage(response, "MenuActiv");

			/** Lecture bandeau */
			File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
			BufferedReader bufReadDoc = null;
			bufReadDoc = new BufferedReader(new FileReader(fileDoc));
			String lineDoc = bufReadDoc.readLine();
			while (lineDoc != null) {
				if (lineDoc.contains("%pseudo%")) {
					lineDoc = lineDoc.replace("%pseudo%", personne.getIdentifiant());
				}
				if (lineDoc.contains("%utilisateur%")) {
					lineDoc = lineDoc.replace("%utilisateur%", ((utilisateur == null) ? "" : utilisateur.getIdentifiant()));
				}
				response.getWriter().println(lineDoc);
				lineDoc = bufReadDoc.readLine();
			}
			bufReadDoc.close();

			/** Lecture page liste utilisateurs */
			File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				if (line.contains("%%value%%")) {
					for (int i = 0; i < lstUser2.size(); i++) {
						String ligne = "";
						if (lstUser2.get(i).isBloque() == true) {
							ligne = "<option style=\"color:red;\" value='%%value%%'></option>";
							ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
							ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + " " + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + " / BLOQUE :" + lstUser2.get(i).getRaisonBlocage() + "</");
							response.getWriter().println(ligne);
						} else {
							ligne = "<option value='%%value%%'></option>";
							ligne = ligne.replace("%%value%%", lstUser2.get(i).getNom() + lstUser2.get(i).getPrenom());
							ligne = ligne.replace("></", ">" + lstUser2.get(i).getNom() + " " + lstUser2.get(i).getPrenom() + "  -  Identifiant : " + lstUser2.get(i).getIdentifiant() + " / Mot de passe : " + lstUser2.get(i).getMdp() + "</");
							response.getWriter().println(ligne);
						}
					}
				}
				response.getWriter().println(line);
				line = bIn.readLine();
			}
			bIn.close();
			
			/** Lecture bas de page */
			vue.lecturePage(response, "BasPage");
		}
		
		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}
	
}
