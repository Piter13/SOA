package pl.marganski.cars.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.CarChoiceHelper;

@WebServlet("/CarChoiceServlet")
public class CarChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String range = request.getParameter("przedzial");
			String type = request.getParameter("typ");
			if (range != null && range.length() > 0) {
				out.println("<h2>Wybrano samochod " + type + " w przedziale cenowym " + range + "</h2>");
			}

			CarChoiceHelper carChoiceHelper = new CarChoiceHelper();
			ArrayList<String> avaliableCars = carChoiceHelper.selectCars(range, type);

			out.println("Avaliable cars: ");
			for (String k : avaliableCars) {
				out.println(k);
			}

		}
	}
}