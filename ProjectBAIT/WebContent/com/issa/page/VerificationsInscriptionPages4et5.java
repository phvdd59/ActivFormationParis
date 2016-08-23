package com.formation.issa;

public class VerificationsInscriptionPages4et5 {
	String autre;
	String fonctionOccupee;
	String position;
	String coeficient;
	String salaireSouhaite;
	
	public boolean fonctionSituationActuelle(String autre){
		boolean retour=false;
		if(autre==null || autre.length()<=0 || autre.matches(".*\\d+.*")){
			retour=false;
		}else{
			retour=true;;
		}
		
		
		return retour;
	}
	public boolean fonctionFonctionOccupee(String fonctionOccupee){
		boolean retour=false;
		if(fonctionOccupee==null || fonctionOccupee.length()<=0 || fonctionOccupee.matches(".*\\d+.*")){
			retour=false;
		}else{
			retour=true;;
		}
		return retour;
	}
	public boolean fonctionPosition(String position){
		boolean retour=false;
		if(position!=null && position.length()>0){
			retour=position.matches("^[0-9]+\\.[0-9]+[0-9\\.]*$");
		}
		return retour;
	}
	public boolean fonctionCoefficient(String coefficient){
		boolean retour=false;
		if(coefficient!=null && coefficient.length()>0){
			retour=coefficient.matches("^[0-9]{1,4}$");
		}
		return retour;
	}
	public boolean foncionSalaireSouhaite(String salaireSouhaite){
		boolean retour=false;
		if(salaireSouhaite!=null && salaireSouhaite.length()>0 && salaireSouhaite.matches(".*\\d+.*")){
			retour=true;
		}
		return retour;
		
	}

}
