package com.formation.ambr.main;

import java.util.ArrayList;

import com.formation.ambr.ctr.Meuble;
import com.formation.ambr.ctr.TRI;

public class MainObject2 {

	public static void main(String[] args) {
		MainObject2 m = new MainObject2();
		m.init();
	}

	private void init() {
		Meuble meuble = new Meuble(TRI.ALPHA, "nom", "ref", "unite", 3f, 3f, 3f);
		ArrayList<Meuble> lst = new ArrayList<Meuble>();
		lst.add(meuble);
		//Collections.sort(lst);
		System.out.println(lst);
	}

}
