<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/styles.css" />"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<div align="center">
		<form:form action="/validation"  modelAttribute="login">
			<table>
				<tr>
					<td>UserName:</td>
					<td><form:input path="userName" id="userNameInput" /></td>
					<td><form:errors path="userName" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" id="passwordInput" /></td>
					<td><form:errors path="password" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td>Select your role:</td>
					<td><form:select path="role" items="${listOfRoles}" /></td>
					<td><form:errors path="role" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="login"></td>
				</tr>
			</table>
		</form:form>
		</div>
	
</body>
</html>