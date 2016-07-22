package com.formation.phva.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.formation.phva.metier.Entrepot;
import com.formation.phva.metier.RER;
import com.formation.phva.metier.WagonResto;

public class MainList {

	public static void main(String[] args) {
		MainList mainList = new MainList();
		mainList.init();
	}

	public void init() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(4);
		liste.add(5);
		liste.add(8);
		liste.add(-1);
		liste.add(2);
		liste.add(9);

		Collections.sort(liste);
		for (int i = 0; i < liste.size(); i++) {
			System.out.println(liste.get(i));
		}

	}

	public void init3() {
		Entrepot entrepotParis = new Entrepot();
		entrepotParis.fabrique(20);
		entrepotParis.fabrique(12);
		System.out.println(entrepotParis.get(entrepotParis.size() - 1));
		entrepotParis.fabrique(34);
		for (int i = 0; i < entrepotParis.size(); i++) {
			System.out.println(entrepotParis.get(i).toString());
		}
		RER rer = new RER();
		rer.add(entrepotParis.remove(0));
		rer.ajoutWagon(entrepotParis);
		entrepotParis.add(new WagonResto());

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
		Collections.sort(list);
		list.clear();
	}

	public void init2() {
		int[] t = { 1, 4, 9, 3, 5, 2 };
		boolean b = false;
		while (!b) {
			b = true;
			for (int i = 0; i < t.length - 1; i++) {
				if (t[i] > t[i + 1]) {
					b = false;
					int s = t[i];
					t[i] = t[i + 1];
					t[i + 1] = s;
				}
			}
		}
		System.out.println(Arrays.toString(t));
	}

	public int[] echanger(int[] t, int a, int b) {
		int s = t[a];
		t[a] = t[b];
		t[b] = s;
		return t;
	}

	public void init4() {
		int[] t = { 1, 4, 9, 3, 5, 2 };
		boolean b = false;
		int v = t.length;
		while (!b) {
			for (int i = 0; i < v - 1; i++) {
				if (t[i] > t[i + 1]) {
					echanger(t, i, i + 1);
				}
			}
		}
	}
}
