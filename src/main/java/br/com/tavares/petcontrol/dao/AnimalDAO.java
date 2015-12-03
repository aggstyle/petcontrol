package br.com.tavares.petcontrol.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.tavares.petcontrol.enums.EStatusAnimal;
import br.com.tavares.petcontrol.modal.Animal;

public class AnimalDAO extends GenericDAO<Animal> {
	public AnimalDAO() {
		super(Animal.class);
	}
	
	public Animal buscaPorRFID(String RFID){
		return (Animal) this.em.createNamedQuery("Animal.findbyrfid").setParameter("rfid", RFID.trim())
        .getSingleResult();
	}
	public List<Animal> buscaNaoAdotados(){
		return listAll().stream().filter(c -> c.getStatus() == EStatusAnimal.N_ADOTADO).collect(Collectors.toList());
	}
}
