package com.formation.issa;

public class VerificationsInscriptionPage1 {
	
	String identifiant;
	String motDePasse;
	String VerifMotDePasse;
	//Verification Identifiant doit comprendre obligatoirement des caractères et des nombres.
	public  boolean fonctionIdentifiant(String Identifiant){
		Identifiant="15Animalis";
		boolean retour=false;
		if(Identifiant.matches("[\\w]+") && Identifiant.matches(".*\\d+.*")){
			retour=true;
		}else{
			retour=false;
		}
		return retour;
	}
	public boolean fonctionMotdePasse(String motdePasse){
		motdePasse="212125Abc";
		boolean retour=false;
		if(motdePasse.matches("[\\w]") && motdePasse.matches(".*\\d+.*")){
			retour=true;
		}
		
		return retour;
		
	}
	
	public boolean VerifierMotdePasse(String VerifMotDePasse){
		boolean retour=false;
		if(motDePasse.equals(VerifMotDePasse)){
			retour=true;
		}
		return retour;
		
	}
	
	

}
