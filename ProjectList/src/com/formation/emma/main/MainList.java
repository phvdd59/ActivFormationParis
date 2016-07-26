package com.formation.emma.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.formation.emma.metier.Entrepot;
import com.formation.emma.metier.Entrepot2;
import com.formation.emma.metier.RER;
import com.formation.emma.metier.Wagon;
import com.formation.emma.metier.WagonResto;

public class MainList {

	public static void main(String[] args) {
		MainList mainList = new MainList();
		mainList.init();
	}

	public void init() {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("un", new Integer(1)); //tree maps conserve en 1er une clé et en 2ie valeur un objet
		map.put("deux", new Integer(2));
		System.out.println(map.get("un"));

		TreeMap<Integer, ArrayList<Wagon>> mapEntrepot = new TreeMap<Integer, ArrayList<Wagon>>();
		mapEntrepot.put(Wagon.WAGON_RESTO, new ArrayList<Wagon>());
		WagonResto w2 = new WagonResto(450);
		mapEntrepot.get(WagonResto.WAGON_RESTO).add(w2);
		System.out.println(mapEntrepot);

		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
		tmap.put("premiere", 1);
		tmap.put("premiere", 2);
		tmap.put("ajout", 8);
		tmap.put("premiere", 3);
		tmap.put("seconde", 4);
		tmap.put("troisieme", null);
		System.out.println(tmap); // ecrase les valeurs si change,

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("premiere", 1);
		hashMap.put("premiere", 2);
		hashMap.put("ajout", 8);
		hashMap.put("premiere", 3);
		hashMap.put("seconde", 4);
		hashMap.put("troisieme", null);
		System.out.println(hashMap); // ecrase les valeurs si change, 

		Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>();
		hashTable.put("premiere", 1);
		hashTable.put("premiere", 2);
		hashTable.put("ajout", 8);
		hashTable.put("premiere", 3);
		hashTable.put("seconde", 9);
		//hashTable.put("troisieme", null);
		System.out.println(hashTable); // ecrase les valeurs si change, refuse les null

		// tree map ordre alphabetique
		// hash map pas de vrai ordre
		// hash table pas de vrai ordre

		// entry converti une map sous forme de set (set etant une sorte de tableau à 2 dimensions)
		Set<Entry<String, Integer>> entryset = hashTable.entrySet();
		for (Entry<String, Integer> entry : entryset) {
			System.out.println(entry.getKey() + " " + entry.getValue() + " " + entry.getKey().hashCode());
		}

		System.out.println("exo train");

		Entrepot entrepotParis = new Entrepot();
		entrepotParis.fabrique(10);
		for (int i = 0; i < entrepotParis.size(); i++) {
		//	System.out.println(entrepotParis.get(i).toString());
		}
		System.out.println("");
		/*
		 * for (int i = 0; i < entrepotParis.size(); i++) {
		 * System.out.println(entrepotParis.get(i).toString()); }
		 */
		// entrepotParis.tri1();
		Collections.sort(entrepotParis);
		for (int i = 0; i < entrepotParis.size(); i++) {
			System.out.println(entrepotParis.get(i).toString());
		}

		Entrepot2 entrepotOrleans = new Entrepot2();
		entrepotOrleans.fabrique(10);
		
	}

}
