package com.test.dropwizard.db;

import org.hibernate.SessionFactory;

import com.test.dropwizard.core.CarAppearance;

import io.dropwizard.hibernate.AbstractDAO;

public class CarAppearanceDAO extends AbstractDAO<CarAppearance> {

	public CarAppearanceDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
