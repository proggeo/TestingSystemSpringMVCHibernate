<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add question</title>
</head>
<body>

<h1>Create New Question</h1>

<c:url var="saveUrl" value="/proggeo/questions/add" />
<form:form modelAttribute="questionAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="question">Question:</form:label></td>
			<td><form:input path="question"/></td>
		</tr>

		<tr>
			<td><form:label path="answer">Right Answer:</form:label></td>
			<td><form:input path="answer"/></td>
		</tr>

		<tr>
			<td><form:label path="wrongAnswer1">Wrong Answer 1:</form:label></td>
			<td><form:input path="wrongAnswer1"/></td>
		</tr>

		<tr>
			<td><form:label path="wrongAnswer2">Wrong Answer 2:</form:label></td>
			<td><form:input path="wrongAnswer2"/></td>
		</tr>

		<tr>
			<td><form:label path="wrongAnswer3">Wrong Answer 3:</form:label></td>
			<td><form:input path="wrongAnswer3"/></td>
		</tr>

	</table>

	<input type="submit" value="Save" />
</form:form>

</body>
</html>