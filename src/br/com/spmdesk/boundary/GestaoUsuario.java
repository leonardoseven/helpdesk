package br.com.spmdesk.boundary;
 
import java.util.ArrayList;

import br.com.smpdesk.control.GestaoUsuarioControl;
import br.com.spmdesk.entity.Usuario;
import br.com.spmdesk.interfaces.ChamarTela;
import br.com.spmdesk.utils.Background;
import br.com.spmdesk.utils.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GestaoUsuario implements EventHandler<ActionEvent>, ChamarTela {
	private Stage stage;
	Usuario usuario = User.getUsuario();
	GestaoUsuarioControl gestaoControl = new GestaoUsuarioControl();
	
	ArrayList<Usuario> listaUsuario = gestaoControl.getAllUsers();

    private TableView<Usuario> table = new TableView<Usuario>();
    private final ObservableList<Usuario> data =
        FXCollections.observableArrayList(listaUsuario);
   
	public GestaoUsuario(Stage stage) {
		chamarTela(stage);
		this.stage = stage;
	}

	
	Button btnVoltar = new Button("Voltar");
	Button btnCadastro = new Button("Novo Usu�rio");
	Button btnIns = new Button("Cadastro desativado");
	
	@Override
	public void chamarTela(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		GridPane gridpane = new GridPane();
		GridPane gridpaneRigth = new GridPane();
		GridPane gridpaneLeft = new GridPane();
		FlowPane bottom = new FlowPane();

		border.setMinSize(800, 500);
		bottom.getChildren().add(btnVoltar);
		
		gridpane.add(new Label("Usu�rios cadastrados:"), 0, 0);
		
		Usuario usr = User.getUsuario();
		
		if("inspetor".equals(usr.getTipo())) {
			gridpane.add(btnIns, 0, 1);
		}
		else {
			gridpane.add(btnCadastro, 0, 1);
		}
//		
//		gridpane.add(new Label("nome"), 0, 2);
//		gridpane.add(new Label("senha"), 1, 2);
//		gridpane.add(new Label("tipo"), 2, 2);

		
		table.setItems(data);
		
	   TableColumn nome = new TableColumn("Nome");
	   nome.setMinWidth(100);
	   nome.setCellValueFactory(
       new PropertyValueFactory<Usuario, String>("nome"));
 
        TableColumn senha = new TableColumn("Senha");
        senha.setMinWidth(100);
        if("inspetor".equals(usuario.getTipo())) {
        	String ins = "Acesso negado";
        	senha.setCellValueFactory(new PropertyValueFactory<String, String>(ins));
		}else {
			senha.setCellValueFactory(
			new PropertyValueFactory<Usuario, String>("pass"));
		}
        TableColumn tipoUsr = new TableColumn("Tipo");
        tipoUsr.setMinWidth(100);
        tipoUsr.setCellValueFactory(
        new PropertyValueFactory<Usuario, String>("tipo"));
        
        table.getColumns().addAll(nome, senha, tipoUsr);
        table.setItems(data);
           
        table.setMinSize(100,200);
	    gridpane.add(table, 0, 0);

		gridpaneRigth.setHgap(5);
		gridpaneRigth.setVgap(5);
		gridpaneRigth.setMinSize(100, 100);
		gridpaneLeft.setMinSize(100,100);
		gridpane.setAlignment(Pos.CENTER);

		gridpane.setHgap(20);
		gridpane.setVgap(10);

		border.setTop(Background.getBackground(800, 100));
		border.setCenter(gridpane);
		border.setRight(gridpaneRigth);
		border.setLeft(gridpaneLeft);
		border.setBottom(bottom);

		stage.addEventFilter(ActionEvent.ANY, this);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Gest�o de Usu�rios");
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget().equals(btnVoltar)) {
				if ("inspetor".equals(usuario.getTipo())) {
					new MainScreenInspetor(stage);
				} else {
					new MainScreenAdmin(stage);
				}

		} else if (event.getTarget().equals(btnCadastro)) {
			new CadastroScreen(stage);
		}
		if (event.getTarget().equals(btnIns)) {
			String title = "Ops... Voc� n�o pode cadastrar usu�rios!";
			String subTitle = "Apenas administradores podem criar Cadastros!";
			new PopUpError(title, subTitle,"br.com.spmdesk.boundary.GestaoUsuario", stage);
		}

	}

}
