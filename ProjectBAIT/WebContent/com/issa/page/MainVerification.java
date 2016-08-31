package com.formation.issa;

public class MainVerification {

	public static void main(String[] args) {
		MainVerification main=new MainVerification();
		main.init();
		

	}

	private void init() {
		
		VerificationsInscriptionPage1 verif =new VerificationsInscriptionPage1();
		String Identifiant="15Animalis";
		verif.fonctionIdentifiant(Identifiant);
		VerificationsInscriptionPage2 verif2=new VerificationsInscriptionPage2();
		String nom="De l'Alembert";
		verif2.fonctionNom(nom);
		String prenom="125Guillaumme";
		verif2.fonctionPrenom(prenom);
		String dateDeNaissance="HJ/JK/KL";
		verif2.fonctionDateDeNaissance(dateDeNaissance);
		String lieu="Paris45";
		verif2.fonctionLieu(lieu);
		String numeroDeSecuriteSociale="289031245545678";
		verif2.fonctionNumeroDeSecuriteSociale(numeroDeSecuriteSociale);
		VerificationsInscriptionPage3 verif3=new VerificationsInscriptionPage3();
		String adresse="24 rue de l'Aubrac";
		verif3.fonctionAdresse(adresse);
		String email="isma.safwat@gmail.com";
		verif3.fonctionEmail(email);
		VerificationsInscriptionPages4et5 verif4et5=new VerificationsInscriptionPages4et5();
		String autre="Au foyer";
		verif4et5.fonctionSituationActuelle(autre);
		String position="2.1";
		verif4et5.fonctionPosition(position);
		String fonctionOccupee="Consultant en informatique";
		verif4et5.fonctionFonctionOccupee(fonctionOccupee);
		String coefficient="230";
		String salaireSouhaite="36000";
		verif4et5.foncionSalaireSouhaite(salaireSouhaite);
	}

}
