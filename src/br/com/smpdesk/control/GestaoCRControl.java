package br.com.smpdesk.control;

import java.util.ArrayList;

import br.com.spmdesk.DAO.GestaoCRDAO;
import br.com.spmdesk.entity.Chamado;
import br.com.spmdesk.entity.Requisicao;

public class GestaoCRControl {

	
	GestaoCRDAO gestaoDAO = new GestaoCRDAO();
	
	public ArrayList<Chamado> getAllChamado(){
		return gestaoDAO.getAllChamado();
	}
	
	public ArrayList<Requisicao> getAllRequisicao(){
		return gestaoDAO.getAllRequisicao();
	}
	
}
