package br.com.smpdesk.control;

import java.sql.Connection;
import java.util.List;

import br.com.spmdesk.DAO.CadastroScreenDAO;
import br.com.spmdesk.DAO.DriverFactory;

public class CadastroScreenControl {

	CadastroScreenDAO cadastroDAO = new CadastroScreenDAO();
	
	public void insertUsuario(List<String> dados) {
		cadastroDAO.insertUsuario(dados);
	}
	
}
