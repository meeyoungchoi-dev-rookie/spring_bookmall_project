<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.SubCategory"%>
<%@page import="com.bookkurly.bookmall.customer.category.entity.MainCategory" %>	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />

<%List<SubCategory> subCategories  = (List<SubCategory>)request.getAttribute("subCategories");
  String mainCateName = (String)request.getAttribute("mainCateName");
  Integer mainCateSeq = (Integer)request.getAttribute("mainCateSeq");
%>

<div class="jumbotron">
	<h1>서브카테고리 관리</h1>
</div>

<div class="container mt-3">
	<p class="font-weight-bold">메인카테고리: ${mainCateName}</p>
</div>



<table class="table text-center table-hover container">
	<thead>
		<tr>
			<th>서브카테고리</th>
			<th>도서수</th>
			<th>수정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="str" items="${subCategories}">
			<tr>
				<input type="hidden" name="subCateSeq" value="${str.subCateSeq}">
				<td>
					<a href="${path}/manager/subcate/${str.subCateSeq}">${str.subCateName}</a>
				</td>
				<td>${str.subCateBookCount}</td>
				<td><a class="btn btn-info">서브카테고리 수정</a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>


<div class="container">
	<a class="btn btn-info" href="${path}/manager/add/subcategory/${mainCateSeq}">서브카테고리 추가</a>
</div>



<jsp:include page="../layouts/footer.jsp" />




