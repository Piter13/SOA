<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shop</title>
<jsp:useBean id="cart" class="pl.marganski.shop.lab3.Cart" scope="session" />
</head>
<body>

	<%
    	if(request.getParameter("product") != null) {
        	cart.addProduct(Integer.parseInt(request.getParameter("product")));
   		}
	%>

	<h1>Our products:</h1>

	<c:import var="productsInfo" url="assortment.xml" />
	<x:parse xml="${productsInfo}" var="output" />
	<form name="Cart" method="post">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th></th>
			</tr>
			<x:forEach select="$output/assortment/product" var="shoes">
				<tr>
					<td><x:out select="$shoes/id" /></td>
					<td><x:out select="$shoes/name" /></td>
					<td><x:out select="$shoes/price" /></td>
					<td><button type="submit" name="product" value="<x:out select="$shoes/id" />">Add to cart</button></td>
				</tr>
			</x:forEach>
		</table>
	</form>
	<br />
	<br /> Check your <a href="shopManagment.jsp">cart</a> (<b><% out.print(cart.getTotalAmount()); %> </b> items)
	<br />

</body>
</html>