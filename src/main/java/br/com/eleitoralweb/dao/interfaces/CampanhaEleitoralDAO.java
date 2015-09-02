package br.com.eleitoralweb.dao.interfaces;

import br.com.eleitoralweb.entity.CampanhaEleitoral;

public interface CampanhaEleitoralDAO extends BaseDAO<CampanhaEleitoral> {
	public CampanhaEleitoral obterUltimaCampanha();

}
