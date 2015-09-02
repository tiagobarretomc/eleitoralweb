package br.com.eleitoralweb.controller.commons;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.eleitoralweb.entity.Recurso;
import br.com.eleitoralweb.entity.Usuario;

@Named
@SessionScoped
public class UserSession implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7335609776581390861L;
	private Usuario user;
	private List<Recurso> menuItens;

	public UserSession() {
	}

	public boolean isLogged() {
        return getUser() != null;
    }

    public void logout() {
        setUser(null);
    }

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Recurso> getMenuItens() {
		return menuItens;
	}

	public void setMenuItens(List<Recurso> menuItens) {
		this.menuItens = menuItens;
	}


}