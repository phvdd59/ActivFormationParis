package com.formation.thcr.fonction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class FonctionCommune {
	public static String HOST = "localhost";
	public static String LOCAL="../GITActivFormationParis/ProjectJMST/WebContent";
	
	public static void INIT(){
		
		Properties props = new Properties();
		HOST = props.getProperty("HOST");
		LOCAL = props.getProperty("LOCAL");
		try {
			props.loadFromXML(new FileInputStream(new File("propsJMST.xml")));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
