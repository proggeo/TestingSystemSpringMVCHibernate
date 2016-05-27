<%--
  Created by IntelliJ IDEA.
  User: Proggeo
  Date: 5/27/2016
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><html>
<head>
    <title>Questions</title>
</head>
<body>

<h1>Questions</h1>

<c:url var="addUrl" value="/krams/questions/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
  <thead style="background:#fcf">
  <tr>
    <th>Question</th>
    <th>Answer</th>
    <th>Wrong Answer 1</th>
    <th>Wrong Answer 2</th>
    <th>Wrong Answer 3</th>
    <th colspan="5"></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${questions}" var="question">
    <c:url var="editUrl" value="/krams/questions/edit?id=${question.id}" />
    <c:url var="deleteUrl" value="/krams/questions/delete?id=${question.id}" />
    <tr>
      <td><c:out value="${question.question}" /></td>
      <td><c:out value="${question.answer}" /></td>
      <td><c:out value="${question.wrongAnswer1}" /></td>
      <td><c:out value="${question.wrongAnswer2}" /></td>
      <td><c:out value="${question.wrongAnswer3}" /></td>
      <td><a href="${editUrl}">Edit</a></td>
      <td><a href="${deleteUrl}">Delete</a></td>
      <td><a href="${addUrl}">Add</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:if test="${empty questions}">
  There are currently no questions in the list. <a href="${addUrl}">Add</a> a question.
</c:if>


</body>
</html>
