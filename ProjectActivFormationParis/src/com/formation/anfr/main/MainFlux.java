package com.formation.anfr.main;

import java.io.File;
import java.io.IOException;

import com.formation.anfr.ctr.TRI;
import com.formation.anfr.ctr.ListeMeuble;
public class MainFlux {
	public static void main(String[] args) {
		MainFlux mainFlux = new MainFlux();
		mainFlux.init();

	}

	public void init() {
		ListeMeuble lst = new ListeMeuble(TRI.ALPHA);
		File file = new File("ikae");
		lst.chargeListeMeuble(file);
		System.out.println(lst);
	}
}
