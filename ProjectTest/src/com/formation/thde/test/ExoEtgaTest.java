package com.formation.thde.test;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void testSetDateCorrecte() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = fd.parse("01-01-2000");
			exoEtga.setDate(d);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Assert.assertEquals("date correcte", "01-01-2000", exoEtga.getDateEmbauche());
	}

	@Test
	public void testSetDateFutur() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = fd.parse("01-01-2020");
			exoEtga.setDate(d);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Assert.assertEquals("date incorrecte", "01-01-1980", exoEtga.getDateEmbauche());
	}

	@Test
	public void testSetCoordonneeCorrect() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "+33605040302");
		Assert.assertEquals("coordonnees tel OK", "+33605040302", exoEtga.getTel());
		Assert.assertEquals("coordonnees mail OK", "eleve@wanadoo.fr", exoEtga.getAdresseMail());
	}

	@Test
	public void testSetCoordonneeMailIncorrect() {
		exoEtga.setCoordonnee("elevewanadoofr", "+33605040302");
		Assert.assertEquals("coordonnees mail pas OK", "pasbon@wanadoo.fr", exoEtga.getAdresseMail());
	}

	@Test
	public void testSetCoordonneeMailIncorrect2() {
		exoEtga.setCoordonnee("eleve@w@a@nadoo.fr", "+33605040302");
		Assert.assertEquals("coordonnees mail pas OK", "pasbon@wanadoo.fr", exoEtga.getAdresseMail());
	}

	@Test
	public void testSetCoordonneeTelLettres() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "numero");
		Assert.assertEquals("coordonnees tel pas OK", "+33600000000", exoEtga.getTel());
	}

	@Test
	public void testSetCoordonneeTelTropLong() {
		exoEtga.setCoordonnee("eleve@wanadoo.fr", "+336050403020100");
		Assert.assertEquals("coordonnees tel pas OK", "+33600000000", exoEtga.getTel());
	}

	@Test
	public void testSetMdpCacheCorrect() {
		exoEtga.setMdpCache("AbcdE1");
		Assert.assertEquals("mdp OK", "bAdc1E", exoEtga.getMdp());
	}

	@Test
	public void testSetMdpCachePasLower() {
		exoEtga.setMdpCache("ABC0");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}

	@Test
	public void testSetMdpCachePasUpper() {
		exoEtga.setMdpCache("abc0");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}

	@Test
	public void testSetMdpCachePasNombre() {
		exoEtga.setMdpCache("aBcD");
		Assert.assertEquals("mdp pas OK", "Abc0", exoEtga.getMdp());
	}
}
