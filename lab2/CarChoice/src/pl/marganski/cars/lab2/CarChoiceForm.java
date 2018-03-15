package pl.marganski.cars.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Form")
public class CarChoiceForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarChoiceForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"pl\">"
                    + "<head><title>Car Choice</title></head>");
			out.println("<body bgcolor=\"#ffffff\">"
					+ "<h1>Wprowadz parametry:</h1>"
					+ "<form method=\"get\">"
					+ "Rodzaj samochodu: "
					+ "<select name=\"typ\">" 
					+ "<option value=\"sportowy\">sportowy</option>" 
					+ "<option value=\"miejski\">miejski</option>" 
					+ "<option value=\"luksusowy\">luksusowy</option>" 
					+ "</select>" + "<br>" + "<br>"
					+ "Przedzial cenowy: "
					+ "<input type=\"text\" name=\"przedzial\" value=\"-\">" + "<br>" + "<br>"
					+ "<input type=\"submit\" value=\"Submit\"/>" + " "
                    + "<input type=\"reset\" value=\"Reset\"/>"
					+ "</form>");
			
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CarChoiceServlet");
                
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            
            out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
