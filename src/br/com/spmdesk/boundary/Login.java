package br.com.spmdesk.boundary;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.smpdesk.control.LoginControl;
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

public class Login implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;
	
	public Login(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	
	
	// Label de usuário e senha
	Label lblUser = new Label("Digite o seu Usuário");
	Label lblPass = new Label("Digite a sua Senha");

	// Area de recebimento de dados
	TextField txtUser = new TextField();
	PasswordField txtPass = new PasswordField();

	// Botão para realização de login
	Button btnLogin = new Button("Login");
	
	@Override
	public void chamarTela(Stage stage) {
		// Criação  da GridPanel e customização
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color:#f8f4f3;");
		
		// Redimencionando o tamanho minimo do GridPane
		gridPane.setMinSize(300, 300);

		// Setando os Gaps do GridPane entre as colunas
		gridPane.setVgap(10);
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
		
		stage.addEventFilter(ActionEvent.ANY, this);
		
		Scene scene = new Scene(gridPane);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		LoginControl login = new LoginControl();
		if(event.getTarget().equals(btnLogin)) {
			String user = txtUser.getText();
			String pass = txtPass.getText();
			String path = login.verificaLogin(user, pass);
			if("admin".equals(path)) {
				new MainScreenAdmin(stage);
			}else if("padrao".equals(path)) {
				new MainScreenUser(stage);
			}else if("inspetor".equals(path)) {
			}
			else {
				new AlertScreen(stage);
			}
		}
	}
}
