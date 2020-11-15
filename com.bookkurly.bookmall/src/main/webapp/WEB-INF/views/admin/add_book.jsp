<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<%
	String mainCateName = (String)request.getAttribute("mainCateName");
	String subCateName = (String)request.getAttribute("subCateName");
	Integer subCateSeq = (Integer)request.getAttribute("subCateSeq");


%>
<script src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
<div class="jumbotron">
	<h1>관리자 도서추가</h1>
</div>

<div class="container">
	<p>메인카테고리:${mainCateName} >> 서브카테고리: ${subCateName} </p>
</div>




<form class="container" method="post" action="${path}/manager/add/book" enctype="multipart/form-data">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">제목</label> <input type="text"
			name="bookTitle" placeholder="도서제목을 입력하세요"
			class="form-control col-sm-10">
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">한줄소개</label> <input type="text"
			name="bookIntro" placeholder="한줄소개를 입력하세요"
			class="form-control col-sm-10">
	</div>

	<div class="form-group row">

		<label class="col-sm-2">목차</label>
	</div>
	<textarea rows="10" cols="50" id="editor" name="bookContents"
		class="ckeditor"></textarea>

	<script>
		var ckeditor_config = {

			resize_enable : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P
		};

		CKEDITOR.replace("editor", ckeditor_config);
	</script>


	<div class="form-group row">
		<label class="col-sm-2 col-form-label">가격</label>
		<input type="text" name="bookPrice" class="form-control col-sm-10" placeholder="도서 가격을 입력하세요">
	</div>
	
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">재고수량</label>
		<input type="text" name="bookAmount" class="form-control col-sm-10" placeholder="재고 수량을 입력하세요">
	</div>
	
	<input type="hidden" name="subCateSeq" value="${subCateSeq}">
	
	<input type="file" name="file" placeholder="첨부할 이미지 파일을 선택하세요">

	<input type="hidden" name="bookStatus" value="true">

	<input type="hidden" name="subCateName" value="${subCateName}">

	<div class="form-group row">
		<label>도서설명</label>
		<textarea rows="10" cols="5" name="bookDescription" placeholder="도서설명을 입력하세요" class="form-control"></textarea>
	</div>

	<button type="submit" class="btn btn-primary">저장</button>

</form>







<jsp:include page="../layouts/footer.jsp" />