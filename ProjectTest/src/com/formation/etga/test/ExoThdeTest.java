package com.formation.etga.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.thde.metier.ExoThde;

public class ExoThdeTest {

	ExoThde exoThde;

	@Before
	public void init() {
		exoThde = new ExoThde();
	}

	@Test
	public void testSetTel() {
		//		exoThde.setTel (0601020304);
		Assert.assertEquals("num de tel incorrect", "+33601020304", exoThde.getTel());
	}

	@Test
	public void testExoThdeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonnees() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMdpCache() {
		fail("Not yet implemented");
	}

}
