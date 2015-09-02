package br.com.eleitoralweb.dao.commons;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.eleitoralweb.bean.Combo;
import br.com.eleitoralweb.dao.interfaces.ComboDAO;
import br.com.eleitoralweb.exceptions.DAOException;

public  class ComboDaoImpl implements ComboDAO{

	protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");	
	
	public EntityManager createEntityManager() {
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	

	@SuppressWarnings("unchecked")
	public List<Combo<?>> retrieveCombo(Class<?> clazz,String fieldValue,String fieldLabel) throws DAOException{
		EntityManager manager = factory.createEntityManager(); 
		try {
			StringBuilder sbquery = new StringBuilder("select new ").append(Combo.class.getName())
					.append("(").append(fieldValue).append(",")
					.append(fieldLabel).append(")")
					.append("from ").append(clazz.getSimpleName());
			return manager.createQuery(sbquery.toString()).getResultList();
		} catch (Exception e) {
		    throw new DAOException(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

}