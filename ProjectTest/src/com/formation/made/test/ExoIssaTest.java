package com.formation.made.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.issa.metier.ExoIssa;

public class ExoIssaTest {

	ExoIssa exoIssa;

	@Before
	public void init() { // teste en rapport avec l'expemple en fait il faudrait remplacer Made par Issa
		exoIssa = new ExoIssa(); // ExoMade exoMade = new ExoMade();
	}

	@Test
	public void testSetTel() {// ceci est le test en rapport avec l'exemple numéro la aussi remplacer
		Assert.fail("Not yet implemented");
		// exoMade.setTel(06648587401);
		// Assert.assertEquals("numero de tel incorrect", "06648587401", ExoMade.getTel());
	}

	@Test
	public void testExoIssaString() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonneeOK() {
		exoIssa.setCoordonnee("monadresse@fournisseur.com", "+33661806482");
		Assert.assertEquals("monadresse@fournisseur.com", exoIssa.getAdressMail());
		Assert.assertEquals("+33661806482", exoIssa.getTel());
	}

	@Test
	public void testSetCoordonneeMailNull() {
		exoIssa.setCoordonnee(null, "+33661806482");
		Assert.assertEquals(null, exoIssa.getAdressMail());
		Assert.assertEquals("+33661806482", exoIssa.getTel());
	}

	@Test
	public void testSetCoordonneeTelNull() {
		exoIssa.setCoordonnee("monadresse@fournisseur.com", null);
		Assert.assertEquals("monadresse@fournisseur.com", exoIssa.getAdressMail());
		Assert.assertEquals(null, exoIssa.getTel());
	}
	@Test
	public void testSetCoordonneeMailsansarobase(){
		exoIssa.setCoordonnee("monadressefournisseur.com", "+33661806482");
		Assert.assertEquals(null, exoIssa.getAdressMail());
		Assert.assertEquals("+33661806482", exoIssa.getTel());
	}
	
	@Test
	public void testSetCoordonneeTelSansPlus(){
		exoIssa.setCoordonnee("monadresse@fournisseur.com", "33661806482");
		Assert.assertEquals("monadresse@fournisseur.com", exoIssa.getAdressMail());
		Assert.assertEquals(null, exoIssa.getTel());
	}
	public void testSetCoordonneeTelPlusLong(){
		exoIssa.setCoordonnee("monadresse@fournisseur.com", "33661806482");
		Assert.assertEquals("monadresse@fournisseur.com", exoIssa.getAdressMail());
		Assert.assertEquals(null, exoIssa.getTel());
	}
	
	

	@Test
	public void testSetMdpCache() {
		// ExoIssa.setMdp("AbCd1234");
		// String mdpCache = "bAdC2143";
		// Assert.assertEquals("Inversion bonne", (exoIssa.setMdpCache("AbCd1234") == mdpCache));
		//
		// String mdpCache = "bAdC 2143";
		// Assert.assertEquals("avec un espace", (exoIssa.setMdpCache("AbCd1234") == mdpCache));
		//
		// String mdpCache = "bacd2143";
		// Assert.assertEquals("sans majuscule", (exoIssa.setMdpCache("AbCd1234") == mdpCache));
		// Assert.fail("Not yet implemented");
	}

}
