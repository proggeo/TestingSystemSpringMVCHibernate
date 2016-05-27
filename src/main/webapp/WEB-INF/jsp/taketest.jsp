<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <spring:url value="/resources/css/test.css" var="css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Take test</title>
    <link rel="stylesheet" type="text/css" href="${css}">
</head>
<body>
<div id="questionContainer" class="noselect">
    <h1>Question</h1>

    <c:url var="saveUrl" value="/krams/test/take"/>

    <h3 class="noselect">${question.question}</h3>

    <form:form modelAttribute="entry" method="post" action="${saveUrl}">
        <form:hidden path="questionId" value="${questionId}"/>
        <p><label for="answer1"><form:radiobutton path="answer" value="${answers[0]}"/> <c:out
                value="${answers[0]}"/></label></p>

        <p><label for="answer2"><form:radiobutton path="answer" value="${answers[1]}"/> <c:out
                value="${answers[1]}"/></label></p>

        <p><label for="answer3"><form:radiobutton path="answer" value="${answers[2]}"/> <c:out
                value="${answers[2]}"/></label></p>

        <p><label for="answer4"><form:radiobutton path="answer" value="${answers[3]}"/> <c:out
                value="${answers[3]}"/></label></p>

        <input type="submit" value="Submit"/>
    </form:form>
</div>
<c:url var="mainUrl" value="/krams/questions"/>
<p>Return to <a href="${mainUrl}">Main List</a></p>
<c:url var="statsUrl" value="/krams/test/stats?id=${entry.  questionId}"/>
<a href="${statsUrl}">Show stats for this question</a>

</body>
</html>