package com.formation.emma.metier;

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
	private InterListPersonne listP;
	private InterAffichage affichage;

	public Ascenseur(InterListPersonne lstP, InterAffichage affichage) {
		this.setName(Integer.toString(CPT));
		CPT++;
		etage = 0;
		personne = null;
		this.listP = lstP;
		this.affichage = affichage;
	}

	@Override
	public void run() {
		progression = 0;
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}

			if (personne == null) {
				
					synchronized (listP) {
						if (listP.size() == 0 && listP.isSortie()) {
						fin = true;
						} else {
							personne = rechercherPersEnAttente();
							personne.setEtat(ETAT.DEPART);
							
						}
					}

				} else {
					int deplacement1 = 0;
					int deplacement2 = 0;

					if (personne.getEtat() == ETAT.DEPART) {
						deplacement1 = getEtage() - personne.getDepart();
						deplacerAscenseur(deplacement1);
						if (etage == personne.getDepart()) {
							personne.setEtat(ETAT.MOVE);
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
							}
						}
					} else if (personne.getEtat() == ETAT.MOVE) {
						deplacement2 = personne.getDepart() - personne.getArrivee();
						deplacerAscenseur(deplacement2);
						if (etage == personne.getArrivee()) {
							personne.setEtat(ETAT.ARRIVE);
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
							}
						}
					} else if (personne.getEtat() == ETAT.ARRIVE) {
						personne = null;
					}
				}
			affichage.repaint();
			}
		}
	

	private void deplacerAscenseur(int deplacement) {

		if (deplacement > 0) {
			progression--;
			if (progression % HAUTEUR_ETAGE == 0) {
				etage--;
				progression = 0;
			}
			// change d'etage grace boucle while dans le run 
		} else if (deplacement < 0) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				etage++;
				progression = 0;
			}

		}
	}

	private InterPersonne rechercherPersEnAttente() { // peut mettre synchronized directement dans la methode mais si le fait les autres ascenseurs ne pourront pas utiliser la liste tant que la recherche ne sera pas terminée pour cet ascenseur 
		InterPersonne persDispo = null;
		for (int i = 0; i < listP.size(); i++) {
			if (listP.get(i).getEtat() == ETAT.ATTENTE) {
				persDispo = listP.remove(i);
				break;
			}
		}
		return persDispo;
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

	@Override
	public String toString() {
		return "Ascenseur " + this.getName() + " [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

}
