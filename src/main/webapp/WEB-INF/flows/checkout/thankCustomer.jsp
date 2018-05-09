<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for online Shopping!</h1>

                    <p>Your order will be shipped in four business days!</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<c:url value="/products/allproducts" />" class="btn btn-default">OK</a></p>
        </section>
        <section class="container">
            <p><a href="<c:url value="/cartSummary" />" class="btn btn-default">Cart Summary</a></p>
        </section>
   <%@ include file="/WEB-INF/views/template/footer.jsp"%>