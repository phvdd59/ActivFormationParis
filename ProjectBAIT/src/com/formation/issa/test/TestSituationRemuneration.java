package com.formation.issa.test;

import static org.junit.Assert.*;

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
	
	

}
