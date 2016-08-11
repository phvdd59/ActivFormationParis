package com.formation.emma.main;

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
			synchronized (threadReveil) { // protection de threadReveil. Tout le synchronized ne peut pas etre modifier par une autre action (le sommeil reste)
				try {
					threadReveil.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				long tEnCours = System.nanoTime();
				System.out.println("j'ai dormi : " + ((tEnCours - tDebut) / 1000000) + "ms");
			}
		}
		threadReveil.setSortir(true);
		System.out.println("arrêt de sommeil");
	}
}
