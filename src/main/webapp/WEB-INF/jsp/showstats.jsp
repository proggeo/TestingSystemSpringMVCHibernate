<%--
  Created by IntelliJ IDEA.
  User: Proggeo
  Date: 5/27/2016
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <spring:url value="/resources/css/stats.css" var="css"/>
    <title>Stats</title>
    <link rel="stylesheet" type="text/css" href="${css}">
</head>
<body>

<h1 class="noselect" id="header">Stats for question: ${question}</h1>

<div id="answersContainer" class="noselect">
    <p>${answer1}:</p>
    <div id="answer1"></div>
    <p>${answer2}:</p>
    <div id="answer2"></div>
    <p>${answer3}:</p>
    <div id="answer3"></div>
    <p>${answer4}:</p>
    <div id="answer4"></div>
</div>

<script>
    document.getElementById("answer1").setAttribute("style","width:${count1*10}px");
    document.getElementById("answer2").setAttribute("style","width:${count2*10}px");
    document.getElementById("answer3").setAttribute("style","width:${count3*10}px");
    document.getElementById("answer4").setAttribute("style","width:${count4*10}px");

</script>

</body>
</html>
