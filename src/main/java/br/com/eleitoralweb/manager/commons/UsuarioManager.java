package br.com.eleitoralweb.manager.commons;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.interfaces.UsuarioDAO;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.exceptions.DAOException;

@Component
public class UsuarioManager extends BaseManager<Usuario, UsuarioDAO>{
	public Usuario obterPorLoginESenha(String login, String senha) throws BusinessException{
		try {
			return getDao().obterPorLoginESenha(login, senha);
		} catch (DAOException e) {
			throw new BusinessException("Usuário não encontrado");
		}
	}

}
