package com.formation.made.exo;

import java.awt.Point;
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
	public char[][] solution(int width, int height, ArrayList<Terme> lst){// throws CruciException {
		char[][] tabcruci=null;
		tabcruci=new char[height][width];
		for (int i = 0; i < lst.size(); i++) {
			Terme terme=null;
			terme=lst.get(i);
			String stringTerme=terme.getNom();
			int intPointx=(int) terme.getPos().getX();
			int intPointy=(int) terme.getPos().getY();
			char[] tabCharTerme=stringTerme.toCharArray();
			if (terme.isSens()==false) {	
				for (int j = 0; j < tabCharTerme.length; j++) {
					tabcruci[intPointy][j]=tabCharTerme[j];
					System.out.println(tabcruci[intPointy][j]);
				}
			}
			else{
				for (int j = 0; j < tabCharTerme.length; j++) {
					tabcruci[j][intPointx]=tabCharTerme[j];
					System.out.println(tabcruci[j][intPointx]);
				}
			}
		}
		
		return tabcruci;
	}
}
