<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function validation() {
		var username = document.getElementById("username").value;

		if (parseInt(username.length) < 4) {
			alert('Username must be 4 characters long');
			return false;
		}

		if (username.indexOf("@") < 0) {

			alert('Enter a valid email address');
			false;
		}

		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;

		if (parseInt(password.length) < 6) {
			alert('Password must be at least 6 characters long');
			return false;

		}

		if (password != repassword) {
			alert('Passwords do not match');
			return false;

		}
		return true;

	}
</script>

<div class="container">
`	<br></br>
	<br></br>

	<div>

		<form action="${pageContext.request.contextPath}/signUp" method="post" onsubmit="return validation()">

			<table>

				<tr>
					<td><label>Enter Email:</label></td>
					<td><input id="username" type="text" name="username" /></td>
				</tr>

				<tr>
					<td><label>Enter Password:</label></td>
					<td><input id="password" type="password" name="password" /></td>
				</tr>

				<tr>
					<td><label>Re enter Password:</label></td>
					<td><input id="repassword" type="password" name="repassword" /></td>
				</tr>


			</table>

			<td><input type="submit" value="Login" /></td>
		</form>


	</div>

</body>
<%@include file="/WEB-INF/jsp/template/footer.jsp"%>