package br.com.spmdesk.boundary;

import br.com.smpdesk.control.CadastroScreenControl;
import br.com.smpdesk.control.CadastroSetorScreenControl;
import br.com.spmdesk.entity.Setor;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroSetorScreen implements EventHandler<ActionEvent>, ChamarTela {

	private Stage stage;

	public CadastroSetorScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	private CadastroSetorScreenControl cadastroSetorControl = new CadastroSetorScreenControl();
	
	Label lblCadastro = new Label("Cadastro de Setor");
	Label lblNome = new Label("Insira o nome do Setor");
	TextField txtNome = new TextField();
	Label lblUsuario = new Label("Insira o nome do responsael pelo  setor");
	TextField txtUsuario = new TextField();
	Button btnVoltar = new Button("Voltar");
	Button cadastrar = new Button("Cadastrar");
	
	@Override
	public void chamarTela(Stage stage) {

		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		FlowPane bottom = new FlowPane();
		
		bottom.getChildren().add(btnVoltar);
				
		border.setMinSize(800, 500);
		//border.setMaxSize(800, 500);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setBottom(bottom);
		
		cadastrar.setMinWidth(250);
		
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		gridpane.setAlignment(Pos.CENTER);
		
		gridpane.add(lblCadastro, 0, 2); //  column=0
		gridpane.add(lblNome, 0, 3); //  column=0
		gridpane.add(txtNome, 0, 4); //  column=0
		
		gridpane.add(lblUsuario, 0, 5); //  column=0
		gridpane.add(txtUsuario, 0, 6); //  column=0
		
		gridpane.add(cadastrar, 0, 8); // column=0
	
		gridpane.setStyle("-fx-font-size: 15px;");
		
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Setor");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			new GestaoUsuario(stage);
		}else if(event.getTarget().equals(cadastrar)) {
			Setor setor = getSetor();
			if(setor == null) {
				new PopUpError("Os campos não podem ser vazio", "Preencha todos os campos", "br.com.spmdesk.boundary.MainScreenAdmin", stage);
			}else {
				cadastroSetorControl.saveSetor(setor);
				new MainScreenAdmin(stage);
			}
			
		}

	}
	
	public Setor getSetor(){
		Setor setor = new Setor();
		Usuario usuario = new Usuario();
		if( !"".equals(txtUsuario.getText()) && txtUsuario.getText() != null  && !"".equals(txtNome.getText()) && txtNome.getText() != null) {
			usuario.setNomeSetor(txtUsuario.getText());
			setor.setNomeSetor(txtNome.getText());
			setor.setGestor(usuario);
			return setor;
		}
		return null;
		
	}

}
