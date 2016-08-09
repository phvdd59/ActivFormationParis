package com.formation.thde.main;

import com.formation.thde.metier.ThreadSommeil;

public class MainSommeil {
	public static void main(String[] args) {
		MainSommeil m = new MainSommeil();
		m.init();
	}

	private void init() {
		ThreadSommeil threadSommeil = new ThreadSommeil(20);
		threadSommeil.start();
	}
}
