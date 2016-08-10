package com.formation.phva.main;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil m=new MainSommeil();
		m.init();
				
	}
	
	public void init() {
		ThreadSommeil threadSommeil=new ThreadSommeil(20);
		threadSommeil.start();
	}
}
