package com.formation.issa.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.pages.Inscription;

public class TestInscription {
	Inscription inscription=new Inscription();
	
	@Test
	public void testValidationMotsDePasseTropCourt() {
	String motDePasse="Ab/785";
	String verifMotDePasse="Ab/785";
	Assert.assertFalse("Mots de passe vides", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}
	
	@Test
	public void testValidationMotsDePasseNull() {
	String motDePasse=" ";
	String verifMotDePasse=" ";
	Assert.assertFalse("Mots de passe vides", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}

	@Test
	public void testValidationMotsDePasseNonIdentiques() {
	String motDePasse="L1589456";
	String verifMotDePasse="M7897412";
	Assert.assertFalse("Mot de passe non identique à la confirmation", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}
	
	@Test
	public void testValidationMotsDePasseNonOkChiffres() {
	String motDePasse="454454545454";
	String verifMotDePasse="454454545454";
	Assert.assertFalse("Mots de passe incorrects", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}
	@Test
	public void testValidationMotsDePasseNonOkLettres() {
	String motDePasse="AFDDFGSG";
	String verifMotDePasse="AFDDFGSG";
	Assert.assertFalse("Mots de passe incorrects", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}
	
	@Test
	public void testValidationMotsDePasseOK() {
	String motDePasse="Ani_78795";
	String verifMotDePasse="Ani_78795";
	Assert.assertTrue("Mots de passe corrects", inscription.validationMotsdePasse(motDePasse, verifMotDePasse));
	}
	@Test
	public void testValidationIdentifiantOK() {
	String identifiant="Jojo89";
	Assert.assertTrue("Identifiant correct", inscription.validationIdentifiant(identifiant));
	}
	@Test
	public void testValidationIdentifiantAvecCaracteresSpeciaux() {
	String identifiant="Jojo89$&@_-";
	Assert.assertFalse("Identifiant incorrect", inscription.validationIdentifiant(identifiant));
	}
	@Test
	public void testValidationIdentifiantTropCourt() {
	String identifiant="Jo";
	Assert.assertFalse("Identifiant incorrect", inscription.validationIdentifiant(identifiant));
	}
	@Test
	public void testValidationIdentifiantNull() {
	String identifiant=" ";
	Assert.assertFalse("Identifiant vide", inscription.validationIdentifiant(identifiant));
	}
	
	
	

}
