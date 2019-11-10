package br.com.spmdesk.boundary;

import br.com.smpdesk.control.LoginControl;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import br.com.spmdesk.utils.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;
	
	public Login(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	
	
	// Label de usu�rio e senha
	Label lblUser = new Label("Digite o seu Usuário");
	Label lblPass = new Label("Digite a sua Senha");

	// Area de recebimento de dados
	TextField txtUser = new TextField();
	PasswordField txtPass = new PasswordField();

	// Bot�o para realiza��o de login
	Button btnLogin = new Button("Login");
	
	@Override
	public void chamarTela(Stage stage) {
		// Cria��o  da GridPanel e customiza��o
		BorderPane border = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color:#f8f4f3;");
		
		// Redimencionando o tamanho minimo do GridPane
		border.setMinSize(800, 500);

		// Setando os Gaps do GridPane entre as colunas
		gridPane.setVgap(10);
		gridPane.setHgap(5);

		// Alinhamento do Grid
		gridPane.setAlignment(Pos.CENTER);

		gridPane.setStyle("-fx-font-size: 20px");
		
		//Adicionando todos os elementos criado a interface e os colocando no lugar desejado
		gridPane.add(lblUser, 1, 0);
		gridPane.add(txtUser, 1, 1);
		gridPane.add(lblPass, 1, 2);
		gridPane.add(txtPass, 1, 3);
		gridPane.add(btnLogin, 1,4);
		
		border.setCenter(gridPane);
		border.setTop(Background.getBackground(800, 100));
		
		Scene scene = new Scene(border);
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
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
			Usuario usuario = login.verificaLogin(user, pass);
			User.setUsuario(usuario);
			if("admin".equals(usuario.getTipo())) {
				new MainScreenAdmin(stage);
			}else if("padrao".equals(usuario.getTipo())) {
				new MainScreenUser(stage);
			}else if("inspetor".equals(usuario.getTipo())) {
				new MainScreenInspetor(stage);
			}
			else {
				String title = "Opa, ocorreu um erro ao logar";
				String subTitle = "Verifique seu usuário e senha se estão corretos";
			
				new PopUpError(title, subTitle,"br.com.spmdesk.boundary.Login", stage);
			}
		}
	}
}
