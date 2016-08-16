package com.formation.anfr.main;

import com.formation.anfr.ctr.ExoAlgo5;

public class MainExo5 {

		public static void main(String[] args) {
			MainExo5 mainExo = new MainExo5();
			mainExo.init();
		}

		public void init() {
			String[] tab = {"123456001","123456002","123456001","456789001","123456003","123456001",
			    	  		"123456003","123456003","456789002","654987001","654987003","123456005",
			    	  		"456789002","456789002","456789510","456789510","789456245","123456001"};
			ExoAlgo5 exo = new ExoAlgo5();
			String[] test = exo.solution(tab, "12346", 2);
			if (test!=null){
			for (int i = 0; i < test.length; i++) {
				System.out.println(test[i]);
			}} else{
				System.out.println("null");
			}
			String[] tab2 = {"123456001","123456002","123456001","456789001","123456003","123456001",
		 		"123456003","123456003","456789002","654987001","654987003","123456005",
		  		"456789002","456789002","456789510","456789510","789456245","123456001"};
			String[] test2 = exo.solution(null, "456789", 2);
			if (test!=null){
				for (int i = 0; i < test.length; i++) {
					System.out.println(test[i]);
				}} else{
					System.out.println("null");
				}
	}

}
