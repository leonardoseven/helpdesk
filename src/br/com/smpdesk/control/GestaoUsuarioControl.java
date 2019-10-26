package br.com.smpdesk.control;

import java.util.ArrayList;

import br.com.spmdesk.DAO.GestaoUsuarioDAO;
import br.com.spmdesk.entity.Usuario;

public class GestaoUsuarioControl {
	
	GestaoUsuarioDAO gestaoDAO = new GestaoUsuarioDAO();
	
	public ArrayList<Usuario> getAllUsers(){
		ArrayList<Usuario> lista = gestaoDAO.getAllUsers();
		return lista;
	}
}
