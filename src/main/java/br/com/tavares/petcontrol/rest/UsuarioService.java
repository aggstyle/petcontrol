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

import br.com.tavares.petcontrol.dao.UsuarioDAO;
import br.com.tavares.petcontrol.modal.Usuario;

@Path("/usuario")
public class UsuarioService {

	@Inject
	UsuarioDAO usuarioDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> buscaTodos() {
		return usuarioDAO.listAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario lookupWeatherByData(@PathParam("id") int id) {
		return usuarioDAO.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario addOrUpdateusuario(Usuario usuario) {
		return usuarioDAO.update(usuario);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario removerusuario(Usuario usuario) {
		usuarioDAO.remover(usuario);
		return usuarioDAO.findById(usuario.getId());
	}
}
