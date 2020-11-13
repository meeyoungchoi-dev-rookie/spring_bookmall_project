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

JangEntity jangEntityDetail = (JangEntity)request.getAttribute("jangEntityDetail");
%>

<div class="container">
	<h1>${customId}님마이페이지</h1>
	<h2>결제내역 상세조회</h2>
</div>

<c:if test="${not empty jangEntityDetail}">
<table class="table text-center table-hover container">
	<thead>
		<tr>
			<th>결제번호</th>
			<th>결제일</th>
			<th>상품</th>
			<th>구매수량</th>
			<th>결제금액</th>
			<th>결제상테</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${jangEntityDetail.orderSerialNum}</td>
			<td>${jangEntityDetail.orderDate}</td>
			<td>${jangEntityDetail.bookTitle}</td>
			<td>${jangEntityDetail.bookOrderCnt}</td>
			<td>${jangEntityDetail.bookOrderCntPrice}</td>
			<td>${jangEntityDetail.orderPaymentStatus}</td>
		</tr>
	</tbody>

</table>



</c:if>

<div class="container">
	<form method="post" action="${path}/mypage/search">
		<input type="hidden" name="myOrderSerialNum" value="${jangEntityDetail.orderSerialNum}">
		<button type="submit" class="btn btn-success">결제목록</button>
	</form>
	
</div>





<jsp:include page="../layouts/footer.jsp" />



