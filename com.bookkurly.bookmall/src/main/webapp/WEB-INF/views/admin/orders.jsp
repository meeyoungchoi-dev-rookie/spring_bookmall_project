<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />
<div class="jumbotron">
	<h1>관리자 결제 및 배송관리</h1>
</div>


<table class="table container text-center table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>주문번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="str" items="${orderNumbers}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="${path}/manager/orders/${str.orderSerialNum}">${str.orderSerialNum}</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="../layouts/footer.jsp" />