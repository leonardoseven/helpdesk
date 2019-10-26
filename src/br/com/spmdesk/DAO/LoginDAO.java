package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	// query para verificar o login e retorna qual o tipo do usuario
	private static final String VERIFICALOGIN = "SELECT tipo FROM tbuser where nome = ? and pass = ?";
	public String verificaLogin(String user, String pass) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(VERIFICALOGIN);
			stm.setString(1, user);
			stm.setString(2, pass);
			stm.execute();

			String tipo = null;
			ResultSet rs = stm.getResultSet();
			while (rs.next()) {
				tipo = rs.getString("tipo");
			}
			stm.close();
			return tipo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
