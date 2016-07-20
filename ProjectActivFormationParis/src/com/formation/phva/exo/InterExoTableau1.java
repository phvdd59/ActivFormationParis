package com.formation.phva.exo;

public interface InterExoTableau1 {

	public int[] remplirTableau(int d, int n, int p);

	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2);

	public int[] insererUnElementDansTableau(int[] tab, int p, int a);

	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1);

	public int[] rotationTableau(int[] tab, int p);

}
