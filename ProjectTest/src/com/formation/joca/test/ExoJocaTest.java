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
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonnee() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMdpCache() {
		exo.setMdpCache("elettssebtno0261");
		Assert.assertEquals("letestestbon2016", exo.getMdp());
	}

	@Test
	public void testExoJocaString() {
		fail("Not yet implemented");
	}

}
