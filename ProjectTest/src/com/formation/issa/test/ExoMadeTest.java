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
		exoMade.setCoordonnees("dupont@outlook.fr"+"336521202925");		
		Assert.assertEquals("adresse mail valide et tel valide",(exoMade.getAdresseMail() && exoMade.getTel());
		
		
	}

	@Test
	public void testSetMdpCache() {
		Assert.fail("Not yet implemented");
	}

}
