package com.formation.issa.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit intégrer une liste de terme sous forme 
	 * d'un tableau à deux dimensions 
	 * 
	 * 
	 * example :
	 * 
     * "DATTIERS"
     * "EREINTEE"
     * "COMEDIEN"
     * "AMENER T"
     * " ART API"
     * "OTA MIAM"
     * "BEIGE RE"
     * "S REGAIN"
     * "EPELER T"
     * "DES VELA"
     * "ET METAL"
     * "REPU ESE"
	 *
 	 * les cas annormaux seront traité en grande partie sur la base des 
	 * exeption cruciExeption.
	 *  
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		
	//String[][]tab=new String[height][width];
	char[][] charArray=(char[][]) lst.toArray();
		
	for (int i = 0; i <charArray.length; i++) {
		for (int j = 0; j < charArray.length; j++) {
			charArray[i][j]=charArray[(lst.get(i).substring(i,i+1)][i];
		}
	}
		// TODO Auto-generated method stub
		return null;
	}

}
