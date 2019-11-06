package br.com.spmdesk.boundary;

import java.util.ArrayList;
import java.util.List;

import br.com.smpdesk.control.CadastroScreenControl;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChamadoScreen implements EventHandler<ActionEvent>, ChamarTela {


	private Stage stage;

	public ChamadoScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	
	ObservableList<String> optionsSetor = FXCollections.observableArrayList("RH","TI", "Comercial");
	ComboBox tipoSetor = new ComboBox(optionsSetor);
	
	TextField txtAssunto = new TextField();
	TextArea txtaDescricao = new TextArea();
	
	Button btnVoltar = new Button("Voltar");
	Button cadastrar = new Button("Solicitar");
	
	@Override
	public void chamarTela(Stage stage) {

		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		Pane pane = new Pane();
		FlowPane bottom = new FlowPane();
		
		bottom.getChildren().add(btnVoltar);
				
		border.setMinSize(800, 450);
		pane.setMinSize(150,1);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setLeft(pane);
		border.setBottom(bottom);		
		
		cadastrar.setMinWidth(250);
		
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		

		gridpane.add(new Label("Digite o assunto do chamado"), 0, 2);
		gridpane.add(txtAssunto, 0, 3);
		gridpane.add(new Label("Selecione o setor que vai receber esse chamado"),0, 4);
		gridpane.add(tipoSetor, 0, 5);
		gridpane.add(new Label("Digite a descrição do chamado"), 0, 6);
		gridpane.add(txtaDescricao, 0, 7);
		gridpane.add(cadastrar, 0, 9); // column=0
	
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Chamado");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			new MainScreenUser(stage);
		}else if(event.getTarget().equals(cadastrar)) {
			
		}

	}

}
