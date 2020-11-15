<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<div class="jumbotron">
	<h1>메인카테고리 관리</h1>
</div>


<table class="table text-center table-hover container">
	<thead>
		<tr>
			<th>#</th>
			<th>카테고리</th>
			<th>수정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="str" items="${mainCategories}">
			<tr>
				<td>${str.mainCateSeq}</td>
				<td>
					<a href="${path}/manager/maincategory/${str.mainCateSeq}">${str.mainCateName}</a>
				</td>
				<td><a class="btn btn-info" href="${path}/manager/${str.mainCateSeq}/update">메인카테고리 수정</a></td>
			</tr>

		</c:forEach>
	</tbody>

</table>

<div class="container">
	<a href="${path}/manager/create" class="btn btn-success">메인카테고리 추가</a>
</div>












<jsp:include page="../layouts/footer.jsp" />