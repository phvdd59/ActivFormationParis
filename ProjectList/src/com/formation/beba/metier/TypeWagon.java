package com.formation.beba.metier;

public enum TypeWagon {
	WAGON_RESTO(0, 14), WAGON_SIMPLE1(1, 14), WAGON_SIMPLE2(2, 44), WAGON_DOUBLE(3, 28);

	private int type;
	private int pourCentType;

	private TypeWagon(int type) {
		this.type = type;

	}

	private TypeWagon(int type, int pourCentType) {
		this.type = type;
		this.pourCentType = pourCentType;

	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPourCentType() {
		return pourCentType;
	}

	public void setPourCentType(int pourCentType) {
		this.pourCentType = pourCentType;
	}
}
