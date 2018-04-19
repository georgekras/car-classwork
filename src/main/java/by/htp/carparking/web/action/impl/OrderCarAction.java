package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.sql.Date;

import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.web.action.BaseAction;

public class OrderCarAction implements BaseAction {

	private OrderService orderService;

	public OrderCarAction() {
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {

		String car_id = request.getParameter(REQUEST_PARAM_CAR_ID);
		String user_id = request.getParameter(REQUEST_PARAM_USER_ID);
		validateRequestParamNotNull(car_id, user_id);
		Car orderCar = DAO.getDAO().carDAO.read(formatString(car_id));
		if (orderCar != null) {
			request.setAttribute(REQUEST_PARAM_ORDERED_CAR, orderCar);
			String dateStart = request.getParameter("start");
			String dateEnd = request.getParameter("end");
			if (dateStart != null && dateEnd != null) {
				orderService.orderCar(formatString(user_id), formatString(car_id),
						Date.valueOf(request.getParameter("start")), Date.valueOf(request.getParameter("end")));
				StringBuilder orderedCarMessage = new StringBuilder();
				orderedCarMessage.append(orderCar.getBrand()).append(" ").append(orderCar.getModel())
						.append(" was ordered succesfully");
				request.setAttribute(REQUEST_PARAM_MSG_ORDER_CAR_SUCCESS, orderedCarMessage);
			}
		}
		return PAGE_USER_CAR_ORDER;
	}
}