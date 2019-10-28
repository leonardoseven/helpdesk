package br.com.spmdesk.boundary;

import java.util.ArrayList;

import br.com.smpdesk.control.GestaoUsuarioControl;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		Pane pane = new Pane();
		border.setMinSize(800, 600);
		pane.setMinSize(300, 600);
		
		
		gridpane.add(new Label("Usuários cadastrados"),0,0);
		
		ArrayList<Usuario> listaUsuario = gestaoControl.getAllUsers();
		for (int i = 0; i < listaUsuario.size(); i++) {
			gridpane.add(new Label(listaUsuario.get(i).getNome()), 0, i+1);
			gridpane.add(new Label(listaUsuario.get(i).getPass()), 1, i+1);
			gridpane.add(new Label(listaUsuario.get(i).getTipo()), 2, i+1);
		}
		
		gridpaneRigth.add(new Label("Ações"),0, 0);
		for (int i = 0; i < listaUsuario.size(); i++) {
			gridpaneRigth.add(new Button("Editar"),0, i+1);
			gridpaneRigth.add(new Button("Excluir"),1, i+1);
		}
		
		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);
		
		gridpane.setHgap(20);
		gridpane.setVgap(10);
		
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setLeft(pane);
		border.setCenter(gridpane);
		border.setRight(gridpaneRigth);

		stage.setScene(scene);
		stage.setTitle("Gestão de Usuários");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
