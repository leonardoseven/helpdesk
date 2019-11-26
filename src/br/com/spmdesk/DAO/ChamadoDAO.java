package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Chamado;

public class ChamadoDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static String INSERTCOMPONENTE = "INSERT INTO tbchamado (assunto, descricao, setor, solicitante) VALUES (?,?,?,?)";

	public void save(Chamado chamado) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(INSERTCOMPONENTE);
			stm.setString(1, chamado.getAssunto());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getSetor());
			stm.setString(4, chamado.getSolicitante());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String  SELECTSETOR = "SELECT * from tbsetor";
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
