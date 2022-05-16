<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/nekonew.css'/>">
<c:import url="../layout/nekonew_base.jsp">

    <c:param name="content">
        <br>
        <br>
        <br>
        <br>

        <header>
            <h2>ねこ情報登録</h2>
        </header>
        <main>
            <form method="POST"
                action="${pageContext.request.contextPath}/nekocreate">

                <br>
                <label for="nekoname">愛猫の名前</label>
                <br>
                <input type="text" id="nekoname" name="nekoname">
                <br>
                <label for="image">愛猫タイプ</label>
                <br>
                <select class="image" name="image">
                    <option value="kijitora">キジトラ</option>
                    <option value="hachiware">ハチワレ</option>
                    <option value="kuro">黒</option>
                    <option value="shiro">白</option>
                </select>
                <br>
                <label for="birthday">誕生日</label>
                <br>
                <input type="date" id="birthday" name="birthday">
                <br>
                <label for="other">特記事項</label>
                <br>
                <textarea name="other" rows="6" cols="80"></textarea>
                <br>
                <br>
                <br>

                <div id="button_wrap">
                    <input type="hidden" name="_token" value="${_token}" /> <input
                        type="submit" value="登録" id="submit">
                </div>

            </form>
            <br>
            <br>

        </main>
    </c:param>
</c:import>