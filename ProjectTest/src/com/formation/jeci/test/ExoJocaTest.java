package com.formation.jeci.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.joca.metier.ExoJoca;

public class ExoJocaTest {
	ExoJoca exoJoca;

	@Before
	public void init() {
		exoJoca = new ExoJoca();
	}

	@Test
	public void test() {
		exoJoca.setTel("+33605040302");
		Assert.assertEquals("numero de tel correct", "+33605040302", exoJoca.getTel());

	}

	@Test
	public void test1() {
		exoJoca.setTel("0605040302");
		Assert.assertEquals("numero de tel incorrect", "numero de telephone non valide", exoJoca.getTel());

	}

	@Test
	public void test2() {
		exoJoca.setTel("+33ab5040302");
		Assert.assertEquals("numero de tel incorrect", "numero de telephone non valide", exoJoca.getTel());

	}

	@Test
	public void test3() {
		exoJoca.setTel("+3360504030285");
		Assert.assertEquals("numero de tel incorrect", "numero de telephone non valide", exoJoca.getTel());

	}

	@Test
	public void test4() {
		exoJoca.setTel(null);
		Assert.assertEquals("numero de tel incorrect", "numero de telephone non valide", exoJoca.getTel());

	}

	@Test
	public void testadresseMail1() {
		exoJoca.setAdresseMail("jerome.gmail@gmail.com");
		Assert.assertEquals("adresse correcte", "jerome.gmail@gmail.com", exoJoca.getAdresseMail());

	}

	@Test
	public void testadresseMail2() {
		exoJoca.setAdresseMail("j erome.gmail@gmail.com");
		Assert.assertEquals("adresse incorrecte", "adresse mail non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testadresseMail3() {
		exoJoca.setAdresseMail("jerome.@mail@gmail.com");
		Assert.assertEquals("adresse incorrecte", "adresse mail non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testadresseMail4() {
		exoJoca.setAdresseMail("jerome.gmail@gmailcom");
		Assert.assertEquals("adresse incorrecte", "adresse mail non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testadresseMail5() {
		exoJoca.setAdresseMail("jerome.gmail@gmail.be");
		Assert.assertEquals("adresse correcte", "adresse mail non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testadresseMail6() {
		exoJoca.setAdresseMail(null);
		Assert.assertEquals("adresse incorrecte", "adresse mail non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testcoordonnee1() {
		exoJoca.setCoordonnee("jerome.@mail@gmail.com", "+33ab5040302");
		Assert.assertEquals("coordonnee incorrecte", "adresse mail non valide" + "numero de telephone non valide", exoJoca.getAdresseMail());

	}

	@Test
	public void testcoordonnee2() {
		exoJoca.setCoordonnee("jerome.mail@gmail.com", "+33525040302");
		Assert.assertEquals("coordonnee correcte", "jerome.mail@gmail.com" + "+33525040302", exoJoca.getAdresseMail());
	}

	@Test
	public void testcoordonnee3() {
		exoJoca.setCoordonnee("jerome.m ail@gmail.com", "+33655040302");
		Assert.assertEquals("coordonnee incorrecte", "adresse mail non valide" + "+33655040302", exoJoca.getAdresseMail());
	}

	@Test
	public void testcoordonnee4() {
		exoJoca.setCoordonnee("jerome@gmail.com", "0");
		Assert.assertEquals("coordonnee incorrecte", "jerome@gmail.com" + "numero de telephone non valide", exoJoca.getAdresseMail());
	}

	@Test
	public void testcoordonnee5() {
		exoJoca.setCoordonnee("jerome@gmail.com", "+3362^1¨15040302");
		Assert.assertEquals("coordonnee incorrecte", "jerome@gmail.com" + "numero de telephone non valide", exoJoca.getAdresseMail());
	}

	/*****************************************************************************************************************/
	@Test
	public void testmdpcache() {
		exoJoca.setMdpCache("alLelou1");
		Assert.assertEquals("mdp correct", "laeLolu", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache1() {
		exoJoca.setMdpCache("alLelou1a");
		Assert.assertEquals("mdp correct", "laeLolua", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache2() {
		exoJoca.setMdpCache("alleléui");
		Assert.assertEquals("mdp incorrect", "mot de passe non valide", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache3() {
		exoJoca.setMdpCache("alleloui");
		Assert.assertEquals("mdp incorrect", "mot de passe non valide", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache4() {
		exoJoca.setMdpCache("ALLELOUI1");
		Assert.assertEquals("mdp incorrect", "mot de passe non valide", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache5() {
		exoJoca.setMdpCache("al.L11lol");
		Assert.assertEquals("mdp incorrect", "mot de passe non valide", exoJoca.getMdp());
	}

	@Test
	public void testmdpcache6() {
		exoJoca.setMdpCache(null);
		Assert.assertEquals("mdp incorrect", "mot de passe non valide", exoJoca.getMdp());
	}

}
