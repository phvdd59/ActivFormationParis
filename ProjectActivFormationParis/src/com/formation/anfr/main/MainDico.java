package com.formation.anfr.main;

import com.formation.anfr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();
	}
 public void init() {
	 Dico dic = new Dico();
	 dic.ranger("Note that the ordering maintained by a tree map, like any sorted map, and whether or not an explicit comparator is provided, must be consistent with equals if this sorted map is to correctly implement the Map interface. (See Comparable or Comparator for a precise definition of consistent with equals.) This is so because the Map interface is defined in terms of the equals operation, but a sorted map performs all key comparisons using its compareTo (or compare) method, so two keys that are deemed equal by this method are, from the standpoint of the sorted map, equal. The behavior of a sorted map is well-defined even if its ordering is inconsistent with equals; it just fails to obey the general contract of the Map interface. ");
	 System.out.println(dic.getListeMot("d", 3));
	 System.out.println(dic.getListeMot("t", 4));
	 System.out.println(dic.getListeMot("t", 3));
	 System.out.println(dic.getListeMot("m", 3));
 }
}
