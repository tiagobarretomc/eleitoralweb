package br.com.eleitoralweb.manager.commons;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.interfaces.BaseDAO;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.exceptions.DAOException;

public abstract class BaseManager<T, E extends BaseDAO<T>> {
	@Inject
	private E dao;
	public String remove(T entity) throws BusinessException{
		try {
			getDao().removeEntity(entity);
			return "Registro removido com sucesso";
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	public String merge(T entity) throws BusinessException{
		try {
			getDao().updateEntity(entity);
			return "Registro alterado com sucesso";
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	
	public String persist(T entity) throws BusinessException{
		try {
			getDao().addEntity(entity);
			return "Registro salvo com sucesso";
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	
	public T findById(Serializable id) throws BusinessException{
		try {
			return getDao().findById(id);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	
	public List<T> findByFilter(T filter) throws BusinessException{
		try {
			return getDao().findByFilter(filter);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	
	public List<T> findAll() throws BusinessException{
		try {
			return getDao().findAll();
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());		
		}
		
	}
	public E getDao() {
		return dao;
	}
}
