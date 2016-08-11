package com.formation.jeci.metier;

import com.formation.jeci.enume.ETAT;

public class Ascenseur extends Thread {

	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;
	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;
	private ListePersonne listePersonne;

	public Ascenseur(ListePersonne lst) {
		this.listePersonne = lst;
		this.etage = 0;
		this.progression = 0;

		this.personne = null;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public void run() {

		while (!fin) {

			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {

			}
			if (this.getPersonne() == null) {
				if (listePersonne.size() > 6) {

					synchronized (listePersonne) {
						if (listePersonne.size() == 0 && listePersonne.isSortie()) {
							fin = true;
						} else {
							personne = rechercherPersonneEnAttente();
							personne.setEtat(ETAT.ETAT_DEPART.ordinal());
						}

					}
				} else if (personne.getEtat() == ETAT.ETAT_DEPART.ordinal()) {
					deplacerAscenseurDepart();
				} else if (personne.getEtat() == ETAT.ETAT_MOVE.ordinal()) {
					deplacerAscenseurArrive();
				} else if (personne.getEtat() == ETAT.ETAT_ARRIVE.ordinal()) {
					personne = null;
				}
			}
		}
	}

	public Personne rechercherPersonneEnAttente() {
		Personne persDisponible = null;
		if (listePersonne != null) {
			if (listePersonne.get(listePersonne.size()).getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {

				persDisponible = listePersonne.remove(listePersonne.size() - 1);
			}
		}
		return persDisponible;

	}

	public void deplacerAscenseurArrive() {
		if (etage > personne.getArrive()) {
			if (progression % 30 == 0 && progression != 0) {
				etage--;

			} else {
				progression++;
			}

		} else if (etage < personne.getArrive()) {
			if (progression % 30 == 0 && progression != 0) {
				etage++;

			} else {
				progression++;
			}

		} else {
			personne.setEtat(ETAT.ETAT_ARRIVE.ordinal());

		}

	}

	public void deplacerAscenseurDepart() {
		if (etage > personne.getDepart()) {
			if (progression % 30 == 0 && progression != 0) {
				etage--;

			} else {
				progression++;
			}
		} else if (etage < personne.getDepart()) {
			if (progression % 30 == 0 && progression != 0) {
				etage++;

			} else {
				progression++;
			}
		} else {
			personne.setEtat(ETAT.ETAT_MOVE.ordinal());
		}

	}

	@Override
	public String toString() {
		return "Ascenseur " + this.getName() + "[etage=" + etage + ", personne=" + personne + "]";
	}

}
