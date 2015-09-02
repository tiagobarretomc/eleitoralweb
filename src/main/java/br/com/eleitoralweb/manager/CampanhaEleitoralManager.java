package br.com.eleitoralweb.manager;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.interfaces.CampanhaEleitoralDAO;
import br.com.eleitoralweb.entity.CampanhaEleitoral;
import br.com.eleitoralweb.manager.commons.BaseManager;

@Component
public class CampanhaEleitoralManager extends BaseManager<CampanhaEleitoral, CampanhaEleitoralDAO> {
	public CampanhaEleitoral obterUltimaCampanha(){
		return null;
	}
	

}
