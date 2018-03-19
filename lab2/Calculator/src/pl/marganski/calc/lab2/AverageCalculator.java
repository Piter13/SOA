package pl.marganski.calc.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AverageCalculator
 */
@WebServlet("/calculate")
public class AverageCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AverageCalculator() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">" + "<head><title>Calculator</title></head>");

			// then write the data of the response
			out.println("<body  bgcolor=\"#ffffff\">" + "<h1>Type five numbers: </h1>" + "<form method=\"get\">"
					+ "1st : " + "<input title=\"1st number: \" type=\"text\" " + "name=\"1st\" size=\"10\"/>"
					+ "<p></p>" + "2nd: " + "<input title=\"2nd number: \" type=\"text\" "
					+ "name=\"2nd\" size=\"10\"/>" + "<p></p>" + "3rd : "
					+ "<input title=\"3rd number: \" type=\"text\" " + "name=\"3rd\" size=\"10\"/>" + "<p></p>"
					+ "4th : " + "<input title=\"4th number: \" type=\"text\" " + "name=\"4th\" size=\"10\"/>"
					+ "<p></p>" + "5th : " + "<input title=\"5th number: \" type=\"text\" "
					+ "name=\"5th\" size=\"10\"/>" + "<p></p>" + "<input type=\"submit\" value=\"Calculate\"/>" + " "
					+ "<input type=\"reset\" value=\"Reset\"/>" + "</form>");

			double first = Double.parseDouble(request.getParameter("1st"));
			double second = Double.parseDouble(request.getParameter("2nd"));
			double third = Double.parseDouble(request.getParameter("3rd"));
			double fourth = Double.parseDouble(request.getParameter("4th"));
			double fifth = Double.parseDouble(request.getParameter("5th"));

			float average = (float) ((first + second + third + fourth + fifth) / 5.0);

			out.println("Srednia z podanych liczb wynosi: " + average);
		}
	}
}
