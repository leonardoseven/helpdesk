package br.com.spmdesk.boundary;

import br.com.spmdesk.interfaces.ChamarTela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainScreenAdmin implements EventHandler<ActionEvent>, ChamarTela{
	private Stage stage;
	
	public MainScreenAdmin(Stage stage) {
			chamarTela(stage);
			this.stage = stage;
	}
	
	Button btnGerenciarUsuario = new Button("Gestão de Usuários");
	Button btnCadastro = new Button("Cadastrar usuário");
	Button btnGerenciarCR = new Button("Gestão de C/R");
	Button btnGerenciarEstoque = new Button("Gestão de Estoque");
	

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		BorderPane header = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		Pane pane = new Pane();
		
		border.setMinSize(800, 600);
		header.setMinSize(800, 100);
		pane.setMinSize(350, 600);
		border.setTop(header);
		header.setStyle("-fx-background-color:#1A1842");
		StackPane sp = new StackPane();
		Image img = new Image("/images/monke.png");
		ImageView imgView = new ImageView(img);
		sp.getChildren().add(imgView);
		header.setLeft(imgView);
		border.setCenter(gridpane);
		border.setLeft(pane);
		
		// Setando os Gaps do GridPane entre as colunas
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		btnGerenciarUsuario.setMinSize(120, 100);
		btnGerenciarCR.setMinSize(120, 100);
		btnGerenciarEstoque.setMinSize(120, 100);
		btnCadastro.setMinSize(120, 100);
		
		gridpane.add(btnGerenciarUsuario, 0, 3);
		gridpane.add(btnGerenciarCR, 0, 4);
		gridpane.add(btnGerenciarEstoque, 0, 5);
		gridpane.add(btnCadastro, 0, 6);
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
		}else if (event.getTarget().equals(btnCadastro)) {
			new CadastroScreen(stage);
		}
	}

}
