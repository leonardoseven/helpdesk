package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static final String VERIFICALOGIN = "SELECT * FROM teste";

	private static Connection con = DriverFactory.getConnection();

	public void teste() {
		try {

			PreparedStatement stm = (PreparedStatement) con.prepareStatement(VERIFICALOGIN);
			stm.execute();

			ResultSet rs = stm.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("nome"));
			}

			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
