<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>

<h2 align="center">Car order</h2>
<br>
<br>
<br>
<form class="order-car"
	action="MainServlet?car_id=${ordered_car.id}&user_id=1&action=order_car"
	method=POST>
	<div class="row">
		<div class=col-md-2>Brand</div>
		<div class=col-md-2>Model</div>
		<div class=col-md-5>Period</div>
	</div>
	<br>
	<div class="row">
		<div class=col-md-2>${ordered_car.brand}</div>
		<div class=col-md-2>${ordered_car.model}</div>
		<div class=col-md-2>
			<p>Start:</p>
			<p>
				<input type="date" name="start">
			</p>
		</div>
		<div class=col-md-2>
			<p>End:</p>
			<p>
				<input type="date" name="end">
			</p>
		</div>
		<div class=col-md-1>
			<button type="submit" class="btn btn-success btn">Order</button>
		</div>
	</div>
			<c:out value="${msg_order_car_success}" />
</form>
<%@ include file="/include/end-html.jsp"%>
