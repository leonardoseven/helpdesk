package br.com.smpdesk.control;

import br.com.spmdesk.DAO.LoginDAO;

public class LoginControl {
	
	LoginDAO loginDAO = new LoginDAO();
	
	public String verificaLogin(String user, String pass) {
		String tipo = loginDAO.verificaLogin(user, pass);
		if(tipo != null) {
			return tipo;
		}
		return null;
	}
}
