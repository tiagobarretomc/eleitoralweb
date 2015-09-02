package br.com.eleitoralweb.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.eleitoralweb.annotations.Public;
import br.com.eleitoralweb.controller.LoginController;
import br.com.eleitoralweb.controller.commons.UserSession;
import br.com.eleitoralweb.exceptions.PermissionDeniedException;

@Intercepts
@RequestScoped
public class ControleAcessoInterceptor implements Interceptor {
	@Inject HttpServletRequest request;
    @Inject Result result;
    @Inject UserSession userSession;
    @Inject Validator validator;

	@Override
	public boolean accepts(ControllerMethod arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ControllerMethod arg1,
			Object arg2) throws InterceptionException {
		if(arg1.getMethod().getDeclaredAnnotation(Public.class) != null || userSession.getUser() != null){
			stack.next(arg1, arg2);
		}else{
			throw new PermissionDeniedException();
		}
		
	}

}
