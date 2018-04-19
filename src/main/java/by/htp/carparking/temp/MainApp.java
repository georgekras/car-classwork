package by.htp.carparking.temp;

import by.htp.carparking.dao.BaseDao;
import by.htp.carparking.dao.impl.CarDaoDBImpl;
import by.htp.carparking.domain.Car;

public class MainApp {

	public static void main(String[] args) {
	
		
		BaseDao dao = new CarDaoDBImpl();
		
		dao.create(new Car());

	}

}
