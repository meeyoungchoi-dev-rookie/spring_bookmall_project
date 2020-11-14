<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<%
	String mainCateName = (String)request.getAttribute("mainCateName");
	Integer mainCateSeq = (Integer)request.getAttribute("mainCateSeq");
	
%>
<div class="jumbotron">
	<h1>관리자 서브카테고리 추가</h1>
</div>

<div class="container">
	<p class="font-weight-bold">메인카테고리: ${mainCateName}</p>
</div>



<form method="post" action="${path}/manager/add/subcate" class="container">
	<div class="form-group"> 
		<label>서브카테고리</label>
		<input type="text" name="subCateName" placeholder="추가할 서브카테고리 이름을 입력하세요" class="form-control">
	</div>
	
	<input type="hidden" name="mainCateSeq" value="${mainCateSeq}">
	
	
	
	<button type="submit" class="btn btn-success">저장</button>
	
	
</form>









</body>
</html>