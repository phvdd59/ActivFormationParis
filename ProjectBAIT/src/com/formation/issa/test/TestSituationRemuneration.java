package com.formation.issa.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.pagesDeVerification.SituationRemuneration;

public class TestSituationRemuneration {
	
	SituationRemuneration situationRem=new SituationRemuneration();
	@Test
	public void testValidationSalaireNull() {
		String salaire=" ";
		Assert.assertFalse("salaire vide", situationRem.validationSalaire(salaire));
	
	}
	@Test
	public void testValidationSalaireAvecLettres() {
		String salaire="ADV4545";
		Assert.assertFalse("salaire incorrect", situationRem.validationSalaire(salaire));
	
	}
	@Test
	public void testValidationSalaireAvecCaracteresSpeciaux() {
		String salaire="45456/%@_-!";
		Assert.assertFalse("salaire incorrect", situationRem.validationSalaire(salaire));
	
	}
	@Test
	public void testValidationSalaireOK() {
		String salaire="450000";
		Assert.assertTrue("salaire correct", situationRem.validationSalaire(salaire));
	
	}
	@Test
	public void testValidationCoeffOK() {
		String coeff="478";
		Assert.assertTrue("coefficient correct", situationRem.validationCoeff(coeff));
	
	}
	@Test
	public void testValidationCoeffAvecLettres() {
		String coeff="478A";
		Assert.assertFalse("coefficient incorrect", situationRem.validationCoeff(coeff));
	
	}
	@Test
	public void testValidationCoeffNull() {
		String coeff=" ";
		Assert.assertFalse("coefficient vide", situationRem.validationCoeff(coeff));
	
	}
	@Test
	public void testValidationCoeffTropLong() {
		String coeff="4787894";
		Assert.assertFalse("coefficient incorrect", situationRem.validationCoeff(coeff));
	
	}
	@Test
	public void testValidationCoeffAvecCaracteresSpeciaux() {
		String coeff="47/%";
		Assert.assertFalse("coefficient incorrect", situationRem.validationCoeff(coeff));
	
	}
	@Test
	public void testValidationPositionAvecLettres() {
		String position="2Atl.5";
		Assert.assertFalse("position incorrecte", situationRem.validationPosition(position));
	
	}
	@Test
	public void testValidationPositionFormatNonOK() {
		String position="28.549";
		Assert.assertFalse("position incorrecte", situationRem.validationPosition(position));
	
	}
	@Test
	public void testValidationPositionNull() {
		String position=" ";
		Assert.assertFalse("position vide", situationRem.validationPosition(position));
	
	}
	@Test
	public void testValidationPositionOK() {
		String position="2.1.3";
		Assert.assertTrue("position correcte", situationRem.validationPosition(position));
	
	}
	@Test
	public void testValidationSituationOK() {
		String situation="En formation professionnelle";
		Assert.assertTrue("situation correcte", situationRem.validationSituation(situation));
	
	}
	@Test
	public void testValidationSituationNull() {
		String situation=" ";
		Assert.assertFalse("situation vide", situationRem.validationSituation(situation));
	
	}
	@Test
	public void testValidationSituationAvecChiffres() {
		String situation="Employé4568";
		Assert.assertFalse("situation incorrecte", situationRem.validationSituation(situation));
	
	}
	@Test
	public void testValidationSituationAvecCaracteresSpeciaux() {
		String situation="Employé!%@-_/";
		Assert.assertFalse("situation incorrecte", situationRem.validationSituation(situation));
	
	}
	@Test
	public void testValidationFonctionOK() {
		String fonction="Ingénieur de Production";
		Assert.assertTrue("fonction correcte", situationRem.validationFonction(fonction));
	
	}
	@Test
	public void testValidationFonctionNull() {
		String fonction=" ";
		Assert.assertFalse("fonction vide", situationRem.validationFonction(fonction));
	
	}
	@Test
	public void testValidationFonctionAvecChiffres() {
		String fonction="Ingénieur4568";
		Assert.assertFalse("fonction incorrecte", situationRem.validationFonction(fonction));
	
	}
	@Test
	public void testValidationFonctionAvecCaracteresSpeciaux() {
		String fonction="Qualititien!%@-_/";
		Assert.assertFalse("fonction incorrecte", situationRem.validationFonction(fonction));
	
	}
	@Test
	public void testValidationDateDeVisiteMedicaleFormatNonOK() throws ParseException{
		String dateVisiteMedicale="25/05/91";
		Assert.assertFalse("Format incorrect", situationRem.validationDateVisiteMedicale(dateVisiteMedicale));
	}
	
	@Test
	public void testValidationDateDeVisiteMedicaleOK() throws ParseException{
		String dateVisiteMedicale="14/03/1989";
		Assert.assertTrue("Date de visite correcte", situationRem.validationDateVisiteMedicale(dateVisiteMedicale));
	}
	@Test
	public void testValidationMontantTransportAvecCaracteresSpeciaux(){
		String montantTransport="454212022/%@_-!";
		Assert.assertFalse("montant de carte de transport incorrect", situationRem.validationMontantCarteTransport(montantTransport));
		
	}
	@Test
	public void testValidationMontantTransportNull() {
		String montantTransport=" ";
		Assert.assertFalse("montant de carte de transport vide", situationRem.validationMontantCarteTransport(montantTransport));
	
	}
	@Test
	public void testValidationMontantTransportAvecLettres() {
		String montantTransport="ADV4545454geTEE";
		Assert.assertFalse("montant de carte de transport incorrect", situationRem.validationMontantCarteTransport(montantTransport));
	
	}
	@Test
	public void testValidationMontantTransportOK() {
		String montantTransport="72,5";
		Assert.assertTrue("montant de carte de transport correct", situationRem.validationMontantCarteTransport(montantTransport));
	
	}
	@Test
	public void testNbCVOK(){
		String nbCV="5";
		Assert.assertTrue("nombre de CV correct", situationRem.validationNbCV(nbCV));
	}
	@Test
	public void testNbCVAvecLettres(){
		String nbCV="5ASDGlkj";
		Assert.assertFalse("nombre de CV incorrect", situationRem.validationNbCV(nbCV));
	}
	@Test
	public void testNbCVNull(){
		String nbCV=" ";
		Assert.assertFalse("nombre de CV vide", situationRem.validationNbCV(nbCV));
	}
	@Test
	public void testNbKmOK(){
		String nbKm="300,5";
		Assert.assertTrue("nombre de km correct", situationRem.validationNbKm(nbKm));
	}
	@Test
	public void testNbKmAvecLettres(){
		String nbKm="5ASDGlkj";
		Assert.assertFalse("nombre de km incorrect", situationRem.validationNbKm(nbKm));
	}
	@Test
	public void testNbKmNull(){
		String nbKm=" ";
		Assert.assertFalse("nombre de km vide", situationRem.validationNbKm(nbKm));
	}
	

}
