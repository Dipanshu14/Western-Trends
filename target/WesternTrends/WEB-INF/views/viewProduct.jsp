<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="template/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
         <div class="container">
            <div class="row">
                <div class="col-md-5">
            <img src="<c:url value="/resources/images/${product.id}.jpg"/>"height="100px" width="100px" />
        	</div>
        	</div>
        	
        	<div class="row">
                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.quantity}</p>
                    <p>${product.description}</p>
                     <p>
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                        <a href="<c:url value = "/cart/addtocart/${product.id}" />"  class="btn btn-default"> Addtocart <span class="glyphicon glyphicon-shopping-cart"></span></a>
                        <a href="<spring:url value="/cart" />"  class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>
                    
                    
                      </div>
                    </div>
                    </div>
<%-- <script src="<c:url value="/resources/js/controller.js" /> "></script> --%>                    
<%@ include file="template/footer.jsp"%> 