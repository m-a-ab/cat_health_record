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
            <h2>体調登録</h2>
        </header>
        <main>
            <form method="POST"
                action="${pageContext.request.contextPath}/condition_create">

                <!--

                <label for="neko_id">猫ID</label>
                <br>-->
                <input type="hidden" id="neko_id" name="neko_id" value="${nekoaccount.id}">



                <label for="date">日付</label>
                <br>
                <input type="date" id="date" name="date">
                <br>
                <label for="food">ごはん</label>
                <br>
                <div class=".radiobutton ">
                    <input type="radio" name="food" value="食べた" id="food">
                    食べた
                    <br>
                    <input type="radio" name="food" value="いつもより少なめ">
                    いつもより少なめ
                    <br>
                    <input type="radio" name="food" value="食べない">
                    食べない
                    <br>
                </div>
                <p>その他、詳細など記載</p>
                <textarea name="food_other" rows="4" cols="40"></textarea>

                <label for="water">お水</label>
                <br>
                <input type="radio" name="water" value="飲んだ">
                飲んだ
                <br>
                <input type="radio" name="water" value="いつもより少なめ">
                いつもより少なめ
                <br>
                <input type="radio" name="water" value="飲んでないがウェットフード食べた">
                飲んでないがウェットフード食べた
                <br>
                <input type="radio" name="water" value="全く飲まない">
                全く飲まない
                <br>
                <p>その他、詳細など記載</p>
                <textarea name="water_other" rows="4" cols="40"></textarea>


                <label for="pee">おしっこ</label>
                <br>
                <input type="radio" name="pee" value="正常">
                正常
                <br>
                <input type="radio" name="pee" value="いつもより多め">
                いつもより多め
                <br>
                <input type="radio" name="pee" value="いつもより少なめ">
                いつもより少なめ
                <br>
                <input type="radio" name="pee" value="血が混じっている">
                血が混じっている
                <br>
                <input type="radio" name="pee" value="全くしていない">
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
                <textarea name="vomit_other" rows="4" cols="40"></textarea>

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
                <br>
                <div id="button_wrap">
                    <input type="hidden" name="_token" value="${_token}" />
                    <input type="submit" value="登録" id="submit">
                </div>
                <br>
                <br>

            </form>
        </main>
    </c:param>
</c:import>