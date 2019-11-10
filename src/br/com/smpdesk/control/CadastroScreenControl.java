package br.com.smpdesk.control;

import java.util.ArrayList;
import java.util.List;

import br.com.spmdesk.DAO.CadastroScreenDAO;
import br.com.spmdesk.entity.Setor;

public class CadastroScreenControl {

	CadastroScreenDAO cadastroDAO = new CadastroScreenDAO();
	
	public void insertUsuario(List<String> dados) {
		cadastroDAO.insertUsuario(dados);
	}
	
	public boolean possiuSetor() {
		return cadastroDAO.getSetor();
	}
	
	public ArrayList<String> getListSetor() {
		return cadastroDAO.getListSetor();
	}
	
}
