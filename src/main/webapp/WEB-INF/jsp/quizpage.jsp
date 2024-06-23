<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Page</title>
</head>
<body>
    <c:if test="${empty sessionScope.username}">
        <c:redirect url="login" />
    </c:if>
    <c:if test="${not empty sessionScope.username}">
        <form method="post" action="${pageContext.request.contextPath}/submitQuiz">
            <div>
                <p>What is the largest planet in our Solar System?</p>
                <input type="radio" name="ques1" value="A"> Earth<br>
                <input type="radio" name="ques1" value="B"> Mars<br>
                <input type="radio" name="ques1" value="C"> Neptune<br>
                <input type="radio" name="ques1" value="D"> Jupiter<br>
            </div>
            <div>
            					<p>Who wrote the play Romeo and Juliet?</p>
            					<input type="radio" name="ques2" value="A"> Stephen King<br>
            					<input type="radio" name="ques2" value="B"> Charles Dickens<br>
            					<input type="radio" name="ques2" value="C"> William
            					Shakespeare<br> <input type="radio" name="ques2" value="D">
            					J.K. Rowling<br>
            				</div>
            				<div>
            					<p>Which element has the chemical symbol 'O'?</p>
            					<input type="radio" name="ques3" value="A"> Gold<br> <input
            						type="radio" name="ques3" value="B"> Oxygen<br> <input
            						type="radio" name="ques3" value="C"> Silver<br> <input
            						type="radio" name="ques3" value="D"> Uranium<br>
            				</div>
            				<div>
            					<p>What is the capital city of Japan?</p>
            					<input type="radio" name="ques4" value="A"> Sapporo<br>
            					<input type="radio" name="ques4" value="B"> Kobe<br> <input
            						type="radio" name="ques4" value="C"> Tokyo<br> <input
            						type="radio" name="ques4" value="D"> Kyoto<br>
            				</div>
            				<div>
            					<p>What is the largest mammal in the world?</p>
            					<input type="radio" name="ques5" value="A"> Elephant<br>
            					<input type="radio" name="ques5" value="B"> Blue Whale<br>
            					<input type="radio" name="ques5" value="C"> Hippo<br>
            					<input type="radio" name="ques5" value="D"> Giraffe<br>
            				</div>
            <input type="submit" value="Submit">
        </form>
    </c:if>
</body>
</html>
