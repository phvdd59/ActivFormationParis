package com.formation.issa.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPageCompte
 */
@WebServlet("/ServletPageCompte")
public class ServletPageCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPageCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File file=new File(FonctionsCommune.LOCAL+"WEB-INF/bait/pages/PageCompte.html");
		BufferedReader bIn = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8"); 
			bIn = new BufferedReader(inputStreamReader);
			String line = bIn.readLine();
			while (line != null) {
				response.getWriter().println(line+"\n");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String etatCivil=req.getParameter("etatCivil");
		
			File file=new File("C:/DevFormation/GITActivFormationParis/ProjetBAIT"+"WebContent/WEB-INF/bait/pages/EtatCivil.html");
			BufferedReader bSn=new BufferedReader(new FileReader(file));
			String l=bSn.readLine();
			while(l!=null){
				response.getWriter().println(l);
				l=bSn.readLine();
			}
		
		
		
		//RequestDispatcher dispatcher=context.getRequestDispatcher("/ServletEtatCivil");
		//dispatcher.forward(req, resp);
	}

}
