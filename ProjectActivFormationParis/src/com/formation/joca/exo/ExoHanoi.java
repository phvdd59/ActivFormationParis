package com.formation.joca.exo;

import java.util.ArrayList;

public class ExoHanoi {
	ArrayList<Integer> tour1 = new ArrayList<Integer>();
	ArrayList<Integer> tour2 = new ArrayList<Integer>();
	ArrayList<Integer> tour3 = new ArrayList<Integer>();

	public ExoHanoi() {
		this.tour1.add(1);
		this.tour1.add(2);
		this.tour1.add(3);
		this.tour1.add(4);

	}

	public ExoHanoi(ArrayList<Integer> tour1) {
		this.tour1 = tour1;

	}

	public ArrayList<Integer> getTour1() {
		return tour1;
	}

	public void setTour1(ArrayList<Integer> tour1) {
		this.tour1 = tour1;
	}

	public ArrayList<Integer> getTour2() {
		return tour2;
	}

	public void setTour2(ArrayList<Integer> tour2) {
		this.tour2 = tour2;
	}

	public ArrayList<Integer> getTour3() {
		return tour3;
	}

	public void setTour3(ArrayList<Integer> tour3) {
		this.tour3 = tour3;
	}

	public void retirerEtage(ArrayList<Integer> tourDepart, ArrayList<Integer> tourArrive) {
		tourArrive.add(0, tourDepart.remove(0));
	}

	public void mouvement() {

	}

	public boolean comparerTour(ArrayList<Integer> tourParam1, ArrayList<Integer> tourParam2) {
		boolean result = false;
		if (tourParam2.size() == 0) {
			result = true;
		} else if (tourParam1.get(0) < tourParam2.get(0)) {
			result = true;
		}
		return result;
	}

}
