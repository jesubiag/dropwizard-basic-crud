package com.test.dropwizard.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.test.dropwizard.core.Car;

import io.dropwizard.hibernate.AbstractDAO;

public class CarDAO extends AbstractDAO<Car> {
	
	public CarDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Car findById(Long id) {
		return get(id);
	}
	
	public Car create(Car car) {
		return persist(car);
	}
	
	public List<Car> findAll() {
		return list(criteria());
	}
	
	public void delete(Long id) {
		Car car = findById(id);
		currentSession().delete(car);
	}

}
