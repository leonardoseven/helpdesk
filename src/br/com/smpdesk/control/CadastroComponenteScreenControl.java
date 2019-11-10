package br.com.smpdesk.control;

import br.com.spmdesk.DAO.CadastroComponenteScreenDAO;
import br.com.spmdesk.entity.Componente;

public class CadastroComponenteScreenControl {

	CadastroComponenteScreenDAO cadastroComponenteScreenDAO = new CadastroComponenteScreenDAO();
	
	public void saveComponente(Componente componente) {
		cadastroComponenteScreenDAO.save(componente);
	}
	
}
