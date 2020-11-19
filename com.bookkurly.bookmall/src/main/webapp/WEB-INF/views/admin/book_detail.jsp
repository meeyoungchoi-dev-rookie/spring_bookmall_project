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

String mainCateName = (String)request.getAttribute("mainCateName");

String subCateName = (String)request.getAttribute("subCateName");


%>
<div class="jumbotron">
	<h1>관리자 도서상세조회</h1>
</div>

<div class="container mt-3">
	<p class="font-weight-bold ">메인카테고리: ${mainCateName} >> 서브카테고리: ${subCateName} >> 책제목: ${book.bookTitle}</p>
</div>


<c:if test="${book != null}">
<form method="post" action="${path}/manager/book/edit/${book.bookSeq}">
<div class="card mb-3 container mt-5 " style="max-width: 1100px;">
	
	<div class="row no-gutters">
		<div class="col-md-4">
			<img
				src="${path}/resources/${book.bookImageName}"
				class="card-img" alt="...">
		</div>
		<div class="col-md-8">
			
				
					<div class="card-body  mt-5 ">
						<div class="row">
							<label class="col-sm-2">책번호</label>
							<p class="card-title font-weight-bold col-sm-9">${book.bookSeq}</p>

						</div>
						<div class="row">
							<label class="col-sm-2 ">책제목</label>
							<p class="card-title font-weight-bold  col-sm-9">${book.bookTitle}</p>
						</div>
						<div class="row">
							<label class="col-sm-2">한줄 소개</label>
							<p class="card-title font-weight-bold col-sm-9">${book.bookIntro}</p>
						</div>

						<div class="row">
							<label class="col-sm-2">가격</label>
							<p type="number" class="card-title font-weight-bold col-sm-9">${book.bookPrice}</p>
						</div>

						<div class="row">
							<label class="col-sm-2">재고수량</label>
							<p class="col-sm-9">${book.bookAmount}</p>
						</div>





					</div>
		</div>

	</div>
</div>


<div class="container mt-5">
	<label class="col-sm-2">책 내용</label>
	<p>${book.bookDescription}</p>
</div>


<div class="container mt-5">
	<label class="col-sm-2">목차</label>
	<div>${book.bookContents}</div>
</div>


<div class="container">
	<button type="submit" class="btn btn-success">수정하기</button>

</div>
</form>
</c:if>



<jsp:include page="../layouts/footer.jsp" />





