//package com.formation.ambr.servlet;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Servlet1
// */
//@WebServlet("/ServletAmbr")
//public class Servlet1Old extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static int VALEUR=0;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Servlet1Old() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 1) récupérer les paramètres.
//		String pseudo=request.getParameter("nom");
//		// 2) COntrôler les paramètres
//		if (pseudo.contains("Philippe")) {
//			pseudo=pseudo+"PLUS";
//		}
//		// 3) Constituer la nouvelle page
//		//response.getWriter().append("Bonjour je m'appelle Amaury: ").append(request.getContextPath());
//		//response.getWriter().println("Bonjour je m'appelle Amaury: ");
//		response.getWriter().println("<html><body><h1>BONJOUR</h1></body></html>");
//		response.getWriter().println("<form><input type='text' value='"+VALEUR+"'></form>");
//		response.getWriter().println("<input name='question' type='text' " + pseudo + "'></form>");
//		response.getWriter().println("<input name='submit' type='submit' " + pseudo + "'></form>");
//		
//		
//		if (pseudo.contains("Philippe")) {
//			response.getWriter().println("<p style='color:red'>" + pseudo + "</p>");
//		} else {
//			response.getWriter().println("<p style='color:blue'>" + pseudo + "</p>");
//		}
//		VALEUR++;
//		response.getWriter().println("</form></body></html>");
//
//	}
//
//}
