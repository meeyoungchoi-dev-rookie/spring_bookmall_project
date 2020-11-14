
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

<jsp:include page="../layouts/header.jsp" />

<%
	List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("maincategories");

String customId = (String) session.getAttribute("loginSession");
%>

<div class="container">
	<div class="row ml-2 mt-5">
		<input type="text" value="${maincatename}"
			class="form-control col-sm-3 my-1" readonly="readonly"> <input
			type="text" value="${subcatename}"
			class="form-control col-sm-3 my-1 ml-3" readonly="readonly">
	</div>

</div>


<div class="card mb-3 container mt-5 " style="max-width: 1100px;">
	<div class="row no-gutters">
		<div class="col-md-4">
			<img
				src="https://image.shutterstock.com/image-illustration/handsome-cartoon-character-billy-sitting-600w-1388391212.jpg"
				class="card-img" alt="...">
		</div>
		<div class="col-md-8">
			<c:if test="${book != null}">
				<div class="card-body  mt-5 ">
					<div class="row">
						<label class="col-sm-2 col-form-label">책제목</label> <input
							type="text"
							class="card-title font-weight-bold form-control col-sm-9"
							value="${book.bookTitle}" readonly="readonly">

					</div>
					<div class="row">
						<label class="col-sm-2 col-form-label">한줄 소개</label> <input
							type="text"
							class="card-title font-weight-bold form-control col-sm-9"
							value="${book.bookIntro}" readonly="readonly">
					</div>

					<div class="row">
						<label class="col-sm-2 col-form-label">가격</label> <input
							type="number"
							class="card-title font-weight-bold form-control col-sm-9"
							value="${book.bookPrice}" readonly="readonly">
					</div>



					<form method="post" action="${path}/book/jangbaguni">
						<input type="hidden" name="bookSeq" value="${book.bookSeq}">
						<input type="hidden" name=customId value="${customId}">
						<input type="hidden" name="bookPrice" value="${book.bookPrice}">
						
						
						<div class="row">
							<label class="col-sm-2 col-form-label">구매수량</label> <input
								type="text" name="bookOrderCnt" placeholder="구매하실 수량을 입력하세요"
								class="form-control col-sm-9">

						</div>

						<c:if test="${customId != null}">
							<button type="submit" class="btn btn-success mt-5 btn-lg">주문담기</button>
						</c:if>

					</form>
				</div>
			</c:if>
		</div>
	</div>
</div>


<div class="container">
	<c:if test="${book != null}">
		<label class="font-weight-bold">책설명</label>
		<p>${book.bookDescription}</p>

	</c:if>

</div>



<div class="container">
	<c:if test="${book != null}">
		<p>${book.bookContents}</p>

	</c:if>
</div>






<div class="card container mt-5">
	<div class="card-body">
		<form method="post" action="/comments/{{articleId}}" class="container">
			<label>댓글을 입력하세요</label>
			<textarea rows="5" class="form-control" name="comment"></textarea>
			<input type="hidden" name="author" value="hong park">
			<button type="submit" class="btn btn-primary mt-3">댓글저장</button>
		</form>


	</div>
</div>







<jsp:include page="../layouts/footer.jsp" />
