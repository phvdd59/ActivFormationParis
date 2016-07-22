package com.formation.phva.exo;

import java.util.ArrayList;

public interface InterExoArrayList1 {

	public ArrayList<Integer> remplirTableau(int d, int n, int p);

	public ArrayList<Integer> intervertirDeuxElementsTableau(ArrayList<Integer> tab, int i1, int i2);

	public ArrayList<Integer> insererUnElementDansTableau(ArrayList<Integer> tab, int p, int a);

	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> tab, int p, ArrayList<Integer> tab1);

	public ArrayList<Integer> rotationTableau(ArrayList<Integer> tab, int p);

}
