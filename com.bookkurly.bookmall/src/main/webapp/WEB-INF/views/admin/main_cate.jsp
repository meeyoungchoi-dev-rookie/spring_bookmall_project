<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<div class="jumbotron">
	<h1>관리자 메인카테고리 추가</h1>
</div>


<form method="post" action="${path}/manager/maincate" class="container">
	<div class=form-group row">
		<label class="col-sm-2 col-form-label">메인카테</label>
		<input type="text" name="mainCateName" placeholder="메인카테고리 이름을 입력하세요" class="form-control col-sm-10">
	</div>
	<button type="submit" class="btn btn-success">저장</button>
</form>





</body>
</html>