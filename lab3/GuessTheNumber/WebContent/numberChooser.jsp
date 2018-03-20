<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose the number!</title>
</head>
<body>

	<%
		int randomNumber;
		int attempt;

		if (request.getParameter("randomNumber") == null)
			randomNumber = (int) (Math.random() * 100);
		else
			randomNumber = Integer.parseInt(request.getParameter("randomNumber"));
		if (request.getParameter("attempt") == null)
			attempt = 0;
		else {
			attempt = Integer.parseInt(request.getParameter("attempt"));
			attempt++;
		}
	%>

	<form method="post">
		Podaj liczbe: <input type="number" min="0" max="100" name="userInput" />
		<input type="submit" value="Zgaduj" /> 
		<input type="hidden" name="randomNumber" value="<% out.print(randomNumber); %>"/> 
		<input type="hidden" name="attempt" value="<% out.print(attempt); %>"/>
	</form>

	<br/>

	<%
		if (request.getParameter("userInput") != null
				&& Integer.parseInt(request.getParameter("userInput")) > randomNumber) {
			out.println("Twoja liczba (" + request.getParameter("userInput") + ") jest wieksza niz zagadka.");
		} else if (request.getParameter("userInput") != null
				&& Integer.parseInt(request.getParameter("userInput")) < randomNumber) {
			out.println("Twoja liczba (" + request.getParameter("userInput") + ") jest mniejsza niz zagadka.");
		} else if (request.getParameter("userInput") != null
				&& Integer.parseInt(request.getParameter("userInput")) == randomNumber) {
			out.println("Brawo! Zgadles po: " + attempt
					+ " probach!<br/><br/>Sprobuj <a href=\"numberChooser.jsp\">raz jeszcze</a>");
		}
	%>

</body>
</html>