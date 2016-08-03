package com.formation.beba.main;

import com.formation.beba.metier.ExoBeba;

public class MainTest {

	public static void main(String[] args) {
		MainTest mainTest = new MainTest();
		mainTest.init();

	}

	private static void init() {
		ExoBeba exoBeba = new ExoBeba();

		exoBeba.setMdpCache("AbCdEf");

	}

}
