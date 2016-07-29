package com.formation.issa.exo;

import java.util.ArrayList;

public class MainAlgo3 {

	public MainAlgo3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAlgo3 mainAlgo3 = new MainAlgo3();
		mainAlgo3.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		ExoAlgo3 exoAlgo3 = new ExoAlgo3();
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		int indice = 5;
		String a = new String();
		String b = new String();
		String c = new String();
		System.out.println(exoAlgo3.solution(lst, indice, a, b, c));

	}

}
