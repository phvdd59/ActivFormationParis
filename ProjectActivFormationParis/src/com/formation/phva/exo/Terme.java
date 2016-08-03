package com.formation.phva.exo;

import java.awt.Point;

public class Terme {
	public static final boolean HORIZONTAL = false;
	public static final boolean VERTICAL = true;

	private String nom;
	private Point pos;
	private boolean sens;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public boolean isSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

	@Override
	public String toString() {
		return nom + " (" + pos.y + "," + pos.x + "," + ((sens) ? "H" : "V") + ")";
	}
}
