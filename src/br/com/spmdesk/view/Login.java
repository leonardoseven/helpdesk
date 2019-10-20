package br.com.spmdesk.view;

import br.com.spmdesk.DAO.LoginDAO;
import br.com.spmdesk.interfaces.ChamarTela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login implements ChamarTela {

	public Login(Stage stage) {
		chamarTela(stage);
	}

	@Override
	public void chamarTela(Stage stage) {
		// TODO Auto-generated method stub

		// Label de usu�rio e senha
		Label lblUser = new Label("Digite o seu Usu�rio");
		Label lblPass = new Label("Digite a sua Senha");

		// Area de recebimento de dados
		TextField txtUser = new TextField();
		PasswordField txtPass = new PasswordField();

		// Bot�o para realiza��o de login
		Button btnLogin = new Button("Login");

		// Cria��o  da GridPanel e customiza��o
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color:#f8f4f3;");
		
		// Redimencionando o tamanho minimo do GridPane
		gridPane.setMinSize(300, 300);
		
		LoginDAO mat = new LoginDAO();
		mat.teste();

		// Setando os Gaps do GridPane entre as colunas
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		// Alinhamento do Grid
		gridPane.setAlignment(Pos.CENTER);

		//Adicionando todos os elementos criado a interface e os colocando no lugar desejado
		
		btnLogin.setMinWidth(150);
		gridPane.add(lblUser, 1, 0);
		gridPane.add(txtUser, 1, 1);
		gridPane.add(lblPass, 1, 2);
		gridPane.add(txtPass, 1, 3);
		gridPane.add(btnLogin, 1,4);
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				new MainScreenUser(stage);
			}
		});
		
		Scene scene = new Scene(gridPane);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}
}
