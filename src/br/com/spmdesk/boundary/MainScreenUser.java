package br.com.spmdesk.boundary;

import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainScreenUser implements EventHandler<ActionEvent>, ChamarTela {
	
	private Stage stage;
	
	public MainScreenUser(Stage stage) {
		this.stage = stage;
		chamarTela(stage);
	}

	Button btnChamado = new Button("Abrir um chamado");
	Button btnRequisicao = new Button("Abrir uma requisição");
	
	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		GridPane gridPainel = new GridPane();
		
		
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridPainel);

		gridPainel.setMinSize(800, 500);
		
		gridPainel.setAlignment(Pos.CENTER);
		
		// Espaçamento dos elementos
		gridPainel.setVgap(25);
		gridPainel.setHgap(25);
		
		// Botões
		btnChamado.setMinSize(300, 50);
		btnRequisicao.setMinSize(300, 50);
		gridPainel.add(btnChamado, 0, 1);
		gridPainel.add(btnRequisicao, 1, 1);
		btnChamado.setStyle("-fx-font-size:20;");
		btnRequisicao.setStyle("-fx-font-size:20;");
		
		
		
		// Criação de cena e inicialização da mesma
		Scene scene = new Scene(border);
		
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Tela Inicial");
		stage.show();
	}

	@Override
	public void handle(ActionEvent e) {
		if(e.getTarget().equals(btnChamado)) {
			new ChamadoScreen(stage);
		}else if(e.getTarget().equals(btnRequisicao)) {
			new RequisicaoScreen(stage);
		}
		
	}
}
