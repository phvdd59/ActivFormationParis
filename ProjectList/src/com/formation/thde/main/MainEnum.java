//package com.formation.thde.main;
//
//import com.formation.thde.metier.Meuble;
//
//public class MainEnum {
//
//	public static void main(String[] args) {
//		MainEnum mainEnum = new MainEnum();
//		mainEnum.init();
//	}
//
//	public void init() {
//		if (Meuble.TABLE.compareTo(Meuble.CHAISE) == -1) {
//			System.err.println("Table < Chaise");
//		} else if (Meuble.TABLE.compareTo(Meuble.CHAISE) == 0) {
//			System.err.println("Table == Chaise");
//		} else {
//			System.err.println("Table > Chaise");
//		}
//		System.out.println(Meuble.TABLE.toString() + " " + Meuble.TABLE.ordinal());
//		System.out.println(Meuble.CHAISE + " " + Meuble.CHAISE.ordinal());
//		System.out.println(Meuble.ARMOIRE + " " + Meuble.ARMOIRE.ordinal());
//
//		Meuble[] tabMeuble = Meuble.values();
//		for (int i = 0; i < tabMeuble.length; i++) {
//			System.out.println("Meuble : " + tabMeuble[i]);
//		}
//
//		int v = (int) (Math.random() * Meuble.values().length);
//		Meuble monMeuble = Meuble.values()[v];
//
//		switch (monMeuble) {
//		case TABLE:
//			System.out.println("Je peux manger dessus");
//			break;
//		case CHAISE:
//			System.out.println("Je m'assois dessus");
//		default:
//			System.out.println("Je stocke dedans");
//			break;
//		}
//		Meuble autreMeuble = Meuble.valueOf("TABLE");
//		if (autreMeuble.equals(Meuble.TABLE)) {
//			System.out.println("OK");
//		} else {
//			System.out.println("PAS OK");
//		}
//
//		System.out.println("Dimension (" + Meuble.TABLE.getLongueur() + ", " + Meuble.TABLE.getLargeur() + ", " + Meuble.TABLE.getHauteur() + ")");
//		System.out.println(Meuble.CHAISE.isDansLaCuisine());
//		System.out.println(Meuble.TABLE.toString());
//		Meuble.TABLE.setLargeur(180);
//		System.out.println("Dimension (" + Meuble.TABLE.getLongueur() + ", " + Meuble.TABLE.getLargeur() + ", " + Meuble.TABLE.getHauteur() + ")");
//	}
//}
