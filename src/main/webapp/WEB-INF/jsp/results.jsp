<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.username}">
            <c:redirect url="login" />
        </c:when>
        <c:otherwise>
            <h2>Grades</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>User name</th>
                        <th>Correct Count</th>
                        <th>Score Percentage</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="result" items="${quizResults}">
                        <tr>
                            <td>${result.username}</td>
                            <td>${result.correctCount}</td>
                            <td>${result.scorePercentage}%</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br />
            <a href="${pageContext.request.contextPath}/home">Home</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
