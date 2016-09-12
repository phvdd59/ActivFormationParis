package com.formation.made.ctrcopie;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExoJUnit1 {

	Elmt elmt;

	@Before
	public void init() {
		elmt = new Elmt();
		elmt.setHauteur(10f);
		elmt.setLargeur(5f);
		elmt.setLongeur(20f);
	}

	
	@Test
	public void testPoidMatFerOK() {
		MATERIAUX fer= MATERIAUX.FER;
		fer.setPourcent(30);
		Assert.assertEquals(2.22f, elmt.poidMat(fer), 0.001f);
	}
	
	@Test
	public void testPoidMatBoisOK() {
		MATERIAUX bois= MATERIAUX.BOIS;
		bois.setPourcent(70);
		Assert.assertEquals(0.42f, elmt.poidMat(bois), 0.001f);
	}
	
	
	@Test
	public void testPoidMatOK() {
		for (MATERIAUX materiaux : MATERIAUX.values()) {
			materiaux.setPourcent(100);
			Assert.assertEquals(materiaux.getDensite(), elmt.poidMat(materiaux), 0.001f);
		}
	}
	
	@Test
	public void testPoidMatOrOK() {
			MATERIAUX or=MATERIAUX.OR;
			or.setPourcent(100);
			Assert.assertEquals(MATERIAUX.OR.getDensite(), elmt.poidMat(or), 0.001f);
	}
	
	@Test
	public void testPoidMatNull() {
			try {
				Assert.assertEquals(0, elmt.poidMat(null), 0.001f);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	}
	
	@Test
	public void testPrixdMatOk() {
	float[]	prMats={1f , 2f , 1f , 3.5f , 1f , 5f , 2f , 7f, 5f , 6f , 4f , 1f};
	MATERIAUX fer= MATERIAUX.FER;
	fer.setPourcent(30);
	MATERIAUX bois= MATERIAUX.BOIS;
	bois.setPourcent(70);
	Assert.assertEquals(8.19f, elmt.prixFarication(prMats), 0.001f);
	
	}

	
	@Test
	public void testPrixdMatNull() {
	Assert.assertEquals(0, elmt.prixFarication(null), 0.001f);
	
	}
	
	@Test
	public void testPrixdMatVide() {
		float[]	prMats={};
	Assert.assertEquals(0, elmt.prixFarication(prMats), 0.001f);
	}
	
	@Test
	public void testPrixdMatDimensionLongue() {
		int nbMateriaux=MATERIAUX.values().length;
		float[]	prMats=new float[nbMateriaux+1];
	Assert.assertEquals(0, elmt.prixFarication(prMats), 0.001f);
	}
	
	@Test
	public void testPrixdMatDimensionCourte() {
		int nbMateriaux=MATERIAUX.values().length;
		float[]	prMats=new float[nbMateriaux-1];
	Assert.assertEquals(0, elmt.prixFarication(prMats), 0.001f);
	}


}
