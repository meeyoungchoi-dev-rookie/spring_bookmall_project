
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />


<% List<MainCategory> mainCategories  = (List<MainCategory>)session.getAttribute("maincategories"); %>
<div class="container mt-5">
	<img
		src="https://images.unsplash.com/photo-1598512199776-e0747530204a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1558&q=80"
		class="container" alt="...">

</div>

<div class="container">
	<div class="col-sm-6">

		<ul class="list-group list-group-horizontal-md mt-5">
			<c:forEach var="subcategory" items="${subcategories}"
				varStatus="status">

				<a
					href="${path}/maincategory/${subcategory.mainCateSeq}/subcategory/${subcategory.subCateSeq}"
					class="btn btn-outline-success mr-3 btn-lg">${subcategory.subCateName}</a>
			</c:forEach>


		</ul>
	</div>
	
	 
</div>

<div class="container">



	<div class="row">

		<c:forEach var="book" items="${books}">
			<div class="card mt-5 mr-5 ml-4" style="width: 19rem;">
				<img
					src="${path}/resources/${book.bookImageName}"
					class="card-img-top" alt="...">
				<div class="card-body">

					<h5 class="card-title container text-center font-weight-bold">${book.bookTitle}</h5>

					<p class="card-text container text-center">${book.bookPrice}원</p>
					<a href="${path}/book/${book.bookSeq}/subcateseq/${book.subCateSeq}" class="btn btn-primary btn-block text-center">상세조회</a>

				</div>
			</div>
		</c:forEach>



	</div>

	<div class="row">

		<c:forEach var="book2" items="${books2}">
			<div class="card mt-5 mr-5 ml-4" style="width: 19rem;">
				<img
					src="${path}/resources/${book2.bookImageName}"
					class="card-img-top" alt="...">
				<div class="card-body">

					<h5 class="card-title container text-center font-weight-bold">${book2.bookTitle}</h5>
					<p class="card-text container text-center">${book2.bookPrice}원</p>
					<a href="${path}/book/${book2.bookSeq}/subcateseq/${book2.subCateSeq}" class="btn btn-primary btn-block text-center">상세조회</a>

				</div>
			</div>
		</c:forEach>
	</div>


	<div class="row">

		<c:forEach var="book3" items="${books3}">
			<div class="card mt-5 mr-5 ml-4" style="width: 19rem;">
				<img
					src="${path}/resources/${book3.bookImageName}"
					class="card-img-top" alt="...">
				<div class="card-body">

					<h5 class="card-title container text-center font-weight-bold">${book3.bookTitle}</h5>
					<p class="card-text container text-center">${book3.bookPrice}원</p>
					<a href="${path}/book/${book3.bookSeq}/subcateseq/${book3.subCateSeq}" class="btn btn-primary btn-block text-center">상세조회</a>

				</div>
			</div>
		</c:forEach>




	</div>

</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>