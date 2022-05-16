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
                <h2>アカウント承認ページ</h2>
            </header>
            <main>
                <br>
                <p class="text-center">
                    <c:out value="${permission.requestUser.username}"></c:out>
                    さんから
                    <br>
                    体調管理のリクエストが来ています。
                    <br>
                    対象の猫ちゃん
                    <br>
                </p>
                <div class="cell">
                    <div>
                        <c:choose>
                            <c:when test="${permission.neko.image =='kijitora'}">
                                <img src="${pageContext.request.contextPath}/image/kijitora.png">
                            </c:when>
                            <c:when test="${permission.neko.image =='hachiware'}">
                                <img src="${pageContext.request.contextPath}/image/hachiware.png">
                            </c:when>
                            <c:when test="${permission.neko.image== 'kuro'}">
                                <img src="${pageContext.request.contextPath}/image/kuro.png">
                            </c:when>
                            <c:when test="${permission.neko.image== 'shiro'}">
                                <img src="${pageContext.request.contextPath}/image/shiro.png">
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <p class="text-center">
                    許可すると対象の猫ちゃんの
                    <br>
                    全ての機能を共有することができます。
                </p>
                <br>
                <div class="button-center">
                    <form method="POST" action="${pageContext.request.contextPath}/neko_permission_approve">
                        <input type="hidden" name="id" value="${permission.id}">
                        <input type="submit" class="button" value="許可する">
                    </form>
                    <form method="GET" action="${pageContext.request.contextPath}/">
                        <input type="submit" class="button" value="キャンセル">
                    </form>
                </div>
            </main>
        </body>
    </c:param>
</c:import>
</html>