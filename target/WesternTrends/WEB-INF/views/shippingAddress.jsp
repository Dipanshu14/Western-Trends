<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="template/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Add Shipping Details</h4>
<form:form method="post" action="${pageContext.request.contextPath}/customer/cart/shippingaddress"
	commandName="shippingaddress">

	<div class="form-group">
			<label for="shippingStreet">Street Name</label>
            <form:input path="streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="apartmentNumber">Apartment Number</label>
            <form:input path="apartmentNumber" id="apartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
        <label for="State">State</label>
            <form:input path="State" id="state" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="city">City</label>
            <form:input path="city" id="city" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="zipCode">Zip Code</label>
            <form:input path="zipCode" id="zipCode" class="form-Control" />
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>
 --%>