package com.test.dropwizard.core;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CarAppearance implements Serializable {
	
	private static final long serialVersionUID = -5518754465087748141L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(mappedBy = "appearance")
	private Car car;
	
	private String color;
	
	private String painting;
	
	@Enumerated
	private CarAppearanceHealth health;
	
	public CarAppearance() {}
	
	public CarAppearance(Car car, String color, String painting, CarAppearanceHealth health) {
		this.car = car;
		this.color = color;
		this.painting = painting;
		this.health = health;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPainting() {
		return painting;
	}

	public void setPainting(String painting) {
		this.painting = painting;
	}

	public CarAppearanceHealth getHealth() {
		return health;
	}

	public void setHealth(CarAppearanceHealth health) {
		this.health = health;
	}
	
}
