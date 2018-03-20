<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pl.marganski.movies.lab3.Movie"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
</head>
<body>

	<h1>Lista filmow</h1>

	<table border="1">
		<tr>
			<th>Tytul</th>
			<th>Gatunek</th>
			<th>Rok</th>
			<th>Dochod</th>
		</tr>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td><c:out value="${movie.title}" /></td>
				<c:choose>
					<c:when test="${movie.genre == 'wojenny'}">
						<td bgcolor="#4286f4"><c:out value="${movie.genre}" /></td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${movie.genre}" /></td>
					</c:otherwise>
				</c:choose>
				<td><c:out value="${movie.year}" /></td>
				<td><fmt:formatNumber value="${movie.income}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>