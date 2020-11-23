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
<script src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
<div class="jumbotron">
	<h1>관리자 도서 수정페이지</h1>
</div>


<div class="container mt-3">
	<p class="font-weight-bold ">메인카테고리: ${mainCateName} >> 서브카테고리:
		${book.subCateName} >> 책제목: ${book.bookTitle}</p>
</div>


<c:if test="${book != null}">
	<form method="post"
		action="${path}/manager/book/update/${book.bookSeq}"
		enctype="multipart/form-data">
		<div class="card mb-3 container mt-5 " style="max-width: 1100px;">
			<div class="row no-gutters">
				<div class="col-md-4">
					<img src="${path}/resources/${book.bookImageName}" class="card-img"
						alt="...">


				</div>
				<div class="col-md-8">


					<div class="card-body  mt-5 ">
						<div class="row">
							<label class="col-sm-2">책번호</label>
							<p class="card-title font-weight-bold col-sm-9">${book.bookSeq}</p>
							<input type="hidden" name="bookSeq" value="${book.bookSeq}">

						</div>
						<div class="row">
							<label class="col-sm-2">메인카테</label>
							<p class="card-title font-weight-bold  col-sm-9">${mainCateName}</p>

						</div>

						<div class="row">
							<label class="col-sm-2">서브카테</label>
							<p type="text" class="card-title font-weight-bold  col-sm-9 ">${book.subCateName}</p>

						</div>



						<div class="row">
							<label class="col-sm-2  ">책제목</label>
							<p class="card-title font-weight-bold  col-sm-9 ">${book.bookTitle}</p>
							<input type="hidden" name="bookTitle" value="${book.bookTitle}">
						</div>
						<div class="row">
							<label class="col-sm-2 col-form-label">한줄소개</label> <input
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

						<input type="hidden" name="bookStatus" value="${book.bookStatus}">
						<input type="hidden" name="subCateSeq" value="${book.subCateSeq}">
						<input type="hidden" name="subCateName"
							value="${book.subCateName}"> <input type="file"
							name="file" placeholder="첨부할 이미지 파일을 선택하세요">
					</div>
				</div>

			</div>
		</div>

		<!-- 
		<div class="container mt-5">
			<label class="col-sm-2">목차</label>
			<p class="card-title font-weight-bold col-sm-9">${book.bookContents}</p>
			<input type="hidden" name="bookContents" value="${book.bookContents}">
		</div>
 -->
		<div class="container mt-5">

			<label class="col-sm-2">목차</label>
		</div>
		<textarea rows="10" cols="50" id="editor" name="bookContents" value="${book.bookContents}"
			class="ckeditor">${book.bookContents}</textarea>
		<script>
			var ckeditor_config = {

				resize_enable : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P
			};

			CKEDITOR.replace("editor", ckeditor_config);
		</script>
		<input type="hidden" name="bookContents">




		<div class="container mt-5">
			<label class="col-sm-2">책 설명</label>
		
			
				<textarea rows="10" cols="50" id="editor" name="bookDescription" 
			>${book.bookDescription}</textarea>
			<input type="hidden" name="bookDescription"
				value="${book.bookDescription}">
		</div>

		<div class="container">
			<button type="submit" class="btn btn-success">수정완료</button>

		</div>
</c:if>


</form>






<jsp:include page="../layouts/footer.jsp" />