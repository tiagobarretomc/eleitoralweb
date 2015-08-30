package br.com.eleitoralweb.controller;

import br.com.caelum.vraptor.*;
import br.com.eleitoralweb.controller.commons.*;
import br.com.eleitoralweb.dao.interfaces.*;
import br.com.eleitoralweb.entity.*;
import br.com.eleitoralweb.manager.commons.*;
import br.com.eleitoralweb.util.*;
import com.google.gson.*;

import java.util.*;

@Controller
@Path("/usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioDAO, UsuarioManager>{

	@Override
	protected Usuario createInstance() {
		return new Usuario();
	}
	@Post
	public void adicionar(Usuario bean, List<GrupoUsuario> grupos){
		bean.getGruposUsuario().clear();
		UsuarioGrupo usuarioGrupo = null;
		super.add(bean);
	}

	@Override
	protected void initForm(Usuario bean) {
		Gson gson = new Gson();
		List<GrupoUsuario> gruposDoUsuario = new ArrayList<GrupoUsuario>();
		for (UsuarioGrupo usuarioGrupo : bean.getGruposUsuario()) {
			gruposDoUsuario.add(usuarioGrupo.getGrupoUsuario());
		}
		String gruposDoUsuarioJson = gson.toJson(gruposDoUsuario);
		result.include("gruposDoUsuarioJson",gruposDoUsuarioJson);
		result.include("gruposDoUsuario",gruposDoUsuario);
		List<GrupoUsuario> gruposUsuarios = new ArrayList<GrupoUsuario>();
		for (UsuarioGrupo usuarioGrupo : bean.getGruposUsuario()) {
			if(!gruposDoUsuario.contains(usuarioGrupo.getGrupoUsuario())){
				gruposUsuarios.add(usuarioGrupo.getGrupoUsuario());
			}
		}
		result.include("gruposUsuarios",gruposUsuarios);
	}

	@Override
	protected void prePersistUpdate(Usuario bean) {
		if(bean.getId() == null){
			String senhaInicial = SecurityUtil.createDefaultPassword();
			bean.setSenhaInicial(senhaInicial);
			bean.setSenha(SecurityUtil.encriptyWord(senhaInicial));
		}
	}

	@Override
	protected void postPersistUpdate(Usuario bean, Result result) {
		
	}
	public static void main(String[] args) {
		System.out.println(SecurityUtil.encriptyWord("guerra08"));
	}
}
