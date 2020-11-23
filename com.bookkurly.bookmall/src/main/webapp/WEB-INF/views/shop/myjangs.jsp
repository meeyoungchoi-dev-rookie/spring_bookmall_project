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

List<JangEntity> myJangList = (List<JangEntity>) request.getAttribute("myJangList");
%>

<div class="jumbotron">
	<h1>${customId}님장바구니</h1>
</div>

<c:if test="${empty myJangList}">
	<h1>장바구니가 비어있습니다.</h1>
	<a href="${path}/maincategory/1/subcategory/1" class="btn btn-success">쇼핑하러가기</a>
</c:if>

<c:if test="${not empty myJangList}">
	<table class="table text-center table-hover container">
		<thead>
			<tr>
				<th>책제목</th>
				<th>구매수량</th>
				<th>총가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="str" items="${myJangList}">
				<tr>
					<form method="post" action="${path}/jang/update">
						<input type="hidden" name="bookSeq" value="${str.bookSeq}">
						<input type="hidden" name="orderSerialNum"
							value="${str.orderSerialNum}">
						<td>${str.bookTitle}</td>
						<td><input type="number" name="bookOrderCnt"
							value="${str.bookOrderCnt}" class="form-control"></td>

						<td>${str.bookOrderCntPrice}</td>
						<td><button type="submit" class="btn btn-info">수량번경</button></td>
					</form>

					<td><a class="btn btn-danger"
						href="${path}/jang/delete/book/${str.bookSeq}/${str.orderSerialNum}">상품삭제</a></td>
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
	<a class="btn btn-outline-primary my-2 my-sm-0 ml-2 mr-20"
		href="${path}/order/${myOrderSerialNum}">주문하기</a>



	<a class="btn btn-info  my-2 my-sm-0 ml-2"
		href="${path}/shopping">계속 쇼핑하기</a> <a
		class="btn btn-danger my-2 my-sm-0 ml-2"
		href="${path}/remove/${myOrderSerialNum}">장바구니 전체 삭제</a>
</div>

</c:if>



<jsp:include page="../layouts/footer.jsp" />