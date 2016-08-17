package com.formation.jeci.main;

import com.formation.jeci.metier.ExoJeci;

public class MainTest {

	public static void main(String[] args) {
		MainTest main = new MainTest();

		main.init();

	}

	private void init() {
		ExoJeci test = new ExoJeci();
		test.setMdpCache("1aBcdef");
		System.out.println(test.getMdp());
		test.setAdresseMail("loic@gmail.com");
		System.out.println(test.getAdresseMail());
		test.setTel("+33619402752");
		System.out.println(test.getTel());
	}

}
