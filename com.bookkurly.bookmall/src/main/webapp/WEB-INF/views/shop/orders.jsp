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

String userId = (String) session.getAttribute("loginSession");

List<JangEntity> myOrders = (List<JangEntity>) request.getAttribute("myOrders");
%>


<c:if test="${not empty userId}">
	<div class="jumbotron">
		<h1>${userId}님주문목록</h1>

	</div>
</c:if>

<c:if test="${not empty myOrders}">
	<table class="table text-center table-hover container">
		<thead>
			<tr>
				<th>책제목</th>
				<th>구매수량</th>
				<th>총가격</th>
				<th>결제상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="str" items="${myOrders}">
				<tr>

					<input type="hidden" name="bookSeq" value="${str.bookSeq}">
					<input type="hidden" name="orderSerialNum"
						value="${str.orderSerialNum}">
					<td>${str.bookTitle}</td>
					<td>${str.bookOrderCnt}</td>

					<td>${str.bookOrderCntPrice}</td>
					<td>${str.orderPaymentStatus}</td>
				</tr>

				<c:set var="total" value="${total + str.bookOrderCntPrice}" />

			</c:forEach>

		</tbody>



	</table>




</c:if>


<p class="container ">
	총 결제금액:
	<c:out value="${total}" />
	원
</p>

<div class="container">
	<form method="post" action="${path}/payment/${myOrderSerialNum}">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">주문자 아이디</label>
			<p class="col-sm-10 text-center">${userId}</p>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">주문자 이름</label>
			<input type="text" name="userName" class="form-control col-sm-10">
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">배송지 주소</label>
			<input type="text" name="address" class="form-control col-sm-10">
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">배송지 주소</label>
			<input type="number" name="연락처" class="form-control col-sm-10">
		</div>
	


		<button class="btn btn-outline-primary my-2 my-sm-0 ml-2 mr-20"
		 type="submit">결제하기</button>

	</form>




</div>



</body>
</html>