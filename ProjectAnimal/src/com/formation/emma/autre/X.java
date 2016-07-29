package com.formation.emma.autre;

public class X implements I1,I2 {

	@Override
	public void methodeA() {
		System.out.println("methode A");
		
	}

	@Override
	public String methodeB() {
		System.out.println("methode B");
		return null;
	}

	@Override
	public void methodeC() {
		System.out.println("methode C");
		
	}

	@Override
	public int methodeD() {
		System.out.println("methode D");
		return 0;
	}

}
