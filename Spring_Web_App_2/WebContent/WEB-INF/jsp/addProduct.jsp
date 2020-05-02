<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Product</h1>

			<p class="lead">Fill the below information to add a product:</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" modelAttribute="product" enctype="multipart/form-data">>
			<div class="form-group">
				<label for="name">Name</label>
				<form:errors path="name" cssStyle="color: #ff0000;" />
				<form:input path="name" id="name" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="price">Product Code</label>
				<form:errors path="price" cssStyle="color: #ff0000;" />
				<form:input path="productCode" id="productCode" class="form-Control" />
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<form:errors path="price" cssStyle="color: #ff0000;" />
				<form:input path="price" id="price" class="form-Control" />
			</div>


			<div class="form-group">
				<label for="description">Description</label>
				<form:input path="description" id="description" class="form-Control" />
			</div>

			<div class="form-group">
				<label class="control-label" for="productImage">Upload Picture</label>
				<form:input  name="productImage" id="productImage" path="productImage" type="file" class="form:input-large" />
			</div>
			
			
			<br>
			<br>
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="admin/productInventory" />"
				class="btn btn-default">Cancel</a>
		</form:form>



		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>