package com.formation.beba.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.anfr.metier.ExoAnfr;

public class ExoAnfrTest {

	ExoAnfr exoAnfr;

	@Before
	public void init() {
		exoAnfr = new ExoAnfr();
	}

	@Test
	public void testSetMdpCache() {

		exoAnfr.setMdpCache("bAdCfE2gaeaeaeae");
		Assert.assertEquals("mdp OK", "AbCdEfg2eaeaeaea", exoAnfr.getMdp());
		System.out.println();

	}

	@Test
	public void testSetMdpCache2() {

		exoAnfr.setMdpCache("bAdCfEg");
		Assert.assertEquals("mdp OK", null, exoAnfr.getMdp());
		System.out.println();

	}

	@Test
	public void testsetCoordonnée() {

		exoAnfr.setCoordonee("b.basdevant@gmail.com", "0682096369");
		Assert.assertEquals("b.basdevant@gmail.com", exoAnfr.getAdresseMail());
		System.out.println();

	}

	@Test
	public void testsetCoordonnée2() {

		exoAnfr.setCoordonee("b_basdevant@gmail.com", "0682096369");
		Assert.assertEquals("b_basdevant@gmail.com", exoAnfr.getAdresseMail());
		System.out.println();

	}

	@Test
	public void testsetCoordonnée3() {

		exoAnfr.setCoordonee("b.basdevant@gmail.co", "+33682096369");
		Assert.assertEquals("+33682096369", exoAnfr.getTel());
		System.out.println();

	}
	// @Test
	// public void testSetDate() {
	// exoAnfr.setDateEmbauche(10022012);
	// Assert.assertEquals("Gros nab ça ne marche pas 2", "16-02-2012",
	// exoAnfr.getDateEmbauche());
	// }
	// @Test
	// public void testExoAnfr() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testExoAnfrString() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetNom() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetDateEmbauche() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetCoordonee() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetMdpCache() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetAdresseMail() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetDateEmbauche() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetTel() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetMdp() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetNom() {
	// fail("Not yet implemented");
	// }

}
