package com.test.dropwizard.core;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Car implements Serializable {
	
	private static final long serialVersionUID = -4805124311615672037L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Float kilometers;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private CarAppearance appearance;
	
	public Car() {}
	
	public Car(String name, Float kilometers, CarAppearance appearance) {
		this.name = name;
		this.kilometers = kilometers;
		this.appearance = appearance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getKilometers() {
		return kilometers;
	}

	public void setKilometers(Float kilometers) {
		this.kilometers = kilometers;
	}

	public CarAppearance getAppearance() {
		return appearance;
	}

	public void setAppearance(CarAppearance appearance) {
		this.appearance = appearance;
	}

}
