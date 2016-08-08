package com.formation.issa.exo;

public class StringTravail {
	public String StringTravail(String mot) {

		char[] charArray = null;
		int d = 2;
		int l = 0;

		charArray = mot.toCharArray();
		if (charArray.length % 3 != 0) {
			return null;
		} else {
			char[] charArray1 = new char[charArray.length];
			for (int i = 0; i < charArray.length; i++) {

				if (i == 0 || i % 3 == 0) {
					charArray1[i] = charArray[i + d];

				} else if (i == d + l) {
					charArray1[i] = charArray[i - d];
					l += 3;
				} else {
					charArray1[i] = charArray[i];
				}
				mot = new String(charArray1);

			}
			return mot;
		}
	}

}
