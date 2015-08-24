package br.com.eleitoralweb.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.commons.BaseDAOJPA;
import br.com.eleitoralweb.dao.interfaces.UsuarioDAO;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.exceptions.DAOException;
import br.com.eleitoralweb.util.SecurityUtil;

@Component
@ApplicationScoped
public class UsuarioDAOImpl extends BaseDAOJPA<Usuario> implements UsuarioDAO{
	
	private static UsuarioDAOImpl instance = null;
	public  static UsuarioDAOImpl getInstance(){
		if (instance == null)
			instance = new UsuarioDAOImpl(); 
		return instance;
	}
	public Usuario login(String email, String senha) throws DAOException {
		List<Usuario> l = findByCriteria(Restrictions.ilike("login", email),Restrictions.ilike("senha", senha));
		if(!l.isEmpty()){
			return l.get(0);
		}
		return null;
	}
	public Usuario obterPorEmail(String email) throws DAOException {
		List<Usuario> l = findByCriteria(Restrictions.ilike("email", email));
		if(!l.isEmpty()){
			return l.get(0);
		}
		return null;
	}
	public Usuario obterPorLoginESenha(String login, String senha) throws DAOException {
		String senhaCriptografada = SecurityUtil.encriptyWord(senha);
		return findSingleByCriteria(Restrictions.eq("login", login), Restrictions.eq("senha", senhaCriptografada));
	}
	@Override
	public boolean verificarAcesso(Usuario usuario)
			throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	 
	 
}
