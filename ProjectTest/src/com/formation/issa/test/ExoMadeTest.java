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
	public void testSetCoordonnees() {
		exoMade.setCoordonnees("dupont@outlook.fr","+336521202925");		
		Assert.assertEquals("dupont@outlook.fr",exoMade.getAdresseMail());
		Assert.assertEquals("+336521202925", exoMade.getTel());

	}
	@Test
	public void  testSetCoordonneesnull() {
		exoMade.setCoordonnees(null,null);		
		Assert.assertEquals(null,exoMade.getAdresseMail());
		Assert.assertEquals(null, exoMade.getTel());

	}

	@Test
	public void testSetMdpCache() {
		exoMade.setMdpCache("Aclelekkl8");
		Assert.assertEquals("cAelelkk8l", exoMade.getMdp());
	}
	@Test
	public void testSetMdpCachePonc() {
		exoMade.setMdpCache("Abcdef!");
		Assert.assertEquals("bAdcfe!", exoMade.getMdp());
	}
	@Test
	public void testSetMdpCacheImpair(){
		exoMade.setMdpCache("Ebcdg");
		Assert.assertEquals("bEdcg", exoMade.getMdp());
	}
	@Test
	public void testSetMdpCacheMAJ(){
	exoMade.setMdpCache("ABCDEF");	
	Assert.assertEquals(null, exoMade.getMdp());
	}
	@Test
	public void testSetMdpCacheMIN(){
		exoMade.setMdpCache("adfer");
		Assert.assertEquals(null, exoMade.getMdp());
	}

}
