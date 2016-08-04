package com.formation.anfr.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.beba.metier.ExoBeba;

public class ExoBebaTest {

	ExoBeba exoBeba;
	@Before
	public void init() {
		exoBeba=new ExoBeba();
	}
	
//	@Test 
//	public void testSetTel() {
//		exoBeba.setTel(605040302);
//		Assert.assertEquals("numero de tel incorrect","0605040302", exoBeba.getTel());
//		
//	}


	@Test
	public void testSetDate() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		   try {
			   Date date = fd.parse("15-03-1968");
			   exoBeba.setDate(date);
			   Assert.assertEquals("Pas la Bonne Adresse","15-03-1968", exoBeba.getDateEmbauche());
			    } catch (ParseException e) {
			      e.printStackTrace();
			    }
	}
	@Test
	public void testSetDate2() {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		   try {
			   Date date = fd.parse("23-06-1968");
			   exoBeba.setDate(null);
			   Assert.assertEquals("Pas la Bonne Adresse",null, exoBeba.getDateEmbauche());
			    } catch (ParseException e) {
			      e.printStackTrace();
			    }
	}

	@Test
	public void testSetCoordonnee() {
		exoBeba.setCoordonnee("antoine.tan.frere@gmail.com", "+33687070737");
		 Assert.assertEquals("Pas le bon numéro","+33687070737", exoBeba.getTel());
		 Assert.assertEquals("Pas le bon mail","antoine.tan.frere@gmail.com", exoBeba.getAdresseMail());
	}
//	@Test
//	public void testSetCoordonnee3() {
//		exoBeba.setCoordonnee(null,null);
//		 Assert.assertEquals("Pas le bon numéro",null, exoBeba.getTel());
//		 Assert.assertEquals("Pas le bon mail",null, exoBeba.getAdresseMail());
//	}
	@Test
	public void testSetCoordonnee2() {
		exoBeba.setCoordonnee("antoine=.tan.frere@gmail.com", "+3368A070737");
		 Assert.assertEquals("Pas le bon numéro",null, exoBeba.getTel());
		 Assert.assertEquals("Pas le bon mail",null, exoBeba.getAdresseMail());
	}

	@Test
	public void testSetMdpCache() {
		exoBeba.setMdpCache("AaBb01");
		 Assert.assertEquals("Pas le bon numéro","aAbB10", exoBeba.getMdp());
	}
	@Test
	public void testSetMdpCacheImpair() {
		exoBeba.setMdpCache("AaBb011");
		 Assert.assertEquals("Pas le bon numéro","aAbB101", exoBeba.getMdp());
	}
	@Test
	public void testSetMdpCacheQueDesChiffres() {
		exoBeba.setMdpCache("121212");
		 Assert.assertEquals("Pas le bon numéro",null, exoBeba.getMdp());
	}
	@Test
	public void testSetMdpCacheQueDesLettresSM() {
		exoBeba.setMdpCache("abcdef");
		 Assert.assertEquals("Pas le bon numéro",null, exoBeba.getMdp());
	}
	@Test
	public void testSetMdpCachePasBonChar() {
		exoBeba.setMdpCache("abcde#");
		 Assert.assertEquals("Pas le bon numéro",null, exoBeba.getMdp());
	}
}
