package br.com.tavares.petcontrol.rest;

import java.util.List;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.tavares.petcontrol.dao.AnimalDAO;
import br.com.tavares.petcontrol.modal.Animal;

@Path("/animal")
public class AnimalService {

	@Inject
	AnimalDAO animalDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {
		List<Animal> list = animalDAO.listAll();
		String result = new Gson().toJson(list);
		return Response.ok(list).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@GET
	@Path("/adocao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaAdocaoTodos() {
		List<Animal> list = animalDAO.buscaNaoAdotados();
		//String result = new Gson().toJson(list);
		return Response.ok(list).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Animal lookupAnimalById(@PathParam("id") int id) {
		return animalDAO.findById(id);
	}

	@GET
	@Path("/RFID/{rfid:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Animal lookupAnimalByRFID(@PathParam("rfid") int id) {
		return animalDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdateAnimal(Animal animal) {
		if (animal.getId() == null) {
			animal = animalDAO.salvar(animal);
		} else {
			animal = animalDAO.update(animal);
		}
		String result = new Gson().toJson(animal);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removerAnimal(Animal animal) {
		animalDAO.remover(animal);
		animal = animalDAO.findById(animal.getId());
		String result = new Gson().toJson(animal);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}
}
