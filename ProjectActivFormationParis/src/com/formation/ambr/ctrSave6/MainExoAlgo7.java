package com.formation.ambr.ctrSave6;

public class MainExoAlgo7 {

	public static void main(String[] args) {
		MainExoAlgo7 m = new MainExoAlgo7();
		m.init();
	}

	private void init() {
		ExoAlgo7Bis exo = new ExoAlgo7Bis();
		int[] H = {8,8,5,7,9,8,7,4,8};
		System.out.println(exo.solution(H));
	}

}
