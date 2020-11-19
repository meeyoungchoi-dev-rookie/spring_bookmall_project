<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@page import="com.bookkurly.bookmall.customer.jang.entity.JangEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />

<%
	List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("maincategories");

String customId = (String) session.getAttribute("loginSession");

List<JangEntity> myOrders = (List<JangEntity>) request.getAttribute("myOrders");

String myOrderSerialNum = (String)request.getAttribute("myOrderSerialNum");
%>

<div class="container">
	<h1>${customId}님 결제완료되었습니다.</h1>
	<h2>결제번호: ${myOrderSerialNum}</h2>
</div>

<table class="table text-center table-hover container mt-5">
		<thead>
			<tr>
				<th>책제목</th>
				<th>구매수량</th>
				<th>총가격</th>
				<th>결제상태</th>
				<th>배송상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="str" items="${myOrders}">
				<tr>
					<td>${str.bookTitle}</td>
					<td>${str.bookOrderCnt}</td>

					<td>${str.bookOrderCntPrice}</td>
					<td>${str.orderPaymentStatus}</td>
					<td>
						<c:if test="${str.orderDeliveryStatus == false}">
							배송중
						</c:if>
							<c:if test="${str.orderDeliveryStatus == true}">
							배송완료
						</c:if>
					</td>
				</tr>

				<c:set var="total" value="${total + str.bookOrderCntPrice}" />

			</c:forEach>

		</tbody>



	</table>


	<div class="container">
		<a class="btn btn-info" href="${path}/shopping">확인</a>
	</div>





</body>
</html>