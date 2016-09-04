package com.formation.ajee.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.ajee.metier.DocPerso;
import com.formation.ajee.metier.ListPersonne;
import com.formation.ajee.metier.ListeDoc;
import com.formation.ajee.metier.Personne;

/**
 * Servlet implementation class ServletDocuments
 */
@WebServlet(value = "/MesDocuments", name = "Servletdocument")
public class Servletmesdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListeDoc listeDoc;
	private DocPerso doc;

	/** @see HttpServlet#HttpServlet() */
	public Servletmesdocuments() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		listeDoc = new ListeDoc();
	}

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
		
		HttpSession session = request.getSession();
		
		Object oPseudo = session.getAttribute("pseudo");
		Object utilisateur = session.getAttribute("utilisateur");
		if (oPseudo != null) {

			String pseudo = (String)oPseudo;
			if (pseudo.equals("Admin")) {
				if (utilisateur == null) {
					/** Lecture Haut de page HTML */
					File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
					BufferedReader bufReadHaut = null;
					bufReadHaut = new BufferedReader(new FileReader(fileHaut));
					String lineHaut = bufReadHaut.readLine();
					while (lineHaut != null) {
						if (lineHaut.contains("<title>Espace Personnel ActivConsulting</title>")) {
							lineHaut=lineHaut.replace("<title>Espace Personnel ActivConsulting</title>", "<title>Chargement</title>");
						}
						response.getWriter().println(lineHaut);
						lineHaut = bufReadHaut.readLine();
					}
					bufReadHaut.close();

					/** A modifier seulement si notre page contient du JavaScript */
					File fileJS = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSAccueilAdmin.html");
					BufferedReader bufReadJS = null;
					bufReadJS = new BufferedReader(new FileReader(fileJS));
					String lineJS = bufReadJS.readLine();
					while (lineJS != null) {
						response.getWriter().println(lineJS);
						lineJS = bufReadJS.readLine();
					}
					bufReadJS.close();

					File fileJS1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/js/JSBandeauAdmin.html");
					BufferedReader bufReadJS1 = null;
					bufReadJS1 = new BufferedReader(new FileReader(fileJS1));
					String lineJS1 = bufReadJS1.readLine();
					while (lineJS1 != null) {
						response.getWriter().println(lineJS1);
						lineJS1 = bufReadJS1.readLine();
					}
					bufReadJS1.close();

					/** Lecture page ActivConsulting */
					File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
					BufferedReader bufReadActiv = null;
					bufReadActiv = new BufferedReader(new FileReader(fileActiv));
					String lineActiv = bufReadActiv.readLine();
					while (lineActiv != null) {
						response.getWriter().println(lineActiv);
						lineActiv = bufReadActiv.readLine();
					}
					bufReadActiv.close();

					response.getWriter().println("Veuillez selectionner une personne dans la liste afin de voir ses documents");
					
					/**
					 * Seule Partie qui va vraiment changer selon les pages (penser aux
					 * controles si necessaire)
					 */
					File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
					BufferedReader bufReadDoc = null;
					bufReadDoc = new BufferedReader(new FileReader(fileDoc));
					String lineDoc = bufReadDoc.readLine();
					while (lineDoc != null) {
						if (lineDoc.contains("%pseudo%")) {
							lineDoc=lineDoc.replace("%pseudo%", pseudo);
						}
						if (lineDoc.contains("%utilisateur%")) {
							lineDoc=lineDoc.replace("%utilisateur%", ((utilisateur == null)?"":utilisateur.toString()));
						}
						response.getWriter().println(lineDoc);
						lineDoc = bufReadDoc.readLine();
					}
					bufReadDoc.close();

					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/AccueilAdmin.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();

					/** Lecture bas de page */
					File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
					BufferedReader bufReadBas = null;
					bufReadBas = new BufferedReader(new FileReader(fileBas));
					String lineBas = bufReadBas.readLine();
					while (lineBas != null) {
						response.getWriter().println(lineBas);
						lineBas = bufReadBas.readLine();
					}
					bufReadBas.close();
					
				} else {
					/** Lecture Haut de page HTML */
					File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
					BufferedReader bufReadHaut = null;
					bufReadHaut = new BufferedReader(new FileReader(fileHaut));
					String lineHaut = bufReadHaut.readLine();
					while (lineHaut != null) {
						response.getWriter().println(lineHaut);
						lineHaut = bufReadHaut.readLine();
					}
					bufReadHaut.close();

					/** Lecture page ActivConsulting */
					File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
					BufferedReader bufReadActiv = null;
					bufReadActiv = new BufferedReader(new FileReader(fileActiv));
					String lineActiv = bufReadActiv.readLine();
					while (lineActiv != null) {
						response.getWriter().println(lineActiv);
						lineActiv = bufReadActiv.readLine();
					}
					bufReadActiv.close();

					/** lecture du bandeau */
					File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BandeauAdmin.html");
					BufferedReader bufReadDoc = null;
					bufReadDoc = new BufferedReader(new FileReader(fileDoc));
					String lineDoc = bufReadDoc.readLine();
					while (lineDoc != null) {
						if (lineDoc.contains("%pseudo%")) {
							lineDoc = lineDoc.replace("%pseudo%", pseudo);
						}if (lineDoc.contains("%utilisateur%")) {
							lineDoc=lineDoc.replace("%utilisateur%", ((utilisateur == null)?"":utilisateur.toString()));
						}
						response.getWriter().println(lineDoc);
						lineDoc = bufReadDoc.readLine();
					}
					bufReadDoc.close();

					/** lecture du corp de page */
					
					Object oNomDocUtil = request.getParameter("nomDocUtil");
					Object oCommentaire = request.getParameter("commentaire");
					Object oTime = LocalDateTime.now();
					Object boutonAjouter = request.getParameter("ajouter");
					Object boutonSupp = request.getParameter("supprimer");
					Object boutonTel = request.getParameter("telecharger");
					
					if (boutonAjouter != null) {
						if ((oNomDocUtil != null) && (oCommentaire != null)) {
							String nomDocUtil = (String)oNomDocUtil;
							nomDocUtil = ((String)oNomDocUtil).substring(0, nomDocUtil.lastIndexOf(".")-1);
							String type = ((String)oNomDocUtil).substring(nomDocUtil.lastIndexOf(".")+1);
							long time = (long)oTime; 
							String nomDocFile = Long.toString(time);
							String commentaire = (String) oCommentaire;
						
							doc = new DocPerso(nomDocUtil, commentaire);		
							listeDoc.add(doc);

							File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
							BufferedReader bufReadDoc1 = null;
							bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
							String lineDoc1 = bufReadDoc1.readLine();
							while (lineDoc1 != null) {
								 if (lineDoc1.contains("%%value%%")) {
									for (int i = 0; i < listeDoc.size(); i++) { 
										lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
										lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
										response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
									}
								 }
								response.getWriter().println(lineDoc1);
								lineDoc1 = bufReadDoc1.readLine();
							}
							bufReadDoc1.close();	
						} else {
							File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
							BufferedReader bufReadDoc1 = null;
							bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
							String lineDoc1 = bufReadDoc1.readLine();
							while (lineDoc1 != null) {
								 if (lineDoc1.contains("%%value%%")) {
									 if (listeDoc.size() == 0) {
									} else {
										for (int i = 0; i < listeDoc.size(); i++) { 
											lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
											lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
											response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
										}
									}
								 }
								response.getWriter().println(lineDoc1);
								lineDoc1 = bufReadDoc1.readLine();
							}
							bufReadDoc1.close();
						}
					} else if (boutonSupp != null) {
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							 if (lineDoc1.contains("checked")) {
								for (int i = 0; i < listeDoc.size(); i++) { 
									lineDoc1 = lineDoc1.replace(listeDoc.get(i).getNomDocUtil(), "");
									listeDoc.remove(i);
									response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
								}
							 }
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();
					} else if (boutonTel != null) {
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							 if (lineDoc1.contains("checked")) {
								for (int i = 0; i < listeDoc.size(); i++) { 
									listeDoc.get(i).getIdDoc();
									// chercher le path de la bdd et  lire le file et reecrire dans un autre fichier
								}
							 }
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();
					} else {
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							if (lineDoc1.contains("%%value%%")) {
								for (int i = 0; i < listeDoc.size(); i++) { 
									lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
									lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
									response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
								}
							}
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();	
					}

					/** Lecture bas de page */
					File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
					BufferedReader bufReadBas = null;
					bufReadBas = new BufferedReader(new FileReader(fileBas));
					String lineBas = bufReadBas.readLine();
					while (lineBas != null) {
						response.getWriter().println(lineBas);
						lineBas = bufReadBas.readLine();
					}
					bufReadBas.close();
				}
			} else {
				/** Lecture Haut de page HTML */
				File fileHaut = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/HautPage.html");
				BufferedReader bufReadHaut = null;
				bufReadHaut = new BufferedReader(new FileReader(fileHaut));
				String lineHaut = bufReadHaut.readLine();
				while (lineHaut != null) {
					response.getWriter().println(lineHaut);
					lineHaut = bufReadHaut.readLine();
				}
				bufReadHaut.close();

				/** Lecture page ActivConsulting */
				File fileActiv = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/MenuActiv.html");
				BufferedReader bufReadActiv = null;
				bufReadActiv = new BufferedReader(new FileReader(fileActiv));
				String lineActiv = bufReadActiv.readLine();
				while (lineActiv != null) {
					response.getWriter().println(lineActiv);
					lineActiv = bufReadActiv.readLine();
				}
				bufReadActiv.close();

				/** lecture du bandeau */
				File fileDoc = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Bandeau.html");
				BufferedReader bufReadDoc = null;
				bufReadDoc = new BufferedReader(new FileReader(fileDoc));
				String lineDoc = bufReadDoc.readLine();
				while (lineDoc != null) {
					if (lineDoc.contains("%pseudo%")) {
						lineDoc = lineDoc.replace("%pseudo%", pseudo);
					}
					response.getWriter().println(lineDoc);
					lineDoc = bufReadDoc.readLine();
				}
				bufReadDoc.close();

				/** lecture du corp de page */
				
				Object oNomDocUtil = request.getParameter("nomDocUtil");
				Object oCommentaire = request.getParameter("commentaire");
				Object oTime = LocalDateTime.now();
				Object boutonAjouter = request.getParameter("ajouter");
				Object boutonSupp = request.getParameter("supprimer");
				Object boutonTel = request.getParameter("telecharger");
				
				if (boutonAjouter != null) {
					if ((oNomDocUtil != null) && (oCommentaire != null)) {
						String nomDocUtil = (String)oNomDocUtil;
						nomDocUtil = ((String)oNomDocUtil).substring(0, nomDocUtil.lastIndexOf(".")-1);
						String type = ((String)oNomDocUtil).substring(nomDocUtil.lastIndexOf(".")+1);
						long time = (long)oTime; 
						String nomDocFile = Long.toString(time);
						String commentaire = (String) oCommentaire;
					
						doc = new DocPerso(nomDocUtil, commentaire);		
						listeDoc.add(doc);

						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							 if (lineDoc1.contains("%%value%%")) {
								for (int i = 0; i < listeDoc.size(); i++) { 
									lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
									lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
									response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
								}
							 }
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();	
					} else {
						File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
						BufferedReader bufReadDoc1 = null;
						bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
						String lineDoc1 = bufReadDoc1.readLine();
						while (lineDoc1 != null) {
							 if (lineDoc1.contains("%%value%%")) {
								 if (listeDoc.size() == 0) {
								} else {
									for (int i = 0; i < listeDoc.size(); i++) { 
										lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
										lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
										response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
									}
								}
							 }
							response.getWriter().println(lineDoc1);
							lineDoc1 = bufReadDoc1.readLine();
						}
						bufReadDoc1.close();
					}
				} else if (boutonSupp != null) {
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						 if (lineDoc1.contains("checked")) {
							for (int i = 0; i < listeDoc.size(); i++) { 
								lineDoc1 = lineDoc1.replace(listeDoc.get(i).getNomDocUtil(), "");
								listeDoc.remove(i);
								response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
							}
						 }
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();
				} else if (boutonTel != null) {
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						 if (lineDoc1.contains("checked")) {
							for (int i = 0; i < listeDoc.size(); i++) { 
								listeDoc.get(i).getIdDoc();
								// chercher le path de la bdd et  lire le file et reecrire dans un autre fichier
							}
						 }
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();
				} else {
					File fileDoc1 = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/Documents.html");
					BufferedReader bufReadDoc1 = null;
					bufReadDoc1 = new BufferedReader(new FileReader(fileDoc1));
					String lineDoc1 = bufReadDoc1.readLine();
					while (lineDoc1 != null) {
						if (lineDoc1.contains("%%value%%")) {
							for (int i = 0; i < listeDoc.size(); i++) { 
								lineDoc1 = lineDoc1.replace("%%value%%", listeDoc.get(i).getNomDocUtil());
								lineDoc1 = lineDoc1.replace("></", ">" + listeDoc.get(i).getNomDocUtil() + "</");
								response.getWriter().println("<option value=\"%%value%%\"><input type=\"checkbox\"/></option>");
							}
						}
						response.getWriter().println(lineDoc1);
						lineDoc1 = bufReadDoc1.readLine();
					}
					bufReadDoc1.close();	
				}

				/** Lecture bas de page */
				File fileBas = new File("C:/DevFormation/GITActivFormationParis/ProjectAJEE/WebContent/ajee/page1/BasPage.html");
				BufferedReader bufReadBas = null;
				bufReadBas = new BufferedReader(new FileReader(fileBas));
				String lineBas = bufReadBas.readLine();
				while (lineBas != null) {
					response.getWriter().println(lineBas);
					lineBas = bufReadBas.readLine();
				}
				bufReadBas.close();
			}

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("//Servletidentification");
			rd.forward(request, response);
		}
	}
}
