package com.formation.soka.main;

import com.formation.soka.metier.ThreadSommeil;

public class MainSommeil {

	public static void main(String[] args) {

		MainSommeil main = new MainSommeil();
		main.init();

	}

	public void init() {
		ThreadSommeil threadSommeil = new ThreadSommeil(20);
		threadSommeil.start();
	}

}