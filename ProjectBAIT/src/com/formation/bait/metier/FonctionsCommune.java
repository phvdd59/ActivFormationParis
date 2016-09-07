package com.formation.bait.metier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

public class FonctionsCommune {

	public void AfficherHautDePage(HttpServletResponse response) {
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // pour
			// texte
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				// System.out.println(line);
				response.getWriter().append(line + "\n");
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void AfficherBasDePage(HttpServletResponse response) {
		File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/basDePageActiv.html");
		BufferedReader bIn3 = null;
		InputStreamReader inputStreamReader3 = null;
		try

		{
			inputStreamReader3 = new InputStreamReader(new FileInputStream(file3), "UTF-8");
			bIn3 = new BufferedReader(inputStreamReader3);
			String line3 = bIn3.readLine();
			while (line3 != null) {
				// System.out.println(line);
				response.getWriter().append(line3);
				line3 = bIn3.readLine();
			}
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				bIn3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Personne PersoVersPerso(Perso tabPerso) {

		;
		
			Personne personne = new Personne();
			Perso perso = tabPerso;
			personne.setIdPersonne(perso.getIdPersonne());
			personne.setNom(perso.getNom());
			personne.setPrenom(perso.getPrenom());
			personne.setIdentifiant(perso.getIdentifiant());
			personne.setMdp(perso.getMdp());
			personne.setEmail(perso.getEmail());
			personne.setAdresse(perso.getAdresse());
			personne.setcP(perso.getCp());
			personne.setVille(perso.getVille());
			personne.setTelFixe(perso.getTelFixe());
			personne.setTelPort(perso.getTelPort());
			personne.setFax(perso.getFax());
			personne.setDateNaissance(perso.getDateNaissance().toString());
			personne.setLieuNaissance(perso.getLieuNaissance());
			personne.setNumSecu(perso.getNumSecu());
			personne.setNationalite(perso.getNationalite());
			personne.setSituation(perso.getSituation());
			personne.setFonction(perso.getFonction());
			personne.setPosition(perso.getPos());
			personne.setCadre(perso.isCadre());
			personne.setCoeff(perso.getCoeff());
			personne.setSalaire(perso.getSalaire());
			personne.setVisiteMedicale(perso.getVisiteMedicale().toString());
			personne.setMontantTransport(perso.getMontantTransport());
			personne.setVoiture(perso.isVoiture());
			personne.setNbCV(Integer.toString(perso.getNbCV()));
			personne.setNdKm(perso.getNbKm());
			personne.setMutuelle(perso.isMutuelle());
			personne.setTicket(perso.isTicketResto());
			personne.setAdmin(perso.isAdmin());
			personne.setDateCreation(perso.getDateCreation().toString());
			personne.setDateModification(perso.getDateModification().toString());
			personne.setBloque(perso.isBloque());
			personne.setRaisonBlocage(perso.getMontantTransport());

		return personne;

	}
//	public Perso[] recupBDDAJEE(){
//		URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
//		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
//		Service service = Service.create(wsdlURL, qname);
//		InterPersoService ps = service.getPort(InterPersoService.class);
//		
//		Perso[] pA= ps.getPersos();
//		
//		
//		return pA;
//		
//	}
//	public Perso[] recupBDDJMST(){
//		URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
//		QName qname = new QName("http://beans.formation.com/", "PersoServiceService");
//		Service service = Service.create(wsdlURL, qname);
//		InterPersoService ps = service.getPort(InterPersoService.class);
//		
//		Perso[] pA= ps.getPersos();
//		
//		
//		return pA;
//		
//	}
}
