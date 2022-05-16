<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/nekolist.css'/>">
<c:import url="../layout/nekonew_base.jsp">
    <c:param name="content">

        <body>
            <!--       <form method="POST"
                action="${pageContext.request.contextPath}/">-->
            <header>
                <h2>愛猫一覧</h2>
            </header>
<br><br><br><br>
            <main>
                <div class="list">
                    <!-- 1匹め -->
                    <c:forEach var="nekoaccount" items="${nekolist}">

                        <div class="cell">
                            <c:choose>
                                <c:when test="${nekoaccount.image =='kijitora'}">
                                    <img src="${pageContext.request.contextPath}/image/kijitora.png">
                                </c:when>
                                <c:when test="${nekoaccount.image =='hachiware'}">
                                    <img
                                        src="${pageContext.request.contextPath}/image/hachiware.png">
                                </c:when>
                                <c:when test="${nekoaccount.image== 'kuro'}">
                                    <img src="${pageContext.request.contextPath}/image/kuro.png">
                                </c:when>
                                <c:when test="${nekoaccount.image== 'shiro'}">
                                    <img src="${pageContext.request.contextPath}/image/shiro.png">
                                </c:when>
                                <c:otherwise></c:otherwise>
                            </c:choose>

                            <p>

                                 <a href="${pageContext.request.contextPath}/condition_list?neko_id=${nekoaccount.id}">  <c:out value="${nekoaccount.nekoname}"></c:out>ちゃんの体調記録を見る</a>
                                <br>
                            </p>
                            <!-- 後で消す -->
                            <p>
                                <a href="${pageContext.request.contextPath}/nekoedit?id=${nekoaccount.id}">猫情報を編集</a>
                            </p>
                                <p>
                                <a href="${pageContext.request.contextPath}/condition_new?neko_id=${nekoaccount.id}">体調新規記録</a>
                            </p>
                            <br>

                        </div>
                    </c:forEach>
                </div>

            </main>
        </body>
    </c:param>
</c:import>
</html>