package com.formation.issa.test;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.pages.EtatCivil;

public class TestEtatCivil {

	EtatCivil etatCivil = new EtatCivil();

	@Test
	public void testValidationNomNull() {
		String nom=" ";
		Assert.assertFalse("Nom vide", etatCivil.validationNom(nom));

	}
	@Test
	public void testValidationNomAvecChiffres() {
		String nom="455Thierry";
		Assert.assertFalse("Nom incorrect", etatCivil.validationNom(nom));

	}
	@Test
	public void testValidationNomAvecCaracteresSpeciaux() {
		String nom="Rudy/@_&";
		Assert.assertFalse("Nom incorrect", etatCivil.validationNom(nom));

	}
	@Test
	public void testValidationNomOk() {
		String nom="Rudy";
		Assert.assertTrue("Nom correct", etatCivil.validationNom(nom));

	}
	@Test
	public void testValidationPrenomNull() {
		String prenom=" ";
		Assert.assertFalse("Prenom vide", etatCivil.validationPrenom(prenom));

	}
	@Test
	public void testValidationPrenomAvecChiffres() {
		String prenom="455Thierry";
		Assert.assertFalse("Prenom incorrect", etatCivil.validationPrenom(prenom));

	}
	@Test
	public void testValidationPrenomAvecCaracteresSpeciaux() {
		String prenom="Rudy/@_&";
		Assert.assertFalse("Prenom incorrect", etatCivil.validationPrenom(prenom));

	}
	@Test
	public void testValidationPrenomOk() {
		String prenom="Rudy";
		Assert.assertTrue("Nom correct", etatCivil.validationPrenom(prenom));

	}
	@Test
	public void testValidationDateDeNaissanceFormatNonOK() throws ParseException{
		String dateDeNaissance="25/05/91";
		Assert.assertFalse("Format incorrect", etatCivil.validationDateDeNaissance(dateDeNaissance));
	}
	
	@Test
	public void testValidationDateDeNaissanceOK() throws ParseException{
		String dateDeNaissance="14/03/1989";
		Assert.assertTrue("Date de naissance correcte", etatCivil.validationDateDeNaissance(dateDeNaissance));
	}
	@Test
	public void testLieuAvecChiffres(){
		String lieu="Paris75";
		Assert.assertFalse("Lieu incorrect", etatCivil.validationLieu(lieu));
	}
	@Test
	public void testLieuAvecCaracteresSpeciaux(){
		String lieu="Paris/!@&";
		Assert.assertFalse("Lieu incorrect", etatCivil.validationLieu(lieu));
	}
	@Test
	public void testLieuNull(){
		String lieu=" ";
		Assert.assertFalse("Lieu vide", etatCivil.validationLieu(lieu));
	}
	@Test
	public void testLieuOK(){
		String lieu="Paris";
		Assert.assertTrue("Lieu correct", etatCivil.validationLieu(lieu));
	}
	@Test
	public void testNationaliteOK(){
		String nationalite="Française";
		Assert.assertTrue("Nationalité correcte", etatCivil.validationNationalite(nationalite));
	}
	@Test
	public void testNationaliteNonOK(){
		String nationalite="Française/4545{&)";
		Assert.assertFalse("Nationalité incorrecte", etatCivil.validationNationalite(nationalite));
	}
	@Test
	public void testNationaliteNull(){
		String nationalite=" ";
		Assert.assertFalse("Nationalité vide", etatCivil.validationNationalite(nationalite));
	}
	@Test
	public void testNumeroDeSecuNull(){
		String numeroDeSecuriteSociale=" ";
		Assert.assertFalse("Numéro de sécurité sociale vide", etatCivil.validationNumeroDeSecuriteSociale(numeroDeSecuriteSociale));
	}
	@Test
	public void testNumeroDeSecuAvecLettres(){
		String numeroDeSecuriteSociale="2 89 35 L5 ADF 456 45";
		Assert.assertFalse("Numéro de sécurité sociale incorrect", etatCivil.validationNumeroDeSecuriteSociale(numeroDeSecuriteSociale));
	}
	@Test
	public void testNumeroDeSecuTropCourt(){
		String numeroDeSecuriteSociale="2 89 35 45 789";
		Assert.assertFalse("Numéro de sécurité sociale incorrect", etatCivil.validationNumeroDeSecuriteSociale(numeroDeSecuriteSociale));
	}
	@Test
	public void testNumeroDeSecuTropLong(){
		String numeroDeSecuriteSociale="2 89 35 45 789 456 78 96 11";
		Assert.assertFalse("Numéro de sécurité sociale incorrect", etatCivil.validationNumeroDeSecuriteSociale(numeroDeSecuriteSociale));
	}
	@Test
	public void testNumeroDeSecuOk(){
		String numeroDeSecuriteSociale="2 89 35 45 789 456 78";
		Assert.assertTrue("Numéro de sécurité sociale correct", etatCivil.validationNumeroDeSecuriteSociale(numeroDeSecuriteSociale));
	}
	
	
	

}
