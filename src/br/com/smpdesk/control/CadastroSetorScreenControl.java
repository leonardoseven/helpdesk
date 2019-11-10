package br.com.smpdesk.control;

import br.com.spmdesk.DAO.CadastroSetorScreenDAO;
import br.com.spmdesk.entity.Setor;

public class CadastroSetorScreenControl {

	CadastroSetorScreenDAO cadastroSetorScreenDAO = new CadastroSetorScreenDAO();
	
	public void saveSetor(Setor setor) {
		cadastroSetorScreenDAO.save(setor);
	}
	
}
