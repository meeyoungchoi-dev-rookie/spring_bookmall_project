<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.SubCategory"%>
<%@page import="com.bookkurly.bookmall.customer.category.entity.Book"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<%
	List<SubCategory> subCategories = (List<SubCategory>) request.getAttribute("subCategories");
List<Book> books = (List<Book>) request.getAttribute("books");

Book book = (Book) request.getAttribute("book");

String mainCateName = (String) request.getAttribute("mainCateName");
%>

<div class="jumbotron">
	<h1>관리자 도서 수정페이지</h1>
</div>


<div class="container mt-3">
	<p class="font-weight-bold ">메인카테고리: ${mainCateName} >> 서브카테고리:
		${book.subCateName} >> 책제목: ${book.bookTitle}</p>
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
				<form method="post"
					action="${path}/manager/book/update/${mainCateName}">
					<div class="card-body  mt-5 ">
						<div class="row">
							<label class="col-sm-2">책번호</label>
							<p class="card-title font-weight-bold col-sm-9" name="bookSeq"
								value="${bookSeq}">${book.bookSeq}</p>

						</div>
						<div class="row">
							<label class="col-sm-2">메인카테</label> <input type="text"
								class="card-title font-weight-bold  col-sm-9 form-control"
								name="mainCateName" value="${mainCateName}" readonly="readonly">

						</div>

						<div class="row">
							<label class="col-sm-2">서브카테</label> <input type="text"
								class="card-title font-weight-bold  col-sm-9 form-control"
								name="subCateName" value="${book.subCateName}" readonly="readonly">

						</div>



						<div class="row">
							<label class="col-sm-2  ">책제목</label> <p
								
								class="card-title font-weight-bold  col-sm-9 ">${book.bookTitle}</p>
								<input type="hidden" name="bookTitle" value="${book.bookTitle}">
						</div>
						<div class="row">
							<label class="col-sm-2 col-form-label">한줄 소개</label> <input
								type="text" name="bookIntro" value="${book.bookIntro}"
								class="card-title font-weight-bold col-sm-9 form-control">
						</div>

						<div class="row">
							<label class="col-sm-2 col-form-label">가격</label> <input
								type="text" name="bookPrice" value="${book.bookPrice}"
								class="card-title font-weight-bold col-sm-9 form-control">
						</div>

						<div class="row">
							<label class="col-sm-2 col-form-label">재고수량</label> <input
								type="text" name="bookAmount" value="${book.bookAmount}"
								class="col-sm-9 form-control">
						</div>
						
						<input type="hidden" name="bookImageName" value="${book.bookImageName}">
						<input type="hidden" name="bookStatus" value="${book.bookStatus}">
						<input type="hidden" name="subCateSeq" value="${book.subCateSeq}">

					</div>
		</div>

	</div>
</div>

<div class="container mt-5">
	<label class="col-sm-2">목차</label>
	<input type="text" name="bookContents" value="${book.bookContents}" class="col-sm-8 form-control">
</div>
<div class="container mt-5">
	<label class="col-sm-2">책 내용</label>
	<p>책 내용</p>
</div>

<div class="container">
	<button type="submit" class="btn btn-success">수정완료</button>

</div>

</c:if>


</form>






<jsp:include page="../layouts/footer.jsp" />