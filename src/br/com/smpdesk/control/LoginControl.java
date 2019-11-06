package br.com.smpdesk.control;

import br.com.spmdesk.DAO.LoginDAO;
import br.com.spmdesk.entity.Usuario;

public class LoginControl {
	
	LoginDAO loginDAO = new LoginDAO();
	
	public Usuario verificaLogin(String user, String pass) {
		Usuario tipo = loginDAO.verificaLogin(user, pass);
		if(tipo != null) {
			return tipo;
		}
		return null;
	}
}
