package com.formation.anfr.main;

import java.util.ArrayList;

import com.formation.anfr.metier.Entrepot;
import com.formation.anfr.metier.RER;
import com.formation.anfr.metier.WagonResto;

public class MainList {

	public static void main(String[] args) {
		MainList mainList = new MainList();
		mainList.init();
	}

	public void init() {
		Entrepot entrepotParis = new Entrepot();
		entrepotParis.fabrique(20);
		entrepotParis.fabrique(12);
/*		for (int i = 0; i < entrepotParis.size(); i++) {
			System.out.println(entrepotParis.get(i).toString());
		}*/
		entrepotParis.tri();
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
			//list.add(Integer.valueOf(val));
			list.add(val);
		}
		list.clear();
	}
}
