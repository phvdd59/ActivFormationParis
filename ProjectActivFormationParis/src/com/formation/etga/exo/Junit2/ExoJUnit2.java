package com.formation.etga.exo.Junit2;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExoJUnit2 {

	private Meuble meuble;
	private TRI tri;
	
	@Before
	public void init() {
		meuble = new Meuble( TRI.REF, "TABLE","100", "mm", 100f, 100f, 100f);	
	}
	
	@Test
	public void testMeubleNomCommercialNull() {
		meuble = new Meuble( TRI.REF, null,"100", "mm", 100f, 100f, 100f);	
		meuble.getNomCommercial();
		Assert.assertNull("Ref null", meuble.getNomCommercial());
	}

	@Test
	public void testMeubleNomCommercialTropGrand() {
		meuble = new Meuble( TRI.REF, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","100", "mm", 100f, 100f, 100f);	
		meuble.getNomCommercial();
		Assert.assertEquals("Nom Trop Long", "", meuble.getNomCommercial());
	}
	
	@Test
	public void testMeubleNomCommercialChiffre() {
		meuble = new Meuble( TRI.REF, "99999999","100", "mm", 100f, 100f, 100f);	
		meuble.getNomCommercial();
		Assert.assertEquals("Nom Incorrect", "", meuble.getNomCommercial());
	}
	
	@Test
	public void testMeubleRefNull() {
		meuble = new Meuble( TRI.REF, "TABLE", null, "mm", 100f, 100f, 100f);	
		meuble.getRefAbrege();
		Assert.assertNull("Ref null", meuble.getRefAbrege());
	}
	
	@Test
	public void testMeubleRefTropGrande() {
		meuble = new Meuble( TRI.REF, "TABLE","999999", "mm", 100f, 100f, 100f);	
		meuble.getRefAbrege();
		Assert.assertEquals("Ref Trop Long", "", meuble.getRefAbrege());
	}
	
	@Test
	public void testMeubleRefLettre() {
		meuble = new Meuble( TRI.REF, "TABLE","ABC", "mm", 100f, 100f, 100f);	
		meuble.getRefAbrege();
		Assert.assertEquals("Ref Incorrecte", "", meuble.getRefAbrege());
	}
	
	@Test
	public void testMeubleLongueurNegative() {
		meuble = new Meuble( TRI.REF, "TABLE", "100", "mm", -100f, 100f, 100f);	
		meuble.getLongeur();
		Assert.assertEquals(0f, meuble.getLongeur(), 0.0001f);
	}
	
	@Test
	public void testMeubleLargeurNegative() {
		meuble = new Meuble( TRI.REF, "TABLE", "100", "mm", 100f, -100f, 100f);
		meuble.getLargeur();
		Assert.assertEquals(0f, meuble.getLargeur(), 0.0001f);
	}
	
	@Test
	public void testMeubleHauteurNegative() {
		meuble = new Meuble( TRI.REF, "TABLE", "100", "mm", 100f, 100f, -100f);
		meuble.getHauteur();
		Assert.assertEquals(0f, meuble.getHauteur(), 0.0001f);
	}
	
	@Test
	public void testMeubleTri() {
		meuble = new Meuble( TRI.REF, "TABLE", "100", "mm", 100f, 100f, -100f);
		Assert.assertEquals("Tri mal defini", TRI.REF, meuble.tri);
	}
}
