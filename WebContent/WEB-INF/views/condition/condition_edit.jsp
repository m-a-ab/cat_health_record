<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/condition.css'/>">
<c:import url="../layout/nekonew_base.jsp">

    <c:param name="content">
        <br>
        <br>
        <br>
        <br>
        <header>
            <h2>体調編集</h2>
        </header>
        <main>
            <form method="POST"
                action="${pageContext.request.contextPath}/condition_update">

                <!-- 後で消す

                <label for="neko_id">猫ID</label>
                <br>
                <input type="text" id="neko_id" name="neko_id">
                <br>　-->
                <label for="date">日付</label>
                <br>
                <input type="date" id="date" name="date" value="${conditions.date}">
                <br>
                <label for="food">ごはん</label>
                <br>
                <div class=".radiobutton ">
                    <input type="radio" name="food" id="food" <c:if test= "${conditions.food == '食べた'}">checked </c:if> value="${conditions.food}" />
                    食べた
                    <br>
                    <input type="radio" name="food" <c:if test= "${conditions.food == 'いつもより少なめ'}">checked</c:if> value="${conditions.food}" />
                    いつもより少なめ
                    <br>
                    <input type="radio" name="food" <c:if test= "${conditons.food == '食べない'}"> checked </c:if> value="${conditions.food}" />
                    食べない
                    <br>
                </div>
                <p>その他、詳細など記載</p>
                <textarea name="food_other" rows="4" cols="40" ></textarea>

                <label for="water">お水</label>
                <br>
                <input type="radio" name="water" value="${conditions.water}">
                飲んだ
                <br>
                <input type="radio" name="water" value="${conditions.water}">
                いつもより少なめ
                <br>
                <input type="radio" name="water" value="${conditions.water}">
                飲んでないがウェットフード食べた
                <br>
                <input type="radio" name="water" value="${conditions.water}">
                全く飲まない
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="water_other" rows="4" cols="40"></textarea>


                <label for="pee">おしっこ</label>
                <br>
                <input type="radio" name="pee" value="${conditions.pee}">
                正常
                <br>
                <input type="radio" name="pee" value="${conditions.pee}">
                いつもより多め
                <br>
                <input type="radio" name="pee" value="${conditions.pee}">
                いつもより少なめ
                <br>
                <input type="radio" name="pee" value="${conditions.pee}">
                血が混じっている
                <br>
                <input type="radio" name="pee" value="${conditions.pee}">
                全くしていない
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="pee_other" rows="4" cols="40"></textarea>

                <label for="poop">うんち</label>
                <br>
                <input type="radio" name="poop" value="正常">
                正常
                <br>
                <input type="radio" name="poop" value="いつもより多め">
                いつもより多め
                <br>
                <input type="radio" name="poop" value="いつもより少なめ">
                いつもより少なめ
                <br>
                <input type="radio" name="poop" value="ゆるい">
                ゆるい
                <br>
                <input type="radio" name="poop" value="下痢">
                下痢
                <br>
                <input type="radio" name="poop" value="血が混じっている">
                血が混じっている
                <br>
                <input type="radio" name="poop" value="全くしていない">
                全くしていない
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="poop_other" rows="4" cols="40"></textarea>

                <label for="vomit">吐く</label>
                <br>
                <input type="radio" name="vomit" value="０回">
                ０回
                <br>
                <input type="radio" name="vomit" value="２回">
                ２回
                <br>
                <input type="radio" name="vomit" value="３回以上">
                ３回
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="vomit" rows="4" cols="40"></textarea>

                <label for="exercise">運動量</label>
                <br>
                <input type="radio" name="exercise" value="通常通り">
                通常通り
                <br>
                <input type="radio" name="exercise" value="いつもより活発">
                いつもより活発
                <br>
                <input type="radio" name="exercise" value="いつもより動かない">
                いつもより動かない
                <br>
                <input type="radio" name="exercise" value="元気がない">
                元気がない
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="exercise_other" rows="4" cols="40"></textarea>

                <label for="etc">その他</label>
                <br>
                <textarea name="etc" rows="5" cols="50"></textarea>
                <br>
                <br>
                <div id="button_wrap2">
                    <input type="hidden" name="_token" value="${_token}" />
                    <input type="submit" value="編集" id="submit">
                </div>
                <br>
            </form>
            <div id="button_wrap3" onclick="confirmDestroy();">
                <form method="POST"
                    action="${pageContext.request.contextPath}/condition_destroy">
                    <input type="hidden" name="_token" value="${_token}" />
                    <input type="submit" value="削除" id="submit">
                </form>
            </div>
            <br>
            <br>
            <script>
                function confirmDestroy(){
                    if(confirm("本当に削除しますか？")){
                        document.form[1].submit();
                    }
                }
            </script>
        </main>
    </c:param>
</c:import>