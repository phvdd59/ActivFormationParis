package com.formation.joca.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.joca.metier.ExoJoca;

public class ExoJocaTest {
	ExoJoca exo;

	@Before
	public void init() {
		exo = new ExoJoca();
	}

	@Test
	public void testExoJocaStringBon1() {
		ExoJoca exo2 = new ExoJoca("Crapal");
		Assert.assertEquals("Crapal", exo2.getNom());
	}

	@Test
	public void testExoJocaStringBon2() {
		ExoJoca exo2 = new ExoJoca("De Crapal");
		Assert.assertEquals("De Crapal", exo2.getNom());
	}

	@Test
	public void testExoJocaStringMauvais1() {
		ExoJoca exo2 = new ExoJoca("Crapal48");
		Assert.assertEquals("nom non valide", exo2.getNom());
	}

	@Test
	public void testExoJocaStringMauvais2() {
		ExoJoca exo2 = new ExoJoca("De_Crapal");
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
		Assert.assertEquals("grenouille_mouillee@gmail.com", exo.getAdresseMail());
		Assert.assertEquals("+33123456789", exo.getTel());
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
		exo.setMdpCache("kokokjui54");
		Assert.assertEquals("mot de passe non valide", exo.getMdp());
	}

	@Test
	public void testSetMdpCacheMauvais2() {
		exo.setMdpCache("elettssebtno0261*");
		Assert.assertEquals("mot de passe non valide", exo.getMdp());
	}

}
