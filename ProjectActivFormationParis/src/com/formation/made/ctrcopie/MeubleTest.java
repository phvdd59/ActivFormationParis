package com.formation.made.ctrcopie;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MeubleTest {
		Meuble meuble;
		private TRI tri=TRI.REF;
		private String nom="monMeuble";
		private String refAbrege="999";
		private String unite="mm";
		private float longueur=10f;
		private float largeur=10f;
		private float hauteur=10f;
	
	@Before
	public void init(){
		meuble=null;
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		
	}
	//--------NOM
	@Test
	public void testMeublenomOk() {

		String nomTest="nomTest";
		meuble=new Meuble(tri,nomTest,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(nomTest, meuble.getNomCommercial());
	}

	@Test
	public void testMeubleNomVide() {

		String nomVide="";
		meuble=new Meuble(tri,nomVide,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals("", meuble.getNomCommercial());
	}
	
	@Test
	public void testMeubleNomLong() {

		String nomTest="nomTesteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		meuble=new Meuble(tri,nomTest,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(null, meuble.getNomCommercial());
	}
	@Test
	public void testMeubleNomNull() {

		String nomTest=null;
		meuble=new Meuble(tri,nomTest,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals("", meuble.getNomCommercial());
	}
	//-------------REF---------------------------------------------------------------------------
	@Test
	public void testMeubleRefok() {

		String refAbrege="450";
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals("450", meuble.getRefAbrege());
	}
	
	@Test
	public void testMeubleRefSuperieur1000() {

		String refAbrege="1001";
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(null, Integer.valueOf(meuble.getRefAbrege()));
	}
	
	@Test
	public void testMeubleRefSuperieurNull() {

		String refAbrege=null;
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(null, meuble.getRefAbrege());
	}
	@Test
	public void testMeubleRefSuperieurVide() {

		String refAbrege="";
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(null, meuble.getRefAbrege());
	}
	
//------------------------------DIM--------------------------------------------------------
	@Test
	public void testMeubleDimOk() {

		Float longueur=20f;
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(longueur, Float.valueOf(meuble.getLongueur()));
	}
	
	@Test
	public void testMeubleUniteCm() {

		Float longueur=20f;
		String unite="cm";
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(Float.valueOf(200), Float.valueOf(meuble.getLongueur()));
	}
	@Test
	public void testMeubleUniteInch() {

		Float longueur=20f;
		String unite="i";
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(Float.valueOf(20f/20.4f), Float.valueOf(meuble.getLongueur()),0.01f);
	}
	
	
	@Test
	public void testMeubleDim0() {

		Float longueur=0f;
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(Float.valueOf(0), Float.valueOf(meuble.getLongueur()));
	}
	
	@Test
	public void testMeubleDimNegativ() {

		Float longueur=-3f;
		meuble=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(Float.valueOf(0), Float.valueOf(meuble.getLongueur()));
	}
	
	@Test
	public void testMeubleDimNull() {
		Float longueur=null;
		try {
			meuble = new Meuble(tri, nom, refAbrege, unite, longueur, largeur, hauteur);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
			Assert.assertEquals(null, Float.valueOf(meuble.getLongueur()));
	
	}
	
	//--------------TRI
	@Test
	public void testMeubleTriOk() {
		String refMeuble1="0";
		String refMeuble2="999";
		Meuble meuble1=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Meuble meuble2=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(1,meuble1.compareTo(meuble2));
	}
	@Test
	public void testMeubleTriNonOk() {
		String refMeuble1="0";
		String refMeuble2="999";
		Meuble meuble1=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Meuble meuble2=new Meuble(tri,nom,refAbrege,unite,longueur,largeur,hauteur);
		Assert.assertEquals(1,meuble2.compareTo(meuble1));
	}
	
}
