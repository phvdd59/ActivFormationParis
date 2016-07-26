package com.formation.thde.metier;

public enum TypeWagon {
	WAGON_RESTO(0), //
	WAGON_SIMPLE1(1), //
	WAGON_SIMPLE2(2), //
	WAGON_DOUBLE(3);//
	
	private int type;

	private TypeWagon(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
