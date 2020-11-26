
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
	
//String customId = (String) session.getAttribute("loginSession");
//Integer bookSeq = (Integer) request.getAttribute("bookSeq");
%>

<div class="container">
	<div class="row ml-2 mt-5">
		<p class="col-sm-3 my-1">${maincatename}</p>
		<p class="col-sm-3 my-1 ml-3">${subcatename}</p>
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
						<label class="col-sm-2 ">책제목</label>
						<p type="text" class="card-title font-weight-bold  col-sm-9"
							value="${book.bookTitle}">${book.bookTitle}</p>

					</div>
					<div class="row mt-2">
						<label class="col-sm-2">한줄 소개</label>
						<p type="text" class="card-title font-weight-bold  col-sm-9"
							value="${book.bookIntro}" readonly="readonly">${book.bookIntro}</p>
					</div>

					<div class="row mt-2">
						<label class="col-sm-2">가격</label>
						<p type="number" class="card-title font-weight-bold  col-sm-9"
							value="${book.bookPrice}" readonly="readonly">${book.bookPrice}</p>
					</div>



					<form method="post" action="${path}/book/jangbaguni">
						<input type="hidden" name="bookSeq" value="${book.bookSeq}">
						<input type="hidden" name=customId value="${customId}"> <input
							type="hidden" name="bookPrice" value="${book.bookPrice}">

						<c:if test="${customId != null}">
							<div class="row mt-2">
								<label class="col-sm-2 col-form-label">구매수량</label> <input
									type="text" name="bookOrderCnt" placeholder="구매하실 수량을 입력하세요"
									class="form-control col-sm-9">

							</div>


							<button type="submit" class="btn btn-success mt-5 btn-lg">장바구니
								담기</button>
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
		<label class="font-weight-bold">목차</label>
		<p>${book.bookContents}</p>

	</c:if>
</div>

<c:if test="${customId == null}">
	<div class="container">
		<p class="text-success">도서를 구매하신후 댓글을 작성하실수 있습니다</p>
	</div>
</c:if>



<c:if test="${not empty jangs}">

	<div class="card container mt-5">
		<div class="card-body">
			<form method="post" action="${path}/review/${bookSeq}"
				class="container">
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
		<li class="media mt-4 container"><img
			src="https://ui-avatars.com/api/?name=${bookreview.customId}"
			class="mr-3" alt="avata">
			<div class="media-body">
				<div class="row">
					<h5 class="mt-0 mb-1 mr-3 ml-3">${bookreview.customId}</h5>
					<h5>${bookreview.purchaseReviewCreatedDate}</h5>
					<c:if
						test="${bookreview.writerStatus eq true && bookreview.customSeq == customSeq}">
						<a href="#" class="review-edit-btn ml-3" data-toggle="collapse"
							data-target=".multi-collapse-${bookreview.purchaseReviewSeq}">수정</a>
						<!-- <a
							href="${path}/review/${bookreview.purchaseReviewSeq}/delete/${bookreview.bookSeq}"
							class="review-edit-btn ml-3" style="color: red">삭제</a> -->

						<button type="button" class="btn btn-danger ml-3" data-toggle="modal"
							data-target="#exampleModal">삭제</button>

						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Modal
											title</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">정말로 삭제하시겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-warning"
											data-dismiss="modal">취소</button>
											<form method="get" action="${path}/review/${bookreview.purchaseReviewSeq}/delete/${bookreview.bookSeq}">
												<button type="submit" class="btn btn-danger">삭제</button>	
											</form>
										
									</div>
								</div>
							</div>
						</div>

					</c:if>

				</div>

				<p
					class="collapse multi-collapse-${bookreview.purchaseReviewSeq} show mr-3">${bookreview.purchaseReviewContent}</p>

				<form
					class="collapse multi-collapse-${bookreview.purchaseReviewSeq}"
					method="post"
					action="${path}/review/update/${bookreview.purchaseReviewSeq}">
					<div class="form-group">
						<textarea class="form-control" name="purchaseReviewContent"
							rows="3">${bookreview.purchaseReviewContent}</textarea>
					</div>
					<input type="hidden" name="purchaseReviewSeq"
						value="${bookreview.purchaseReviewSeq}"> <input
						type="hidden" name="customId" value="${bookReview.customId}">
					<input type="hidden" name="customSeq"
						value="${bookReview.customSeq}"> <input type="hidden"
						name="orderSeq" value="${bookReview.orderSeq}"> <input
						type="hidden" name="bookSeq" value="${bookReview.bookSeq}">
					<input type="hidden" name="orderSerialNum"
						value="${bookReview.orderSerialNum}"> <input type="hidden"
						name="writerStatus" value="${bookReview.writerStataus}">
					<button type="submit" class="btn btn-info comment-update-btn">수정
						완료</button>
				</form>

			</div></li>
	</c:forEach>
</ul>







<jsp:include page="../layouts/footer.jsp" />
