<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>愛猫の体調管理カレンダー</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/menu.css' />">
</head>
<body>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="<c:url value='/js/menu.js' />"></script>
    <button type="button" class="btn js-btn">
      <span class="btn-line"></span>
    </button>
    <nav>
      <ul class="menu">
        <li class="menu-lists"> <a href="${pageContext.request.contextPath}/top">愛猫一覧</a></li>
        <li class="menu-lists"> <a href="${pageContext.request.contextPath}/nekonew"> 新規猫登録</a></li>
        <li class="menu-lists"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></li>
      </ul>
    </nav>
    <div id="content">${param.content}</div>

<!-- 共通する部分書く -->
</body>
</html>