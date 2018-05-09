<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">
                <div>
                    <a href="<spring:url value="/customer/cart/removeAll/${cartId}" />" class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span> Clearcart</a>
                    <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Checkout</a>
                </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                    	<th>Id</th>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                        <th>Action</th>
                    </tr>
                    
                    <c:forEach items="${cart.cartItems}" var="products">
                    <tr>
                    	<td>${products.cartItemId}</td>
                        <td>${products.product.name}</td>
                        <td>${products.product.productPrice}</td>
                        <td>${products.quantity}</td>
                        <td>${products.totalPrice}</td>
                        <td><a href="<c:url value="/customer/cart/remove/${products.cartItemId}"/>" class="label label-danger" ><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<c:url value="/products/allproducts" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
<!-- My -->
<%-- <script src="<c:url value="/resources/js/controller.js" /> "></script> --%>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>