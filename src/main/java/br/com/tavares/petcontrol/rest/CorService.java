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

import br.com.tavares.petcontrol.dao.CorDAO;
import br.com.tavares.petcontrol.modal.Cor;

@Path("/cor")
public class CorService {

	@Inject
	CorDAO corDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {
		List<Cor> list = corDAO.listAll();
		String result = new Gson().toJson(list);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cor lookupWeatherByData(@PathParam("id") int id) {
		return corDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdateCor(Cor cor) {
		cor = corDAO.update(cor);
		String result = new Gson().toJson(cor);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Cor removerCor(Cor cor) {
		corDAO.remover(cor);
		return corDAO.findById(cor.getId());
	}
}
