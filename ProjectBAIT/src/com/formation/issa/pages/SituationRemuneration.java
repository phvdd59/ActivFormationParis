package com.formation.issa.pages;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public class SituationRemuneration {
	String situation;
	private static String CHAMP_SITUATION = "sit";
	private static String CHAMP_FONCTION = "Fonction";
	private static String CHAMP_POSITION = "Position";
	private static String CHAMP_COEFF = "Coefficient";
	private static String CHAMP_SALAIRE = "SalaireS";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Candidat detaillerSituation(HttpServletRequest request) {
		String situation = getValeurChamp(request, CHAMP_SITUATION);
		String fonction = getValeurChamp(request, CHAMP_FONCTION);
		String position = getValeurChamp(request, CHAMP_POSITION);
		String coeff = getValeurChamp(request, CHAMP_COEFF);
		String salaire = getValeurChamp(request, CHAMP_SALAIRE);
		Candidat candidat = new Candidat();
		try {
			validationSituation(situation);
		} catch (Exception e) {
			setErreur(CHAMP_SITUATION, e.getMessage());
		}
		try{
			validationFonction(fonction);
		}catch(Exception e){
			setErreur(CHAMP_FONCTION, e.getMessage());
		}
		try{
			validationPosition(position);
		}catch(Exception e){
			setErreur(CHAMP_POSITION, e.getMessage());
		}
		try{
			validationCoeff(coeff);
		}catch(Exception e){
			setErreur(CHAMP_COEFF, e.getMessage());
		}
		try{
			validationSalaire(salaire);
		}catch(Exception e){
			setErreur(CHAMP_SALAIRE, e.getMessage());
		}
			
		return candidat;

	}

	private void validationSalaire(String salaire) throws Exception {
		if (salaire!=null){
			if(!salaire.matches("^[0-9]+[0-9\\,]*$")){
				throw new Exception("Merci de bien vouloir saisir un salaire correct");
			}
		}else{
			throw new Exception("Merci de bien vouloir saisir votre salaire.");
		}
		
	}

	private void validationCoeff(String coeff) throws Exception {
		if(coeff!=null){
			if(!coeff.matches("^[0-9]{1,4}$")){
				throw new Exception("Merci de bien vouloir saisir un coefficient correct.");
			}
		}else{
			throw new Exception("Merci de bien vouloir saisir votre coefficient.");
		}
		
	}

	private void validationPosition(String position) throws Exception {
		if(position!=null){
			if(!position.matches("^[0-9]+\\.[0-9]+[0-9\\.]*$")){
				throw new Exception("Merci de bien vouloir saisir une position correcte.");
			}
		}else{
			throw new Exception("Merci de bien vouloir saisir votre position.");
		}
		
	}

	private void validationFonction(String fonction) throws Exception {
		if (fonction != null) {
			if (!fonction.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir une fonction correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre fonction.");
		}	
		
	}

	private void validationSituation(String situation) throws Exception {
		if (situation != null) {
			if (!situation.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir une situation correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre situation.");
		}

	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);

	}

	private static String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}
