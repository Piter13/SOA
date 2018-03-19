package pl.marganski.book.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Vector<DaneOsobowe> usersData = new Vector<>();

	private class DaneOsobowe {
		private String firstname;
		private String surname;
		private String login;
		private String password;

		public DaneOsobowe(String firstname, String surname, String login, String password) {
			this.firstname = firstname;
			this.surname = surname;
			this.login = login;
			this.password = password;
		}

		public String getLogin() {
			return login;
		}

		public String getPassword() {
			return password;
		}

	}

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usersData.add(new DaneOsobowe("Rafael", "Nadal", "rafa", "french"));
		usersData.add(new DaneOsobowe("Roger", "Federer", "fedex", "wimbledon"));
		usersData.add(new DaneOsobowe("Stanislas", "Wawrinka", "stanimal", "australian"));

		PrintWriter out = response.getWriter();

		String login = request.getParameter("username");
		String password = request.getParameter("pass");

		for (DaneOsobowe person : usersData) {
			if (person.getLogin().equals(login) && person.getPassword().equals(password)) {
				Cookie loginCookie = new Cookie("user", login);
				response.addCookie(loginCookie);
				response.sendRedirect("/Guestbook/BookServlet");
			} else if (login.isEmpty()) {
				out.println("<font color=red>Login can't be empty!</font>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
				if (dispatcher != null) {
					dispatcher.include(request, response);
				}
			} else if (password.isEmpty()) {
				out.println("<font color=red>Password can't be empty!</font>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
				if (dispatcher != null) {
					dispatcher.include(request, response);
				}
			} else {
				out.println("<font color=red>Wrong login and password!</font>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
				if (dispatcher != null) {
					dispatcher.include(request, response);
				}
			}
		}
	}
}
