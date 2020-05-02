<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Cart</h1>

			<p class="lead">Congrats your order will be shipped to you with 3 days</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Edit Quantity</th>
					<th></th>
				</tr>
			</thead>
			
 			<c:forEach items="${items}" var="items"> 
				<tr>
					<td>${items.name}</td>
					<td>${items.price}USD</td>
					<td>${items.quantity}</td>
					<td>
				</tr>

 			</c:forEach> 
		</table>
		<label style="color: red";>${shoppingCart.total}</label>

		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>