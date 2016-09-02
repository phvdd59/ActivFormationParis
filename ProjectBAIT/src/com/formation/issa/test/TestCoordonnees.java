package com.formation.issa.test;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.pages.Coordonnees;

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
		String telFixe = "0623470293";
		try {

			Assert.assertTrue("Numéro de téléphone correcte", coordonnees.validationTelFixe(telFixe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

}
