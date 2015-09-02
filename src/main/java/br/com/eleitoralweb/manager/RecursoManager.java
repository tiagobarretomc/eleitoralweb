package br.com.eleitoralweb.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.interfaces.RecursoDAO;
import br.com.eleitoralweb.entity.Recurso;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.manager.commons.BaseManager;

@Component
public class RecursoManager extends BaseManager<Recurso, RecursoDAO> {
	public List<Recurso> obterMenu(Usuario usuario) throws BusinessException{
		return getDao().obterMenu(usuario);
	}


}
