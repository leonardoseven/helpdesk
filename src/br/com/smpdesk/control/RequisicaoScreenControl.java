package br.com.smpdesk.control;

import java.util.ArrayList;

import br.com.spmdesk.DAO.RequisicaoDAO;
import br.com.spmdesk.entity.Requisicao;

public class RequisicaoScreenControl {

	RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
	
	public ArrayList<String> getListSetor() {
		return requisicaoDAO.getListSetor();
	}
	
	public void save(Requisicao requisicao) {
		requisicaoDAO.save(requisicao);
	}

	public ArrayList<String> getListComponente() {
		return requisicaoDAO.getListComponente();
	}
	
}
