package com.formation.ambr.metier;

public class Ascenseur extends Thread {

	public static int CPT = 0;
	public static int TEMPS = 10; // temps que l'ascenseur va mettre pour se déplacer d'un pixel
	public static int HAUTEUR_ETAGE = 30; // etage est de 30 pixels d'épaisseur. Grâce à ça on va pouvoir déplacer l'ascenseur graphiquement

	private int etage;
	private int progression; // valeur maximale = nbre d'étages * 30
	private boolean fin;
	private Personne personne;

	private ListePersonne listPers; // on a ajouté ça car on a fait le constructeur Ascenceur (ListePersonne listPers)

	public Ascenseur(ListePersonne listPers) {
		etage = 0;
		progression = 0;
		fin = false;
		personne = null;

		this.listPers = listPers;

	}

	@Override
	public void run() {
		// chaque ascenseur a une liste de personnes
		// existe-il une eprsonne en attente?

		while (!fin) { // dans le while on traite petite étape par petite étape
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}
			if (personne == null) { // 1) ai-je une personne dans mon ascenseur?
				synchronized (listPers) { // on aurait aussi pu mettre la méthode (ci-dessous) en synchronize. A ce moment là, les autres ascenseurs ne peuvent plus toucher à la méthode pendant qu'elle est utilisée. là on a verrouillé toute la liste de personne, pendant tout le code qui sera dans le bloc synchronize
					if (listPers.size() == 0 && listPers.isSortie()) {
						fin = true;
					} else {
						personne = rechercherPersonneEnAttente();
						personne.setEtat(ETAT.DEPART.ordinal());
					}
				}
			} else {
				if (personne.getEtat() == ETAT.DEPART.ordinal()) {
					// déplacer l'ascenseur jusqu'à la personne
					deplaceAscenseurVersDepart();
				} else if (personne.getEtat() == ETAT.MOVE.ordinal()) {
					// déplacer l'ascenseur avec la personne dedans, jusqu'à l'étage de destination
					deplaceAscenseurVersArrivee();
				} else if (personne.getEtat() == ETAT.ARRIVEE.ordinal()) {
					// retirer la personne de la liste
					personne = null;
				}
			}
		}
	}

	private void deplaceAscenseurVersArrivee() { // déplacer l'ascenseur avec la personne dedans, jusqu'à l'étage de destination. Qd arrivé, l'état de la pers passe de MOV à ARRIVEE
		if (etage > personne.getArrivee()) {
			etage--;
		} else if (etage < personne.getArrivee()) {
			etage++;
		} else {
			personne.setEtat(ETAT.ARRIVEE.ordinal());
		}
	}

	private void deplaceAscenseurVersDepart() { // déplacer l'ascenseur jusqu'à la personne. Qd arrivé, l'état de la pers passe de DEPART à MOVE
		if (etage > personne.getDepart()) {
			etage--;
		} else if (etage < personne.getDepart()) {
			progression = 0;
			if (progression < HAUTEUR_ETAGE) {
				progression++;
				if (progression == HAUTEUR_ETAGE) {
					etage++;
				}
			}

		} else {
			personne.setEtat(ETAT.MOVE.ordinal());
		}
	}

	private Personne rechercherPersonneEnAttente() {
		Personne persDisponible = null;
		if (listPers != null) {
			for (int i = 0; i < listPers.size(); i++) {
				if (listPers.get(i).getEtat() == ETAT.ATTENTE.ordinal()) {
					persDisponible = listPers.remove(i); // ceci contient un get implicite
					break;
				}
			}
		}
		return persDisponible;
	}

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static int getTEMPS() {
		return TEMPS;
	}

	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}

	public static int getHAUTEUR_ETAGE() {
		return HAUTEUR_ETAGE;
	}

	public static void setHAUTEUR_ETAGE(int hAUTEUR_ETAGE) {
		HAUTEUR_ETAGE = hAUTEUR_ETAGE;
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
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

}
