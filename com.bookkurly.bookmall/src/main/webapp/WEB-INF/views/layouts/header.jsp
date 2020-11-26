<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>

	<%
		String customId = (String) session.getAttribute("loginSession");
	%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light ">
		<a class="navbar-brand" href="${path}/shopping">BookKurly</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 카테고리 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<c:forEach var="maincategory" items="${mainCategories}"
							varStatus="status">
							<c:choose>
								<c:when test="${maincategory.mainCateSeq == 1}">
									<a class="dropdown-item"
										href="${path}/subacategory/backend/${maincategory.mainCateSeq}">${maincategory.mainCateName}</a>
								</c:when>
								<c:when test="${maincategory.mainCateSeq == 2}">
									<a class="dropdown-item"
										href="${path}/subacategory/frontend/${maincategory.mainCateSeq}">${maincategory.mainCateName}</a>

								</c:when>

							</c:choose>
						</c:forEach>
					</div></li>
				
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<c:if test="${customId != null}">
					<h1 class="text-success">${customId}님로그인중</h1>
					<a class="btn btn-outline-info my-2 my-sm-0 ml-2"
						href="${path}/customer/logout" type="submit">로그아웃</a>
					<a class="btn btn-outline-success my-2 my-sm-0 ml-2"
						href="${path}/customer/mypage">마이페이지</a>
				</c:if>
				<c:if test="${customId == null}">
					<a class="btn btn-outline-info my-2 my-sm-0 ml-2"
						href="${path}/customer/login" type="submit">로그인</a>
					<a class="btn btn-outline-primary my-2 my-sm-0 ml-2"
						href="${path}/customer/register" type="submit">회원가입</a>
				</c:if>

			</form>
		</div>
	</nav>