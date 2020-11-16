
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.PurchaseReview"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

<jsp:include page="../layouts/header.jsp" />

<%
	List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("maincategories");

String customId = (String) session.getAttribute("loginSession");
Integer bookSeq = (Integer) request.getAttribute("bookSeq");
%>

<div class="container">
	<div class="row ml-2 mt-5">
		<input type="text" value="${maincatename}"
			class="form-control col-sm-3 my-1" readonly="readonly"> <input
			type="text" value="${subcatename}"
			class="form-control col-sm-3 my-1 ml-3" readonly="readonly">
	</div>

</div>

<c:if test="${book != null}">
	<div class="card mb-3 container mt-5 " style="max-width: 1100px;">
		<div class="row no-gutters">
			<div class="col-md-4">
				<img src="${path}/resources/${book.bookImageName}" class="card-img"
					alt="...">
			</div>
			<div class="col-md-8">

				<div class="card-body  mt-5 ">
					<div class="row">
						<label class="col-sm-2 ">책제목</label> <p
							type="text"
							class="card-title font-weight-bold  col-sm-9"
							value="${book.bookTitle}" >${book.bookTitle}</p>

					</div>
					<div class="row mt-2">
						<label class="col-sm-2">한줄 소개</label> <p
							type="text"
							class="card-title font-weight-bold  col-sm-9"
							value="${book.bookIntro}" readonly="readonly">${book.bookIntro}</p>
					</div>

					<div class="row mt-2">
						<label class="col-sm-2">가격</label> <p
							type="number"
							class="card-title font-weight-bold  col-sm-9"
							value="${book.bookPrice}" readonly="readonly">${book.bookPrice}</p>
					</div>



					<form method="post" action="${path}/book/jangbaguni">
						<input type="hidden" name="bookSeq" value="${book.bookSeq}">
						<input type="hidden" name=customId value="${customId}"> <input
							type="hidden" name="bookPrice" value="${book.bookPrice}">


						<div class="row mt-2">
							<label class="col-sm-2 col-form-label">구매수량</label> <input
								type="text" name="bookOrderCnt" placeholder="구매하실 수량을 입력하세요"
								class="form-control col-sm-9">

						</div>

						<c:if test="${customId != null}">
							<button type="submit" class="btn btn-success mt-5 btn-lg">주문담기</button>
						</c:if>

					</form>
				</div>


			</div>
		</div>
	</div>
</c:if>

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




<c:if test="${not empty jangs}">
	<div class="card container mt-5">
		<div class="card-body">
			<form method="post" action="${path}/review/${bookSeq}" class="container">
				<label>댓글을 입력하세요</label>
				<textarea rows="5" class="form-control" name="purchaseReviewContent"></textarea>
				<input type="hidden" name="customId" value="${customId}">
				<button type="submit" class="btn btn-primary mt-3">댓글저장</button>
			</form>


		</div>
	</div>




</c:if>






<ul class="list-unstyled container">
	<c:forEach var="bookreview" items="${reviews}">
		<li class="media mt-4 container">
		<img src="https://ui-avatars.com/api/?name=${bookreview.customId}" class="mr-3" alt="avata">
			<div class="media-body">
				<div class="row">
					<h5 class="mt-0 mb-1 mr-3 ml-3">${bookreview.customId}</h5>
					<h5>${bookreview.purchaseReviewCreatedDate}</h5>
					<a href="#" class="ml-3">수정</a>
				</div>

				<p class="mr-3">${bookreview.purchaseReviewContent}</p>

			</div>
		</li>
	</c:forEach>
</ul>







<jsp:include page="../layouts/footer.jsp" />
