package com.formation.soka.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur, InterAffichage {
	public static int CPT = 0;
	public static int TEMPS = 10;
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
		this.affichage = affichage;
		CPT++;
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (personne == null) {
				synchronized (listePersonne) {
					// Le synchronized ne prend que la recherche car on a fait un remove dedans! 
					if (listePersonne.size() == 0 && listePersonne.isSortie()) {
						fin = true;

					} else {
						personne = rechercherPersonneEnAttente();
						if (personne == null) {
						}

						else {
							personne.setEtat(Etat.ETAT_DEPART);
							System.out.println(Thread.currentThread().getName() + " nom A : " + personne.getNom() + " etat A : " + personne.getEtat());
						}
					}
				}
			} else {
				if (personne.getEtat() == Etat.ETAT_DEPART) {
					deplacerAscenseurVersDepart();
					System.out.println(Thread.currentThread().getName() + " nom A : " + personne.getNom() + " etat A : " + personne.getEtat());

				} else if (personne.getEtat() == Etat.ETAT_MOVE) {
					deplacerAscenseurVersArrive();
					System.out.println(Thread.currentThread().getName() + " nom A : " + personne.getNom() + " etat A : " + personne.getEtat());

				} else if (personne.getEtat() == Etat.ETAT_ARRIVE) {
					System.out.println(Thread.currentThread().getName() + " nom A : " + personne.getNom() + " etat A : " + personne.getEtat());

					personne = null;
				}
			}
			affichage.repaint();
			//			synchronized (listePersonne) {
			//				for (Personne p : listePersonne) {
			//					System.out.println("toto");
			//					System.out.println(p + " Je suis dans ascenseur");
			//					if (p.getEtat() == Etat.ETAT_ATTENTE.ordinal()) {
			//						p.setEtat(Etat.ETAT_DEPART.ordinal());
			//						System.out.println("nom A : " + p.getNom() + " etat A : " + p.getEtat());
			//					}
			//					if (p.getEtat() == Etat.ETAT_DEPART.ordinal()) {
			//						p.setEtat(Etat.ETAT_MOVE.ordinal());
			//						this.etage = p.getDepart();
			//						System.out.println("nom A : " + p.getNom() + " etat A : " + p.getEtat());
			//					}
			//					if (p.getEtat() == Etat.ETAT_MOVE.ordinal()) {
			//						p.setEtat(Etat.ETAT_ARRIVE.ordinal());
			//						this.etage = p.getArrive();
			//						System.out.println("nom A : " + p.getNom() + " etat A : " + p.getEtat());
			//						personne = null;
			//					}
			//					if (listePersonne.isEmpty()) {
			//						fin = true;
			//					}
			//					listePersonne.remove(p);
			//				}
			//			}

		}

	}

	public InterPersonne rechercherPersonneEnAttente() {
		InterPersonne personneDispo = null;
		if (listePersonne != null) {
			if (listePersonne.size() > 0) {
				personneDispo = listePersonne.remove(listePersonne.size() - 1);
			}
			//			System.out.println("nom A : " + personneDispo.getNom() + " etat A : " + personneDispo.getEtat());
			//
			//			/*for (int i = 0; i < listePersonne.size(); i++) {
			//				if (listePersonne.get(i).getEtat() == Etat.ETAT_ATTENTE.ordinal()) {
			//					personneDispo = listePersonne.remove(i);
			//					break;
			//				}
			//			}
			//				*/
			//		}

			//		for (Personne personne : listePersonne) {
			//			if (personne.getEtat() == Etat.ETAT_ATTENTE.ordinal()) {
			//				personneDispo = personne;
			//				personneDispo.setEtat(Etat.ETAT_DEPART.ordinal());
			//				System.out.println(Thread.currentThread().getName() + " nom A : " + personne.getNom() + " etat A : " + personne.getEtat());
			//				listePersonne.remove(personneDispo);
			//				break;
			//			}
		}
		return personneDispo;
	}

	private void deplacerAscenseurVersDepart() {
		if (etage > personne.getDepart()) {
			progression--;
			if (progression % HAUTEUR_ETAGE == 0) {
				progression = 0;
				etage--;
			}
		} else if (etage < personne.getDepart()) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				progression = 0;
				etage++;
			}
		} else {
			if (personne.getEtat() == Etat.ETAT_DEPART) {
				personne.setEtat(Etat.ETAT_MOVE);
			} else {
				personne.setEtat(Etat.ETAT_ARRIVE);
			}
		}

	}

	private void deplacerAscenseurVersArrive() {
		if (etage > personne.getArrivee()) {
			progression--;
			if (progression % HAUTEUR_ETAGE == 0) {
				progression = 0;
				etage--;
			}
		} else if (etage < personne.getArrivee()) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				progression = 0;
				etage++;
			}
		} else {
			personne.setEtat(Etat.ETAT_ARRIVE);
		}
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
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub

	}
}
