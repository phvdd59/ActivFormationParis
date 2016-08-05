package com.formation.thde.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFlux2 {

	public static void main(String[] args) {
		MainFlux2 mainF = new MainFlux2();
		mainF.init();
	}

	public void init() {
		BufferedReader stdIn = null;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String ligne = stdIn.readLine();
			while (!ligne.equals("")) {
				
				//UTILISE LIGNE
				System.out.println(ligne);
				
				ligne = stdIn.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stdIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}