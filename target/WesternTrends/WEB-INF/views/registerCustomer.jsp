 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ include file="template/header.jsp"%>
    <!DOCTYPE html>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body> 
        <div align="centre">
            <form:form action="register" method="post" commandName="customer" >
                <table border="0">
                <tr>
                	<td colspan="2" align="centre"><h2>Registration</h2></td>
                </tr>
                	<tr>
                        <td>Name</td>
                        <td><form:input path="customerName"  /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><form:input path="customerEmail"  /></td>
                    </tr>
                    <tr>
                    <td>Phone No.</td>
                        <td><form:input path="customerPhone"  /></td>
                    </tr>
                    <tr>
                    <td>User Name</td>
                        <td><form:input path="username" /></td>
                    </tr>
                    <tr><td>Password</td>
                        <td><form:input path="password"/></td> 
                    </tr>
                    
                   </table>
                               </div>
            
<h4>Add Shipping Details</h4>
	<div class="form-group">
			<label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="apartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
        <label for="State">State</label>
            <form:input path="shippingAddress.State" id="state" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="city">City</label>
            <form:input path="shippingAddress.city" id="city" class="form-Control" />
        </div>
        
        <div class="form-group">
            <label for="Country">Country</label>
            <form:input path="shippingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
         <label for="zipCode">Zip Code</label>
            <form:input path="shippingAddress.zipCode" id="zipCode" class="form-Control" />
        </div>

        <br/><br/>
        
         <h4>Billing Address</h4>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control" />
        </div>

        <br/>
        <tr>
       <td colspan="2" align="centre"><input type="submit" value="Register" /></td>
        </tr>
        
        </form:form>
            
        </body>
        <%@ include file="template/footer.jsp"%>
        </html>