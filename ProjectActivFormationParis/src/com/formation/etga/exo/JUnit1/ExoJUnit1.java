package com.formation.etga.exo.JUnit1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExoJUnit1 {
	private Elmt elmt;
	private MATERIAUX mat;
	
	@Before
	public void init() {
		elmt = new Elmt();
		elmt.setHauteur(10f);
		elmt.setLargeur(10f);
		elmt.setLongeur(10f);
		ArrayList<MATERIAUX> lstMat = new ArrayList<MATERIAUX>();
		MATERIAUX bois = MATERIAUX.BOIS;
	}
	
	@Test
	public void testPoidMatNull() {
		MATERIAUX mMat = null;  
		elmt.poidMat(mMat);
		Assert.assertEquals("Materiaux incorrect", "MATERAUX", elmt.getMateriaux());
	}

	@Test
	public void testPrixFarication() {
		Float [] prMats = {10f ,2f, 3f};
//		elmt.prixFarication(prMats);
	}

}
