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

public class MainScreenAdmin implements EventHandler<ActionEvent>, ChamarTela{
	private Stage stage;
	
	public MainScreenAdmin(Stage stage) {
			chamarTela(stage);
			this.stage = stage;
	}
	
	Button btnGerenciarUsuario = new Button("Gest�o de Usu�rios");
	Button btnGerenciarCR = new Button("Gest�o de C/R");
	Button btnGerenciarEstoque = new Button("Gest�o de Estoque");
	Button btnCadastrarSetor = new Button("Cadastrar Setor");
	Button btnCadastrarComponente = new Button("Cadastrar Componente");
	

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
		
		btnGerenciarUsuario.setPrefSize(250, 50);
		btnGerenciarCR.setPrefSize(250, 50);
		btnGerenciarEstoque.setPrefSize(250, 50);
		btnCadastrarSetor.setPrefSize(250, 50);
		btnCadastrarComponente.setPrefSize(250, 50);
		
		gridpane.add(btnGerenciarUsuario, 0, 0);
		gridpane.add(btnGerenciarCR, 1, 0);
		gridpane.add(btnGerenciarEstoque, 2, 0);
		gridpane.add(btnCadastrarSetor, 0, 1);
		gridpane.add(btnCadastrarComponente, 1, 1);
		
		
		stage.addEventFilter(ActionEvent.ANY, this);
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
		}else if(event.getTarget().equals(btnCadastrarSetor)) {
			new CadastroSetorScreen(stage);
		}else if(event.getTarget().equals(btnCadastrarComponente)) {
			new CadastroComponenteScreen(stage);
		}
	}

}
