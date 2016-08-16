package com.formation.thde.ctr;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	private void init() {
		ExoAlgo5 exo5 = new ExoAlgo5();
		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
		int n = 5;
		String cat = "456789";
		String[] newTab = exo5.solution(tab, cat, n);
		for (int i = 0; i < newTab.length; i++) {
			if (newTab[i] != null) {
				System.out.println(newTab[i]);
			}
		}
	}

}
