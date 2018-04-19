package by.htp.carparking.service;

import java.sql.Date;

public interface OrderService {

	void orderCar(int user_id, int car_id, Date date, Date date2);
}
