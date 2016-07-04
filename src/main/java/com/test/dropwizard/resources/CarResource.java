package com.test.dropwizard.resources;

import static com.test.dropwizard.resources.ResourcesConstants.PATH_CAR;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@UnitOfWork
	public Response save(
			@FormParam(Car.PROPERTY_NAME) String name,
			@FormParam(Car.PROPERTY_KILOMETERS) Float kilometers,
			@FormParam(Car.PROPERTY_APPEARANCE_COLOR) String appearanceColor,
			@FormParam(Car.PROPERTY_APPEARANCE_PAINTING) String appearancePainting
			) throws URISyntaxException {
		Car newCar = new Car(name, kilometers, appearanceColor, appearancePainting);
		newCar = carDAO.create(newCar);
		URI location = UriBuilder.fromUri("/cars").build();
		return Response.seeOther(location).build();
	}
	
	@DELETE
	@Path("/{id}")
	@UnitOfWork
	public Response delete(@PathParam(Car.PROPERTY_ID) Long id) {
		carDAO.delete(id);
		URI location = UriBuilder.fromUri("/cars").build();
		return Response.seeOther(location).build();
	}

}
