<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="template/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Add Product Details</h4>
<form:form method="post" action="${pageContext.request.contextPath}/admin/products/addProduct/submit"
	commandName="products" enctype="multipart/form-data">

	<table>
		<tr>
			<td>Name</td>
			<td><form:input path="name" id="name" /></td>
		</tr>

		<tr>
			<td>Description</td>
			<td><form:input path="description" id="description" /></td>
		</tr>

		<tr>
			<td>Product Price</td>
			<td><form:input path="productPrice" id="productPrice" /></td>
		</tr>

		<tr>
			<td>Quantity</td>
			<td><form:input path="quantity" id="quantity" /></td>
		</tr>
		
		<tr>
			<td>Image</td>
			<td><form:input path="image" type="file" /></td>
		</tr>

		<tr>
			<td><input type="submit" value="Submit" /></td>
			
			<td><a href="<c:url value="/admin/productInventory"/>"
				class="btn btn-default">Cancel</a></td>
		</tr>
	</table>
</form:form>
<%@ include file="template/footer.jsp"%>