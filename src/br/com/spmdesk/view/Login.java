package br.com.spmdesk.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login {
	
	public Login(Stage stage) {
		screen(stage);
	}
	
	private void screen(Stage stage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.setTitle("teste");
		stage.show();
	}
}
