package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;

public class CarListViewAction implements BaseAction{
	
	//TODO change to IoC, singletone
	private CarService carService;

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		
		List<Car> cars = carService.getCarsList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);
		
		return PAGE_USER_MAIN;
	}

}
