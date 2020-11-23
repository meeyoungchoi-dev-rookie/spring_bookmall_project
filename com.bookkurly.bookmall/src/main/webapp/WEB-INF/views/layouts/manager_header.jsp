<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${path}/manager/maincategories">BookKurlyManager</a>
		

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="${path}/manager/maincategories" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 카테고리관리 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="${path}/manager/maincategories">메인카테고리</a> 
					</div></li>
				<li class="nav-item"><a class="nav-link" href="${path}/manager/orders"
					tabindex="-1" aria-disabled="true">주문관리</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<c:if test="${adminlogin != null}">
					<h1 class="text-success">${adminlogin}님로그인중</h1>
					<a class="btn btn-outline-info my-2 my-sm-0 ml-2"
						href="${path}/admin/logout" type="submit">로그아웃</a>
				</c:if>
				<c:if test="${adminlogin == null } ">
					<a class="btn btn-outline-info my-2 my-sm-0 ml-2"
						href="${path}/admin/login" type="submit">로그인</a>

				</c:if>
			</form>
		</div>
	</nav>