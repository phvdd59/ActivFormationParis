package com.formation.anfr.ctr;

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
		int soluce = -1;
		try {
			if ((tab.length>2*n)&&(tab.length-2*n>f)) {
			int[] tab2 = new int[tab.length-2*n];
			for (int i = 0; i < tab2.length; i++) {
				tab2[i]=Somme(tab,(2*n+1),i);
			}
			int[] tab3 = new int[tab2.length-f+1];
			int max = 0;
			for (int i = 0; i < tab2.length-f+1; i++) {
				tab3[i]=Somme(tab2,f,i);
				if (tab3[i] > max){
					max = tab3[i];
					soluce = i+n;
				}
			}
			}
		} catch (NullPointerException e) {
		}
		return soluce;
	}
	
	public int Somme(int[] tab,int nombre, int depart){
		int soluce = 0;
		for (int j = depart; j <depart +nombre ; j++) {
			soluce += tab[j];
		}
		return soluce;
	}
	
}
