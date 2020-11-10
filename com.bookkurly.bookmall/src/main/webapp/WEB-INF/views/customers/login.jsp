
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


<div class="jumbotron">
	<h1>고객 로그인 페이지</h1>
</div>



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