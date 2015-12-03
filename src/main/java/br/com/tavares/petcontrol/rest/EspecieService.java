package br.com.tavares.petcontrol.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import br.com.tavares.petcontrol.dao.EspecieDAO;
import br.com.tavares.petcontrol.modal.Especie;

@Path("/especie")
public class EspecieService {

	@Inject
	EspecieDAO especieDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {

		List<Especie> list = especieDAO.listAll();
		String result = new Gson().toJson(list);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Especie lookupWeatherByData(@PathParam("id") int id) {
		return especieDAO.findById(id);
	}

	@GET
	@Path("/filtro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, String>> filtraOng() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Especie especie : especieDAO.listAll()) {
			Map<String, String> especieMap = new HashMap<String, String>();
			especieMap.put("id", especie.getDescricao());
			especieMap.put("title", especie.getDescricao());
			list.add(especieMap);
		}
		return list;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdateespecie(Especie especie) {
		try {
			especie = especieDAO.update(especie);
			String result = new Gson().toJson(especie);
			return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			throw e;
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Especie removerespecie(Especie especie) {
		especieDAO.remover(especie);
		return especieDAO.findById(especie.getId());
	}
}
