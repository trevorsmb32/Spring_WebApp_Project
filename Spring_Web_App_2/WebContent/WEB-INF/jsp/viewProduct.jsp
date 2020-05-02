<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Here is the detail information of the product!</p>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<h3>${product.name}</h3>
					<p>
						<strong>Product Code</strong> : ${product.productCode}
					</p>										
					<p>
						<strong>Description</strong> : ${product.description}
					</p>
					<p>
						<strong>Product Price</strong> : ${product.price}USD
					</p>
				</div>
			</div>
		</div>



		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>>
	