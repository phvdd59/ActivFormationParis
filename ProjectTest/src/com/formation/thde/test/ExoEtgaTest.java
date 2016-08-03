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
	public void testSetCoordonneeCorrect() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "+33605040302");
		Assert.assertEquals("coordonnees tel OK", "+33605040302", exoEtga.getTel());
		Assert.assertEquals("coordonnees mail OK", "eleve@wanadoo.fr", exoEtga.getAdresseMail());
	}

	public void testSetCoordonneeMailIncorrect() {
		exoEtga.setCoordonnee("elevewanadoofr", "+33605040302");
		Assert.assertEquals("coordonnees mail pas OK", "pasbon@wanadoo.fr", exoEtga.getAdresseMail());
	}

	public void testSetCoordonneeTelLettres() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "numero");
		Assert.assertEquals("coordonnees tel pas OK", "+33600000000", exoEtga.getTel());
	}

	public void testSetCoordonneeTelTropLong() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "+336050403020100");
		Assert.assertEquals("coordonnees tel pas OK", "+33600000000", exoEtga.getTel());
	}

	@Test
	public void testSetMdpCacheCorrect() {
		exoEtga.setMdpCache("AbcdE1");
		Assert.assertEquals("mdp OK", "bAdc1E", exoEtga.getMdp());
	}

	public void testSetMdpCachePasLower() {
		exoEtga.setMdpCache("ABC0");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}

	public void testSetMdpCachePasUpper() {
		exoEtga.setMdpCache("abc0");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}

	public void testSetMdpCachePasNombre() {
		exoEtga.setMdpCache("aBcD");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}
}
