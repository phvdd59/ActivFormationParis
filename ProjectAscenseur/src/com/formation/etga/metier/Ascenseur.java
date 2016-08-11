package com.formation.etga.metier;

import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;

	private InterListPersonne lstPersonne;
	private InterPersonne personne;
	private int etage;
	private int progression;
	private boolean fin;

	public Ascenseur(InterListPersonne lstPersonne) {
		this.lstPersonne = lstPersonne;
		this.personne = null;
		this.etage = 0;
		this.progression = 0;
		this.fin = true;
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}
			if (personne == null) {
				synchronized (lstPersonne) {
					if (lstPersonne.isSortie()) {
						fin = true;
					} else {
						personne = rechercherPersonneEnAttente();
						personne.setEtat(ETAT.DEPART);
					}
				}
			} else {
				if (personne.getEtat() == (ETAT.DEPART)) {
					deplaceAscenseurVersDepart();
				} else if (personne.getEtat() == (ETAT.MOVE)) {
					deplaceAscenseurVersArrive();
				} else if (personne.getEtat() == (ETAT.ARRIVE)) {
					personne = null;
				}
			}
		}
	}

	private void deplaceAscenseurVersDepart() {
		if (etage > personne.getDepart()) {
			if (progression % 30 == 0) {
				etage--;
				progression = 0;
			} else {
				progression++;
			}
		} else if (etage < personne.getDepart()) {
			if (progression % 30 == 0) {
				etage++;
				progression = 0;
			} else {
				progression++;
			}
		} else {
			personne.setEtat(ETAT.MOVE);
		}
	}

	private void deplaceAscenseurVersArrive() {
		if (etage > personne.getArrivee()) {
			if (progression % 30 == 0) {
				etage--;
				progression = 0;
			} else {
				progression++;
			}
		} else if (etage < personne.getArrivee()) {
			if (progression % 30 == 0) {
				etage++;
				progression = 0;
			} else {
				progression++;
			}
		} else {
			personne.setEtat(ETAT.ARRIVE);
		}
	}

	private InterPersonne rechercherPersonneEnAttente() {
		InterPersonne personneDisponible = null;
		if (lstPersonne != null) {
			for (int i = 0; i < lstPersonne.size(); i++) {
				if (lstPersonne.get(i).getEtat() == ETAT.ATTENTE) {
					personneDisponible = lstPersonne.remove(i);
					break;
				}
			}
		}
		return personneDisponible;
	}

	public static int getCPT() {
		return CPT;
	}

	public static int getTEMPS() {
		return TEMPS;
	}

	public static int getHAUTEUR_ETAGE() {
		return HAUTEUR_ETAGE;
	}

	public int getEtage() {
		return etage;
	}

	public int getProgression() {
		return progression;
	}

	public boolean isFin() {
		return fin;
	}

	public InterPersonne getPersonne() {
		return personne;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}

	public static void setHAUTEUR_ETAGE(int hAUTEUR_ETAGE) {
		HAUTEUR_ETAGE = hAUTEUR_ETAGE;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public void setPersonne(InterPersonne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";

	}
}