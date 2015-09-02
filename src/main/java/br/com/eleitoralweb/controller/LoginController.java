package br.com.eleitoralweb.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.eleitoralweb.annotations.Public;
import br.com.eleitoralweb.controller.commons.UserSession;
import br.com.eleitoralweb.entity.Recurso;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.manager.RecursoManager;
import br.com.eleitoralweb.manager.UsuarioManager;


@Controller
@Path("/")
public class LoginController {
	@Inject
	private Result result;
	private UserSession userSession;
    @Inject
    private UsuarioManager usuarioManager;
    @Inject
    private RecursoManager recursoManager;
    @Inject
    private Validator validator;

    public LoginController(){
    }

    @Inject
    public LoginController(UserSession userSession) {
        this();
        this.userSession = userSession;
    }

    @Get("/")
    @Public
    public void login() {
    	userSession.setUser(null);
    	userSession.setMenuItens(null);
    }

    @Post("/autenticar")
    @Public
    public void autenticar(String login, String senha){
        Usuario user = usuarioManager.obterPorLoginESenha(login, senha);
        if (user != null) {
            userSession.setUser(user);
            userSession.setMenuItens(recursoManager.obterMenu(user));
            result.redirectTo(MainController.class).main();
        } else {
        	 validator.add(new SimpleMessage("login",
        		        "Usuário/senha inválido")).onErrorRedirectTo(LoginController.class).login();
        }
    }

    @Get("/logout")
    public void logout() {
        userSession.logout();
        result.redirectTo(this).login();
    }

}
