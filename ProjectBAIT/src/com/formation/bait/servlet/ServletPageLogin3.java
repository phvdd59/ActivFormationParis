package com.formation.bait.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value = "/ServletLogin3", name = "ServletLogin3")
public class ServletPageLogin3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPageLogin3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
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

		File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Login.html");
		BufferedReader bIn2 = null;
		InputStreamReader inputStreamReader2 = null;
		try {
			inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			bIn2 = new BufferedReader(inputStreamReader2);
			String line2 = bIn2.readLine();
			while (line2 != null) {
				// System.out.println(line);
				response.getWriter().append(line2 + "\n");
				line2 = bIn2.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/basDePageActiv.html");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/hautDePageActiv.html");
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

		String pseudo = request.getParameter("identifiant");
		// Contrôler les params
		if (pseudo != null) {

			File file2 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/Login.html");
			File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectBAIT/WebContent/WEB-INF/bait/pages/PageCompte2.html");
					BufferedReader bIn2 = null;
			InputStreamReader inputStreamReader2 = null;
			
			
			if (pseudo.contains("Admin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("C:/DevFormation/GITActivFormationParis/ProjectBAIT/src/com/formation/bait/servlet/ServletPageCompte2.java");
				dispatcher.forward(request, response);
//				try {
//					inputStreamReader2 = new InputStreamReader(new FileInputStream(file3), "UTF-8");
//					bIn2 = new BufferedReader(inputStreamReader2);
//					String line2 = bIn2.readLine();
//					while (line2 != null) {
//						// System.out.println(line);
//						response.getWriter().append(line2 + "\n");
//						line2 = bIn2.readLine();
//					}
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						bIn2.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
			} else {

				try {
					inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
					bIn2 = new BufferedReader(inputStreamReader2);
					String line2 = bIn2.readLine();
					while (line2 != null) {
						if (line2.contains("identifiant")) {
							line2 = line2.replace("value=''", "value='Erreur " + pseudo + " '");
						}
						response.getWriter().append(line2 + "\n");
						line2 = bIn2.readLine();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bIn2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		File file3 = new File("C:/DevFormation/GITActivFormationParis/ProjectEtudiant/WebContent/WEB-INF/com/formation/anfr/pages/basDePageActiv.html");
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