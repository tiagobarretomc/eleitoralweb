package br.com.eleitoralweb.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.eleitoralweb.controller.commons.UserSession;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.manager.commons.UsuarioManager;


@Controller
@Path("/")
public class LoginController {
	@Inject
	private Result result;
	@Inject
	private UserSession userSession;
    @Inject
    private UsuarioManager usuarioManager;
    @Inject
    private Validator validator;
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
