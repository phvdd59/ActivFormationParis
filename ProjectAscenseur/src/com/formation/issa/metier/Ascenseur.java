package com.formation.issa.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {
	public static int CPT = 0;
	public static int TEMPS = 10; // vitesste à laquelle l'ascenseur va bouger
	public static int HAUTEUR_ETAGE = 30;
	private int etage;
	private int progression;
	private InterPersonne personne;
	private boolean fin;
	private InterListPersonne listPersonne;
	private InterAffichage affichage;

	public Ascenseur() {
		this.setHAUTEUR_ETAGE(HAUTEUR_ETAGE);
		this.setEtage(etage);

	}

	public Ascenseur(InterListPersonne listPersonne, InterAffichage affichage) {
		super(Integer.toString(CPT));
		this.listPersonne = listPersonne;
		etage = 0;
		progression = 0;
		fin = false;
		personne = null;
		CPT++;
		this.affichage = affichage;

	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
				// recherche de personnes
				if (personne == null) {
					synchronized (listPersonne) {
						if (listPersonne.size() == 0 && listPersonne.isSortie()) {
							fin = true;
						} else {
							this.personne = rechercherPersonneEnAttente();
							if (this.personne != null) {
								this.personne.setEtat(ETAT.DEPART);
							}
						}

					}
				} else {
					if (personne.getEtat() == ETAT.DEPART) {
						this.deplaceAscenseurversDepart();
					} else if (personne.getEtat() == ETAT.MOVE) {
						deplaceAscenseurversArrivee();
					} else if (personne.getEtat() == ETAT.ARRIVEE) {
						personne = null;
					}
				}
			} catch (InterruptedException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			affichage.repaint();

		}

	}

	private InterPersonne rechercherPersonneEnAttente() {
		InterPersonne persDisponible = null;
		if (listPersonne.size() > 0) {
			persDisponible = listPersonne.remove(listPersonne.size() - 1);
		}
		// if (listPersonne != null) {
		// int indice = 0;
		// while (indice < listPersonne.size() &&
		// listPersonne.get(indice).getEtat() != ETAT.ATTENTE) {
		// indice++;
		// }
		// if (indice != listPersonne.size()) {
		// persDisponible = listPersonne.remove(indice);
		// }
		//
		// }
		return persDisponible;
	}

	private void deplaceAscenseurversDepart() {
		if (this.etage > this.personne.getDepart()) {
			progression--;
			if (progression % 30 == 0) {
				progression = 0;
				etage--;

			}
		} else if (etage < personne.getDepart()) {
			progression++;
			if (progression % 30 == 0) {
				progression = 0;

				etage++;

			}

		} else {
			personne.setEtat(ETAT.MOVE);
		}
	}

	private void deplaceAscenseurversArrivee() {
		if (etage > personne.getArrivee()) {
			progression--;
			if (progression % 30 == 0) {
				progression = 0;
				etage--;

			}

		} else if (etage < personne.getArrivee()) {
			progression++;
			if (progression % 30 == 0) {
				progression = 0;

				etage++;

			}

		} else {
			personne.setEtat(ETAT.ARRIVEE);

		}

	}

	// public void MonteeAscenseur() {
	// int etageInitial = personne.getDepart();
	// int etageArrivee = personne.getArrivee();
	// while (etageInitial < etageArrivee) {
	// for (int i = etageInitial; i < etageArrivee; i++) {
	// etage++;
	// System.out.println("étage = " + etage);
	// }
	// }
	//
	// }
	//
	// public void DescenteAscenseur() {
	// int etageInitial = personne.getDepart();
	// int etageArrivee = personne.getArrivee();
	// while (etageArrivee > etageInitial) {
	// for (int i = etageArrivee; i > etageInitial; i--) {
	// etage--;
	// System.out.println("étage =" + etage);
	// }
	// }
	//
	// }

	private boolean isfin() {
		return fin;
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

	public InterPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", personne=" + personne + "]";
	}

}
