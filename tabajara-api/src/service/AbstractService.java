package service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import dto.AbstractDTO;
import model.AbstractModel;

public abstract class AbstractService<T> {
	
	@Inject
	private EntityManager em;

	public abstract Class<T> myClass();
	
	public abstract AbstractDTO<T> get(Integer id);
	
	public abstract List<T> getList();
	
	public abstract String validator(T t);
	
	
	@Transactional
	public T create(T model){
		
		em.persist(model);
		return model;
	}
	
	@Transactional
	public AbstractModel<T> edit(AbstractModel<T> model){
		em.merge(model);
		return model;
	}
	
	@Transactional
	public Boolean delete(Integer id){
		em.remove(em.getReference(myClass(), id));
		return true;
	}

}