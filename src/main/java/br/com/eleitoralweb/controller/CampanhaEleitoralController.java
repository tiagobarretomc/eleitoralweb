package br.com.eleitoralweb.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.eleitoralweb.controller.commons.BaseController;
import br.com.eleitoralweb.dao.interfaces.CampanhaEleitoralDAO;
import br.com.eleitoralweb.dao.interfaces.ComboDAO;
import br.com.eleitoralweb.entity.CampanhaEleitoral;
import br.com.eleitoralweb.entity.Estado;
import br.com.eleitoralweb.exceptions.BusinessException;
import br.com.eleitoralweb.exceptions.DAOException;
import br.com.eleitoralweb.manager.CampanhaEleitoralManager;

import com.google.gson.Gson;

@Controller
@Path("/campanhaEleitoral")
public class CampanhaEleitoralController extends BaseController<CampanhaEleitoral, CampanhaEleitoralDAO, CampanhaEleitoralManager>{
	@Inject ComboDAO comboDao;
	@Override
	protected CampanhaEleitoral createInstance() {
		return new CampanhaEleitoral();
	}

	@Override
	protected void initForm(CampanhaEleitoral bean) {
		carregarEstadoCombo();
	}
	
	private void carregarEstadoCombo(){
		try {
			Gson gson = new Gson();
			String json = gson.toJson(comboDao.retrieveCombo(Estado.class, "id", "nome"));
			result.include("estadoList", json);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}
	private void carregarCidadeCombo(CampanhaEleitoral bean){
	}

	@Override
	protected void prePersistUpdate(CampanhaEleitoral bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postPersistUpdate(CampanhaEleitoral bean, Result result) {
		// TODO Auto-generated method stub
		
	}
	
    @Path(value = "/form", priority = Path.HIGH)
    @Override
	public CampanhaEleitoral form(Long id) throws BusinessException {
		return super.form(id);
	}

}
