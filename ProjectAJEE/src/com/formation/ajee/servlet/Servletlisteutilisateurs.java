package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.Personne;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value = "/Servletlisteutilisateurs", name = "Servletlisteutilisateurs")

public class Servletlisteutilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ListPersonne lstUser;
	public Personne user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servletlisteutilisateurs() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		lstUser = new ListPersonne();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		if (boutonAjouter != null) {
			if (oNomA != null && oPrenomA != null) {
				String nomA = (String) oNomA;
				String prenomA = (String) oPrenomA;

				user = new Personne(nomA, prenomA);

				if (lstUser.size() == 0) { // quand bdd fonctionne plus de liste nulle ->adnim a ajoute direct dans bdd
					lstUser.add(user); // a supprimer
				} else {
					for (int i = 0; i < lstUser.size(); i++) {
//						if (lstUser.get(i).getPrenom().contains(prenomA) && lstUser.get(i).getNom().contains(nomA))
						if (lstUser.get(i).getIdentifiant().equals(nomA.substring(0,1)+"."+nomA.toLowerCase())) {
							existe = true;
							break;
						}
					}
					if (existe == false) {
						lstUser.add(user);
					}
				}

				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {

					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser.size(); i++) {
							String ligne = "<option value='%%value%%'></option>";
							ligne = ligne.replace("%%value%%", lstUser.get(i).getNom() + lstUser.get(i).getPrenom());
							ligne = ligne.replace("></", ">" + lstUser.get(i).getNom() + " " + lstUser.get(i).getPrenom() + "  -  Identifiant : " + lstUser.get(i).getIdentifiant() + " / Mot de passe : " + lstUser.get(i).getMdp() + "</");
							response.getWriter().println(ligne);

						}
					} else if (line.contains("%%existe%%")) {
						if (existe == true) {
							line = line.replace("%%existe%%", "onload='alert(\"Personne déjà existante\")'");
							existe = false;
						} else {
							line = line.replace("%%existe%%", "");
						}
					}

					response.getWriter().println(line);
					line = bIn.readLine();

				}

				bIn.close();

			} else {
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {
					if (line.contains("%%value%%")) {
						if (lstUser.size() == 0) { // a supprimer quand bdd fonctionne

						} else {
							for (int i = 0; i < lstUser.size(); i++) {
								String ligne = "<option value='%%value%%'></option>";
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

			}
		} else if (boutonSupp != null) {

			if (oNomB != null && oPrenomB != null) {
				String nomB = (String) oNomB;
				String prenomB = (String) oPrenomB;
				String commentaire = (String) oCommentaire;
				int indice = -1;

				for (int i = 0; i < lstUser.size(); i++) {
					if (lstUser.get(i).getPrenom().contains(prenomB) && lstUser.get(i).getNom().contains(nomB)) {
						lstUser.get(i).setBloque(true);
						lstUser.get(i).setRaisonBlocage(commentaire);
						indice = 1;
						break;
					}
				}
				if (indice == -1) {
					existe = true;
				}

				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {

					if (line.contains("%%value%%")) {
						for (int i = 0; i < lstUser.size(); i++) {
							String ligne = "";
							if (lstUser.get(i).getPrenom().contains(prenomB) && lstUser.get(i).getNom().contains(nomB)) {
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
					} else if (line.contains("%%existe%%")) {
						if (existe == true) {
							line = line.replace("%%existe%%", "onload='alert(\"Personne non trouvée - Nom et/ou prénom inconnus\")'");
							existe = false;
						} else {
							line = line.replace("%%existe%%", "");
						}
					}

					response.getWriter().println(line);
					line = bIn.readLine();

				}

				bIn.close();

			} else {
				File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
				BufferedReader bIn = new BufferedReader(new FileReader(file));
				String line = bIn.readLine();

				while (line != null) {
					if (line.contains("%%value%%")) {
						if (lstUser.size() == 0) {

						} else {
							for (int i = 0; i < lstUser.size(); i++) {
								String ligne = "<option value='%%value%%'></option>";
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

			}

		} else {
			File file = new File("../GITActivFormationParis/ProjectAJEE/WebContent/WEB-INF/com/formation/ajee/page/ListeUtilisateurs2.html");
			BufferedReader bIn = new BufferedReader(new FileReader(file));
			String line = bIn.readLine();

			while (line != null) {
				if (line.contains("%%value%%")) {
					if (lstUser.size() == 0) {

					} else {
						for (int i = 0; i < lstUser.size(); i++) {
							String ligne = "<option value='%%value%%'></option>";
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

		}

	}

}
