<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
<div class="table-responsive">
<table class="table">
<thead>
<tr>	
<th>id</th>
<th>name</th>
<th>quantity</th>
<th>description</th>
<th>price</th>
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
<td>${products.productPrice}</td>
<td><img src="<c:url value="/resources/images/${products.id}.jpg" />" style="width:25%"/></td>	
<td><a href="<spring:url value="/admin/products/editProduct/${products.id}" />">edit <span class="glyphicon glyphicon-pencil"></span></a>
<td><a href="<spring:url value="/admin/products/deleteProduct/${products.id}" />">delete <span class="glyphicon glyphicon-remove"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
<a href="<spring:url value="/admin/products/addProduct" />" class="btn btn-primary">Add Product</a>
<%@ include file="template/footer.jsp" %>