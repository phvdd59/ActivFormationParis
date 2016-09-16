package com.formation.ajee.veriffom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Vue {
	public static final String rep = FonctionsCommune.LOCAL+"ajee/page1/";
	public static final String rep1 = FonctionsCommune.LOCAL+"ajee/js/";

	public void lecturePage(HttpServletResponse resp, String sPage) {
		File file = new File(rep + sPage + ".html");
		if (file.exists()) {
			BufferedReader bufRead = null;
			try {
				bufRead = new BufferedReader(new FileReader(file));
				String line = bufRead.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bufRead.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bufRead != null) {
					try {
						bufRead.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void lectureJS(HttpServletResponse resp, String sPage) {
		File file = new File(rep1 + sPage + ".html");
		if (file.exists()) {
			BufferedReader bufRead = null;
			try {
				bufRead = new BufferedReader(new FileReader(file));
				String line = bufRead.readLine();
				while (line != null) {
					resp.getWriter().println(line);
					line = bufRead.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bufRead != null) {
					try {
						bufRead.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
