package com.formation.joca.metier;

import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {

	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private InterPersonne personne;
	private InterListPersonne listePersonne;

	public Ascenseur(InterListPersonne lstPers) {
		this.etage = 0;
		this.progression = 0;
		this.fin = false;
		this.personne = null;
		this.listePersonne = lstPers;
		this.CPT++;
	}

	public InterListPersonne getListePersonne() {
		return listePersonne;
	}

	public void setListePersonne(InterListPersonne listePersonne) {
		this.listePersonne = listePersonne;
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

	public InterPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(InterPersonne personne) {
		this.personne = personne;
	}

	public void trouverPersonne() {
		InterPersonne personneTrouve = null;
		boolean trouve = false;
		int nb = 0;
		synchronized (listePersonne) {
			if (listePersonne.size() != 0) {
				while (!trouve && nb < listePersonne.size()) {
					if (this.getListePersonne().get(nb).getEtat() == ETAT.ATTENTE) {
						personneTrouve = this.getListePersonne().get(nb);
						personneTrouve.setEtat(ETAT.DEPART);
						trouve = true;
					}
					nb++;
				}
			}
		}
		this.setPersonne(personneTrouve);
	}

	public void deplacer(int destination) {
		if (destination > this.getEtage()) {
			if (progression % 30 == 0 && progression != 0) {
				this.etage++;
				progression = 0;
			} else {
				progression++;
			}
		} else if (destination < this.getEtage()) {

			if (progression % 30 == 0) {
				this.etage--;
				progression = 0;
			} else {
				progression--;
			}
		}
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}

			if (this.getPersonne() == null) {
				this.trouverPersonne();
				if (personne == null) {
					this.fin = true;
				}
			} else if (this.getPersonne().getEtat() == ETAT.DEPART) {
				if (this.getEtage() != this.getPersonne().getDepart()) {
					this.deplacer(this.getPersonne().getDepart());
				} else {
					synchronized (listePersonne) {
						this.getPersonne().setEtat(ETAT.MOVE);
					}
				}
			} else if (this.getPersonne().getEtat() == ETAT.MOVE) {
				if (this.getEtage() != this.getPersonne().getArrivee()) {
					this.deplacer(this.getPersonne().getArrivee());
				} else {
					synchronized (listePersonne) {
						this.getPersonne().setEtat(ETAT.ARRIVE);
					}
				}
			} else if (this.getPersonne().getEtat() == ETAT.ARRIVE) {
				synchronized (listePersonne) {
					this.getListePersonne().remove(this.getPersonne());
				}
				System.out.println(this.getName() + " " + this.getPersonne().toString());
				this.setPersonne(null);
			}
		}
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne
				+ ", CPT=" + CPT + ", name=" + this.getName() + "]";
	}

}
