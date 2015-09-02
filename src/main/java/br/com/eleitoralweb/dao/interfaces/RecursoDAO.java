package br.com.eleitoralweb.dao.interfaces;

import java.util.List;

import br.com.eleitoralweb.entity.Recurso;
import br.com.eleitoralweb.entity.Usuario;

public interface RecursoDAO extends BaseDAO<Recurso> {
	public List<Recurso> obterMenu(Usuario usuario);
}
