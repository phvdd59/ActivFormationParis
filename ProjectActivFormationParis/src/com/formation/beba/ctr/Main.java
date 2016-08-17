package com.formation.beba.ctr;

public class Main {
	public static void main(String[] args) {

		String[] tab = { "123456001", "123456002", "123456001", "456789001", "123456003", "123456001", "123456003", "123456003", "456789002", "654987001", "654987003", "123456005", "456789002", "456789002", "456789510", "456789510", "789456245", "123456001" };
		String[] tabret;
		ExoAlgo5 exo = new ExoAlgo5();
		System.out.println(exo.solution(tab, "456789", 2));
	}
}