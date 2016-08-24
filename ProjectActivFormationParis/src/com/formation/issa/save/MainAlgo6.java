package com.formation.issa.save;

public class MainAlgo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAlgo6 main=new MainAlgo6();
		main.init();

	}

	private void init() {
	ExoAlgo6 exo=new ExoAlgo6();
	int n=2;
	int f=3;
	int[]tab={1,4,7,8,4,3,7,2,8,9,2,6,3,4,1,7,9,1,1,2};
	exo.solution(tab, n, f);
		
	}

}
