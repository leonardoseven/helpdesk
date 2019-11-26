package br.com.spmdesk.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.spmdesk.entity.Componente;
import br.com.spmdesk.entity.Usuario;

public class GestaoComponenteDAO {
	private static Connection con = (Connection) DriverFactory.getInstance();
	
	private static final String PEGARTODOSCOMPONENTES = "Select * from tbcomponente";
	public ArrayList<Componente> getAllComponentes(){
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(PEGARTODOSCOMPONENTES);
			stm.execute();
			
			ArrayList<Componente> listaComp = new ArrayList<>();
			ResultSet rs = stm.getResultSet();
			while(rs.next()) {
				Componente componente = new Componente();
				componente.setNome(rs.getString("nome"));
				componente.setPreco(rs.getDouble("preco"));
				componente.setDescricao(rs.getString("descricao"));
				componente.setQtdPeca(rs.getInt("qtdPeca"));
				listaComp.add(componente);
			}
			
			stm.close();
			
			return listaComp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
