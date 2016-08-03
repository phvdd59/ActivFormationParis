package com.formation.etga.main;

import com.formation.etga.metier.ExoEtga;

public class MainTest {

	public static void main(String[] args) {
		ExoEtga exoEtga = new ExoEtga ();
		exoEtga.setMdpCache("ABcd08");
		System.out.println(exoEtga.getMdp());

	}

}
