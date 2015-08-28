package br.com.eleitoralweb.controller.commons;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.eleitoralweb.dao.interfaces.BaseDAO;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.manager.commons.BaseManager;
import br.com.eleitoralweb.util.EntityUtil;

import javax.inject.Inject;
import java.util.List;


public abstract class BaseController<E, D extends BaseDAO<E>, T extends BaseManager<E, D>> {
	@Inject
	protected  Result result;
	@Inject
	protected  T manager;
	@Inject
	protected Validator validator;
	
	private void addMessageResult(String message){
		result.include("message", message);
	}
	private void addBeanResult(E bean){
		result.include("bean",bean);
	}
	
	private void addFilterResult(E filter, List<E> list){
		result.include("beanList",list);
		result.include("filter",filter);
	}
		
		
	@Path("/remove/{id}")
	public void remove(Long id) throws BusinessException{
		String msg = null;
		E bean = manager.findById(id);
		if (bean != null){
			msg = manager.remove(bean);
			addMessageResult(msg);
		}
		result.forwardTo(this.getClass()).lista();
	  }

	public void form(E bean){
		initForm(bean);
		addBeanResult(bean);
	}
	
	@Path({"/{id}","/form","/novo"})
	public E form(Long id) throws BusinessException{
		E bean = null;
		if (id != null){
			bean = manager.findById(id);
		}else{
			bean = createInstance();
		}
		
		initForm(bean);
		addBeanResult(bean);
		
		return bean;
	}
	@SuppressWarnings("unchecked")
	@Post
	public void add(E bean) throws BusinessException{
		prePersistUpdate(bean);
	 	validateForm(bean);
		Long id = (Long)EntityUtil.getId(bean.getClass(), bean);
		String msg = null;
		if (id != null && id > 0){
			msg = manager.merge(bean);
		}else{
			msg = manager.persist(bean);
		}
		postPersistUpdate(bean, result);
		addMessageResult(msg);
		result.forwardTo(this.getClass()).lista();
	  }
	
	
	@Path({"/lista","/lista/"})
	public List<E> lista() throws BusinessException {
		List<E> lista = null;
		lista = manager.findAll();
		E filter = createInstance();
		initFilter(filter);
		addFilterResult(filter, lista);
		return lista;
	}
	@Path({"/filtrar"})
	public List<E> filtrar(E filter) throws BusinessException{
		List<E> lista = null;
		lista = manager.findByFilter(filter);
		initFilter(filter);
		addFilterResult(filter, lista);
		return lista;
		
	}
	protected void validateForm(E bean){
		validator.validate(bean);
		validator.onErrorUsePageOf(this.getClass()).form(bean);
	}
	
	protected  E createInstance(Class<E> type) throws InstantiationException, IllegalAccessException{
		E tipoBase = type.newInstance();
		return tipoBase;
	}
	protected void initFilter(E filter){}
	protected abstract E createInstance();
	protected abstract void initForm(E bean);
	protected abstract void prePersistUpdate(E bean);
	protected abstract void postPersistUpdate(E bean, Result result);
}
