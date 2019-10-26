package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Usuario;

public class GestaoUsuarioDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static final String PEGARTODOSUSUARIOS = "Select * from tbuser";
	public ArrayList<Usuario> getAllUsers(){
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(PEGARTODOSUSUARIOS);
			stm.execute();
			
			ArrayList<Usuario> listaUsuario = new ArrayList<>();
			ResultSet rs = stm.getResultSet();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setPass(rs.getString("pass"));
				usuario.setTipo(rs.getString("tipo"));
				listaUsuario.add(usuario);
			}
			
			stm.close();
			
			return listaUsuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
