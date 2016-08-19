package com.formation.etga.ctr;

import com.formation.phva.exo.InterAlgo6;

public class ExoAlgo6 implements InterAlgo6{
	/**
	* Chronologiquement le nombre de vente est stocké dans un tableau. 
	* IKAE souhaite connaîre la période la plus faste des ventes.
	* Nous avons un tableau tab constitué d'entiers positifs.
	* Afin de ne pas être affecté par des valeurs ponctuelles anormales 
	* il sera nécessaire de lisser chaque élement du tableau par ses "n" voisins à gauche 
	* et à droite les plus proches,  
	* avant de calculer sur une fenêtre de "f" valeurs correspondantes à une période
	* celle la plus favorable (ie celle dont la somme la plus importante).
	* Attention on ne s'intéressera pas aux n premiers éléments et aux n derniers éléments.
	* 
	* example :
	* n=2
	* f=3
	*              24                   27                      20
	*       ----------------     ----------------        ----------------
	*       |      .       |     |      .       |        |      .       |
	* tab = [1 ,4 ,7 ,8 ,4 ,3 ,7 ,2 ,8 ,9 ,2 ,6 ,3 ,4 ,1 ,7 ,9 ,1 ,1 ,2 ] 
	*                             .  .  .                 .  .  .
	*                             29 28 27                22 19 20         
	*                            |        |              |        |
	*                            ----------              ----------
	*                             .                       .
	*                             84                      61
	* 
	* --> résultat indice :  7 --> valeurs maxi = 84 ([3+7+2+8+9]+[7+2+8+9+2]+[2+8+9+2+6])
	* 
	* Donnez le premier indice du tableau "tab" en partant de la gauche 
	* 	correspondant à la fenêtre "f" la plus favorable avec un lissage de n de part et d'autre.
	* 	En cas d'impossibilité renvoyer -1 
	*/
	
	public int solution(int[] tab, int n, int f) {
		int indice = -1;
		int [] tabSumN = new int [tab.length-(n*2)];
		int [] tabSumF = new int [tabSumN.length-f];
		
		if ((tab.length < (n*2+1)) ||(tab == null) || (n<0) ||(f<0)) {
			indice = -1;
		} else if (tab.length == 1) {
			indice = 0;
		} else {
			for (int i = n; i <=tab.length-n; i++) {
				for (int j = i-n; j < i+n; j++) {
					tabSumN[i] += tab[j];
				}
			}
			for (int i = 0; i <= tabSumN.length-f; i++) {
				for (int j = 0; j < f; j++) {
					tabSumF[i] += tabSumN[j];
				}
			}
			int max=0;
			for (int i=0; i<tabSumF.length+1; i++) {
			    if (tabSumF[i]< tabSumF[i+1]) {
				max=tabSumF[i+1];
			    }
			}
			indice = max+n;
		}	
		return indice;
	}
}