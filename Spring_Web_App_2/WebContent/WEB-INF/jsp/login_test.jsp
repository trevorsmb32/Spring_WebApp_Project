<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
        <h1 id="banner">Login to Security Demo</h1> 
        <form name="f" action="<c:url value='j_spring_security_check'/>"  method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type='text' name='j_username' /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='text' name='j_password'></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>