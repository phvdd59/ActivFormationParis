package com.formation.phva.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.phva.exception.CruciCroisementException;
import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.inter.InterAlgo4;
import com.formation.phva.metier.ListTerme;
import com.formation.phva.metier.Terme;

public class Cruci implements InterAlgo4 {

	private ListTerme lst;
	private char[][] tabCruci;

	public Cruci(ListTerme lst) throws CruciException {
		this.lst = lst;
		int hMax = 0;
		int wMax = 0;
		for (Terme terme : lst) {
			if (terme.getPos().x >= 0 && terme.getPos().getY() >= 0) {
				if (terme.isSens() == Terme.HORIZONTAL) {
					hMax = Math.max(hMax, terme.getPos().y);
					wMax = Math.max(wMax, terme.getPos().x + terme.getNom().length());
				} else {
					hMax = Math.max(hMax, terme.getPos().y + terme.getNom().length());
					wMax = Math.max(wMax, terme.getPos().x);
				}
			} else {
				throw new CruciDebordeException();
			}
		}
		tabCruci = creCruci(wMax+1, hMax+1, lst);
	}

	public char[][] creCruci(int width, int height, ArrayList<Terme> lst) throws CruciException {
		if (width <= 0) {
			throw new CruciWidthException();
		}
		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (lst == null) {
			throw new CruciNullException();
		}
		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}
		for (Terme ter : lst) {
			Terme terme = ter;
			if (ter.getNom().contains(" ")) {
				String[] t = ter.getNom().split(" ");
				terme = new Terme(t[0], new Point(ter.getPos().x, ter.getPos().y), ter.isSens());
			}
			char[] tab = terme.getNom().toCharArray();
			if (terme.isSens() == Terme.HORIZONTAL) {
				if (terme.getPos().y < 0 || terme.getPos().y >= height) {
					throw new CruciDebordeException(terme);
				}
				if (terme.getPos().x < 0 || terme.getPos().x + tab.length > width) {
					throw new CruciDebordeException(terme);
				}
				for (int i = 0; i < tab.length; i++) {
					try {
						if (cruci[terme.getPos().y][terme.getPos().x + i] != ' ' && cruci[terme.getPos().y][terme.getPos().x + i] != tab[i]) {
							throw new CruciCroisementException(terme, i);
						}
						cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
					} catch (CruciCroisementException e) {
					}
				}
			} else {
				if (terme.getPos().x < 0 || terme.getPos().x >= width) {
					throw new CruciDebordeException(terme);
				}
				if (terme.getPos().y < 0 || terme.getPos().y + tab.length > height) {
					throw new CruciDebordeException(terme);
				}
				for (int i = 0; i < tab.length; i++) {
					try {
						if (cruci[terme.getPos().y + i][terme.getPos().x] != ' ' && cruci[terme.getPos().y + i][terme.getPos().x] != tab[i]) {
							throw new CruciCroisementException(terme, i);
						}
						cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
					} catch (CruciCroisementException e) {
					}
				}
			}
		}
		return cruci;
	}

	public void afficher() {
		afficher(tabCruci);
	}

	public void afficher(char[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < tab[0].length; j++) {
				System.out.print(tab[i][j]);
				if (j < tab[0].length - 1) {
					System.out.print(" | ");
				}
			}
			System.out.println(" |");
		}
	}

}
