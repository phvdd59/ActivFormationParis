package com.formation.thde.main;

import com.formation.thde.metier.ArrayListTerme;

public class MainXml {

	public static void main(String[] args) {
		MainXml main = new MainXml();
		main.initLecture();
	}

	public void initLecture() {
		ArrayListTerme lst = new ArrayListTerme("./src/com/formation/thde/xml/ListTerme.xml");
		lst.lecture();
		System.out.println(lst);
	}
}
