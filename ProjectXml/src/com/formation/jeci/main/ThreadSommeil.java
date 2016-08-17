package com.formation.jeci.main;

public class ThreadSommeil extends Thread {
	private int nbDeReveil;

	public ThreadSommeil(int nbDeReveil) {
		this.nbDeReveil = nbDeReveil;
	}

	@Override
	public void run() {
		ThreadReveil threadReveil = new ThreadReveil();
		threadReveil.start();
		long tDebut = System.nanoTime();
		for (int i = 0; i < nbDeReveil; i++) {
			synchronized (threadReveil) {
				try {
					threadReveil.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long tEnCours = System.nanoTime();
				System.out.println("j'ai dormi:" + (tEnCours - tDebut) / 1000000);
			}
		}
		threadReveil.setSortir(true);
		System.out.println("arret de sommeil");
	}

}
