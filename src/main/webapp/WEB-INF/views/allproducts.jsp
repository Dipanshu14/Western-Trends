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
<th>id</th>
<th>name</th>
<th>quantity</th>
<th>description</th>
<th>image</th>
</tr>
</thead>
<tbody>
<c:forEach items="${products}" var="products">
<tr>
<td>${products.id}</td>
<td>${products.name}</td>
<td>${products.quantity}</td>
<td>${products.description}</td>
<td><img src="<c:url value="/resources/images/${products.id}.jpg" />" style="width:25%"/></td>
<td><a href="<c:url value="/viewProduct/${products.id}" />">view more<span class="glyphicon glyphicon-info-sign"></span></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
<%@ include file="template/footer.jsp"%>