package com.formation.issa.save;

public class MainAlgo5 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAlgo5 mainAlgo5=new MainAlgo5();
		mainAlgo5.init();

	}

	private void init() {
	ExoAlgo5 ex5=new ExoAlgo5();
	String []tab={"001451001,001451002,001451001,001451005,001451004,001451001,001451008,001451004"};
	String ini="001451001,001451002,001451001,001451005,001451004,001451001,001451008,001451004";
	String cat=null;
	int n=2;
	ex5.solution(tab, cat, n);
	
	
		
	}

}
