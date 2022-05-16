<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <form method="POST" action="${pageContext.request.contextPath}/create">
            <h2>アカウント登録</h2>

            <p>
                <label for="username" class="floatLabel">ユーザー名</label> <input
                    id="username" name="username" type="text"
                    value="${account.username}" />
            </p>
            <p>
                <label for="email_address" class="floatLabel">メールアドレス</label> <input
                    id="email_address" name="email_address" type="text"
                    value="${account.email_address}" />
            </p>
            <p>
                <label for="password" class="floatLabel">パスワード</label> <input
                    id="password" name="password" type="password"
                    value="${account.password}" />
            </p>
            <p>
                <input type="hidden" name="_token" value="${_token}" /> <input
                    type="submit" value="新規登録" id="submit">
            </p>
        </form>

    </c:param>
</c:import>
