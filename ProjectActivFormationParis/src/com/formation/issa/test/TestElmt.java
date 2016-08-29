package com.formation.issa.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.formation.issa.ctr.Elmt;
import com.formation.issa.ctr.MATERIAUX;

public class TestElmt {
	Elmt element=new Elmt();
	int pourcent=0;
	
	
	

	@Test
	public void testPoidMat() {
	
		MATERIAUX mat=MATERIAUX.BOIS;
		
		
		element.poidMat(mat);
		element.setLargeur(25.4f);
		element.setLongueur(20.2f);
		element.setHauteur(19.5f);
		Assert.assertEquals(10044.45, element.volume());
		element.poidMat(mat);
		

		
	}

}
