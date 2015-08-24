package br.com.eleitoralweb.dao.interfaces;

import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.exceptions.DAOException;

public interface UsuarioDAO extends BaseDAO<Usuario> {
	public Usuario login(String email, String senha) throws DAOException;
	public Usuario obterPorEmail(String email) throws DAOException;
	public boolean verificarAcesso(Usuario usuario) throws DAOException;
	public Usuario obterPorLoginESenha(String login, String senha) throws DAOException;

}
