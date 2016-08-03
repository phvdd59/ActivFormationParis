package com.formation.thcr.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.soka.metier.ExoSoka;

public class ExoSokaTest {

	ExoSoka exoSoka;

	@Before
	public void init() {
		exoSoka = new ExoSoka();
	}

	@Test
	public void testExoSokaNom() {
		//		Assert.fail("Nom incorrect");
		ExoSoka exo = new ExoSoka("Souad");
		Assert.assertEquals("Nom correct", "Souad", exo.getNom());
	}

	@Test
	public void testExoSokaNomNull() {
		//		Assert.fail("Nom incorrect");
		ExoSoka exo2 = new ExoSoka(null);
		Assert.assertNull("Nom correct", exo2.getNom());
	}

	@Test
	public void testExoSokaNomChar() {
		//		Assert.fail("Nom incorrect");
		ExoSoka exo = new ExoSoka("יט|");
		Assert.assertEquals("Nom correct", "", exo.getNom());
	}

	@Test
	public void testExoSokaNomChar2() {
		//		Assert.fail("Nom incorrect");
		ExoSoka exo = new ExoSoka("יטא");
		Assert.assertEquals("Nom correct", "יטא", exo.getNom());
	}

	@Test
	public void testExoSokaDate() {
		//		fail("Not yet implemented");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		try {
			date = simpleDateFormat.parse("20-04-2016");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exoSoka.setDate(date);
		System.out.println(exoSoka.getDateEmbauche());
		Assert.assertEquals("Date correct", simpleDateFormat.format(date),
				exoSoka.getDateEmbauche());

	}

	@Test
	public void testSetCoordonnee() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "jdhzzzf564@iejz.fr";
		String tel = "+33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", adresseMail, exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "+33202578412", exoSoka.getTel());

	}

	@Test
	public void testSetCoordonneeNull() {
		//fail("Mail ou Tel incorrect");
		exoSoka.setCoordonnee(null, null);
		Assert.assertNull("Mail correct", exoSoka.getAdresseMail());
		Assert.assertNull("Tel correct", exoSoka.getTel());

	}

	@Test
	public void testSetCoordonneeMailLowerCase() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "jDhzZZf564@iejz.com";
		String tel = "+33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "jdhzzzf564@iejz.com", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "+33202578412", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatMail() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaabbb.com";
		String tel = "+33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "+33202578412", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatMail2() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaa@bbbcom";
		String tel = "+33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "+33202578412", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatMail3() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaa.bbb@com";
		String tel = "33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatTel() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = null;
		String tel = "+332025712";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", null, exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatTel2() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaa@bbb.com";
		String tel = "33202578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "aaaaa@bbb.com", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatTel3() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaa@bbb.com";
		String tel = "33202khy578412";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "aaaaa@bbb.com", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "", exoSoka.getTel());
	}

	@Test
	public void testSetCoordonneeFormatTel4() {
		//fail("Mail ou Tel incorrect");
		String adresseMail = "aaaaa@bbb.com";
		String tel = "0305086032";
		exoSoka.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("Mail correct", "aaaaa@bbb.com", exoSoka.getAdresseMail());
		Assert.assertEquals("Tel correct", "", exoSoka.getTel());
	}

	@Test
	public void testSetMdp() {
		String mdpCache = "a1B3C56ER";
		exoSoka.setMdp(mdpCache);
		Assert.assertEquals("Mdp correct", "1a3B5CE6R", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMdp2() {
		String mdpCache = "a1B3C56E";
		exoSoka.setMdp(mdpCache);
		Assert.assertEquals("Mdp correct", "1a3B5CE6", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMdpNull() {
		exoSoka.setMdp(null);
		Assert.assertNull("Mdp correct", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMdpFormat() {
		String mdpCache = "aaaaa";
		exoSoka.setMdp(mdpCache);
		Assert.assertEquals("Mdp correct", "", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMdpFormat2() {
		String mdpCache = "aaAAa";
		exoSoka.setMdp(mdpCache);
		Assert.assertEquals("Mdp correct", "", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMdpFormat3() {
		String mdpCache = "30FT54A";
		exoSoka.setMdp(mdpCache);
		Assert.assertEquals("Mdp correct", "", exoSoka.getMdp());
		//fail("Not yet implemented");
	}

}
