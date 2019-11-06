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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GestaoEstoque implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;

	public GestaoEstoque(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}


	Button btnVoltar = new Button("Voltar");
	Button btnCadastro = new Button("Novo Usu�rio");

	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		FlowPane bottom = new FlowPane();
		
		Pane pane = new Pane();
		border.setMinSize(500, 500);
		pane.setMinSize(250, 500);
		bottom.getChildren().add(btnVoltar);
		
		gridpane.add(new Label("Usu�rios Estoque:"),0,0);
		
		gridpane.add(new Label("Nome do componente"),0,1);
		gridpane.add(new Label("Setor responsavel"),1,1);
		gridpane.add(new Label("Quantidade minima permitida"),2,1);
		gridpane.add(new Label("Quantidade atual"),3,1);
		
		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);
		
		gridpane.setHgap(20);
		gridpane.setVgap(10);
		
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setLeft(pane);
		border.setRight(gridpaneRigth);
		border.setBottom(bottom);

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setScene(scene);
		stage.setTitle("Gest�o de Estoque");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			new MainScreenAdmin(stage);
		}else if(event.getTarget().equals(btnCadastro)) {
			new CadastroScreen(stage);
		}

	}

}
