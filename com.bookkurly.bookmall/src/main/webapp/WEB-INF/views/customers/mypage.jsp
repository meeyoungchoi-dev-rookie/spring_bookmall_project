<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.bookkurly.bookmall.customer.jang.entity.JangEntity"%>
<%@page import="com.bookkurly.bookmall.customer.jang.dto.JangInfo"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />
<%
	List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("maincategories");

String customId = (String) session.getAttribute("loginSession");

List<JangEntity> myOrders = (List<JangEntity>) request.getAttribute("myOrders");
%>

<div class="container">
	<h1>${customId}님마이페이지</h1>
</div>


<form class="form-inline mr-auto container mt-5" method="post"
	action="${path}/mypage/search">
	<input class="form-control col-sm-8" type="text"
		placeholder="주문번호를 사용하여 검색하세요" name="myOrderSerialNum"
		aria-label="Search">
	<button class="btn btn-success btn-rounded btn-sm my-0 ml-sm-2"
		type="submit">Search</button>
</form>


<c:if test="${not empty myOrderSerialNum}">
	<div class="container mt-3">
		<h1>주문번호: ${myOrderSerialNum}</h1>
	</div>
</c:if>



<c:if test="${not empty myOrders}">
	<table class="table text-center table-hover container mt-5">
		<thead>
			<tr>
				<th>결제일</th>
				<th>상품명</th>
				<th>결제금액</th>
				<th>출하상태</th>
				<th>배송상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="str" items="${myOrders}">
				<tr>
					<td>${str.orderDate}</td>
					<td><a href="${path}/order/detail/${myOrderSerialNum}/${str.bookTitle}">${str.bookTitle}</a></td>
					<td>${str.bookOrderCntPrice}</td>
					<td>출하완료</td>
					<td>배송준비중</td>
				</tr>


			</c:forEach>


		</tbody>





	</table>




</c:if>

<jsp:include page="../layouts/footer.jsp" />