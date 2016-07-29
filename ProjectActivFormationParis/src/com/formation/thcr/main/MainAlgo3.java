package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.phva.exo.Mouvement;
import com.formation.thcr.exo.ExoAlgo3;

public class MainAlgo3 {

	public static void main(String[] args) {
		MainAlgo3 main = new MainAlgo3();
		main.init();
	}

	private void init() {
		ExoAlgo3 exo = new ExoAlgo3();
		ArrayList<Mouvement> M = new ArrayList<Mouvement>();
		exo.solution(M, 4, "a", "b", "c");
		
	}

}
