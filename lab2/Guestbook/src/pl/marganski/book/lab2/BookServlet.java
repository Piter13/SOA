package pl.marganski.book.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Vector<String> entries = new Vector<>();

	public BookServlet() {
		super();
	}

	private boolean isLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					loginCookie = cookie;
					break;
				}
			}
		}

		if (loginCookie != null) {
			loginCookie.setMaxAge(120);
			response.addCookie(loginCookie);
			return true;
		} else {
			response.sendRedirect("/login.html");
		}

		return false;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isLoggedIn(request, response)) {
			response.setContentType("text/html");
			try (PrintWriter out = response.getWriter()) {
				out.println("<html lang=\"pl\">" + "<head><title>Guest Book</title></head>");
				out.println("<body bgcolor=\"#ffffff\">" + "<h1>Please submit your feedback:</h1>"
						+ "<form method=\"get\">" + "Your name: " + "<input type=\"text\" name=\"name\" size=\"20\"/>"
						+ "<br>" + "<br>" + "Yout email: " + "<input type=\"text\" name=\"email\" size=\"20\"/>"
						+ "<br>" + "<br>" + "Comment: " + "<input type=\"text\" name=\"comment\" size=\"100\"/>"
						+ "<br>" + "<br>" + "<input type=\"submit\" value=\"Send feedback\"/>" + "</form>");

				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String comment = request.getParameter("comment");

				String entry = "<b>" + name + "</b> (" + email + ") says<br><code>" + comment + "</code><br><br>";

				if (!name.equals("") && !email.equals("") && !comment.equals(""))
					entries.add(entry);

				for (String note : entries)
					out.println(note);

				out.println("</body></html>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
