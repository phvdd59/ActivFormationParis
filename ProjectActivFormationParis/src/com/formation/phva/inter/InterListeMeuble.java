package com.formation.phva.inter;

import java.io.File;

import com.formation.phva.dosFile1.metier.Meuble;

public interface InterListeMeuble {

	public void chargeListeMeuble(File fRep);
	public Meuble get(int index);
	public int size();
}
