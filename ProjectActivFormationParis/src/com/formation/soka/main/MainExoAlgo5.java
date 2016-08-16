package com.formation.soka.main;

import com.formation.soka.ctr.ExoAlgo5;

public class MainExoAlgo5 {

	public static void main(String[] args) {
		MainExoAlgo5 m = new MainExoAlgo5();
		m.init();

	}

	public void init() {
		ExoAlgo5 exo = new ExoAlgo5();
		String[] t = { "123456001", "456789001", "123456002", "123456001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
		exo.solution(t, "123456", 2);
	}

}
