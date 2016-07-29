package com.formation.joca.autres;

public class X implements I1, I2 {

	@Override
	public void methodeA() {
		System.out.println("methodeA");
	}

	@Override
	public void methodeB() {
		System.out.println("methodeB");
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
