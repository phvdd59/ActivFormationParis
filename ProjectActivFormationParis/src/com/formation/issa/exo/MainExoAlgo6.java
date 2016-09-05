package com.formation.issa.exo;

public class MainExoAlgo6 {

	public static void main(String[] args) {
		MainExoAlgo6 mainAlgo6=new MainExoAlgo6();
		mainAlgo6.init();

	}

	private void init() {
		ExoAlgo6 ex=new ExoAlgo6();
		int []tab ={1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2 ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2};
		int n=2;
		int f=3;
		ex.solution(tab, n, f);
		
	}

}
