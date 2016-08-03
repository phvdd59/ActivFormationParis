package com.formation.emma.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.formation.ambr.metier.ExoAmbr;

public class ExoAmbrTest {

	ExoAmbr exoAmbr;

	@Before
	public void init() {
		exoAmbr = new ExoAmbr();
	}

	@Test
	public void testExoAmbrString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
//		SimpleDateFormat fd = new SimpleDateFormat("jj-mm-yyyy");
//		String s = fd.format(new Date());
//		//try catch Date d = fd.parse(s);
		fail("Not yet implemented");
	}

	@Test
	public void testTelSimple() {
		exoAmbr.setCoordonnee("mail@orange.fr", "0633212425");
		assertEquals("+3333212425" , exoAmbr.getTel());
	}
	
	@Test
	public void testTelIncorrect1() {
		exoAmbr.setCoordonnee("mail@orange.fr", "063331212425");
		assertNull(exoAmbr.getTel());
	}
	
	@Test
	public void testTelIncorrect2() {
		exoAmbr.setCoordonnee("mail@orange.fr", "06333z2425");
		assertNull(exoAmbr.getTel());
	}
	
	@Test
	public void testMailSimple() {
		exoAmbr.setCoordonnee("mail@orange.fr", "0633212425");
		assertEquals("mail@orange.fr" ,exoAmbr.getAdresseMail());
	}
	
	@Test
	public void testMailIncorrect1() {
		exoAmbr.setCoordonnee("mail@@orange.fr", "0633212425");
		assertNull(exoAmbr.getAdresseMail());
	}
	
	@Test
	public void testMailIncorrect2() {
		exoAmbr.setCoordonnee("mail@orange..fr", "0633212425");
		assertNull(exoAmbr.getAdresseMail());
	}

	@Test
	public void testMdpSimple() {
		exoAmbr.setMdpCache("oBjno2ru");
		assertEquals("Bonj2our", exoAmbr.getMdp());
	}

	@Test
	public void testMdpImpaire() {
		exoAmbr.setMdpCache("oBjn82uor");
		assertEquals("Bonj28our", exoAmbr.getMdp());}

	@Test
	public void testMdpCaractereSpe() {
		exoAmbr.setMdpCache("oB!jno2@ru");
		assertNull(exoAmbr.getMdp());}

	@Test
	public void testMdpContientChiffreLettreMajMin() {
		exoAmbr.setMdpCache("oBjnuor");
		assertNull(exoAmbr.getMdp());
	}

}
