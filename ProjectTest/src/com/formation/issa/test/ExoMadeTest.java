package com.formation.issa.test;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.made.metier.ExoMade;

public class ExoMadeTest {
	
	ExoMade exoMade;
	@Before
	public void init(){
		exoMade=new ExoMade();
	}

	@Test
	public void testExoMadeString() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testSetCoordonnes() {
		exoMade.setTel("0652120292");
		Assert.assertEquals("numero de tel incorrect", "0652120292", exoMade.getTel());
		
		
	}

	@Test
	public void testSetMdpCache() {
		Assert.fail("Not yet implemented");
	}

}
