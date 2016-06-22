package com.test.dropwizard.views;

import java.util.List;

import com.test.dropwizard.core.Car;

import io.dropwizard.views.View;

public class CarView extends View {
	
	public static final String TEMPLATE_NAME_CAR_VIEW = "car/CarView.ftl";
	public static final String TEMPLATE_NAME_CARS_VIEW = "car/CarsView.ftl";
	public static final String TEMPLATE_NAME_CAR_CREATE = "car/CreateCarView.ftl";
	
	private Car car;
	
	private List<Car> cars;
	
	public CarView(String templateName) {
		super(templateName);
	}

	public CarView(Car car) {
		super(TEMPLATE_NAME_CAR_VIEW);
		this.car = car;
	}
	
	public CarView(List<Car> cars) {
		super(TEMPLATE_NAME_CARS_VIEW);
		this.cars = cars;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
