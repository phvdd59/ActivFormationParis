package com.formation.anfr.main;

public class MainProjectAnfr {

	public static void main(String[] args) {
		MainProjectAnfr m = new MainProjectAnfr();
		m.init();

	}

	private void init() {
		String noSuivi="";
		for (int i = 0; i < 2; i++) {
			int k = (int) (Math.random() * 26)+1;
			System.out.println(k);
			noSuivi += String.valueOf((char)(k + 64));
		}
		noSuivi+="_";
		for (int i = 0; i < 8; i++) {
			int k = (int) (Math.random() * 10);
			noSuivi += k;
		}
		System.out.println(noSuivi);
	}

}
