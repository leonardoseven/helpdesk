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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainScreenAdmin implements EventHandler<ActionEvent>, ChamarTela{
	private Stage stage;
	
	public MainScreenAdmin(Stage stage) {
			chamarTela(stage);
			this.stage = stage;
	}
	
	Button btnGerenciarUsuario = new Button("Gestão de Usuários");
	Button btnGerenciarCR = new Button("Gestão de C/R");
	Button btnGerenciarEstoque = new Button("Gestão de Estoque");
	

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		
		border.setMinSize(800, 500);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		
		gridpane.setAlignment(Pos.CENTER);
		
		// Setando os Gaps do GridPane entre as colunas
		gridpane.setVgap(10);
		gridpane.setHgap(10);
//		btnGerenciarUsuario.setMinSize(120, 100);
//		btnGerenciarCR.setMinSize(120, 100);
//		btnGerenciarEstoque.setMinSize(120, 100);
		
		gridpane.add(btnGerenciarUsuario, 0, 0);
		gridpane.add(btnGerenciarCR, 1, 0);
		gridpane.add(btnGerenciarEstoque, 2, 0);
		
		gridpane.setStyle("-fx-font-size: 25px;");
		
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Menu admin");
		stage.show();
		
	}


	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnGerenciarUsuario)) {
			new GestaoUsuario(stage);
		}else if(event.getTarget().equals(btnGerenciarCR)){
			new GestaoCR(stage);
		}else if(event.getTarget().equals(btnGerenciarEstoque)) {
			new GestaoEstoque(stage);
		}
	}

}
