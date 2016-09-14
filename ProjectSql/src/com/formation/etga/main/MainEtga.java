package com.formation.etga.main;

import java.util.Date;

public class MainEtga {

	public static void main(String[] args) throws IllegalArgumentException, InterruptedException {
		MainEtga m = new MainEtga();
		m.init();
	}

	private void init() throws IllegalArgumentException, InterruptedException {
		Perso perso = new Perso("NOM1", new Date(), new Date());
		System.out.println(perso);

	}
}
