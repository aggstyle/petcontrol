package br.com.tavares.petcontrol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@Transactional
public class GenericDAO<T> {

	@PersistenceContext(unitName = "petcontrol", type = PersistenceContextType.EXTENDED)
	protected EntityManager em;

	protected Class<T> classe;

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> classe) {
		this();
		this.classe = classe;
	}

	public T salvar(T obj) {
		em.persist(obj);
		return obj;
	}
	
	public T update(T obj) {
		return em.merge(obj);
	}

	public void remover(T obj) {
		em.remove(obj);
	}

	public T findById(int id) {
		return em.find(classe, id);
	}

	public int getRowCount() {
		Query query = em.createQuery("SELECT count(a) from " + classe.getSimpleName() + " a");
		return Integer.parseInt(query.getSingleResult().toString());
	}

	public List<T> listAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(classe);
		query.from(classe);
		return em.createQuery(query).getResultList();
	}

}
