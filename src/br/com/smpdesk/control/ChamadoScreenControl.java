package br.com.smpdesk.control;

import java.util.ArrayList;

import br.com.spmdesk.DAO.ChamadoDAO;
import br.com.spmdesk.entity.Chamado;

public class ChamadoScreenControl {

	ChamadoDAO chamadoDAO = new ChamadoDAO();
	
	public ArrayList<String> getListSetor() {
		return chamadoDAO.getListSetor();
	}
	
	public void save(Chamado chamado) {
		chamadoDAO.save(chamado);
	}
	
}
