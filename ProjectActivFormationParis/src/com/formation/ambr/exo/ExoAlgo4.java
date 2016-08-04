package com.formation.ambr.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit intégrer une liste de terme sous forme d'un
	 * tableau à deux dimensions
	 * 
	 * 
	 * example :
	 * 
	 * "DATTIERS" "EREINTEE" "COMEDIEN" "AMENER T" " ART API" "OTA MIAM"
	 * "BEIGE RE" "S REGAIN" "EPELER T" "DES VELA" "ET METAL" "REPU ESE"
	 *
	 * les cas annormaux seront traité en grande partie sur la base des exeption
	 * cruciExeption.
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		int w = width;
		int h = height;
		char[][] tab = new char[w][h];

		ArrayList<Terme> lst1 = new ArrayList<Terme>();

		String txt = new String();
		//String txtEpure = Terme.epuration(txt);

		for (int i = 0; i < tab.length; i++) {

		}
		return tab;
	}

}
