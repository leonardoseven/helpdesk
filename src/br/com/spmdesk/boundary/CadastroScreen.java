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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroScreen implements EventHandler<ActionEvent>, ChamarTela {

	private Stage stage;

	public CadastroScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}
	private CadastroScreenControl cadastroControl = new CadastroScreenControl();
	
	Label lblCadastro = new Label("Cadastro de usuário");
	Label lblNome = new Label("Insira o nome do funcionário");
	TextField txtNome = new TextField();
	Label lblUsuario = new Label("Insira o nome de usuário para o funcionário");
	TextField txtUsuario = new TextField();
	Label lblSenha = new Label("Insira uma senha para funcionário");
	TextField txtSenha = new TextField();
	Label lblRegistro = new Label("Insira o registro do funcionário");
	TextField txtRegistro = new TextField();
	Label lblTipoUser = new Label("Informe o tipo de usuário");
	Label lblSetor = new Label("Informe o Setor do funcionário");
	Button btnVoltar = new Button("Voltar");
	Button cadastrar = new Button("CADASTRAR");
	ObservableList<String> optionsSetor = FXCollections.observableArrayList("RH","TI", "Comercial");
	ComboBox tipoSetor = new ComboBox(optionsSetor);
	ObservableList<String> optionsUser = FXCollections.observableArrayList("admin","padrao", "inspetor");
	ComboBox tipoUser = new ComboBox(optionsUser);
	
	
	@Override
	public void chamarTela(Stage stage) {

		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		Pane pane = new Pane();
		FlowPane bottom = new FlowPane();
		
		bottom.getChildren().add(btnVoltar);
				
		border.setMinSize(800, 450);
		pane.setMinSize(280, 450);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setLeft(pane);
		border.setBottom(bottom);
		
		
		tipoUser.setMinWidth(250);
		tipoSetor.setMinWidth(250);
		
		
		cadastrar.setMinWidth(250);
		
		
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		
		gridpane.add(lblCadastro, 0, 2); //  column=0
		gridpane.add(lblNome, 0, 3); //  column=0
		gridpane.add(txtNome, 0, 4); //  column=0
		
		gridpane.add(lblUsuario, 0, 5); //  column=0
		gridpane.add(txtUsuario, 0, 6); //  column=0
		
		gridpane.add(lblSenha, 0, 7); //  column=0
		gridpane.add(txtSenha, 0, 8); // column=0
		
		gridpane.add(lblRegistro, 0, 9); //  column=0
		gridpane.add(txtRegistro, 0, 10); // column=0
		
		gridpane.add(lblTipoUser, 0, 11); //  column=0
		gridpane.add(tipoUser, 0, 12); //  column=0
		
		gridpane.add(lblSetor, 0, 13); // column=0
		gridpane.add(tipoSetor, 0, 14); // column=0

		gridpane.add(cadastrar, 0, 15); // column=0
	
		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Usuários");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnVoltar)) {
			new GestaoUsuario(stage);
		}else if(event.getTarget().equals(cadastrar)) {
			List<String> dados = getValues();
			cadastroControl.insertUsuario(dados);
			System.out.println("Sucesso");
		}

	}
	
	public List<String> getValues(){
		List<String> dados = new ArrayList<>();
		String nome = txtNome.getText();
		String usuario  = txtUsuario.getText();
		String senha =  txtSenha.getText();
		String registro = txtRegistro.getText();
		String tipoUsuario = tipoUser.getSelectionModel().getSelectedItem().toString();
		String tipoSetores = tipoSetor.getSelectionModel().getSelectedItem().toString();
		
		if(!nome.equals("") && !usuario.equals("") && !senha.equals("") && !registro.equals("") && !tipoUsuario.equals("") && !tipoSetores.equals("")) {
			dados.add(nome);
			dados.add(tipoUsuario);
			dados.add(senha);
			dados.add(usuario);
			dados.add(registro);
			dados.add(tipoSetores);
			return dados;
		}else {
			// Mostrar tela de erro
		}		
		return null;
	}

}
