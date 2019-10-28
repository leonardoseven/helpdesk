package br.com.spmdesk.boundary;

import br.com.smpdesk.control.LoginControl;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlertScreen implements EventHandler<ActionEvent>, ChamarTela{
	private Stage stage;
	
	public AlertScreen(Stage stage) {
			chamarTela(stage);
			this.stage = stage;
	}
	Button btnVoltar = new Button("Voltar ao login");

	@Override
	public void chamarTela(Stage stage) {
		// TODO Auto-generated method stub
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane pane = new GridPane();
		border.setMinSize(400,100);
		pane.setMinSize(200, 75);
		border.setTop(Background.getBackground(400, 25));
		border.setCenter(gridpane);
		border.setLeft(pane);
		pane.setHgap(10);
		pane.setVgap(10);
		
		stage.addEventFilter(ActionEvent.ANY, this);
		Label lblAviso = new Label("Opa, ocorreu um erro de login!");
		Label lblMensagem = new Label("Verifique seu usuário e senha se estão corretos e "
				+ "volte a fazer login, caso o problema permaneça entre em contato com"
				+ "o setor de T.I .");
		
		pane.add(lblAviso,0,2);
		pane.add(lblMensagem,0,3);
		pane.add(btnVoltar,0,4);
		
		stage.setScene(scene);
		stage.setTitle("Ops, algo deu errado");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			new Login(stage);
		}
	}

}
