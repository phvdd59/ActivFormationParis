package com.formation.anfr.main;

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
					e.printStackTrace();
				}
				long tEncours = System.nanoTime();
				System.out.println("J'ai dormi : " + ((tEncours - tDebut) / 100000));

			}
		
		}
		threadReveil.setSortir(true);
		System.out.println("arret du Sommeil");
	}

}
