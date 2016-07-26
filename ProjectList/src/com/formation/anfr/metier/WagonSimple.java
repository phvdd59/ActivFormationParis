package com.formation.anfr.metier;

public class WagonSimple extends WagonVoyageur {
	public static boolean PREMIERE_CLASSE = true;
	public static boolean SECONDE_CLASSE = false;

	private boolean typeClass;

	public WagonSimple() {
		super();
		typeClass = SECONDE_CLASSE;
	}

	public WagonSimple(boolean typeClass) {
		super();
		this.typeClass = typeClass;
		if (typeClass == PREMIERE_CLASSE) {
			setLng(getLng() * 4f / 3f);
		}
	}

	public WagonSimple(int nbSieges) {
		super(nbSieges);
		typeClass = SECONDE_CLASSE;
	}

	public WagonSimple(int nbSieges, boolean typeClass) {
		super(nbSieges);
		this.typeClass = typeClass;
		if (typeClass == PREMIERE_CLASSE) {
			setLng(getLng() * 4f / 3f);
		}
	}

	public boolean isTypeClass() {
		return typeClass;
	}

	public void setTypeClass(boolean typeClass) {
		if (typeClass == PREMIERE_CLASSE && this.typeClass == SECONDE_CLASSE) {
			setLng(getLng() * 4f / 3f);
		} else if (typeClass == SECONDE_CLASSE && isTypeClass() == PREMIERE_CLASSE) {
			setLng(getLng() * 3f / 4f);
		}
		this.typeClass = typeClass;
	}

	public void setNbSieges(int nbSieges) {
		super.setNbSieges(nbSieges);
		if (typeClass == PREMIERE_CLASSE) {
			setLng(getLng() * 4f / 3f);
		}
	}

	@Override
	public String toString() {
		String s = "";
		if (typeClass == PREMIERE_CLASSE) {
			s += "WAGON 1°     : ";
		} else {
			s += "WAGON 2°     : ";
		}
		return s + super.toString();
	}

	@Override
	public int getType() {
		int type = 0;
		if (isTypeClass() == PREMIERE_CLASSE) {
			type = typeWagon.WAGON_SIMPLE1.ordinal();
		} else {
			type = typeWagon.WAGON_SIMPLE2.ordinal();
		}
		return type;
	}
	
	@Override
	public int getValeur() {
		int type = 0;
		if (isTypeClass() == PREMIERE_CLASSE) {
			type = typeWagon.WAGON_SIMPLE1.getOrdreDeTri();
		} else {
			type = typeWagon.WAGON_SIMPLE2.getOrdreDeTri();
		}
		return type;
	}
}
