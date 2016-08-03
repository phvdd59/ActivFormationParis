package com.formation.joca.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.jeci.metier.ExoJeci;

public class ExoJeciTest {

	ExoJeci exo;

	@Before
	public void init() {
		exo = new ExoJeci();
	}

	@Test
	public void testExoJeciStringBon1() {
		ExoJeci exo2 = new ExoJeci("Crapal");
		Assert.assertEquals("Crapal", exo2.getNom());
	}

	@Test
	public void testExoJeciStringBon2() {
		ExoJeci exo2 = new ExoJeci("De Crapal");
		Assert.assertEquals("De Crapal", exo2.getNom());
	}

	@Test
	public void testExoJeciStringMauvais1() {
		ExoJeci exo2 = new ExoJeci("Crapal48");
		Assert.assertEquals("nom non valide", exo2.getNom());
	}

	@Test
	public void testExoJeciStringMauvais2() {
		ExoJeci exo2 = new ExoJeci("De_Crapal");
		Assert.assertEquals("nom non valide", exo2.getNom());
	}

	@Test
	public void testSetDateBon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDateMauvais1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDateMauvais2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonneeBon1() {
		exo.setCoordonnee("grenouille_mouillee@gmail.com", "0123456789");
		Assert.assertEquals("numero de telephone non valide", exo.getTel());
		Assert.assertEquals("grenouille_mouillee@gmail.com", exo.getAdresseMail());
		
	}

	@Test
	public void testSetCoordonneeBon2() {
		exo.setCoordonnee("grenouille_mouillee@gmail.com", "+33123456789");
		Assert.assertEquals("grenouille_mouillee@gmail.com", exo.getAdresseMail());
		Assert.assertEquals("+33123456789", exo.getTel());
	}

	@Test
	public void testSetCoordonneeMauvais1() {
		exo.setCoordonnee("grenouille_mouillee@gmail.com", "01234z6789");
		Assert.assertEquals("grenouille_mouillee@gmail.com", exo.getAdresseMail());
		Assert.assertEquals("numero de telephone non valide", exo.getTel());
	}

	@Test
	public void testSetCoordonneeMauvais2() {
		exo.setCoordonnee("grenouille_mouillee.gmail@com", "+33123456789");
		Assert.assertEquals("adresse mail non valide", exo.getAdresseMail());
		Assert.assertEquals("+33123456789", exo.getTel());
	}

	@Test
	public void testSetCoordonneeMauvais3() {
		exo.setCoordonnee("grenouille_mouillee#gmail.com", "+33123456789");
		Assert.assertEquals("adresse mail non valide", exo.getAdresseMail());
		Assert.assertEquals("+33123456789", exo.getTel());
	}

	@Test
	public void testSetMdpCacheBon() {
		exo.setMdpCache("eLeTtssEBtno0261");
		Assert.assertEquals("LeTestEstBon2016", exo.getMdp());
	}

	@Test
	public void testSetMdpCacheMauvais1() {
		exo.setMdpCache("eL eTtssEBtno0261");
		Assert.assertEquals("mot de passe non valide", exo.getMdp());
	}

	@Test
	public void testSetMdpCacheMauvais2() {
		exo.setMdpCache("elettssebtno0261*");
		Assert.assertEquals("mot de passe non valide", exo.getMdp());
	}

}
