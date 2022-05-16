<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/nekolist.css' />">
<c:import url="../layout/nekonew_base.jsp">
    <c:param name="content">
        <br>
        <br>
        <br>
        <br>
        <body>
            <header>
                <h2>TOP画面</h2>
            </header>
            <main>
                <c:if test="${error != null }">
                    <br>
                    <div class="flush_error">
                        <c:out value="${error}"></c:out>
                    </div>
                </c:if>
                <c:if test="${flush != null }">
                    <br>
                    <div class="flush_success">
                        <c:out value="${flush}"></c:out>
                    </div>
                </c:if>

                <c:if test="${accessPermissions != null }">
                    <br>
                    <div class="flush_success">
                        <c:forEach var="permission" items="${accessPermissions}">
                            <a href="${pageContext.request.contextPath}/neko_permission_show?id=${permission.id}">
                                <c:out value="${permission.requestUser.username}"></c:out>さんから<c:out value="${permission.neko.nekoname}"></c:out>ちゃんのアクセス承認依頼が来ています。
                            </a>
                            <br>
                        </c:forEach>
                    </div>
                </c:if>
                <div class="list">
                    <!-- 1匹め -->
                    <c:forEach var="nekoaccount" items="${nekoaccount}">

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

                                 <a href="${pageContext.request.contextPath}/condition_list?neko_id=${nekoaccount.id}">  <c:out value="${nekoaccount.nekoname}"></c:out>ちゃんの体調記録</a>
                                <br>
                            </p>
                            <!-- 後で消す -->
                            <p>
                                <a href="${pageContext.request.contextPath}/nekoedit?id=${nekoaccount.id}">このねこを編集</a>
                            </p>
                                <p>
                                <a href="${pageContext.request.contextPath}/condition_new?neko_id=${nekoaccount.id}">このねこの体調記録</a>
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