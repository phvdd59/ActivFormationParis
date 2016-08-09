package com.formation.joca.metier;

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
				System.out.println("j'ai dormis : " + ((tEnCours - tDebut) / 1000000));
			}
		}
		threadReveil.setSortir(true);
		System.out.println("arret de sommeil");
	}

}
