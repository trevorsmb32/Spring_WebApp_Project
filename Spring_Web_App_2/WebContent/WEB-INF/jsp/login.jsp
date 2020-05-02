<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<br>
			<br>
			<h1>Login Page</h1>

			<p class="lead">Checkout all the awesome products available now!</p>


			<label style="color: red";>${error_msg}</label>
			<form:form action="${pageContext.request.contextPath}/login"
				modelAttribute="admin" method="post">

				<table>

					<tr>
						<td><label>Enter Username:</label></td>
						<td><form:input type="text" path="username" name="username" />
							<br> <form:errors path="username" style="color:red"></form:errors>
						</td>
					</tr>

					<tr>
						<td><label>Enter Password:</label></td>
						<td><form:input type="password" path="password"
								name="password" /> <br> <form:errors path="password"
								style="color:red"></form:errors></td>
					</tr>



					<tr>
						<td>ujds</td>
						<td><input type="submit" value="Login" /></td>
					</tr>


				</table>
			</form:form>


			<%@include file="/WEB-INF/jsp/template/footer.jsp"%>