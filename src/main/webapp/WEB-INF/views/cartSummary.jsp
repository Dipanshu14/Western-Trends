<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="template/header.jsp"%>
<div class="container-fluid">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>ProductName</th>
					<th>Price</th>
					<th>Quantity</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cart.cartItems}" var="products">
					<tr>
						<td>${products.cartItemId}</td>
						<td>${products.product.name}</td>
						<td>${products.product.productPrice}</td>
						<td>${products.quantity}</td>
						<td>${products.totalPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="template/footer.jsp"%>