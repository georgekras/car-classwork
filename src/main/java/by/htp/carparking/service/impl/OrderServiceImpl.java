package by.htp.carparking.service.impl;

import java.sql.Date;

import by.htp.carparking.dao.OrderDao;
import by.htp.carparking.dao.impl.OrderDaoDBImpl;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	
	@Override
	public void orderCar(int user_id, int car_id, Date date, Date date2) {
		orderDao.insertNewOrder(user_id, car_id, date, date2);
	}

//	@Override
//	public void orderCar(int user_id, int car_id) {
//
//		orderDao.insertNewOrder(user_id, car_id);
//		
//	}

	public OrderServiceImpl() {
		
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	

}
