package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static final String VERIFICALOGIN = "SELECT tipo FROM tbuser";

	private static Connection con = DriverFactory.getConnection();

	public String verificaLogin(String user, String pass) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(VERIFICALOGIN);
			stm.execute();

			String tipo = null;
			ResultSet rs = stm.getResultSet();
			while (rs.next()) {
				tipo = rs.getString("tipo");
			}
			stm.close();
			con.close();
			
			return tipo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
