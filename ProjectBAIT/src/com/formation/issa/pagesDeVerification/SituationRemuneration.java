package com.formation.issa.pagesDeVerification;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public boolean validationSalaire(String salaire) {
		boolean retour=false;
		if (salaire!=null){
			if(salaire.matches("^[0-9]+[0-9\\,.]*$")){
				retour=true;
			}
		}
		return retour;
	}

	public boolean validationCoeff(String coeff) {
		boolean retour=false;
		if(coeff!=null){
			if(coeff.matches("^[0-9]{1,4}$")){
				retour=true;
			}
		}
		return retour;
		
	}

	public boolean validationPosition(String position) {
		boolean retour=false;
		if(position!=null){
			if(position.matches("^[0-9]{1}\\.[0-9]{1}[0-9\\.]+$")){
				retour=true;
			}
		}
		return retour;
		
	}

	public boolean validationFonction(String fonction) {
		boolean retour=false;
		if (fonction != null) {
			if (fonction.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				retour=true;
			}
		}
		return retour; 
		
	}

	public boolean validationSituation(String situation) {
		boolean retour=false;
		if (situation != null) {
			if (situation.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				retour=true;
			}
		}
		return retour; 

	}
	public boolean validationDateVisiteMedicale(String dateVisiteMedicale) throws ParseException {
		boolean retour=false;
		final DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		final Date date = df.parse(dateVisiteMedicale);
		if(dateVisiteMedicale!=null){
			if (dateVisiteMedicale.length() == 10) {
				retour = true;
			}
		}
		return retour;
		
	}
	public boolean validationMontantCarteTransport(String montantTransport) {
		boolean retour=false;
		if (montantTransport!=null){
			if(montantTransport.matches("^[0-9]+[0-9\\,.]*$")){
				retour=true;
			}
		}
		return retour;
	}
	public boolean validationNbCV(String nbCV) {
		boolean retour=false;
		if(nbCV!=null){
			if(nbCV.matches("^[0-9]+$")){
				retour=true;
			}
		}
		return retour;
		
	}
	public boolean validationNbKm(String nbKm) {
		boolean retour=false;
		if (nbKm!=null){
			if(nbKm.matches("^[0-9]+[0-9\\,.]*$")){
				retour=true;
			}
		}
		return retour;
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
