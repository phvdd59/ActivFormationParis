package com.formation.emma.main;

import com.formation.emma.ctr.ExoAlgo5;

public class Main2 {

	public static void main(String[] args) {
		Main2 main = new Main2();
		main.init();
	}
	
		private void init() {
			ExoAlgo5 exo= new ExoAlgo5();
			String[] tab = {"123456789","125741123","123456102","123456103","145156231","123456102","123789456","123456789","123456789"};
			exo.solution(tab, "123456", 2);
		
	}

		
		

	}


