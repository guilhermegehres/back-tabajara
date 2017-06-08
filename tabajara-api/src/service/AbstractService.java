package service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


public abstract class AbstractService<T> {

	@Inject
	private EntityManager em;

	public abstract Class<T> myClass();

	@Transactional
	public T create(T model){
		em.persist(model);
		return model;
	}
	
	@Transactional
	public T editApartamento(T model){
		em.merge(model);
		return model;
	}
	
	@Transactional
	public Boolean deleteApartamento(Integer id){
		em.remove(em.getReference(myClass(), id));
		return true;
	}

}