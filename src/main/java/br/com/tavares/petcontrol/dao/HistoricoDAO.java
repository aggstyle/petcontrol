package br.com.tavares.petcontrol.dao;

import javax.enterprise.context.ApplicationScoped;

import br.com.tavares.petcontrol.modal.Historico;

@ApplicationScoped
public class HistoricoDAO extends GenericDAO<Historico>{
	public HistoricoDAO(){
		super(Historico.class);
	}
}
