package br.com.eleitoralweb.dao.commons;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.eleitoralweb.util.EntityUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.engine.spi.TypedValue;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.weld.bean.proxy.ProxyObject;

import br.com.eleitoralweb.dao.interfaces.BaseDAO;
import br.com.eleitoralweb.exceptions.DAOException;

public class BaseDAOJPA<T> implements BaseDAO<T> {

	private Class<T> classEntity;
	protected static final EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("default");
	/**
	 * Construtor
	 * 
	 * @param Entity
	 * @param classEntity
	 */
	@SuppressWarnings("unchecked")
	public BaseDAOJPA() {
		Class<?> clazz = null;
		if(this instanceof ProxyObject){
			clazz = getClass().getSuperclass();
		}else{
			clazz = getClass();
		}
			this.classEntity = (Class<T>) ((ParameterizedType) clazz
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager createEntityManager() {
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public void startTransaction(EntityManager manager) {
		manager.getTransaction().begin();
	}

	public void commitTransaction(EntityManager manager) {
		manager.getTransaction().commit();
	}

	public void rollbackTransaction(EntityManager manager) {
		manager.getTransaction().rollback();
	}

	public void closeConnection(EntityManager manager) {
		if (manager != null && manager.isOpen()) {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			String query = "from " + classEntity.getSimpleName();
			return manager.createQuery(query).getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bancohibernate.dao.commons.CrudDAO#findById(java.io.Serializable)
	 */
	public T findById(Serializable id) throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			return manager.find(classEntity, id);
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bancohibernate.dao.commons.CrudDAO#addEntity(java.lang.Object)
	 */
	public void addEntity(T entity) throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			startTransaction(manager);
			manager.persist(entity);
			commitTransaction(manager);
			;
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			closeConnection(manager);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bancohibernate.dao.commons.CrudDAO#updateEntity(java.lang.Object)
	 */
	public void updateEntity(T entity) throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			throw new DAOException(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bancohibernate.dao.commons.CrudDAO#removeEntity(java.lang.Object)
	 */
	public void removeEntity(T entity) throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			startTransaction(manager);
			entity = manager.merge(entity);
			manager.remove(entity);
			commitTransaction(manager);
		} catch (Exception e) {
			if (isConstraintException(e)) {
				throw new DAOException(
						"O registro não pode ser excluído pois está sendo utilizado no sistema.");
			}
			throw new DAOException(e);
		} finally {
			closeConnection(manager);
		}
	}

	private boolean isConstraintException(Throwable e) {
		if (e == null)
			return false;
		if (e.getCause() instanceof ConstraintViolationException) {
			return true;
		} else {
			return isConstraintException(e.getCause());
		}
	}

	public void removeEntity(T entity, EntityManager manager)
			throws DAOException {
		entity = manager.merge(entity);
		manager.remove(entity);
	}

	public void addEntity(T entity, EntityManager manager) throws DAOException {
		manager.persist(entity);
	}

	public void updateEntity(T entity, EntityManager manager)
			throws DAOException {
		manager.merge(entity);
	}

	/**
	 * Busca o objeto de acordo com o objeto preenchido com os valores passado
	 * como exemplo.
	 *
	 * @param objeto
	 *            utilizado para realizar a busca
	 * @param ordenacoes
	 *            lista de crit?rios de ordena??o
	 * @return Lista de objetos retornada
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByFilter(final T entity, Order... ordenacoes)
			throws DAOException {
		EntityManager manager = factory.createEntityManager();
		try {
			Session session = (Session) manager.getDelegate();
			Criteria crit = session.createCriteria(classEntity);
			Map<String, Object> params = EntityUtil.loadParams(entity);
			List<T> result = null;
			for (String param : params.keySet()) {

			}
			for (int i = 0; i < ordenacoes.length; i++) {
				crit.addOrder(ordenacoes[i]);
			}

			result = crit.list();

			return result;
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public List<T> findByCriteria(final Criterion... criterion) {
		return findByCriteria(-1, -1, criterion);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public T findSingleByCriteria(final Criterion... criterion) {
		List<T> t = findByCriteria(-1, 1, criterion);
		if (!t.isEmpty()) {
			return t.get(0);
		}
		return null;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final int firstResult, final int maxResults,
			final Criterion... criterion) {
		EntityManager manager = factory.createEntityManager();
		Session session = (Session) manager.getDelegate();
		Criteria crit = session.createCriteria(classEntity);

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		if (firstResult > 0) {
			crit.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			crit.setMaxResults(maxResults);
		}

		final List<T> result = crit.list();
		return result;
	}

	protected Criteria createCriteria() {
		EntityManager manager = factory.createEntityManager();

		Session session = (Session) manager.getDelegate();

		return session.createCriteria(classEntity);

	}

	protected int countByCriteria(Criterion... criterion) {
		Session session = (Session) factory.createEntityManager().getDelegate();
		Criteria crit = session.createCriteria(classEntity);
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		return (Integer) crit.list().get(0);
	}
}
