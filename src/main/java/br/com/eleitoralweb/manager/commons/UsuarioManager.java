package br.com.eleitoralweb.manager;

import br.com.eleitoralweb.dao.interfaces.*;
import br.com.eleitoralweb.entity.*;
import br.com.eleitoralweb.exceptions.*;
import br.com.eleitoralweb.manager.commons.*;
import org.springframework.stereotype.*;

@Component
public class UsuarioManager extends BaseManager<Usuario, UsuarioDAO> {
	public Usuario obterPorLoginESenha(String login, String senha) throws BusinessException{
		try {
			return getDao().obterPorLoginESenha(login, senha);
		} catch (DAOException e) {
			throw new BusinessException("Usuário não encontrado");
		}
	}


}
