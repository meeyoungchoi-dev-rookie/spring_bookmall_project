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
String subCateName = (String)request.getAttribute("subCateName");
String mainCateName = (String)request.getAttribute("mainCateName");
Integer subCateSeq = (Integer)request.getAttribute("subCateSeq");
Integer mainCateSeq = (Integer)request.getAttribute("mainCateSeq");
%>

<div class="jumbotron">
	<h1>도서관리</h1>
</div>


<div class="container">
	<p>메인카테고리: ${mainCateName} >> 서브카테고리: ${subCateName}</p>
</div>


<div class="container">
	<a class="btn btn-success" href="${path}/manager/add/book/${mainCateSeq}/${subCateSeq}">도서추가</a>
</div>



<div class="container">



	<div class="row">

		<c:forEach var="str" items="${books}">
			<div class="card mt-5 mr-5 ml-4" style="width: 19rem;">
				<img
					src="${path}/resources/${str.bookImageName}"
					class="card-img-top" alt="...">
				<div class="card-body">

					<h5 class="card-title container text-center font-weight-bold">${str.bookTitle}</h5>
					<p class="card-text container text-center">${str.bookPrice}원</p>
					<a
						href="${path}/manager/book/${str.bookSeq}"
						class="btn btn-primary btn-block text-center">상세조회</a>

				</div>
			</div>
		</c:forEach>



	</div>

</div>






<jsp:include page="../layouts/footer.jsp" />