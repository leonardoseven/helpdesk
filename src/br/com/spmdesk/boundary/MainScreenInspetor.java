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

public class MainScreenInspetor implements EventHandler<ActionEvent>, ChamarTela {
	
	private Stage stage;
	
	public MainScreenInspetor(Stage stage) {
		this.stage = stage;
		chamarTela(stage);
	}

	Button btnChamado = new Button("Abrir um chamado");
	Button btnRequisicao = new Button("Abrir uma requisição");
	Button btnGerenciarUsuario = new Button("Gest�o de Usuários");
	Button btnGerenciarCR = new Button("Gestão de C/R");
	Button btnGerenciarEstoque = new Button("Gestão de Estoque");
	Button btnCadastrarSetor = new Button("Cadastrar Setor");
	
	
	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		GridPane gridPainel = new GridPane();
		
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridPainel);

		gridPainel.setMinSize(800, 500);
		
		gridPainel.setAlignment(Pos.CENTER);
		
		// Espa�amento dos elementos
		gridPainel.setVgap(10);
		gridPainel.setHgap(10);
		
		// Bot�es
		btnChamado.setMinSize(300, 50);
		btnRequisicao.setMinSize(300, 50);
		gridPainel.add(btnChamado, 0, 0);
		gridPainel.add(btnRequisicao, 0, 1);
		
		gridPainel.add(btnGerenciarUsuario, 0, 2);
		gridPainel.add(btnGerenciarCR, 1, 0);
		gridPainel.add(btnGerenciarEstoque, 1, 1);
		gridPainel.add(btnCadastrarSetor, 1, 2);
		
		btnChamado.setMinSize(300, 50);
		btnRequisicao.setMinSize(300, 50);
		btnGerenciarUsuario.setMinSize(300, 50);
		btnGerenciarCR.setMinSize(300, 50);
		btnGerenciarEstoque.setMinSize(300, 50);
		btnCadastrarSetor.setMinSize(300, 50);
		
		btnChamado.setStyle("-fx-font-size:20;");
		btnRequisicao.setStyle("-fx-font-size:20;");
		btnGerenciarUsuario.setStyle("-fx-font-size:20;");
		btnGerenciarCR.setStyle("-fx-font-size:20;");
		btnGerenciarEstoque.setStyle("-fx-font-size:20;");
		btnCadastrarSetor.setStyle("-fx-font-size:20;");
		
		
		// Cria��o de cena e inicializa��o da mesma
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
		}
		if(e.getTarget().equals(btnRequisicao)) {
			new RequisicaoScreen(stage);
		}if(e.getTarget().equals(btnGerenciarUsuario)) {
			new GestaoUsuario(stage);
		}
		if(e.getTarget().equals(btnGerenciarCR)){
			new GestaoCR(stage);
		}
		if(e.getTarget().equals(btnGerenciarEstoque)) {
			new GestaoEstoque(stage);
		}
		if(e.getTarget().equals(btnCadastrarSetor)) {
			new CadastroSetorScreen(stage);
		}
	}
}
