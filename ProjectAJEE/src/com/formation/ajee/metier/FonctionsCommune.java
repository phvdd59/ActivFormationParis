package com.formation.ajee.metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class FonctionsCommune {
	public static String HOST = "127.0.0.1";
	public static String LOCAL = "../GITActivFormationParis/ProjectAJEE/WebContent/";

	public static void INIT() {
		Properties props = new Properties();
		try {
			props.loadFromXML(new FileInputStream(new File("propsAJEE.xml")));
			HOST = props.getProperty("HOST");
			LOCAL = props.getProperty("LOCAL");
		} catch (InvalidPropertiesFormatException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
