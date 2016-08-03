package com.formation.thde.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.formation.etga.metier.ExoEtga;

import junit.framework.Assert;

public class ExoEtgaTest {

	ExoEtga exoEtga;

	@Before
	public void init() {
		exoEtga = new ExoEtga();
	}

	@Test
	public void testSetTel() {
		Assert.assertEquals("numero de tel incorrect", "0605040302", exoEtga.setTel(0605040302));
	}

	@Test
	public void testExoEtgaString() {
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

	@Test
	public void testSetMdpCache() {
		fail("Not yet implemented");
	}

}
