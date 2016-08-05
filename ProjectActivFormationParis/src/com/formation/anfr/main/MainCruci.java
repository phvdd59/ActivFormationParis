package com.formation.anfr.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.anfr.exo.ExoAlgo4;
import com.formation.anfr.exo.ExoException1;
import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.Terme;

public class MainCruci {

	public static void main(String[] args) {
		MainCruci mainCruci = new MainCruci();
		mainCruci.init();
	}

	private void init() {
		ExoException1 exo = new ExoException1();
		ArrayList<Terme> lst = new ArrayList<Terme>();
		System.out.println("LOL");
		Point p = new Point(0,0);
		lst.add(new Terme("lol",p,Terme.HORIZONTAL));
		lst.add(new Terme("tu",new Point(0,1),Terme.VERTICAL));
		lst.add(new Terme("va",new Point(1,1),Terme.VERTICAL));
		lst.add(new Terme("bu",new Point(2,0),Terme.VERTICAL));
		char[][] sol = null;
		 try {
			sol = exo.solution(3, 3, lst);
		 } catch (CruciException e) {
			 System.out.println("LOL");
		 }
		 
	}

}
