package com.formation.etga.main;

import com.formation.etga.metier.ThreadSommeil;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil mainSommeil = new MainSommeil();
		mainSommeil.init();
	}
	
	public void init() {
		ThreadSommeil threadSommeil = new ThreadSommeil(20);
		threadSommeil.start();
	}
}
