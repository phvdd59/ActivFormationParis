package com.formation.made.Autre;

public class X implements I1,I2{

	@Override
	public void methodeA() {
		System.out.println("m�thodeA de X");
		
	}

	@Override
	public void methodeB() {
		System.out.println("m�thodeB");
		
	}

	@Override
	public void methodeC() {
		System.out.println("m�thodeC");
		
	}

	@Override
	public int methodeD() {
		System.out.println("m�thodeD");
		return 0;
	}

}
