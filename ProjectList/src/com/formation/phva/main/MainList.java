package com.formation.phva.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.formation.phva.metier.Entrepot;
import com.formation.phva.metier.Wagon;
import com.formation.phva.metier.WagonResto;

public class MainList {

	public static void main(String[] args) {
		MainList mainList = new MainList();
		mainList.init();
	}

	public void init() {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		Integer o1 = Integer.valueOf(1);
		map.put("Un", o1);

		int vv = 3 + map.get("Un").intValue();
		Object o = map.get("Un");

		int u = (int) 3l;
		Object oo = 1l;

		if (oo.equals(o)) {
			System.out.println("=");
		} else {
			System.out.println("#");
		}

		if (oo instanceof Integer) {
			System.out.println("je suis un Integer");
		}

		map.put("Deux", new Integer(2));

		System.out.println(map.get("Un"));

		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("Premiere", 1);
		treeMap.put("Quatrieme", null);
		treeMap.put("Premiere", 2);
		treeMap.put("Premiere", 3);
		treeMap.put("Seconde", 4);
		treeMap.put("Ajout", 2);
		treeMap.put("Troisieme", null);
		System.out.println(treeMap);
		
		Set<Entry<String, Integer>> entrys = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey()+" "+entry.getValue()+" "+entry.getKey().hashCode());
		}
		System.out.println("----------------------------------------------------------");


		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Premiere", 1);
		hashMap.put("Quatrieme", null);
		hashMap.put("Premiere", 2);
		hashMap.put("Premiere", 3);
		hashMap.put("Seconde", 4);
		hashMap.put("Ajout", 2);
		hashMap.put("Troisieme", null);
		System.out.println(hashMap);

		Hashtable<String, Integer> hashT = new Hashtable<String, Integer>();
		hashT.put("Premiere", 1);
		hashT.put("Premiere", 2);
		hashT.put("Balle", 9);
		hashT.put("Premiere", 3);
		hashT.put("Seconde", 4);
		hashT.put("Ajout", 2);
		//hashT.put("Troisieme", null);
		System.out.println(hashT);
		
		Set<Entry<String, Integer>> entryset = hashT.entrySet();
		for (Entry<String, Integer> entry : entryset) {
			System.out.println(entry.getKey()+" "+entry.getValue()+" "+entry.getKey().hashCode());
		}
		
		

		TreeMap<Integer, ArrayList<Wagon>> mapEntrepots = new TreeMap<Integer, ArrayList<Wagon>>();
		ArrayList<Wagon> lstWagon = new ArrayList<Wagon>();
		WagonResto w1 = new WagonResto();
		//mapEntrepots.put(Wagon.WAGON_RESTO, w1);
		mapEntrepots.put(Wagon.WAGON_RESTO, lstWagon);
		ArrayList<Wagon> lstNew = mapEntrepots.get(Wagon.WAGON_RESTO);
		mapEntrepots.get(Wagon.WAGON_RESTO).add(w1);
		WagonResto w2 = new WagonResto(450);
		mapEntrepots.get(Wagon.WAGON_RESTO).add(w2);
		System.out.println(mapEntrepots.toString());

		Entrepot entrepotParis = new Entrepot();
		entrepotParis.fabrique(10);
		for (int i = 0; i < entrepotParis.size(); i++) {
			System.out.println(entrepotParis.get(i).toString());
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

	}

	public void init1() {
		int[] tab = { 1, 8, 5, 7, 6, 4, 2, 1 };
		ArrayList list = new ArrayList();
		System.out.println(list.size());
		list.add(new Integer(4));
		list.add(Integer.valueOf(tab[0]));
		System.out.println(list.size());
		System.out.println(list);
		Integer iv = new Integer(123);
		list.add(1, iv);
		list.add(new Long(3));
		list.add(new WagonResto());
		System.out.println(list);
		list.add("bonjour");
		list.remove(2);
		System.out.println(list.isEmpty());
		System.out.println(list.contains("bonjour"));
		System.out.println(list);
		list.remove(iv);
		System.out.println(list);
		Object o = list.get(2);
		if (o instanceof WagonResto) {
			WagonResto w = (WagonResto) o;
			w.setId(45864);
		}
		System.out.println(o + " " + iv);
		System.out.println(list);
		int j = list.indexOf("bonjour");
		System.out.println(j);
		list.clear();
		System.out.println("list = " + list);
		for (int val : tab) {
			// list.add(Integer.valueOf(val));
			list.add(val);
		}
		list.clear();
	}
}
