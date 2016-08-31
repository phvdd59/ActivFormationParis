package com.formation.ajee.veriffom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VerifFormTest {
	VerifForm test;

	@Before
	public void init() {

		test = new VerifForm();
	}

	@Test
	public void testnomnok() {
		String nom = test.nomVerif("054 pazeo");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testnomok() {
		String nom = test.nomVerif("'-Paul");

		Assert.assertEquals("'-Paul", nom);
	}

	@Test
	public void testnomokaccent() {
		String nom = test.nomVerif("Jérémy");

		Assert.assertEquals("Jérémy", nom);
	}

	@Test
	public void testnomnoklong() {
		String nom = test.nomVerif("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testprenomnok() {
		String nom = test.nomVerif("054 pazeo");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testprenomok() {
		String nom = test.nomVerif("Paul");

		Assert.assertEquals("Paul", nom);
	}

	@Test
	public void testprenomokaccent() {
		String nom = test.nomVerif("Jérémy");

		Assert.assertEquals("Jérémy", nom);
	}

	@Test
	public void testprenomnoklong() {
		String nom = test.nomVerif("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", nom);
	}
}
