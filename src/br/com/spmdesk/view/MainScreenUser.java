package br.com.spmdesk.view;

import br.com.spmdesk.interfaces.ChamarTela;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainScreenUser implements ChamarTela {
	public MainScreenUser(Stage stage) {
		chamarTela(stage);
	}

	@Override
	public void chamarTela(Stage stage) {
		// TODO Auto-generated method stub
		// Area dos botões do usuário
		Button btnChamado = new Button("Abrir um chamado");
		Button btnRequisicao = new Button("Abrir uma requisição");

		// Criação do painel e customização
		GridPane gridPainel = new GridPane();
		gridPainel.setMinSize(500, 250);
		
		// Espaçamento dos elementos
		gridPainel.setVgap(25);
		gridPainel.setHgap(25);
		
		// Botões
		btnChamado.setMinSize(200, 200);
		btnRequisicao.setMinSize(200, 200);
		gridPainel.add(btnChamado, 1, 1);
		gridPainel.add(btnRequisicao, 3, 1);
		btnChamado.setStyle("-fx-font-size:20;");
		btnRequisicao.setStyle("-fx-font-size:20;");
		
		// Criação de cena e inicialização da mesma
		Scene scene = new Scene(gridPainel);
		stage.setScene(scene);
		stage.setTitle("Tela Inicial");
		stage.show();
	}

	@Override
	public void retirardaquipqcoloqueisopracommitar() {
		// TODO Auto-generated method stub
		
	}
}
