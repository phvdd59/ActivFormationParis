package com.formation.jeci.main;


public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil main = new MainSommeil();
		main.init();
	}

	public void init() {
ThreadSommeil threadSommeil=new ThreadSommeil(20);
threadSommeil.start();
	}
}
