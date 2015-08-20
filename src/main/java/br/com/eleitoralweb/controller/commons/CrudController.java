package br.com.eleitoralweb.controller.commons;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.eleitoralweb.dao.commons.CrudDAO;
import br.com.eleitoralweb.dao.commons.DAOException;
import br.com.eleitoralweb.util.EntityUtil;

@Resource
public abstract class CrudController<E, T extends CrudDAO<E>> {
	protected  Result result;
	protected  T dao;
	protected Validator validator;
	
	
	@Autowired
	public void setResult(Result result) {
		this.result = result;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired 
	public void setDao(T dao) {
		this.dao = dao;
	}
	
	@Path("/remove/{id}")
	public void remove(Long id) {
		String msg = null;
		try{
			E bean = dao.findById(id);
			if (bean != null){
				dao.removeEntity(bean);
				msg = "Registro excluído com sucesso." ;
				result.include("mensagem", msg);
			}
		}catch(DAOException e){
			result.include("erro", e.getMessage());
		}
		result.forwardTo(this.getClass()).lista();
	  }

	public void form(E bean){
		initForm(bean);
		result.include("bean",bean);
	}
	
	@Path({"/{id}","/form","/novo"})
	public E form(Long id) throws DAOException{
		E bean = null;
		
		
		if (id != null){
			
			bean = dao.findById(id);
			
		}else{
			bean = createInstance();
		}
		
		initForm(bean);
		result.include("bean",bean);
		
		return bean;
	}
	@SuppressWarnings("unchecked")
	@Post
	public void add(E bean) {
		boolean isSucesso = false;
		prePersistUpdate(bean);
	 	validateForm(bean);
		Long id = (Long)EntityUtil.getId(bean.getClass(), bean);
		String msg = null;
		if (id != null && id > 0){
			if(update(bean)){
				msg = "Registro alterado com sucesso." ;
				isSucesso = true;
			} 
		}else{
			if(persist(bean)){
				msg = "Registro incluído com sucesso." ;
				isSucesso = true;
			}
		}
		if(isSucesso){
			postPersistUpdate(bean, result);
			result.include("mensagem", msg);
			result.forwardTo(this.getClass()).lista();
		}else{
			result.include("erro","Erro ao incluir registro.");
			result.forwardTo(this.getClass()).form(bean);;
		}
	  }
	
	
	public boolean persist(E bean){
		try {
			dao.addEntity(bean);
			return true;
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(E bean){
		try {
			dao.updateEntity(bean);
			return true;
		} catch (Exception e) {
			result.include("erro", "Erro ao alterar registro.");
			e.printStackTrace();
			return false;
		}
	}
	@Path({"/lista","/lista/"})
	public List<E> lista(){
		List<E> lista = null;
		
		try {
			lista = dao.findAll();
			E filter = createInstance();
			initFilter(filter);
			result.include("filter",filter);
			result.include("beanList",lista);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	@Path({"/filtrar"})
	public List<E> filtrar(E filter){
		List<E> lista = null;
		
		lista = dao.findByFilter(filter);
		initFilter(filter);
		result.include("beanList",lista);
		result.include("filter",filter);
		
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
