package br.com.eleitoralweb.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.*;
import br.com.eleitoralweb.controller.commons.*;
import br.com.eleitoralweb.entity.*;
import br.com.eleitoralweb.manager.*;

import javax.inject.*;


@Controller
@Path("/")
public class LoginController {
	@Inject
	private Result result;
	private UserSession userSession;
    @Inject
    private UsuarioManager usuarioManager;
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
    public void login() {

    }

    @Post("/autenticar")
    public void autenticar(String login, String senha){
        Usuario user = usuarioManager.obterPorLoginESenha(login, senha);
        if (user != null) {
            userSession.setUser(user);
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
