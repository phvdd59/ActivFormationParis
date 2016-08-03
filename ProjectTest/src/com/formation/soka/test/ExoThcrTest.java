package com.formation.soka.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.soka.metier.ExoSoka;
import com.formation.thcr.metier.ExoThcr;

public class ExoThcrTest {

	ExoThcr exoThcr;
	ExoSoka exoSoka;

	@Before
	public void init() {
		exoThcr = new ExoThcr();
		exoSoka = new ExoSoka();
	}

	@Test
	public void testExoThcrString() {
		ExoThcr exoThcr2 = new ExoThcr("Thomas");
		Assert.assertEquals("Thomas", exoThcr2.getNom());
	}

	@Test
	public void testExoThcrStringFaux() {
		ExoThcr exoThcr2 = new ExoThcr("Thomas!");
		Assert.assertEquals("", exoThcr2.getNom());
	}

	@Test
	public void testExoThcrStringNumber() {
		ExoThcr exoThcr2 = new ExoThcr("Thoma2s");
		Assert.assertEquals("", exoThcr2.getNom());
	}

	@Test
	public void testExoThcrStringNull() {
		ExoThcr exoThcr2 = new ExoThcr(null);
		Assert.assertNull(exoThcr2.getNom());
	}

	@Test
	public void testSetDate() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		try {
			date = fd.parse("16-04-2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exoThcr.setDate(date);
		Assert.assertEquals("16-04-2016", exoThcr.getDateEmbauche());
	}

	//@Test
	public void testSetDateNull() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		try {
			date = fd.parse(null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exoThcr.setDate(date);
		Assert.assertNull(exoThcr.getDateEmbauche());
	}

	@Test
	public void testSetTel() {
		exoThcr.setCoordonnee("", "+33620598745");
		Assert.assertEquals("numero de tel correct", "+33620598745", exoThcr.getTel());
	}

	@Test
	public void testSetTel0() {
		exoThcr.setCoordonnee("", "0620598745");
		Assert.assertEquals("", exoThcr.getTel());
	}

	@Test
	public void testSetTel11() {
		exoThcr.setCoordonnee("", "+3362059874");
		Assert.assertEquals("", exoThcr.getTel());
	}

	@Test
	public void testSetTelAbcd() {
		exoThcr.setCoordonnee("", "+3362059874a");
		Assert.assertEquals("", exoThcr.getTel());
	}

	@Test
	public void testSetTelAFaux() {
		exoThcr.setCoordonnee("", "+3362059874!");
		Assert.assertEquals("", exoThcr.getTel());
	}

	@Test
	public void testSetCoordonnee() {
		String adresseMail = "thomas.cresson@gmail.com";
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertEquals(adresseMail, exoThcr.getAdresseMail());
		Assert.assertEquals(tel, exoThcr.getTel());
	}

	@Test
	public void testSetAdresse() {
		String adresseMail = "thomas.cresson@gmail.com";
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertEquals(adresseMail, exoThcr.getAdresseMail());
	}

	@Test
	public void testSetAdresseNull() {
		String adresseMail = null;
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertNull(adresseMail, exoThcr.getAdresseMail());
	}

	@Test
	public void testSetAdresseLowerCase() {
		String adresseMail = "thomas.cressON@gmail.com";
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertEquals(adresseMail.toLowerCase(), exoThcr.getAdresseMail());
	}

	@Test
	public void testSetAdresseFaux() {
		String adresseMail = "thomas.cresson@gmail.com!!";
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("", exoThcr.getAdresseMail());
	}
	
	@Test
	public void testSetAdresseFaux2() {
		String adresseMail = "thomas.cresson@gm@ail.com";
		String tel = "+33659874936";
		exoThcr.setCoordonnee(adresseMail, tel);
		Assert.assertEquals("", exoThcr.getAdresseMail());
	}

	@Test
	public void testSetMdpCacheImpair() {
		exoThcr.setMdpCache("bcdF3");
		Assert.assertEquals("cbFd3", exoThcr.getMdp());
	}

	@Test
	public void testSetMdpCachePair() {
		exoThcr.setMdpCache("abcdF3");
		Assert.assertEquals("badc3F", exoThcr.getMdp());
	}

	@Test
	public void testSetMdpCacheNull() {
		exoThcr.setMdpCache(null);
		//Assert.assertEquals(null, exoThcr.getMdp());
		Assert.assertNull(exoThcr.getMdp());
	}

}
