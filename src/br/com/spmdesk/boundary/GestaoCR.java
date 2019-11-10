package br.com.spmdesk.boundary;
 
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GestaoCR implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;

	public GestaoCR(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	Button btnVoltar = new Button("Voltar");

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		FlowPane bottom = new FlowPane();
		
		border.setMinSize(800, 500);
		bottom.getChildren().add(btnVoltar);
		
		gridpane.add(new Label("Requisitos e chamados ativos:"),0,0);
		gridpane.add(new Label("Tipo (chamado ou requisi��o)"),0,1);
		gridpane.add(new Label("Solicitante"),1,1);
		gridpane.add(new Label("Descri��o "),2,1);
		gridpane.add(new Label("Setor"),3,1);
		
		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);
		
		gridpane.setHgap(20);
		gridpane.setVgap(10);
		
		gridpane.setAlignment(Pos.CENTER);
		
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setRight(gridpaneRigth);
		border.setBottom(bottom);

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Gest�o de CR");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			Usuario usuario = User.getUsuario();
			if("inspetor".equals(usuario.getTipo())) {
				new MainScreenInspetor(stage);
			}
			else {
				new MainScreenAdmin(stage);
			}
		}
	}

}
