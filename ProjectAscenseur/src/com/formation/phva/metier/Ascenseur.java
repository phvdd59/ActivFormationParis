package com.formation.phva.metier;

import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 1000;
	public static int HAUTEUR_ETAGE = 30;

	private ListePersonne listePersonne;
	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;

	public Ascenseur(ListePersonne listePersonne) {
		this.listePersonne = listePersonne;
		etage = 0;
		progression = 0;
		fin = false;
		personne = null;
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}
			if (personne == null) {
				synchronized (listePersonne) {
					if (listePersonne.size() == 0 && listePersonne.sortie) {
						fin = true;
					} else {
						personne = rechercherPersonneEnAttente();
						personne.etat = ETAT.DEPART.ordinal();
					}
				}
			} else {
				if (personne.etat == ETAT.DEPART.ordinal()) {
					deplaceAscenceurVersDepart();
				} else if (personne.etat == ETAT.MOVE.ordinal()) {
					deplaceAscenceurVersArrive();
				} else if (personne.etat == ETAT.ARRIVE.ordinal()) {
					personne = null;

				}
			}
		}
	}

	private void deplaceAscenceurVersArrive() {
		if (etage > personne.arrivee) {
			etage--;
		} else if (etage < personne.arrivee) {
			etage++;
		} else {
			personne.etat = ETAT.ARRIVE.ordinal();
		}
	}

	private void deplaceAscenceurVersDepart() {
		if (etage > personne.depart) {
			etage--;
		} else if (etage < personne.depart) {
			etage++;
		} else {
			personne.etat = ETAT.MOVE.ordinal();
		}
	}

	private Personne rechercherPersonneEnAttente() {
		Personne persDisponible = null;
		if (listePersonne != null) {
			if (listePersonne.size() > 0) {
				persDisponible = listePersonne.remove(listePersonne.size() - 1);
			}
			/*
			for (int i = 0; i < listePersonne.size(); i++) {
				if (listePersonne.get(i).getEtat() == ETAT.ATTENTE.ordinal()) {
					persDisponible = listePersonne.remove(i);
					break;
				}
			}
			*/
			/*
			int ind = 0;
			while (ind < listePersonne.size() && listePersonne.get(ind).getEtat() != ETAT.ATTENTE.ordinal()) {
				ind++;
			}
			if (ind != listePersonne.size()) {
				persDisponible = listePersonne.remove(ind);
			}
			*/
		}
		return persDisponible;
	}
}
