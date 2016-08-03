package com.formation.etga.test;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.thde.metier.ExoThde;

public class ExoThdeTest {

	ExoThde exoThde;

	@Before
	public void init() {
		exoThde = new ExoThde();
	}

	@Test
	public void testSetTel() {
		exoThde.setTel(0601020304);
		Assert.assertEquals("num de tel incorrect", "+33600000000", exoThde.getTel());
	}

	@Test
	public void testExoThdeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		SimpleDateFormat dateEmbauche = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d = dateEmbauche.parse("01-02-2001");
			exoThde.setDate(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("date OK", "01-02-2001", exoThde.getDateEmbauche());
	}

	@Test
	public void testSetDateHS() {
		SimpleDateFormat dateEmbauche = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d1 = dateEmbauche.parse("13-12-2050");
			exoThde.setDate(d1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Assert.assertEquals("date pas OK", "01-01-1980", exoThde.getDateEmbauche());
	}

	@Test
	public void testSetCoordonnees() {
		exoThde.setCoordonnees("thde@gmail.com", "+33600123000");
		Assert.assertEquals("Mail OK", "thde@gmail.com", exoThde.getAdresseMail());
		Assert.assertEquals("Tel OK", "+33600123000", exoThde.getTel());
	}

	@Test
	public void testSetCoordonneesMailHS() {
		exoThde.setCoordonnees("thdegmail", "+33600123000");
		Assert.assertEquals("Mail Pas OK", "pasbon@wanadoo.fr", exoThde.getAdresseMail());
		Assert.assertEquals("Tel OK", "+33600123000", exoThde.getTel());
	}

	@Test
	public void testSetCoordonneesTelHS() {
		exoThde.setCoordonnees("thde@gmail.com", "060000000");
		Assert.assertEquals("Mail OK", "thde@gmail.com", exoThde.getAdresseMail());
		Assert.assertEquals("Tel Pas OK", "+33600000000", exoThde.getTel());
	}

	@Test
	public void testSetMdpCache() {
		exoThde.setMdpCache("ABcd08");
		Assert.assertEquals("Mdp OK", "BAdc80", exoThde.getMdp());
	}

	@Test
	public void testSetMdpCacheMdpHS() {
		exoThde.setMdpCache("@zi!!");
		Assert.assertEquals("Mdp Pas OK", "Abc0", exoThde.getMdp());
	}

}
