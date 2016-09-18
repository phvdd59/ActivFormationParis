package com.formation.phva.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.phva.metier.ListeMeuble;
import com.formation.phva.metier.Meuble;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ServletJson
 */
@WebServlet("/ServletJson")
public class ServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** 1 envoi sous forme de liste de nomCommercial de meuble */
		String sJson = "[\"123 Table\",\"045 Table\",\"456 Chaise\",\"789 Chaise\",\"100 Armoire\",\"444 Cuisine\",\"777 Chambre\",\"444 Salon\"]";

		/** 2 envoi sous forme d'un meuble */
		//String sJson="{\"tri\":0,\"nomCommercial\":\"Table\",\"refAbrege\":\"123456780\",\"longueur\":160.0,\"largeur\":70.0,\"hauteur\":80.0,\"lstElmt\":[{\"numero\":1,\"nom\":\"Plan\",\"nb\":1,\"longueur\":160.0,\"largeur\":80.0,\"hauteur\":10.0,\"listeMateriaux\":[{\"nom\":\"BOIS\",\"densite\":0.6,\"solidite\":0,\"pourcent\":100}]},{\"numero\":1,\"nom\":\"Pied\",\"nb\":4,\"longueur\":70.0,\"largeur\":10.0,\"hauteur\":10.0,\"listeMateriaux\":[{\"nom\":\"FER\",\"densite\":7.4,\"solidite\":1,\"pourcent\":100}]}]}";

		
		/** 3 envoi sous forme d'un meuble a partir du metier*/
		//String refUnMeuble="123456789";
		//String sJson = initUnMeuble(refUnMeuble);

		response.setContentType("application/json, text/plain");
		response.getWriter().println(sJson);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public String initTousLesMeubles() {
		String json = "[]";
		ListeMeuble liste = new ListeMeuble();
		File file = new File("../GITActivFormationParis/ProjectIKAEPhva/ikae");
		if (file.exists()) {
			liste.chargeListeMeuble(file);

			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			json = gson.toJson(liste);
			json = json.replace("\"", "\\\"");
			System.out.println(json);
		}
		return json;
	}

	public String initUnMeuble(String ref) {
		String json = "[]";
		ListeMeuble liste = new ListeMeuble();
		File file = new File("../GITActivFormationParis/ProjectIKAEPhva/ikae");
		if (file.exists()) {
			liste.chargeListeMeuble(file);

			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			Meuble meuble=null;
			for (Meuble m : liste) {
				if (m.getRefAbrege().equals(ref)) {
					meuble=m;
					break;
				}
			}
			json = gson.toJson(meuble);
			json = json.replace("\"", "\\\"");
		}
		return json;
	}
}
