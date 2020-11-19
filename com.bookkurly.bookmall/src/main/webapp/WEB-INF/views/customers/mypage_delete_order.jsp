<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>${customId}님마이페이지</h1>
	<h2>결제 취소 내역</h2>
</div>

<div class="container">
	<h1>결제 취소되었습니다</h1>
</div>

<c:if test="${not empty deletejangs}">
<table class="table text-center table-hover container mt-5">
	<thead>
			<tr>
				<th>결제일</th>
				<th>상품명</th>
				<th>결제금액</th>
				<th>취소상태</th>
			</tr>
	</thead>
	<tbody>
			<c:forEach var="str" items="${deletejangs}">
				<tr>
					<td>${str.orderDate}</td>
					<td><a href="${path}/order/detail/${myOrderSerialNum}/${str.bookTitle}">${str.bookTitle}</a></td>
					<td>${str.bookOrderCntPrice}</td>
					<td>취소완료</td>
				</tr>


			</c:forEach>


		</tbody>

</table>


</c:if>




</body>
</html>