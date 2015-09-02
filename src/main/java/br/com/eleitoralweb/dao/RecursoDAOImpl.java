package br.com.eleitoralweb.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.commons.BaseDAOJPA;
import br.com.eleitoralweb.dao.interfaces.RecursoDAO;
import br.com.eleitoralweb.entity.Recurso;
import br.com.eleitoralweb.entity.Usuario;

@Component
@ApplicationScoped
public class RecursoDAOImpl extends BaseDAOJPA<Recurso> implements RecursoDAO {

	private static RecursoDAOImpl instance = null;

	public static RecursoDAOImpl getInstance() {
		if (instance == null)
			instance = new RecursoDAOImpl();
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recurso> obterMenu(Usuario usuario) {
		String hql = "select distinct r from RecursoGrupo o inner join o.recurso r" +
					" where exists (select 1 from UsuarioGrupo where grupoUsuario = o.grupoUsuario " +
					" and usuario = :usuario) and r.menu = true and r.recursoPai is null";
		Query q = createEntityManager().createQuery(hql);
		q.setParameter("usuario", usuario);
		return q.getResultList();
	}

	
}
