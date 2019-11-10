package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Componente;
import br.com.spmdesk.entity.Setor;

public class CadastroComponenteScreenDAO {

	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static String INSERTCOMPONENTE = "INSERT INTO tbcomponente (nome, descricao, preco, quantidade) VALUES (?,?,?,?)";

	public void save(Componente componente) {
		try {
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(INSERTCOMPONENTE);
			stm.setString(1, componente.getNome());
			stm.setString(2, componente.getDescricao());
			stm.setDouble(3, componente.getPreco());
			stm.setInt(4, componente.getQtdPeca());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
