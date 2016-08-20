package com.formation.issa;

public class VerificationsInscriptionPage3 {
	String adresse;
	String codePostal;
	String ville;
	String tel;
	String email;

	public boolean fonctionAdresse(String adresse) {
		boolean retour = false;
		if(adresse!=null && adresse.length()>0){
		retour=adresse.matches("^[0-9]{1,3}\\ [a-zA-Z]{2,6}\\ [a-zA-Z]{1,2}\\ [a-zA-Z]+[a-zA-Z\\'_-]*$");
		
		}
	
		return retour;

	}
	
	public boolean fonctionCodePostal(String codePostal){
		boolean retour=false;
		if(codePostal.matches(".*\\d+.*") && codePostal.length()==5){
			retour=true;
		}
		return retour;
	}
	
	public boolean fonctionTel(String tel){
		boolean retour=false;
		if(tel.matches(".*\\d+.*") && tel.length()==10){
			retour=true;
		}
		return retour;
		
	}
	
	public boolean fonctionEmail(String email){
		boolean retour=false;
		if(email!=null && email.length()>0){
			
			retour=email.matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$");
		}
		return retour;
		
	}
}
