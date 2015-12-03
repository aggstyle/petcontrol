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

import br.com.tavares.petcontrol.dao.EstadoDAO;
import br.com.tavares.petcontrol.modal.Estado;

@Path("/estado")
public class EstadoService {

	@Inject
	EstadoDAO estadoDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> buscaTodos() {
		return estadoDAO.listAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estado lookupWeatherByData(@PathParam("id") int id) {
		return estadoDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Estado addOrUpdateestado(Estado estado) {
		return estadoDAO.update(estado);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Estado removerestado(Estado estado) {
		estadoDAO.remover(estado);
		return estadoDAO.findById(estado.getId());
	}
}
