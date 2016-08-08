package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.issa.exo.ExoAlgo4;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class MainAlgo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainAlgo4 mainAlgo4 = new MainAlgo4();
		mainAlgo4.init();
	}

	private void init() {
		ExoAlgo4 exoAlgo4 = new ExoAlgo4();
		ArrayList<Terme> lst = new ArrayList<Terme>();
		Terme terme = new Terme();
		String txt="Bonjour, où allez-vous? Nous allons à New-York. ";
		System.out.println(terme.epuration(txt));

		int width =0;
		int height = 0;
		char[][] charTab = new char[height][width];
		try {
			System.out.println(exoAlgo4.solution(width, height, lst));
		} catch (CruciException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
