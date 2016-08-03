package com.formation.thde.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.etga.metier.ExoEtga;

public class ExoEtgaTest {

	ExoEtga exoEtga;

	@Before
	public void init() {
		exoEtga = new ExoEtga();
	}

	@Test
	public void testSetTel() {
		exoEtga.setTel(0605040302);
		Assert.assertEquals("numero de tel incorrect", "+33605040302", exoEtga.getTel());
	}

	@Test
	public void testExoEtgaString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		//exoEtga.setDate(01-01-2000);
	}

	@Test
	public void testSetCoordonnee() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "+33000000001");
		Assert.assertEquals("coordonnees OK", "+33000000001", exoEtga.getTel());
		Assert.assertEquals("coordonnees OK", "eleve@wanadoo.fr", exoEtga.getAdresseMail());
		exoEtga.setCoordonnee("elevewanadoofr", "+33000000001");
		Assert.assertEquals("coordonnees pas OK", "nope@wanadoo.fr", exoEtga.getAdresseMail());
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "numero");
		Assert.assertEquals("coordonnees pas OK", "+33000000000", exoEtga.getTel());
	}

	@Test
	public void testSetMdpCache() {
		exoEtga.setMdpCache("AbcdE1");
		Assert.assertEquals("mdp OK", "bAdc1E", exoEtga.getMdp());
		exoEtga.setMdpCache("abc");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}

}
