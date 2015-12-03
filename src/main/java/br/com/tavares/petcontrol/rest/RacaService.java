package br.com.tavares.petcontrol.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.tavares.petcontrol.dao.RacaDAO;
import br.com.tavares.petcontrol.modal.Raca;

@Path("/raca")
public class RacaService {

	@Inject
	RacaDAO racaDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {
		System.out.println("buscaTodos raca");
		List<Raca> list = racaDAO.listAll();
		String result = new Gson().toJson(list);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Raca lookupWeatherByData(@PathParam("id") int id) {
		return racaDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdateraca(Raca raca) {
		raca = racaDAO.update(raca);
		String result = new Gson().toJson(raca);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Raca removerraca(Raca raca) {
		racaDAO.remover(raca);
		return racaDAO.findById(raca.getId());
	}
}
