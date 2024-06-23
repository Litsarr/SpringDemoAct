<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>

    <!-- Button to navigate to quizpage.jsp -->
    <form action="${pageContext.request.contextPath}/quizpage">
        <input type="submit" value="Quiz Page">
    </form>

    <!-- Button to navigate to results.jsp -->
    <form action="${pageContext.request.contextPath}/results">
        <input type="submit" value="Results">
    </form>

    <form action="${pageContext.request.contextPath}/logout">
            <input type="submit" value="Logout">
        </form>
</body>
</html>
