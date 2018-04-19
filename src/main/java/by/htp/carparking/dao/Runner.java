package by.htp.carparking.dao;

import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;

public class Runner {

	public static void main(String[] args) {
		new CarServiceImpl();
		new OrderServiceImpl();
		System.out.println(DAO.getDAO().carDAO.read(1));
	}
}
