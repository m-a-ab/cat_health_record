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
            <h2>${nekoaccount.nekoname}の情報編集</h2>
        </header>
        <main>
            <form method="POST"
                action="${pageContext.request.contextPath}/nekoupdate">
                <label for="nekoname">愛猫の名前</label> <br> <input type="text"
                    id="nekoname" name="nekoname" value="${nekoaccount.nekoname}"> <br> <label for="image">愛猫タイプ</label>
                <br> <select name="image">
                    <option value="kijitora">キジトラ</option>
                    <option value="hachiware">ハチワレ</option>
                    <option value="kuro">黒</option>
                    <option value="shiro">白</option>
                </select> <br> <label for="birthday">誕生日</label> <br> <input
                    type="date" id="birthday" name="birthday" value="${nekoaccount.birthday}"> <br> <label
                    for="other">特記事項</label> <br>
                <textarea name="other" rows="6" cols="80"></textarea>
                <br>
                <br>


                <div id="button_wrap2">
                    <input type="hidden" name="_token" value="${_token}" /> <input
                        type="submit" value="更新">
                </div>
            </form>
            <br>
            <form method="POST"
                action="${pageContext.request.contextPath}/nekodestroy">
                <div id="button_wrap3" onclick="confirmDestroy();">
                    <input type="hidden" name="_token" value="${_token}" /> <input
                        type="button" value="削除" /><br>
                    <br>
                </div>

            </form>
            <script>
function confirmDestroy(){
    if(confirm("本当に削除しますか？")){
        document.forms[1].submit();
   }
}

</script>
        </main>

    </c:param>
</c:import>