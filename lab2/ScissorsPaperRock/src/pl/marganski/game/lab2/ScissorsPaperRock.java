package pl.marganski.game.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScissorsPaperRock
 */
@WebServlet("/play")
public class ScissorsPaperRock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private class ScissorsPaperRockView {
		private HttpServletResponse response;

		public ScissorsPaperRockView(HttpServletResponse response) {
			this.response = response;
		}

		public void printResult(String winner) throws IOException {
			PrintWriter out = response.getWriter();
			out.println(winner);
			out.close();
		}
	}

	private class ScissorsPaperRockModel {
		String winner;

		public ScissorsPaperRockModel() {
		}

		public String getResponse(String computerS, String player) throws IOException {

			if (computerS.equals("paper") && player.equals("rock")) {
				winner = "Computer wins!";
				return winner;
			} else if (computerS.equals("paper") && player.equals("scissors")) {
				winner = "Player wins!";
				return winner;
			} else if (computerS.equals("rock") && player.equals("paper")) {
				winner = "Player wins!";
				return winner;
			} else if (computerS.equals("rock") && player.equals("scissors")) {
				winner = "Computer wins!";
				return winner;
			} else if (computerS.equals("scissors") && player.equals("paper")) {
				winner = "Computer wins!";
				return winner;
			} else if (computerS.equals("scissors") && player.equals("rock")) {
				winner = "Player wins!";
				return winner;
			} else if (computerS.equals(player)) {
				winner = "It's a draw.";
				return winner;
			}
			return player;

		}
	}

	enum Weapon {
		scissors, paper, rock
	}

	String computerS;
	String player;
	String winner;

	public ScissorsPaperRock() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">" + "<head><title>Let's play</title></head>" + "<body  bgcolor=\"#ffffff\">"
					+ "<h1>Choose your weapon: </h1>" + "<form method=\"get\">" + "Select: " + "<select name=\"type\">"
					+ "<option value=\"scissors\">scissors</option>" + "<option value=\"paper\">paper</option>"
					+ "<option value=\"rock\">rock</option>" + "</select>" + "<br>" + "<br>"
					+ "<input type=\"submit\" value=\"Play!\"/>" + "</form>" + "</body></html>");

			Weapon computer = r.random();

			String computerS = computer.name();
			String player = request.getParameter("type");

			ScissorsPaperRockModel model = new ScissorsPaperRockModel();
			String winner = model.getResponse(computerS, player);

			ScissorsPaperRockView view = new ScissorsPaperRockView(response);
			view.printResult(winner);

			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static final RandomEnum<Weapon> r = new RandomEnum<Weapon>(Weapon.class);

	private static class RandomEnum<E extends Enum> {
		private static final Random RND = new Random();
		private final E[] values;

		public RandomEnum(Class<E> token) {
			values = token.getEnumConstants();
		}

		public E random() {
			return values[RND.nextInt(values.length)];
		}
	}

}
