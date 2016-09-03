package com.formation.made.main;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil mainSommeil=new MainSommeil();
		mainSommeil.init();
	}

	private void init() {
		ThreadSommeil threadSommeil=new ThreadSommeil(5);
		threadSommeil.start();
	}

}
