package com.formation.made.Autre;

public class X implements I1,I2{

	@Override
	public void methodeA() {
		System.out.println("méthodeA de X");
		
	}

	@Override
	public void methodeB() {
		System.out.println("méthodeB");
		
	}

	@Override
	public void methodeC() {
		System.out.println("méthodeC");
		
	}

	@Override
	public int methodeD() {
		System.out.println("méthodeD");
		return 0;
	}

}
