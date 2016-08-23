package com.formation.ambr.ctrSave;

import com.formation.phva.inter.InterAlgo6;

public class ExoAlgo6 implements InterAlgo6{
	/**
	* Chronologiquement le nombre de vente est stock� dans un tableau. 
	* IKAE souhaite conna�re la p�riode la plus faste des ventes.
	* Nous avons un tableau tab constitu� d'entiers positifs.
	* Afin de ne pas �tre affect� par des valeurs ponctuelles anormales 
	* il sera n�cessaire de lisser chaque �lement du tableau par ses "n" voisins � gauche 
	* et � droite les plus proches,  
	* avant de calculer sur une fen�tre de "f" valeurs correspondantes � une p�riode
	* celle la plus favorable (ie celle dont la somme la plus importante).
	* Attention on ne s'int�ressera pas aux n premiers �l�ments et aux n derniers �l�ments.
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
	* --> r�sultat indice :  7 --> valeurs maxi = 84 ([3+7+2+8+9]+[7+2+8+9+2]+[2+8+9+2+6])
	* 
	* Donnez le premier indice du tableau "tab" en partant de la gauche 
	* 	correspondant � la fen�tre "f" la plus favorable avec un lissage de n de part et d'autre.
	* 	En cas d'impossibilit� renvoyer -1 
	*/
	
	public int solution(int[] tab, int n, int f) {
		// protection si i < n
		
		int sommeN = 0;
		int sommeF = 0;
		int[] tabN = new int[(n*2)+1];
		int[] tabNGrand = new int[tab.length-(n*2)];
		int[] tabF = new int[tabNGrand.length/2];
		int[] tabFGrand = new int[tabF.length];
		int k = 0;
		int x=0;
		int y=0;
		int z=0;
		
		for (int i = n; i < tab.length; i++) {
			for (int j = (i-n); j <= (i+n); j++) {
				tabN[k]=tab[j];
				sommeN+=tabN[k];
				k++;
			}
			tabNGrand[x]=sommeN;
			x++;
		}
		
		for (int m = 0; m <= tabNGrand.length; m++) {
			for (int l = m; l <= (m+(f-1)); l++) {
				tabF[y]=tab[l];
				sommeF+=tabF[y];
				y++;
			}
			tabFGrand[z]=sommeF;
			z++;
		}
		
		for (int o = 0; o < tabFGrand.length; o++) {
			
		}
		
		
		return 0;
	}
}
