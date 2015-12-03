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

import br.com.tavares.petcontrol.dao.PessoaDAO;
import br.com.tavares.petcontrol.modal.Pessoa;

@Path("/pessoa")
public class PessoaService {

	@Inject
	PessoaDAO pessoaDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {
		List<Pessoa> list = pessoaDAO.listAll();
		String result = new Gson().toJson(list);
		return Response.ok(list).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupWeatherByData(@PathParam("id") int id) {
		Pessoa pessoa = pessoaDAO.findById(id);
		String result = new Gson().toJson(pessoa);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrUpdatepessoa(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			pessoa = pessoaDAO.salvar(pessoa);
		} else {
			pessoa = pessoaDAO.update(pessoa);
		}
		String result = new Gson().toJson(pessoa);
		return Response.ok(result).header("Access-Control-Allow-Origin", "*").build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Pessoa removerpessoa(Pessoa pessoa) {
		pessoaDAO.remover(pessoa);
		return pessoaDAO.findById(pessoa.getId());
	}
}
