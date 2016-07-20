package com.formation.etga.exo;

import com.formation.phva.exo.InterExoSimple;

public class ExoSimple implements InterExoSimple {

	public static void main(String[] args) {
		ExoSimple exoSimple = new ExoSimple();
		exoSimple.init();
	}

	private void init() {
		System.out.println(sumTableau(tab));
	}

	private int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };

	public int sumTableau(int[] tab) {
		int sum = 0;
		for (int i : tab) {
			sum += i;
		}
		return sum;
	}
}
