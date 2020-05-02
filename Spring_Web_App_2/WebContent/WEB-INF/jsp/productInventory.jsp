<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        	<br></br>
			<br></br>
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
				<th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                	 <td><img src="<c:url value="/resource/images/${product.id}.png" /> " alt="image"
                             style="width:100%"/></td>
					<td>${product.name}</td>
					<td>${product.productCode}</td>
					<td>${product.description}</td>
					<td>${product.price}USD</td>
					<td>${product.quantity}</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.id}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.id}" />"
                        ><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.id}" />"
                        ><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct" />" class="btn btn-primary">Add Product</a>

       <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
