package com.formation.etga.metier;

public class ThreadSommeil extends Thread {

	private int nbDeReveil;

	public ThreadSommeil(int nbDeReveil) {
		this.nbDeReveil = nbDeReveil;
	}

	@Override
	public void run() {
		ThreadReveil threadReveil = new ThreadReveil();
		threadReveil.start();
		
		for (int i = 0; i < nbDeReveil; i++) {
			long tDebut = System.nanoTime();
			synchronized (threadReveil) {
				try {
					threadReveil.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long tEnCours = System.nanoTime();
				System.out.println("J'ai dormi : " + ((tEnCours - tDebut) / 100000));
			}
		}
		threadReveil.setSortir(true);
		System.out.println("arret de sommeil");
	}
}