package br.com.eleitoralweb.controller.commons;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.entity.Usuario;

@Component
@SessionScoped
public class UserSession implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7335609776581390861L;
	private Usuario user;

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


}