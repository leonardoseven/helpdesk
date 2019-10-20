package br.com.spmdesk.main;

import br.com.spmdesk.view.Login;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartSPM extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new Login(stage);
	}

}
