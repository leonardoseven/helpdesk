package br.com.spmdesk.boundary;

import br.com.smpdesk.control.CadastroComponenteScreenControl;
import br.com.spmdesk.entity.Componente;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroComponenteScreen implements EventHandler<ActionEvent>, ChamarTela {

	private Stage stage;

	public CadastroComponenteScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	private CadastroComponenteScreenControl cadastroComponenteScreenControl = new CadastroComponenteScreenControl();
	
	Label lblCadastro = new Label("Cadastro de Componente");
	Label lblNome = new Label("Insira o nome do Componente");
	TextField txtNome = new TextField();
	Label lblpreco = new Label("Insira o preco do componente");
	TextField txtpreco = new TextField();
	Label lblqtd = new Label("Insira a quantidade desse componente no estoque");
	TextField txtqtd= new TextField();
	Label lblDescricao = new Label("Insira a descricao desse componente");
	TextArea txtADescricao = new TextArea();
	
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
		txtADescricao.setMaxHeight(100);
		
		gridpane.setHgap(10);
		gridpane.setVgap(5);
		
		gridpane.setAlignment(Pos.CENTER);
		
		gridpane.add(lblCadastro, 0, 2); //  column=0
		gridpane.add(lblNome, 0, 3); //  column=0
		gridpane.add(txtNome, 0, 4); //  column=0
		
		gridpane.add(lblpreco, 0, 5); //  column=0
		gridpane.add(txtpreco, 0, 6); //  column=0
		
		gridpane.add(lblqtd, 0, 7); //  column=0
		gridpane.add(txtqtd, 0, 8); //  column=0
		
		gridpane.add(lblDescricao, 0, 9); //  column=0
		gridpane.add(txtADescricao, 0, 10); //  column=0
		
		gridpane.add(cadastrar, 0, 11); // column=0
	
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
			new MainScreenAdmin(stage);
		}else if(event.getTarget().equals(cadastrar)) {
			Componente componente = getComponente();
			if(componente == null) {
				new PopUpError("Os campos não podem ser vazio", "Preencha todos os campos", "br.com.spmdesk.boundary.MainScreenAdmin", stage);
			}else {
				cadastroComponenteScreenControl.saveComponente(componente);
				new MainScreenAdmin(stage);
			}
			
		}

	}
	
	public Componente getComponente(){
		Componente componente = new Componente();
		if(!"".equals(txtNome.getText()) && txtNome.getText() != null && !"".equals(txtpreco.getText()) && txtpreco.getText() != null && !"".equals(txtqtd.getText()) && txtqtd.getText() != null && !"".equals(txtADescricao.getText()) && txtADescricao.getText() != null) {
			componente.setNome(txtNome.getText());
			componente.setDescrição(txtADescricao.getText());
			componente.setPreco(Double.valueOf(txtpreco.getText()));
			componente.setQtdPeca(Integer.valueOf(txtqtd.getText()));
			return componente;
			
		}
		return null;
	}

}
