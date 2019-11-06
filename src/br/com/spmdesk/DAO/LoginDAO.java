package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.spmdesk.entity.Usuario;

public class LoginDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	// query para verificar o login e retorna qual o tipo do usuario
	private static final String VERIFICALOGIN = "SELECT id, tipo, nome, resgistro, setor FROM tbuser where nome = ? and pass = ?";
	public Usuario verificaLogin(String user, String pass) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(VERIFICALOGIN);
			stm.setString(1, user);
			stm.setString(2, pass);
			stm.execute();

			Usuario usuario = new Usuario();
			ResultSet rs = stm.getResultSet();
			while (rs.next()) {
				usuario.setTipo( rs.getString("tipo"));
				usuario.setNome( rs.getString("nome"));
				usuario.setRegistro( rs.getString("registro"));
				usuario.setNomeSetor( rs.getString("setor"));
				usuario.setId( rs.getInt("id"));
			}
			stm.close();
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
