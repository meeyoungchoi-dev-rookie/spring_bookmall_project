
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
%>
<div class="container mt-5">
	<img
		src="https://images.unsplash.com/photo-1598512199776-e0747530204a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1558&q=80"
		class="container" alt="...">

</div>

<div class="container">
	<div class="col-sm-6">

		<ul class="list-group list-group-horizontal-md mt-5">
			<c:forEach var="subcategory" items="${subatecategories}"
				varStatus="status">


				<c:choose>
					<c:when test="${subcategory.mainCateSeq == 1}">
						<a
							href="${path}/maincategory/${subcategory.mainCateSeq}/subcategory/${subcategory.subCateSeq}"
							class="btn btn-outline-success mr-3 btn-lg">${subcategory.subCateName}</a>
					</c:when>
					<c:when test="${subcategory.mainCateSeq == 2}">
						<a
							href="${path}/maincategory/${subcategory.mainCateSeq}/subcategory/${subcategory.subCateSeq}"
							class="btn btn-outline-success mr-3 btn-lg">${subcategory.subCateName}</a>
					</c:when>
				</c:choose>

			</c:forEach>




		</ul>


	</div>




</div>

<div class="container">
	<div class="row ml-2 mt-5">
		<input type="text" value="${maincate}"
			class="form-control col-sm-3 my-1" readonly="readonly"> <input
			type="text" value="${subCateName}"
			class="form-control col-sm-3 my-1 ml-3" readonly="readonly">
	</div>

</div>


<div class="container">


	<!-- C:/images/${subcatebook.bookImageName}
	${path}/resources/${subcatebook.bookImageName}


   -->
	<div class="row">

		<c:forEach var="subcatebook" items="${subcatebooks}">
			<div class="card mt-5 mr-5 ml-4" style="width: 19rem;">
				<img src="${path}/resources/${subcatebook.bookImageName}"
					class="card-img-top" alt="...">
				<div class="card-body">

					<h5 class="card-title container text-center font-weight-bold">${subcatebook.bookTitle}</h5>

					<p class="card-text container text-center">${subcatebook.bookPrice}원</p>
					<a
						href="${path}/book/${subcatebook.bookSeq}/subcateseq/${subcatebook.subCateSeq}"
						class="btn btn-primary btn-block text-center">상세조회</a>

				</div>
			</div>
		</c:forEach>



	</div>

</div>
<jsp:include page="../layouts/footer.jsp" />
