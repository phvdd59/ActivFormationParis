package com.formation.jeci.metier;

import com.formation.jeci.enume.ETAT;
import com.formation.phva.inter.InterAffichage;
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
	private InterAffichage affichage;

	public Ascenseur(InterListPersonne lst, InterAffichage affichage) {

		super(Integer.toString(CPT));
		this.listePersonne = lst;
		this.etage = 0;
		this.progression = 0;

		this.personne = null;
		this.affichage = affichage;
		CPT++;
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

	@Override
	public void run() {

		while (!fin) {
			// affichage.repaint();
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {

			}
			if (listePersonne.size() != 0) {

				if (personne == null) {

					synchronized (listePersonne) {
						if (listePersonne.size() == 0 && listePersonne.isSortie()) {
							// fin = true;
						} else {
							personne = rechercherPersonneEnAttente();
							personne.setEtat(ETAT.DEPART);
						}

					}
				} else if (personne.getEtat() == ETAT.DEPART) {
					deplacerAscenseurDepart();

				} else if (personne.getEtat() == ETAT.MOVE) {
					deplacerAscenseurArrive();
				} else if (personne.getEtat() == ETAT.ARRIVE) {
					personne = null;
				}
			}
			affichage.repaint();
		}
	}

	public InterPersonne rechercherPersonneEnAttente() {
		InterPersonne persDisponible = null;
		if (listePersonne != null) {
			if (listePersonne.size() > 0) {
				persDisponible = listePersonne.get(listePersonne.size() - 1);
				persDisponible = listePersonne.remove(listePersonne.size() - 1);
			}
		}
		return persDisponible;

	}

	public void deplacerAscenseurArrive() {
		if (etage > personne.getArrivee()) {
			if (progression % 30 == 0 && progression != 0) {
				etage--;
				progression = 0;

			} else {
				progression--;
			}

		} else if (etage < personne.getArrivee()) {
			if (progression % 30 == 0 && progression != 0) {
				etage++;
				progression = 0;

			} else {
				progression++;
			}

		} else {
			personne.setEtat(ETAT.ARRIVE);

		}

	}

	public void deplacerAscenseurDepart() {
		if (etage > personne.getDepart()) {
			if (progression % 30 == 0 && progression != 0) {
				etage--;
				progression = 0;

			} else {
				progression--;
			}
		} else if (etage < personne.getDepart()) {
			if (progression % 30 == 0 && progression != 0) {
				etage++;
				progression = 0;

			} else {
				progression++;
			}
		} else {
			personne.setEtat(ETAT.MOVE);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "Ascenseur " + this.getName() + "[etage=" + etage + ", personne=" + personne + "]";
	}

}
