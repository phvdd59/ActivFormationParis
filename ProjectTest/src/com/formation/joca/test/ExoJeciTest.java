package com.formation.joca.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.formation.joca.metier.ExoJoca;

public class ExoJeciTest {
	
	ExoJoca exo;

	@Test
	public void testExoJeciString() {
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
		exo.setMdpCache("elettssebtno0261");
		Assert.assertEquals("letestestbon2016", exo.getMdp());
	}

}
