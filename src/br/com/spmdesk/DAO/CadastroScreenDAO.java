package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class CadastroScreenDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static String INSERTUSER = "INSERT INTO tbuser (nome, tipo, pass, usuario, registro, setor) VALUES (?,?,?,?,?,?)";

	public void insertUsuario(List<String> dados) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(INSERTUSER);
			for(int i = 0; i < dados.size(); i++) {
				stm.setString(i+1, dados.get(i));
			}
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
