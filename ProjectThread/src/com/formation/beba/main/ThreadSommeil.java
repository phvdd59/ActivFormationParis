package com.formation.beba.main;

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
				}
				long tEnCours = System.nanoTime();
				System.out.println("J'ai dormi: " + (tEnCours - tDebut) / 1000000 + " mS");
			}

		}
		threadReveil.setSortir(true);
		System.out.println("Arret de Sommeil");

	}

}
