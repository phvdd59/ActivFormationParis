package com.formation.beba.main;

import java.util.ArrayList;

import com.formation.beba.exo.ExoAlgo3;
import com.formation.phva.exo.Mouvement;

public class MainAlgo3 {
	public static void main(String[] args) {
		ExoAlgo3 exoAlgo3 = new ExoAlgo3();
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		lst = exoAlgo3.solution(lst, 30, "A", "B", "C");

		System.out.println(lst);
	}
}
