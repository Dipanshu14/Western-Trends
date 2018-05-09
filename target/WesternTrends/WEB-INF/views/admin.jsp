<%@ include file="template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Welcome to the administrator page</h1>

            
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome ${pageContext.request.userPrincipal.name}
               
            </h2>
        </c:if>
        
        <h3>
            <a href="<c:url value="/admin/productInventory" /> ">Product Inventory</a>
        </h3>
        
         <h3>
            <a href="<c:url value="/admin/customer" /> ">Customer Management</a>
        </h3>
        
        
<%@ include file="template/footer.jsp"%>