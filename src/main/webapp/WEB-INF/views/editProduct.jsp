<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="template/header.jsp" %>
 <h1>Please update the product information here </h1>
        <form:form action="${pageContext.request.contextPath}/admin/products/editProduct"
        	method="post"  commandName="products" enctype="multipart/form-data">
        <form:hidden path="id" value="${products.id}" />
            
 	<table>
 	<tr>
 	<td>Name</td>
 	<td><form:input path="name" value="${products.name}" class="form-Control" /></td>
 	</tr>
 	
 	<tr>
 	<td>Description</td>
 	<td><form:input path="description" value="${products.description}" class="form-Control"/></td>
 	</tr>
 	
 	<tr>
 	<td>Product Price</td>
 	<td><form:input path="productPrice" value="${products.productPrice}" class="form-Control"/></td>
 	</tr>
 	<tr>
 	<td>Quantity</td>
 	<td><form:input path="quantity" value="${products.quantity}" class="form-Control"/></td>
 	</tr>
 	
 	<tr>
			<td>Image</td>
			<td><form:input path="image" /></td>
			<td><form:input type="file" path="image" /></td>
			
		</tr>
 	</table>
 	<tr>
 	<td><input type="submit" value="Submit"/></td>
    <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
    </tr>
</form:form>
<%@ include file="template/footer.jsp" %>