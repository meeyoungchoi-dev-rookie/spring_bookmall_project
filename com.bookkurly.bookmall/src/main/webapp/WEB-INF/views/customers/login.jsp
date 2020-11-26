
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

<jsp:include page="../layouts/header.jsp" />



<div class="jumbotron">
	<h1 class="display-4">BookKurly 로그인</h1>
	<p class="lead">로그인 하시고 더 다양한 서비스를 경험하세요</p>
</div>


<c:if test="${loginFail  == '로그인 실패'}">
	<p class="container" style="color:red">로그인 정보를 확인해주세요</p>
</c:if>


	<form method="post" action="${path}/customer/logincheck" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">아이디</label>
        <input type="text" name="customId" placeholder="아이디를 입력하세요" class="form-control col-sm-10">
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">비밀번호</label>
        <input type="text" name="customPw" placeholder="비밀번호를 입력하세요" class="form-control col-sm-10">
    </div>
    <button type="submit" class="btn btn-primary">로그인</button>
</form>












<jsp:include page="../layouts/footer.jsp" />