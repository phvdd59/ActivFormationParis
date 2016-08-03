package com.formation.phva.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.frva.metier.ExoFrva;

public class ExoFrvaTest {

	ExoFrva exoFrva;
	@Before
	public void init() {
		exoFrva=new ExoFrva();
	}
	
	@Test 
	public void testSetTel() {
		exoFrva.setTel(605040302);
		Assert.assertEquals("numero de tel incorrect","0605040302", exoFrva.getTel());
		
	}

	@Test
	public void testExoFrvaString() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonnee() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetMdpCache() {
		Assert.fail("Not yet implemented");
	}
}
