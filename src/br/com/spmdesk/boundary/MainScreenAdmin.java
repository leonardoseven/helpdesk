package br.com.spmdesk.boundary;

import br.com.spmdesk.interfaces.ChamarTela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainScreenAdmin implements EventHandler<ActionEvent>, ChamarTela{
	private Stage stage;
	
	public MainScreenAdmin(Stage stage) {
			chamarTela(stage);
			this.stage = stage;
	}
	
	Button btnGerenciarUsuario = new Button("Gestão de Usuários");
	Button btnGerenciarCR = new Button("Gestão de CR");
	Button btnGerenciarEstoque = new Button("Gestão de Estoque");
	

	@Override
	public void chamarTela(Stage stage) {
		GridPane grid  = new GridPane();
		Scene scene =  new Scene(grid);
		
		grid.setStyle("-fx-background-color:#f8f4f3;");
		
		// Redimencionando o tamanho minimo do GridPane
		grid.setMinSize(300, 300);

		// Setando os Gaps do GridPane entre as colunas
		grid.setVgap(10);
		grid.setHgap(5);
		
		grid.add(btnGerenciarUsuario, 0, 3);
		grid.add(btnGerenciarCR, 2, 3);
		grid.add(btnGerenciarEstoque, 4, 3);
		
		stage.addEventFilter(ActionEvent.ANY, this);
		
		stage.setScene(scene);
		stage.setTitle("Menu admin");
		stage.show();
		
	}


	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnGerenciarUsuario)) {
			new GestaoUsuario(stage);
		}else if(event.getTarget().equals(btnGerenciarCR)){
			System.out.println("ola");
		}else if(event.getTarget().equals(btnGerenciarEstoque)) {
			System.out.println("hello");
		}
	}

}
