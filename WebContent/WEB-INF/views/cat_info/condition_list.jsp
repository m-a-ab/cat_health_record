<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/condition_list.css'/>">
<c:import url="../layout/nekonew_base.jsp">
 <c:param name="content">



<body>
  <header>
            <h2>体調一覧</h2>
            </header>
<br><br><br><br>
<main>

<table id="condition_list">
<tbody>
<tr>
 <th class="date">日付</th>
 <th class="food">ごはん</th>
 <th class="water">お水</th>
  <th class="pee">おしっこ</th>
  <th class="poop">うんち</th>
  <th class="vomit">きらきら</th>
  <th class="exercise">運動量</th>
  <th class="button"></th>

</tr>
<!--
　<th class="etc">その他</th>
 <th class="food_other">ごはんその他</th>
 <th class="water_other">お水その他</th>
 <th class="pee_other">おしっこその他</th>
 <th class="poop_other">うんちその他</th>
 <th class="vomit_other">吐くその他</th>
 <th class="exercise_other">運動量その他</th>
-->
<c:forEach var="conditions" items="${conditions}" varStatus="status">


<tr class="row${status.count % 2 }">
   <td class="date">${conditions.date}
   <td class="food">${conditions.food}</td>
   <td class="water">${conditions.water}</td>
   <td class="pee">${conditions.pee}</td>
   <td class="poop">${conditions.poop}</td>
   <td class="vomit">${conditions.vomit}</td>
   <td class="exercise">${conditions.exercise}</td>
    <td class="button"> <a href="${pageContext.request.contextPath}/condition_edit?id=${conditions.id}">編集</a></td>
<!--    <td class="etc">${conditions.etc}</td>-->
   </tr>
   </c:forEach>
   </tbody>
</table>






</main>

</body>
</c:param>
</c:import>
</html>