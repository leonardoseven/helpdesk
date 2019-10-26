package br.com.spmdesk.boundary;

import java.util.ArrayList;

import br.com.smpdesk.control.GestaoUsuarioControl;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
		
		gridpane.add(new Label("Usuários cadastrados"),0,0);
		
		ArrayList<Usuario> listaUsuario = gestaoControl.getAllUsers();
		for (int i = 0; i < listaUsuario.size(); i++) {
			gridpane.add(new Label(listaUsuario.get(i).getNome()), 0, i);
			gridpane.add(new Label(listaUsuario.get(i).getPass()), 1, i);
			gridpane.add(new Label(listaUsuario.get(i).getTipo()), 2, i);
		}
		gridpane.setHgap(20);
		gridpane.setVgap(10);
		border.setCenter(gridpane);

		stage.setScene(scene);
		stage.setTitle("Gestão de Usuários");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
