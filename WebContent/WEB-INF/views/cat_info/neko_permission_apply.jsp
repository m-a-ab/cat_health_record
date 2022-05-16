<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<c:import url="../layout/nekonew_base.jsp">
    <c:param name="content">

        <body>
            <br>
            <br>
            <br>
            <br>
            <header>
                <h2>愛猫のアクセス申請結果画面</h2>
            </header>
            <main>
                <br>
                <c:if test="${errorMessage != null }">
                    <div class="flush_error">
                        <c:out value="${errorMessage}"></c:out>
                    </div>
                </c:if>
                <c:if test="${successMessage != null }">
                    <div class="flush_success">
                        <c:out value="${successMessage}"></c:out>
                    </div>
                </c:if>
            </main>
        </body>
    </c:param>
</c:import>
</html>