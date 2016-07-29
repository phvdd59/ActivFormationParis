package com.formation.etga.autre;

public class X implements I1, I2 {

	@Override
	public void methodeA() {
		System.out.println("methodeA");
	}

	@Override
	public String methodeB() {
		System.out.println("methodeB");
		return null;
	}

	@Override
	public void methodeC() {
		System.out.println("methodeC");
	}

	@Override
	public int methodeD() {
		System.out.println("methodeD");
		return 0;
	}

}
