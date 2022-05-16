<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>猫の体調管理カレンダー</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <div id="content">${param.content}</div>
</body>
</html>