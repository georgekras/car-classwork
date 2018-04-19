package by.htp.carparking.service;

import java.util.List;

import by.htp.carparking.domain.Car;

public interface CarService {
	
	Car read(int id);
	List<Car> getCarsList();

}
