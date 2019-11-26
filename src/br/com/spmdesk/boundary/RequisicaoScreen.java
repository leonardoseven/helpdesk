package br.com.spmdesk.boundary;

import java.util.ArrayList;

import br.com.smpdesk.control.RequisicaoScreenControl;
import br.com.spmdesk.entity.Componente;
import br.com.spmdesk.entity.Requisicao;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import br.com.spmdesk.utils.DateUtils;
import br.com.spmdesk.utils.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RequisicaoScreen implements EventHandler<ActionEvent>, ChamarTela {

	private Stage stage;
	private RequisicaoScreenControl c = new RequisicaoScreenControl();
	
	public RequisicaoScreen(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	ObservableList<String> optionsSetor = FXCollections.observableArrayList(getList());
	ComboBox tipoSetor = new ComboBox(optionsSetor);

	ObservableList<String> optionscomponentes = FXCollections.observableArrayList(getListCom());
	ComboBox componentes = new ComboBox(optionscomponentes);

	TextField txtAssunto = new TextField();
	TextArea txtaDescricao = new TextArea();

	Button btnVoltar = new Button("Voltar");
	Button cadastrar = new Button("Solicitar");

	@Override
	public void chamarTela(Stage stage) {

		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		FlowPane bottom = new FlowPane();

		bottom.getChildren().add(btnVoltar);

		border.setMinSize(800, 500);
		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setBottom(bottom);

		cadastrar.setMinWidth(250);

		gridpane.setHgap(10);
		gridpane.setVgap(10);

		gridpane.setAlignment(Pos.CENTER);

		gridpane.add(new Label("Digite o assunto da requisição"), 0, 2);
		gridpane.add(txtAssunto, 0, 3);
		gridpane.add(new Label("Selecione o setor que vai receber essa requisição"), 0, 4);
		gridpane.add(tipoSetor, 0, 5);
		gridpane.add(new Label("Selecione o componente para essa requisição"), 0, 6);
		gridpane.add(componentes, 0, 7);
		gridpane.add(new Label("Digite a descrição do requisição"), 0, 8);
		gridpane.add(txtaDescricao, 0, 9);
		gridpane.add(cadastrar, 0, 11); // column=0

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Cadastro de Requisiçãso");
		stage.show();
	}

	public Requisicao boundaryToControl() {
		Usuario usuario = User.getUsuario();
		Requisicao requisicao = new Requisicao();
		Componente componente = new Componente();
		if(componentes.getSelectionModel().getSelectedItem().toString() != null && !"".equals(componentes.getSelectionModel().getSelectedItem().toString())) {
			componente.setNome(componentes.getSelectionModel().getSelectedItem().toString());
		}else {
			new PopUpError("Os campos não podem ser vazio", "Preencha todos os campos", "br.com.spmdesk.boundary.MainScreenUser", stage);
		}
		if(tipoSetor.getSelectionModel().getSelectedItem().toString() != null && !"".equals(tipoSetor.getSelectionModel().getSelectedItem().toString())) {
			requisicao.setSetor(tipoSetor.getSelectionModel().getSelectedItem().toString());
		}else {
			new PopUpError("Os campos não podem ser vazio", "Preencha todos os campos", "br.com.spmdesk.boundary.MainScreenUser", stage);
		}
		requisicao.setDataChamado(DateUtils.now());
		requisicao.setAssunto(txtAssunto.getText());
		requisicao.setDescricao(txtaDescricao.getText());
		requisicao.setComponente(componente.getNome());
		requisicao.setSolicitante(usuario.getNome());
		return requisicao;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget().equals(btnVoltar)) {
			Usuario usuario = User.getUsuario();
			if ("inspetor".equals(usuario.getTipo())) {
				new MainScreenInspetor(stage);
			} else {
				new MainScreenUser(stage);
			}

		} else if (event.getTarget().equals(cadastrar)) {
			c.save(boundaryToControl());
			new MainScreenUser(stage);
			
		}
	}
	
	private ArrayList<String> getList(){
		return c.getListSetor();
	}
	
	private ArrayList<String> getListCom(){
		return c.getListComponente();
	}
}
