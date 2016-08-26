package com.formation.ajee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.ajee.metier.Fichier;
import com.formation.ajee.metier.UploadForm;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String CHEMIN = "chemin";
	public static final String ATT_FICHIER = "fichier";
	public static final String ATT_FORM = "form";
	public static final String VUE = "../ProjectAJEE/WebContent/WEB-INF/upload.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'upload */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Lecture du param�tre 'chemin' pass� � la servlet via la d�claration dans le web.xml */
		String chemin = this.getServletConfig().getInitParameter(CHEMIN);
		/* Pr�paration de l'objet formulaire */
		UploadForm form = new UploadForm();
		/* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
		Fichier fichier = form.enregistrerFichier(request, chemin);
		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_FICHIER, fichier);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}