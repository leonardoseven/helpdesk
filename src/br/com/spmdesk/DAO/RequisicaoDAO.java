package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Requisicao;

public class RequisicaoDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static String INSERTCOMPONENTE = "INSERT INTO tbrequisicao (assunto, descricao, setor, componente, solicitante) VALUES (?,?,?,?,?)";

	public void save(Requisicao requisicao) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(INSERTCOMPONENTE);
			stm.setString(1, requisicao.getAssunto());
			stm.setString(2, requisicao.getDescricao());
			stm.setString(3, requisicao.getSetor());
			stm.setString(4, requisicao.getComponente());
			stm.setString(5, requisicao.getSolicitante());
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

	private static String  SELECTCOMPONENTE = "SELECT * from tbcomponente";
	public ArrayList<String> getListComponente() {
		try {
		PreparedStatement stm = (PreparedStatement) con.prepareStatement(SELECTCOMPONENTE);
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
