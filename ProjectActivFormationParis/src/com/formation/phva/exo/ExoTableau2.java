package com.formation.phva.exo;

public class ExoTableau2 implements com.formation.phva.exo.InterExoTableau2 {

	/** Exemple
	 * tab = [1,4,6,-5,7,5]
	 * @param tab tableau en entrée
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		return null;
	}

	/** Exemple
	 *  [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * @param tab tableau de départ
	 * @param a  valeur à ajouter à la fin
	 * @return 
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		return null;
	}

	/** Exemple
	 *  [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * @param tab tableau de départ
	 * @param p position où il faut insérer le 2ème tableau
	 * @param tab1 tableau à insérer
	 * @return tableau 
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		return null;
	}

	/** Exemple 1
	 * [1,7,8,2,4,6] : d=2 --> [1,7]   
	 *                 		   [8,2]    
	 *                         [4,6]
	 * Exemple 2    
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8]
	 *                        [2,4,6] 
	 *                    
	 * @param tab tableau en entrée
	 * @param d : nb d'element de la 1ere dimension  
	 * @return tableau de 2 dimensions  
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		return null;
	}

	/** Exemple
	 *  v=18 --> résultat [1,0,0,1,0]
	 * @param v  valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		return null;
	}
}