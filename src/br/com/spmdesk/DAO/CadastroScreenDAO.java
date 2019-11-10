package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Setor;

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

	private static String  SELECTSETOR = "SELECT * from tbsetor";
	public boolean getSetor() {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(SELECTSETOR);
			stm.execute();
			
			ResultSet rs = stm.getResultSet();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<String> getListSetor() {
		try {
		PreparedStatement stm = (PreparedStatement) con.prepareStatement(SELECTSETOR);
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		ArrayList<String> setores = new ArrayList<String>();
		while(rs.next()) {
			setores.add(rs.getString("nome"));
		}
			return setores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
