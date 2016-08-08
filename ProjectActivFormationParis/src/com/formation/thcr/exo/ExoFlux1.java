package com.formation.thcr.exo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoFlux1 extends ArrayList<Terme> {

	public class Saisie {

		/**
		 * But : Entrer des éléments au clavier pour le mot croisé et les mettre
		 * dans un fichier
		 * 
		 * Eléments à entrer (pour au final, savoir créer un Terme) Saisir un
		 * mot Saisir une position x (début du mot sur la ligne horizontale)
		 * Saisir un position y (début du mot sur la ligne verticale) Saisir le
		 * sens du mot (mot vertical ou mot horizontal)
		 * 
		 * Dans le but de standardiser voici le nom des zones de saisie zone de
		 * saisie du mot : sMot zone de saisie de la position x : sPosX Zone de
		 * saisie de la position y : sPosY Zone de saisie du sens du mot : sSens
		 * 
		 * Plusieurs éléments devront pouvoir être saisis.
		 * 
		 * Créer un fichier dans lequel seront intégrées toutes les informations
		 * saisies.
		 * 
		 * Le nom du ficher est : saisie.json
		 * 
		 * Le fichier se présentera sous la forme : par enregistrement
		 * {"mot":"motsaisi","posX":positionXSaisie,"posY":positionYSaisie,
		 * "sens":true ou false}
		 * 
		 * attention à bien respecter la syntaxe du fichier les {} en début et
		 * fin d'enregistrement les , entre 2 informations les : entre le nom de
		 * la valeur et la valeur en elle-même Les informations fixes
		 * "mot","posX",posY","sens" sont entre "" Les valeurs positions x et y
		 * sont indiquées telles quelles Le sens prend la valeur true ou la
		 * valeur false
		 * 
		 * Exemple de fichier saisie.json
		 * {"mot":"pastille","posX":1,"posY":5,"sens":true}
		 * {"mot":"propre","posX":1,"posY":5,"sens":false}
		 * 
		 * 
		 */

	}

	public void saisie() {
		BufferedReader bInStr = null;
		bInStr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("saisir un terme : ");
		try {

			String sNomOk = null;
			String sMot = null;

			while (sMot == null || !sMot.equals(sNomOk) || sMot.equals("")) {
				try {
					System.out.print("entrer sMot : ");
					sMot = bInStr.readLine();
					sNomOk = epuration(sMot);
					if (!sMot.equals(sNomOk) || sMot.equals("")) {
						System.err.println("mot incorrect");
					}
				} catch (NullPointerException e) {
					System.err.println(e.getMessage() + " mauvaise saisie");
				}
			}

			int sPosX = -1;
			while (sPosX < 0) {
				System.out.print("entrer sPosX : ");
				try {
					sPosX = Integer.valueOf(bInStr.readLine()).intValue();
					if (sPosX < 0) {
						System.err.println("Position X négative");
					}
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage() + " mauvaise saisie");
					sPosX = -1;
				}
			}
			System.out.print("entrer sPosY : ");
			int sPosY = -1;
			while (sPosY < 0) {
				try {
					sPosY = Integer.valueOf(bInStr.readLine()).intValue();
					if (sPosY < 0) {
						System.err.println("Position Y négative");
						System.out.print("sPosY : ");
					}
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage() + " mauvaise saisie");
					System.out.print("sPosY : ");
					sPosY = -1;
				}
			}
			System.out.println("entrer sSens : \n1.HORIZONTAL\n2.VERTICAL");
			boolean checkSens = false;
			int sSens = 0;
			while (!(sSens == 1 || sSens == 2)) {
				try {
					System.out.print("sSens : ");
					sSens = Integer.valueOf(bInStr.readLine()).intValue();
					if (sSens == 1) {
						checkSens = Terme.HORIZONTAL;
					} else if (sSens == 2) {
						checkSens = Terme.VERTICAL;
					} else {
						System.err.println("recommencer saisie");
					}
				} catch (Exception e) {
					System.err.println(e.getMessage() + " mauvaise saisie");
					sSens = 0;
				}
			}
			this.add(new Terme(sMot, new Point(sPosX, sPosY), checkSens));
			System.out.println();
			System.out.println("Création du terme : " + this.get(this.size() - 1));
			System.out.println("Sauvegarder ?\n1.Oui\t2.Non");
			int save = 0;
			while (save != 1 && save != 2) {
				try {
					save = Integer.valueOf(bInStr.readLine()).intValue();
					if (save == 1) {
						save();
					} else if (save == 2) {
					} else {
						System.err.println("saisie invalide");
						save = 0;
					}
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage());
				}
			}
			System.out.println("Continuer ?\n1.Oui\t2.Non");
			int next = 0;
			while (next != 1 && next != 2) {
				try {
					next = Integer.valueOf(bInStr.readLine()).intValue();
					if (next == 1) {
						saisie();
					} else if (next == 2) {
					} else {
						System.err.println("saisie invalide");
						next = 0;
					}
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void saisie2() {
		//Menuing
		BufferedReader bInStr = null;
		bInStr = new BufferedReader(new InputStreamReader(System.in));
		String choixMenu = "";
		try {
			while (choixMenu != "exit") {
				System.out.println("Menu");
				System.out.println("1.Créer Terme");
				System.out.println("2.Supprimer Terme");
				System.out.println("3.Supprimer liste");
				System.out.println("4.Sauvegarder");
				System.out.println("5.Sauvegarder sous (alpha 0.01)");
				System.out.println("6.Charger");
				System.out.println("7.Consulter liste de Termes");
				System.out.println("8.Afficher Solution");
				System.out.println("9.quitter");
				choixMenu = bInStr.readLine();
				System.out.println();
				switch (choixMenu) {
					case "1":
						/**********************************
						 * AJOUTER TERME
						 */
						System.out.println("Création Terme");
						String sNomOk = null;
						String sMot = null;

						while (sMot == null || !sMot.equals(sNomOk) || sMot.equals("")) {
							try {
								System.out.print("entrer sMot : ");
								sMot = bInStr.readLine();
								sNomOk = epuration(sMot);
								if (!sMot.equals(sNomOk) || sMot.equals("")) {
									System.err.println("mot incorrect");
								}
							} catch (NullPointerException e) {
								System.err.println(e.getMessage());
							}
						}

						System.out.print("entrer sPosX : ");
						int sPosX = -1;
						while (sPosX < 0) {
							try {
								sPosX = Integer.valueOf(bInStr.readLine()).intValue();
								if (sPosX < 0) {
									System.err.println("Position X négative");
									System.out.print("sPosX : ");
								}
							} catch (NumberFormatException e) {
								System.err.println(e.getMessage() + " mauvaise saisie");
								System.out.print("sPosX : ");
								sPosX = -1;
							}
						}
						System.out.print("entrer sPosY : ");
						int sPosY = -1;
						while (sPosY < 0) {
							try {
								sPosY = Integer.valueOf(bInStr.readLine()).intValue();
								if (sPosY < 0) {
									System.err.println("Position Y négative");
									System.out.print("sPosY : ");
								}
							} catch (NumberFormatException e) {
								System.err.println(e.getMessage() + " mauvaise saisie");
								System.out.print("sPosY : ");
								sPosY = -1;
							}
						}
						System.out.println("entrer sSens : \n1.HORIZONTAL\n2.VERTICAL");
						boolean checkSens = false;
						int sSens = 0;
						System.out.print("sSens : ");
						while (!(sSens == 1 || sSens == 2)) {
							try {
								sSens = Integer.valueOf(bInStr.readLine()).intValue();
								if (sSens == 1) {
									checkSens = Terme.HORIZONTAL;
								} else if (sSens == 2) {
									checkSens = Terme.VERTICAL;
								} else {
									System.out.println("recommencer saisie");
									System.out.println("entrer sSens : \n1.HORIZONTAL\n2.VERTICAL");
									System.out.print("sSens : ");
								}
							} catch (Exception e) {
								System.err.println(e.getMessage() + " mauvaise saisie");
								System.out.print("sSens : ");
								sSens = 0;
							}
						}
						this.add(new Terme(sMot, new Point(sPosX, sPosY), checkSens));
						System.out.println();
						System.out.println("Création du terme : " + this.get(this.size() - 1));
						System.out.println("Sauvegarder\n1.Oui\t2.Non");
						int save = 0;
						while (save != 1 && save != 2) {
							try {
								save = Integer.valueOf(bInStr.readLine()).intValue();
								if (save == 1) {
									save();
								} else if (save == 2) {
								} else {
									System.err.println("saisie invalide");
								}
							} catch (NumberFormatException e) {
								System.err.println(e.getMessage());
							}
						}
						break;
					case "2":
						/**********************************
						 * SUPPRIMER TERME
						 */
						System.out.println();
						System.out.println("suppression Terme");
						System.out.println("Liste de Termes : ");
						if (this.isEmpty()) {
							System.out.println("Pas de terme à supprimer");
						} else {
							int i = 0;
							for (Terme terme : this) {
								System.out.println(i + "." + terme);
								i++;
							}
							int termeASupprimer = Integer.valueOf(bInStr.readLine());
							while (termeASupprimer >= this.size() || termeASupprimer < 0) {
								try {
									System.out.println("indice en dehors des limites");
									termeASupprimer = Integer.valueOf(bInStr.readLine());
								} catch (Exception e) {
									System.err.println(e.getMessage() + " mauvaise saisie");
									termeASupprimer = -1;
								}
							}
							System.out.println(this.remove(termeASupprimer) + "a été supprimé");
						}
						System.out.println();
						break;
					case "3":
						/**********************************
						 * SUPPRIMER LISTE
						 */
						while (!this.isEmpty()) {
							this.clear();
						}
						System.out.println("Liste supprimée");
						System.out.println();
						break;
					case "4":
						/**********************************
						 * SAVE
						 */
						save();
						System.out.println();
						break;
					case "5":
						/**********************************
						 * SAVE UNDER
						 */
						File file = new File("./");
						String path = "./";
						System.out.println("répertoire (./) : ");
						int saveU = 0;
						file = new File(path);
						try {
							System.out.println(file.getCanonicalPath());
						} catch (IOException e) {
							System.err.println(e.getMessage());
						}
						try {
							while (saveU != 1) {

								saveU = 0;
								System.out.println();
								System.out.print("Entrer chemin : ");
								path = bInStr.readLine();
								file = new File(path);
								System.out.println(file.getCanonicalPath());
								File[] listFile = file.listFiles();
								for (File f : listFile) {
									System.out.println(f.getName());
								}
								System.out.println("Répertoire voulu ?\n1.Oui\n2.Non");
								while (saveU != 1 && saveU != 2) {
									try {
										saveU = Integer.valueOf(bInStr.readLine()).intValue();
										if (saveU == 1) {
										} else if (saveU == 2) {
										} else {
											System.err.println("saisie invalide");
										}
									} catch (NumberFormatException e) {
										System.err.println(e.getMessage());
									}
								}
							}
							System.out.print("saisir nom : ");
							String name = bInStr.readLine();
							path = file.getCanonicalPath() + "/" + name + ".json";
							save(path);

						} catch (IOException | NullPointerException e) {
							System.err.println(e.getMessage());
							saveU = 0;
						}

						break;
					case "6":
						/**********************************
						 * LOAD
						 */

						File fileLoad = new File("./");
						String pathLoad = "./";
						System.out.println("répertoire (./) : ");
						int load = 0;
						fileLoad = new File(pathLoad);
						try {
							System.out.println(fileLoad.getCanonicalPath());
						} catch (IOException e) {
							System.err.println(e.getMessage());
						}

						while (load != 1 || !fileLoad.isFile()) {
							try {
								load = 0;
								System.out.println();
								System.out.print("Entrer chemin : ");
								pathLoad = bInStr.readLine();
								fileLoad = new File(pathLoad);
								System.out.println(fileLoad.getCanonicalPath());
								File[] listFile = fileLoad.listFiles();
								if (listFile != null) {
									for (File f : listFile) {
										System.out.println(f.getName());
									}
								}
								System.out.println("fichier voulu ?\n1.Oui\n2.Non");
								while (load != 1 && load != 2) {
									try {
										load = Integer.valueOf(bInStr.readLine()).intValue();
										if (load == 1) {
											if (!fileLoad.isFile()) {
												System.err.println("ce n'est pas un fichier");
											}
										} else if (load == 2) {
										} else {
											System.err.println("saisie invalide");
										}
									} catch (NumberFormatException e) {
										System.err.println(e.getMessage());
									}
								}
							} catch (IOException | NullPointerException e) {
								e.printStackTrace();
								load = 0;
							}
						}

						recup(pathLoad);
						System.out.println("fichier chargé : " + fileLoad.getName());

						break;
					case "7":
						/**********************************
						 * AFFICHAGE LISTE TERME
						 */
						System.out.println("Liste de Termes : ");
						if (this.isEmpty()) {
							System.out.println("Pas de terme");
						} else {
							for (Terme terme : this) {
								System.out.println(terme);
							}
						}
						System.out.println();
						break;
					case "8":
						/**********************************
						 * SOLUTION (EXOEXCEPTION1)
						 */
						ExoException1 exo = new ExoException1();
						int width = -1;
						int height = -1;
						System.out.println("entrez largeur");
						while (width < 0) {
							try {
								System.out.print("sLargeur : ");
								width = Integer.valueOf(bInStr.readLine());
								if (width < 0) {
									System.err.println("largeur négative");
								}

							} catch (Exception e) {
								System.err.println(e.getMessage() + " saisie incorrect");
								width = -1;
							}
						}
						System.out.println("entrez hauteur");
						while (height < 0) {
							try {
								System.out.print("sHauteur : ");
								height = Integer.valueOf(bInStr.readLine());
								if (height < 0) {
									System.err.println("hauteur négative");
								}

							} catch (Exception e) {
								System.err.println(e.getMessage() + " saisie incorrect");
								height = -1;
							}
						}
						char[][] sol = null;
						try {
							sol = exo.solution(width, height, this);

							//Affichage solution
							for (int i = 0; i < sol.length; i++) {
								System.out.println();
								for (int j = 0; j < sol[0].length; j++) {
									System.out.print(sol[i][j]);
								}
							}
						} catch (CruciException e) {
							System.err.println(e.getMessage());
						}
						System.out.println();
						break;
					case "9":
						/**********************************
						 * EXIT
						 */
						System.out.println("voulez-vous sauvegarder avant de quitter");
						System.out.println("1.oui\n2.non");
						int choix = Integer.valueOf(bInStr.readLine());
						while (choix < 1 || choix > 2) {
							System.out.println("cas non traité");
							System.out.println("voulez-vous sauvegarder");
							System.out.println("1.oui\n2.non");
						}
						if (choix == 1) {
							save();
						}
						choixMenu = "exit";
						System.out.println("programme quitté");
						break;
					default:
						System.err.println("recommencer saisie");
						System.out.println();
						break;
				}
			}
		} catch (IOException e) {
		} finally {
			try {
				bInStr.close();
			} catch (IOException e) {
			}
		}
	}

	public void save() {
		// vers votre repertoire data sous forme saisie.json
		File file = new File("./src/com/formation/thcr/data/saisie.json");
		PrintWriter bw = null;
		try {
			bw = new PrintWriter(new FileWriter(file));
			for (Terme terme : this) {
				//{"mot":"pastille","posX":1,"posY":5,"sens":true}
				bw.write("{\"mot\":\"" + terme.getNom() + "\",\"posX\":" + terme.getPos().x + ",\"posY\":" + terme.getPos().y + ",\"sens\":"
						+ terme.isSens() + "}\n");
			}
			System.out.println("sauvegarde effectuée");
		} catch (IOException e) {

		} finally {
			bw.close();
		}
	}

	public void recup() {
		// de votre repertoire data
		File file = new File("src/com/formation/thcr/data/saisie.json");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int character = fr.read();
			String s = "";
			while (character != -1) {
				s += (char) character;
				character = fr.read();
			}
			String sModif = cleanJSON(s);
			String[] info = sModif.split(" ");
			String nom = "";
			int posX = 0;
			int posY = 0;
			boolean sens = false;
			this.clear();
			for (int i = 0; i < info.length; i++) {
				//On utilise les modulo pour capter les 4 attributs de Terme
				if (i % 4 == 0) {
					nom = info[i];
				} else if (i % 4 == 1) {
					posX = Integer.valueOf(info[i]);
				} else if (i % 4 == 2) {
					posY = Integer.valueOf(info[i]);
				} else {
					if (Boolean.valueOf(info[i]) == Terme.HORIZONTAL) {
						sens = Terme.HORIZONTAL;
					} else if (Boolean.valueOf(info[i]) == Terme.VERTICAL) {
						sens = Terme.VERTICAL;
					}
					this.add(new Terme(nom, new Point(posX, posY), sens));
				}

			}
			System.out.println("chargement effectué");
		} catch (FileNotFoundException e) {
			System.err.println("fichier non trouvé");
		} catch (IOException e) {
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save(String path) {
		// vers votre repertoire data sous forme saisie.json
		File file = new File(path);
		PrintWriter bw = null;
		try {
			bw = new PrintWriter(new FileWriter(file));
			for (Terme terme : this) {
				//{"mot":"pastille","posX":1,"posY":5,"sens":true}
				bw.write("{\"mot\":\"" + terme.getNom() + "\",\"posX\":" + terme.getPos().x + ",\"posY\":" + terme.getPos().y + ",\"sens\":"
						+ terme.isSens() + "}\n");
			}
			System.out.println("sauvegarde effectuée sous :");
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {

		} finally {
			bw.close();
		}
	}

	public void recup(String path) {
		// de votre repertoire data
		File file = new File(path);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int character = fr.read();
			String s = "";
			while (character != -1) {
				s += (char) character;
				character = fr.read();
			}
			String sModif = cleanJSON(s);
			String[] info = sModif.split(" ");
			String nom = "";
			int posX = 0;
			int posY = 0;
			boolean sens = false;
			this.clear();
			for (int i = 0; i < info.length; i++) {
				//On utilise les modulo pour capter les 4 attributs de Terme
				if (i % 4 == 0) {
					nom = info[i];
				} else if (i % 4 == 1) {
					posX = Integer.valueOf(info[i]);
				} else if (i % 4 == 2) {
					posY = Integer.valueOf(info[i]);
				} else {
					if (Boolean.valueOf(info[i]) == Terme.HORIZONTAL) {
						sens = Terme.HORIZONTAL;
					} else if (Boolean.valueOf(info[i]) == Terme.VERTICAL) {
						sens = Terme.VERTICAL;
					}
					this.add(new Terme(nom, new Point(posX, posY), sens));
				}

			}
			System.out.println("chargement effectué");
		} catch (FileNotFoundException e) {
			System.err.println("fichier non trouvé");
		} catch (IOException e) {
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String cleanJSON(String texte) {
		String s = texte.replace("{", " ");
		s = s.replace("}", " ");
		s = s.replace("\"", " ");
		s = s.replace(":", " ");
		s = s.replace(",", " ");
		s = s.replace("  ", " ");
		s = s.replace("  ", " ");
		s = s.replace(" mot ", "");
		s = s.replace(" posX", "");
		s = s.replace(" posY", "");
		s = s.replace(" sens", "");
		s = s.replaceAll("\\p{Space}", " ");
		s = s.replace("  ", " ");
		return s;
	}

	public String epuration(String texte) {
		String sRet = "";
		if (texte != null) {
			char[] tab = texte.trim().toLowerCase().toCharArray();
			for (int i = 0; i < tab.length; i++) {
				int v = tab[i];
				if (v >= 'à' && v <= 'å') {
					sRet += "a";
				} else if (v >= 'ç' && v <= 'ç') {
					sRet += "c";
				} else if (v >= 'è' && v <= 'ë') {
					sRet += "e";
				} else if (v >= 'ì' && v <= 'ï') {
					sRet += "i";
				} else if (v >= 'ò' && v <= 'ö') {
					sRet += "o";
				} else if (v >= 'ù' && v <= 'ü') {
					sRet += "u";
				} else if (v >= 'ý' && v <= 'ý') {
					sRet += "y";
				} else if (v >= 'a' && v <= 'z') {
					sRet += (char) v;
				} else {
					if (i != 0 && !sRet.substring(sRet.length() - 1).equals(" ")) {
						sRet += " ";
					}
				}
			}
		}
		return sRet.trim().toUpperCase();
	}
}
