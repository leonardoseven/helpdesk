package br.com.spmdesk.boundary;
 
import java.util.ArrayList;

import br.com.smpdesk.control.GestaoUsuarioControl;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GestaoUsuario implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;

	public GestaoUsuario(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	GestaoUsuarioControl gestaoControl = new GestaoUsuarioControl();
	Button btnVoltar = new Button("Voltar");
	Button btnCadastro = new Button("Novo Usuário");
	Button btnIns = new Button("Cadastro desativado");
	
	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		FlowPane bottom = new FlowPane();

		border.setMinSize(800, 500);
		bottom.getChildren().add(btnVoltar);
		
		gridpane.add(new Label("Usuários cadastrados:"), 0, 0);
		
		Usuario usr = User.getUsuario();
		
		if("inspetor".equals(usr.getTipo())) {
			gridpane.add(btnIns, 0, 1);
		}
		else {
			gridpane.add(btnCadastro, 0, 1);
		}
		
		gridpane.add(new Label("nome"), 0, 2);
		gridpane.add(new Label("senha"), 1, 2);
		gridpane.add(new Label("tipo"), 2, 2);

		ArrayList<Usuario> listaUsuario = gestaoControl.getAllUsers();
		//instancia de usuario
		
		
		for (int i = 0; i < listaUsuario.size(); i++) {
			
			Usuario usuario = User.getUsuario();
			gridpane.add(new Label(listaUsuario.get(i).getNome()), 0, i + 3);
			if("inspetor".equals(usuario.getTipo())) {
				gridpane.add(new Label("Acesso Negado"), 1, i + 3);
			}
			else {
				gridpane.add(new Label(listaUsuario.get(i).getPass()), 1, i + 3);
			}
			gridpane.add(new Label(listaUsuario.get(i).getTipo()), 2, i + 3);
		}

		gridpaneRigth.add(new Label("Ações"), 0, 0);
//		for (int i = 0; i < listaUsuario.size(); i++) {
//			gridpaneRigth.add(new Button("Editar"),0, i+3);
//			gridpaneRigth.add(new Button("Excluir"),1, i+3);
//		}

		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);

		gridpane.setAlignment(Pos.CENTER);

		gridpane.setHgap(20);
		gridpane.setVgap(10);

		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setRight(gridpaneRigth);
		border.setBottom(bottom);

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Gestão de Usuários");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget().equals(btnVoltar)) {
				Usuario usuario = User.getUsuario();
				if ("inspetor".equals(usuario.getTipo())) {
					new MainScreenInspetor(stage);
				} else {
					new MainScreenAdmin(stage);
				}

		} else if (event.getTarget().equals(btnCadastro)) {
			new CadastroScreen(stage);
		}
		if (event.getTarget().equals(btnIns)) {
			String title = "Ops... Você não pode cadastrar usuários!";
			String subTitle = "Apenas administradores podem criar Cadastros!";
			new PopUpError(title, subTitle,"br.com.spmdesk.boundary.GestaoUsuario", stage);
		}

	}

}
