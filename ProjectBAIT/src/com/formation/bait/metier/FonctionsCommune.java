package com.formation.bait.metier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import com.formation.beans.Perso;

public class FonctionsCommune {
	public static String HOST="localhost";
	public static String LOCAL="../GITActivFormationParis/ProjectBAIT/WebContent/";
	
	public static void INIT() {
		Properties props = new Properties();
		try {
			File file=new File("");
			String s="BAIT : "+file.getCanonicalPath();
			System.out.println(s);
			props.loadFromXML(new FileInputStream(new File("propsBAIT.xml")));
			HOST=props.getProperty("HOST");
			LOCAL=props.getProperty("LOCAL");
		} catch (InvalidPropertiesFormatException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	

	public void AfficherHautDePage(HttpServletResponse response) {
		File file = new File(FonctionsCommune.LOCAL+"WEB-INF/bait/pages/hautDePageActiv.html");
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
		File file3 = new File(FonctionsCommune.LOCAL+"WEB-INF/bait/pages/basDePageActiv.html");
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
		if (perso.getNom() == null) {
			personne.setNom("");
		} else {
			personne.setNom(perso.getNom());
		}
		if (perso.getPrenom() == null) {
			personne.setPrenom("");
		} else {
			personne.setPrenom(perso.getPrenom());
		}
		if (perso.getIdentifiant() == null) {
			personne.setIdentifiant("");
		} else {
			personne.setIdentifiant(perso.getIdentifiant());
		}
		if (perso.getMdp() == null) {
			personne.setMdp("12345");
		} else {
			personne.setMdp(perso.getMdp());
		}
		if (perso.getEmail() == null) {
			personne.setEmail("");
		} else {
			personne.setEmail(perso.getEmail());
		}
		if (perso.getAdresse() == null) {
			personne.setAdresse("");
		} else {
			personne.setAdresse(perso.getAdresse());
		}
		if (perso.getCp() == null) {
			personne.setcP("");
		} else {
			personne.setcP(perso.getCp());
		}
		if (perso.getVille() == null) {
			personne.setVille("");
		} else {
			personne.setVille(perso.getVille());
		}
		if (perso.getTelFixe() == null) {
			personne.setTelFixe("");
		} else {
			personne.setTelFixe(perso.getTelFixe());
		}
		if (perso.getTelPort() == null) {
			personne.setTelPort("");
		} else {
			personne.setTelPort(perso.getTelPort());
		}
		if (perso.getFax() == null) {
			personne.setFax("");
		} else {
			personne.setFax(perso.getFax());
		}
		if (perso.getDateNaissance() == null) {
			personne.setDateNaissance("");
		} else {
			personne.setDateNaissance(perso.getDateNaissance().toString());
		}
		if (perso.getLieuNaissance() == null) {
			personne.setLieuNaissance("");
		} else {
			personne.setLieuNaissance(perso.getLieuNaissance());
		}
		if (perso.getNumSecu() == null) {
			personne.setNumSecu("");
		} else {
			personne.setNumSecu(perso.getNumSecu());
		}
		if (perso.getNationalite() == null) {
			personne.setNationalite("");
		} else {
			personne.setNationalite(perso.getNationalite());
		}
		if (perso.getSituation() == null) {
			personne.setSituation(SITUATION.SALARIE);
		} else {
			personne.setSituation(perso.getSituation());
		}
		if (perso.getFonction() == null) {
			personne.setFonction("");
		} else {
			personne.setFonction(perso.getFonction());
		}
		if (perso.getPos() == null) {
			personne.setPosition("");
		} else {
			personne.setPosition(perso.getPos());
		}
		personne.setCadre(perso.isCadre());
		if (perso.getCoeff() == null) {
			personne.setCoeff("");
		} else {
			personne.setCoeff(perso.getCoeff());
		}
		if (perso.getSalaire() == null) {
			personne.setSalaire("");
		} else {
			personne.setSalaire(perso.getSalaire());
		}
		if (perso.getVisiteMedicale() == null) {
			personne.setVisiteMedicale("");
		} else {
			personne.setVisiteMedicale(perso.getVisiteMedicale().toString());
		}
		if (perso.getMontantTransport() == null) {
			personne.setMontantTransport("");
		} else {
			personne.setMontantTransport(perso.getMontantTransport());
		}
		personne.setVoiture(perso.isVoiture());
		personne.setNbCV(Integer.toString(perso.getNbCV()));
		if (perso.getNbKm() == null) {
			personne.setNdKm("");
		} else {
			personne.setNdKm(perso.getNbKm());
		}
		personne.setMutuelle(perso.isMutuelle());
		personne.setTicket(perso.isTicketResto());
		personne.setAdmin(perso.isAdmin());
		if (perso.getDateCreation() == null) {
			personne.setDateCreation("");
		} else {
			personne.setDateCreation(perso.getDateCreation().toString());
		}
		if (perso.getDateModification() == null) {
			personne.setDateModification("");
		} else {
			personne.setDateModification(perso.getDateModification().toString());
		}
		personne.setBloque(perso.isBloque());
		if (perso.getMontantTransport() == null) {
			personne.setMontantTransport("");
		} else {
			personne.setRaisonBlocage(perso.getMontantTransport());
		}
		if (personne.getIdentifiant().equals("Admin")) {
			personne.setAdmin(true);
		}
		return personne; 

	}
	// public Perso[] recupBDDAJEE(){
	// URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
	// QName qname = new QName("http://beans.formation.com/",
	// "PersoServiceService");
	// Service service = Service.create(wsdlURL, qname);
	// InterPersoService ps = service.getPort(InterPersoService.class);
	//
	// Perso[] pA= ps.getPersos();
	//
	//
	// return pA;
	//
	// }
	// public Perso[] recupBDDJMST(){
	// URL wsdlURL = new URL("http://192.168.33.145:8888/ws/jax?wsdl");
	// QName qname = new QName("http://beans.formation.com/",
	// "PersoServiceService");
	// Service service = Service.create(wsdlURL, qname);
	// InterPersoService ps = service.getPort(InterPersoService.class);
	//
	// Perso[] pA= ps.getPersos();
	//
	//
	// return pA;
	//
	// }
}
