package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Chamado;
import br.com.spmdesk.entity.Requisicao;

public class GestaoCRDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private final static String SelectChamado = "select * from tbchamado";
	public ArrayList<Chamado> getAllChamado() {
		try {
		PreparedStatement stm = (PreparedStatement) con.prepareStatement(SelectChamado);
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		ArrayList<Chamado> chamados = new ArrayList<Chamado>();
		while(rs.next()) {
			Chamado c = new Chamado();
			c.setAssunto(rs.getString("assunto"));
			c.setDescricao(rs.getString("descricao"));
			c.setSetor(rs.getString("setor"));
			c.setSolicitante(rs.getString("solicitante"));
			chamados.add(c);
		}
			return chamados;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private final static String SelectRe = "select * from tbrequisicao";
	public ArrayList<Requisicao> getAllRequisicao() {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(SelectRe);
			stm.execute();
			
			ResultSet rs = stm.getResultSet();
			ArrayList<Requisicao> requisicoes = new ArrayList<Requisicao>();
			while(rs.next()) {
				Requisicao c = new Requisicao();
				c.setAssunto(rs.getString("assunto"));
				c.setDescricao(rs.getString("descricao"));
				c.setSetor(rs.getString("setor"));
				c.setSolicitante(rs.getString("solicitante"));
				requisicoes.add(c);
			}
				return requisicoes;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	
	
}
