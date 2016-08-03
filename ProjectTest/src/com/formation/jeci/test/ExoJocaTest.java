package com.formation.jeci.metier;

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

	public void test1() {
		exoJoca.setTel("0605040302");
		Assert.assertEquals("numero de tel incorrect", "0605040302", exoJoca.getTel());

	}

	public void test2() {
		exoJoca.setTel("+33ab5040302");
		Assert.assertEquals("numero de tel incorrect", "+33ab5040302", exoJoca.getTel());

	}

	public void test3() {
		exoJoca.setTel("+3360504030285");
		Assert.assertEquals("numero de tel incorrect", "+3360504030285", exoJoca.getTel());

	}

	public void test4() {
		exoJoca.setTel(null);
		Assert.assertEquals("numero de tel incorrect", null, exoJoca.getTel());

	}

	public void testadresseMail1() {
		exoJoca.setAdresseMail("jerome.gmail@gmail.com");
		Assert.assertEquals("adresse correcte", "jerome.gmail@gmail.com", exoJoca.getAdresseMail());

	}

	public void testadresseMail2() {
		exoJoca.setAdresseMail("j erome.gmail@gmail.com");
		Assert.assertEquals("adresse incorrecte", "j erome.gmail@gmail.com", exoJoca.getAdresseMail());

	}

	public void testadresseMail3() {
		exoJoca.setAdresseMail("jerome.@mail@gmail.com");
		Assert.assertEquals("adresse incorrecte", "jerome.@mail@gmail.com", exoJoca.getAdresseMail());

	}

	public void testadresseMail4() {
		exoJoca.setAdresseMail("jerome.gmail@gmailcom");
		Assert.assertEquals("adresse incorrecte", "jerome.gmail@gmailcom", exoJoca.getAdresseMail());

	}

	public void testadresseMail5() {
		exoJoca.setAdresseMail("jerome.gmail@gmail.be");
		Assert.assertEquals("adresse correcte", "jerome.gmail@gmail.be", exoJoca.getAdresseMail());

	}

	public void testadresseMail6() {
		exoJoca.setAdresseMail(null);
		Assert.assertEquals("adresse incorrecte", null, exoJoca.getAdresseMail());

	}

	public void testcoordonnee1() {
		exoJoca.setCoordonnee("jerome.@mail@gmail.com", "+33ab5040302");
		Assert.assertEquals("coordonnee incorrecte", "jerome.@mail@gmail.com" + "+33ab5040302", exoJoca.getAdresseMail());

	}

	public void testcoordonnee2() {
		exoJoca.setCoordonnee("jerome.mail@gmail.com", "+33525040302");
		Assert.assertEquals("coordonnee correcte", "jerome.mail@gmail.com" + "+33525040302", exoJoca.getAdresseMail());
	}

	public void testcoordonnee3() {
		exoJoca.setCoordonnee("jerome.m ail@gmail.com", "+33655040302");
		Assert.assertEquals("coordonnee incorrecte", "jerome.m ail@gmail.com" + "+33655040302", exoJoca.getAdresseMail());
	}

	public void testcoordonnee4() {
		exoJoca.setCoordonnee("jerome@gmail.com", "0");
		Assert.assertEquals("coordonnee incorrecte", "jerome@gmail.com" + "0", exoJoca.getAdresseMail());
	}

	public void testcoordonnee5() {
		exoJoca.setCoordonnee("jerome@gmail.com", "+3362^1¨15040302");
		Assert.assertEquals("coordonnee incorrecte", "jerome@gmail.com" + "+3362^1¨15040302", exoJoca.getAdresseMail());
	}
	
}
