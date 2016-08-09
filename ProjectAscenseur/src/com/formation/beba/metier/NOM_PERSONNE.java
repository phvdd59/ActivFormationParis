package com.formation.beba.metier;

import java.util.Random;

public enum NOM_PERSONNE {
	Jean, Henri, Fiona, Luke, Leia, Max, Sam, Achab, Anna, Chiara, Cléa, Eva, Léa, Lila, Luna, Nina, Noélia, Oria, Sarah, Adam, Erwann, Ethan, Ilan, Kylian, Nolan, Ryan, Yoan;
	private static final NOM_PERSONNE[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();

	public static NOM_PERSONNE getRandomNom() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
}
