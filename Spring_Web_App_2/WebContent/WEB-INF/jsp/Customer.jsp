<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer Details</h1>

			<p class="lead">Fill the below information to add a product:</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath}/register"
			method="post" modelAttribute="product" enctype="multipart/form-data">>
			<div class="form-group">
				<label for="firstName">First Name</label>
				<form:errors path="firstName" cssStyle="color: #ff0000;" />
				<form:input path="firstName" id="firstName" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="secondName">Second Name</label>
				<form:errors path="secondName" cssStyle="color: #ff0000;" />
				<form:input path="secondName" id="secondName" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="email">Email</label>
				<form:errors path="email" cssStyle="color: #ff0000;" />
				<form:input path="email" id="email" class="form-Control" />
			</div>


			<div class="form-group">
				<label for="password">Password</label>
				<form:input path="password" id="password" class="form-Control" />
			</div>

	
		<h1>Shipping Address</h1>

		<div class="form-group">
				<label for="shippingAddress.street">Street</label>
				<form:input path="shippingAddress.street" id="street" class="form-Control" />
		</div>	
			
			<br>
			<br>
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/" />"
				class="btn btn-default">Cancel</a>
		</form:form>



		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>