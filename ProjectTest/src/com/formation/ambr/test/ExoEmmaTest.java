package com.formation.ambr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.emma.metier.ExoEmma;

public class ExoEmmaTest {

	ExoEmma exoEmma;

	@Before
	public void init() {
		exoEmma = new ExoEmma();
	}

	@Test
	public void testSetTel() {
		exoEmma.setTel("0612345678");
		Assert.assertEquals("numero de tel incorrect", "0612345678", exoEmma.getTel());
	}

	@Test
	public void testExoEmmaString() {

		fail("Not yet implemented");

	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonnee() {
		fail("Not yet implemented");
	}

	// tests mdp

	@Test
	public void testSetMdpCache() {
		exoEmma.setMdpCache("B0njOUrr");
		assertEquals("0BjnUOrr", exoEmma.getMdp());
	}

	@Test
	public void testSetMdpCacheAutreQueLettresChiffres() {
		exoEmma.setMdpCache(" BOnjOUr!");
		//assertEquals(null, exoEmma.getMdp());
		assertNull(exoEmma.getMdp());
	}

	@Test
	public void testSetMdpCacheImpair() {
		exoEmma.setMdpCache("BOnjOUr");
		assertEquals("OBjnUOr", exoEmma.getMdp());
	}

	@Test
	public void testSetMdpCacheVide() {
		exoEmma.setMdpCache("");
		assertNull(exoEmma.getMdp());
	}

}
