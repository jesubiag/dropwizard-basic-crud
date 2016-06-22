package com.test.dropwizard.resources;

import static com.test.dropwizard.resources.ResourcesConstants.PATH_CAR;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dropwizard.core.Car;
import com.test.dropwizard.db.CarDAO;
import com.test.dropwizard.views.CarView;

import io.dropwizard.hibernate.UnitOfWork;

@Path(PATH_CAR)
public class CarResource {
	
	private CarDAO carDAO;
	
	public CarResource(CarDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	@GET
	@UnitOfWork
	@Produces(MediaType.TEXT_HTML)
	public CarView getCars() {
		return new CarView(carDAO.findAll());
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@Path("/{id}")
	public CarView getCar(@PathParam("id") Long id) {
		return new CarView(carDAO.findById(id));
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@UnitOfWork
	@Path("/new")
	public CarView create() {
		return new CarView(CarView.TEMPLATE_NAME_CAR_CREATE);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@UnitOfWork
	public CarView save(Form carForm) {
		MultivaluedMap<String, String> carFormMap = carForm.asMap();
		carFormMap.forEach( (k,v) -> {
			System.out.println("**** key: " + k);
			System.out.println("**** value: " + v);
		});
		ObjectMapper mapper = new ObjectMapper();
		Car car = mapper.convertValue(carFormMap, Car.class);
		carDAO.create(car);
		return getCars();
	}

}
