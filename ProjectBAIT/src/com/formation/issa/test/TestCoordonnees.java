package com.formation.issa.test;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.pagesDeVerification.Coordonnees;

public class TestCoordonnees {
	Coordonnees coordonnees = new Coordonnees();

	@Test
	public void testValidationTelFixeTropLong() {
		String telFixe = "006623547896455555";
		try {

			Assert.assertFalse("Numéro de téléphone incorrect", coordonnees.validationTelFixe(telFixe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationTelFixeAvecLettres() {
		String telFixe = "AD23470293";
		try {

			Assert.assertFalse("Numéro de téléphone incorrect", coordonnees.validationTelFixe(telFixe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationTelFixeNull() {
		String telFixe = " ";
		try {

			Assert.assertFalse("Numéro de téléphone vide", coordonnees.validationTelFixe(telFixe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationTelFixeCorrect() {
		String telFixe = "0623470293";
		try {

			Assert.assertTrue("Numéro de téléphone correcte", coordonnees.validationTelFixe(telFixe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationTelPortCorrect() {
		String telPort = "0623470293";
		try {

			Assert.assertTrue("Numéro de téléphone correcte", coordonnees.validationTelPort(telPort));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testValidationTelPortNull() {
		String telPort = " ";
		try {

			Assert.assertFalse("Numéro de téléphone vide", coordonnees.validationTelPort(telPort));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationTelPortTropLong() {
		String telPort = "006623547896455555";
		try {

			Assert.assertFalse("Numéro de téléphone incorrect", coordonnees.validationTelPort(telPort));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testValidationFaxTropLong() {
		String fax = "006623547896455555";
		try {

			Assert.assertFalse("Numéro de fax incorrect", coordonnees.validationFax(fax));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationFaxAvecLettres() {
		String fax = "AD23470293";
		try {

			Assert.assertFalse("Numéro de fax incorrect", coordonnees.validationFax(fax));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationFaxNull() {
		String fax = " ";
		try {

			Assert.assertFalse("Numéro de fax vide", coordonnees.validationFax(fax));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationFaxCorrect() {
		String fax = "0623470293";
		try {

			Assert.assertTrue("Numéro de fax correcte", coordonnees.validationFax(fax));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationCodePostalAvecLettres(){
		String codePostal="ADnlM";
		Assert.assertFalse("Code Postal incorrect", coordonnees.validationCodePostal(codePostal));
	}
	@Test
	public void testValidationCodePostalNull(){
		String codePostal=" ";
		Assert.assertFalse("Code Postal vide", coordonnees.validationCodePostal(codePostal));
	}
	@Test
	public void testValidationCodePostalTropLong(){
		String codePostal="1245454645";
		Assert.assertFalse("Code Postal incorrect", coordonnees.validationCodePostal(codePostal));
	}
	@Test
	public void testValidationCodePostalCorrect(){
		String codePostal="75015";
		Assert.assertTrue("Code Postal correct", coordonnees.validationCodePostal(codePostal));
	}



	@Test
	public void testValidationEmailNonConforme() {
		String email = "dupont.fr";
		try {

			Assert.assertFalse("Email incorrect", coordonnees.validationEmail(email));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testValidationEmailIncorrect() {
		String email = "@marie.schmit.fr";
		Assert.assertFalse("Email incorrect", coordonnees.validationEmail(email));

	}

	@Test
	public void testValidationEmailCorrect() {
		String email = "marie.schmidt@outlook.fr";
		Assert.assertTrue("Email correct", coordonnees.validationEmail(email));

	}
	@Test
	public void testValidationVilleAvecChiffres() {
		String ville = "455Berlin";
		Assert.assertFalse("Ville incorrecte", coordonnees.validationVille(ville));

	}
	@Test
	public void testValidationVilleAvecCaracteresSpeciaux() {
		String ville = "Berli/@%(n)";
		Assert.assertFalse("Ville incorrecte", coordonnees.validationVille(ville));

	}
	@Test
	public void testValidationVilleNull() {
		String ville = " ";
		Assert.assertFalse("Ville vide", coordonnees.validationVille(ville));

	}
	@Test
	public void testValidationVilleCorrecte() {
		String ville = "Berlin";
		Assert.assertTrue("Ville correcte", coordonnees.validationVille(ville));

	}

}
