package com.formation.made.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {

	public static int CPT = 0;
	public static int TEMPS = 10; // temps pour se deplacer d'un pixel
	public static int HAUTEUR_ETAGE = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private InterPersonne personne;
	private InterListPersonne listePersonne;
	private InterAffichage affichage;

	public Ascenseur(InterListPersonne listePersonne, InterAffichage affichage) {
		super(Integer.toString(CPT));
		this.etage = 0;
		this.progression = 0;
		this.fin = false;
		this.personne = null;
		this.listePersonne = listePersonne;
		this.affichage=affichage;
	}

	

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS*2);
			} catch (InterruptedException e) {
			}
			if (personne == null) {
				synchronized (listePersonne) { // une autre méthode consiste a synchronisé la méthode utilisant la liste de personne
					if (listePersonne.isSortie() && listePersonne.size() == 0) {
						fin = true;
					} else {
						personne = RecherchePersonneEnAttente();
						if (personne != null) {
							personne.setEtat(ETAT.DEPART);
							System.out.println(personne.toString());
						}
					}
				}
			} else {
				if (personne.getEtat() == ETAT.DEPART) {
					deplaceAscenseurVersDepart();
					System.out.println(personne.toString());
//					personne.setEtat(ETAT.ETAT_MOVE);
				} else if (personne.getEtat() == ETAT.MOVE) {
					
					deplaceAscenseurVersArrivee();
					System.out.println(personne.toString());
				} else if (personne.getEtat() == ETAT.ARRIVE) {
					System.out.println(personne.toString());
					personne = null;
				}
			}
			affichage.repaint();
		}
	}

	private void deplaceAscenseurVersDepart() {
		if (etage > personne.getDepart()) {
			progression--;
			if (progression%30 ==0) {
				etage--;	
			}

		} else if (etage < personne.getDepart()) {
			progression++;
			if (progression % 30 == 0) {
				etage++;
			}
		} else {
			if (personne.getEtat() == ETAT.DEPART) {
				personne.setEtat(ETAT.MOVE);
			} else {
				personne.setEtat(ETAT.ARRIVE);
			}
		}

	}

	private void deplaceAscenseurVersArrivee() {
		if (etage > personne.getArrivee()) {
			progression--;
			if (progression % 30 == 0) {
				etage--;
			}
		} else if (etage < personne.getArrivee()) {
			progression++;
			if (progression % 30 == 0) {
				etage++;
			}
		} else {
			personne.setEtat(ETAT.ARRIVE);

		}

	}

	private synchronized InterPersonne RecherchePersonneEnAttente() {// avec ça on dit que la méthode ne peut être utilisé que par un seul ascenseur a la fois
		InterPersonne personnedisponible = null;
		if (listePersonne != null) {
			if (listePersonne.size() > 0) {
				personnedisponible = listePersonne.remove(listePersonne.size() - 1);
			}
			/*
			 * for (int i = 0; i < listePersonne.size(); i++) {
			 * 
			 * } while (listePersonne.get(indice).getEtat()!=ETAT.ETAT_ATTENTE) { //si on a atteind la fin indice++; } personnedisponible=listePersonne.remove(indice); }
			 */
		}
		return personnedisponible;
	}

	public InterListPersonne getListePersonne() {
		return listePersonne;
	}

	public void mouvementAscenseur(int etage) {
		int difference = this.getEtage() - etage;
		if (difference > 0) { // mouvement descendant
			while (this.etage != etage)
				this.etage--;
		} else { // mouvement ascendant
			while (fin) {
				this.etage++;
			}
		}
	}

	public void setListePersonne(ListePersonne listePersonne) {
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

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
