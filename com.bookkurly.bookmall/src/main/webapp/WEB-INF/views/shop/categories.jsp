
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bookkurly.bookmall.customer.category.entity.MainCategory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

	

<jsp:include page="../layouts/header.jsp" />


<% List<MainCategory> mainCategories  = (List<MainCategory>)session.getAttribute("maincategories"); %>

<div class="jumbotron">
	<h1>고객이 볼 페이지</h1>
</div>

<div class="conainter">
	<div class="row">

		<div class="col-sm-4">
			<label>카테고리 선택</label>
			<c:forEach var="maincategory" items="${mainCategories}"
				varStatus="status">
				<div class="row">






					<a href="${path}/subacategory/${maincategory.mainCateSeq}">${maincategory.mainCateName}</a>

				</div>
			</c:forEach>
		</div>

	</div>
</div>



<jsp:include page="../layouts/footer.jsp" />
