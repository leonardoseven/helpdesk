package br.com.spmdesk.boundary;

import java.util.ArrayList;

import br.com.smpdesk.control.GestaoUsuarioControl;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
		GridPane grid = new GridPane();
		Scene scene = new Scene(border);
		
		border.setTop(new Label("Usuários cadastrados"));
		
		
		ArrayList<Usuario> listaUsuario = gestaoControl.getAllUsers();
		for(int i = 0; i< listaUsuario.size(); i++) {
			grid.add(new Label(listaUsuario.get(i).getNome()), 0, i);
			grid.add(new Label(listaUsuario.get(i).getPass()), 1, i);
			grid.add(new Label(listaUsuario.get(i).getTipo()), 2, i);
		}
		grid.setHgap(20);
		grid.setVgap(10);
		border.setCenter(grid);
		
		
		
		stage.setScene(scene);
		stage.setTitle("Gestão de Usuários");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
