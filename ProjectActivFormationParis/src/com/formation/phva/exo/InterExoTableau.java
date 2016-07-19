package com.formation.phva.exo;

public interface InterExoTableau {

	public int[] remplirTableau(int d, int n, int p);

	public int[] inverserTableau(int[] tab);

	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2);

	public int[] rallongerTableauDeUnElement(int[] tab, int a);

	public int[] insererUnElementDansTableau(int[] tab, int p, int a);

	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1);

	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1);

	public int[][] changerDimensionTableau(int[] tab, int d);

	public int[] rotationTableau(int[] tab, int p);

	public int[] tabBaseDeux(int v);
}
