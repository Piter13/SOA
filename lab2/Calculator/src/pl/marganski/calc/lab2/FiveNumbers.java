package pl.marganski.calc.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultipleParameters
 */
@WebServlet("/FiveNumbers")
public class FiveNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiveNumbers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Calculator</title></head>");
            
            out.println("<body  bgcolor=\"#ffffff\">"
            		+ "<h1>Type five numbers: </h1>"
                    + "<form method=\"POST\">"
            		+ "1st : "
                    + "<input title=\"1st number: \" type=\"text\" "
                    + "name=\"1st\" size=\"10\"/>"
                    + "<p></p>"
                    + "2nd: "
                    + "<input title=\"2nd number: \" type=\"text\" "
                    + "name=\"2nd\" size=\"10\"/>"
                    + "<p></p>"
                    + "3rd : "
                    + "<input title=\"3rd number: \" type=\"text\" "
                    + "name=\"3rd\" size=\"10\"/>"
                    + "<p></p>"
                    + "4th : "
                    + "<input title=\"4th number: \" type=\"text\" "
                    + "name=\"4th\" size=\"10\"/>"
                    + "<p></p>"
                    + "5th : "
                    + "<input title=\"5th number: \" type=\"text\" "
                    + "name=\"5th\" size=\"10\"/>"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\"/>"
                    + "<input type=\"reset\" value=\"Reset\"/>"
                    + "</form>");
            
            List<Integer> arr = new ArrayList<Integer>();
            
            Enumeration<String> enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String parameterName = (String) enumeration.nextElement();
                String paramValues[] = request.getParameterValues(parameterName); 
                for (int i=0; i < paramValues.length; i++){
                	try {
                		arr.add(Integer.parseInt(paramValues[i]));
                	} catch(NumberFormatException e) {
                	    out.println("Input is not a valid integer\n");
                	}
                }
            }
            
            Collections.sort(arr);
     	    for(int counter: arr){
     			out.println(counter);
     		}
            
            out.println("</body></html>");
        }
	}

}
