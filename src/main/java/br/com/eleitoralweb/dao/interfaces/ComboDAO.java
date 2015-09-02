package br.com.eleitoralweb.dao.interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.eleitoralweb.bean.Combo;
import br.com.eleitoralweb.exceptions.DAOException;

public interface ComboDAO {
	
	public EntityManager createEntityManager();
	
	public List<Combo<?>> retrieveCombo(Class<?> clazz, String fieldValue, String fieldLabel) throws DAOException;

}