package pl.marganski.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.marganski.converter.*;

@WebServlet("/ExecuteEjbServlet")
public class ExecuteEjbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Konwerter konwerter;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double newTemp;
		double temp = Double.parseDouble(request.getParameter("temperature"));
		String direction = request.getParameter("direction");
		String fromSymbol;
		String toSymbol;
		
		if (direction.equals("ftoc")) {
			newTemp = konwerter.fahrNaCels(temp);
			fromSymbol = "F";
			toSymbol = "C";
		} else {
			newTemp = konwerter.celsNaFahr(temp);
			fromSymbol = "C";
			toSymbol = "F";
		}

		request.getRequestDispatcher("./index.jsp").include(request, response);
		response.getWriter().println("<p> Wynik konwersji: " + request.getParameter("temperature") + " " + fromSymbol
				+ " = " + newTemp + " " + toSymbol + "</p>");
	}
}