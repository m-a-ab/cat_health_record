<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>

<h2>愛猫体調カレンダー</h2>
<ul>
            <c:forEach var="conditions" items="${conditions}">
                <li>
                <p>
                  <c:out value="${conditions.id}"></c:out>
                        <br></p>
        <p><a href="${pageContext.request.contextPath}/condition_edit?id=${conditions.id}">登録した体調を編集</a></p><br>
</li>
            </c:forEach>
        </ul>

</body>
</html>