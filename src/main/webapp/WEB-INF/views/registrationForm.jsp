<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
	.errors{
		color: red
	}
</style>

<link href="<c:url value="/resources/styles/styles.css" />"	rel="stylesheet">

<title>Registration</title>
</head>
<body>
	<div align="center" class="container">
		<form:form action="/new" method="post" modelAttribute="registration">
			<table>
				<tr>
					<td class="">UserName:</td>
					<td><form:input path="userName" id="userNameInput" /></td>
					<td><form:errors path="userName" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" id="passwordInput" /></td>
					<td><form:errors path="password" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" id="nameInput" /></td>
					<td><form:errors path="name" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" id="emailInput" /></td>
					<td><form:errors path="email" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Select your role:</td>
					<td><form:select path="role" items="${listOfRoles}" /></td>
					<td><form:errors path="role" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td align="center" colspan="2" ><input type="submit"
						value="Register"></td>
				</tr>
				<tr>
				<td align="center" colspan="2"><label>Already registered?</label><a href="/login" style="padding-left: 2em">Login</a></td>
				</tr>
			</table>
		</form:form>
	</div>


</body>
</html>