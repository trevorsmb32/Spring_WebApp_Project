<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">

			<h1>Welcome to you personal profile page</h1>
			<label style="color: red";>${user}</label>

			<%@include file="/WEB-INF/jsp/template/footer.jsp"%>