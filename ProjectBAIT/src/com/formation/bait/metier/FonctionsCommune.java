package com.formation.bait.metier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

public class FonctionsCommune {

	public void AfficherHautDePage(HttpServletResponse response) {
		File file = new File(
				"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); // pour
			// texte
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				// System.out.println(line);
				response.getWriter().append(line + "\n");
				line = bIn.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void AfficherBasDePage (HttpServletResponse response){
		File file3 = new File(
				"C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/basDePageActiv.html");
		BufferedReader bIn3 = null;
		InputStreamReader inputStreamReader3 = null;
		try

		{
			inputStreamReader3 = new InputStreamReader(new FileInputStream(file3), "UTF-8");
			bIn3 = new BufferedReader(inputStreamReader3);
			String line3 = bIn3.readLine();
			while (line3 != null) {
				// System.out.println(line);
				response.getWriter().append(line3);
				line3 = bIn3.readLine();
			}
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				bIn3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
