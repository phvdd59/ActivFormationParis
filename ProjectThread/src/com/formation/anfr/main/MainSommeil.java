package com.formation.anfr.main;

public class MainSommeil {
	public static void main(String[] args){
		MainSommeil m =new MainSommeil();
		m.init();
	}

	private void init() {
		ThreadSommeil threadSommeil = new ThreadSommeil(20);
		threadSommeil.start();
		
	}
}
