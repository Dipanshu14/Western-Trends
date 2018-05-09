<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout cancelled!</h1>

                    <p>Your checkout process is cancelled! You may continue shopping.</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="/products/allProducts" />" class="btn btn-default">Products</a></p>
        </section>
    <%@ include file="/WEB-INF/views/template/footer.jsp"%>