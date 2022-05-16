<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app_login.jsp">
    <c:param name="content">
        <c:if test="${hasError}">
            <div id="flush_error">メールアドレスかパスワードが間違っています。</div>
        </c:if>
        <c:if test="${flush != null }">
            <div id="flush_success">
                <c:out value="${flush }"></c:out>
            </div>
        </c:if>


        <div class="form-wrapper">
            <h1>ログイン</h1>
            <form method="POST" action="${pageContext.request.contextPath}/login">

                <div class="form-item">
                    <label for="address"></label> <input type="text" name="address"
                        id="address" required="required" placeholder="メールアドレス"></input>

                </div>
                <div class="form-item">
                    <label for="password"></label> <input type="password"
                        name="password" required="required" placeholder="パスワード"></input>
                </div>


                <div class="button-panel">
                    <input type="hidden" name="_token" value="${_token }" /> <input
                        type="submit" class="button" title="login" value="ログイン"></input>
                </div>
            </form>
            <div class="form-footer">

                <form method="GET" action="${pageContext.request.contextPath}/new">
                    <p>
                        <a href="${pageContext.request.contextPath}/new">新規登録</a>
                    </p>
                </form>
            </div>
        </div>
    </c:param>
</c:import>



