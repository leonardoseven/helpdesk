package br.com.spmdesk.boundary;

import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CadastroScreen implements EventHandler<ActionEvent>, ChamarTela {

	private Stage stage;

	public CadastroScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	@Override
	public void chamarTela(Stage stage) {
		// TODO Auto-generated method stub

		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		Pane pane = new Pane();
				
		border.setMinSize(800, 600);
		pane.setMinSize(280, 600);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setLeft(pane);
		
		Label lblCadastro = new Label("Cadastro de usuário");
		
		Label lblNome = new Label("Insira o nome do funcionário");
		TextField txtNome = new TextField();
		
		Label lblUsuario = new Label("Insira o nome de usuário para o funcionário");
		TextField txtUsuario = new TextField();
		
		Label lblSenha = new Label("Insira uma senha para funcionário");
		TextField txtSenha = new TextField();
		
		Label lblRegistro = new Label("Insira o registro do funcionário");
		TextField txtRegistro = new TextField();
		
		Label lblTipoUser = new Label("Informe o tipo de usuário");
		ComboBox tipoUser = new ComboBox();
		tipoUser.setMinWidth(250);
		
		Label lblSetor = new Label("Informe o Setor do funcionário");
		ComboBox tipoSetor = new ComboBox();
		tipoSetor.setMinWidth(250);
		
		Button cadastrar = new Button("CADASTRAR");
		cadastrar.setMinWidth(250);
		
		
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		
		gridpane.add(lblCadastro, 0, 2); //  column=0
		gridpane.add(lblNome, 0, 3); //  column=0
		gridpane.add(txtNome, 0, 4); //  column=0
		
		gridpane.add(lblUsuario, 0, 5); //  column=0
		gridpane.add(txtUsuario, 0, 6); //  column=0
		
		gridpane.add(lblSenha, 0, 7); //  column=0
		gridpane.add(txtSenha, 0, 8); // column=0
		
		gridpane.add(lblRegistro, 0, 9); //  column=0
		gridpane.add(txtRegistro, 0, 10); // column=0
		
		gridpane.add(lblTipoUser, 0, 11); //  column=0
		gridpane.add(tipoUser, 0, 12); //  column=0
		
		gridpane.add(lblSetor, 0, 13); // column=0
		gridpane.add(tipoSetor, 0, 14); // column=0

		gridpane.add(cadastrar, 0, 15); // column=0
	
		stage.setScene(scene);
		stage.setTitle("Cadastro de Usuários");
		stage.show();

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
