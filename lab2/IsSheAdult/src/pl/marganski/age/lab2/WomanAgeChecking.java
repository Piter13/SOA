package pl.marganski.age.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgeChecking
 */
@WebServlet("/whatAge")
public class WomanAgeChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WomanAgeChecking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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
			out.println("<html lang=\"en\">" + "<head><title>Are you an adult woman?</title></head>");

			// then write the data of the response
			out.println("<body  bgcolor=\"#ffffff\">" + "<h1>Type your name and age: </h1>" + "<form method=\"get\">"
					+ "Name: " + "<input title=\"Your name: \" type=\"text\" " + "name=\"username\" size=\"25\"/>"
					+ "<p></p>" + "Age: " + "<input title=\"Your age: \" type=\"text\" " + "name=\"age\" size=\"25\"/>"
					+ "<p></p>" + "<input type=\"submit\" value=\"Submit\"/>"
					+ "<input type=\"reset\" value=\"Reset\"/>" + "</form>");

			String username = request.getParameter("username");
			String ageString = request.getParameter("age");
			int age = Integer.parseInt(ageString);

			if (username.endsWith("a")) {
				if (age > 17) {
					out.println("It's okey");
				} else {
					out.println("You're not adult");
				}
			} else {
				out.println("You're not a woman");
			}
			out.println("</body></html>");
		}
	}

}
