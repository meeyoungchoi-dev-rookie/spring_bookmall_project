<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/manager_header.jsp" />

<div class="jumbotron">
	<h1>${customerId}님결제및배송정보</h1>
</div>

<div class="container">
	<h1>주문번호: ${orderSerialNum}</h1>
</div>

<table class="table text-center table-hover container">
	<thead>
		<tr>
			<th>결제일</th>
			<th>제품</th>
			<th>주문수량</th>
			<th>금액</th>
			<th>결제상태</th>
			<th>결제취소상태</th>
			<th>배송상태</th>
			<th>환불상태</th>
			<th>배송관리</th>
		</tr>

	</thead>
	<tbody>
		<c:forEach var="sts" items="${jangs}">



			<tr>
				<td>${sts.orderDate}</td>
				<td>${sts.bookTitle}</td>
				<td>${sts.bookOrderCnt}</td>
				<td>${sts.bookOrderCntPrice}</td>
				<td>${sts.orderPaymentStatus}</td>
				<td><c:if test="${sts.allOrderDeleteStatus == true}">
						결제취소
					</c:if> <c:if test="${sts.allOrderDeleteStatus == false}">
						결제완료
					</c:if></td>
				<td><c:if test="${sts.allOrderDeleteStatus == false}">
						<c:if test="${sts.orderDeliveryStatus == false}">
							배송중
					</c:if>
						<c:if test="${sts.orderDeliveryStatus == true}">
						배송완료
					</c:if>
					</c:if>
					<c:if test="${sts.allOrderDeleteStatus == true || sts.productRefundstatus == true}">
						반품됨
					</c:if>
					
				</td>
				<td><c:if test="${sts.productRefundstatus == true}">
					환불됨
				</c:if></td>
				
				
				<td>
				<c:if test="${sts.allOrderDeleteStatus == false || sts.productRefundstatus == false}">
					<form method="post"
						action="${path}/manager/update/orderDeliverStatus">
						<button type="submit" class="btn btn-info">
							배송완료</button> <input type="hidden" name="orderSerialNum"
								value="${orderSerialNum}"> <input type="hidden"
								name="orderDeliveryStatus" value="${sts.orderDeliveryStatus}">
							<input type="hidden" name="bookSeq" value="${sts.bookSeq}">
					</form>
				</c:if>
				<c:if test="${sts.allOrderDeleteStatus == true  || sts.productRefundstatus == true}">
					배송불가
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>