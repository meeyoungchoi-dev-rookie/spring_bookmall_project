<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.bookkurly.bookmall.customer.jang.entity.JangEntity"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />


<%
	List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("maincategories");

String userId = (String) session.getAttribute("loginSession");
%>

<div class="jumbotron">
	<h1>${userId}님장바구니</h1>
</div>



<table class="table text-center table-hover container">
	<thead>
		<tr>
			<th>책제목</th>
			<th>구매수량</th>
			<th>총가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="str" items="${myJangList}">
			<tr>
				<td>${str.bookTitle}</td>
				<td>${str.bookOrderCnt}</td>
				<td>${str.bookOrderCntPrice}</td>
			</tr>

			<c:set var="total" value="${total + str.bookOrderCntPrice}" />

		</c:forEach>

	</tbody>



</table>

<p class="container ">
	총 합계금액:
	<c:out value="${total}" />
	원
</p>


<div class="container">
	<button class="btn btn-outline-primary my-2 my-sm-0 ml-2 mr-20"
		type="submit">주문하기</button>



	<a class="btn btn-info  my-2 my-sm-0 ml-2"
		href="${path}/shop/categories">계속 쇼핑하기</a>
</div>





<jsp:include page="../layouts/footer.jsp" />