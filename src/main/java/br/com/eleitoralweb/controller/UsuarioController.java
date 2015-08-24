package br.com.eleitoralweb.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.eleitoralweb.controller.commons.BaseController;
import br.com.eleitoralweb.dao.interfaces.UsuarioDAO;
import br.com.eleitoralweb.entity.GrupoUsuario;
import br.com.eleitoralweb.entity.Usuario;
import br.com.eleitoralweb.entity.UsuarioGrupo;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.manager.commons.UsuarioManager;
import br.com.eleitoralweb.util.SecurityUtil;

import com.google.gson.Gson;

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
