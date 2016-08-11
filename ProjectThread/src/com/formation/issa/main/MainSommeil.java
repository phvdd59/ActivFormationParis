package com.formation.issa.main;

import com.formation.phva.main.ThreadSommeil;

public class MainSommeil {

	public static void main(String[] args) {
		MainSommeil m=new MainSommeil();
		m.init();

	}

	public void init() {
		// TODO Auto-generated method stub
		ThreadSommeil threadSommeil=new ThreadSommeil(20);
		threadSommeil.start();
		
	}

}
