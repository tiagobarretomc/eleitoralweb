package br.com.eleitoralweb.dao;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.stereotype.Component;

import br.com.eleitoralweb.dao.commons.BaseDAOJPA;
import br.com.eleitoralweb.dao.interfaces.CampanhaEleitoralDAO;
import br.com.eleitoralweb.entity.CampanhaEleitoral;

@Component
@ApplicationScoped
public class CampanhaEleitoralDAOImpl extends BaseDAOJPA<CampanhaEleitoral> implements CampanhaEleitoralDAO {

	private static CampanhaEleitoralDAOImpl instance = null;

	public static CampanhaEleitoralDAOImpl getInstance() {
		if (instance == null)
			instance = new CampanhaEleitoralDAOImpl();
		return instance;
	}
	public CampanhaEleitoral obterUltimaCampanha(){
		String hql = "select o from CampanhaEleitoral o order by id desc";
		
		return null;
	}

}
