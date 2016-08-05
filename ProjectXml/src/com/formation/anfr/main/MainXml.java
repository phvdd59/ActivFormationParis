package com.formation.anfr.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.formation.anfr.metier.ListeTerme;
import com.formation.anfr.metier.Terme;

public class MainXml {

	public static void main(String[] args) throws IOException {
		MainXml main = new MainXml();
		main.initLecture();
	}

	private void initLecture() throws IOException {
		ListeTerme lst = new ListeTerme();
		lst.readAndStore("./src/com/formation/anfr/xml/ListTerme.xml");
		System.out.println(lst.toString());
	}
}
