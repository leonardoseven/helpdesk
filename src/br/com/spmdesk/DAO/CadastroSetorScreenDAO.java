package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Setor;

public class CadastroSetorScreenDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static String INSERTUSER = "INSERT INTO tbsetor (nome, nome_gestor) VALUES (?,?)";

	public void save(Setor setor) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(INSERTUSER);
			stm.setString(1, setor.getNomeSetor());
			stm.setString(2, setor.getGestor().getNomeSetor());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
