package com.formation.joca.main;

import com.formation.joca.metier.ThreadSommeil;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil m = new MainSommeil();
		m.init();
	}

	private void init() {
		ThreadSommeil sommeil = new ThreadSommeil(3);
		sommeil.start();
	}

}
