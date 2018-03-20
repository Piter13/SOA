package com.example.web.WyborPiwa;

import com.example.model.EkspertPiwny;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_wybierzpiwo
 */
@WebServlet("/WybierzPiwo.do")
public class Servlet_wybierzpiwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_wybierzpiwo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Porada piwna<br/>");
		String c = request.getParameter("kolor");
		out.println("<br/>Wybrany kolor piwa: " + c);

		EkspertPiwny ekspert = new EkspertPiwny();
		List<String> marki = ekspert.getMarki(c);

		request.setAttribute("marki", marki);
		RequestDispatcher view = request.getRequestDispatcher("wyniki.jsp");
		view.forward(request, response);

	}

}
