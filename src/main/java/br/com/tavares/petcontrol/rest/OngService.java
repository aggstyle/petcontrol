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

import br.com.tavares.petcontrol.dao.ONGDAO;
import br.com.tavares.petcontrol.modal.ONG;

@Path("/ong")
public class OngService {

	@Inject
	ONGDAO ongDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ONG> buscaTodos() {
		return ongDAO.listAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public ONG lookupWeatherByData(@PathParam("id") int id) {
		return ongDAO.findById(id);
	}
	
	@GET
	@Path("/filtro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, String>>  filtraOng() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for (ONG ong : ongDAO.listAll()) {
			Map<String,String> ongMap = new HashMap<String,String>();
			ongMap.put("id",ong.getNome());
			ongMap.put("title",ong.getNome());
			list.add(ongMap);
		}
		return  list;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdateOng(ONG ong) {
		ong =  ongDAO.update(ong);
		String result = new Gson().toJson(ong);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public ONG removerOng(ONG ong) {
		ongDAO.remover(ong);
		return ongDAO.findById(ong.getId());
	}

}
