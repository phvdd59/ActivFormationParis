package com.formation.thde.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {

	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;
	private int etage;
	private int progression = 0;
	private boolean fin;
	private InterPersonne personne;
	public InterListPersonne listPersonne;
	private InterAffichage affichage;

	public Ascenseur(int etage, int progression, boolean fin, Personne personne, InterListPersonne listPersonne, InterAffichage affichage) {
		this.etage = etage;
		this.progression = progression;
		this.fin = fin;
		this.personne = personne;
		this.listPersonne = listPersonne;
		this.affichage=affichage;
	}

	@Override
	public void run() {
		while (this.fin == false) {
			affichage.repaint();
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}
			if (this.personne == null) {

				if (listPersonne.size() == 0 && listPersonne.isSortie() == true) {
					this.fin = true;
				}
				synchronized (listPersonne) {
					if (listPersonne.size() > 0) {
						for (int i = 0; i < listPersonne.size(); i++) {
							if (listPersonne.get(i).getEtat() == ETAT.ATTENTE) {
								this.personne = listPersonne.remove(i);
								this.personne.setEtat(ETAT.DEPART);
								break;
							}
						}
					}
				}
			} else if (this.personne.getEtat() == ETAT.DEPART) {
				if (etage > personne.getDepart()) {
					progression--;
					if (progression % 30 == 0) {
						this.etage--;
						progression=0;
					}
				} else if (etage < personne.getDepart()) {
					progression++;
					if (progression % 30 == 0) {
						this.etage++;
						progression=0;
					}
				} else {
					this.personne.setEtat(ETAT.MOVE);
				}
			} else if (this.personne.getEtat() == ETAT.MOVE) {

				if (etage > personne.getArrivee()) {
					progression--;
					if (progression % 30 == 0) {
						this.etage--;
						progression=0;
					}
				} else if (etage < personne.getArrivee()) {
					progression++;
					if (progression % 30 == 0) {
						this.etage++;
						progression=0;
					}
				} else {
					this.personne.setEtat(ETAT.ARRIVE);
				}

			} else if (this.personne.getEtat() == ETAT.ARRIVE) {
				this.personne = null;
			}
		}
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

	public InterPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public InterListPersonne getListPersonne() {
		return listPersonne;
	}

	public void setListPersonne(ListePersonne listPersonne) {
		this.listPersonne = listPersonne;
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

}
