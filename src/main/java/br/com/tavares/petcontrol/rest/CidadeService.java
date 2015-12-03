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
import br.com.tavares.petcontrol.dao.CidadeDAO;
import br.com.tavares.petcontrol.modal.Cidade;

@Path("/cidade")
public class CidadeService {

	@Inject
	CidadeDAO cidadeDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidade> buscaTodos() {
		return cidadeDAO.listAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade lookupWeatherByData(@PathParam("id") int id) {
		return cidadeDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade addOrUpdateCidade(Cidade cidade) {
		return cidadeDAO.update(cidade);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Cidade removerCidade(Cidade cidade) {
		cidadeDAO.remover(cidade);
		return cidadeDAO.findById(cidade.getId());
	}
}
