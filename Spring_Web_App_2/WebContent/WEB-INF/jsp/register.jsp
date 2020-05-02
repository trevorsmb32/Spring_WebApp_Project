<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer Details</h1>

		</div>

		<form:form action="${pageContext.request.contextPath}/register"
			method="post" modelAttribute="customer" enctype="multipart/form-data">
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
				<form:errors path="password" cssStyle="color: #ff0000;" />
				<form:input path="password" id="password" class="form-Control" />
			</div>



			<h1>Shipping Details</h1>
			<br></br>

			<div class="form-group">
				<label for="shippingAddress.street">street</label>
				<form:errors path="shippingAddress.street" cssStyle="color: #ff0000;" />
				<form:input path="shippingAddress.street" id="shippingAddress.street" class="form-Control" />
			</div>
			
			<div class="form-group">
				<label for="shippingAddress.town">town</label>
				<form:errors path="shippingAddress.town" cssStyle="color: #ff0000;" />
				<form:input path="shippingAddress.town" id="shippingAddress.town" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="shippingAddress.county">county</label>
				<form:errors path="shippingAddress.county" cssStyle="color: #ff0000;" />
				<form:input path="shippingAddress.county" id="shippingAddress.county" class="form-Control" />
			</div>
			
			
			<div class="form-group">
				<label for="shippingAddress.areaCode">areaCode</label>
				<form:errors path="shippingAddress.areaCode" cssStyle="color: #ff0000;" />
				<form:input path="shippingAddress.areaCode" id="shippingAddress.areaCode" class="form-Control" />
			</div>
			
			<div class="form-group">
				<label for="shippingAddress.areaCode">country</label>
				<form:errors path="shippingAddress.country" cssStyle="color: #ff0000;" />
				<form:input path="shippingAddress.country" id="shippingAddress.country" class="form-Control" />
			</div>
			

			<br>
			<br>
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
		</form:form>



		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>